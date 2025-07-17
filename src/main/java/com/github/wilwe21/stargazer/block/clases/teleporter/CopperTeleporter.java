package com.github.wilwe21.stargazer.block.clases.teleporter;

import com.mojang.serialization.MapCodec;
import net.minecraft.block.Block;
import net.minecraft.block.BlockState;
import net.minecraft.block.BlockWithEntity;
import net.minecraft.block.ShapeContext;
import net.minecraft.block.entity.BlockEntity;
import net.minecraft.fluid.FluidState;
import net.minecraft.fluid.Fluids;
import net.minecraft.item.ItemPlacementContext;
import net.minecraft.state.StateManager;
import net.minecraft.state.property.BooleanProperty;
import net.minecraft.state.property.EnumProperty;
import net.minecraft.state.property.Properties;
import net.minecraft.util.math.BlockPos;
import net.minecraft.util.math.Direction;
import net.minecraft.util.math.random.Random;
import net.minecraft.util.shape.VoxelShape;
import net.minecraft.util.shape.VoxelShapes;
import net.minecraft.world.BlockView;
import net.minecraft.world.WorldView;
import net.minecraft.world.tick.ScheduledTickView;
import org.jetbrains.annotations.Nullable;

import java.util.Map;

public class CopperTeleporter extends BlockWithEntity {
    public static VoxelShape MIDDLESHAPE = VoxelShapes.union(
            VoxelShapes.cuboid(0, 0, 0, 1, 1, 0.0625),
            VoxelShapes.cuboid(0, 0, 0.9375, 1, 1, 1),
            VoxelShapes.cuboid(0, 0, 0.0625, 0.0625, 1, 0.9375),
            VoxelShapes.cuboid(0.9375, 0, 0.0625, 1, 1, 0.9375),
            VoxelShapes.cuboid(0.0625, 0, 0.0625, 0.9375, 0.0625, 0.9375),
            VoxelShapes.cuboid(0.0625, 0.875, 0.0625, 0.9375, 0.9375, 0.9375),
            VoxelShapes.cuboid(0.0625, 0.9375, 0.8125, 0.1875, 1, 0.9375),
            VoxelShapes.cuboid(0.0625, 0.9375, 0.0625, 0.1875, 1, 0.1875),
            VoxelShapes.cuboid(0.8125, 0.9375, 0.0625, 0.9375, 1, 0.1875),
            VoxelShapes.cuboid(0.8125, 0.9375, 0.8125, 0.9375, 1, 0.9375)
    );
    public static VoxelShape CORNERSHAPE = VoxelShapes.union(
            VoxelShapes.cuboid(0, 0, 0, 1, 0.625, 1),
            VoxelShapes.cuboid(0.25, 0.625, 0, 1, 0.9375, 0.75)
    );
    public static VoxelShape SIDESHAPE = VoxelShapes.union(
            VoxelShapes.cuboid(0, 0, 0, 1, 0.3125, 1),
            VoxelShapes.cuboid(0, 0.3125, 0.3125, 1, 0.625, 1),
            VoxelShapes.cuboid(0, 0.625, 0.625, 1, 0.9375, 1)
    );
    public static VoxelShape CORNERTOPSHAPE = VoxelShapes.union(
            VoxelShapes.cuboid(0.6875, -0.0625, 0.1875, 0.8125, 0.875, 0.3125),
            VoxelShapes.cuboid(0.5, 0.875, 0, 1, 1, 0.5)
    );

    public static final EnumProperty<CopperTeleporterState> STATE = EnumProperty.of("state", CopperTeleporterState.class);
    public static final BooleanProperty WATERLOGGED = Properties.WATERLOGGED;

    public CopperTeleporter(Settings settings) {
        super(settings);
        this.setDefaultState(
                this.stateManager.getDefaultState().with(STATE, CopperTeleporterState.middle).with(WATERLOGGED, Boolean.FALSE)
        );
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
        if ((Boolean)state.get(WATERLOGGED)) {
            tickView.scheduleFluidTick(pos, Fluids.WATER, Fluids.WATER.getTickRate(world));
        }

        return state;
    }

    @Override
    protected FluidState getFluidState(BlockState state) {
        return state.get(WATERLOGGED) ? Fluids.WATER.getStill(false) : super.getFluidState(state);
    }

    @Override
    protected VoxelShape getCollisionShape(BlockState state, BlockView world, BlockPos pos, ShapeContext context) {
        return collision(state,world,pos,context);
    }

    @Override
    protected VoxelShape getOutlineShape(BlockState state, BlockView world, BlockPos pos, ShapeContext context) {
        return collision(state,world,pos,context);
    }

    protected VoxelShape collision(BlockState state, BlockView world, BlockPos pos, ShapeContext context) {
        Map<Direction, VoxelShape> SIDEMAP = VoxelShapes.createFacingShapeMap(SIDESHAPE);
        Map<Direction, VoxelShape> CORNERMAP = VoxelShapes.createFacingShapeMap(CORNERSHAPE);
        Map<Direction, VoxelShape> CORNERTOPMAP = VoxelShapes.createFacingShapeMap(CORNERTOPSHAPE);
        if (state.get(STATE).equals(CopperTeleporterState.north)) {
            return SIDEMAP.get(Direction.NORTH);
        }
        if (state.get(STATE).equals(CopperTeleporterState.south)) {
            return SIDEMAP.get(Direction.SOUTH);
        }
        if (state.get(STATE).equals(CopperTeleporterState.east)) {
            return SIDEMAP.get(Direction.EAST);
        }
        if (state.get(STATE).equals(CopperTeleporterState.west)) {
            return SIDEMAP.get(Direction.WEST);
        }
        if (state.get(STATE).equals(CopperTeleporterState.north_east)) {
            return CORNERMAP.get(Direction.NORTH);
        }
        if (state.get(STATE).equals(CopperTeleporterState.north_west)) {
            return CORNERMAP.get(Direction.WEST);
        }
        if (state.get(STATE).equals(CopperTeleporterState.south_east)) {
            return CORNERMAP.get(Direction.EAST);
        }
        if (state.get(STATE).equals(CopperTeleporterState.south_west)) {
            return CORNERMAP.get(Direction.SOUTH);
        }
        if (state.get(STATE).equals(CopperTeleporterState.ne_up)) {
            return CORNERTOPMAP.get(Direction.NORTH);
        }
        if (state.get(STATE).equals(CopperTeleporterState.nw_up)) {
            return CORNERTOPMAP.get(Direction.WEST);
        }
        if (state.get(STATE).equals(CopperTeleporterState.se_up)) {
            return CORNERTOPMAP.get(Direction.EAST);
        }
        if (state.get(STATE).equals(CopperTeleporterState.sw_up)) {
            return CORNERTOPMAP.get(Direction.SOUTH);
        }
        return MIDDLESHAPE;
    }

    @Override
    protected void appendProperties(StateManager.Builder<Block, BlockState> builder) {
        builder.add(STATE, WATERLOGGED);
    }

    @Override
    public BlockState getPlacementState(ItemPlacementContext ctx) {
        FluidState fluidState = ctx.getWorld().getFluidState(ctx.getBlockPos());
        BlockState blockState = this.getDefaultState()
                .with(STATE, CopperTeleporterState.middle)
                .with(WATERLOGGED, Boolean.valueOf(fluidState.getFluid() == Fluids.WATER));
        return blockState;
    }

    @Override
    protected MapCodec<? extends BlockWithEntity> getCodec() {
        return null;
    }

    @Override
    public @Nullable BlockEntity createBlockEntity(BlockPos pos, BlockState state) {
        return null;
    }
}
