package com.github.wilwe21.stargazer.datagen;

import com.github.wilwe21.stargazer.block.register.MoonBlocks;
import net.fabricmc.fabric.api.datagen.v1.FabricDataOutput;
import net.fabricmc.fabric.api.datagen.v1.provider.FabricTagProvider;
import net.minecraft.block.Block;
import net.minecraft.registry.RegistryWrapper;
import net.minecraft.registry.tag.BlockTags;
import net.minecraft.registry.tag.TagBuilder;
import org.apache.commons.compress.compressors.lz77support.LZ77Compressor;

import java.util.concurrent.CompletableFuture;

public class ModBlockTagProvider extends FabricTagProvider.BlockTagProvider {
    public ModBlockTagProvider(FabricDataOutput output, CompletableFuture<RegistryWrapper.WrapperLookup> registriesFuture) {
        super(output, registriesFuture);
    }

    @Override
    protected void configure(RegistryWrapper.WrapperLookup wrapperLookup) {
        // Wood
        getOrCreateTagBuilder(BlockTags.AXE_MINEABLE)
                .add(MoonBlocks.MOON_LOG)
                .add(MoonBlocks.STRIPPED_MOON_LOG)
                .add(MoonBlocks.MOON_PLANKS);
        getOrCreateTagBuilder(BlockTags.LOGS)
                .add(MoonBlocks.MOON_LOG);
        getOrCreateTagBuilder(BlockTags.HOE_MINEABLE).add(MoonBlocks.MOON_LEAVES);
        // Rock
        getOrCreateTagBuilder(BlockTags.PICKAXE_MINEABLE)
                .add(MoonBlocks.MOON_ROCK)
                .add(MoonBlocks.MOON_ROCK_NYLIUM)
                .add(MoonBlocks.MOON_ROCK_BRICKS)
                .add(MoonBlocks.CHISELED_MOON_ROCK_BRICKS)
                .add(MoonBlocks.CRACKED_MOON_ROCK_BRICKS)
                .add(MoonBlocks.BLACK_MOON_ROCK);
        getOrCreateTagBuilder(BlockTags.NEEDS_STONE_TOOL)
                .add(MoonBlocks.MOON_ROCK)
                .add(MoonBlocks.MOON_ROCK_NYLIUM)
                .add(MoonBlocks.MOON_ROCK_BRICKS)
                .add(MoonBlocks.CHISELED_MOON_ROCK_BRICKS)
                .add(MoonBlocks.CRACKED_MOON_ROCK_BRICKS);
        getOrCreateTagBuilder(BlockTags.NEEDS_IRON_TOOL)
                .add(MoonBlocks.BLACK_MOON_ROCK);
    }
}
