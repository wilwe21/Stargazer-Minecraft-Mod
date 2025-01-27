package com.github.wilwe21.gsad.datagen;

import com.github.wilwe21.gsad.block.ModBlock;
import com.github.wilwe21.gsad.item.ModItems;
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
        // GSAD
        addDrop(ModBlock.COSMIC_BLOCK);
        addDrop(ModBlock.NEGATIVE_BLOCK);
        addDrop(ModBlock.GRAVE);
        // Celeste
        addDrop(ModBlock.TV_BLOCK);
        addDrop(ModBlock.DREAM_BLOCK, ModItems.STARDUST);
        addDrop(ModBlock.DUST_BUNNY);
        addDrop(ModBlock.SPIKES);
        addDrop(ModBlock.SPINNER);
        addDrop(ModBlock.SCAFFOLDING);
        addDrop(ModBlock.SPRING);
        // Mario
        addDrop(ModBlock.BRICK);
        addDrop(ModBlock.EMPTY_BLOCK);
        addDrop(ModBlock.LUCKY_BLOCK);
        addDrop(ModBlock.GROUND_BLOCK);
        // Sonic
        addDrop(ModBlock.Sonic_DIRT);
        addDrop(ModBlock.Sonic_GRASS);
    }
}
