package com.github.wilwe21.stargazer.datagen.lang;

import com.github.wilwe21.stargazer.CreativeTab.ItemGroup;
import com.github.wilwe21.stargazer.block.ModBlock;
import com.github.wilwe21.stargazer.block.register.MoonBlocks;
import com.github.wilwe21.stargazer.block.register.StarBlocks;
import com.github.wilwe21.stargazer.effects.StatusEffects;
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
        // Moon Rocks
        translationBuilder.add(MoonBlocks.MOON_ROCK, "Skała Księżycowa");
        translationBuilder.add(MoonBlocks.BLACK_MOON_ROCK, "Czarna Skała Księżycowa");
        translationBuilder.add(MoonBlocks.MOON_ROCK_BRICKS, "Cegły ze Skały Księżycowej");
        translationBuilder.add(MoonBlocks.CRACKED_MOON_ROCK_BRICKS, "Popękane Cegły ze Skały Księżycowej");
        translationBuilder.add(MoonBlocks.CHISELED_MOON_ROCK_BRICKS, "Rzeźbione Cegły ze Skały Księżycowej");
        translationBuilder.add(MoonBlocks.STAR_FORGE, "Kuźnia Gwiazd");
        // Moon Tree
        translationBuilder.add(MoonBlocks.MOON_LOG, "Księżycowy Pień");
        translationBuilder.add(MoonBlocks.STRIPPED_MOON_LOG, "Ociosany Księżycowy Pień");
        translationBuilder.add(MoonBlocks.MOON_LEAVES, "Księżycowe Liście");
        translationBuilder.add(MoonBlocks.MOON_SAPLING, "Księżycowa Sadzonka");
        translationBuilder.add(MoonBlocks.MOON_PLANKS, "Księżycowe Deski");
        translationBuilder.add(MoonBlocks.RED_MOON_PLANKS, "Czerwone Księżycowe Deski");
        translationBuilder.add(MoonBlocks.BLUE_MOON_PLANKS, "Niebieskie Księżycowe Deski");
        translationBuilder.add(MoonBlocks.PURPLE_MOON_PLANKS, "Fioletowe Księżycowe Deski");
        translationBuilder.add(MoonBlocks.YELLOW_MOON_PLANKS, "Żółte Księżycowe Deski");
        // Star
        translationBuilder.add(StarBlocks.COSMIC_BLOCK, "Niebo Kosmosu");
        translationBuilder.add(StarBlocks.BORDER_BLOCK, "Block Granicy");
        translationBuilder.add(StarBlocks.STAR_BARRIER_BLOCK, "Gwiezdna Bariera");
        translationBuilder.add(StarBlocks.STAR_LOG, "Gwiezdny Pień");
        translationBuilder.add(StarBlocks.STRIPPED_STAR_LOG, "Ociosany Gwiezdny Pień");
        translationBuilder.add(StarBlocks.STAR_PLANKS, "Gwiezdne Deski");
        translationBuilder.add(StarBlocks.STAR_LEAVES, "Gwiezdne Liście");
        translationBuilder.add(StarBlocks.STAR_SAPLING, "Gwiezdna Sadząka");
        // Items
        translationBuilder.add(ModItems.GRAVICE, "Lody Żwirowe");
        translationBuilder.add(ModItems.STARDUST, "Gwiezdny pył");
        translationBuilder.add(ModItems.YELLOW_STAR, "Gwiazda");
        translationBuilder.add(ModItems.RED_STAR, "Gwiazda");
        translationBuilder.add(ModItems.BLUE_STAR, "Gwiazda");
        translationBuilder.add(ModItems.PURPLE_STAR, "Gwiazda");
        // Effects
        translationBuilder.add("effects.stargazer.hydrophobic", "Hydrofobia");
        translationBuilder.add("effects.stargazer.cosmofeeling", "Kosmiczne Uczucie");
        translationBuilder.add("effects.stargazer.glasshands", "Szklane Ręce");
    }
}
