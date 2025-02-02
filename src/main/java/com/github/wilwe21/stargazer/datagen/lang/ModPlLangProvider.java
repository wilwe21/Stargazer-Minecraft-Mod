package com.github.wilwe21.stargazer.datagen.lang;

import com.github.wilwe21.stargazer.CreativeTab.ItemGroup;
import com.github.wilwe21.stargazer.block.ModBlock;
import com.github.wilwe21.stargazer.item.ModItems;
import net.fabricmc.fabric.api.datagen.v1.FabricDataOutput;
import net.fabricmc.fabric.api.datagen.v1.provider.FabricLanguageProvider;
import net.minecraft.registry.RegistryWrapper;

import java.util.concurrent.CompletableFuture;

public class ModPlLangProvider extends FabricLanguageProvider {
    public ModPlLangProvider(FabricDataOutput dataGenerator, CompletableFuture<RegistryWrapper.WrapperLookup> registryLookup) {
        // Specifying en_us is optional, by default it is en_us.
        super(dataGenerator, "pl_pl", registryLookup);
    }
    @Override
    public void generateTranslations(RegistryWrapper.WrapperLookup wrapperLookup, TranslationBuilder translationBuilder) {
        translationBuilder.add(ItemGroup.STAR_GROUP_KEY, "Gwiazdo Gap");
        translationBuilder.add(ModBlock.GRAVE, "Grób");
        translationBuilder.add(ModBlock.NEGATIVE_BLOCK, "Negatywny Block");
        translationBuilder.add(ModBlock.COSMIC_BLOCK, "Niebo Kosmosu");
        translationBuilder.add(ModBlock.BORDER_BLOCK, "Block Granicy");
        translationBuilder.add(ModItems.GRAVICE, "Lody Żwirowe");
        translationBuilder.add(ModItems.STARDUST, "Gwiezdny pył");
    }
}
