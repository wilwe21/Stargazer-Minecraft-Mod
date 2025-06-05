package com.github.wilwe21.stargazer.block.clases.moon.leaves;

import com.mojang.serialization.MapCodec;
import net.minecraft.block.BlockState;
import net.minecraft.block.LeavesBlock;
import net.minecraft.util.math.BlockPos;
import net.minecraft.util.math.Direction;
import net.minecraft.util.math.random.Random;
import net.minecraft.world.BlockRenderView;
import net.minecraft.world.World;
import org.jetbrains.annotations.Nullable;

public class MoonLeaves extends LeavesBlock {
    public MoonLeaves(Settings settings) {
        super(1.0F, settings);
    }

    @Override
    public BlockState getAppearance(BlockState state, BlockRenderView renderView, BlockPos pos, Direction side, @Nullable BlockState sourceState, @Nullable BlockPos sourcePos) {
        return super.getAppearance(state, renderView, pos, side, sourceState, sourcePos);
    }

    @Override
    public MapCodec<? extends LeavesBlock> getCodec() {
        return null;
    }

    @Override
    protected void spawnLeafParticle(World world, BlockPos pos, Random random) {

    }
}
