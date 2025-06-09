package com.github.wilwe21.stargazer.mechanics.trees.star;

import com.github.wilwe21.stargazer.block.register.MoonBlocks;
import com.github.wilwe21.stargazer.mechanics.trees.DirectionalTree;
import com.github.wilwe21.stargazer.mechanics.trees.Tree;
import com.google.common.collect.ImmutableList;
import com.mojang.serialization.Codec;
import net.minecraft.util.math.BlockPos;
import net.minecraft.util.math.Direction;
import net.minecraft.world.World;
import net.minecraft.world.gen.feature.Feature;
import net.minecraft.world.gen.feature.GeodeFeature;
import net.minecraft.world.gen.feature.TreeFeature;
import net.minecraft.world.gen.feature.util.FeatureContext;

import java.util.ArrayList;

public class StarTrees extends Feature {
    public static final ImmutableList<Direction> GROW_DIRECTIONS = ImmutableList.of(
            Direction.SOUTH, Direction.NORTH, Direction.EAST, Direction.WEST
    );

    public static ArrayList<StarTree> TREELIST = new ArrayList<>();
    public static StarTree treeSmall = register("starSmall", 8);
    public static StarTree treeMid = register("starMid", 10);
    public static StarTree treeHi = register("starHi", 12);
    public static StarTree treeMeg = register("starMeg", 14);

    public StarTrees(Codec configCodec) {
        super(configCodec);
    }

    public static StarTree register(String name, int height) {
        StarTree tre = new StarTree(false, name, height);
        TREELIST.add(tre);
        return tre;
    }
    public static void init() {
        for (StarTree tre : TREELIST) {
            tre.init();
        }
    }

    @Override
    public boolean generate(FeatureContext context) {
        World world = context.getWorld().toServerWorld();
        BlockPos pos = context.getOrigin();
        java.util.Random random = new java.util.Random();
        Tree tree = TREELIST.get(random.nextInt(TREELIST.size()));
        if (tree.ROTATO) {
            Direction dir = GROW_DIRECTIONS.get(random.nextInt(GROW_DIRECTIONS.size()));
            Tree rotated = DirectionalTree.getFromNorth(tree, dir);
            if (rotated.canGrow(context.getWorld(), pos)) {
                rotated.Grow(context.getWorld(), pos);
                if (world.getBlockState(pos.down(1)).getBlock().equals(MoonBlocks.MOON_ROCK_NYLIUM)) {
                    this.setBlockState(context.getWorld(), pos.down(1), MoonBlocks.MOON_ROCK.getDefaultState());
                }
                return true;
            }
        } else {
            if (tree.canGrow(context.getWorld(), pos)) {
                tree.Grow(context.getWorld(), pos);
                if (world.getBlockState(pos.down(1)).getBlock().equals(MoonBlocks.MOON_ROCK_NYLIUM)) {
                    this.setBlockState(context.getWorld(), pos.down(1), MoonBlocks.MOON_ROCK.getDefaultState());
                }
                return true;
            }
        }
        return false;
    }
}
