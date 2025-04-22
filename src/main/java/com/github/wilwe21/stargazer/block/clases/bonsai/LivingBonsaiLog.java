package com.github.wilwe21.stargazer.block.clases.bonsai;

import com.github.wilwe21.stargazer.block.register.Bonsai;
import com.google.common.collect.ImmutableList;
import com.mojang.serialization.MapCodec;
import net.minecraft.block.*;
import net.minecraft.block.entity.BlockEntity;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.item.ItemPlacementContext;
import net.minecraft.item.ItemStack;
import net.minecraft.registry.Registries;
import net.minecraft.registry.tag.BlockTags;
import net.minecraft.registry.tag.ItemTags;
import net.minecraft.server.world.ServerWorld;
import net.minecraft.state.StateManager;
import net.minecraft.state.property.Properties;
import net.minecraft.util.ActionResult;
import net.minecraft.util.Hand;
import net.minecraft.util.hit.BlockHitResult;
import net.minecraft.util.math.BlockPos;
import net.minecraft.util.math.Direction;
import net.minecraft.util.math.random.Random;
import net.minecraft.world.World;
import net.minecraft.world.block.WireOrientation;
import org.jetbrains.annotations.Nullable;

public class LivingBonsaiLog extends BlockWithEntity {
    public static final ImmutableList<Direction> GROW_DIRECTIONS = ImmutableList.of(
            Direction.SOUTH, Direction.NORTH, Direction.EAST, Direction.WEST, Direction.UP
    );
    @Override
    protected MapCodec<? extends BlockWithEntity> getCodec() {
        return null;
    }

    @Override
    protected void neighborUpdate(BlockState state, World world, BlockPos pos, Block sourceBlock, @Nullable WireOrientation wireOrientation, boolean notify) {
        LivingBonsaiLogEntity thisEntity = ((LivingBonsaiLogEntity) world.getBlockEntity(pos));
        checkLiving(pos, state, thisEntity, world);
        super.neighborUpdate(state, world, pos, sourceBlock, wireOrientation, notify);
    }

    @Override
    protected ActionResult onUseWithItem(ItemStack stack, BlockState state, World world, BlockPos pos, PlayerEntity player, Hand hand, BlockHitResult hit) {
        if (stack.isIn(ItemTags.LOGS)) {
            Block bl = Block.getBlockFromItem(stack.getItem());
            if (!player.isInCreativeMode()) {
                stack.decrement(1);
            }
            if (bl.getDefaultState().contains(Properties.AXIS)) {
                world.setBlockState(pos, bl.getDefaultState().with(Properties.AXIS, state.get(Properties.AXIS)));
            } else {
                world.setBlockState(pos, bl.getDefaultState());
            }
            return ActionResult.CONSUME;
        }
        return super.onUseWithItem(stack, state, world, pos, player, hand, hit);
    }

    public LivingBonsaiLog(Settings settings) {
        super(settings);
        this.setDefaultState(this.getDefaultState());
    }

    @Override
    protected void appendProperties(StateManager.Builder<Block, BlockState> builder) {
        builder.add(Properties.AXIS);
    }

    @Override
    public BlockState getPlacementState(ItemPlacementContext ctx) {
        return super.getPlacementState(ctx)
                .with(Properties.AXIS, ctx.getSide().getAxis());
    }

    public static void checkLiving(BlockPos pos, BlockState state, LivingBonsaiLogEntity thisEntity, World world) {
        if (!world.getBlockState(new BlockPos(thisEntity.ROOTX, thisEntity.ROOTY, thisEntity.ROOTZ)).getBlock().equals(Bonsai.LIVING_BONSAI_LOG) || !world.getBlockState(new BlockPos(thisEntity.PREVX, thisEntity.PREVY, thisEntity.PREVZ)).getBlock().equals(Bonsai.LIVING_BONSAI_LOG)) {
            if (world.getBlockState(new BlockPos(thisEntity.ROOTX, thisEntity.ROOTY, thisEntity.ROOTZ)).isIn(BlockTags.LOGS)) {
                BlockState state2 = world.getBlockState(new BlockPos(thisEntity.ROOTX, thisEntity.ROOTY, thisEntity.ROOTZ));
                if (state2.contains(Properties.AXIS)) {
                    world.setBlockState(pos, state2.with(Properties.AXIS, state.get(Properties.AXIS)));
                } else {
                    world.setBlockState(pos, state2);
                }
            } else if (world.getBlockState(new BlockPos(thisEntity.PREVX, thisEntity.PREVY, thisEntity.PREVZ)).isIn(BlockTags.LOGS)) {
                BlockState state2 = world.getBlockState(new BlockPos(thisEntity.PREVX, thisEntity.PREVY, thisEntity.PREVZ));
                if (state2.contains(Properties.AXIS)) {
                    world.setBlockState(pos, state2.with(Properties.AXIS, state.get(Properties.AXIS)));
                } else {
                    world.setBlockState(pos, state2);
                }
            } else {
                world.setBlockState(pos, Bonsai.BONSAI_LOG.getDefaultState());
            }
        }
    }

