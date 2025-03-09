package com.github.wilwe21.stargazer.datagen;

import com.github.wilwe21.stargazer.Stargazer;
import com.github.wilwe21.stargazer.block.register.MoonBlocks;
import com.github.wilwe21.stargazer.item.ItemTags;
import com.github.wilwe21.stargazer.item.ModItems;
import net.fabricmc.fabric.api.datagen.v1.FabricDataOutput;
import net.fabricmc.fabric.api.datagen.v1.provider.FabricRecipeProvider;
import net.minecraft.data.recipe.RecipeExporter;
import net.minecraft.data.recipe.RecipeGenerator;
import net.minecraft.item.Item;
import net.minecraft.item.Items;
import net.minecraft.recipe.book.RecipeCategory;
import net.minecraft.registry.*;
import net.minecraft.util.Identifier;

import java.util.concurrent.CompletableFuture;

public class ModRecipeProvider extends FabricRecipeProvider {
    public ModRecipeProvider(FabricDataOutput output, CompletableFuture<RegistryWrapper.WrapperLookup> registriesFuture) {
        super(output, registriesFuture);
    }

    @Override
    protected RecipeGenerator getRecipeGenerator(RegistryWrapper.WrapperLookup wrapperLookup, RecipeExporter recipeExporter) {
        return new RecipeGenerator(wrapperLookup, recipeExporter) {
            @Override
            public void generate() {
                RegistryWrapper.Impl<Item> itemLookup = registries.getOrThrow(RegistryKeys.ITEM);
                createShaped(RecipeCategory.FOOD, ModItems.GRAVICE, 1)
                        .pattern("#")
                        .pattern("#")
                        .pattern("I")
                        .input('#', Items.GRAVEL)
                        .input('I', Items.STICK)
                        .group("ice")
                        .criterion(hasItem(Items.GRAVEL), conditionsFromItem(ModItems.GRAVICE))
                        .offerTo(exporter);
                // Moon Tree
                createShapeless(RecipeCategory.BUILDING_BLOCKS, MoonBlocks.MOON_PLANKS, 4)
                        .input(ItemTags.MOON_LOG)
                        .group("planks")
                        .criterion("has_log", this.conditionsFromTag(ItemTags.MOON_LOG))
                        .offerTo(this.exporter, Identifier.of(Stargazer.MOD_ID, "moonplanksfromlog").getPath());
                // Moon Rock
                createShapeless(RecipeCategory.BUILDING_BLOCKS, MoonBlocks.MOON_PLANKS, 4)
                        .input(MoonBlocks.STRIPPED_MOON_LOG)
                        .group("planks")
                        .criterion("has_log", this.conditionsFromItem(MoonBlocks.STRIPPED_MOON_LOG))
                        .offerTo(exporter, Identifier.of(Stargazer.MOD_ID, "moonplanksfromstripped").getPath());
                createShaped(RecipeCategory.BUILDING_BLOCKS, MoonBlocks.MOON_ROCK_BRICKS, 4)
                        .input('#', MoonBlocks.MOON_ROCK)
                        .pattern("##")
                        .pattern("##")
                        .criterion(hasItem(MoonBlocks.MOON_ROCK), this.conditionsFromItem(MoonBlocks.MOON_ROCK))
                        .offerTo(this.exporter);
                createShaped(RecipeCategory.MISC, MoonBlocks.STAR_FORGE, 1)
                        .pattern("ss")
                        .pattern("##")
                        .pattern("##")
                        .input('#', MoonBlocks.MOON_ROCK)
                        .input('s', ItemTags.STAR)
                        .group("starforge")
                        .criterion(hasItem(MoonBlocks.MOON_ROCK), conditionsFromTag(ItemTags.STAR))
                        .offerTo(exporter);
            }
        };
    }

        @Override
    public String getName() {
        return "stargazer";
    }
}

