package com.github.wilwe21.stargazer.mechanics.trees.star;

import com.github.wilwe21.stargazer.block.register.StarBlocks;
import com.github.wilwe21.stargazer.mechanics.trees.Tree;
import net.minecraft.block.BlockState;
import net.minecraft.block.Blocks;
import net.minecraft.util.math.Direction;

public class StarTree extends Tree {
    private final int HEIGHT;
    public StarTree(Boolean rotatable, String name, int height) {
        super(rotatable, name, StarBlocks.STAR_LOG.getDefaultState(), StarBlocks.STAR_LEAVES.getDefaultState());
        HEIGHT = height;
    }

    public void addBrandchesType1(int y) {
        this.addLogPos(1,  y, 0);
        this.addLogPos(2, y, 0);
        this.addLogPos(3, y+1, 0);
        this.addLogPos(-1, y, 0);
        this.addLogPos(-2, y, 0);
        this.addLogPos(-3, y+1, 0);
        this.addLogPos(0, y, 1);
        this.addLogPos(0, y, 2);
        this.addLogPos(0, y+1, 3);
        this.addLogPos(0, y, -1);
        this.addLogPos(0, y, -2);
        this.addLogPos(0, y+1, -3);

        // 1 l
        this.addLeavesPos(1, y, 1);
        this.addLeavesPos(2, y, 1);
        this.addLeavesPos(1, y, 2);

        this.addLeavesPos(0, y, 3);
        this.addLeavesPos(0, y, 4);

        this.addLeavesPos(-1, y, 1);
        this.addLeavesPos(-2, y, 1);
        this.addLeavesPos(-1, y, 2);

        this.addLeavesPos(0, y, -3);
        this.addLeavesPos(0, y, -4);

        this.addLeavesPos(1, y, -1);
        this.addLeavesPos(2, y, -1);
        this.addLeavesPos(1, y, -2);

        this.addLeavesPos(3, y, 0);
        this.addLeavesPos(4, y, 0);

        this.addLeavesPos(-1, y, -1);
        this.addLeavesPos(-2, y, -1);
        this.addLeavesPos(-1, y, -2);

        this.addLeavesPos(-3, y, 0);
        this.addLeavesPos(-4, y, 0);

        // 2 l
        this.addLeavesPos(1, y+1, 0);
        this.addLeavesPos(2, y+1, 0);
        this.addLeavesPos(-1, y+1, 0);
        this.addLeavesPos(-2, y+1, 0);
        this.addLeavesPos(0, y+1, 1);
        this.addLeavesPos(0, y+1, 2);
        this.addLeavesPos(0, y+1, -1);
        this.addLeavesPos(0, y+1, -2);
        this.addLeavesPos(4, y+1, 0);
        this.addLeavesPos(5, y+1, 0);
        this.addLeavesPos(-4, y+1, 0);
        this.addLeavesPos(-5, y+1, 0);
        this.addLeavesPos(0, y+1, 4);
        this.addLeavesPos(0, y+1, 5);
        this.addLeavesPos(0, y+1, -4);
        this.addLeavesPos(0, y+1, -5);

        this.addLeavesPos(1, y+1, 1);
        this.addLeavesPos(1, y+1, 2);
        this.addLeavesPos(2, y+1, 1);
        this.addLeavesPos(2, y+1, 2);

        this.addLeavesPos(1, y+1, -1);
        this.addLeavesPos(1, y+1, -2);
        this.addLeavesPos(2, y+1, -1);
        this.addLeavesPos(2, y+1, -2);

        this.addLeavesPos(-1, y+1, 1);
        this.addLeavesPos(-1, y+1, 2);
        this.addLeavesPos(-2, y+1, 1);
        this.addLeavesPos(-2, y+1, 2);

        this.addLeavesPos(-1, y+1, -1);
        this.addLeavesPos(-1, y+1, -2);
        this.addLeavesPos(-2, y+1, -1);
        this.addLeavesPos(-2, y+1, -2);

        this.addLeavesPos(3, y+1, 1);
        this.addLeavesPos(4, y+1, 1);
        this.addLeavesPos(3, y+1, -1);
        this.addLeavesPos(4, y+1, -1);

        this.addLeavesPos(-3, y+1, 1);
        this.addLeavesPos(-4, y+1, 1);
        this.addLeavesPos(-3, y+1, -1);
        this.addLeavesPos(-4, y+1, -1);

        this.addLeavesPos(1, y+1, 3);
        this.addLeavesPos(1, y+1, 4);
        this.addLeavesPos(-1, y+1, 3);
        this.addLeavesPos(-1, y+1, 4);

        this.addLeavesPos(1, y+1, -3);
        this.addLeavesPos(1, y+1, -4);
        this.addLeavesPos(-1, y+1, -3);
        this.addLeavesPos(-1, y+1, -4);

        // 3 l
        this.addLeavesPos(1, y+2, 1);
        this.addLeavesPos(2, y+2, 1);
        this.addLeavesPos(1, y+2, 2);

        this.addLeavesPos(0, y+2, 3);
        this.addLeavesPos(0, y+2, 4);

        this.addLeavesPos(-1, y+2, 1);
        this.addLeavesPos(-2, y+2, 1);
        this.addLeavesPos(-1, y+2, 2);

        this.addLeavesPos(0, y+2, -3);
        this.addLeavesPos(0, y+2, -4);

        this.addLeavesPos(1, y+2, -1);
        this.addLeavesPos(2, y+2, -1);
        this.addLeavesPos(1, y+2, -2);

        this.addLeavesPos(3, y+2, 0);
        this.addLeavesPos(4, y+2, 0);

        this.addLeavesPos(-1, y+2, -1);
        this.addLeavesPos(-2, y+2, -1);
        this.addLeavesPos(-1, y+2, -2);

        this.addLeavesPos(-3, y+2, 0);
        this.addLeavesPos(-4, y+2, 0);

        this.addLeavesPos(1, y+2, 0);
        this.addLeavesPos(2, y+2, 0);
        this.addLeavesPos(-1, y+2, 0);
        this.addLeavesPos(-2, y+2, 0);
        this.addLeavesPos(0, y+2, 1);
        this.addLeavesPos(0, y+2, 2);
        this.addLeavesPos(0, y+2, -1);
        this.addLeavesPos(0, y+2, -2);
    }
    public void addBrandchesType2(int y) {
        this.addLogPos(1, y, 0);
        this.addLogPos(-1, y, 0);
        this.addLogPos(0, y, 1);
        this.addLogPos(0, y, -1);

        // 4 l
        this.addLeavesPos(0, y, 2);
        this.addLeavesPos(0, y, -2);
        this.addLeavesPos(2, y, 0);
        this.addLeavesPos(-2, y, 0);

        this.addLeavesPos(1, y, 1);
        this.addLeavesPos(-1, y, 1);
        this.addLeavesPos(1, y, -1);
        this.addLeavesPos(-1, y, -1);
    }

