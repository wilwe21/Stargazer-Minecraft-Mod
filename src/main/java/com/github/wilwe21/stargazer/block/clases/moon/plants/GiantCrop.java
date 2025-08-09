package com.github.wilwe21.stargazer.block.clases.moon.plants;

import com.github.wilwe21.stargazer.block.clases.moon.MoonFarmland;
import com.github.wilwe21.stargazer.block.clases.moon.geode_fruit.GeodeFruitStage;
import com.github.wilwe21.stargazer.block.register.MoonBlocks;
import com.mojang.serialization.MapCodec;
import net.minecraft.block.*;
import net.minecraft.entity.Entity;
import net.minecraft.entity.EntityCollisionHandler;
import net.minecraft.entity.mob.RavagerEntity;
import net.minecraft.item.ItemConvertible;
import net.minecraft.item.ItemStack;
import net.minecraft.item.Items;
import net.minecraft.server.world.ServerWorld;
import net.minecraft.state.StateManager;
import net.minecraft.state.property.EnumProperty;
import net.minecraft.state.property.IntProperty;
import net.minecraft.state.property.Properties;
import net.minecraft.util.math.BlockPos;
import net.minecraft.util.math.MathHelper;
import net.minecraft.util.math.random.Random;
import net.minecraft.util.shape.VoxelShape;
import net.minecraft.world.BlockView;
import net.minecraft.world.GameRules;
import net.minecraft.world.World;
import net.minecraft.world.WorldView;

public class GiantCrop
        extends Block {
    public static final MapCodec<GiantCrop> CODEC = GiantCrop.createCodec(GiantCrop::new);
    public static final EnumProperty<GiantCropSide> SIDE = EnumProperty.of("side", GiantCropSide.class);

    public MapCodec<? extends GiantCrop> getCodec() {
        return CODEC;
    }


    public GiantCrop(Settings settings) {
        super(settings);
    }

    protected ItemConvertible getSeedsItem() {
        return Items.WHEAT_SEEDS;
    }

    @Override
    protected ItemStack getPickStack(WorldView world, BlockPos pos, BlockState state, boolean includeData) {
        return new ItemStack(this.getSeedsItem());
    }

    @Override
    protected void appendProperties(StateManager.Builder<Block, BlockState> builder) {
        builder.add(SIDE);
    }
}