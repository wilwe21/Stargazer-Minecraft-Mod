package com.github.wilwe21.gsad.block.custom.blockEntity.Mario.brick;

import com.github.wilwe21.gsad.block.BlockTypes;
import net.minecraft.block.BlockState;
import net.minecraft.block.entity.BlockEntity;
import net.minecraft.util.math.BlockPos;

public class BrickEntity extends BlockEntity {
    public BrickEntity(BlockPos pos, BlockState state) {
        super(BlockTypes.BRICK, pos, state);
    }
}
