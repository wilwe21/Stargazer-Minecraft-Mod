package com.github.wilwe21.stargazer.mechanics.features;

import com.github.wilwe21.stargazer.mechanics.features.curve.CurveTrees;
import com.github.wilwe21.stargazer.mechanics.features.moon.MoonTrees;
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
    }
}
