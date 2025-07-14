package com.github.wilwe21.stargazer.block.clases.teleporter;

import com.github.wilwe21.stargazer.block.BlockTypes;
import net.minecraft.block.BlockState;
import net.minecraft.block.entity.BlockEntity;
import net.minecraft.util.math.BlockPos;

public class CopperTeleporterEntity extends BlockEntity {
    public CopperTeleporterEntity(BlockPos pos, BlockState state) {
        super(BlockTypes.COPPER_TELEPORTER, pos, state);
    }
}
