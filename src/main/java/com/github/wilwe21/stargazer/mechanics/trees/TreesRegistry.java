package com.github.wilwe21.stargazer.mechanics.trees;

import com.github.wilwe21.stargazer.mechanics.trees.moon.MoonTrees;
import com.github.wilwe21.stargazer.mechanics.trees.star.StarTrees;

// North negative Z
// South positive Z
// West negative X
// east positive X
public class TreesRegistry {
    public static void init() {
        MoonTrees.init();
        StarTrees.init();
    }
}
