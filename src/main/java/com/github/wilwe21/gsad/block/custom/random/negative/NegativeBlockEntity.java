package com.github.wilwe21.gsad.block.custom.random.negative;

import com.github.wilwe21.gsad.block.BlockTypes;
import net.minecraft.block.BlockState;
import net.minecraft.block.entity.BlockEntity;
import net.minecraft.util.math.BlockPos;

public class NegativeBlockEntity extends BlockEntity {
    public NegativeBlockEntity(BlockPos pos, BlockState state) {
        super(BlockTypes.NEGATIVE_BLOCK, pos, state);
    }
}
