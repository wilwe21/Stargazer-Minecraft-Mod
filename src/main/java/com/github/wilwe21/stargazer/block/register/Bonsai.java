package com.github.wilwe21.stargazer.block.register;

import com.github.wilwe21.stargazer.block.clases.bonsai.LivingBonsaiLog;
import net.minecraft.block.AbstractBlock;
import net.minecraft.block.Block;
import net.minecraft.block.MapColor;
import net.minecraft.block.PillarBlock;
import net.minecraft.sound.BlockSoundGroup;
import net.minecraft.state.property.Properties;
import net.minecraft.util.math.Direction;

import static com.github.wilwe21.stargazer.block.ModBlock.register;

public class Bonsai {
    public static final Block LIVING_BONSAI_LOG = register("living_bonsai_log", LivingBonsaiLog::new, AbstractBlock.Settings.create()
            .solid()
            .ticksRandomly()
            .sounds(BlockSoundGroup.WOOD)
            .strength(2.0F)
            .mapColor(blockState -> blockState.get(Properties.AXIS).equals(Direction.Axis.Y) ? MapColor.RAW_IRON_PINK : MapColor.BROWN)
    );
    public static final Block BONSAI_LOG = register("bonsai_log", PillarBlock::new, AbstractBlock.Settings.create()
            .solid()
            .sounds(BlockSoundGroup.WOOD)
            .strength(2.0F)
            .mapColor(blockState -> blockState.get(Properties.AXIS).equals(Direction.Axis.Y) ? MapColor.RAW_IRON_PINK : MapColor.BROWN)
    );
    public static void init() {}
}
