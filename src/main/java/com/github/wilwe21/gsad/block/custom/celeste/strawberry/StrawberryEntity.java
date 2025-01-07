package com.github.wilwe21.gsad.block.custom.celeste.strawberry;

import com.github.wilwe21.gsad.block.BlockTypes;
import net.minecraft.block.BlockState;
import net.minecraft.block.entity.BlockEntity;
import net.minecraft.util.math.BlockPos;

public class StrawberryEntity extends BlockEntity {
    public StrawberryEntity(BlockPos pos, BlockState state) {
        super(BlockTypes.STRAWBERRY, pos, state);
    }
}
