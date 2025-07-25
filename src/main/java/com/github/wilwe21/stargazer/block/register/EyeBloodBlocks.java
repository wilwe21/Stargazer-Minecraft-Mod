package com.github.wilwe21.stargazer.block.register;

import com.github.wilwe21.stargazer.block.clases.CustomLeaves;
import com.github.wilwe21.stargazer.block.clases.eyes.EyeLog;
import com.github.wilwe21.stargazer.block.clases.eyes.StrippedEyeLog;
import com.github.wilwe21.stargazer.block.clases.moon.leaves.MoonLeaves;
import net.minecraft.block.*;
import net.minecraft.sound.BlockSoundGroup;
import net.minecraft.state.property.Properties;
import net.minecraft.util.Colors;
import net.minecraft.util.math.Direction;

import static com.github.wilwe21.stargazer.block.ModBlock.register;

public class EyeBloodBlocks {

    public static final Block STRIPPED_EYE_LOG = register("stripped_eye_log", StrippedEyeLog::new, AbstractBlock.Settings.create()
            .solid()
            .sounds(BlockSoundGroup.WOOD)
            .strength(2.15F)
            .mapColor(MapColor.PALE_YELLOW)
    );
    public static final Block EYE_LOG = register("eye_log", (settings) -> new EyeLog(STRIPPED_EYE_LOG, settings), AbstractBlock.Settings.create()
            .solid()
            .sounds(BlockSoundGroup.WOOD)
            .strength(2.15F)
            .ticksRandomly()
            .mapColor(blockState -> blockState.get(Properties.AXIS).equals(Direction.Axis.Y) ? MapColor.YELLOW : MapColor.WHITE)
    );

    public static final Block EYE_LEAVES = register("eye_leaves", (settings) -> new CustomLeaves(Colors.RED, settings), AbstractBlock.Settings.create()
            .solid()
            .nonOpaque()
            .sounds(BlockSoundGroup.GRASS)
            .strength(0.175F)
            .mapColor(MapColor.RED)
    );

    public static void init() {}
}
