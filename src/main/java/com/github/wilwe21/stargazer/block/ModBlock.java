package com.github.wilwe21.stargazer.block;

import com.github.wilwe21.stargazer.Stargazer;
import com.github.wilwe21.stargazer.block.clases.border.BorderBlock;
import com.github.wilwe21.stargazer.block.clases.cosmic.CosmicBlock;
import com.github.wilwe21.stargazer.block.clases.grave.Grave;
import com.github.wilwe21.stargazer.block.clases.negative.NegativeBlock;
import com.github.wilwe21.stargazer.block.register.MoonRocks;
import com.github.wilwe21.stargazer.sound.SoundGroups;
import net.minecraft.block.*;
import net.minecraft.block.piston.PistonBehavior;
import net.minecraft.item.Items;
import net.minecraft.registry.RegistryKey;
import net.minecraft.registry.RegistryKeys;
import net.minecraft.sound.BlockSoundGroup;
import net.minecraft.util.Identifier;

import java.util.function.Function;

public class ModBlock {
    public static final Block GRAVE = register("grave", Grave::new, AbstractBlock.Settings.create()
            .strength(1.0f)
            .nonOpaque()
            .sounds(BlockSoundGroup.STONE)
            .pistonBehavior(PistonBehavior.DESTROY)
    );
    public static final Block NEGATIVE_BLOCK = register("negative_block", NegativeBlock::new, AbstractBlock.Settings.create()
            .nonOpaque()
            .noCollision()
            .pistonBehavior(PistonBehavior.BLOCK)
    );
    public static final Block COSMIC_BLOCK = register("cosmic_block", CosmicBlock::new, AbstractBlock.Settings.create()
            .nonOpaque()
            .noCollision()
            .sounds(SoundGroups.STAR)
            .pistonBehavior(PistonBehavior.BLOCK)
    );
    public static final Block BORDER_BLOCK = register("border_block", BorderBlock::new, AbstractBlock.Settings.create()
            .nonOpaque()
            .solid()
            .pistonBehavior(PistonBehavior.BLOCK)
    );

    public static Block register(String path, Function<AbstractBlock.Settings, Block> factory, AbstractBlock.Settings settings) {
        final Identifier identifier = Identifier.of(Stargazer.MOD_ID, path);
        final RegistryKey<Block> registryKey = RegistryKey.of(RegistryKeys.BLOCK, identifier);
        final Block block = Blocks.register(registryKey, factory, settings);
        Items.register(block);
        return block;
    }

    public static void init() {
        MoonRocks.init();
    }
}
