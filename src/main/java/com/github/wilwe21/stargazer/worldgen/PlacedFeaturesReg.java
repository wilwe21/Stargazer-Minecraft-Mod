package com.github.wilwe21.stargazer.worldgen;

import com.github.wilwe21.stargazer.Stargazer;
import net.minecraft.registry.RegistryKey;
import net.minecraft.registry.RegistryKeys;
import net.minecraft.util.Identifier;
import net.minecraft.world.gen.feature.PlacedFeature;

public class PlacedFeaturesReg {
    public static RegistryKey<PlacedFeature> MOON_TREES = register("moon_trees");

    public static RegistryKey<PlacedFeature> register(String name) {
        return RegistryKey.of(RegistryKeys.PLACED_FEATURE, Identifier.of(Stargazer.MOD_ID, name));
    }
    public static void init() {}
}
