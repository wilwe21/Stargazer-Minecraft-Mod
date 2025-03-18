package com.github.wilwe21.stargazer.block.register;

import com.github.wilwe21.stargazer.block.clases.moon.MoonPlanks;
import com.github.wilwe21.stargazer.block.clases.moon.leaves.MoonLeaves;
import com.github.wilwe21.stargazer.block.clases.sapling.MoonSapling;
import com.github.wilwe21.stargazer.block.clases.sapling.StarSapling;
import com.github.wilwe21.stargazer.block.clases.star.barrier.StarBarrierBlock;
import com.github.wilwe21.stargazer.block.clases.star.border.BorderBlock;
import com.github.wilwe21.stargazer.block.clases.star.cosmic.CosmicBlock;
import com.github.wilwe21.stargazer.block.clases.moon.log.MoonLog;
import com.github.wilwe21.stargazer.block.clases.star.leaves.StarLeaves;
import com.github.wilwe21.stargazer.block.clases.star.log.StarLog;
import com.github.wilwe21.stargazer.block.clases.star.log.StrippedStarLog;
import com.github.wilwe21.stargazer.sound.SoundGroups;
import net.minecraft.block.AbstractBlock;
import net.minecraft.block.Block;
import net.minecraft.block.MapColor;
import net.minecraft.block.enums.NoteBlockInstrument;
import net.minecraft.block.piston.PistonBehavior;
import net.minecraft.sound.BlockSoundGroup;
import net.minecraft.state.property.Properties;
import net.minecraft.util.DyeColor;
import net.minecraft.util.math.Direction;

import static com.github.wilwe21.stargazer.block.ModBlock.register;

public class StarBlocks {
    public static final Block COSMIC_BLOCK = register("cosmic_block", CosmicBlock::new, AbstractBlock.Settings.create()
            .nonOpaque()
            .sounds(SoundGroups.STAR)
            .pistonBehavior(PistonBehavior.BLOCK)
    );
    public static final Block STAR_BARRIER_BLOCK = register("star_barrier_block", StarBarrierBlock::new, AbstractBlock.Settings.create()
            .nonOpaque()
            .sounds(SoundGroups.STAR)
            .pistonBehavior(PistonBehavior.BLOCK)
    );
    public static final Block BORDER_BLOCK = register("border_block", BorderBlock::new, AbstractBlock.Settings.create()
            .nonOpaque()
            .solid()
            .pistonBehavior(PistonBehavior.BLOCK)
    );
    public static final Block STAR_LOG = register("star_log", StarLog::new, AbstractBlock.Settings.create()
            .solid()
            .sounds(BlockSoundGroup.WOOD)
            .strength(2.0F)
            .mapColor(blockState -> blockState.get(Properties.AXIS).equals(Direction.Axis.Y) ? MapColor.WHITE : MapColor.PURPLE)
    );
    public static final Block STRIPPED_STAR_LOG = register("stripped_star_log", StrippedStarLog::new, AbstractBlock.Settings.create()
            .solid()
            .sounds(BlockSoundGroup.WOOD)
            .strength(2.0F)
            .mapColor(DyeColor.BLACK)
    );
    public static final Block STAR_PLANKS = register("star_planks", Block::new, AbstractBlock.Settings.create()
            .solid()
            .sounds(BlockSoundGroup.WOOD)
            .instrument(NoteBlockInstrument.BASS)
            .strength(2.0F)
            .mapColor(MapColor.BLACK)
    );
    public static final Block STAR_LEAVES = register("star_leaves", StarLeaves::new, AbstractBlock.Settings.create()
            .nonOpaque()
            .sounds(BlockSoundGroup.GRASS)
            .strength(0.2F)
            .mapColor(MapColor.YELLOW)
    );
    public static final Block STAR_SAPLING = register("star_sapling", StarSapling::new, AbstractBlock.Settings.create()
            .noCollision()
            .sounds(BlockSoundGroup.GRASS)
            .ticksRandomly()
            .breakInstantly()
    );
    public static void init() {

    }
}
