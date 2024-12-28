package com.github.wilwe21.celeste.block.custom;

import com.github.wilwe21.celeste.block.types.BlockTypes;
import net.minecraft.block.BlockState;
import net.minecraft.block.entity.BlockEntity;
import net.minecraft.util.math.BlockPos;

public class DreamBlockEntity extends BlockEntity {
    public DreamBlockEntity(BlockPos pos, BlockState state) {
        super(BlockTypes.DREAM_BLOCK, pos, state);
    }
}
