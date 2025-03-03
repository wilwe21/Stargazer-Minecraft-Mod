package com.github.wilwe21.stargazer.block.clases.moon.star_stone;

import net.minecraft.block.Block;
import net.minecraft.block.BlockState;
import net.minecraft.util.math.BlockPos;
import net.minecraft.util.math.Direction;
import net.minecraft.world.BlockRenderView;
import org.jetbrains.annotations.Nullable;

public class StarStone extends Block {
    public StarStone(Settings settings) {
        super(settings);
    }

    public static int getLuminance(BlockState currentBlockState) {
        return 15;
    }

}
