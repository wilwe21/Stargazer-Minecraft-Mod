package com.github.wilwe21.stargazer.mechanics;

import com.github.wilwe21.stargazer.Stargazer;
import com.github.wilwe21.stargazer.mechanics.trees.moon.MoonTrees;
import com.github.wilwe21.stargazer.mechanics.trees.moon.MoonTreesConfig;
import net.minecraft.registry.Registries;
import net.minecraft.registry.Registry;
import net.minecraft.util.Identifier;
import net.minecraft.world.gen.feature.Feature;
import net.minecraft.world.gen.feature.GeodeFeature;

public class CustomFeatures {
    public static final Feature star_trees = register("moon_trees", new MoonTrees(MoonTreesConfig.CODEC));

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
