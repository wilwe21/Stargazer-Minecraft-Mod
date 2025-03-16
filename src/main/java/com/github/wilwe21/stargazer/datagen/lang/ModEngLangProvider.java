package com.github.wilwe21.stargazer.datagen.lang;

import com.github.wilwe21.stargazer.CreativeTab.ItemGroup;
import com.github.wilwe21.stargazer.block.ModBlock;
import com.github.wilwe21.stargazer.block.register.MoonBlocks;
import com.github.wilwe21.stargazer.block.register.StarBlocks;
import com.github.wilwe21.stargazer.effects.StatusEffects;
import com.github.wilwe21.stargazer.item.ModItems;
import com.github.wilwe21.stargazer.mechanics.DamageTypeRegistry;
import net.fabricmc.fabric.api.datagen.v1.FabricDataOutput;
import net.fabricmc.fabric.api.datagen.v1.provider.FabricLanguageProvider;
import net.minecraft.registry.RegistryWrapper;

import java.util.concurrent.CompletableFuture;

public class ModEngLangProvider extends FabricLanguageProvider {
    public ModEngLangProvider(FabricDataOutput dataGenerator, CompletableFuture<RegistryWrapper.WrapperLookup> registryLookup) {
        // Specifying en_us is optional, by default it is en_us.
        super(dataGenerator, "en_us", registryLookup);
    }
    @Override
    public void generateTranslations(RegistryWrapper.WrapperLookup wrapperLookup, TranslationBuilder translationBuilder) {
        translationBuilder.add(ItemGroup.STAR_GROUP_KEY, "Stargazer");
        // Blocks
        translationBuilder.add(ModBlock.GRAVE, "Grave");
        translationBuilder.add(ModBlock.NEGATIVE_BLOCK, "Negative Block");
        translationBuilder.add(StarBlocks.COSMIC_BLOCK, "Cosmic Skybox Block");
        translationBuilder.add(StarBlocks.BORDER_BLOCK, "Border Block");
        translationBuilder.add(StarBlocks.STAR_BARRIER_BLOCK, "Star Barrier");
        // Moon Rock
        translationBuilder.add(MoonBlocks.MOON_ROCK, "Moon Rock");
        translationBuilder.add(MoonBlocks.BLACK_MOON_ROCK, "Black Moon Rock");
        translationBuilder.add(MoonBlocks.MOON_ROCK_BRICKS, "Moon Rock Bricks");
        translationBuilder.add(MoonBlocks.CRACKED_MOON_ROCK_BRICKS, "Cracked Moon Rock Bricks");
        translationBuilder.add(MoonBlocks.CHISELED_MOON_ROCK_BRICKS, "Chiseled Moon Rock Bricks");
        translationBuilder.add(MoonBlocks.STAR_FORGE, "Star Forge");
        // Moon Tree
        translationBuilder.add(MoonBlocks.MOON_LEAVES, "Moon Leaves");
        translationBuilder.add(MoonBlocks.MOON_LOG, "Moon Log");
        translationBuilder.add(MoonBlocks.STRIPPED_MOON_LOG, "Stripped Moon Log");
        translationBuilder.add(MoonBlocks.MOON_SAPLING, "Moon Sapling");
        translationBuilder.add(MoonBlocks.MOON_PLANKS, "Moon Planks");
        translationBuilder.add(MoonBlocks.RED_MOON_PLANKS, "Red Moon Planks");
        translationBuilder.add(MoonBlocks.BLUE_MOON_PLANKS, "Blue Moon Planks");
        translationBuilder.add(MoonBlocks.PURPLE_MOON_PLANKS, "Purple Moon Planks");
        translationBuilder.add(MoonBlocks.YELLOW_MOON_PLANKS, "Yellow Moon Planks");
        // Items
        translationBuilder.add(ModItems.GRAVICE, "Gravel Ice");
        translationBuilder.add(ModItems.STARDUST, "Stardust");
        translationBuilder.add(ModItems.YELLOW_STAR, "Star");
        translationBuilder.add(ModItems.RED_STAR, "Star");
        translationBuilder.add(ModItems.BLUE_STAR, "Star");
        translationBuilder.add(ModItems.PURPLE_STAR, "Star");
        // Effects
        translationBuilder.add(StatusEffects.HYDRO, "Hydrophobic");
        translationBuilder.add(StatusEffects.COSMO, "Cosmic Feeling");
        translationBuilder.add(StatusEffects.GLASS, "Glass Hands");
    }
}
