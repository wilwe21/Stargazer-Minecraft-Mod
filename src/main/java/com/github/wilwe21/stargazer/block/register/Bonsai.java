package com.github.wilwe21.stargazer.block.register;

import com.github.wilwe21.stargazer.block.clases.bonsai.BonsaiLog;
import net.minecraft.block.AbstractBlock;
import net.minecraft.block.Block;
import net.minecraft.block.MapColor;
import net.minecraft.sound.BlockSoundGroup;
import net.minecraft.state.property.Properties;
import net.minecraft.util.math.Direction;

import static com.github.wilwe21.stargazer.block.ModBlock.register;

public class Bonsai {
    public static final Block BONSAI_LOG = register("bonsai_log", BonsaiLog::new, AbstractBlock.Settings.create()
            .solid()
            .sounds(BlockSoundGroup.WOOD)
            .strength(2.0F)
            .mapColor(blockState -> blockState.get(Properties.AXIS).equals(Direction.Axis.Y) ? MapColor.RAW_IRON_PINK : MapColor.BROWN)
    );
    public static void init() {}
}
