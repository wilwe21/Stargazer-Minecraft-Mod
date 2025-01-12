package com.github.wilwe21.gsad.block.custom.celeste;

import net.minecraft.block.Block;
import net.minecraft.block.BlockState;
import net.minecraft.block.ShapeContext;
import net.minecraft.block.enums.BlockHalf;
import net.minecraft.entity.LivingEntity;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.item.ItemPlacementContext;
import net.minecraft.item.ItemStack;
import net.minecraft.state.StateManager;
import net.minecraft.state.property.Properties;
import net.minecraft.util.math.BlockPos;
import net.minecraft.util.math.Direction;
import net.minecraft.util.shape.VoxelShape;
import net.minecraft.util.shape.VoxelShapes;
import net.minecraft.world.BlockView;
import net.minecraft.world.World;
import net.minecraft.world.event.GameEvent;
import org.jetbrains.annotations.Nullable;

// TEMP

public class Summit extends Block {
    public Summit(Settings settings) {
        super(settings);
    }

    @Override
    protected void appendProperties(StateManager.Builder<Block, BlockState> builder) {
        builder.add(Properties.BLOCK_HALF);
        builder.add(Properties.HORIZONTAL_FACING);
    }

    @Override
    public VoxelShape getOutlineShape(BlockState state, BlockView view, BlockPos pos, ShapeContext context) {
       return VoxelShapes.cuboid(0.4375, 0, 0.4375, 0.5625, 1, 0.5625);
    }

    @Override
    public BlockState onBreak(World world, BlockPos pos, BlockState state, PlayerEntity player) {
        this.spawnBreakParticles(world, player, pos, state);
        if (world.getBlockState(pos.offset(Direction.Axis.Y, 1)).getBlock() instanceof Summit) {
            world.breakBlock(pos.offset(Direction.Axis.Y, 1), false);
            world.emitGameEvent(GameEvent.BLOCK_DESTROY, pos.offset(Direction.Axis.Y, 1), GameEvent.Emitter.of(player, state));
        }
        if (world.getBlockState(pos.offset(Direction.Axis.Y, -1)).getBlock() instanceof Summit) {
            world.breakBlock(pos.offset(Direction.Axis.Y, -1), false);
            world.emitGameEvent(GameEvent.BLOCK_DESTROY, pos.offset(Direction.Axis.Y, -1), GameEvent.Emitter.of(player, state));
        }
        if (world.getBlockState(pos.offset(Direction.Axis.Y, 2)).getBlock() instanceof Summit) {
            world.breakBlock(pos.offset(Direction.Axis.Y, 2), false);
            world.emitGameEvent(GameEvent.BLOCK_DESTROY, pos.offset(Direction.Axis.Y, 2), GameEvent.Emitter.of(player, state));
        }
        if (world.getBlockState(pos.offset(Direction.Axis.Y, -2)).getBlock() instanceof Summit) {
            world.breakBlock(pos.offset(Direction.Axis.Y, -2), false);
            world.emitGameEvent(GameEvent.BLOCK_DESTROY, pos.offset(Direction.Axis.Y, -2), GameEvent.Emitter.of(player, state));
        }
        world.emitGameEvent(GameEvent.BLOCK_DESTROY, pos, GameEvent.Emitter.of(player, state));
        return state;
    }

    @Override
    public void onPlaced(World world, BlockPos pos, BlockState state, @Nullable LivingEntity placer, ItemStack itemStack) {
        world.setBlockState(pos, state.with(Properties.BLOCK_HALF, BlockHalf.BOTTOM));
        world.setBlockState(pos.offset(Direction.Axis.Y, 1), state.with(Properties.BLOCK_HALF, BlockHalf.BOTTOM));
        world.setBlockState(pos.offset(Direction.Axis.Y, 2), state.with(Properties.BLOCK_HALF, BlockHalf.TOP));
    }

//    @Override
//    public BlockState getPlacementState(ItemPlacementContext ctx) {
//        if (this.canPlaceAt(this.getDefaultState(), ctx.getWorld(), ctx.getBlockPos().up(1))) {
//            return this.getDefaultState();
//        }
//        return null;
//    }
}
