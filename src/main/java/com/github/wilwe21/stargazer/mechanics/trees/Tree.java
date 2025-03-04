package com.github.wilwe21.stargazer.mechanics.trees;

import com.github.wilwe21.stargazer.block.ModBlock;
import net.minecraft.block.Block;
import net.minecraft.block.BlockState;
import net.minecraft.block.Blocks;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.World;

import java.util.ArrayList;
import java.util.List;

public class Tree {
    public final Boolean ROTATO;
    public final String name;
    public final List<BlockPos> logs = new ArrayList<>();
    public final List<BlockPos> leaves = new ArrayList<>();
    public final List<Block> replacable = new ArrayList<>();
    public final BlockState log;
    public final BlockState leave;

    public Tree(Boolean rotatable, String name, BlockState log, BlockState leave) {
        this.ROTATO = rotatable;
        this.name = name;
        this.log = log;
        this.leave = leave;
    }

    public void addLogPos(int X, int Y, int Z) {
        this.logs.add(new BlockPos(X, Y, Z));
    }
    public void addLeavesPos(int X, int Y, int Z) {
        this.leaves.add(new BlockPos(X, Y, Z));
    }
    public void addLogPos(List<BlockPos> list) {
        this.logs.addAll(list);
    }
    public void addLeavesPos(List<BlockPos> list) {
        this.leaves.addAll(list);
    }
    public void addReplacableBlock(Block block) {
        this.replacable.add(block);
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
                world.setBlockState(base.add(pos), log);
            }
            for (BlockPos pos : leaves) {
                world.setBlockState(base.add(pos), leave);
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
}
