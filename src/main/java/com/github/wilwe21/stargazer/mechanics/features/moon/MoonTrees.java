package com.github.wilwe21.stargazer.mechanics.features.moon;

import com.github.wilwe21.stargazer.block.clases.sapling.MoonSapling;
import com.github.wilwe21.stargazer.block.register.MoonBlocks;
import com.github.wilwe21.stargazer.mechanics.features.DirectionalTree;
import com.github.wilwe21.stargazer.mechanics.features.Tree;
import com.google.common.collect.ImmutableList;
import com.mojang.serialization.Codec;
import net.minecraft.state.property.Properties;
import net.minecraft.util.math.BlockPos;
import net.minecraft.util.math.Direction;
import net.minecraft.world.gen.feature.DefaultFeatureConfig;
import net.minecraft.world.gen.feature.Feature;
import net.minecraft.world.gen.feature.util.FeatureContext;

import java.util.ArrayList;

public class MoonTrees extends Feature<DefaultFeatureConfig> {
    public static final ImmutableList<Direction> GROW_DIRECTIONS = ImmutableList.of(
            Direction.SOUTH, Direction.NORTH, Direction.EAST, Direction.WEST
    );

    public static ArrayList<Tree> TREELIST = new ArrayList<>();
    public static Tree SmallMoon = register("SmallMoon");
    public static Tree HiMoon = register("HiMoon");
    public static Tree DoubleMoon = register("DoubleMoon");

    public MoonTrees(Codec<DefaultFeatureConfig> codec) {
        super(codec);
    }

    public static Tree register(String name) {
        Tree tree = new Tree(true, name, MoonBlocks.MOON_LOG.getDefaultState().with(Properties.AXIS, Direction.Axis.Y), MoonBlocks.MOON_LEAVES.getDefaultState());
        TREELIST.add(tree);
        return tree;
    }
    public static void init() {
        MoonBase.leavesInit();
        MoonTree1.init(SmallMoon);
        MoonTree2.init(HiMoon);
        MoonTree3.init(DoubleMoon);
    }

    @Override
    public boolean generate(FeatureContext context) {
        if (!MoonSapling.PLACE.contains(context.getWorld().getBlockState(context.getOrigin().down(1)).getBlock())) {
            return false;
        }
        BlockPos pos = context.getOrigin();
        java.util.Random random = new java.util.Random();
        Tree tree = TREELIST.get(random.nextInt(TREELIST.size()));
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