    public void init() {
        this.addReplacableBlock(StarBlocks.COSMIC_BLOCK);
        this.addReplacableBlock(Blocks.AIR);
        for (BlockState state : this.leave) {
            this.addReplacableBlock(state.getBlock());
        }
        Tree branch = Tree.genBranch(HEIGHT);
        Tree.addBranch(this, branch, Direction.NORTH);

        int y = HEIGHT - 5;
//        this.addBrandchesType1(y);
        if (HEIGHT - 4 > 0) {
            for (int i = 0; i < (HEIGHT-4)/4; i ++) {
                this.addBrandchesType1(y - 3*i);
            }
        }
        this.addBrandchesType2(y+3);

        // top leaves
        // 5/6 l
        this.addLeavesPos(1, y+4, 0);
        this.addLeavesPos(1, y+5, 0);
        this.addLeavesPos(-1, y+4, 0);
        this.addLeavesPos(-1, y+5, 0);
        this.addLeavesPos(0, y+4, 1);
        this.addLeavesPos(0, y+5, 1);
        this.addLeavesPos(0, y+4, -1);
        this.addLeavesPos(0, y+5, -1);

        // 6/y+4/y+5 l
        this.addLeavesPos(0, y+5, 0);
        this.addLeavesPos(0, y+6, 0);
        this.addLeavesPos(0, y+7, 0);
    }
}
