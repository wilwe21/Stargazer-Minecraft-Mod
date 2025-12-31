package com.github.wilwe21.stargazer.block.register;

import com.github.wilwe21.stargazer.block.clases.CustomLeaves;
import com.github.wilwe21.stargazer.block.clases.moon.*;
import com.github.wilwe21.stargazer.block.clases.moon.geode_fruit.GeodeFruit;
import com.github.wilwe21.stargazer.block.clases.moon.leaves.MoonLeaves;
import com.github.wilwe21.stargazer.block.clases.moon.log.MoonLog;
import com.github.wilwe21.stargazer.block.clases.moon.log.StrippedMoonLog;
import com.github.wilwe21.stargazer.block.clases.moon.star_stone.StarStone;
import com.github.wilwe21.stargazer.block.clases.moon.star_trap.StarTrap;
import com.github.wilwe21.stargazer.block.clases.moon.starforge.Starforge;
import com.github.wilwe21.stargazer.block.clases.sapling.CurveSapling;
import com.github.wilwe21.stargazer.block.clases.sapling.MoonSapling;
import com.github.wilwe21.stargazer.item.ModItems;
import net.minecraft.block.*;
import net.minecraft.block.enums.NoteBlockInstrument;
import net.minecraft.block.piston.PistonBehavior;
import net.minecraft.item.Item;
import net.minecraft.sound.BlockSoundGroup;
import net.minecraft.state.property.Properties;
import net.minecraft.util.Colors;
import net.minecraft.util.math.Direction;

import java.util.HashMap;

import static com.github.wilwe21.stargazer.block.ModBlock.register;

