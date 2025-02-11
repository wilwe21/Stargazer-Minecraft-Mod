package com.github.wilwe21.stargazer.block.clases.cosmic;

import com.github.wilwe21.stargazer.particle.Particles;
import com.github.wilwe21.stargazer.sound.SoundEffects;
import com.mojang.serialization.MapCodec;
import net.minecraft.block.BlockRenderType;
import net.minecraft.block.BlockState;
import net.minecraft.block.BlockWithEntity;
import net.minecraft.block.ShapeContext;
import net.minecraft.block.entity.BlockEntity;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.particle.SimpleParticleType;
import net.minecraft.sound.SoundCategory;
import net.minecraft.util.math.BlockPos;
import net.minecraft.util.shape.VoxelShape;
import net.minecraft.util.shape.VoxelShapes;
import net.minecraft.world.BlockView;
import net.minecraft.world.World;

import java.util.Random;

public class CosmicBlock extends BlockWithEntity {
    public static boolean SOLID = false;
    private final static Random random = new Random();
    private final static float velocity = 0.06F;
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
        if (SOLID) {
            return VoxelShapes.fullCube();
        } else {
            return VoxelShapes.empty();
        }
    }

    @Override
    public BlockState onBreak(World world, BlockPos pos, BlockState state, PlayerEntity player) {
        for (int i = 1; i <= 5; i++) {
            world.addParticle((SimpleParticleType) Particles.STAR, true, true, pos.getX() + 0.5, pos.getY() + 0.5, pos.getZ() + 0.5, -velocity + random.nextFloat(velocity*2), -velocity + random.nextFloat(velocity*2), -velocity + random.nextFloat(velocity *2));
            world.playSoundAtBlockCenter(pos, this.soundGroup.getBreakSound(), SoundCategory.BLOCKS, this.soundGroup.volume/2, this.soundGroup.pitch, true);
        }
        return state;
    }


    public CosmicBlock(Settings settings) {
        super(settings.replaceable());
    }

    @Override
    protected BlockRenderType getRenderType(BlockState state) {
        return BlockRenderType.INVISIBLE;
    }
}
