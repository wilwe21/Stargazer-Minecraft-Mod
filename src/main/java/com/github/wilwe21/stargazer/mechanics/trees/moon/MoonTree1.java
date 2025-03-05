package com.github.wilwe21.stargazer.mechanics.trees.moon;

import com.github.wilwe21.stargazer.block.ModBlock;
import com.github.wilwe21.stargazer.block.register.MoonBlocks;
import com.github.wilwe21.stargazer.mechanics.trees.Tree;
import net.minecraft.block.BlockState;
import net.minecraft.block.Blocks;

public class MoonTree1 {
    public static Tree tree = new Tree(true, "moon1", MoonBlocks.MOON_LOG.getDefaultState(), MoonBlocks.MOON_LEAVES.getDefaultState());
    public static void init() {
        tree.addReplacableBlock(ModBlock.COSMIC_BLOCK);
        tree.addReplacableBlock(Blocks.AIR);
        for (BlockState state : tree.leave) {
            tree.addReplacableBlock(state.getBlock());
        }
        // logs
        tree.addLogPos(0,0,0);
        tree.addLogPos(0,1,0);
        tree.addLogPos(0,2,-1);
        tree.addLogPos(0,3,-1);
        tree.addLogPos(0,4,-1);
        tree.addLogPos(0,5,-1);
        // leaves base
        tree.addLeavesPos(0, 4, 0);
        tree.addLeavesPos(0, 5, 0);
        tree.addLeavesPos(1, 4, -1);
        tree.addLeavesPos(1, 5, -1);
        tree.addLeavesPos(-1, 4, -1);
        tree.addLeavesPos(-1, 5, -1);
        tree.addLeavesPos(0, 4, -2);
        tree.addLeavesPos(0, 5, -2);
        // leaves top ring 1
        tree.addLeavesPos(0, 6, -3);
        tree.addLeavesPos(0, 6, -2);
        tree.addLeavesPos(0, 6, -1);
        tree.addLeavesPos(0, 6, 0);
        tree.addLeavesPos(0, 6, 1);
        tree.addLeavesPos(-2, 6, -1);
        tree.addLeavesPos(-1, 6, -1);
        tree.addLeavesPos(1, 6, -1);
        tree.addLeavesPos(2, 6, -1);
        tree.addLeavesPos(1, 6, 0);
        tree.addLeavesPos(-1, 6, 0);
        tree.addLeavesPos(1, 6, -2);
        tree.addLeavesPos(-1, 6, -2);
        // leaves top ring 2
        tree.addLeavesPos(0, 7, -2);
        tree.addLeavesPos(0, 7, -1);
        tree.addLeavesPos(0, 7, 0);
        tree.addLeavesPos(1, 7, -1);
        tree.addLeavesPos(-1, 7, -1);
        // top
        tree.addLeavesPos(0, 8, -1);
    }
}
