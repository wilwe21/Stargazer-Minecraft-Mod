package com.github.wilwe21.celeste.block.custom;

import net.minecraft.block.AbstractBlock;
import net.minecraft.block.Block;
import net.minecraft.block.BlockState;
import net.minecraft.block.ShapeContext;
import net.minecraft.entity.Entity;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.sound.SoundCategory;
import net.minecraft.sound.SoundEvents;
import net.minecraft.state.StateManager;
import net.minecraft.state.property.BooleanProperty;
import net.minecraft.util.ActionResult;
import net.minecraft.util.hit.BlockHitResult;
import net.minecraft.util.math.BlockPos;
import net.minecraft.util.shape.VoxelShape;
import net.minecraft.util.shape.VoxelShapes;
import net.minecraft.world.BlockView;
import net.minecraft.world.World;

public class Spring extends Block{
    public static final BooleanProperty ACTIVATED = BooleanProperty.of("activated");

    @Override
    protected void appendProperties(StateManager.Builder<Block, BlockState> builder) {
        builder.add(ACTIVATED);
    }

    public Spring(AbstractBlock.Settings settings) {
        super(settings);

        setDefaultState(getDefaultState().with(ACTIVATED, false));
    }

    @Override
    protected ActionResult onUse(BlockState state, World world, BlockPos pos, PlayerEntity player, BlockHitResult hit) {
        if (!player.getAbilities().allowModifyWorld) {
            return ActionResult.PASS;
        } else {
            boolean active = state.get(ACTIVATED);

            if (active) {
                world.setBlockState(pos, state.with(ACTIVATED, !active));
            }

            return ActionResult.SUCCESS;
        }
    }

    @Override
    public void onEntityCollision(BlockState state, World world, BlockPos pos, Entity entity) {
        boolean active = state.get(ACTIVATED);
        if (!active) {
            world.setBlockState(pos, state.with(ACTIVATED, !active));
            entity.setVelocity(entity.getVelocity().x, 1.3, entity.getVelocity().z);
            world.playSound(entity, pos, SoundEvents.ENTITY_SLIME_JUMP_SMALL, SoundCategory.BLOCKS, 1.0F, 1.0F);
        }
    }

    @Override
    public VoxelShape getOutlineShape(BlockState state, BlockView view, BlockPos pos, ShapeContext context) {
        if (!state.get(ACTIVATED)) {
            return VoxelShapes.cuboid(0.1f, 0f, 0.1f, 0.9f, 0.15f, 0.9f);
        } else {
            return VoxelShapes.cuboid(0.1f, 0f, 0.1f, 0.9f, 0.5f, 0.9f);
        }
    }
}
