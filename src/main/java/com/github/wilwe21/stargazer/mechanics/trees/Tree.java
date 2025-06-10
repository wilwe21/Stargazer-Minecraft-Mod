package com.github.wilwe21.stargazer.mechanics.trees;

import com.mojang.serialization.Codec;
import it.unimi.dsi.fastutil.objects.ObjectArraySet;
import net.minecraft.block.Block;
import net.minecraft.block.BlockState;
import net.minecraft.block.Blocks;
import net.minecraft.server.world.ServerWorld;
import net.minecraft.state.property.Properties;
import net.minecraft.util.math.BlockPos;
import net.minecraft.util.math.Direction;
import net.minecraft.world.StructureWorldAccess;
import net.minecraft.world.World;
import net.minecraft.world.gen.feature.Feature;
import net.minecraft.world.gen.feature.GeodeFeature;
import net.minecraft.world.gen.feature.util.FeatureContext;

import java.util.Random;
import java.util.Set;

public class Tree {
    public final Boolean ROTATO;
    public final String name;
    public final Set<BlockPos> logs = new ObjectArraySet<>();
    public final Set<BlockPos> leaves = new ObjectArraySet<>();
    public final Set<Block> replacable = new ObjectArraySet<>();
    public final Set<BlockState> log = new ObjectArraySet<>();
    public final Set<BlockState> leave = new ObjectArraySet<>();
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
    public Tree(Boolean rotatable, String name, Set<BlockState> log, Set<BlockState> leave) {
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
    public void addLogPos(Set<BlockPos> list) {
        this.logs.addAll(list);
    }
    public void addLeavesPos(Set<BlockPos> list) {
        this.leaves.addAll(list);
    }
    public void addReplacableBlock(Block block) {
        this.replacable.add(block);
    }
    public void addReplacableBlock(Set<Block> block) {
        this.replacable.addAll(block);
    }
    public void addLog(BlockState block) {
        this.log.add(block);
    }
    public void addLeave(BlockState block) {
        this.leave.add(block);
    }

    public Boolean canGrow(ServerWorld world, BlockPos base) {
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

    public Boolean canGrow(StructureWorldAccess world, BlockPos base) {
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

    public boolean Grow(ServerWorld world, BlockPos base) {
        if (canGrow(world, base)) {
            for (int i = 0; i < logs.size(); i ++) {
                BlockPos pos = logs.stream().toList().get(i);
                BlockPos nex;
                if (i + 1 != logs.size()) {
                    nex = logs.stream().toList().get(i+1);
                } else {
                    nex = logs.stream().toList().get(i-1);
                }
                BlockState newLog = log.stream().toList().get(random.nextInt(log.size()));
                if (newLog.getProperties().contains(Properties.AXIS)) {
                    if (Math.abs(pos.getZ()) > Math.abs(pos.getX())) {
                        newLog = newLog.with(Properties.AXIS, Direction.Axis.Z);
                    }
                    if (Math.abs(pos.getX()) > Math.abs(pos.getZ())) {
                        newLog = newLog.with(Properties.AXIS, Direction.Axis.X);
                    }
                    if (Math.abs(pos.getZ()) == Math.abs(pos.getX()) || nex.up(1).equals(pos) || nex.down(1).equals(pos)) {
                        newLog = newLog.with(Properties.AXIS, Direction.Axis.Y);
                    }
                    world.setBlockState(base.add(pos), newLog);
                } else {
                    world.setBlockState(base.add(pos), newLog);
                }
            }
            for (BlockPos pos : leaves) {
                world.setBlockState(base.add(pos), leave.stream().toList().get(random.nextInt(leave.size())));
            }
            return true;
        }
        return false;
    }

    public boolean Grow(StructureWorldAccess world, BlockPos base) {
        if (canGrow(world, base)) {
            for (int i = 0; i < logs.size(); i ++) {
                BlockPos pos = logs.stream().toList().get(i);
                BlockPos nex;
                if (i + 1 != logs.size()) {
                    nex = logs.stream().toList().get(i+1);
                } else {
                    nex = logs.stream().toList().get(i-1);
                }
                BlockState newLog = log.stream().toList().get(random.nextInt(log.size()));
                if (newLog.getProperties().contains(Properties.AXIS)) {
                    if (Math.abs(pos.getZ()) > Math.abs(pos.getX())) {
                        newLog = newLog.with(Properties.AXIS, Direction.Axis.Z);
                    }
                    if (Math.abs(pos.getX()) > Math.abs(pos.getZ())) {
                        newLog = newLog.with(Properties.AXIS, Direction.Axis.X);
                    }
                    if (Math.abs(pos.getZ()) == Math.abs(pos.getX()) || nex.up(1).equals(pos) || nex.down(1).equals(pos)) {
                        newLog = newLog.with(Properties.AXIS, Direction.Axis.Y);
                    }
                    world.setBlockState(base.add(pos), newLog, Block.NOTIFY_ALL | Block.FORCE_STATE);
                } else {
                    world.setBlockState(base.add(pos), newLog, Block.NOTIFY_ALL | Block.FORCE_STATE);
                }
            }
            for (BlockPos pos : leaves) {
                world.setBlockState(base.add(pos), leave.stream().toList().get(random.nextInt(leave.size())), Block.NOTIFY_ALL);
            }
            return true;
        }
        return false;
    }

    public boolean checkBlocks(ServerWorld world, BlockPos pos) {
        for (Block block : replacable) {
            if (world.getBlockState(pos).getBlock().equals(block)) {
                return true;
            }
        }
        return false;
    }

    public boolean checkBlocks(StructureWorldAccess world, BlockPos pos) {
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

    public String countLogs() {
        return "" + logs.size();
    }

    public String countLeaves() {
        return "" + leaves.size();
    }

    @Override
    public String toString() {
        return "Tree{" +
                "name='" + name + '\'' +
                ", logs amount=" + countLogs() +
                ", leaves amount=" + countLeaves() +
                ", logs=" + logs +
                ", leaves=" + leaves +
                ", replacable=" + replacable +
                ", log=" + log +
                ", leave=" + leave +
                '}';
    }

}
