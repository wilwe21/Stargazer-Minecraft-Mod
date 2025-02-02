package com.github.wilwe21.stargazer.datagen;

import com.github.wilwe21.stargazer.block.ModBlock;
import com.github.wilwe21.stargazer.item.ModItems;
import net.fabricmc.fabric.api.datagen.v1.FabricDataOutput;
import net.fabricmc.fabric.api.datagen.v1.provider.FabricRecipeProvider;
import net.minecraft.data.recipe.RecipeExporter;
import net.minecraft.data.recipe.RecipeGenerator;
import net.minecraft.item.Item;
import net.minecraft.item.Items;
import net.minecraft.recipe.book.RecipeCategory;
import net.minecraft.registry.*;

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
//                createShaped(RecipeCategory.FOOD, ModItems.GRAVICE, 1)
//                        .input('#', Items.GRAVEL)
//                        .input('|', Items.STICK)
//                        .pattern("#")
//                        .pattern("#")
//                        .pattern("|")
//                        .offerTo(recipeExporter);
                createShaped(RecipeCategory.FOOD, ModItems.GRAVICE, 1)
                        .pattern("#")
                        .pattern("#")
                        .pattern("I")
                        .input('#', Items.GRAVEL) // 'w' means "any wool"
                        .input('I', Items.STICK)
                        .group("ice")
                        .criterion(hasItem(Items.GRAVEL), conditionsFromItem(ModItems.GRAVICE))
                        .offerTo(exporter);

            }
        };
    }

        @Override
    public String getName() {
        return "gsad";
    }
}

