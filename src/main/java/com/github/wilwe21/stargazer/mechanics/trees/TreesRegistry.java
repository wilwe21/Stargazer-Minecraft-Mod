package com.github.wilwe21.stargazer.mechanics.trees;

import com.github.wilwe21.stargazer.block.ModBlock;
import com.github.wilwe21.stargazer.block.register.MoonBlocks;
import com.github.wilwe21.stargazer.mechanics.trees.moon.MoonTree1;
import com.github.wilwe21.stargazer.mechanics.trees.moon.MoonTree2;
import net.minecraft.block.BlockState;
import net.minecraft.block.Blocks;

// North negative Z
// South positive Z
// West negative X
// east positive X
public class TreesRegistry {
    public static void init() {
        MoonTree1.init();
        MoonTree2.init();
    }
}
