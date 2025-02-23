package com.github.wilwe21.stargazer.block.clases.barrier;

import com.github.wilwe21.stargazer.block.BlockTypes;
import net.minecraft.block.BlockState;
import net.minecraft.block.entity.BlockEntity;
import net.minecraft.util.math.BlockPos;

public class StarBarrierBlockEntity extends BlockEntity {
    public StarBarrierBlockEntity(BlockPos pos, BlockState state) {
        super(BlockTypes.STAR_BARRIER_BLOCK, pos, state);
    }
}
