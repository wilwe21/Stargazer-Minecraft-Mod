package com.github.wilwe21.stargazer.datagen;

import com.github.wilwe21.stargazer.block.ModBlock;
import com.github.wilwe21.stargazer.block.clases.sapling.StarSapling;
import com.github.wilwe21.stargazer.block.register.Bonsai;
import com.github.wilwe21.stargazer.block.register.MoonBlocks;
import com.github.wilwe21.stargazer.block.register.StarBlocks;
import net.fabricmc.fabric.api.datagen.v1.FabricDataOutput;
import net.fabricmc.fabric.api.datagen.v1.provider.FabricBlockLootTableProvider;
import net.minecraft.registry.RegistryWrapper;

import java.util.concurrent.CompletableFuture;

public class ModLootTableProvider extends FabricBlockLootTableProvider {
    public ModLootTableProvider(FabricDataOutput dataOutput, CompletableFuture<RegistryWrapper.WrapperLookup> registryLookup) {
        super(dataOutput, registryLookup);
    }

    @Override
    public void generate() {
        addDrop(ModBlock.NEGATIVE_BLOCK);
        addDrop(ModBlock.GRAVE);
        // Moon
        addDrop(MoonBlocks.MOON_LEAVES, leavesDrops(MoonBlocks.MOON_LEAVES, MoonBlocks.MOON_SAPLING, 0.035F));
        addDrop(MoonBlocks.MOON_ROCK_NYLIUM, drops(MoonBlocks.MOON_ROCK_NYLIUM, MoonBlocks.MOON_ROCK));
        addDrop(MoonBlocks.MOON_LOG);
        addDrop(MoonBlocks.MOON_SAPLING);
        addDrop(MoonBlocks.STRIPPED_MOON_LOG);
        addDrop(MoonBlocks.MOON_PLANKS);
        addDrop(MoonBlocks.MOON_PLANKS_STAIRS);
        addDrop(MoonBlocks.MOON_PLANKS_SLAB);
        addDrop(MoonBlocks.MOON_PLANKS_BUTTON);
        addDrop(MoonBlocks.MOON_PLANKS_FENCE);
        addDrop(MoonBlocks.MOON_PLANKS_FENCE_GATE);
        addDrop(MoonBlocks.RED_MOON_PLANKS);
        addDrop(MoonBlocks.RED_MOON_PLANKS_STAIRS);
        addDrop(MoonBlocks.RED_MOON_PLANKS_SLAB);
        addDrop(MoonBlocks.RED_MOON_PLANKS_BUTTON);
        addDrop(MoonBlocks.RED_MOON_PLANKS_FENCE);
        addDrop(MoonBlocks.RED_MOON_PLANKS_FENCE_GATE);
        addDrop(MoonBlocks.BLUE_MOON_PLANKS);
        addDrop(MoonBlocks.BLUE_MOON_PLANKS_STAIRS);
        addDrop(MoonBlocks.BLUE_MOON_PLANKS_SLAB);
        addDrop(MoonBlocks.BLUE_MOON_PLANKS_BUTTON);
        addDrop(MoonBlocks.BLUE_MOON_PLANKS_FENCE);
        addDrop(MoonBlocks.BLUE_MOON_PLANKS_FENCE_GATE);
        addDrop(MoonBlocks.PURPLE_MOON_PLANKS);
        addDrop(MoonBlocks.PURPLE_MOON_PLANKS_STAIRS);
        addDrop(MoonBlocks.PURPLE_MOON_PLANKS_SLAB);
        addDrop(MoonBlocks.PURPLE_MOON_PLANKS_BUTTON);
        addDrop(MoonBlocks.PURPLE_MOON_PLANKS_FENCE);
        addDrop(MoonBlocks.PURPLE_MOON_PLANKS_FENCE_GATE);
        addDrop(MoonBlocks.YELLOW_MOON_PLANKS);
        addDrop(MoonBlocks.YELLOW_MOON_PLANKS_STAIRS);
        addDrop(MoonBlocks.YELLOW_MOON_PLANKS_SLAB);
        addDrop(MoonBlocks.YELLOW_MOON_PLANKS_BUTTON);
        addDrop(MoonBlocks.YELLOW_MOON_PLANKS_FENCE);
        addDrop(MoonBlocks.YELLOW_MOON_PLANKS_FENCE_GATE);
        addDrop(MoonBlocks.MOON_ROCK);
        addDrop(MoonBlocks.MOON_ROCK_BRICKS);
        addDrop(MoonBlocks.MOON_ROCK_BRICKS_SLAB);
        addDrop(MoonBlocks.MOON_ROCK_BRICKS_STAIRS);
        addDrop(MoonBlocks.CHISELED_MOON_ROCK_BRICKS);
        addDrop(MoonBlocks.CRACKED_MOON_ROCK_BRICKS);
        addDrop(MoonBlocks.BLACK_MOON_ROCK);
        // Star
        addDrop(StarBlocks.COSMIC_BLOCK);
        addDrop(StarBlocks.STAR_LEAVES, leavesDrops(StarBlocks.STAR_LEAVES, StarBlocks.STAR_SAPLING, 0.035F));
        addDrop(StarBlocks.STAR_LOG);
        addDrop(StarBlocks.STRIPPED_STAR_LOG);
        addDrop(StarBlocks.STAR_PLANKS);
        addDrop(StarBlocks.STAR_PLANKS_STAIRS);
        addDrop(StarBlocks.STAR_PLANKS_SLAB);
        addDrop(StarBlocks.STAR_PLANKS_BUTTON);
        addDrop(StarBlocks.STAR_PLANKS_FENCE);
        addDrop(StarBlocks.STAR_PLANKS_FENCE_GATE);
        addDrop(StarBlocks.STAR_SAPLING);
        // Bonsai
//        addDrop(Bonsai.LIVING_BONSAI_LOG, Bonsai.BONSAI_LOG);
//        addDrop(Bonsai.BONSAI_LOG, Bonsai.BONSAI_LOG);
    }
}
