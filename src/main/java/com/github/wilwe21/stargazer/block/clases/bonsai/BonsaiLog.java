package com.github.wilwe21.stargazer.block.clases.bonsai;

import com.github.wilwe21.stargazer.block.register.Bonsai;
import com.google.common.collect.ImmutableList;
import com.mojang.serialization.MapCodec;
import net.minecraft.block.Block;
import net.minecraft.block.BlockState;
import net.minecraft.block.BlockWithEntity;
import net.minecraft.block.Blocks;
import net.minecraft.block.entity.BlockEntity;
import net.minecraft.item.ItemPlacementContext;
import net.minecraft.server.world.ServerWorld;
import net.minecraft.state.StateManager;
import net.minecraft.state.property.BooleanProperty;
import net.minecraft.state.property.Properties;
import net.minecraft.util.math.BlockPos;
import net.minecraft.util.math.Direction;
import net.minecraft.util.math.random.Random;
import org.jetbrains.annotations.Nullable;

public class BonsaiLog extends BlockWithEntity {
    public static final ImmutableList<Direction> GROW_DIRECTIONS = ImmutableList.of(
            Direction.SOUTH, Direction.NORTH, Direction.EAST, Direction.WEST, Direction.UP
    );
    public static BooleanProperty NATURAL = BooleanProperty.of("natural");
    @Override
    protected MapCodec<? extends BlockWithEntity> getCodec() {
        return null;
    }

    public BonsaiLog(Settings settings) {
        super(settings);
        this.setDefaultState(this.getDefaultState()
                .with(NATURAL, false));
    }

    @Override
    protected void appendProperties(StateManager.Builder<Block, BlockState> builder) {
        builder.add(Properties.AXIS);
        builder.add(NATURAL);
    }

    @Override
    public BlockState getPlacementState(ItemPlacementContext ctx) {
        return super.getPlacementState(ctx)
                .with(Properties.AXIS, ctx.getSide().getAxis());
    }

    @Override
    protected void randomTick(BlockState state, ServerWorld world, BlockPos pos, Random random) {
        if (!state.get(NATURAL)) {
            return;
        }
        if (world.getBlockState(pos.up(1)).getBlock().equals(Blocks.AIR)) {
            BonsaiLogEntity thisEntity = ((BonsaiLogEntity) world.getBlockEntity(pos));
            if (thisEntity == null) {
                return;
            }
            boolean canBranch = (pos.getY() - thisEntity.ROOTY) > 3;
            if (!canBranch) {
                spawnLog(world, pos.up(1), thisEntity, state.with(NATURAL, true));
            } else if (state.get(Properties.AXIS).equals(Direction.Axis.Y)) {
                Direction dir = GROW_DIRECTIONS.get(random.nextInt(GROW_DIRECTIONS.size()));
                BlockPos pos1 = pos.offset(dir, 1);
                if (dir == Direction.UP) {
                    spawnLog(world, pos1, thisEntity, state.with(NATURAL, true).with(Properties.AXIS, dir.getAxis()));
                } else {
                    if (canBranchOn(world, pos)) {
                        spawnLog(world, pos1, thisEntity, state.with(NATURAL, true).with(Properties.AXIS, dir.getAxis()));
                    }
                }
            } else {
                Direction.Axis axis = state.get(Properties.AXIS);
                if (Math.abs(pos.getX() - thisEntity.ROOTX) > 5) {
                    return;
                }
                if (Math.abs(pos.getZ() - thisEntity.ROOTZ) > 5) {
                    return;
                }
                BlockPos pos2 = pos.offset(axis, 1);
                if (Math.abs(pos.getX() - thisEntity.ROOTX) > 2 || Math.abs(pos.getZ() - thisEntity.ROOTZ) > 2) {
                    if (random.nextBoolean()) {
                        pos2.up(1);
                    }
                }
                if (canBranchOn(world, pos2)) {
                    spawnLog(world, pos2, thisEntity, state.with(NATURAL, true).with(Properties.AXIS, axis));
                }
            }
        }
//        super.randomTick(state, world, pos, random);
    }
    private boolean canBranchOn(ServerWorld world, BlockPos pos) {
        if (!world.getBlockState(pos.down(1)).getBlock().equals(Blocks.AIR)) {
            return false;
        }
        if (!world.getBlockState(pos.down(2)).getBlock().equals(Blocks.AIR)) {
            return false;
        }
        if (!world.getBlockState(pos.up(1)).getBlock().equals(Blocks.AIR)) {
            return false;
        }
        if (!world.getBlockState(pos.up(2)).getBlock().equals(Blocks.AIR)) {
            return false;
        }
        return true;
    }

    private void spawnLog(ServerWorld world, BlockPos pos, BonsaiLogEntity thisEntity, BlockState state) {
        if (world.getBlockState(pos).getBlock().equals(Bonsai.BONSAI_LOG)) {
            return;
        }
        world.setBlockState(pos, state);
        BlockEntity otherEntity = world.getBlockEntity(pos);
        if (otherEntity instanceof BonsaiLogEntity ble) {
            ble.setROOTX(thisEntity.ROOTX);
            ble.setROOTY(thisEntity.ROOTY);
            ble.setROOTZ(thisEntity.ROOTZ);
        }

    }


    @Override
    public @Nullable BlockEntity createBlockEntity(BlockPos pos, BlockState state) {
        return new BonsaiLogEntity(pos, state);
    }
}
