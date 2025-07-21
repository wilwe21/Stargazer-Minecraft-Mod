package com.github.wilwe21.stargazer.block.clases.moon.geode_fruit;

import com.github.wilwe21.stargazer.block.register.MoonBlocks;
import net.minecraft.block.Block;
import net.minecraft.block.BlockState;
import net.minecraft.block.Blocks;
import net.minecraft.block.ShapeContext;
import net.minecraft.registry.tag.BlockTags;
import net.minecraft.state.StateManager;
import net.minecraft.state.property.EnumProperty;
import net.minecraft.util.math.BlockPos;
import net.minecraft.util.math.Direction;
import net.minecraft.util.math.random.Random;
import net.minecraft.util.shape.VoxelShape;
import net.minecraft.util.shape.VoxelShapes;
import net.minecraft.world.BlockView;
import net.minecraft.world.WorldView;
import net.minecraft.world.tick.ScheduledTickView;

import java.util.List;
import java.util.Map;

public class GeodeFruit extends Block {
    public static final EnumProperty<GeodeFruitStage> STAGE = EnumProperty.of("stage", GeodeFruitStage.class);
    public static final EnumProperty<Direction> FACING = EnumProperty.of("facing", Direction.class, List.of(
            Direction.NORTH,
            Direction.SOUTH,
            Direction.EAST,
            Direction.WEST
    ));

    public static VoxelShape stage1Shape = VoxelShapes.union(
            VoxelShapes.cuboid(0.4375, 0.875, 0.4375, 0.5625, 1, 0.5625)
    );
    public static VoxelShape stage2Shape = VoxelShapes.union(
            VoxelShapes.cuboid(0.4375, 0.75, 0.4375, 0.5625, 1, 0.5625)
    );
    public static VoxelShape stage3Shape = VoxelShapes.union(
            VoxelShapes.cuboid(0.375, 0.625, 0.375, 0.625, 1, 0.625)
    );
    public static VoxelShape stage4Shape = VoxelShapes.union(
            VoxelShapes.cuboid(0.36875, 0.84375, 0.375, 0.53125, 0.90625, 0.625),
            VoxelShapes.cuboid(0.34375, 0.78125, 0.375, 0.625, 0.84375, 0.625),
            VoxelShapes.cuboid(0.31875, 0.71875, 0.375, 0.6125, 0.78125, 0.625),
            VoxelShapes.cuboid(0.2875, 0.65625, 0.375, 0.5875, 0.71875, 0.625),
            VoxelShapes.cuboid(0.26250000000000007, 0.59375, 0.375, 0.5625000000000001, 0.65625, 0.625),
            VoxelShapes.cuboid(0.25000000000000006, 0.53125, 0.375, 0.5312500000000002, 0.59375, 0.625),
            VoxelShapes.cuboid(0.33125000000000004, 0.46875, 0.375, 0.5062500000000002, 0.53125, 0.625)
    );

    public GeodeFruit(Settings settings) {
        super(settings);
        this.setDefaultState(this.getDefaultState().with(STAGE, GeodeFruitStage.start).with(FACING, Direction.NORTH));
    }

    @Override
    protected VoxelShape getOutlineShape(BlockState state, BlockView world, BlockPos pos, ShapeContext context) {
        return getCollisionShape(state, world, pos, context);
    }

    @Override
    protected VoxelShape getCollisionShape(BlockState state, BlockView world, BlockPos pos, ShapeContext context) {
        Map<Direction, VoxelShape> S4MAP = VoxelShapes.createFacingShapeMap(stage4Shape);
        if (state.get(STAGE).equals(GeodeFruitStage.start)) {
            return stage1Shape;
        } else if (state.get(STAGE).equals(GeodeFruitStage.middle)) {
            return stage2Shape;
        } else if (state.get(STAGE).equals(GeodeFruitStage.ending)) {
            return stage3Shape;
        } else {
            return S4MAP.get(state.get(FACING));
        }
    }

    @Override
    protected boolean canPlaceAt(BlockState state, WorldView world, BlockPos pos) {
        BlockPos blockPos = pos.up();
        BlockState blockState = world.getBlockState(blockPos);
        return blockState.isSideSolidFullSquare(world, blockPos, Direction.DOWN) || blockState.isIn(BlockTags.LEAVES);
    }

    @Override
    protected BlockState getStateForNeighborUpdate(BlockState state, WorldView world, ScheduledTickView tickView, BlockPos pos, Direction direction, BlockPos neighborPos, BlockState neighborState, Random random) {
        if (direction == Direction.UP && !this.canPlaceAt(state, world, pos)) {
            return Blocks.AIR.getDefaultState();
        }
        return super.getStateForNeighborUpdate(state, world, tickView, pos, direction, neighborPos, neighborState, random);
    }

    @Override
    protected void appendProperties(StateManager.Builder<Block, BlockState> builder) {
        super.appendProperties(builder);
        builder.add(STAGE);
        builder.add(FACING);
    }
}
