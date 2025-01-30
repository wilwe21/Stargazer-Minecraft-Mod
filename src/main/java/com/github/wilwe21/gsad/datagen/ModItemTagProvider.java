package com.github.wilwe21.gsad.datagen;

import com.github.wilwe21.gsad.item.ItemTags;
import com.github.wilwe21.gsad.item.ModItems;
import net.fabricmc.fabric.api.datagen.v1.FabricDataOutput;
import net.fabricmc.fabric.api.datagen.v1.provider.FabricTagProvider;
import net.minecraft.registry.RegistryWrapper;

import java.util.concurrent.CompletableFuture;

import static com.github.wilwe21.gsad.item.ItemTags.STARDUST;

public class ModItemTagProvider extends FabricTagProvider.ItemTagProvider {

    public ModItemTagProvider(FabricDataOutput output, CompletableFuture<RegistryWrapper.WrapperLookup> completableFuture) {
        super(output, completableFuture);
    }

    @Override
    protected void configure(RegistryWrapper.WrapperLookup wrapperLookup) {
        getOrCreateTagBuilder(STARDUST)
                .add(ModItems.STARDUST);
        getOrCreateTagBuilder(ItemTags.ICECREAM)
                .add(ModItems.GRAVICE);
    }
}
