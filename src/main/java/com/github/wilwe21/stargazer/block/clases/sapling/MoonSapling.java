package com.github.wilwe21.stargazer.block.clases.sapling;

import com.github.wilwe21.stargazer.Stargazer;
import com.github.wilwe21.stargazer.block.register.MoonBlocks;
import com.github.wilwe21.stargazer.mechanics.trees.DirectionalTree;
import com.github.wilwe21.stargazer.mechanics.trees.Tree;
import com.github.wilwe21.stargazer.mechanics.trees.TreesRegistry;
import com.github.wilwe21.stargazer.mechanics.trees.moon.MoonBase;
import com.github.wilwe21.stargazer.mechanics.trees.moon.MoonTree1;
import com.github.wilwe21.stargazer.mechanics.trees.moon.MoonTree2;
import com.github.wilwe21.stargazer.mechanics.trees.moon.MoonTree3;
import com.google.common.collect.ImmutableList;
import com.mojang.serialization.MapCodec;
import net.minecraft.block.*;
import net.minecraft.server.world.ServerWorld;
import net.minecraft.util.math.BlockPos;
import net.minecraft.util.math.Direction;
import net.minecraft.util.math.random.Random;
import net.minecraft.util.shape.VoxelShape;
import net.minecraft.world.BlockView;
import net.minecraft.world.World;
import net.minecraft.world.WorldView;

public class MoonSapling extends PlantBlock implements Fertilizable {
    public static final ImmutableList<Direction> GROW_DIRECTIONS = ImmutableList.of(
            Direction.SOUTH, Direction.NORTH, Direction.EAST, Direction.WEST
    );

    public MoonSapling(Settings settings) {
        super(settings);
    }

    @Override
    protected MapCodec<? extends PlantBlock> getCodec() {
        return null;
    }

    @Override
    protected boolean canPlantOnTop(BlockState floor, BlockView world, BlockPos pos) {
        return floor.getBlock().equals(MoonBlocks.MOON_ROCK);
    }

    @Override
    protected VoxelShape getOutlineShape(BlockState state, BlockView world, BlockPos pos, ShapeContext context) {
        return Block.createCuboidShape(2.0, 0.0, 2.0, 14.0, 12.0, 14.0);
    }

    @Override
    public boolean isFertilizable(WorldView world, BlockPos pos, BlockState state) {
        return true;
    }

    @Override
    public boolean canGrow(World world, Random random, BlockPos pos, BlockState state) {
        return true;
    }

    @Override
    public void grow(ServerWorld world, Random random, BlockPos pos, BlockState state) {
        if (random.nextInt(15) > 3) {
            return;
        }
        Tree tree;
        switch (random.nextBetween(0, 2)) {
            case 1 -> tree = MoonTree2.tree;
            case 2 -> tree = MoonTree3.tree;
            default -> tree = MoonTree1.tree;
        }
        if (tree.ROTATO) {
            Direction dir = GROW_DIRECTIONS.get(random.nextInt(GROW_DIRECTIONS.size()));
            Tree rotated = DirectionalTree.getFromNorth(tree, dir);
            if (rotated.canGrow(world, pos)) {
                rotated.Grow(world, pos);
            }
        } else {
            if (tree.canGrow(world, pos)) {
                tree.Grow(world, pos);
            }
        }
    }
}
