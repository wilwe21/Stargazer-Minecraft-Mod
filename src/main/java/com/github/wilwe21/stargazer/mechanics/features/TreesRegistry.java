package com.github.wilwe21.stargazer.mechanics.features;

import com.github.wilwe21.stargazer.mechanics.features.bones.BoneTrees;
import com.github.wilwe21.stargazer.mechanics.features.curve.CurveTrees;
import com.github.wilwe21.stargazer.mechanics.features.eyeblodbirch.EyeBirchTrees;
import com.github.wilwe21.stargazer.mechanics.features.moon.MoonTrees;
import com.github.wilwe21.stargazer.mechanics.features.purple_shroom.PurpleBase;
import com.github.wilwe21.stargazer.mechanics.features.purple_shroom.PurpleShrooms;
import com.github.wilwe21.stargazer.mechanics.features.star.StarTrees;

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
    }
}
