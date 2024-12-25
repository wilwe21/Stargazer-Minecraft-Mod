package com.github.wilwe21.celeste.block.custom;

import com.mojang.serialization.MapCodec;
import net.minecraft.block.BlockState;
import net.minecraft.block.BlockWithEntity;
import net.minecraft.block.Blocks;
import net.minecraft.block.entity.BlockEntity;
import net.minecraft.entity.Entity;
import net.minecraft.sound.SoundCategory;
import net.minecraft.sound.SoundEvents;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.World;

public class Strawberry extends BlockWithEntity {
    public Strawberry(Settings settings) {
        super(settings);
    }

    @Override
    public void onEntityCollision(BlockState state, World world, BlockPos pos, Entity entity) {
        world.playSound(entity, pos, SoundEvents.BLOCK_AMETHYST_CLUSTER_BREAK, SoundCategory.BLOCKS, 1.0F, 1.0F);
        world.setBlockState(pos, Blocks.AIR.getDefaultState());
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
