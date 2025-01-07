package com.github.wilwe21.gsad.block.custom.celeste.dream;

import com.github.wilwe21.gsad.dash.Dash;
import com.github.wilwe21.gsad.dash.DashClient;
import com.mojang.serialization.MapCodec;
import net.minecraft.block.*;
import net.minecraft.block.entity.BlockEntity;
import net.minecraft.entity.Entity;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.item.ItemPlacementContext;
import net.minecraft.state.StateManager;
import net.minecraft.state.property.BooleanProperty;
import net.minecraft.util.math.BlockPos;
import net.minecraft.util.math.Direction;
import net.minecraft.util.math.Vec3d;
import net.minecraft.util.math.random.Random;
import net.minecraft.util.shape.VoxelShape;
import net.minecraft.util.shape.VoxelShapes;
import net.minecraft.world.BlockView;
import net.minecraft.world.World;
import net.minecraft.world.WorldView;
import net.minecraft.world.tick.ScheduledTickView;

import java.util.Map;

public class DreamBlock extends BlockWithEntity {
    public boolean SOLID = true;
    public static boolean MULTI = false;

    public static final BooleanProperty NORTH = ConnectingBlock.NORTH;
    public static final BooleanProperty EAST = ConnectingBlock.EAST;
    public static final BooleanProperty SOUTH = ConnectingBlock.SOUTH;
    public static final BooleanProperty WEST = ConnectingBlock.WEST;
    public static final BooleanProperty UP = ConnectingBlock.UP;
    public static final BooleanProperty DOWN = ConnectingBlock.DOWN;
    private static final Map<Direction, BooleanProperty> FACING_PROPERTIES = ConnectingBlock.FACING_PROPERTIES;
    @Override
    protected MapCodec<? extends DreamBlock> getCodec() {
        return createCodec(DreamBlock::new);
    }

    @Override
	protected void appendProperties(StateManager.Builder<Block, BlockState> builder) {
		builder.add(UP, DOWN, NORTH, EAST, SOUTH, WEST);
	}

    @Override
    public BlockEntity createBlockEntity(BlockPos pos, BlockState state) {
        return new DreamBlockEntity(pos, state);
    }

    public DreamBlock(Settings settings) {
        super(settings);
        this.setDefaultState(
                this.stateManager
                        .getDefaultState()
                        .with(NORTH, true)
                        .with(EAST, true)
                        .with(SOUTH, true)
                        .with(WEST, true)
                        .with(UP, true)
                        .with(DOWN, true)
        );
    }

    @Override
	public BlockState getPlacementState(ItemPlacementContext ctx) {
		BlockView blockView = ctx.getWorld();
		BlockPos blockPos = ctx.getBlockPos();
		return this.getDefaultState()
			.with(DOWN, !blockView.getBlockState(blockPos.down()).isOf(this))
			.with(UP, !blockView.getBlockState(blockPos.up()).isOf(this))
			.with(NORTH, !blockView.getBlockState(blockPos.north()).isOf(this))
			.with(EAST, !blockView.getBlockState(blockPos.east()).isOf(this))
			.with(SOUTH, !blockView.getBlockState(blockPos.south()).isOf(this))
			.with(WEST, !blockView.getBlockState(blockPos.west()).isOf(this));
	}

    public static Vec3d lookDir = null;

    @Override
    protected void onEntityCollision(BlockState state, World world, BlockPos pos, Entity entity) {
        if (entity instanceof PlayerEntity pl) {
            if (!MULTI) {
                lookDir = null;
            }
            if (Dash.isPlayerDashing(pl.getUuid()) || MULTI) {
                if (lookDir == null) {
                    lookDir = pl.getRotationVector();
                }
                pl.setVelocity(lookDir.multiply(DashClient.DASH_SPEED));
                SOLID = false;
                MULTI = true;
            } else {
                SOLID = true;
            }
        }

    }

    public static int getLuminance(BlockState currentBlockState) {
        return 15;
    }

    public VoxelShape getOutlineShape(BlockState state, BlockView view, BlockPos pos, ShapeContext context) {
        if (SOLID) {
            return VoxelShapes.cuboid(0.01, 0.01, 0.01, 0.99, 0.99, 0.99);
        } else {
            return VoxelShapes.empty();
        }
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
		return neighborState.isOf(this)
			? state.with(FACING_PROPERTIES.get(direction), false)
			: super.getStateForNeighborUpdate(state, world, tickView, pos, direction, neighborPos, neighborState, random);
	}

    public static BooleanProperty directionProperty(Direction direction) {
        return switch (direction) {
            case UP -> UP;
            case DOWN -> DOWN;
            case NORTH -> NORTH;
            case SOUTH -> SOUTH;
            case EAST -> EAST;
            case WEST -> WEST;
        };
    }

    public static boolean isTouchingDreamBlock(BlockState state, Direction face) {
        return !state.get(directionProperty(face));
    }
}
