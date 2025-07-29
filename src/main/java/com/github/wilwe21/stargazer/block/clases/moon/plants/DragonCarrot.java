package com.github.wilwe21.stargazer.block.clases.moon.plants;

import com.github.wilwe21.stargazer.block.register.Crops;
import com.mojang.serialization.MapCodec;
import net.minecraft.block.*;
import net.minecraft.item.ItemConvertible;
import net.minecraft.util.math.BlockPos;
import net.minecraft.util.shape.VoxelShape;
import net.minecraft.world.BlockView;

public class DragonCarrot extends MoonCrop{
    public static final MapCodec<DragonCarrot> CODEC = DragonCarrot.createCodec(DragonCarrot::new);
    private static final VoxelShape[] SHAPES_BY_AGE = Block.createShapeArray(7, age -> Block.createColumnShape(16.0, 0.0, 2 + age));

    public MapCodec<DragonCarrot> getCodec() {
        return CODEC;
    }

    public DragonCarrot(AbstractBlock.Settings settings) {
        super(settings);
    }

    @Override
    protected ItemConvertible getSeedsItem() {
        return Crops.DRAGON_CARROT;
    }

    @Override
    protected VoxelShape getOutlineShape(BlockState state, BlockView world, BlockPos pos, ShapeContext context) {
        return SHAPES_BY_AGE[this.getAge(state)];
    }
}
