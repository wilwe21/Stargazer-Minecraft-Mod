package com.github.wilwe21.stargazer.mechanics.trees;

import com.github.wilwe21.stargazer.mechanics.trees.moon.MoonBase;
import com.github.wilwe21.stargazer.mechanics.trees.moon.MoonTree1;
import com.github.wilwe21.stargazer.mechanics.trees.moon.MoonTree2;
import com.github.wilwe21.stargazer.mechanics.trees.moon.MoonTree3;
import com.github.wilwe21.stargazer.mechanics.trees.star.StarTrees;

// North negative Z
// South positive Z
// West negative X
// east positive X
public class TreesRegistry {
    public static void init() {
        MoonBase.leavesInit();
        MoonTree1.init();
        MoonTree2.init();
        MoonTree3.init();
        StarTrees.init();
    }
}
