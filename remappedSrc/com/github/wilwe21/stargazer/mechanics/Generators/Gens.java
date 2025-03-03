package com.github.wilwe21.stargazer.mechanics.Generators;

import com.github.wilwe21.stargazer.Stargazer;
import com.github.wilwe21.stargazer.block.ModBlock;
import com.github.wilwe21.stargazer.block.register.MoonBlocks;
import net.minecraft.block.Block;
import net.minecraft.block.BlockState;
import net.minecraft.block.Blocks;
import net.minecraft.fluid.Fluid;
import net.minecraft.registry.tag.FluidTags;
import net.minecraft.registry.tag.TagBuilder;
import net.minecraft.registry.tag.TagKey;

import java.util.ArrayList;
import java.util.List;

public class Gens {
    public static List<CobbleGen> list = new ArrayList<>();
    public static final CobbleGen cosmicWATER = register(ModBlock.COSMIC_BLOCK, MoonBlocks.BLACK_MOON_ROCK, MoonBlocks.MOON_ROCK);
    public static final CobbleGen cosmicLAVA = register(ModBlock.COSMIC_BLOCK, Blocks.DARK_PRISMARINE, MoonBlocks.STAR_STONE, FluidTags.LAVA);
    public static final CobbleGen negatWATER = register(ModBlock.NEGATIVE_BLOCK, Blocks.AMETHYST_BLOCK, Blocks.END_STONE);

    public static CobbleGen register(Block lava, Block obs, Block cobble) {
        CobbleGen gen = new CobbleGen(lava, obs, cobble);
        list.add(gen);
        return gen;
    }
    public static CobbleGen register(Block lava, BlockState obs, Block cobble) {
        CobbleGen gen = new CobbleGen(lava, obs, cobble);
        list.add(gen);
        return gen;
    }
    public static CobbleGen register(Block lava, Block obs, BlockState cobble) {
        CobbleGen gen = new CobbleGen(lava, obs, cobble);
        list.add(gen);
        return gen;
    }
    public static CobbleGen register(Block lava, BlockState obs, BlockState cobble) {
        CobbleGen gen = new CobbleGen(lava, obs, cobble);
        list.add(gen);
        return gen;
    }
    public static CobbleGen register(Block lava, Block obs, Block cobble, TagKey<Fluid> fluid) {
        CobbleGen gen = new CobbleGen(lava, obs, cobble, fluid);
        list.add(gen);
        return gen;
    }
    public static CobbleGen register(Block lava, BlockState obs, Block cobble, TagKey<Fluid> fluid) {
        CobbleGen gen = new CobbleGen(lava, obs, cobble, fluid);
        list.add(gen);
        return gen;
    }
    public static CobbleGen register(Block lava, Block obs, BlockState cobble, TagKey<Fluid> fluid) {
        CobbleGen gen = new CobbleGen(lava, obs, cobble, fluid);
        list.add(gen);
        return gen;
    }
    public static CobbleGen register(Block lava, BlockState obs, BlockState cobble, TagKey<Fluid> fluid) {
        CobbleGen gen = new CobbleGen(lava, obs, cobble, fluid);
        list.add(gen);
        return gen;
    }
    public static void init() {
        Stargazer.LOGGER.info("CobbleGen size " + list.size());
        for (CobbleGen cobbleGen : list) {
            Stargazer.LOGGER.info(cobbleGen.toString()); // Or whatever you need to do
        }
    }
}
