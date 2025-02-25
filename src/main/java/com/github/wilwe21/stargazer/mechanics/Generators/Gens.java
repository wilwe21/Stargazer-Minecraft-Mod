package com.github.wilwe21.stargazer.mechanics.Generators;

import com.github.wilwe21.stargazer.Stargazer;
import com.github.wilwe21.stargazer.block.ModBlock;
import com.github.wilwe21.stargazer.block.register.MoonBlocks;
import net.minecraft.block.Block;
import net.minecraft.block.BlockState;
import net.minecraft.block.Blocks;

import java.util.ArrayList;
import java.util.List;

public class Gens {
    public static List<CobbleGen> list = new ArrayList<>();
    public static final CobbleGen cosmic = register(ModBlock.COSMIC_BLOCK, MoonBlocks.BLACK_MOON_ROCK, MoonBlocks.MOON_ROCK);
    public static final CobbleGen negat = register(ModBlock.NEGATIVE_BLOCK, Blocks.AMETHYST_BLOCK, Blocks.GLASS);
    public static final CobbleGen test = register(Blocks.OAK_LOG, Blocks.ACACIA_FENCE, Blocks.LAPIS_ORE);

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
    public static void init() {
        Stargazer.LOGGER.info("CobbleGen size " + list.size());
        for (CobbleGen cobbleGen : list) {
            Stargazer.LOGGER.info(cobbleGen.toString()); // Or whatever you need to do
        }
    }
}
