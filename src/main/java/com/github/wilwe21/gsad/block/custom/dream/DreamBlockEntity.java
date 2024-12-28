package com.github.wilwe21.gsad.block.custom.dream;

import com.github.wilwe21.gsad.block.types.BlockTypes;
import net.minecraft.block.BlockState;
import net.minecraft.block.entity.BlockEntity;
import net.minecraft.util.math.BlockPos;
import net.minecraft.util.math.Direction;

public class DreamBlockEntity extends BlockEntity {
    public DreamBlockEntity(BlockPos pos, BlockState state) {
        super(BlockTypes.DREAM_BLOCK, pos, state);
    }
}
