package com.github.wilwe21.stargazer.block.clases.sapling;

import com.github.wilwe21.stargazer.block.ModBlock;
import com.github.wilwe21.stargazer.block.register.MoonBlocks;
import com.google.common.collect.ImmutableList;
import com.mojang.serialization.MapCodec;
import net.minecraft.block.*;
import net.minecraft.server.world.ServerWorld;
import net.minecraft.state.property.IntProperty;
import net.minecraft.state.property.Properties;
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
    private static final java.util.Random random = new java.util.Random();

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
        if (random.nextInt(20) > 3) {
            return false;
        }
        if (!(checkBlocks(world,pos.up(1)))) {
            return false;
        }
        for (Direction dir : GROW_DIRECTIONS) {
            BlockPos stempOff = pos.offset(dir, 1).up(5);
            for (int i = 2; i <= 8; i++) {
                if (!(checkBlocks(world, pos.offset(dir, 1).up(i)))) {
                    return false;
                }
            }
            if (!(checkBlocks(world, stempOff))) {
                return false;
            }
            for (int i = 0; i < 4; i++) {
                if (!(checkBlocks(world, stempOff.down(1).up(i).south(1)))) {
                    return false;
                }
                if (!(checkBlocks(world, stempOff.down(1).up(i).north(1)))) {
                    return false;
                }
                if (!(checkBlocks(world, stempOff.down(1).up(i).east(1)))) {
                    return false;
                }
                if (!(checkBlocks(world, stempOff.down(1).up(i).west(1)))) {
                    return false;

                }
            }
            if (!(checkBlocks(world, stempOff.up(1).south(2)))) {
                return false;
            }
            if (!(checkBlocks(world, stempOff.up(1).south(1).east(1)))) {
                return false;
            }
            if (!(checkBlocks(world, stempOff.up(1).north(2)))) {
                return false;
            }
            if (!(checkBlocks(world, stempOff.up(1).north(1).west(1)))) {
                return false;
            }
            if (!(checkBlocks(world, stempOff.up(1).west(2)))) {
                return false;
            }
            if (!(checkBlocks(world, stempOff.up(1).west(1).south(1)))) {
                return false;
            }
            if (!(checkBlocks(world, stempOff.up(1).east(2)))) {
                return false;
            }
            if (!(checkBlocks(world, stempOff.up(1).east(1).north(1)))) {
                return false;
            }
        }
        return true;
    }
    public boolean checkBlocks(World world, BlockPos pos) {
        return world.getBlockState(pos).getBlock().equals(Blocks.AIR) || world.getBlockState(pos).getBlock().equals(ModBlock.COSMIC_BLOCK);
    }

    @Override
    public void grow(ServerWorld world, Random random, BlockPos pos, BlockState state) {
        Direction dir = GROW_DIRECTIONS.get(random.nextInt(GROW_DIRECTIONS.size()));
        BlockPos stempPos = pos;
        stempPos = stempPos.offset(dir, 1);
        BlockPos stempEnd = pos;
        for (int i = 0; i < 2; i++) {
            world.setBlockState(pos.up(i), MoonBlocks.MOON_LOG.getDefaultState().with(Properties.AXIS, Direction.Axis.Y));
        }
        for (int i = 2; i < 6; i++) {
            world.setBlockState(stempPos.up(i), MoonBlocks.MOON_LOG.getDefaultState().with(Properties.AXIS, Direction.Axis.Y));
            stempEnd = stempPos.up(i);
        }
        for (int i = 6; i <= 8; i++) {
            world.setBlockState(stempPos.up(i), MoonBlocks.MOON_LEAVES.getDefaultState());
        }
        for (int i = 0; i < 4; i++) {
            world.setBlockState(stempEnd.down(1).up(i).south(1), MoonBlocks.MOON_LEAVES.getDefaultState());
            world.setBlockState(stempEnd.down(1).up(i).north(1), MoonBlocks.MOON_LEAVES.getDefaultState());
            world.setBlockState(stempEnd.down(1).up(i).east(1), MoonBlocks.MOON_LEAVES.getDefaultState());
            world.setBlockState(stempEnd.down(1).up(i).west(1), MoonBlocks.MOON_LEAVES.getDefaultState());
        }
        world.setBlockState(stempEnd.up(1).south(2), MoonBlocks.MOON_LEAVES.getDefaultState());
        world.setBlockState(stempEnd.up(1).south(1).east(1), MoonBlocks.MOON_LEAVES.getDefaultState());
        world.setBlockState(stempEnd.up(1).north(2), MoonBlocks.MOON_LEAVES.getDefaultState());
        world.setBlockState(stempEnd.up(1).north(1).west(1), MoonBlocks.MOON_LEAVES.getDefaultState());
        world.setBlockState(stempEnd.up(1).west(2), MoonBlocks.MOON_LEAVES.getDefaultState());
        world.setBlockState(stempEnd.up(1).west(1).south(1), MoonBlocks.MOON_LEAVES.getDefaultState());
        world.setBlockState(stempEnd.up(1).east(2), MoonBlocks.MOON_LEAVES.getDefaultState());
        world.setBlockState(stempEnd.up(1).east(1).north(1), MoonBlocks.MOON_LEAVES.getDefaultState());
    }
}
