package com.github.wilwe21.stargazer.mechanics.features;

import com.github.wilwe21.stargazer.Stargazer;
import net.fabricmc.fabric.api.biome.v1.BiomeModifications;
import net.fabricmc.fabric.api.biome.v1.BiomeSelectors;
import net.minecraft.registry.RegistryKey;
import net.minecraft.registry.RegistryKeys;
import net.minecraft.util.Identifier;
import net.minecraft.world.gen.GenerationStep;
import net.minecraft.world.gen.feature.PlacedFeature;

public class PlacedFeatures {
    public static final RegistryKey<PlacedFeature> MOON_TREES = RegistryKey.of(
            RegistryKeys.PLACED_FEATURE,
            Identifier.of(Stargazer.MOD_ID, "moon_trees")
    );

    public static void init() {
//        BiomeModifications.addFeature(
//                BiomeSelectors.all(), // Or use BiomeSelectors.includeByKey(Biomes.PLAINS)
//                GenerationStep.Feature.VEGETAL_DECORATION, // The Step
//                MOON_TREES // The Registry Key
//        );
    }
}
