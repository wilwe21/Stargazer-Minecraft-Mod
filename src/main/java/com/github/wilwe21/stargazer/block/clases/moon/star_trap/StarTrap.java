package com.github.wilwe21.stargazer.block.clases.moon.star_trap;

import com.github.wilwe21.stargazer.mechanics.DamageTypeRegistry;
import com.mojang.serialization.MapCodec;
import net.minecraft.block.Block;
import net.minecraft.block.BlockState;
import net.minecraft.block.BlockWithEntity;
import net.minecraft.block.ShapeContext;
import net.minecraft.block.entity.BlockEntity;
import net.minecraft.entity.Entity;
import net.minecraft.entity.EntityCollisionHandler;
import net.minecraft.entity.LivingEntity;
import net.minecraft.entity.damage.DamageSource;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.registry.RegistryKeys;
import net.minecraft.server.world.ServerWorld;
import net.minecraft.state.StateManager;
import net.minecraft.state.property.BooleanProperty;
import net.minecraft.util.ActionResult;
import net.minecraft.util.hit.BlockHitResult;
import net.minecraft.util.math.BlockPos;
import net.minecraft.util.shape.VoxelShape;
import net.minecraft.util.shape.VoxelShapes;
import net.minecraft.world.BlockView;
import net.minecraft.world.World;

public class StarTrap extends BlockWithEntity {
    public static final BooleanProperty ACTIVE = BooleanProperty.of("active");
    @Override
    protected MapCodec<? extends StarTrap> getCodec() {
        return createCodec(StarTrap::new);
    }

    @Override
    protected ActionResult onUse(BlockState state, World world, BlockPos pos, PlayerEntity player, BlockHitResult hit) {
        if (!player.getAbilities().allowModifyWorld || pos.equals(player.getBlockPos())) {
            return ActionResult.PASS;
        }
        if (state.get(ACTIVE)) {
            world.setBlockState(pos, state.with(ACTIVE, false));
            BlockEntity be = world.getBlockEntity(pos);
            if (be instanceof StarTrapEntity ste) {
                ste.setActive(false);
            }
            return ActionResult.SUCCESS;
        }
        return ActionResult.PASS;
    }

    @Override
    protected VoxelShape getOutlineShape(BlockState state, BlockView world, BlockPos pos, ShapeContext context) {
        return VoxelShapes.cuboid(0.1, 0.0, 0.1, 0.9, 0.15, 0.9);
    }

    @Override
    protected void onEntityCollision(BlockState state, World world, BlockPos pos, Entity entity, EntityCollisionHandler handler) {
        if (entity instanceof PlayerEntity pe) {
            if (!pe.getAbilities().allowModifyWorld) {
                return;
            }
        }
        if (!state.get(ACTIVE) && entity instanceof LivingEntity le) {
            world.setBlockState(pos, state.with(ACTIVE, true));
            BlockEntity be = world.getBlockEntity(pos);
            if (be instanceof StarTrapEntity ste) {
                ste.setActive(true);
            }
            if (world instanceof ServerWorld sw) {
                DamageSource damageSource = new DamageSource(
                        world.getRegistryManager()
                                .getOrThrow(RegistryKeys.DAMAGE_TYPE)
                                .getEntry(DamageTypeRegistry.STAR_TRAP.getValue()).get()
                );
                le.damage(sw, damageSource, 6.0f);
            }
        }
    }

    @Override
    public BlockEntity createBlockEntity(BlockPos pos, BlockState state) {
        return new StarTrapEntity(pos, state);
    }

    public StarTrap(Settings settings) {
        super(settings.replaceable());
        this.setDefaultState(this.getDefaultState().with(ACTIVE, false));
    }

    @Override
    protected void appendProperties(StateManager.Builder<Block, BlockState> builder) {
        builder.add(ACTIVE);
    }

}
