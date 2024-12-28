package com.github.wilwe21.gsad.block.custom.dream;

import com.mojang.serialization.MapCodec;
import net.minecraft.block.BlockState;
import net.minecraft.block.BlockWithEntity;
import net.minecraft.block.entity.BlockEntity;
import net.minecraft.util.math.BlockPos;

public class DreamBlock extends BlockWithEntity {
    @Override
    protected MapCodec<? extends DreamBlock> getCodec() {
        return createCodec(DreamBlock::new);
    }

    @Override
    public BlockEntity createBlockEntity(BlockPos pos, BlockState state) {
        return new DreamBlockEntity(pos, state);
    }

    public DreamBlock(Settings settings) {
        super(settings);
    }

    public static int getLuminance(BlockState currentBlockState) {
        return 15;
    }
}
