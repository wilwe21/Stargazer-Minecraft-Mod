package com.github.wilwe21.stargazer.datagen;

import com.github.wilwe21.stargazer.block.register.MoonBlocks;
import com.github.wilwe21.stargazer.block.register.StarBlocks;
import net.fabricmc.fabric.api.client.datagen.v1.provider.FabricModelProvider;
import net.fabricmc.fabric.api.datagen.v1.FabricDataOutput;
import net.minecraft.client.data.BlockStateModelGenerator;
import net.minecraft.client.data.ItemModelGenerator;
import net.minecraft.client.data.TexturedModel;

public class ModModelProvider extends FabricModelProvider {
    public ModModelProvider(FabricDataOutput output) {
        super(output);
    }

    @Override
    public void generateBlockStateModels(BlockStateModelGenerator blockStateModelGenerator) {
        // planks
        blockStateModelGenerator.registerCubeAllModelTexturePool(MoonBlocks.MOON_PLANKS)
                .stairs(MoonBlocks.MOON_PLANKS_STAIRS)
                .button(MoonBlocks.MOON_PLANKS_BUTTON)
                .fence(MoonBlocks.MOON_PLANKS_FENCE)
                .fenceGate(MoonBlocks.MOON_PLANKS_FENCE_GATE)
                .slab(MoonBlocks.MOON_PLANKS_SLAB);
        blockStateModelGenerator.registerCubeAllModelTexturePool(MoonBlocks.YELLOW_MOON_PLANKS)
                .stairs(MoonBlocks.YELLOW_MOON_PLANKS_STAIRS)
                .button(MoonBlocks.YELLOW_MOON_PLANKS_BUTTON)
                .fence(MoonBlocks.YELLOW_MOON_PLANKS_FENCE)
                .fenceGate(MoonBlocks.YELLOW_MOON_PLANKS_FENCE_GATE)
                .slab(MoonBlocks.YELLOW_MOON_PLANKS_SLAB);
        blockStateModelGenerator.registerCubeAllModelTexturePool(MoonBlocks.BLUE_MOON_PLANKS)
                .stairs(MoonBlocks.BLUE_MOON_PLANKS_STAIRS)
                .button(MoonBlocks.BLUE_MOON_PLANKS_BUTTON)
                .fence(MoonBlocks.BLUE_MOON_PLANKS_FENCE)
                .fenceGate(MoonBlocks.BLUE_MOON_PLANKS_FENCE_GATE)
                .slab(MoonBlocks.BLUE_MOON_PLANKS_SLAB);
        blockStateModelGenerator.registerCubeAllModelTexturePool(MoonBlocks.RED_MOON_PLANKS)
                .stairs(MoonBlocks.RED_MOON_PLANKS_STAIRS)
                .button(MoonBlocks.RED_MOON_PLANKS_BUTTON)
                .fence(MoonBlocks.RED_MOON_PLANKS_FENCE)
                .fenceGate(MoonBlocks.RED_MOON_PLANKS_FENCE_GATE)
                .slab(MoonBlocks.RED_MOON_PLANKS_SLAB);
        blockStateModelGenerator.registerCubeAllModelTexturePool(MoonBlocks.PURPLE_MOON_PLANKS)
                .stairs(MoonBlocks.PURPLE_MOON_PLANKS_STAIRS)
                .button(MoonBlocks.PURPLE_MOON_PLANKS_BUTTON)
                .fence(MoonBlocks.PURPLE_MOON_PLANKS_FENCE)
                .fenceGate(MoonBlocks.PURPLE_MOON_PLANKS_FENCE_GATE)
                .slab(MoonBlocks.PURPLE_MOON_PLANKS_SLAB);
        blockStateModelGenerator.registerCubeAllModelTexturePool(StarBlocks.STAR_PLANKS)
                .stairs(StarBlocks.STAR_PLANKS_STAIRS)
                .button(StarBlocks.STAR_PLANKS_BUTTON)
                .fence(StarBlocks.STAR_PLANKS_FENCE)
                .fenceGate(StarBlocks.STAR_PLANKS_FENCE_GATE)
                .slab(StarBlocks.STAR_PLANKS_SLAB);
        // rock
        blockStateModelGenerator.registerCubeAllModelTexturePool(MoonBlocks.MOON_ROCK);
        blockStateModelGenerator.registerCubeAllModelTexturePool(MoonBlocks.MOON_ROCK_BRICKS)
                .stairs(MoonBlocks.MOON_ROCK_BRICKS_STAIRS)
                .slab(MoonBlocks.MOON_ROCK_BRICKS_SLAB);
        blockStateModelGenerator.registerSimpleCubeAll(MoonBlocks.CHISELED_MOON_ROCK_BRICKS);
        blockStateModelGenerator.registerSimpleCubeAll(MoonBlocks.CRACKED_MOON_ROCK_BRICKS);
        blockStateModelGenerator.registerCubeAllModelTexturePool(MoonBlocks.BLACK_MOON_ROCK);
        // tree
        blockStateModelGenerator.registerSimpleCubeAll(MoonBlocks.MOON_LEAVES);
        blockStateModelGenerator.registerAxisRotated(MoonBlocks.MOON_LOG, TexturedModel.CUBE_COLUMN);
        blockStateModelGenerator.registerAxisRotated(MoonBlocks.STRIPPED_MOON_LOG, TexturedModel.CUBE_COLUMN);
        blockStateModelGenerator.registerAxisRotated(StarBlocks.STAR_LOG, TexturedModel.CUBE_COLUMN);
        blockStateModelGenerator.registerAxisRotated(StarBlocks.STRIPPED_STAR_LOG, TexturedModel.CUBE_COLUMN);
        // saplings
        blockStateModelGenerator.registerTintableCross(MoonBlocks.MOON_SAPLING, BlockStateModelGenerator.CrossType.NOT_TINTED);
        blockStateModelGenerator.registerTintableCross(StarBlocks.STAR_SAPLING, BlockStateModelGenerator.CrossType.NOT_TINTED);
        // flowers
        blockStateModelGenerator.registerTintableCross(StarBlocks.STAR_FLOWER, BlockStateModelGenerator.CrossType.NOT_TINTED);
        blockStateModelGenerator.registerTintableCross(StarBlocks.CELESTIAL_STAR_FLOWER, BlockStateModelGenerator.CrossType.NOT_TINTED);
    }

    @Override
    public void generateItemModels(ItemModelGenerator itemModelGenerator) {

    }
}