    @Override
    protected void randomTick(BlockState state, ServerWorld world, BlockPos pos, Random random) {
        LivingBonsaiLogEntity thisEntity = ((LivingBonsaiLogEntity) world.getBlockEntity(pos));
        assert thisEntity != null;
        checkLiving(pos, state, thisEntity, world);
        if (world.getBlockState(pos.up(1)).getBlock().equals(Blocks.AIR)) {
            boolean canBranch = (pos.getY() - thisEntity.ROOTY) > 3;
            if (!canBranch) {
                if (pos.getY() - thisEntity.ROOTY < 15) {
                    spawnLog(world, pos.up(1), thisEntity, state, pos);
                }
            } else if (state.get(Properties.AXIS).equals(Direction.Axis.Y) && pos.getY() - thisEntity.ROOTY < 10) {
                Direction dir = GROW_DIRECTIONS.get(random.nextInt(GROW_DIRECTIONS.size()));
                BlockPos pos1 = pos.offset(dir, 1);
                if (dir == Direction.UP) {
                    if (pos.getY() - thisEntity.ROOTY < 15) {
                        spawnLog(world, pos1, thisEntity, state.with(Properties.AXIS, dir.getAxis()), pos);
                    }
                } else {
                    if (canBranchOn(world, pos1)) {
                        spawnLog(world, pos1, thisEntity, state.with(Properties.AXIS, dir.getAxis()), pos);
                    }
                }
            } else {
                Direction.Axis axis = state.get(Properties.AXIS);
                if (Math.abs(pos.getX() - thisEntity.ROOTX) > 4) {
                    spawnCubeLeaves(world, pos, thisEntity, state);
                    return;
                }
                if (Math.abs(pos.getZ() - thisEntity.ROOTZ) > 4) {
                    spawnCubeLeaves(world, pos, thisEntity, state);
                    return;
                }
                BlockPos pos2 = pos.offset(axis, 1);
                if (Math.abs(pos.getX() - thisEntity.ROOTX) > 1 || Math.abs(pos.getZ() - thisEntity.ROOTZ) > 1) {
                    if (random.nextBoolean()) {
                        pos2.up(1);
                    }
                }
//                if (canBranchOn(world, pos2)) {
                    spawnLog(world, pos2, thisEntity, state.with(Properties.AXIS, axis), pos);
//                }
            }
        }
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
    private boolean canLeavesOn(ServerWorld world, BlockPos pos) {
        if (!world.getBlockState(pos.up(1)).getBlock().equals(Blocks.AIR)) {
            return false;
        }
        if (!world.getBlockState(pos.down(1)).getBlock().equals(Blocks.AIR)) {
            return false;
        }
        return true;
    }

    private void spawnCubeLeaves(ServerWorld world, BlockPos pos, LivingBonsaiLogEntity thisEntity, BlockState state) {
        for (int i = -1; i > 1; i ++) {
            for (int j = -1; j > 1; j++) {
                if (canLeavesOn(world, pos.up(i).north(j).west(-1))) {
                    spawnLeave(world, pos.up(i).north(j).west(-1), thisEntity, state);
                }
                if (canLeavesOn(world, pos.up(i).north(j).west(0))) {
                    spawnLeave(world, pos.up(i).north(j).west(0), thisEntity, state);
                }
                if (canLeavesOn(world, pos.up(i).north(j).west(1))) {
                    spawnLeave(world, pos.up(i).north(j).west(1), thisEntity, state);
                }
            }
        }
    }

    private void spawnLeave(ServerWorld world, BlockPos pos, LivingBonsaiLogEntity thisEntity, BlockState state) {
        if (world.getBlockState(pos).getBlock().equals(Bonsai.LIVING_BONSAI_LOG)) {
            return;
        }
        world.setBlockState(pos, Blocks.OAK_LEAVES.getDefaultState());
    }

    private void spawnLog(ServerWorld world, BlockPos pos, LivingBonsaiLogEntity thisEntity, BlockState state, BlockPos prevPos) {
        if (world.getBlockState(pos).getBlock().equals(Bonsai.LIVING_BONSAI_LOG)) {
            return;
        }
        world.setBlockState(pos, state);
        BlockEntity otherEntity = world.getBlockEntity(pos);
        if (otherEntity instanceof LivingBonsaiLogEntity ble) {
            ble.setROOTX(thisEntity.ROOTX);
            ble.setROOTY(thisEntity.ROOTY);
            ble.setROOTZ(thisEntity.ROOTZ);
            ble.setPREVX(prevPos.getX());
            ble.setPREVY(prevPos.getY());
            ble.setPREVZ(prevPos.getZ());
        }

    }


    @Override
    public @Nullable BlockEntity createBlockEntity(BlockPos pos, BlockState state) {
        return new LivingBonsaiLogEntity(pos, state);
    }
}
