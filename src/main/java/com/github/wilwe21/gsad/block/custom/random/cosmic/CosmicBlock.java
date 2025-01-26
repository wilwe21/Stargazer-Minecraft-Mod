package com.github.wilwe21.gsad.block.custom.random.cosmic;

import com.mojang.serialization.MapCodec;
import net.minecraft.block.BlockState;
import net.minecraft.block.BlockWithEntity;
import net.minecraft.block.ShapeContext;
import net.minecraft.block.entity.BlockEntity;
import net.minecraft.util.math.BlockPos;
import net.minecraft.util.shape.VoxelShape;
import net.minecraft.util.shape.VoxelShapes;
import net.minecraft.world.BlockView;

public class CosmicBlock extends BlockWithEntity {
    public static boolean SOLID = false;
    @Override
    protected MapCodec<? extends CosmicBlock> getCodec() {
        return createCodec(CosmicBlock::new);
    }

    @Override
    public BlockEntity createBlockEntity(BlockPos pos, BlockState state) {
        return new CosmicBlockEntity(pos, state);
    }

    @Override
    public VoxelShape getOutlineShape(BlockState state, BlockView view, BlockPos pos, ShapeContext context) {
        if (SOLID) {
            return VoxelShapes.fullCube();
        } else {
            return VoxelShapes.empty();
        }
    }

    public CosmicBlock(Settings settings) {
        super(settings.replaceable());
    }
}
