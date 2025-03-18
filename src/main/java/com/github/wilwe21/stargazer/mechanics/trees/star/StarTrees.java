package com.github.wilwe21.stargazer.mechanics.trees.star;

import java.util.ArrayList;

public class StarTrees {
    public static ArrayList<StarTree> TREELIST = new ArrayList<>();
    public static StarTree treeSmall = register("starSmall", 8);
    public static StarTree treeMid = register("starMid", 10);
    public static StarTree treeHi = register("starHi", 12);
    public static StarTree treeMeg = register("starMeg", 14);
    public static StarTree register(String name, int height) {
        StarTree tre = new StarTree(false, name, height);
        TREELIST.add(tre);
        return tre;
    }
    public static void init() {
        for (StarTree tre : TREELIST) {
            tre.init();
        }
    }
}
