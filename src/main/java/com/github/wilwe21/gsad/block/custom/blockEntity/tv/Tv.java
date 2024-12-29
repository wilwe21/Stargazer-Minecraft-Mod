package com.github.wilwe21.gsad.block.custom.blockEntity.tv;

import com.mojang.serialization.MapCodec;
import net.minecraft.block.BlockState;
import net.minecraft.block.BlockWithEntity;
import net.minecraft.block.entity.BlockEntity;
import net.minecraft.util.math.BlockPos;

public class Tv extends BlockWithEntity {
    @Override
    protected MapCodec<? extends Tv> getCodec() {
        return createCodec(Tv::new);
    }

    @Override
    public BlockEntity createBlockEntity(BlockPos pos, BlockState state) {
        return new TvEntity(pos, state);
    }

    public Tv(Settings settings) {
        super(settings);
    }
}
