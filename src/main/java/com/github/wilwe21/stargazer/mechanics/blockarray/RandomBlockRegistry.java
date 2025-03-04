package com.github.wilwe21.stargazer.mechanics.blockarray;

import com.github.wilwe21.stargazer.block.register.MoonBlocks;

public class RandomBlockRegistry {
    public static RandomBlockArray moon = new RandomBlockArray("moon1");

    public static void init() {
        moon.add(MoonBlocks.MOON_ROCK);
        moon.add(MoonBlocks.MOON_LOG);
        moon.add(MoonBlocks.BLACK_MOON_ROCK);
    }
}
