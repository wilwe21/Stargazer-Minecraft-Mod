package com.github.wilwe21.stargazer.block.register;

import com.github.wilwe21.stargazer.block.clases.moon.leaves.MoonLeaves;
import com.github.wilwe21.stargazer.block.clases.moon.log.MoonLog;
import com.github.wilwe21.stargazer.block.clases.moon.star_stone.StarStone;
import com.github.wilwe21.stargazer.block.clases.moon.starforge.Starforge;
import net.minecraft.block.AbstractBlock;
import net.minecraft.block.Block;
import net.minecraft.block.Blocks;
import net.minecraft.block.HorizontalFacingBlock;
import net.minecraft.sound.BlockSoundGroup;

import static com.github.wilwe21.stargazer.block.ModBlock.register;

public class MoonBlocks {
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
    public static final Block BLACK_MOON_ROCK = register("black_moon_rock", Block::new, AbstractBlock.Settings.create()
            .solid()
            .sounds(BlockSoundGroup.STONE)
    );
    public static final Block STAR_FORGE = register("star_forge", Starforge::new, AbstractBlock.Settings.create()
            .solid()
            .sounds(BlockSoundGroup.STONE)
    );
    public static final Block MOON_LOG = register("moon_log", MoonLog::new, AbstractBlock.Settings.create()
            .solid()
            .sounds(BlockSoundGroup.WOOD)
    );
    public static final Block MOON_LEAVES = register("moon_leaves", MoonLeaves::new, AbstractBlock.Settings.create()
            .solid()
            .nonOpaque()
            .sounds(BlockSoundGroup.GRASS)
    );
    public static final Block STAR_STONE = register("star_stone", StarStone::new, AbstractBlock.Settings.create()
            .solid()
            .sounds(BlockSoundGroup.GLASS)
            .luminance(StarStone::getLuminance)
    );
    public static void init() {}
}
