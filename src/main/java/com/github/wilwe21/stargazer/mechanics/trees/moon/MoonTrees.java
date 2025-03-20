package com.github.wilwe21.stargazer.mechanics.trees.moon;

import com.github.wilwe21.stargazer.block.register.MoonBlocks;
import com.github.wilwe21.stargazer.mechanics.trees.Tree;

import java.util.ArrayList;

public class MoonTrees {
    public static ArrayList<Tree> TREELIST = new ArrayList<>();
    public static Tree SmallMoon = register("SmallMoon");
    public static Tree HiMoon = register("HiMoon");
    public static Tree DoubleMoon = register("DoubleMoon");
    public static Tree register(String name) {
        Tree tree = new Tree(true, name, MoonBlocks.MOON_LOG.getDefaultState(), MoonBlocks.MOON_LEAVES.getDefaultState());
        TREELIST.add(tree);
        return tree;
    }
    public static void init() {
        MoonBase.leavesInit();
        MoonTree1.init(SmallMoon);
        MoonTree2.init(HiMoon);
        MoonTree3.init(DoubleMoon);
    }
}
