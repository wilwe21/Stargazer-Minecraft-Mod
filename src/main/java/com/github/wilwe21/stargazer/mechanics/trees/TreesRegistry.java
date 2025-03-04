package com.github.wilwe21.stargazer.mechanics.trees;

import com.github.wilwe21.stargazer.block.ModBlock;
import com.github.wilwe21.stargazer.block.register.MoonBlocks;
import net.minecraft.block.Blocks;

// North negative Z
// South positive Z
// West negative X
// east positive X
public class TreesRegistry {
    public static Tree moon1 = new Tree(true, "moon1", MoonBlocks.MOON_LOG.getDefaultState(), MoonBlocks.MOON_LEAVES.getDefaultState());
    public static Tree moon2 = new Tree(true, "moon2", MoonBlocks.MOON_LOG.getDefaultState(), MoonBlocks.MOON_LEAVES.getDefaultState());
    public static void moon1() {
        moon1.addReplacableBlock(ModBlock.COSMIC_BLOCK);
        moon1.addReplacableBlock(Blocks.AIR);
        moon1.addReplacableBlock(moon1.leave.getBlock());
        // logs
        moon1.addLogPos(0,0,0);
        moon1.addLogPos(0,1,0);
        moon1.addLogPos(0,2,-1);
        moon1.addLogPos(0,3,-1);
        moon1.addLogPos(0,4,-1);
        moon1.addLogPos(0,5,-1);
        // leaves base
        moon1.addLeavesPos(0, 4, 0);
        moon1.addLeavesPos(0, 5, 0);
        moon1.addLeavesPos(1, 4, -1);
        moon1.addLeavesPos(1, 5, -1);
        moon1.addLeavesPos(-1, 4, -1);
        moon1.addLeavesPos(-1, 5, -1);
        moon1.addLeavesPos(0, 4, -2);
        moon1.addLeavesPos(0, 5, -2);
        // leaves top ring 1
        moon1.addLeavesPos(0, 6, -3);
        moon1.addLeavesPos(0, 6, -2);
        moon1.addLeavesPos(0, 6, -1);
        moon1.addLeavesPos(0, 6, 0);
        moon1.addLeavesPos(0, 6, 1);
        moon1.addLeavesPos(-2, 6, -1);
        moon1.addLeavesPos(-1, 6, -1);
        moon1.addLeavesPos(1, 6, -1);
        moon1.addLeavesPos(2, 6, -1);
        moon1.addLeavesPos(1, 6, 0);
        moon1.addLeavesPos(-1, 6, 0);
        moon1.addLeavesPos(1, 6, -2);
        moon1.addLeavesPos(-1, 6, -2);
        // leaves top ring 2
        moon1.addLeavesPos(0, 7, -2);
        moon1.addLeavesPos(0, 7, -1);
        moon1.addLeavesPos(0, 7, 0);
        moon1.addLeavesPos(1, 7, -1);
        moon1.addLeavesPos(-1, 7, -1);
        // top
        moon1.addLeavesPos(0, 8, -1);
    }
    public static void moon2() {
        moon2.addReplacableBlock(ModBlock.COSMIC_BLOCK);
        moon2.addReplacableBlock(Blocks.AIR);
        moon2.addReplacableBlock(moon2.leave.getBlock());
        // logs
        moon2.addLogPos(0,0,0);
        moon2.addLogPos(0,1,0);
        moon2.addLogPos(0,2,0);
        moon2.addLogPos(0,3,-1);
        moon2.addLogPos(0,4,-1);
        moon2.addLogPos(0,5,-1);
        // leaves base
        moon2.addLeavesPos(0, 4, 0);
        moon2.addLeavesPos(0, 5, 0);
        moon2.addLeavesPos(1, 4, -1);
        moon2.addLeavesPos(1, 5, -1);
        moon2.addLeavesPos(-1, 4, -1);
        moon2.addLeavesPos(-1, 5, -1);
        moon2.addLeavesPos(0, 4, -2);
        moon2.addLeavesPos(0, 5, -2);
        // leaves top ring 1
        moon2.addLeavesPos(0, 6, -3);
        moon2.addLeavesPos(0, 6, -2);
        moon2.addLeavesPos(0, 6, -1);
        moon2.addLeavesPos(0, 6, 0);
        moon2.addLeavesPos(0, 6, 1);
        moon2.addLeavesPos(-2, 6, -1);
        moon2.addLeavesPos(-1, 6, -1);
        moon2.addLeavesPos(1, 6, -1);
        moon2.addLeavesPos(2, 6, -1);
        moon2.addLeavesPos(1, 6, 0);
        moon2.addLeavesPos(-1, 6, 0);
        moon2.addLeavesPos(1, 6, -2);
        moon2.addLeavesPos(-1, 6, -2);
        // leaves top ring 2
        moon2.addLeavesPos(0, 7, -2);
        moon2.addLeavesPos(0, 7, -1);
        moon2.addLeavesPos(0, 7, 0);
        moon2.addLeavesPos(1, 7, -1);
        moon2.addLeavesPos(-1, 7, -1);
        // top
        moon2.addLeavesPos(0, 8, -1);

    }
    public static void init() {
        moon1();
        moon2();
    }
}
