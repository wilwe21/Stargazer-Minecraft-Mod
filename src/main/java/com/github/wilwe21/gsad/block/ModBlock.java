package com.github.wilwe21.gsad.block;

import com.github.wilwe21.gsad.Gsad;
import com.github.wilwe21.gsad.block.custom.*;
import com.github.wilwe21.gsad.block.custom.blockEntity.dream.DreamBlock;
import com.github.wilwe21.gsad.block.custom.blockEntity.spinner.Spinner;
import com.github.wilwe21.gsad.block.custom.blockEntity.strawberry.Strawberry;
import com.github.wilwe21.gsad.block.custom.blockEntity.tv.Tv;
import net.minecraft.block.*;
import net.minecraft.block.piston.PistonBehavior;
import net.minecraft.item.Items;
import net.minecraft.registry.RegistryKey;
import net.minecraft.registry.RegistryKeys;
import net.minecraft.sound.BlockSoundGroup;
import net.minecraft.util.Identifier;

import java.util.function.Function;

public class ModBlock {
    public static final Block DREAM_BLOCK = register("dream_block", DreamBlock::new, AbstractBlock.Settings.create()
            .solid()
            .strength(0.0f)
            .sounds(BlockSoundGroup.AMETHYST_BLOCK)
            .pistonBehavior(PistonBehavior.BLOCK)
            .luminance(DreamBlock::getLuminance)
    );
    public static final Block TV_BLOCK = register("tv", Tv::new, AbstractBlock.Settings.create()
            .solid()
            .pistonBehavior(PistonBehavior.BLOCK)
    );
    public static final Block SCAFFOLDING = register("scaffolding", Block::new, AbstractBlock.Settings.create()
            .strength(4.0f)
            .solid()
            .sounds(BlockSoundGroup.METAL)
    );
    public static final Block SPINNER = register("spinner", Spinner::new, AbstractBlock.Settings.create()
            .noCollision()
            .pistonBehavior(PistonBehavior.DESTROY)
    );
    public static final Block SPIKES = register("spikes", Spikes::new, AbstractBlock.Settings.create()
            .noCollision()
            .pistonBehavior(PistonBehavior.DESTROY)
    );
    public static final Block STRAWBERRY = register("strawberry", Strawberry::new, AbstractBlock.Settings.create()
            .noCollision()
            .pistonBehavior(PistonBehavior.BLOCK)
    );
    public static final Block SPRING = register("spring", Spring::new, AbstractBlock.Settings.create()
            .pistonBehavior(PistonBehavior.BLOCK)
    );

    private static Block register(String path, Function<AbstractBlock.Settings, Block> factory, AbstractBlock.Settings settings) {
        final Identifier identifier = Identifier.of(Gsad.MOD_ID, path);
        final RegistryKey<Block> registryKey = RegistryKey.of(RegistryKeys.BLOCK, identifier);
        final Block block = Blocks.register(registryKey, factory, settings);
        Items.register(block);
        return block;
    }

    public static void init() {}
}
