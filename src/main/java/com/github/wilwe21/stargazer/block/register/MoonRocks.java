package com.github.wilwe21.stargazer.block.register;

import net.minecraft.block.AbstractBlock;
import net.minecraft.block.Block;
import net.minecraft.sound.BlockSoundGroup;

import static com.github.wilwe21.stargazer.block.ModBlock.register;

public class MoonRocks {
    public static final Block MOON_ROCK = register("moon_rock", Block::new, AbstractBlock.Settings.create()
            .solid()
            .sounds(BlockSoundGroup.STONE)
    );
    public static final Block MOON_ROCK_BRICKS = register("moon_rock_bricks", Block::new, AbstractBlock.Settings.create()
            .solid()
            .sounds(BlockSoundGroup.STONE)
    );
    public static final Block CRACKED_MOON_ROCK_BRICKS = register("cracked_moon_rock_bricks", Block::new, AbstractBlock.Settings.create()
            .solid()
            .sounds(BlockSoundGroup.STONE)
    );
    public static final Block CHISELED_MOON_ROCK_BRICKS = register("chiseled_moon_rock_bricks", Block::new, AbstractBlock.Settings.create()
            .solid()
            .sounds(BlockSoundGroup.STONE)
    );
    public static final Block STAR_FORGE = register("star_forge", Block::new, AbstractBlock.Settings.create()
            .solid()
            .sounds(BlockSoundGroup.STONE)
    );
    public static void init() {}
}
