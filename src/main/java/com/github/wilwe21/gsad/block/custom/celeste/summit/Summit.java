package com.github.wilwe21.gsad.block.custom.celeste.summit;

import com.google.common.collect.Maps;
import com.mojang.serialization.MapCodec;
import com.mojang.serialization.codecs.RecordCodecBuilder;
import net.minecraft.block.*;
import net.minecraft.block.enums.BlockHalf;
import net.minecraft.entity.LivingEntity;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.item.ItemPlacementContext;
import net.minecraft.item.ItemStack;
import net.minecraft.state.StateManager;
import net.minecraft.state.property.IntProperty;
import net.minecraft.state.property.Properties;
import net.minecraft.util.BlockMirror;
import net.minecraft.util.BlockRotation;
import net.minecraft.util.DyeColor;
import net.minecraft.util.math.BlockPos;
import net.minecraft.util.math.Direction;
import net.minecraft.util.math.RotationPropertyHelper;
import net.minecraft.util.math.random.Random;
import net.minecraft.util.shape.VoxelShape;
import net.minecraft.util.shape.VoxelShapes;
import net.minecraft.world.BlockView;
import net.minecraft.world.World;
import net.minecraft.world.WorldView;
import net.minecraft.world.event.GameEvent;
import net.minecraft.world.tick.ScheduledTickView;
import org.jetbrains.annotations.Nullable;

import java.util.Map;

// TEMP

public class Summit extends AbstractSummit {
    public static final MapCodec<Summit> CODEC = RecordCodecBuilder.mapCodec(
            instance -> instance.group(DyeColor.CODEC.fieldOf("color").forGetter(AbstractSummit::getColor), createSettingsCodec()).apply(instance, Summit::new)
    );
    public static final IntProperty ROTATION = Properties.ROTATION;
    private static final Map<DyeColor, Block> COLORED_BANNERS = Maps.<DyeColor, Block>newHashMap();

    @Override
    public MapCodec<Summit> getCodec() {
        return CODEC;
    }

    public Summit(DyeColor dyeColor, AbstractBlock.Settings settings) {
        super(dyeColor, settings);
        this.setDefaultState(this.stateManager.getDefaultState().with(ROTATION, Integer.valueOf(0)));
        COLORED_BANNERS.put(dyeColor, this);
    }

    @Override
    protected void appendProperties(StateManager.Builder<Block, BlockState> builder) {
        builder.add(Properties.ROTATION);
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

    @Override
    public BlockState getPlacementState(ItemPlacementContext ctx) {
        return this.getDefaultState().with(ROTATION, Integer.valueOf(RotationPropertyHelper.fromYaw(ctx.getPlayerYaw() + 180.0F)));
    }

    @Override
    protected BlockState getStateForNeighborUpdate(
            BlockState state,
            WorldView world,
            ScheduledTickView tickView,
            BlockPos pos,
            Direction direction,
            BlockPos neighborPos,
            BlockState neighborState,
            Random random
    ) {
        return direction == Direction.DOWN && !state.canPlaceAt(world, pos)
                ? Blocks.AIR.getDefaultState()
                : super.getStateForNeighborUpdate(state, world, tickView, pos, direction, neighborPos, neighborState, random);
    }

    @Override
    protected BlockState rotate(BlockState state, BlockRotation rotation) {
        return state.with(ROTATION, Integer.valueOf(rotation.rotate((Integer)state.get(ROTATION), 16)));
    }

    @Override
    protected BlockState mirror(BlockState state, BlockMirror mirror) {
        return state.with(ROTATION, Integer.valueOf(mirror.mirror((Integer)state.get(ROTATION), 16)));
    }

    public static Block getForColor(DyeColor color) {
        return (Block)COLORED_BANNERS.getOrDefault(color, Blocks.WHITE_BANNER);
    }

}
