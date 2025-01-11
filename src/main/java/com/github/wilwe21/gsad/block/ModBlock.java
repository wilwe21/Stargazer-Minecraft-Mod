package com.github.wilwe21.gsad.block;

import com.github.wilwe21.gsad.Gsad;
import com.github.wilwe21.gsad.block.custom.Mario.brick.Brick;
import com.github.wilwe21.gsad.block.custom.Mario.empty.EmptyBlock;
import com.github.wilwe21.gsad.block.custom.Mario.lucky.LuckyBlock;
import com.github.wilwe21.gsad.block.custom.celeste.Spring;
import com.github.wilwe21.gsad.block.custom.celeste.Summit;
import com.github.wilwe21.gsad.block.custom.celeste.dream.DreamBlock;
import com.github.wilwe21.gsad.block.custom.celeste.Spikes;
import com.github.wilwe21.gsad.block.custom.celeste.dustbunny.DustBunny;
import com.github.wilwe21.gsad.block.custom.Sonic.ring.Ring;
import com.github.wilwe21.gsad.block.custom.celeste.spinner.Spinner;
import com.github.wilwe21.gsad.block.custom.celeste.strawberry.Strawberry;
import com.github.wilwe21.gsad.block.custom.celeste.tv.Tv;
import com.github.wilwe21.gsad.block.custom.random.Grave;
import net.minecraft.block.*;
import net.minecraft.block.piston.PistonBehavior;
import net.minecraft.item.Items;
import net.minecraft.registry.RegistryKey;
import net.minecraft.registry.RegistryKeys;
import net.minecraft.sound.BlockSoundGroup;
import net.minecraft.util.Identifier;

import java.util.function.Function;

public class ModBlock {
    // Random
    public static final Block GRAVE = register("grave", Grave::new, AbstractBlock.Settings.create()
            .strength(1.0f)
            .pistonBehavior(PistonBehavior.DESTROY)
    );
    // Celeste
    public static final Block SPRING = register("spring", Spring::new, AbstractBlock.Settings.create()
            .strength(1.0f)
            .pistonBehavior(PistonBehavior.BLOCK)
    );
    public static final Block DREAM_BLOCK = register("dream_block", DreamBlock::new, AbstractBlock.Settings.create()
            .solid()
            .strength(0.0f)
            .sounds(BlockSoundGroup.AMETHYST_BLOCK)
            .pistonBehavior(PistonBehavior.BLOCK)
            .luminance(DreamBlock::getLuminance)
    );
    public static final Block TV_BLOCK = register("tv", Tv::new, AbstractBlock.Settings.create()
            .strength(4.0f)
            .solid()
            .pistonBehavior(PistonBehavior.BLOCK)
    );
    public static final Block SCAFFOLDING = register("scaffolding", Block::new, AbstractBlock.Settings.create()
            .strength(2.0f)
            .solid()
            .sounds(BlockSoundGroup.METAL)
    );
    public static final Block SUMMIT = register("summit", Summit::new, AbstractBlock.Settings.create()
            .strength(1.0f)
            .solid()
            .sounds(BlockSoundGroup.WOOD)
    );
    public static final Block SPINNER = register("spinner", Spinner::new, AbstractBlock.Settings.create()
            .noCollision()
            .pistonBehavior(PistonBehavior.DESTROY)
    );
    public static final Block DUST_BUNNY = register("dust_bunny", DustBunny::new, AbstractBlock.Settings.create()
            .noCollision()
            .pistonBehavior(PistonBehavior.DESTROY)
    );
    public static final Block SPIKES = register("spikes", Spikes::new, AbstractBlock.Settings.create()
            .noCollision()
            .strength(2.0f)
            .pistonBehavior(PistonBehavior.DESTROY)
    );
    public static final Block STRAWBERRY = register("strawberry", Strawberry::new, AbstractBlock.Settings.create()
            .noCollision()
            .strength(999999999.0f)
            .pistonBehavior(PistonBehavior.BLOCK)
    );
    // Mario
    public static final Block LUCKY_BLOCK = register("lucky_block", LuckyBlock::new, AbstractBlock.Settings.create()
            .strength(2.0f)
            .solid()
    );
    public static final Block EMPTY_BLOCK = register("empty_block", EmptyBlock::new, AbstractBlock.Settings.create()
            .strength(2.0f)
            .solid()
    );
    public static final Block GROUND_BLOCK = register("ground_block", Block::new, AbstractBlock.Settings.create()
            .strength(2.0f)
            .solid()
    );
    public static final Block BRICK = register("brick", Brick::new, AbstractBlock.Settings.create()
            .strength(2.0f)
            .solid()
    );
    // Sonic
    public static final Block RING = register("ring", Ring::new, AbstractBlock.Settings.create()
            .noCollision()
            .strength(999999999.0f)
            .pistonBehavior(PistonBehavior.BLOCK)
    );
    public static final Block Sonic_DIRT = register("sonic_dirt", Block::new, AbstractBlock.Settings.create()
            .strength(1.0f)
            .solid()
            .sounds(BlockSoundGroup.GRASS)
    );
    public static final Block Sonic_GRASS = register("sonic_grass", Block::new, AbstractBlock.Settings.create()
            .strength(1.0f)
            .solid()
            .sounds(BlockSoundGroup.GRASS)
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
