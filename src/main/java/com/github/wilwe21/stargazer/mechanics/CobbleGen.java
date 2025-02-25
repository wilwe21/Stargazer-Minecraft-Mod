package com.github.wilwe21.stargazer.mechanics;

import com.github.wilwe21.stargazer.Helpers;
import com.github.wilwe21.stargazer.block.ModBlock;
import com.github.wilwe21.stargazer.block.register.MoonBlocks;
import net.minecraft.block.Block;
import net.minecraft.block.BlockState;
import net.minecraft.block.Blocks;
import net.minecraft.registry.tag.FluidTags;
import net.minecraft.util.math.BlockPos;
import net.minecraft.util.math.Direction;
import net.minecraft.world.World;

import static net.minecraft.block.FluidBlock.FLOW_DIRECTIONS;

public class CobbleGen {
    public static boolean test(World world, BlockPos pos) {
        if (!gen(ModBlock.COSMIC_BLOCK, MoonBlocks.BLACK_MOON_ROCK, MoonBlocks.MOON_ROCK, world, pos)) {
            return false;
        }
        if (!gen(ModBlock.NEGATIVE_BLOCK, Blocks.AMETHYST_BLOCK, Blocks.GLASS, world, pos)) {
            return false;
        }
        return true;
    }

    public static boolean gen(Block lava, Block Obs, Block Cobble, World world, BlockPos pos) {
        return gen(lava, Obs.getDefaultState(), Cobble.getDefaultState(), world, pos);
    }
    public static boolean gen(Block lava, BlockState Obs, Block Cobble, World world, BlockPos pos) {
        return gen(lava, Obs, Cobble.getDefaultState(), world, pos);
    }
    public static boolean gen(Block lava, Block Obs, BlockState Cobble, World world, BlockPos pos) {
        return gen(lava, Obs.getDefaultState(), Cobble, world, pos);
    }

    public static boolean gen(Block lava, BlockState Obs, BlockState Cobble, World world, BlockPos pos) {
        for (Direction direction : FLOW_DIRECTIONS) {
            if (Helpers.isColliding(lava, world, pos, direction)) {
                BlockPos blockPos = pos.offset(direction.getOpposite());
                if (world.getFluidState(blockPos).isIn(FluidTags.WATER)) {
                    BlockState block = world.getFluidState(pos).isStill() ? Obs : Cobble;
                    if (direction == Direction.DOWN) {
                        BlockPos newPos = Helpers.getCollidingPosition(lava, world, pos, FLOW_DIRECTIONS);
                        world.setBlockState(newPos, Obs);
                    } else {
                        world.setBlockState(pos, block);
                    }
                    return false;
                }
            }
        }
        if (world.getFluidState(pos).isStill()) {
            if (Helpers.isCollidingAny(lava, world, pos, FLOW_DIRECTIONS)) {
                BlockState block = world.getFluidState(pos).isStill() ? Obs : Cobble;
                BlockPos newPos = Helpers.getCollidingPosition(lava, world, pos, FLOW_DIRECTIONS);
                world.setBlockState(newPos, block);
                return false;
            }
        }
        return true;
    }
}
