package com.github.wilwe21.stargazer.block.clases.sapling;

import com.github.wilwe21.stargazer.block.ModBlock;
import com.github.wilwe21.stargazer.block.register.MoonBlocks;
import com.github.wilwe21.stargazer.mechanics.trees.DirectionalTree;
import com.github.wilwe21.stargazer.mechanics.trees.Tree;
import com.github.wilwe21.stargazer.mechanics.trees.moon.MoonTree1;
import com.github.wilwe21.stargazer.mechanics.trees.moon.MoonTree2;
import com.github.wilwe21.stargazer.mechanics.trees.moon.MoonTree3;
import com.google.common.collect.ImmutableList;
import com.mojang.serialization.MapCodec;
import net.minecraft.block.*;
import net.minecraft.server.world.ServerWorld;
import net.minecraft.state.StateManager;
import net.minecraft.state.property.BooleanProperty;
import net.minecraft.util.math.BlockPos;
import net.minecraft.util.math.Direction;
import net.minecraft.util.math.random.Random;
import net.minecraft.util.shape.VoxelShape;
import net.minecraft.world.BlockView;
import net.minecraft.world.World;
import net.minecraft.world.WorldAccess;
import net.minecraft.world.WorldView;

public class MoonSapling extends PlantBlock implements Fertilizable {
    public static final ImmutableList<Direction> GROW_DIRECTIONS = ImmutableList.of(
            Direction.SOUTH, Direction.NORTH, Direction.EAST, Direction.WEST
    );
    public static BooleanProperty GROWN = BooleanProperty.of("grown");

    public MoonSapling(Settings settings) {
        super(settings);
        this.setDefaultState(this.getDefaultState().with(GROWN, false));
    }

    @Override
    protected void appendProperties(StateManager.Builder<Block, BlockState> builder) {
        builder.add(GROWN);
    }

    @Override
    protected MapCodec<? extends PlantBlock> getCodec() {
        return null;
    }

    @Override
    protected void prepare(BlockState state, WorldAccess world, BlockPos pos, int flags, int maxUpdateDepth) {
        if (state.get(GROWN)) {
            instantGrow((ServerWorld) world, pos, state);
        }
        super.prepare(state, world, pos, flags, maxUpdateDepth);
    }

    @Override
    protected void onBlockAdded(BlockState state, World world, BlockPos pos, BlockState oldState, boolean notify) {
        if (state.get(GROWN)) {
            instantGrow((ServerWorld) world, pos, state);
        }
        super.onBlockAdded(state, world, pos, oldState, notify);
    }

    @Override
    protected boolean canPlantOnTop(BlockState floor, BlockView world, BlockPos pos) {
        return floor.getBlock().equals(MoonBlocks.MOON_ROCK) || floor.getBlock().equals(Blocks.END_STONE) || floor.getBlock().equals(MoonBlocks.MOON_ROCK_NYLIUM);
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
        if (random.nextInt(7) == 0 || state.get(GROWN)) {
            instantGrow(world, pos, state);
        } else {
            if (world.getBlockState(pos.up()).getBlock().equals(ModBlock.COSMIC_BLOCK) && random.nextInt(3) == 0) {
                instantGrow(world, pos, state);
            }
        }
    }

    @Override
    public void grow(ServerWorld world, Random random, BlockPos pos, BlockState state) {
        if (random.nextInt(15) > 3) {
            return;
        }
        instantGrow(world, pos, state);
    }

    public static void instantGrow(ServerWorld world, BlockPos pos, BlockState state) {
        Tree tree;
        java.util.Random random = new java.util.Random();
        switch (random.nextInt(0, 2)) {
            case 1 -> tree = MoonTree2.tree;
            case 2 -> tree = MoonTree3.tree;
            default -> tree = MoonTree1.tree;
        }
        if (tree.ROTATO) {
            Direction dir = GROW_DIRECTIONS.get(random.nextInt(GROW_DIRECTIONS.size()));
            Tree rotated = DirectionalTree.getFromNorth(tree, dir);
            if (rotated.canGrow(world, pos)) {
                rotated.Grow(world, pos);
                if (world.getBlockState(pos.down(1)).getBlock().equals(MoonBlocks.MOON_ROCK_NYLIUM)) {
                    world.setBlockState(pos.down(1), MoonBlocks.MOON_ROCK.getDefaultState());
                }
            } else if (state.get(GROWN)){
                world.setBlockState(pos, Blocks.AIR.getDefaultState());
            }
        } else {
            if (tree.canGrow(world, pos)) {
                tree.Grow(world, pos);
                if (world.getBlockState(pos.down(1)).getBlock().equals(MoonBlocks.MOON_ROCK_NYLIUM)) {
                    world.setBlockState(pos.down(1), MoonBlocks.MOON_ROCK.getDefaultState());
                }
            } else if (state.get(GROWN)) {
                world.setBlockState(pos, Blocks.AIR.getDefaultState());
            }
        }
    }
}
