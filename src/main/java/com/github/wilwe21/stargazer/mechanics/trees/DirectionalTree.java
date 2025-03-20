package com.github.wilwe21.stargazer.mechanics.trees;

import it.unimi.dsi.fastutil.objects.ObjectArraySet;
import net.minecraft.util.math.BlockPos;
import net.minecraft.util.math.Direction;

import java.util.Set;

// North negative Z
// South positive Z
// West negative X
// east positive X
public class DirectionalTree {
    public static Set<BlockPos> logs;
    public static Set<BlockPos> leaves;
    public static Tree getFromNorth(Tree tree, Direction want) {
        logs = new ObjectArraySet<>();
        leaves = new ObjectArraySet<>();
        if (want.equals(Direction.SOUTH)) {
            for (BlockPos pos : tree.logs) {
                if (!(pos.getZ() == 0 && pos.getX() == 0)) {
                    BlockPos newPos = new BlockPos(pos.getX()*-1, pos.getY(), pos.getZ() * -1);
                    logs.add(newPos);
                } else {
                    logs.add(pos);
                }
            }
            for (BlockPos pos : tree.leaves) {
                BlockPos newPos = new BlockPos(pos.getX()*-1, pos.getY(), pos.getZ() * -1);
                leaves.add(newPos);
            }
            Tree tre = new Tree(false, tree.name+"SOUTH", tree.log, tree.leave);
            tre.addLogPos(logs);
            tre.addLeavesPos(leaves);
            tre.addReplacableBlock(tree.replacable);
            return tre;
        }
        if (want.equals(Direction.WEST)) {
            for (BlockPos pos : tree.logs) {
                if (!(pos.getZ() == 0 && pos.getX() == 0)) {
                    BlockPos newPos = new BlockPos(pos.getZ(), pos.getY(), pos.getX()*-1);
                    logs.add(newPos);
                } else {
                    logs.add(pos);
                }
            }
            for (BlockPos pos : tree.leaves) {
                BlockPos newPos = new BlockPos(pos.getZ(), pos.getY(), pos.getX()*-1);
                leaves.add(newPos);
            }
            Tree tre = new Tree(false, tree.name+"WEST", tree.log, tree.leave);
            tre.addLogPos(logs);
            tre.addLeavesPos(leaves);
            tre.addReplacableBlock(tree.replacable);
            return tre;
        }
        if (want.equals(Direction.EAST)) {
            for (BlockPos pos : tree.logs) {
                if (!(pos.getZ() == 0 && pos.getX() == 0)) {
                    BlockPos newPos = new BlockPos(pos.getZ()*-1, pos.getY(), pos.getX());
                    logs.add(newPos);
                } else {
                    logs.add(pos);
                }
            }
            for (BlockPos pos : tree.leaves) {
                BlockPos newPos = new BlockPos(pos.getZ()*-1, pos.getY(), pos.getX());
                leaves.add(newPos);
            }
            Tree tre = new Tree( false, tree.name+"WEST", tree.log, tree.leave);
            tre.addLogPos(logs);
            tre.addLeavesPos(leaves);
            tre.addReplacableBlock(tree.replacable);
            return tre;
        }
        return tree;
    }
}
