package com.github.wilwe21.stargazer.block.clases.star.cosmic;

import com.github.wilwe21.stargazer.Stargazer;
import com.github.wilwe21.stargazer.particle.Particles;
import com.mojang.serialization.MapCodec;
import net.minecraft.block.*;
import net.minecraft.block.entity.BlockEntity;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.item.ItemPlacementContext;
import net.minecraft.particle.SimpleParticleType;
import net.minecraft.registry.Registries;
import net.minecraft.sound.SoundCategory;
import net.minecraft.util.Identifier;
import net.minecraft.util.math.BlockPos;
import net.minecraft.util.shape.VoxelShape;
import net.minecraft.util.shape.VoxelShapes;
import net.minecraft.world.BlockView;
import net.minecraft.world.World;

import java.nio.channels.ScatteringByteChannel;
import java.util.Random;

public class CosmicBlock extends BlockWithEntity {
    private final static Random random = new Random();
    private final static float velocity = 0.06F;
    public static final Identifier TEXTURE = Identifier.of(Stargazer.MOD_ID, "textures/block/dream_block.png");
    @Override
    protected MapCodec<? extends CosmicBlock> getCodec() {
        return createCodec(CosmicBlock::new);
    }

    @Override
    public BlockEntity createBlockEntity(BlockPos pos, BlockState state) {
        return new CosmicBlockEntity(pos, state);
    }


    @Override
    public VoxelShape getOutlineShape(BlockState state, BlockView view, BlockPos pos, ShapeContext context) {
        if (context.isHolding(Registries.ITEM.get(Identifier.of(Stargazer.MOD_ID, "cosmic_block")))) {
            return VoxelShapes.fullCube();
        } else {
            return VoxelShapes.cuboid(0.0, 0.0, 0.0, 0.01, 0.01, 0.01);
        }
    }

    @Override
    protected VoxelShape getCollisionShape(BlockState state, BlockView world, BlockPos pos, ShapeContext context) {
        return VoxelShapes.empty();
    }

    @Override
    public BlockState onBreak(World world, BlockPos pos, BlockState state, PlayerEntity player) {
        for (int i = 1; i <= 5; i++) {
            world.addParticleClient((SimpleParticleType) Particles.STAR, true, true, pos.getX() + 0.5, pos.getY() + 0.5, pos.getZ() + 0.5, -velocity + random.nextFloat(velocity*2), -velocity + random.nextFloat(velocity*2), -velocity + random.nextFloat(velocity *2));
        }
        world.playSoundAtBlockCenterClient(pos, this.soundGroup.getBreakSound(), SoundCategory.BLOCKS, this.soundGroup.volume*2, this.soundGroup.pitch, true);
        return state;
    }


    public CosmicBlock(Settings settings) {
        super(settings);
    }

    @Override
    protected boolean canReplace(BlockState state, ItemPlacementContext context) {
        return (context.getStack().isEmpty() || !context.getStack().isOf(this.asItem()));
    }

    @Override
    public boolean canMobSpawnInside(BlockState state) {
        return true;
    }
}
