package com.github.wilwe21.stargazer.block;

import com.github.wilwe21.stargazer.Stargazer;
import com.github.wilwe21.stargazer.block.border.BorderBlock;
import com.github.wilwe21.stargazer.block.cosmic.CosmicBlock;
import com.github.wilwe21.stargazer.block.grave.Grave;
import com.github.wilwe21.stargazer.block.negative.NegativeBlock;
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
            .pistonBehavior(PistonBehavior.BLOCK)
    );
    public static final Block BORDER_BLOCK = register("border_block", BorderBlock::new, AbstractBlock.Settings.create()
            .nonOpaque()
            .solid()
            .pistonBehavior(PistonBehavior.BLOCK)
    );
    public static final Block MOON_ROCK = register("moon_rock", Block::new, AbstractBlock.Settings.create()
            .solid()
            .sounds(BlockSoundGroup.STONE)
    );
    public static final Block MOON_ROCK_BRICKS = register("moon_rock_bricks", Block::new, AbstractBlock.Settings.create()
            .solid()
            .sounds(BlockSoundGroup.STONE)
    );
    public static final Block CRACKED_MOON_ROCK_BRICKS = register("cracked_moon_rock_bricks", Block::new, AbstractBlock.Settings.create()
            .solid()
            .sounds(BlockSoundGroup.STONE)
    );
    public static final Block CHISELED_MOON_ROCK_BRICKS = register("chiseled_moon_rock_bricks", Block::new, AbstractBlock.Settings.create()
            .solid()
            .sounds(BlockSoundGroup.STONE)
    );

    private static Block register(String path, Function<AbstractBlock.Settings, Block> factory, AbstractBlock.Settings settings) {
        final Identifier identifier = Identifier.of(Stargazer.MOD_ID, path);
        final RegistryKey<Block> registryKey = RegistryKey.of(RegistryKeys.BLOCK, identifier);
        final Block block = Blocks.register(registryKey, factory, settings);
        Items.register(block);
        return block;
    }

    public static void init() {}
}
