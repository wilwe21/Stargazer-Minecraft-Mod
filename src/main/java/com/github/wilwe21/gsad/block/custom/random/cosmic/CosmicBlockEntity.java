package com.github.wilwe21.gsad.block.custom.random.cosmic;

import com.github.wilwe21.gsad.block.BlockTypes;
import net.minecraft.block.BlockState;
import net.minecraft.block.entity.BlockEntity;
import net.minecraft.util.math.BlockPos;

public class CosmicBlockEntity extends BlockEntity {
    public CosmicBlockEntity(BlockPos pos, BlockState state) {
        super(BlockTypes.COSMIC_BLOCK, pos, state);
    }
}
