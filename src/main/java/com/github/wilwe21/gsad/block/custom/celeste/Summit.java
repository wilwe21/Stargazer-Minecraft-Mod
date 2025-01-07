package com.github.wilwe21.gsad.block.custom.celeste;

import net.minecraft.block.Block;
import net.minecraft.block.BlockState;
import net.minecraft.block.ShapeContext;
import net.minecraft.util.math.BlockPos;
import net.minecraft.util.shape.VoxelShape;
import net.minecraft.util.shape.VoxelShapes;
import net.minecraft.world.BlockView;

// TEMP

public class Summit extends Block {
    public Summit(Settings settings) {
        super(settings);
    }

    @Override
    public VoxelShape getOutlineShape(BlockState state, BlockView view, BlockPos pos, ShapeContext context) {
        return VoxelShapes.union(
                VoxelShapes.cuboid(0.4375, -1, 0.4375, 0.5625, 2, 0.5625),
                VoxelShapes.cuboid(-1, 0.875, 0.4375, 0.4375, 2, 0.5625)
        );

    }
}
