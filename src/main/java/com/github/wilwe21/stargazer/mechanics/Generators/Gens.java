package com.github.wilwe21.stargazer.mechanics.Generators;

import com.github.wilwe21.stargazer.Stargazer;
import com.github.wilwe21.stargazer.block.ModBlock;
import com.github.wilwe21.stargazer.block.register.MoonBlocks;
import com.github.wilwe21.stargazer.block.register.StarBlocks;
import com.github.wilwe21.stargazer.mechanics.blockarray.RandomBlockArray;
import net.minecraft.block.Block;
import net.minecraft.block.BlockState;
import net.minecraft.block.Blocks;
import net.minecraft.fluid.Fluid;
import net.minecraft.registry.tag.FluidTags;
import net.minecraft.registry.tag.TagKey;

import java.util.ArrayList;
import java.util.List;

public class Gens {
    public static List<CobbleGen> list = new ArrayList<>();
    public static final CobbleGen cosmicWATER = register(false, StarBlocks.COSMIC_BLOCK, MoonBlocks.BLACK_MOON_ROCK, MoonBlocks.MOON_ROCK);
    public static final CobbleGen cosmicLAVA = register(false, StarBlocks.COSMIC_BLOCK, Blocks.DARK_PRISMARINE, MoonBlocks.STAR_STONE, FluidTags.LAVA);
    public static final CobbleGen negatWATER = register(false, ModBlock.NEGATIVE_BLOCK, Blocks.AMETHYST_BLOCK, Blocks.END_STONE);

    public static CobbleGen register(Boolean useArray, Block lava, Block obs, Block cobble) {
        CobbleGen gen = new CobbleGen(useArray, lava, obs, cobble);
        list.add(gen);
        return gen;
    }
    public static CobbleGen register(Boolean useArray, Block lava, RandomBlockArray obs, RandomBlockArray cobble) {
        CobbleGen gen = new CobbleGen(useArray, lava, obs, cobble);
        list.add(gen);
        return gen;
    }
    public static CobbleGen register(Boolean useArray, Block lava, Block obs, RandomBlockArray cobble) {
        CobbleGen gen = new CobbleGen(useArray, lava, obs, cobble);
        list.add(gen);
        return gen;
    }
    public static CobbleGen register(Boolean useArray, Block lava, RandomBlockArray obs, Block cobble) {
        CobbleGen gen = new CobbleGen(useArray, lava, obs, cobble);
        list.add(gen);
        return gen;
    }
    public static CobbleGen register(Boolean useArray, Block lava, BlockState obs, Block cobble) {
        CobbleGen gen = new CobbleGen(useArray, lava, obs, cobble);
        list.add(gen);
        return gen;
    }
    public static CobbleGen register(Boolean useArray, Block lava, Block obs, BlockState cobble) {
        CobbleGen gen = new CobbleGen(useArray, lava, obs, cobble);
        list.add(gen);
        return gen;
    }
    public static CobbleGen register(Boolean useArray, Block lava, BlockState obs, BlockState cobble) {
        CobbleGen gen = new CobbleGen(useArray, lava, obs, cobble);
        list.add(gen);
        return gen;
    }
    public static CobbleGen register(Boolean useArray, Block lava, Block obs, Block cobble, TagKey<Fluid> fluid) {
        CobbleGen gen = new CobbleGen(useArray, lava, obs, cobble, fluid);
        list.add(gen);
        return gen;
    }
    public static CobbleGen register(Boolean useArray, Block lava, BlockState obs, Block cobble, TagKey<Fluid> fluid) {
        CobbleGen gen = new CobbleGen(useArray, lava, obs, cobble, fluid);
        list.add(gen);
        return gen;
    }
    public static CobbleGen register(Boolean useArray, Block lava, Block obs, BlockState cobble, TagKey<Fluid> fluid) {
        CobbleGen gen = new CobbleGen(useArray, lava, obs, cobble, fluid);
        list.add(gen);
        return gen;
    }
    public static CobbleGen register(Boolean useArray, Block lava, BlockState obs, BlockState cobble, TagKey<Fluid> fluid) {
        CobbleGen gen = new CobbleGen(useArray, lava, obs, cobble, fluid);
        list.add(gen);
        return gen;
    }
    public static void init() {
    }
}
