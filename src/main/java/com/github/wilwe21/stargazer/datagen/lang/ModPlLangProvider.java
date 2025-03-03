package com.github.wilwe21.stargazer.datagen.lang;

import com.github.wilwe21.stargazer.CreativeTab.ItemGroup;
import com.github.wilwe21.stargazer.block.ModBlock;
import com.github.wilwe21.stargazer.block.register.MoonBlocks;
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
        // Blocks
        translationBuilder.add(ModBlock.GRAVE, "Grób");
        translationBuilder.add(ModBlock.NEGATIVE_BLOCK, "Negatywny Block");
        translationBuilder.add(ModBlock.COSMIC_BLOCK, "Niebo Kosmosu");
        translationBuilder.add(ModBlock.BORDER_BLOCK, "Block Granicy");
        translationBuilder.add(MoonBlocks.MOON_ROCK, "Skała Księżycowa");
        translationBuilder.add(MoonBlocks.BLACK_MOON_ROCK, "Czarna Skała Księżycowa");
        translationBuilder.add(MoonBlocks.MOON_ROCK_BRICKS, "Cegły ze Skały Księżycowej");
        translationBuilder.add(MoonBlocks.CRACKED_MOON_ROCK_BRICKS, "Popękane Cegły ze Skały Księżycowej");
        translationBuilder.add(MoonBlocks.CHISELED_MOON_ROCK_BRICKS, "Rzeźbione Cegły ze Skały Księżycowej");
        translationBuilder.add(MoonBlocks.STAR_FORGE, "Kuźnia Gwiazd");
        translationBuilder.add(ModBlock.STAR_BARRIER_BLOCK, "Gwiezdna Bariera");
        translationBuilder.add(MoonBlocks.MOON_LOG, "Księżycowa Kłoda");
        translationBuilder.add(MoonBlocks.MOON_LEAVES, "Księżycowe Liście");
        translationBuilder.add(MoonBlocks.MOON_SAPLING, "Księżycowa Sadzonka");
        // Items
        translationBuilder.add(ModItems.GRAVICE, "Lody Żwirowe");
        translationBuilder.add(ModItems.STARDUST, "Gwiezdny pył");
        translationBuilder.add(ModItems.YELLOW_STAR, "Gwiazda");
        translationBuilder.add(ModItems.RED_STAR, "Gwiazda");
        translationBuilder.add(ModItems.BLUE_STAR, "Gwiazda");
        translationBuilder.add(ModItems.PURPLE_STAR, "Gwiazda");
        translationBuilder.add(ModItems.GREEN_STAR, "Gwiazda");
    }
}
