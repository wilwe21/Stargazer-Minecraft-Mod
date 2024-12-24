package com.github.wilwe21.celeste.block;

import com.github.wilwe21.celeste.Celeste;
import net.minecraft.block.*;
import net.minecraft.item.Items;
import net.minecraft.registry.RegistryKey;
import net.minecraft.registry.RegistryKeys;
import net.minecraft.sound.BlockSoundGroup;
import net.minecraft.util.Identifier;

import java.util.function.Function;

public class ModBlock {
    public static final Block DREAM_BLOCK = register("dream_block", DreamBlock::new, AbstractBlock.Settings.create()
            .strength(0.0f)
            .sounds(BlockSoundGroup.AMETHYST_BLOCK)
            .luminance(DreamBlock::getLuminance)
    );
    public static final Block SCAFFOLDING = register("scaffolding", Block::new, AbstractBlock.Settings.create()
            .strength(4.0f)
            .sounds(BlockSoundGroup.METAL)
    );

    private static Block register(String path, Function<AbstractBlock.Settings, Block> factory, AbstractBlock.Settings settings) {
        final Identifier identifier = Identifier.of(Celeste.MOD_ID, path);
        final RegistryKey<Block> registryKey = RegistryKey.of(RegistryKeys.BLOCK, identifier);
        final Block block = Blocks.register(registryKey, factory, settings);
        Items.register(block);
        return block;
    }

    public static void init() {}
}
