package com.github.wilwe21.stargazer.mechanics.features.moon;

import com.github.wilwe21.stargazer.mechanics.features.Tree;

public class MoonBase {
    public static Tree leavepattern = new Tree(false, "moonLeaves");
    public static void leavesInit() {
        // leaves base
        leavepattern.addLeavesPos(0, -2, 1);
        leavepattern.addLeavesPos(0, -1, 1);
        leavepattern.addLeavesPos(1, -2, 0);
        leavepattern.addLeavesPos(1, -1, 0);
        leavepattern.addLeavesPos(-1, -2, 0);
        leavepattern.addLeavesPos(-1, -1, 0);
        leavepattern.addLeavesPos(0, -2, -1);
        leavepattern.addLeavesPos(0, -1, -1);
        // leaves top ring 1
        leavepattern.addLeavesPos(0, 0, -2);
        leavepattern.addLeavesPos(0, 0, -1);
        leavepattern.addLeavesPos(0, 0, 0);
        leavepattern.addLeavesPos(0, 0, 1);
        leavepattern.addLeavesPos(0, 0, 2);
        leavepattern.addLeavesPos(-2, 0, 0);
        leavepattern.addLeavesPos(-1, 0, 0);
        leavepattern.addLeavesPos(1, 0, 0);
        leavepattern.addLeavesPos(2, 0, 0);
        leavepattern.addLeavesPos(1, 0, 1);
        leavepattern.addLeavesPos(-1, 0, 1);
        leavepattern.addLeavesPos(1, 0, -1);
        leavepattern.addLeavesPos(-1, 0, -1);
        // leaves top ring 2
        leavepattern.addLeavesPos(0, 1, -1);
        leavepattern.addLeavesPos(0, 1, 0);
        leavepattern.addLeavesPos(0, 1, 1);
        leavepattern.addLeavesPos(1, 1,  0);
        leavepattern.addLeavesPos(-1, 1, 0);
        // top
        leavepattern.addLeavesPos(0, 2, 0);
    }
}
