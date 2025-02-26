package com.github.wilwe21.stargazer.mechanics.Generators;

import com.github.wilwe21.stargazer.Helpers;
import net.minecraft.block.Block;
import net.minecraft.block.BlockState;
import net.minecraft.registry.tag.FluidTags;
import net.minecraft.util.math.BlockPos;
import net.minecraft.util.math.Direction;
import net.minecraft.world.World;

import static net.minecraft.block.FluidBlock.FLOW_DIRECTIONS;

public class CobbleGen {
    public CobbleGen(Block lava, Block Obs, Block Cobble) {
        LAVA = lava;
        BLOCKCOBBLE = Cobble.getDefaultState();
        BLOCKOBS = Obs.getDefaultState();
    }
    public CobbleGen(Block lava, BlockState Obs, Block Cobble) {
        LAVA = lava;
        BLOCKCOBBLE = Cobble.getDefaultState();
        BLOCKOBS = Obs;
    }
    public CobbleGen(Block lava, Block Obs, BlockState Cobble) {
        LAVA = lava;
        BLOCKCOBBLE = Cobble;
        BLOCKOBS = Obs.getDefaultState();
    }
    public CobbleGen(Block lava, BlockState Obs, BlockState Cobble) {
        LAVA = lava;
        BLOCKCOBBLE = Cobble;
        BLOCKOBS = Obs;
    }
    public final Block LAVA;
    public final BlockState BLOCKOBS;
    public final BlockState BLOCKCOBBLE;

    public boolean gen(World world, BlockPos pos) {
        for (Direction direction : FLOW_DIRECTIONS) {
            if (Helpers.isColliding(LAVA, world, pos, direction)) {
                BlockPos blockPos = pos.offset(direction.getOpposite());
                if (world.getFluidState(blockPos).isIn(FluidTags.WATER)) {
                    BlockState block = world.getFluidState(pos).isStill() ? BLOCKOBS : BLOCKCOBBLE;
                    if (direction == Direction.DOWN) {
                        BlockPos newPos = Helpers.getCollidingPosition(LAVA, world, pos, FLOW_DIRECTIONS);
                        world.setBlockState(newPos, BLOCKOBS);
                    } else {
                        world.setBlockState(pos, block);
                    }
                    return false;
                }
            }
        }
        if (world.getFluidState(pos).isStill()) {
            if (Helpers.isCollidingAny(LAVA, world, pos, FLOW_DIRECTIONS)) {
                BlockState block = world.getFluidState(pos).isStill() ? BLOCKOBS : BLOCKCOBBLE;
                BlockPos newPos = Helpers.getCollidingPosition(LAVA, world, pos, FLOW_DIRECTIONS);
                world.setBlockState(newPos, block);
                return false;
            }
        }
        return true;
    }
}
