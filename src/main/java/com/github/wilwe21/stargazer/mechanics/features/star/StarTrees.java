package com.github.wilwe21.stargazer.mechanics.features.star;

import com.github.wilwe21.stargazer.block.clases.sapling.StarSapling;
import com.github.wilwe21.stargazer.block.register.MoonBlocks;
import com.github.wilwe21.stargazer.mechanics.features.DirectionalTree;
import com.github.wilwe21.stargazer.mechanics.features.Tree;
import com.github.wilwe21.stargazer.mechanics.features.TreeConfig;
import com.google.common.collect.ImmutableList;
import com.mojang.serialization.Codec;
import net.minecraft.util.math.BlockPos;
import net.minecraft.util.math.Direction;
import net.minecraft.world.gen.feature.Feature;
import net.minecraft.world.gen.feature.util.FeatureContext;

import java.util.ArrayList;
import java.util.List;

public class StarTrees extends Feature<TreeConfig> {
    public static final ImmutableList<Direction> GROW_DIRECTIONS = ImmutableList.of(
            Direction.SOUTH, Direction.NORTH, Direction.EAST, Direction.WEST
    );

    public static ArrayList<Tree> TREELIST = new ArrayList<>();
    public static Tree treeSmall = register("starSmall", 8);
    public static Tree treeMid = register("starMid", 10);
    public static Tree treeHi = register("starHi", 12);
    public static Tree treeMeg = register("starMeg", 14);

    public StarTrees(Codec<TreeConfig> configCodec) {
        super(configCodec);
    }

    public static Tree register(String name, int height) {
        Tree tre = StarTree.NewStarTree(false, name, height);
        TREELIST.add(tre);
        return tre;
    }

    public static void init() {
    }

    @Override
    public boolean generate(FeatureContext<TreeConfig> context) {
        if (!StarSapling.PLACE.contains(context.getWorld().getBlockState(context.getOrigin().down(1)).getBlock())) {
            return false;
        }
        TreeConfig config = context.getConfig();
        List<String> allowed = config.NAMES;
        List<Tree> TREES;
        if (config.BLACKLIST) {
            TREES = TREELIST.stream().filter(name -> !allowed.contains(name.name)).toList();
        } else {
            TREES = TREELIST.stream().filter(name -> allowed.contains(name.name)).toList();
        }
        BlockPos pos = context.getOrigin();
        java.util.Random random = new java.util.Random();
        Tree tree = TREES.get(random.nextInt(TREES.size()));
        if (tree.ROTATO) {
            Direction dir = GROW_DIRECTIONS.get(random.nextInt(GROW_DIRECTIONS.size()));
            Tree rotated = DirectionalTree.getFromNorth(tree, dir);
            if (rotated.canGrow(context.getWorld(), pos)) {
                rotated.Grow(context.getWorld(), pos);
                if (context.getWorld().getBlockState(pos.down(1)).getBlock().equals(MoonBlocks.MOON_ROCK_NYLIUM)) {
                    this.setBlockState(context.getWorld(), pos.down(1), MoonBlocks.MOON_ROCK.getDefaultState());
                }
                return true;
            }
        } else {
            if (tree.canGrow(context.getWorld(), pos)) {
                tree.Grow(context.getWorld(), pos);
                if (context.getWorld().getBlockState(pos.down(1)).getBlock().equals(MoonBlocks.MOON_ROCK_NYLIUM)) {
                    this.setBlockState(context.getWorld(), pos.down(1), MoonBlocks.MOON_ROCK.getDefaultState());
                }
                return true;
            }
        }
        return false;
    }
}
