package com.github.wilwe21.celeste.block.custom;

import com.mojang.serialization.MapCodec;
import net.minecraft.block.BlockState;
import net.minecraft.block.BlockWithEntity;
import net.minecraft.block.entity.BlockEntity;
import net.minecraft.util.math.BlockPos;

public class Strawberry extends BlockWithEntity {
    public Strawberry(Settings settings) {
        super(settings);
    }

    @Override
    protected MapCodec<? extends Strawberry> getCodec() {
        return createCodec(Strawberry::new);
    }

    @Override
    public BlockEntity createBlockEntity(BlockPos pos, BlockState state) {
        return new StrawberryEntity(pos, state);
    }
}
