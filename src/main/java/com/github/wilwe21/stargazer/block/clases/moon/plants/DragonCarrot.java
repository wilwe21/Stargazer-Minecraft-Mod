package com.github.wilwe21.stargazer.block.clases.moon.plants;

import com.github.wilwe21.stargazer.Stargazer;
import com.github.wilwe21.stargazer.block.ModBlock;
import com.github.wilwe21.stargazer.block.register.Crops;
import com.mojang.serialization.MapCodec;
import net.minecraft.block.*;
import net.minecraft.item.ItemConvertible;
import net.minecraft.util.math.BlockPos;
import net.minecraft.util.math.random.Random;
import net.minecraft.util.shape.VoxelShape;
import net.minecraft.world.BlockView;
import net.minecraft.world.World;
import net.minecraft.world.WorldView;

import java.util.ArrayList;
import java.util.List;

public class DragonCarrot extends MoonCrop{
    public static final MapCodec<DragonCarrot> CODEC = DragonCarrot.createCodec(DragonCarrot::new);
    private static final VoxelShape[] SHAPES_BY_AGE = Block.createShapeArray(7, age -> Block.createColumnShape(16.0, 0.0, 2 + age));

    public MapCodec<DragonCarrot> getCodec() {
        return CODEC;
    }

    public DragonCarrot(AbstractBlock.Settings settings) {
        super(settings);
    }

    @Override
    protected ItemConvertible getSeedsItem() {
        return Crops.DRAGON_CARROT;
    }

    @Override
    public boolean isFertilizable(WorldView world, BlockPos pos, BlockState state) {
        return true;
    }

    @Override
    protected VoxelShape getOutlineShape(BlockState state, BlockView world, BlockPos pos, ShapeContext context) {
        return SHAPES_BY_AGE[this.getAge(state)];
    }

    @Override
    public void applyGrowth(World world, BlockPos pos, BlockState state) {
        super.applyGrowth(world, pos, state);
        if (state.get(AGE).equals(this.getMaxAge())) {
            List<Boolean> list = new ArrayList<>();
            for (BlockPos blockPos : BlockPos.iterate(pos, pos.add(1, 0, 1))) {
                if (world.getBlockState(blockPos).equals(this.getDefaultState().with(AGE, this.getMaxAge())) && world.getBlockState(blockPos.up()).getBlock().equals(Blocks.AIR)) {
                    list.add(true);
                }
            }
            if (list.size() == 4) {
                GiantDragonCarrot.place(world, pos, Crops.GIANT_DRAGON_CARROT.getDefaultState().with(GiantCrop.SIDE, GiantCropSide.ned));
                return;
            } else {
                list = new ArrayList<>();
            }
            for (BlockPos blockPos : BlockPos.iterate(pos, pos.add(-1, 0, -1))) {
                if (world.getBlockState(blockPos).equals(this.getDefaultState().with(AGE, this.getMaxAge())) && world.getBlockState(blockPos.up()).getBlock().equals(Blocks.AIR)) {
                    list.add(true);
                }
            }
            if (list.size() == 4) {
                GiantDragonCarrot.place(world, pos, Crops.GIANT_DRAGON_CARROT.getDefaultState().with(GiantCrop.SIDE, GiantCropSide.sed));
                return;
            } else {
                list = new ArrayList<>();
            }
            for (BlockPos blockPos : BlockPos.iterate(pos, pos.add(1, 0, -1))) {
                if (world.getBlockState(blockPos).equals(this.getDefaultState().with(AGE, this.getMaxAge())) && world.getBlockState(blockPos.up()).getBlock().equals(Blocks.AIR)) {
                    list.add(true);
                }
            }
            if (list.size() == 4) {
                GiantDragonCarrot.place(world, pos, Crops.GIANT_DRAGON_CARROT.getDefaultState().with(GiantCrop.SIDE, GiantCropSide.swd));
                return;
            } else {
                list = new ArrayList<>();
            }
            for (BlockPos blockPos : BlockPos.iterate(pos, pos.add(-1, 0, 1))) {
                if (world.getBlockState(blockPos).equals(this.getDefaultState().with(AGE, this.getMaxAge())) && world.getBlockState(blockPos.up()).getBlock().equals(Blocks.AIR)) {
                    list.add(true);
                }
            }
            if (list.size() == 4) {
                GiantDragonCarrot.place(world, pos, Crops.GIANT_DRAGON_CARROT.getDefaultState().with(GiantCrop.SIDE, GiantCropSide.nwd));
            }
        }
    }
}
