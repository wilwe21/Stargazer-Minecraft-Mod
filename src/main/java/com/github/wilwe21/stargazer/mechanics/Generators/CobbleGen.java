package com.github.wilwe21.stargazer.mechanics.Generators;

import com.github.wilwe21.stargazer.Helpers;
import com.github.wilwe21.stargazer.mechanics.blockarray.RandomBlockArray;
import net.minecraft.block.Block;
import net.minecraft.block.BlockState;
import net.minecraft.fluid.Fluid;
import net.minecraft.registry.tag.FluidTags;
import net.minecraft.registry.tag.TagKey;
import net.minecraft.util.math.BlockPos;
import net.minecraft.util.math.Direction;
import net.minecraft.world.World;

import static net.minecraft.block.FluidBlock.FLOW_DIRECTIONS;

public class CobbleGen {
    public final Block LAVA;
    public final BlockState BLOCKOBS;
    public final BlockState BLOCKCOBBLE;
    public final RandomBlockArray BLOCKOBSARRAY;
    public final RandomBlockArray BLOCKCOBBLEARRAY;
    public final TagKey<Fluid> FLUID;
    public final Boolean ARRAYUSE;

    public CobbleGen(Boolean useArray, Block lava, Block Obs, Block Cobble) {
        ARRAYUSE = useArray;
        LAVA = lava;
        BLOCKCOBBLE = Cobble.getDefaultState();
        BLOCKOBS = Obs.getDefaultState();
        BLOCKCOBBLEARRAY = new RandomBlockArray("cob");
        BLOCKCOBBLEARRAY.add(BLOCKCOBBLE.getBlock());
        BLOCKOBSARRAY = new RandomBlockArray("obs");
        BLOCKOBSARRAY.add(BLOCKOBS.getBlock());
        FLUID = FluidTags.WATER;
    }
    public CobbleGen(Boolean useArray, Block lava, RandomBlockArray Obs, RandomBlockArray Cobble) {
        ARRAYUSE = useArray;
        LAVA = lava;
        BLOCKCOBBLEARRAY = Cobble;
        BLOCKOBSARRAY = Obs;
        BLOCKOBS = Obs.getRandom().getDefaultState();
        BLOCKCOBBLE = Cobble.getRandom().getDefaultState();
        FLUID = FluidTags.WATER;
    }
    public CobbleGen(Boolean useArray, Block lava, RandomBlockArray Obs, Block Cobble) {
        ARRAYUSE = useArray;
        LAVA = lava;
        BLOCKCOBBLE = Cobble.getDefaultState();
        BLOCKOBSARRAY = Obs;
        BLOCKCOBBLEARRAY = new RandomBlockArray("cob");
        BLOCKCOBBLEARRAY.add(Cobble);
        BLOCKOBS = Obs.getRandom().getDefaultState();
        FLUID = FluidTags.WATER;
    }
    public CobbleGen(Boolean useArray, Block lava, Block Obs, RandomBlockArray Cobble) {
        ARRAYUSE = useArray;
        LAVA = lava;
        BLOCKCOBBLEARRAY = Cobble;
        BLOCKCOBBLE = Cobble.getRandom().getDefaultState();
        BLOCKOBS = Obs.getDefaultState();
        BLOCKOBSARRAY = new RandomBlockArray("obs");
        BLOCKOBSARRAY.add(Obs);
        FLUID = FluidTags.WATER;
    }
    public CobbleGen(Boolean useArray, Block lava, BlockState Obs, Block Cobble) {
        ARRAYUSE = useArray;
        LAVA = lava;
        BLOCKCOBBLE = Cobble.getDefaultState();
        BLOCKOBS = Obs;
        BLOCKCOBBLEARRAY = new RandomBlockArray("cob");
        BLOCKCOBBLEARRAY.add(BLOCKCOBBLE.getBlock());
        BLOCKOBSARRAY = new RandomBlockArray("obs");
        BLOCKOBSARRAY.add(BLOCKOBS.getBlock());
        FLUID = FluidTags.WATER;
    }
    public CobbleGen(Boolean useArray, Block lava, Block Obs, BlockState Cobble) {
        ARRAYUSE = useArray;
        LAVA = lava;
        BLOCKCOBBLE = Cobble;
        BLOCKOBS = Obs.getDefaultState();
        BLOCKCOBBLEARRAY = new RandomBlockArray("cob");
        BLOCKCOBBLEARRAY.add(BLOCKCOBBLE.getBlock());
        BLOCKOBSARRAY = new RandomBlockArray("obs");
        BLOCKOBSARRAY.add(BLOCKOBS.getBlock());
        FLUID = FluidTags.WATER;
    }
    public CobbleGen(Boolean useArray, Block lava, BlockState Obs, BlockState Cobble) {
        ARRAYUSE = useArray;
        LAVA = lava;
        BLOCKCOBBLE = Cobble;
        BLOCKOBS = Obs;
        BLOCKCOBBLEARRAY = new RandomBlockArray("cob");
        BLOCKCOBBLEARRAY.add(BLOCKCOBBLE.getBlock());
        BLOCKOBSARRAY = new RandomBlockArray("obs");
        BLOCKOBSARRAY.add(BLOCKOBS.getBlock());
        FLUID = FluidTags.WATER;
    }
    public CobbleGen(Boolean useArray, Block lava, Block Obs, Block Cobble, TagKey<Fluid> keyFluid) {
        ARRAYUSE = useArray;
        LAVA = lava;
        BLOCKCOBBLE = Cobble.getDefaultState();
        BLOCKOBS = Obs.getDefaultState();
        BLOCKCOBBLEARRAY = new RandomBlockArray("cob");
        BLOCKCOBBLEARRAY.add(BLOCKCOBBLE.getBlock());
        BLOCKOBSARRAY = new RandomBlockArray("obs");
        BLOCKOBSARRAY.add(BLOCKOBS.getBlock());
        FLUID = keyFluid;
    }
    public CobbleGen(Boolean useArray, Block lava, BlockState Obs, Block Cobble, TagKey<Fluid> keyFluid) {
        ARRAYUSE = useArray;
        LAVA = lava;
        BLOCKCOBBLE = Cobble.getDefaultState();
        BLOCKOBS = Obs;
        BLOCKCOBBLEARRAY = new RandomBlockArray("cob");
        BLOCKCOBBLEARRAY.add(BLOCKCOBBLE.getBlock());
        BLOCKOBSARRAY = new RandomBlockArray("obs");
        BLOCKOBSARRAY.add(BLOCKOBS.getBlock());
        FLUID = keyFluid;
    }
    public CobbleGen(Boolean useArray, Block lava, Block Obs, BlockState Cobble, TagKey<Fluid> keyFluid) {
        ARRAYUSE = useArray;
        LAVA = lava;
        BLOCKCOBBLE = Cobble;
        BLOCKOBS = Obs.getDefaultState();
        BLOCKCOBBLEARRAY = new RandomBlockArray("cob");
        BLOCKCOBBLEARRAY.add(BLOCKCOBBLE.getBlock());
        BLOCKOBSARRAY = new RandomBlockArray("obs");
        BLOCKOBSARRAY.add(BLOCKOBS.getBlock());
        FLUID = keyFluid;
    }
    public CobbleGen(Boolean useArray, Block lava, BlockState Obs, BlockState Cobble, TagKey<Fluid> keyFluid) {
        ARRAYUSE = useArray;
        LAVA = lava;
        BLOCKCOBBLE = Cobble;
        BLOCKOBS = Obs;
        BLOCKCOBBLEARRAY = new RandomBlockArray("cob");
        BLOCKCOBBLEARRAY.add(BLOCKCOBBLE.getBlock());
        BLOCKOBSARRAY = new RandomBlockArray("obs");
        BLOCKOBSARRAY.add(BLOCKOBS.getBlock());
        FLUID = keyFluid;
    }

