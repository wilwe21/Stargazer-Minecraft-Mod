package com.github.wilwe21.gsad.block.custom.random;

import com.github.wilwe21.gsad.Helpers;
import com.mojang.serialization.MapCodec;
import net.minecraft.block.Block;
import net.minecraft.block.BlockState;
import net.minecraft.block.FacingBlock;
import net.minecraft.block.ShapeContext;
import net.minecraft.item.ItemPlacementContext;
import net.minecraft.state.StateManager;
import net.minecraft.state.property.Properties;
import net.minecraft.util.math.BlockPos;
import net.minecraft.util.math.Direction;
import net.minecraft.util.shape.VoxelShape;
import net.minecraft.util.shape.VoxelShapes;
import net.minecraft.world.BlockView;

public class Grave extends FacingBlock {

    public static final MapCodec<Grave> CODEC = Block.createCodec(Grave::new);

    @Override
    protected void appendProperties(StateManager.Builder<Block, BlockState> builder) {
        builder.add(Properties.HORIZONTAL_FACING);
    }

    public Grave(Settings settings) {
        super(settings);
    }

    @Override
    protected MapCodec<? extends Grave> getCodec() {
        return CODEC;
    }

    @Override
    public VoxelShape getOutlineShape(BlockState state, BlockView view, BlockPos pos, ShapeContext context) {
        Direction dir = state.get(Properties.HORIZONTAL_FACING);
        return VoxelShapes.union(
                Helpers.FacingHorizontal(dir, 0.1875F, 0.8125F, 0.875F, 0.8125F, 0.9375F, 1F, true),
                Helpers.FacingHorizontal(dir, 0.125F, 0F, 0.875F, 0.875F, 0.8125F, 1F, true)
        );

    }
    @Override
    public BlockState getPlacementState(ItemPlacementContext ctx) {
        return super.getPlacementState(ctx).with(Properties.HORIZONTAL_FACING, ctx.getHorizontalPlayerFacing().getOpposite());
    }
}
