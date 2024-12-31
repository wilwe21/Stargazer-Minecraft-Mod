package com.github.wilwe21.gsad.block.custom.blockEntity.Mario.lucky;

import com.github.wilwe21.gsad.block.types.BlockTypes;
import net.minecraft.block.BlockState;
import net.minecraft.block.entity.BlockEntity;
import net.minecraft.util.math.BlockPos;

public class LuckyBlockEntity extends BlockEntity {
    public LuckyBlockEntity(BlockPos pos, BlockState state) {
        super(BlockTypes.LUCKY_BLOCK, pos, state);
    }
}
