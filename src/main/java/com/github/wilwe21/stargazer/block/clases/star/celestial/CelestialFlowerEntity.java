package com.github.wilwe21.stargazer.block.clases.star.celestial;

import com.github.wilwe21.stargazer.block.BlockTypes;
import net.minecraft.block.BlockState;
import net.minecraft.block.entity.BlockEntity;
import net.minecraft.util.math.BlockPos;

public class CelestialFlowerEntity extends BlockEntity {
    public CelestialFlowerEntity(BlockPos pos, BlockState state) {
        super(BlockTypes.CELESTIAL_FLOWER, pos, state);
    }
}
