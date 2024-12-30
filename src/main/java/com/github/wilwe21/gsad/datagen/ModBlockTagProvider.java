package com.github.wilwe21.gsad.datagen;

import com.github.wilwe21.gsad.block.ModBlock;
import net.fabricmc.fabric.api.datagen.v1.FabricDataOutput;
import net.fabricmc.fabric.api.datagen.v1.provider.FabricTagProvider;
import net.minecraft.registry.RegistryWrapper;
import net.minecraft.registry.tag.BlockTags;

import java.util.concurrent.CompletableFuture;

public class ModBlockTagProvider extends FabricTagProvider.BlockTagProvider {
    public ModBlockTagProvider(FabricDataOutput output, CompletableFuture<RegistryWrapper.WrapperLookup> registriesFuture) {
        super(output, registriesFuture);
    }

    @Override
    protected void configure(RegistryWrapper.WrapperLookup wrapperLookup) {
        getOrCreateTagBuilder(BlockTags.PICKAXE_MINEABLE)
                .add(ModBlock.TV_BLOCK)
                .add(ModBlock.SPIKES)
                .add(ModBlock.SCAFFOLDING);

        getOrCreateTagBuilder(BlockTags.HOE_MINEABLE)
                .add(ModBlock.DREAM_BLOCK);

        getOrCreateTagBuilder(BlockTags.NEEDS_IRON_TOOL)
                .add(ModBlock.SCAFFOLDING)
                .add(ModBlock.TV_BLOCK);
    }
}
