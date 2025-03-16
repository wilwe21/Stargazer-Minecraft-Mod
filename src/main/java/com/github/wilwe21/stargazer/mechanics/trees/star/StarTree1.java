package com.github.wilwe21.stargazer.mechanics.trees.star;

import com.github.wilwe21.stargazer.block.register.StarBlocks;
import com.github.wilwe21.stargazer.mechanics.trees.Tree;
import net.minecraft.block.BlockState;
import net.minecraft.block.Blocks;
import net.minecraft.util.math.Direction;

public class StarTree1 {
    public static Tree tree = new Tree(false, "star", StarBlocks.STAR_LOG.getDefaultState(), StarBlocks.STAR_LEAVES.getDefaultState(), true);
    public static void init() {
        tree.addReplacableBlock(StarBlocks.COSMIC_BLOCK);
        tree.addReplacableBlock(Blocks.AIR);
        for (BlockState state : tree.leave) {
            tree.addReplacableBlock(state.getBlock());
        }
        Tree branch = Tree.genBranch(8);
        Tree.addBranch(tree, branch, Direction.NORTH);
        // 1 ring
        tree.addLogPos(1, 3, 0);
        tree.addLogPos(2, 3, 0);
        tree.addLogPos(3, 4, 0);
        tree.addLogPos(-1, 3, 0);
        tree.addLogPos(-2, 3, 0);
        tree.addLogPos(-3, 4, 0);
        tree.addLogPos(0, 3, 1);
        tree.addLogPos(0, 3, 2);
        tree.addLogPos(0, 4, 3);
        tree.addLogPos(0, 3, -1);
        tree.addLogPos(0, 3, -2);
        tree.addLogPos(0, 4, -3);
        // 2 ring
        tree.addLogPos(1, 6, 0);
        tree.addLogPos(-1, 6, 0);
        tree.addLogPos(0, 6, 1);
        tree.addLogPos(0, 6, -1);
        // 1 l
        tree.addLeavesPos(1, 3, 1);
        tree.addLeavesPos(2, 3, 1);
        tree.addLeavesPos(1, 3, 2);

        tree.addLeavesPos(0, 3, 3);
        tree.addLeavesPos(0, 3, 4);

        tree.addLeavesPos(-1, 3, 1);
        tree.addLeavesPos(-2, 3, 1);
        tree.addLeavesPos(-1, 3, 2);

        tree.addLeavesPos(0, 3, -3);
        tree.addLeavesPos(0, 3, -4);

        tree.addLeavesPos(1, 3, -1);
        tree.addLeavesPos(2, 3, -1);
        tree.addLeavesPos(1, 3, -2);

        tree.addLeavesPos(3, 3, 0);
        tree.addLeavesPos(4, 3, 0);

        tree.addLeavesPos(-1, 3, -1);
        tree.addLeavesPos(-2, 3, -1);
        tree.addLeavesPos(-1, 3, -2);

        tree.addLeavesPos(-3, 3, 0);
        tree.addLeavesPos(-4, 3, 0);

        // 2 l
        tree.addLeavesPos(1, 4, 0);
        tree.addLeavesPos(2, 4, 0);
        tree.addLeavesPos(-1, 4, 0);
        tree.addLeavesPos(-2, 4, 0);
        tree.addLeavesPos(0, 4, 1);
        tree.addLeavesPos(0, 4, 2);
        tree.addLeavesPos(0, 4, -1);
        tree.addLeavesPos(0, 4, -2);
        tree.addLeavesPos(4, 4, 0);
        tree.addLeavesPos(5, 4, 0);
        tree.addLeavesPos(-4, 4, 0);
        tree.addLeavesPos(-5, 4, 0);
        tree.addLeavesPos(0, 4, 4);
        tree.addLeavesPos(0, 4, 5);
        tree.addLeavesPos(0, 4, -4);
        tree.addLeavesPos(0, 4, -5);

        tree.addLeavesPos(1, 4, 1);
        tree.addLeavesPos(1, 4, 2);
        tree.addLeavesPos(2, 4, 1);
        tree.addLeavesPos(2, 4, 2);

        tree.addLeavesPos(1, 4, -1);
        tree.addLeavesPos(1, 4, -2);
        tree.addLeavesPos(2, 4, -1);
        tree.addLeavesPos(2, 4, -2);

        tree.addLeavesPos(-1, 4, 1);
        tree.addLeavesPos(-1, 4, 2);
        tree.addLeavesPos(-2, 4, 1);
        tree.addLeavesPos(-2, 4, 2);

        tree.addLeavesPos(-1, 4, -1);
        tree.addLeavesPos(-1, 4, -2);
        tree.addLeavesPos(-2, 4, -1);
        tree.addLeavesPos(-2, 4, -2);

        tree.addLeavesPos(3, 4, 1);
        tree.addLeavesPos(4, 4, 1);
        tree.addLeavesPos(3, 4, -1);
        tree.addLeavesPos(4, 4, -1);

        tree.addLeavesPos(-3, 4, 1);
        tree.addLeavesPos(-4, 4, 1);
        tree.addLeavesPos(-3, 4, -1);
        tree.addLeavesPos(-4, 4, -1);

        tree.addLeavesPos(1, 4, 3);
        tree.addLeavesPos(1, 4, 4);
        tree.addLeavesPos(-1, 4, 3);
        tree.addLeavesPos(-1, 4, 4);

        tree.addLeavesPos(1, 4, -3);
        tree.addLeavesPos(1, 4, -4);
        tree.addLeavesPos(-1, 4, -3);
        tree.addLeavesPos(-1, 4, -4);

        // 3 l
        tree.addLeavesPos(1, 5, 1);
        tree.addLeavesPos(2, 5, 1);
        tree.addLeavesPos(1, 5, 2);

        tree.addLeavesPos(0, 5, 3);
        tree.addLeavesPos(0, 5, 4);

        tree.addLeavesPos(-1, 5, 1);
        tree.addLeavesPos(-2, 5, 1);
        tree.addLeavesPos(-1, 5, 2);

        tree.addLeavesPos(0, 5, -3);
        tree.addLeavesPos(0, 5, -4);

        tree.addLeavesPos(1, 5, -1);
        tree.addLeavesPos(2, 5, -1);
        tree.addLeavesPos(1, 5, -2);

        tree.addLeavesPos(3, 5, 0);
        tree.addLeavesPos(4, 5, 0);

        tree.addLeavesPos(-1, 5, -1);
        tree.addLeavesPos(-2, 5, -1);
        tree.addLeavesPos(-1, 5, -2);

        tree.addLeavesPos(-3, 5, 0);
        tree.addLeavesPos(-4, 5, 0);

        tree.addLeavesPos(1, 5, 0);
        tree.addLeavesPos(2, 5, 0);
        tree.addLeavesPos(-1, 5, 0);
        tree.addLeavesPos(-2, 5, 0);
        tree.addLeavesPos(0, 5, 1);
        tree.addLeavesPos(0, 5, 2);
        tree.addLeavesPos(0, 5, -1);
        tree.addLeavesPos(0, 5, -2);

        // 4 l
        tree.addLeavesPos(0, 6, 2);
        tree.addLeavesPos(0, 6, -2);
        tree.addLeavesPos(2, 6, 0);
        tree.addLeavesPos(-2, 6, 0);

        tree.addLeavesPos(1, 6, 1);
        tree.addLeavesPos(-1, 6, 1);
        tree.addLeavesPos(1, 6, -1);
        tree.addLeavesPos(-1, 6, -1);

        // 5/6 l
        tree.addLeavesPos(1, 7, 0);
        tree.addLeavesPos(1, 8, 0);
        tree.addLeavesPos(-1, 7, 0);
        tree.addLeavesPos(-1, 8, 0);
        tree.addLeavesPos(0, 7, 1);
        tree.addLeavesPos(0, 8, 1);
        tree.addLeavesPos(0, 7, -1);
        tree.addLeavesPos(0, 8, -1);

        // 6/7/8 l
        tree.addLeavesPos(0, 8, 0);
        tree.addLeavesPos(0, 9, 0);
        tree.addLeavesPos(0, 10, 0);
    }
}
