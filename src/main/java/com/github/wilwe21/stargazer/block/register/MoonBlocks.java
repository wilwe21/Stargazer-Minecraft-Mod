package com.github.wilwe21.stargazer.block.register;

import com.github.wilwe21.stargazer.block.clases.moon.leaves.MoonLeaves;
import com.github.wilwe21.stargazer.block.clases.moon.log.MoonLog;
import com.github.wilwe21.stargazer.block.clases.moon.log.StrippedMoonLog;
import com.github.wilwe21.stargazer.block.clases.moon.star_stone.StarStone;
import com.github.wilwe21.stargazer.block.clases.moon.starforge.Starforge;
import com.github.wilwe21.stargazer.block.clases.sapling.MoonSapling;
import net.minecraft.block.*;
import net.minecraft.block.enums.NoteBlockInstrument;
import net.minecraft.sound.BlockSoundGroup;

import static com.github.wilwe21.stargazer.block.ModBlock.register;

public class MoonBlocks {
    public static final Block MOON_ROCK = register("moon_rock", Block::new, AbstractBlock.Settings.create()
            .solid()
            .sounds(BlockSoundGroup.STONE)
            .strength(1)
            .requiresTool()
            .strength(1.5F, 6.0F)
    );
    public static final Block MOON_ROCK_BRICKS = register("moon_rock_bricks", Block::new, AbstractBlock.Settings.create()
            .solid()
            .sounds(BlockSoundGroup.STONE)
            .requiresTool()
            .strength(1.5F, 6.0F)
    );
    public static final Block CRACKED_MOON_ROCK_BRICKS = register("cracked_moon_rock_bricks", Block::new, AbstractBlock.Settings.create()
            .solid()
            .sounds(BlockSoundGroup.STONE)
            .requiresTool()
            .strength(1.5F, 6.0F)
    );
    public static final Block CHISELED_MOON_ROCK_BRICKS = register("chiseled_moon_rock_bricks", Block::new, AbstractBlock.Settings.create()
            .solid()
            .sounds(BlockSoundGroup.STONE)
            .requiresTool()
            .strength(1.5F, 6.0F)
    );
    public static final Block BLACK_MOON_ROCK = register("black_moon_rock", Block::new, AbstractBlock.Settings.create()
            .solid()
            .sounds(BlockSoundGroup.STONE)
            .requiresTool()
            .strength(1.8F, 7.5F)
    );
    public static final Block STAR_FORGE = register("star_forge", Starforge::new, AbstractBlock.Settings.create()
            .solid()
            .sounds(BlockSoundGroup.STONE)
            .requiresTool()
            .strength(1.5F, 6.0F)
    );
    public static final Block MOON_LOG = register("moon_log", MoonLog::new, AbstractBlock.Settings.create()
            .solid()
            .sounds(BlockSoundGroup.WOOD)
            .strength(2.0F)
    );
    public static final Block STRIPPED_MOON_LOG = register("stripped_moon_log", StrippedMoonLog::new, AbstractBlock.Settings.create()
            .solid()
            .sounds(BlockSoundGroup.WOOD)
            .strength(2.0F)
    );
    public static final Block MOON_PLANKS = register("moon_planks", Block::new, AbstractBlock.Settings.create()
            .solid()
            .sounds(BlockSoundGroup.WOOD)
            .instrument(NoteBlockInstrument.BASS)
            .strength(2.0F)
    );
    public static final Block MOON_LEAVES = register("moon_leaves", MoonLeaves::new, AbstractBlock.Settings.create()
            .solid()
            .nonOpaque()
            .sounds(BlockSoundGroup.GRASS)
            .strength(0.2F)
    );
    public static final Block STAR_STONE = register("star_stone", StarStone::new, AbstractBlock.Settings.create()
            .solid()
            .sounds(BlockSoundGroup.GLASS)
            .luminance(StarStone::getLuminance)
            .strength(1.0F)
    );
    public static final Block MOON_SAPLING = register("moon_sapling", MoonSapling::new, AbstractBlock.Settings.create()
            .noCollision()
            .sounds(BlockSoundGroup.GRASS)
            .ticksRandomly()
            .breakInstantly()
    );
    public static void init() {
    }
}
