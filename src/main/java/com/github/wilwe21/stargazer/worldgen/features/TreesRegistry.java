package com.github.wilwe21.stargazer.worldgen.features;

import com.github.wilwe21.stargazer.worldgen.features.bones.BoneTrees;
import com.github.wilwe21.stargazer.worldgen.features.curve.CurveTrees;
import com.github.wilwe21.stargazer.worldgen.features.eyeblodbirch.EyeBirchTrees;
import com.github.wilwe21.stargazer.worldgen.features.moon.MoonTrees;
import com.github.wilwe21.stargazer.worldgen.features.prismaticore.PrismaticOre;
import com.github.wilwe21.stargazer.worldgen.features.purple_shroom.PurpleShrooms;
import com.github.wilwe21.stargazer.worldgen.features.star.StarTrees;

// North negative Z
// South positive Z
// West negative X
// east positive X
public class TreesRegistry {
    public static void init() {
        MoonTrees.init();
        StarTrees.init();
        CurveTrees.init();
        PurpleShrooms.init();
        BoneTrees.init();
        EyeBirchTrees.init();
        PrismaticOre.init();
    }
}
