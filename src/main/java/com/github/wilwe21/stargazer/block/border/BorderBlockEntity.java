package com.github.wilwe21.stargazer.block.border;

import com.github.wilwe21.stargazer.block.BlockTypes;
import net.minecraft.block.BlockState;
import net.minecraft.block.entity.BlockEntity;
import net.minecraft.util.math.BlockPos;

public class BorderBlockEntity extends BlockEntity {
    public BorderBlockEntity(BlockPos pos, BlockState state) {
        super(BlockTypes.BORDER_BLOCK, pos, state);
    }
}
