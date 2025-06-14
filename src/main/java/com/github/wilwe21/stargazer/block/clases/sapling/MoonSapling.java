package com.github.wilwe21.stargazer.block.clases.sapling;

import com.github.wilwe21.stargazer.block.register.MoonBlocks;
import com.github.wilwe21.stargazer.block.register.StarBlocks;
import com.github.wilwe21.stargazer.mechanics.features.DirectionalTree;
import com.github.wilwe21.stargazer.mechanics.features.Tree;
import com.github.wilwe21.stargazer.mechanics.features.moon.MoonTrees;
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
    public static final ImmutableList<Block> PLACE = ImmutableList.of(
            MoonBlocks.MOON_ROCK, Blocks.END_STONE, MoonBlocks.MOON_ROCK_NYLIUM
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
        return PLACE.contains(floor.getBlock());
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
    protected void randomTick(BlockState state, ServerWorld world, BlockPos pos, Random random) {
        if (random.nextInt(7) == 0) {
            this.instantGrow(world, pos, state);
        } else {
            if (world.getBlockState(pos.up()).getBlock().equals(StarBlocks.COSMIC_BLOCK) && random.nextInt(3) == 0) {
                this.instantGrow(world, pos, state);
            }
        }
    }

    @Override
    public void grow(ServerWorld world, Random random, BlockPos pos, BlockState state) {
        if (random.nextInt(15) > 3) {
            return;
        }
        this.instantGrow(world, pos, state);
    }

    public void instantGrow(ServerWorld world, BlockPos pos, BlockState state) {
        java.util.Random random = new java.util.Random();
        Tree tree = MoonTrees.TREELIST.get(random.nextInt(MoonTrees.TREELIST.size()));
        if (tree.ROTATO) {
            Direction dir = GROW_DIRECTIONS.get(random.nextInt(GROW_DIRECTIONS.size()));
            Tree rotated = DirectionalTree.getFromNorth(tree, dir);
            if (rotated.canGrow(world, pos)) {
                rotated.Grow(world, pos);
                if (world.getBlockState(pos.down(1)).getBlock().equals(MoonBlocks.MOON_ROCK_NYLIUM)) {
                    world.setBlockState(pos.down(1), MoonBlocks.MOON_ROCK.getDefaultState());
                }
            }
        } else {
            if (tree.canGrow(world, pos)) {
                tree.Grow(world, pos);
                if (world.getBlockState(pos.down(1)).getBlock().equals(MoonBlocks.MOON_ROCK_NYLIUM)) {
                    world.setBlockState(pos.down(1), MoonBlocks.MOON_ROCK.getDefaultState());
                }
            }
        }
    }
}