public class MoonBlocks {
    public static final HashMap<Item, BlockState> COLORED_PLANKS = new HashMap<>();
    public static final Block MOON_ROCK = register("moon_rock", MoonRock::new, AbstractBlock.Settings.create()
            .solid()
            .sounds(BlockSoundGroup.STONE)
            .strength(1)
            .requiresTool()
            .strength(1.5F, 6.0F)
            .mapColor(MapColor.WHITE)
    );
    public static final Block SMOOTH_MOON_ROCK = register("smooth_moon_rock", Block::new, AbstractBlock.Settings.create()
            .solid()
            .sounds(BlockSoundGroup.STONE)
            .strength(1)
            .requiresTool()
            .strength(1.5F, 6.0F)
            .mapColor(MapColor.WHITE)
    );
    public static final Block MOON_FARMLAND = register("moon_farmland", MoonFarmland::new, AbstractBlock.Settings.create()
            .solid()
            .sounds(BlockSoundGroup.STONE)
            .ticksRandomly()
            .strength(1)
            .requiresTool()
            .strength(1.5F, 6.0F)
            .mapColor(MapColor.WHITE)
    );
    public static final Block MOON_ROCK_NYLIUM = register("moon_rock_nylium", MoonRock::new, AbstractBlock.Settings.create()
            .solid()
            .sounds(BlockSoundGroup.NYLIUM)
            .strength(1)
            .requiresTool()
            .strength(1.5F, 6.0F)
            .mapColor(MapColor.PALE_PURPLE)
    );
    public static final Block MOON_ROCK_BRICKS = register("moon_rock_bricks", Block::new, AbstractBlock.Settings.create()
            .solid()
            .sounds(BlockSoundGroup.STONE)
            .requiresTool()
            .strength(1.5F, 6.0F)
            .mapColor(MapColor.WHITE)
    );
    public static final Block MOON_ROCK_BRICKS_SLAB = register("moon_rock_bricks_slab", SlabBlock::new, AbstractBlock.Settings.create()
            .solid()
            .sounds(BlockSoundGroup.STONE)
            .requiresTool()
            .strength(1.5F, 6.0F)
            .mapColor(MapColor.WHITE)
    );
    public static final Block MOON_ROCK_BRICKS_STAIRS = register("moon_rock_bricks_stairs", (AbstractBlock.Settings settings) -> new StairsBlock(MOON_ROCK_BRICKS.getDefaultState(), (AbstractBlock.Settings)settings), AbstractBlock.Settings.create()
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
    public static final Block SMOOTH_BLACK_MOON_ROCK = register("smooth_black_moon_rock", Block::new, AbstractBlock.Settings.create()
            .solid()
            .sounds(BlockSoundGroup.STONE)
            .requiresTool()
            .strength(1.8F, 7.5F)
            .mapColor(MapColor.PURPLE)
    );
    public static final Block MOON_ROCK_TILES = register("moon_rock_tiles", Block::new, AbstractBlock.Settings.create()
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
    public static final Block STRIPPED_MOON_LOG = register("stripped_moon_log", StrippedMoonLog::new, AbstractBlock.Settings.create()
            .solid()
            .sounds(BlockSoundGroup.WOOD)
            .strength(2.0F)
            .mapColor(MapColor.WHITE)
    );
    public static final Block STRIPPED_CURVE_LOG = register("stripped_curve_log", StrippedMoonLog::new, AbstractBlock.Settings.create()
            .solid()
            .sounds(BlockSoundGroup.WOOD)
            .strength(2.0F)
            .mapColor(MapColor.PALE_PURPLE)
    );
    public static final Block MOON_LOG = register("moon_log", (settings) -> new MoonLog(STRIPPED_MOON_LOG, settings), AbstractBlock.Settings.create()
            .solid()
            .sounds(BlockSoundGroup.WOOD)
            .strength(2.0F)
            .mapColor(blockState -> blockState.get(Properties.AXIS).equals(Direction.Axis.Y) ? MapColor.WHITE : MapColor.PURPLE)
    );
    public static final Block CURVE_LOG = register("curve_log", (settings) -> new MoonLog(STRIPPED_CURVE_LOG, settings), AbstractBlock.Settings.create()
            .solid()
            .sounds(BlockSoundGroup.WOOD)
            .strength(2.0F)
            .mapColor(blockState -> blockState.get(Properties.AXIS).equals(Direction.Axis.Y) ? MapColor.WHITE : MapColor.PURPLE)
    );
    public static final Block CURVE_LEAVES = register("curve_leaves", (settings) -> new CustomLeaves(Colors.LIGHT_RED, settings), AbstractBlock.Settings.create()
            .solid()
            .nonOpaque()
            .sounds(BlockSoundGroup.GRASS)
            .strength(0.2F)
            .mapColor(MapColor.PINK)
    );
    // MOON_PLANKS
    public static final Block MOON_PLANKS = register("moon_planks", MoonPlanks::new, AbstractBlock.Settings.create()
            .solid()
            .sounds(BlockSoundGroup.WOOD)
            .instrument(NoteBlockInstrument.BASS)
            .strength(2.0F)
            .mapColor(MapColor.WHITE)
    );
    public static final Block MOON_PLANKS_DOOR = register("moon_planks_door", (settings) -> new DoorBlock(BlockSetType.OAK, (AbstractBlock.Settings)  settings), AbstractBlock.Settings.create()
            .solid()
            .nonOpaque()
            .sounds(BlockSoundGroup.WOOD)
            .instrument(NoteBlockInstrument.BASS)
            .strength(2.0F)
            .mapColor(MapColor.WHITE)
    );
    public static final Block MOON_PLANKS_SLAB = register("moon_planks_slab", SlabBlock::new, AbstractBlock.Settings.create()
            .solid()
            .sounds(BlockSoundGroup.WOOD)
            .instrument(NoteBlockInstrument.BASS)
            .strength(2.0F)
            .mapColor(MapColor.WHITE)
    );
    public static final Block MOON_PLANKS_STAIRS = register("moon_planks_stairs", (AbstractBlock.Settings settings) -> new StairsBlock(MOON_PLANKS.getDefaultState(), (AbstractBlock.Settings)settings), AbstractBlock.Settings.create()
            .solid()
            .sounds(BlockSoundGroup.WOOD)
            .instrument(NoteBlockInstrument.BASS)
            .strength(2.0F)
            .mapColor(MapColor.WHITE)
    );
    public static final Block MOON_PLANKS_FENCE = register("moon_planks_fence", FenceBlock::new, AbstractBlock.Settings.create()
            .solid()
            .sounds(BlockSoundGroup.WOOD)
            .instrument(NoteBlockInstrument.BASS)
            .strength(2.0F)
            .mapColor(MapColor.WHITE)
    );
    public static final Block MOON_PLANKS_FENCE_GATE = register("moon_planks_fence_gate", (AbstractBlock.Settings settings) -> new FenceGateBlock(WoodType.OAK, (AbstractBlock.Settings)settings), AbstractBlock.Settings.create()
            .solid()
            .sounds(BlockSoundGroup.WOOD)
            .instrument(NoteBlockInstrument.BASS)
            .strength(2.0F)
            .mapColor(MapColor.WHITE)
    );
    public static final Block MOON_PLANKS_BUTTON = register("moon_planks_button", (AbstractBlock.Settings settings) -> new ButtonBlock(BlockSetType.OAK, 30, (AbstractBlock.Settings) settings), AbstractBlock.Settings.create()
            .noCollision()
            .sounds(BlockSoundGroup.WOOD)
            .instrument(NoteBlockInstrument.BASS)
            .strength(1.0F)
            .mapColor(MapColor.WHITE)
    );
    public static final Block RED_MOON_PLANKS = register("red_moon_planks", MoonPlanks::new, AbstractBlock.Settings.create()
            .solid()
            .sounds(BlockSoundGroup.WOOD)
            .instrument(NoteBlockInstrument.BASS)
            .strength(2.0F)
            .mapColor(MapColor.RED)
    );
    public static final Block RED_MOON_PLANKS_SLAB = register("red_moon_planks_slab", SlabBlock::new, AbstractBlock.Settings.create()
            .solid()
            .sounds(BlockSoundGroup.WOOD)
            .instrument(NoteBlockInstrument.BASS)
            .strength(2.0F)
            .mapColor(MapColor.RED)
    );
    public static final Block RED_MOON_PLANKS_STAIRS = register("red_moon_planks_stairs", (AbstractBlock.Settings settings) -> new StairsBlock(RED_MOON_PLANKS.getDefaultState(), (AbstractBlock.Settings)settings), AbstractBlock.Settings.create()
            .solid()
            .sounds(BlockSoundGroup.WOOD)
            .instrument(NoteBlockInstrument.BASS)
            .strength(2.0F)
            .mapColor(MapColor.RED)
    );
    public static final Block RED_MOON_PLANKS_FENCE = register("red_moon_planks_fence", FenceBlock::new, AbstractBlock.Settings.create()
            .solid()
            .sounds(BlockSoundGroup.WOOD)
            .instrument(NoteBlockInstrument.BASS)
            .strength(2.0F)
            .mapColor(MapColor.RED)
    );
    public static final Block RED_MOON_PLANKS_FENCE_GATE = register("red_moon_planks_fence_gate", (AbstractBlock.Settings settings) -> new FenceGateBlock(WoodType.OAK, (AbstractBlock.Settings)settings), AbstractBlock.Settings.create()
            .solid()
            .sounds(BlockSoundGroup.WOOD)
            .instrument(NoteBlockInstrument.BASS)
            .strength(2.0F)
            .mapColor(MapColor.RED)
    );
    public static final Block RED_MOON_PLANKS_BUTTON = register("red_moon_planks_button", (AbstractBlock.Settings settings) -> new ButtonBlock(BlockSetType.OAK, 30, (AbstractBlock.Settings) settings), AbstractBlock.Settings.create()
            .noCollision()
            .sounds(BlockSoundGroup.WOOD)
            .instrument(NoteBlockInstrument.BASS)
            .strength(1.0F)
            .mapColor(MapColor.RED)
    );
    public static final Block BLUE_MOON_PLANKS = register("blue_moon_planks", MoonPlanks::new, AbstractBlock.Settings.create()
            .solid()
            .sounds(BlockSoundGroup.WOOD)
            .instrument(NoteBlockInstrument.BASS)
            .strength(2.0F)
            .mapColor(MapColor.BLUE)
    );
    public static final Block BLUE_MOON_PLANKS_SLAB = register("blue_moon_planks_slab", SlabBlock::new, AbstractBlock.Settings.create()
            .solid()
            .sounds(BlockSoundGroup.WOOD)
            .instrument(NoteBlockInstrument.BASS)
            .strength(2.0F)
            .mapColor(MapColor.BLUE)
    );
    public static final Block BLUE_MOON_PLANKS_STAIRS = register("blue_moon_planks_stairs", (AbstractBlock.Settings settings) -> new StairsBlock(BLUE_MOON_PLANKS.getDefaultState(), (AbstractBlock.Settings)settings), AbstractBlock.Settings.create()
            .solid()
            .sounds(BlockSoundGroup.WOOD)
            .instrument(NoteBlockInstrument.BASS)
            .strength(2.0F)
            .mapColor(MapColor.BLUE)
    );
    public static final Block BLUE_MOON_PLANKS_FENCE = register("blue_moon_planks_fence", FenceBlock::new, AbstractBlock.Settings.create()
            .solid()
            .sounds(BlockSoundGroup.WOOD)
            .instrument(NoteBlockInstrument.BASS)
            .strength(2.0F)
            .mapColor(MapColor.BLUE)
    );
    public static final Block BLUE_MOON_PLANKS_FENCE_GATE = register("blue_moon_planks_fence_gate", (AbstractBlock.Settings settings) -> new FenceGateBlock(WoodType.OAK, (AbstractBlock.Settings)settings), AbstractBlock.Settings.create()
            .solid()
            .sounds(BlockSoundGroup.WOOD)
            .instrument(NoteBlockInstrument.BASS)
            .strength(2.0F)
            .mapColor(MapColor.BLUE)
    );
    public static final Block BLUE_MOON_PLANKS_BUTTON = register("blue_moon_planks_button", (AbstractBlock.Settings settings) -> new ButtonBlock(BlockSetType.OAK, 30, (AbstractBlock.Settings) settings), AbstractBlock.Settings.create()
            .noCollision()
            .sounds(BlockSoundGroup.WOOD)
            .instrument(NoteBlockInstrument.BASS)
            .strength(1.0F)
            .mapColor(MapColor.BLUE)
    );
    public static final Block YELLOW_MOON_PLANKS = register("yellow_moon_planks", MoonPlanks::new, AbstractBlock.Settings.create()
            .solid()
            .sounds(BlockSoundGroup.WOOD)
            .instrument(NoteBlockInstrument.BASS)
            .strength(2.0F)
            .mapColor(MapColor.YELLOW)
    );
    public static final Block YELLOW_MOON_PLANKS_SLAB = register("yellow_moon_planks_slab", SlabBlock::new, AbstractBlock.Settings.create()
            .solid()
            .sounds(BlockSoundGroup.WOOD)
            .instrument(NoteBlockInstrument.BASS)
            .strength(2.0F)
            .mapColor(MapColor.YELLOW)
    );
    public static final Block YELLOW_MOON_PLANKS_STAIRS = register("yellow_moon_planks_stairs", (AbstractBlock.Settings settings) -> new StairsBlock(YELLOW_MOON_PLANKS.getDefaultState(), (AbstractBlock.Settings)settings), AbstractBlock.Settings.create()
            .solid()
            .sounds(BlockSoundGroup.WOOD)
            .instrument(NoteBlockInstrument.BASS)
            .strength(2.0F)
            .mapColor(MapColor.YELLOW)
    );
    public static final Block YELLOW_MOON_PLANKS_FENCE = register("yellow_moon_planks_fence", FenceBlock::new, AbstractBlock.Settings.create()
            .solid()
            .sounds(BlockSoundGroup.WOOD)
            .instrument(NoteBlockInstrument.BASS)
            .strength(2.0F)
            .mapColor(MapColor.YELLOW)
    );
    public static final Block YELLOW_MOON_PLANKS_FENCE_GATE = register("yellow_moon_planks_fence_gate", (AbstractBlock.Settings settings) -> new FenceGateBlock(WoodType.OAK, (AbstractBlock.Settings)settings), AbstractBlock.Settings.create()
            .solid()
            .sounds(BlockSoundGroup.WOOD)
            .instrument(NoteBlockInstrument.BASS)
            .strength(2.0F)
            .mapColor(MapColor.YELLOW)
    );
    public static final Block YELLOW_MOON_PLANKS_BUTTON = register("yellow_moon_planks_button", (AbstractBlock.Settings settings) -> new ButtonBlock(BlockSetType.OAK, 30, (AbstractBlock.Settings) settings), AbstractBlock.Settings.create()
            .noCollision()
            .sounds(BlockSoundGroup.WOOD)
            .instrument(NoteBlockInstrument.BASS)
            .strength(1.0F)
            .mapColor(MapColor.YELLOW)
    );
    public static final Block PURPLE_MOON_PLANKS = register("purple_moon_planks", MoonPlanks::new, AbstractBlock.Settings.create()
            .solid()
            .sounds(BlockSoundGroup.WOOD)
            .instrument(NoteBlockInstrument.BASS)
            .strength(2.0F)
            .mapColor(MapColor.PALE_PURPLE)
    );
    public static final Block PURPLE_MOON_PLANKS_SLAB = register("purple_moon_planks_slab", SlabBlock::new, AbstractBlock.Settings.create()
            .solid()
            .sounds(BlockSoundGroup.WOOD)
            .instrument(NoteBlockInstrument.BASS)
            .strength(2.0F)
            .mapColor(MapColor.PALE_PURPLE)
    );
    public static final Block PURPLE_MOON_PLANKS_STAIRS = register("purple_moon_planks_stairs", (AbstractBlock.Settings settings) -> new StairsBlock(PURPLE_MOON_PLANKS.getDefaultState(), (AbstractBlock.Settings)settings), AbstractBlock.Settings.create()
            .solid()
            .sounds(BlockSoundGroup.WOOD)
            .instrument(NoteBlockInstrument.BASS)
            .strength(2.0F)
            .mapColor(MapColor.PALE_PURPLE)
    );
    public static final Block PURPLE_MOON_PLANKS_FENCE = register("purple_moon_planks_fence", FenceBlock::new, AbstractBlock.Settings.create()
            .solid()
            .sounds(BlockSoundGroup.WOOD)
            .instrument(NoteBlockInstrument.BASS)
            .strength(2.0F)
            .mapColor(MapColor.PALE_PURPLE)
    );
    public static final Block PURPLE_MOON_PLANKS_FENCE_GATE = register("purple_moon_planks_fence_gate", (AbstractBlock.Settings settings) -> new FenceGateBlock(WoodType.OAK, (AbstractBlock.Settings)settings), AbstractBlock.Settings.create()
            .solid()
            .sounds(BlockSoundGroup.WOOD)
            .instrument(NoteBlockInstrument.BASS)
            .strength(2.0F)
            .mapColor(MapColor.PALE_PURPLE)
    );
    public static final Block PURPLE_MOON_PLANKS_BUTTON = register("purple_moon_planks_button", (AbstractBlock.Settings settings) -> new ButtonBlock(BlockSetType.OAK, 30, (AbstractBlock.Settings) settings), AbstractBlock.Settings.create()
            .noCollision()
            .sounds(BlockSoundGroup.WOOD)
            .instrument(NoteBlockInstrument.BASS)
            .strength(1.0F)
            .mapColor(MapColor.PALE_PURPLE)
    );
    public static final Block MOON_LEAVES = register("moon_leaves", (settings) -> new MoonLeaves(Colors.PURPLE, settings), AbstractBlock.Settings.create()
            .solid()
            .nonOpaque()
            .ticksRandomly()
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
    public static final Block CURVE_SAPLING = register("curve_sapling", CurveSapling::new, AbstractBlock.Settings.create()
            .noCollision()
            .sounds(BlockSoundGroup.GRASS)
            .ticksRandomly()
            .breakInstantly()
    );
    public static final Block MOON_GRASS = register("moon_grass", MoonGrass::new, AbstractBlock.Settings.create()
            .mapColor(MapColor.PURPLE)
            .noCollision()
            .breakInstantly()
            .sounds(BlockSoundGroup.GRASS)
            .offset(AbstractBlock.OffsetType.XZ)
            .pistonBehavior(PistonBehavior.DESTROY)
    );
    public static final Block MOON_FERN = register("moon_fern", MoonFern::new, AbstractBlock.Settings.create()
            .mapColor(MapColor.PURPLE)
            .noCollision()
            .breakInstantly()
            .sounds(BlockSoundGroup.GRASS)
            .offset(AbstractBlock.OffsetType.XZ)
            .pistonBehavior(PistonBehavior.DESTROY)
    );
    public static final Block TALL_MOON_GRASS = register("tall_moon_grass", TallMoonGrass::new, AbstractBlock.Settings.create()
            .mapColor(MapColor.PURPLE)
            .noCollision()
            .breakInstantly()
            .sounds(BlockSoundGroup.GRASS)
            .offset(AbstractBlock.OffsetType.XZ)
            .pistonBehavior(PistonBehavior.DESTROY)
    );
    // CURVE PLANKS
    public static final Block CURVE_PLANKS = register("curve_planks", Block::new, AbstractBlock.Settings.create()
            .solid()
            .sounds(BlockSoundGroup.WOOD)
            .instrument(NoteBlockInstrument.BASS)
            .strength(2.0F)
            .mapColor(MapColor.PURPLE)
    );
    public static final Block CURVE_PLANKS_SLAB = register("curve_planks_slab", SlabBlock::new, AbstractBlock.Settings.create()
            .solid()
            .sounds(BlockSoundGroup.WOOD)
            .instrument(NoteBlockInstrument.BASS)
            .strength(2.0F)
            .mapColor(MapColor.PURPLE)
    );
    public static final Block CURVE_PLANKS_STAIRS = register("curve_planks_stairs", (AbstractBlock.Settings settings) -> new StairsBlock(CURVE_PLANKS.getDefaultState(), (AbstractBlock.Settings)settings), AbstractBlock.Settings.create()
            .solid()
            .sounds(BlockSoundGroup.WOOD)
            .instrument(NoteBlockInstrument.BASS)
            .strength(2.0F)
            .mapColor(MapColor.PURPLE)
    );
    public static final Block CURVE_PLANKS_FENCE = register("curve_planks_fence", FenceBlock::new, AbstractBlock.Settings.create()
            .solid()
            .sounds(BlockSoundGroup.WOOD)
            .instrument(NoteBlockInstrument.BASS)
            .strength(2.0F)
            .mapColor(MapColor.PURPLE)
    );
    public static final Block CURVE_PLANKS_FENCE_GATE = register("curve_planks_fence_gate", (AbstractBlock.Settings settings) -> new FenceGateBlock(WoodType.OAK, (AbstractBlock.Settings)settings), AbstractBlock.Settings.create()
            .solid()
            .sounds(BlockSoundGroup.WOOD)
            .instrument(NoteBlockInstrument.BASS)
            .strength(2.0F)
            .mapColor(MapColor.PURPLE)
    );
    public static final Block CURVE_PLANKS_BUTTON = register("curve_planks_button", (AbstractBlock.Settings settings) -> new ButtonBlock(BlockSetType.OAK, 30, (AbstractBlock.Settings) settings), AbstractBlock.Settings.create()
            .noCollision()
            .sounds(BlockSoundGroup.WOOD)
            .instrument(NoteBlockInstrument.BASS)
            .strength(1.0F)
            .mapColor(MapColor.PURPLE)
    );
    public static final Block PURPLE_MUSHROOM_BLOCK = register("purple_mushroom_block", MushroomBlock::new, AbstractBlock.Settings.create()
            .mapColor(MapColor.RED)
            .instrument(NoteBlockInstrument.BASS)
            .strength(0.2f)
            .sounds(BlockSoundGroup.WOOD)
            .burnable()
    );
    public static final Block GEODE_FRUIT = register("geode_fruit_block", GeodeFruit::new, AbstractBlock.Settings.create()
            .strength(1.0f)
            .noCollision()
            .ticksRandomly()
            .sounds(BlockSoundGroup.STONE)
    );
    public static final Block STAR_TRAP = register("star_trap", StarTrap::new, AbstractBlock.Settings.create()
            .mapColor(MapColor.PURPLE)
            .noCollision()
            .breakInstantly()
            .sounds(BlockSoundGroup.GRASS)
            .pistonBehavior(PistonBehavior.DESTROY)
    );

    public static void init() {
        COLORED_PLANKS.put(ModItems.RED_STAR, MoonBlocks.RED_MOON_PLANKS.getDefaultState());
        COLORED_PLANKS.put(ModItems.BLUE_STAR, MoonBlocks.BLUE_MOON_PLANKS.getDefaultState());
        COLORED_PLANKS.put(ModItems.YELLOW_STAR, MoonBlocks.YELLOW_MOON_PLANKS.getDefaultState());
        COLORED_PLANKS.put(ModItems.PURPLE_STAR, MoonBlocks.PURPLE_MOON_PLANKS.getDefaultState());
    }
}
