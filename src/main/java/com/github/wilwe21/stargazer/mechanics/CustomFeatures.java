package com.github.wilwe21.stargazer.mechanics;

import com.github.wilwe21.stargazer.Stargazer;
import com.github.wilwe21.stargazer.mechanics.trees.moon.MoonTrees;
import com.github.wilwe21.stargazer.mechanics.trees.star.StarTrees;
import net.minecraft.registry.Registries;
import net.minecraft.registry.Registry;
import net.minecraft.util.Identifier;
import net.minecraft.world.gen.feature.DefaultFeatureConfig;
import net.minecraft.world.gen.feature.Feature;

public class CustomFeatures {
    public static final Feature moon_trees = register("moon_trees", new MoonTrees(DefaultFeatureConfig.CODEC));
    public static final Feature star_trees = register("star_trees", new StarTrees(DefaultFeatureConfig.CODEC));

    public static Feature register(String id, Feature<?> entry) {
        return Registry.register(
                Registries.FEATURE,
                Identifier.of(Stargazer.MOD_ID, id),
                entry
        );
    }

    public static void init() {
    }
}
