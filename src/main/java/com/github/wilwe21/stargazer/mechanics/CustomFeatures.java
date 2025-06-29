package com.github.wilwe21.stargazer.mechanics;

import com.github.wilwe21.stargazer.Stargazer;
import com.github.wilwe21.stargazer.mechanics.features.TreeConfig;
import com.github.wilwe21.stargazer.mechanics.features.amertylst.Amertylst;
import com.github.wilwe21.stargazer.mechanics.features.amertylst.AmertylstConfig;
import com.github.wilwe21.stargazer.mechanics.features.bones.BoneTrees;
import com.github.wilwe21.stargazer.mechanics.features.curve.CurveTrees;
import com.github.wilwe21.stargazer.mechanics.features.eyeblodbirch.EyeBirchTrees;
import com.github.wilwe21.stargazer.mechanics.features.moon.MoonTrees;
import com.github.wilwe21.stargazer.mechanics.features.purple_shroom.PurpleShrooms;
import com.github.wilwe21.stargazer.mechanics.features.star.StarTrees;
import net.minecraft.registry.Registries;
import net.minecraft.registry.Registry;
import net.minecraft.util.Identifier;
import net.minecraft.world.gen.feature.Feature;

public class CustomFeatures {
    public static final Feature moon_trees = register("moon_trees", new MoonTrees(TreeConfig.CODEC));
    public static final Feature star_trees = register("star_trees", new StarTrees(TreeConfig.CODEC));
    public static final Feature eye_birch_trees = register("eye_birch_trees", new EyeBirchTrees(TreeConfig.CODEC));
    public static final Feature curve_trees = register("curve_trees", new CurveTrees(TreeConfig.CODEC));
    public static final Feature purple_shroom = register("purple_shroom", new PurpleShrooms(TreeConfig.CODEC));
    public static final Feature bone_trees = register("bone_trees", new BoneTrees(TreeConfig.CODEC));
    public static final Feature spike = register("spike", new Amertylst(AmertylstConfig.CODEC));

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
