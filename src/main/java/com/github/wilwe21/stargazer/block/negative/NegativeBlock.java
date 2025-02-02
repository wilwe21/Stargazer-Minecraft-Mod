package com.github.wilwe21.stargazer.block.negative;

import com.mojang.serialization.MapCodec;
import net.minecraft.block.*;
import net.minecraft.block.entity.BlockEntity;
import net.minecraft.util.math.BlockPos;
import net.minecraft.util.shape.VoxelShape;
import net.minecraft.util.shape.VoxelShapes;
import net.minecraft.world.BlockView;

public class NegativeBlock extends BlockWithEntity {
    public static boolean SOLID = false;
    @Override
    protected MapCodec<? extends NegativeBlock> getCodec() {
        return createCodec(NegativeBlock::new);
    }

    @Override
    public BlockEntity createBlockEntity(BlockPos pos, BlockState state) {
        return new NegativeBlockEntity(pos, state);
    }

    @Override
    public VoxelShape getOutlineShape(BlockState state, BlockView view, BlockPos pos, ShapeContext context) {
        if (SOLID) {
            return VoxelShapes.fullCube();
        } else {
            return VoxelShapes.empty();
        }
    }

    public NegativeBlock(Settings settings) {
        super(settings.replaceable());
    }
}