    public boolean gen(World world, BlockPos pos) {
        for (Direction direction : FLOW_DIRECTIONS) {
            if (Helpers.isColliding(LAVA, world, pos, direction)) {
                BlockPos blockPos = pos.offset(direction.getOpposite());
                if (world.getFluidState(blockPos).isIn(FLUID)) {
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
        if (world.getFluidState(pos).isStill() && world.getFluidState(pos).isIn(FLUID)) {
            if (Helpers.isCollidingAny(LAVA, world, pos, FLOW_DIRECTIONS)) {
                BlockState block = world.getFluidState(pos).isStill() ? BLOCKOBS : BLOCKCOBBLE;
                BlockPos newPos = Helpers.getCollidingPosition(LAVA, world, pos, FLOW_DIRECTIONS);
                world.setBlockState(newPos, block);
                return false;
            }
        }
        return true;
    }
    public boolean genFromArray(World world, BlockPos pos) {
        for (Direction direction : FLOW_DIRECTIONS) {
            if (Helpers.isColliding(LAVA, world, pos, direction)) {
                BlockPos blockPos = pos.offset(direction.getOpposite());
                if (world.getFluidState(blockPos).isIn(FLUID)) {
                    BlockState block = world.getFluidState(pos).isStill() ? BLOCKOBSARRAY.getRandom().getDefaultState() : BLOCKCOBBLEARRAY.getRandom().getDefaultState();
                    if (direction == Direction.DOWN) {
                        BlockPos newPos = Helpers.getCollidingPosition(LAVA, world, pos, FLOW_DIRECTIONS);
                        world.setBlockState(newPos, BLOCKOBSARRAY.getRandom().getDefaultState());
                    } else {
                        world.setBlockState(pos, block);
                    }
                    return false;
                }
            }
        }
        if (world.getFluidState(pos).isStill() && world.getFluidState(pos).isIn(FLUID)) {
            if (Helpers.isCollidingAny(LAVA, world, pos, FLOW_DIRECTIONS)) {
                BlockState block = world.getFluidState(pos).isStill() ? BLOCKOBSARRAY.getRandom().getDefaultState() : BLOCKCOBBLEARRAY.getRandom().getDefaultState();
                BlockPos newPos = Helpers.getCollidingPosition(LAVA, world, pos, FLOW_DIRECTIONS);
                world.setBlockState(newPos, block);
                return false;
            }
        }
        return true;
    }
}
