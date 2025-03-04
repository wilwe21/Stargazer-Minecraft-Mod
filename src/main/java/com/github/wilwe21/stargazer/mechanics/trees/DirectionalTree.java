package com.github.wilwe21.stargazer.mechanics.trees;

import com.github.wilwe21.stargazer.block.register.MoonBlocks;
import com.google.common.collect.ImmutableList;
import net.minecraft.util.math.BlockPos;
import net.minecraft.util.math.Direction;

import java.util.ArrayList;
import java.util.List;

// North negative Z
// South positive Z
// West negative X
// east positive X
public class DirectionalTree {
    public static List<BlockPos> logs;
    public static List<BlockPos> leaves;
    public static Tree getFromNorth(Tree tree, Direction want) {
        logs = new ArrayList<>();
        leaves = new ArrayList<>();
        if (want.equals(Direction.SOUTH)) {
            for (BlockPos pos : tree.logs) {
                if (!(pos.getZ() == 0 && pos.getX() == 0)) {
                    BlockPos newPos = pos.offset(Direction.SOUTH, 2);
                    logs.add(newPos);
                } else {
                    logs.add(pos);
                }
            }
            for (BlockPos pos : tree.leaves) {
                BlockPos newPos = pos.offset(Direction.SOUTH, 2);
                leaves.add(newPos);
            }
            Tree tre = new Tree(false, tree.name+"SOUTH", tree.log, tree.leave);
            tre.addLogPos(logs);
            tre.addLeavesPos(leaves);
            return tre;
        }
        if (want.equals(Direction.WEST)) {
            for (BlockPos pos : tree.logs) {
                if (!(pos.getZ() == 0 && pos.getX() == 0)) {
                    BlockPos newPos = pos.offset(Direction.SOUTH, 1).offset(Direction.WEST, 1);
                    logs.add(newPos);
                } else {
                    logs.add(pos);
                }
            }
            for (BlockPos pos : tree.leaves) {
                BlockPos newPos = pos.offset(Direction.SOUTH, 1).offset(Direction.WEST, 1);
                leaves.add(newPos);
            }
            Tree tre = new Tree(false, tree.name+"WEST", tree.log, tree.leave);
            tre.addLogPos(logs);
            tre.addLeavesPos(leaves);
            return tre;
        }
        if (want.equals(Direction.EAST)) {
            for (BlockPos pos : tree.logs) {
                if (!(pos.getZ() == 0 && pos.getX() == 0)) {
                    BlockPos newPos = pos.offset(Direction.SOUTH, 1).offset(Direction.EAST, 1);
                    logs.add(newPos);
                } else {
                    logs.add(pos);
                }
            }
            for (BlockPos pos : tree.leaves) {
                BlockPos newPos = pos.offset(Direction.SOUTH, 1).offset(Direction.EAST, 1);
                leaves.add(newPos);
            }
            Tree tre = new Tree( false, tree.name+"WEST", tree.log, tree.leave);
            tre.addLogPos(logs);
            tre.addLeavesPos(leaves);
            return tre;
        }
        return tree;
    }
}
