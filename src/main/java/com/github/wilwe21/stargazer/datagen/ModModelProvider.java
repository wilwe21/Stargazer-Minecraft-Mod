package com.github.wilwe21.stargazer.datagen;

import com.github.wilwe21.stargazer.block.ModBlock;
import com.github.wilwe21.stargazer.block.clases.moon.plants.MoonCrop;
import com.github.wilwe21.stargazer.block.register.Crops;
import com.github.wilwe21.stargazer.block.register.EyeBloodBlocks;
import com.github.wilwe21.stargazer.block.register.MoonBlocks;
import com.github.wilwe21.stargazer.block.register.StarBlocks;
import com.github.wilwe21.stargazer.item.ModItems;
import net.fabricmc.fabric.api.client.datagen.v1.provider.FabricModelProvider;
import net.fabricmc.fabric.api.datagen.v1.FabricDataOutput;
import net.minecraft.client.data.*;
import net.minecraft.client.render.item.property.bool.BooleanProperty;

public class ModModelProvider extends FabricModelProvider {
    public ModModelProvider(FabricDataOutput output) {
        super(output);
    }

    @Override
    public void generateBlockStateModels(BlockStateModelGenerator blockStateModelGenerator) {
        blockStateModelGenerator.registerSimpleCubeAll(ModBlock.BONE_LEAVES);
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
        // STAR
        blockStateModelGenerator.registerCubeAllModelTexturePool(StarBlocks.STAR_PLANKS)
                .stairs(StarBlocks.STAR_PLANKS_STAIRS)
                .button(StarBlocks.STAR_PLANKS_BUTTON)
                .fence(StarBlocks.STAR_PLANKS_FENCE)
                .fenceGate(StarBlocks.STAR_PLANKS_FENCE_GATE)
                .slab(StarBlocks.STAR_PLANKS_SLAB);
        // CURVE
        blockStateModelGenerator.registerCubeAllModelTexturePool(MoonBlocks.CURVE_PLANKS)
                .stairs(MoonBlocks.CURVE_PLANKS_STAIRS)
                .button(MoonBlocks.CURVE_PLANKS_BUTTON)
                .fence(MoonBlocks.CURVE_PLANKS_FENCE)
                .fenceGate(MoonBlocks.CURVE_PLANKS_FENCE_GATE)
                .slab(MoonBlocks.CURVE_PLANKS_SLAB);
        // rock
        blockStateModelGenerator.registerCubeAllModelTexturePool(MoonBlocks.MOON_ROCK);
        blockStateModelGenerator.registerCubeAllModelTexturePool(MoonBlocks.POLISHED_MOON_ROCK);
        blockStateModelGenerator.registerCubeAllModelTexturePool(MoonBlocks.MOON_ROCK_BRICKS)
                .stairs(MoonBlocks.MOON_ROCK_BRICKS_STAIRS)
                .slab(MoonBlocks.MOON_ROCK_BRICKS_SLAB);
        blockStateModelGenerator.registerSimpleCubeAll(MoonBlocks.CHISELED_MOON_ROCK_BRICKS);
        blockStateModelGenerator.registerSimpleCubeAll(MoonBlocks.CRACKED_MOON_ROCK_BRICKS);
        blockStateModelGenerator.registerCubeAllModelTexturePool(MoonBlocks.BLACK_MOON_ROCK);
        blockStateModelGenerator.registerCubeAllModelTexturePool(MoonBlocks.POLISHED_BLACK_MOON_ROCK);
        blockStateModelGenerator.registerCubeAllModelTexturePool(MoonBlocks.POLISHED_BLACK_MOON_ROCK_PURPLE);
        blockStateModelGenerator.registerCubeAllModelTexturePool(MoonBlocks.PRISMATIC_ORE);
        // tree
        blockStateModelGenerator.registerSimpleCubeAll(MoonBlocks.MOON_LEAVES);
        blockStateModelGenerator.registerAxisRotated(MoonBlocks.MOON_LOG, TexturedModel.CUBE_COLUMN);
        blockStateModelGenerator.registerAxisRotated(MoonBlocks.STRIPPED_MOON_LOG, TexturedModel.CUBE_COLUMN);
        blockStateModelGenerator.registerAxisRotated(MoonBlocks.CURVE_LOG, TexturedModel.CUBE_COLUMN);
        blockStateModelGenerator.registerAxisRotated(MoonBlocks.STRIPPED_CURVE_LOG, TexturedModel.CUBE_COLUMN);
        blockStateModelGenerator.registerSimpleCubeAll(MoonBlocks.CURVE_LEAVES);
        blockStateModelGenerator.registerAxisRotated(StarBlocks.STAR_LOG, TexturedModel.CUBE_COLUMN);
        blockStateModelGenerator.registerAxisRotated(StarBlocks.STRIPPED_STAR_LOG, TexturedModel.CUBE_COLUMN);
        // Eye blood
        blockStateModelGenerator.registerAxisRotated(EyeBloodBlocks.STRIPPED_EYE_LOG, TexturedModel.CUBE_COLUMN);
        blockStateModelGenerator.registerSimpleCubeAll(EyeBloodBlocks.EYE_LEAVES);
        // mushroom
        blockStateModelGenerator.registerTintableCross(MoonBlocks.PURPLE_MUSHROOM, BlockStateModelGenerator.CrossType.NOT_TINTED);
        blockStateModelGenerator.registerMushroomBlock(MoonBlocks.PURPLE_MUSHROOM_BLOCK);
        // saplings
        blockStateModelGenerator.registerTintableCross(MoonBlocks.MOON_SAPLING, BlockStateModelGenerator.CrossType.NOT_TINTED);
        blockStateModelGenerator.registerTintableCross(MoonBlocks.CURVE_SAPLING, BlockStateModelGenerator.CrossType.NOT_TINTED);
        blockStateModelGenerator.registerTintableCross(StarBlocks.STAR_SAPLING, BlockStateModelGenerator.CrossType.NOT_TINTED);
        // flowers
        blockStateModelGenerator.registerTintableCross(StarBlocks.STAR_FLOWER, BlockStateModelGenerator.CrossType.NOT_TINTED);
        blockStateModelGenerator.registerTintableCross(StarBlocks.CELESTIAL_STAR_FLOWER, BlockStateModelGenerator.CrossType.NOT_TINTED);
        blockStateModelGenerator.registerTintableCross(MoonBlocks.MOON_GRASS, BlockStateModelGenerator.CrossType.NOT_TINTED);
        blockStateModelGenerator.registerDoubleBlock(MoonBlocks.TALL_MOON_GRASS, BlockStateModelGenerator.CrossType.NOT_TINTED);
        blockStateModelGenerator.registerTintableCross(MoonBlocks.MOON_FERN, BlockStateModelGenerator.CrossType.NOT_TINTED);
        // crops
        blockStateModelGenerator.registerCrop(Crops.DRAGON_CARROT_BLOCK, MoonCrop.AGE, 0, 1, 2, 3, 4, 5, 6, 7);
    }

    @Override
    public void generateItemModels(ItemModelGenerator itemModelGenerator) {
        itemModelGenerator.register(ModItems.LODESTAR, Models.GENERATED);
        itemModelGenerator.register(ModItems.STARDUST, Models.GENERATED);
        itemModelGenerator.register(ModItems.GEODE_FRUIT, Models.GENERATED);
        itemModelGenerator.register(ModItems.BLUE_STAR);
        itemModelGenerator.register(ModItems.RED_STAR);
        itemModelGenerator.register(ModItems.YELLOW_STAR);
        itemModelGenerator.register(ModItems.PURPLE_STAR);
        itemModelGenerator.register(MoonBlocks.TALL_MOON_GRASS.asItem(), Models.GENERATED);

        itemModelGenerator.register(ModItems.PRISMATIC_SHARD, Models.GENERATED);

        // Spawn Eggs
        itemModelGenerator.register(ModItems.GHOST_SPAWN_EGG, Models.GENERATED);
        itemModelGenerator.register(ModItems.AMETHYST_TURTLE_SPAWN_EGG, Models.GENERATED);
        itemModelGenerator.register(ModItems.EYE_BAT_SPAWN_EGG, Models.GENERATED);
    }
}
