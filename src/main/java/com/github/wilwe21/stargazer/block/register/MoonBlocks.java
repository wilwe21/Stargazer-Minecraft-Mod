package com.github.wilwe21.stargazer.block.register;

import com.github.wilwe21.stargazer.block.clases.moon.MoonPlanks;
import com.github.wilwe21.stargazer.block.clases.moon.leaves.MoonLeaves;
import com.github.wilwe21.stargazer.block.clases.moon.log.MoonLog;
import com.github.wilwe21.stargazer.block.clases.moon.log.StrippedMoonLog;
import com.github.wilwe21.stargazer.block.clases.moon.star_stone.StarStone;
import com.github.wilwe21.stargazer.block.clases.moon.starforge.Starforge;
import com.github.wilwe21.stargazer.block.clases.sapling.MoonSapling;
import com.github.wilwe21.stargazer.item.ModItems;
import net.minecraft.block.*;
import net.minecraft.block.enums.NoteBlockInstrument;
import net.minecraft.item.Item;
import net.minecraft.sound.BlockSoundGroup;
import net.minecraft.state.property.Properties;
import net.minecraft.util.math.Direction;

import java.util.HashMap;

import static com.github.wilwe21.stargazer.block.ModBlock.register;

public class MoonBlocks {
    public static final HashMap<Item, BlockState> COLORED_PLANKS = new HashMap<>();
    public static final Block MOON_ROCK = register("moon_rock", Block::new, AbstractBlock.Settings.create()
            .solid()
            .sounds(BlockSoundGroup.STONE)
            .strength(1)
            .requiresTool()
            .strength(1.5F, 6.0F)
            .mapColor(MapColor.WHITE)
    );
    public static final Block MOON_ROCK_BRICKS = register("moon_rock_bricks", Block::new, AbstractBlock.Settings.create()
            .solid()
            .sounds(BlockSoundGroup.STONE)
            .requiresTool()
            .strength(1.5F, 6.0F)
            .mapColor(MapColor.WHITE)
    );
    public static final Block CRACKED_MOON_ROCK_BRICKS = register("cracked_moon_rock_bricks", Block::new, AbstractBlock.Settings.create()
            .solid()
            .sounds(BlockSoundGroup.STONE)
            .requiresTool()
            .strength(1.5F, 6.0F)
            .mapColor(MapColor.WHITE)
    );
    public static final Block CHISELED_MOON_ROCK_BRICKS = register("chiseled_moon_rock_bricks", Block::new, AbstractBlock.Settings.create()
            .solid()
            .sounds(BlockSoundGroup.STONE)
            .requiresTool()
            .strength(1.5F, 6.0F)
            .mapColor(MapColor.WHITE)
    );
    public static final Block BLACK_MOON_ROCK = register("black_moon_rock", Block::new, AbstractBlock.Settings.create()
            .solid()
            .sounds(BlockSoundGroup.STONE)
            .requiresTool()
            .strength(1.8F, 7.5F)
            .mapColor(MapColor.PURPLE)
    );
    public static final Block STAR_FORGE = register("star_forge", Starforge::new, AbstractBlock.Settings.create()
            .solid()
            .sounds(BlockSoundGroup.STONE)
            .requiresTool()
            .strength(1.5F, 6.0F)
            .mapColor(MapColor.WHITE)
    );
    public static final Block MOON_LOG = register("moon_log", MoonLog::new, AbstractBlock.Settings.create()
            .solid()
            .sounds(BlockSoundGroup.WOOD)
            .strength(2.0F)
            .mapColor(blockState -> blockState.get(Properties.AXIS).equals(Direction.Axis.Y) ? MapColor.WHITE : MapColor.PURPLE)
    );
    public static final Block STRIPPED_MOON_LOG = register("stripped_moon_log", StrippedMoonLog::new, AbstractBlock.Settings.create()
            .solid()
            .sounds(BlockSoundGroup.WOOD)
            .strength(2.0F)
            .mapColor(MapColor.WHITE)
    );
    public static final Block MOON_PLANKS = register("moon_planks", MoonPlanks::new, AbstractBlock.Settings.create()
            .solid()
            .sounds(BlockSoundGroup.WOOD)
            .instrument(NoteBlockInstrument.BASS)
            .strength(2.0F)
            .mapColor(MapColor.WHITE)
    );
    public static final Block RED_MOON_PLANKS = register("red_moon_planks", MoonPlanks::new, AbstractBlock.Settings.create()
            .solid()
            .sounds(BlockSoundGroup.WOOD)
            .instrument(NoteBlockInstrument.BASS)
            .strength(2.0F)
            .mapColor(MapColor.RED)
    );
    public static final Block BLUE_MOON_PLANKS = register("blue_moon_planks", MoonPlanks::new, AbstractBlock.Settings.create()
            .solid()
            .sounds(BlockSoundGroup.WOOD)
            .instrument(NoteBlockInstrument.BASS)
            .strength(2.0F)
            .mapColor(MapColor.BLUE)
    );
    public static final Block YELLOW_MOON_PLANKS = register("yellow_moon_planks", MoonPlanks::new, AbstractBlock.Settings.create()
            .solid()
            .sounds(BlockSoundGroup.WOOD)
            .instrument(NoteBlockInstrument.BASS)
            .strength(2.0F)
            .mapColor(MapColor.YELLOW)
    );
    public static final Block PURPLE_MOON_PLANKS = register("purple_moon_planks", MoonPlanks::new, AbstractBlock.Settings.create()
            .solid()
            .sounds(BlockSoundGroup.WOOD)
            .instrument(NoteBlockInstrument.BASS)
            .strength(2.0F)
            .mapColor(MapColor.PALE_PURPLE)
    );
    public static final Block MOON_LEAVES = register("moon_leaves", MoonLeaves::new, AbstractBlock.Settings.create()
            .solid()
            .nonOpaque()
            .sounds(BlockSoundGroup.GRASS)
            .strength(0.2F)
            .mapColor(MapColor.PURPLE)
    );
    public static final Block STAR_STONE = register("star_stone", StarStone::new, AbstractBlock.Settings.create()
            .solid()
            .sounds(BlockSoundGroup.GLASS)
            .luminance(StarStone::getLuminance)
            .strength(1.0F)
            .mapColor(MapColor.BRIGHT_RED)
    );
    public static final Block MOON_SAPLING = register("moon_sapling", MoonSapling::new, AbstractBlock.Settings.create()
            .noCollision()
            .sounds(BlockSoundGroup.GRASS)
            .ticksRandomly()
            .breakInstantly()
    );
    public static void init() {
        COLORED_PLANKS.put(ModItems.RED_STAR, MoonBlocks.RED_MOON_PLANKS.getDefaultState());
        COLORED_PLANKS.put(ModItems.BLUE_STAR, MoonBlocks.BLUE_MOON_PLANKS.getDefaultState());
        COLORED_PLANKS.put(ModItems.YELLOW_STAR, MoonBlocks.YELLOW_MOON_PLANKS.getDefaultState());
        COLORED_PLANKS.put(ModItems.PURPLE_STAR, MoonBlocks.PURPLE_MOON_PLANKS.getDefaultState());
    }
}
