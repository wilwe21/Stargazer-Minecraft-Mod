package com.github.wilwe21.stargazer.mechanics.trees;

import net.minecraft.block.Block;
import net.minecraft.block.BlockState;
import net.minecraft.block.Blocks;
import net.minecraft.util.math.BlockPos;
import net.minecraft.util.math.Direction;
import net.minecraft.world.World;
import net.minecraft.world.tick.Tick;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class Tree {
    public final Boolean ROTATO;
    public final String name;
    public final List<BlockPos> logs = new ArrayList<>();
    public final List<BlockPos> leaves = new ArrayList<>();
    public final List<Block> replacable = new ArrayList<>();
    public final List<BlockState> log = new ArrayList<>();
    public final List<BlockState> leave = new ArrayList<>();
    private static final Random random = new Random();

    public Tree(Boolean rotatable, String name) {
        this.ROTATO = rotatable;
        this.name = name;
        this.log.add(Blocks.AIR.getDefaultState());
        this.leave.add(Blocks.AIR.getDefaultState());
    }
    public Tree(Boolean rotatable, String name, BlockState log, BlockState leave) {
        this.ROTATO = rotatable;
        this.name = name;
        this.log.add(log);
        this.leave.add(leave);
    }
    public Tree(Boolean rotatable, String name, List<BlockState> log, List<BlockState> leave) {
        this.ROTATO = rotatable;
        this.name = name;
        this.log.addAll(log);
        this.leave.addAll(leave);
    }

    public void addLogPos(int X, int Y, int Z) {
        this.logs.add(new BlockPos(X, Y, Z));
    }
    public void addLeavesPos(int X, int Y, int Z) {
        this.leaves.add(new BlockPos(X, Y, Z));
    }
    public void addLogPos(BlockPos pos) {
        this.logs.add(pos);
    }
    public void addLeavesPos(BlockPos pos) {
        this.leaves.add(pos);
    }
    public void addLogPos(List<BlockPos> list) {
        for (BlockPos pos : list) {
            if (!this.logs.contains(pos)) {
                this.logs.add(pos);
            }
        }
    }
    public void addLeavesPos(List<BlockPos> list) {
        for (BlockPos pos : list) {
            if (!this.leaves.contains(pos)) {
                this.leaves.add(pos);
            }
        }
    }
    public void addReplacableBlock(Block block) {
        this.replacable.add(block);
    }
    public void addReplacableBlock(List<Block> block) {
        this.replacable.addAll(block);
    }
    public void addLog(BlockState block) {
        this.log.add(block);
    }
    public void addLeave(BlockState block) {
        this.leave.add(block);
    }

    public Boolean canGrow(World world, BlockPos base) {
        for (BlockPos pos : logs) {
            if (!(pos.equals(new BlockPos(0, 0, 0 )))) {
                if (!(checkBlocks(world, base.add(pos)))) {
                    return false;
                }
            }
        }
        for (BlockPos pos : leaves) {
            if (!(pos.equals(new BlockPos(0, 0, 0 )))) {
                if (!(checkBlocks(world, base.add(pos)))) {
                    return false;
                }
            }
        }
        return true;
    }
    public void Grow(World world, BlockPos base) {
        if (canGrow(world, base)) {
            for (BlockPos pos : logs) {
                world.setBlockState(base.add(pos), log.get(random.nextInt(log.size())));
            }
            for (BlockPos pos : leaves) {
                world.setBlockState(base.add(pos), leave.get(random.nextInt(leave.size())));
            }
        }
    }

    public boolean checkBlocks(World world, BlockPos pos) {
        for (Block block : replacable) {
            if (world.getBlockState(pos).getBlock().equals(block)) {
                return true;
            }
        }
        return false;
    }

    public static Tree offset(Tree tree, Direction dir, int offset) {
        Tree newTree = new Tree(true, tree.name+"Offset");
        for (BlockPos pos : tree.logs) {
            newTree.addLogPos(pos.offset(dir, offset));
        }
        for (BlockPos pos : tree.leaves) {
            newTree.addLeavesPos(pos.offset(dir, offset));
        }
        return newTree;
    }

    public static Tree genBranch(int height) {
        Tree branch = new Tree(false, "branch");
        for (int i = 0; i < height; i++) {
            branch.addLogPos(0,i,0);
        }
        return branch;
    }

    public static void addBranch(Tree treeB, Tree branchB, Direction dir) {
        Tree rotated = DirectionalTree.getFromNorth(branchB, dir);
        treeB.addLogPos(rotated.logs);
        treeB.addLeavesPos(rotated.leaves);
    }

    @Override
    public String toString() {
        return "Tree{" +
                "name='" + name + '\'' +
                ", logs=" + logs +
                ", leaves=" + leaves +
                ", replacable=" + replacable +
                ", log=" + log +
                ", leave=" + leave +
                '}';
    }
}
