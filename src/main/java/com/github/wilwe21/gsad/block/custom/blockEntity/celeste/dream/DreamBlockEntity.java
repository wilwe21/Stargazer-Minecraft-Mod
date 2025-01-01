package com.github.wilwe21.gsad.block.custom.blockEntity.celeste.dream;

import com.github.wilwe21.gsad.block.BlockTypes;
import net.minecraft.block.BlockState;
import net.minecraft.block.entity.BlockEntity;
import net.minecraft.util.math.BlockPos;

public class DreamBlockEntity extends BlockEntity {
    public DreamBlockEntity(BlockPos pos, BlockState state) {
        super(BlockTypes.DREAM_BLOCK, pos, state);
    }
}
