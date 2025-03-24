package com.github.wilwe21.stargazer.datagen.lang;

import com.github.wilwe21.stargazer.CreativeTab.ItemGroup;
import com.github.wilwe21.stargazer.block.ModBlock;
import com.github.wilwe21.stargazer.block.register.MoonBlocks;
import com.github.wilwe21.stargazer.block.register.StarBlocks;
import com.github.wilwe21.stargazer.effects.Potions;
import com.github.wilwe21.stargazer.effects.StatusEffects;
import com.github.wilwe21.stargazer.item.ModItems;
import com.github.wilwe21.stargazer.mechanics.DamageTypeRegistry;
import net.fabricmc.fabric.api.datagen.v1.FabricDataOutput;
import net.fabricmc.fabric.api.datagen.v1.provider.FabricLanguageProvider;
import net.minecraft.item.Item;
import net.minecraft.registry.Registries;
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
        // Star
        translationBuilder.add(StarBlocks.COSMIC_BLOCK, "Cosmic Skybox Block");
        translationBuilder.add(StarBlocks.BORDER_BLOCK, "Border Block");
        translationBuilder.add(StarBlocks.STAR_BARRIER_BLOCK, "Star Barrier");
        translationBuilder.add(StarBlocks.STAR_LOG, "Star Log");
        translationBuilder.add(StarBlocks.STRIPPED_STAR_LOG, "Stripped Star Log");
        translationBuilder.add(StarBlocks.STAR_PLANKS, "Star Planks");
        translationBuilder.add(StarBlocks.STAR_LEAVES, "Star Leaves");
        translationBuilder.add(StarBlocks.STAR_SAPLING, "Star Sapling");
        // Items
        translationBuilder.add(ModItems.GRAVICE, "Gravel Ice");
        translationBuilder.add(ModItems.STARDUST, "Stardust");
        translationBuilder.add(ModItems.YELLOW_STAR, "Star");
        translationBuilder.add(ModItems.RED_STAR, "Star");
        translationBuilder.add(ModItems.BLUE_STAR, "Star");
        translationBuilder.add(ModItems.PURPLE_STAR, "Star");
        // Potions
        translationBuilder.add("item.minecraft.potion.effect."+Registries.POTION.get(Potions.CosmoFeel.getKey().get()).getBaseName(), "Potion of Cosmic Feeling");
        translationBuilder.add("item.minecraft.splash_potion.effect."+Registries.POTION.get(Potions.CosmoFeel.getKey().get()).getBaseName(), "Splash Potion of Cosmic Feeling");
        translationBuilder.add("item.minecraft.lingering_potion.effect."+Registries.POTION.get(Potions.CosmoFeel.getKey().get()).getBaseName(), "Lingering Potion of Cosmic Feeling");
        translationBuilder.add("item.minecraft.potion.effect."+Registries.POTION.get(Potions.GlassHands.getKey().get()).getBaseName(), "Potion of Glass Hands");
        translationBuilder.add("item.minecraft.splash_potion.effect."+Registries.POTION.get(Potions.GlassHands.getKey().get()).getBaseName(), "Splash Potion of Glass Hands");
        translationBuilder.add("item.minecraft.lingering_potion.effect."+Registries.POTION.get(Potions.GlassHands.getKey().get()).getBaseName(), "Lingering Potion of Glass Hands");
        // Effects
        translationBuilder.add("effect.stargazer.hydrophobic", "Hydrophobic");
        translationBuilder.add("effect.stargazer.cosmofeeling", "Cosmic Feeling");
        translationBuilder.add("effect.stargazer.glasshands", "Glass Hands");
    }
}
