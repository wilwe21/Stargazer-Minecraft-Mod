package com.github.wilwe21.gsad.datagen.lang;

import com.github.wilwe21.gsad.CreativeTab.ItemGroup;
import com.github.wilwe21.gsad.block.ModBlock;
import com.github.wilwe21.gsad.entity.ModEntity;
import com.github.wilwe21.gsad.item.ModItems;
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
        // GSAD
        translationBuilder.add(ItemGroup.GSAD_GROUP_KEY, "GSAD");
        translationBuilder.add(ModBlock.GRAVE, "Grób");
        translationBuilder.add(ModBlock.NEGATIVE_BLOCK, "Negatywny Block");
        translationBuilder.add(ModBlock.BORDER_BLOCK, "Block Granicy");
        // Celeste
        translationBuilder.add(ItemGroup.CELESTE_GROUP_KEY, "Celeste");
        translationBuilder.add(ModBlock.DREAM_BLOCK, "Senny Block");
        translationBuilder.add(ModBlock.TV_BLOCK, "Tv");
        translationBuilder.add(ModBlock.SPIKES, "Kolce");
        translationBuilder.add(ModBlock.SPINNER, "Kryształy");
        translationBuilder.add(ModBlock.DUST_BUNNY, "Królik z kurzu");
        translationBuilder.add(ModBlock.SCAFFOLDING, "Rusztowanie");
        translationBuilder.add(ModBlock.SPRING, "Sprężyna");
        translationBuilder.add(ModBlock.STRAWBERRY, "Truskawka");
        translationBuilder.add(ModItems.STARDUST, "Gwiezdny pył");
        // Sonic
        translationBuilder.add(ItemGroup.SONIC_GROUP_KEY, "Sonic");
        translationBuilder.add(ModBlock.RING, "Pierścień");
        translationBuilder.add(ModEntity.MOTOBUG, "Motoryzacyjny Robak");
        translationBuilder.add(ModBlock.Sonic_GRASS, "Trawa");
        translationBuilder.add(ModBlock.Sonic_DIRT, "Ziemia");
        // Mario
        translationBuilder.add(ItemGroup.MARIO_GROUP_KEY, "Mario");
        translationBuilder.add(ModBlock.LUCKY_BLOCK, "Szczęśliwy Block");
        translationBuilder.add(ModBlock.EMPTY_BLOCK, "Pusty Block");
        translationBuilder.add(ModBlock.GROUND_BLOCK, "Ziamia");
        translationBuilder.add(ModBlock.BRICK, "Block z Cegły");
    }
}
