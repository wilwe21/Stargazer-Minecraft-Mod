package com.github.wilwe21.gsad.block.custom.random.negative;

import com.mojang.serialization.MapCodec;
import net.minecraft.block.*;
import net.minecraft.block.entity.BlockEntity;
import net.minecraft.util.math.BlockPos;

public class NegativeBlock extends BlockWithEntity {
    @Override
    protected MapCodec<? extends NegativeBlock> getCodec() {
        return createCodec(NegativeBlock::new);
    }

    @Override
    public BlockEntity createBlockEntity(BlockPos pos, BlockState state) {
        return new NegativeBlockEntity(pos, state);
    }

    public NegativeBlock(Settings settings) {
        super(settings);
    }
}
