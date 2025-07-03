package com.github.wilwe21.stargazer.datagen;

import com.github.wilwe21.stargazer.block.register.MoonBlocks;
import com.github.wilwe21.stargazer.block.register.StarBlocks;
import com.github.wilwe21.stargazer.item.ItemTags;
import com.github.wilwe21.stargazer.item.ModItems;
import net.fabricmc.fabric.api.datagen.v1.FabricDataOutput;
import net.fabricmc.fabric.api.datagen.v1.provider.FabricRecipeProvider;
import net.minecraft.data.recipe.RecipeExporter;
import net.minecraft.data.recipe.RecipeGenerator;
import net.minecraft.item.Item;
import net.minecraft.item.Items;
import net.minecraft.recipe.Ingredient;
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
                        .criterion("has_log", this.conditionsFromTag(net.minecraft.registry.tag.ItemTags.LOGS))
                        .offerTo(this.exporter);
                createSlabRecipe(RecipeCategory.BUILDING_BLOCKS, MoonBlocks.MOON_PLANKS_SLAB, Ingredient.ofItem(MoonBlocks.MOON_PLANKS))
                        .group("moon_planks_slabs")
                        .criterion("wood", conditionsFromItem(MoonBlocks.MOON_PLANKS))
                        .offerTo(exporter);
                createSlabRecipe(RecipeCategory.BUILDING_BLOCKS, MoonBlocks.PURPLE_MOON_PLANKS_SLAB, Ingredient.ofItem(MoonBlocks.PURPLE_MOON_PLANKS))
                        .group("moon_planks_slabs")
                        .criterion("wood", conditionsFromItem(MoonBlocks.PURPLE_MOON_PLANKS))
                        .offerTo(exporter);
                createSlabRecipe(RecipeCategory.BUILDING_BLOCKS, MoonBlocks.RED_MOON_PLANKS_SLAB, Ingredient.ofItem(MoonBlocks.RED_MOON_PLANKS))
                        .group("moon_planks_slabs")
                        .criterion("wood", conditionsFromItem(MoonBlocks.RED_MOON_PLANKS))
                        .offerTo(exporter);
                createSlabRecipe(RecipeCategory.BUILDING_BLOCKS, MoonBlocks.BLUE_MOON_PLANKS_SLAB, Ingredient.ofItem(MoonBlocks.BLUE_MOON_PLANKS))
                        .group("moon_planks_slabs")
                        .criterion("wood", conditionsFromItem(MoonBlocks.BLUE_MOON_PLANKS))
                        .offerTo(exporter);
                createSlabRecipe(RecipeCategory.BUILDING_BLOCKS, MoonBlocks.YELLOW_MOON_PLANKS_SLAB, Ingredient.ofItem(MoonBlocks.YELLOW_MOON_PLANKS))
                        .group("moon_planks_slabs")
                        .criterion("wood", conditionsFromItem(MoonBlocks.YELLOW_MOON_PLANKS))
                        .offerTo(exporter);
                createStairsRecipe(MoonBlocks.MOON_PLANKS_STAIRS, Ingredient.ofItem(MoonBlocks.MOON_PLANKS))
                        .group("moon_planks_staris")
                        .criterion("wood", conditionsFromItem(MoonBlocks.MOON_PLANKS))
                        .offerTo(exporter);
                createStairsRecipe(MoonBlocks.PURPLE_MOON_PLANKS_STAIRS, Ingredient.ofItem(MoonBlocks.PURPLE_MOON_PLANKS))
                        .group("moon_planks_staris")
                        .criterion("wood", conditionsFromItem(MoonBlocks.PURPLE_MOON_PLANKS))
                        .offerTo(exporter);
                createStairsRecipe(MoonBlocks.RED_MOON_PLANKS_STAIRS, Ingredient.ofItem(MoonBlocks.RED_MOON_PLANKS))
                        .group("moon_planks_staris")
                        .criterion("wood", conditionsFromItem(MoonBlocks.RED_MOON_PLANKS))
                        .offerTo(exporter);
                createStairsRecipe(MoonBlocks.BLUE_MOON_PLANKS_STAIRS, Ingredient.ofItem(MoonBlocks.BLUE_MOON_PLANKS))
                        .group("moon_planks_staris")
                        .criterion("wood", conditionsFromItem(MoonBlocks.BLUE_MOON_PLANKS))
                        .offerTo(exporter);
                createStairsRecipe(MoonBlocks.YELLOW_MOON_PLANKS_STAIRS, Ingredient.ofItem(MoonBlocks.YELLOW_MOON_PLANKS))
                        .group("moon_planks_staris")
                        .criterion("wood", conditionsFromItem(MoonBlocks.YELLOW_MOON_PLANKS))
                        .offerTo(exporter);
                createButtonRecipe(MoonBlocks.MOON_PLANKS_BUTTON, Ingredient.ofItem(MoonBlocks.MOON_PLANKS))
                        .group("moon_planks_button")
                        .criterion("wood", conditionsFromItem(MoonBlocks.MOON_PLANKS))
                        .offerTo(exporter);
                createButtonRecipe(MoonBlocks.PURPLE_MOON_PLANKS_BUTTON, Ingredient.ofItem(MoonBlocks.PURPLE_MOON_PLANKS))
                        .group("moon_planks_button")
                        .criterion("wood", conditionsFromItem(MoonBlocks.PURPLE_MOON_PLANKS))
                        .offerTo(exporter);
                createButtonRecipe(MoonBlocks.RED_MOON_PLANKS_BUTTON, Ingredient.ofItem(MoonBlocks.RED_MOON_PLANKS))
                        .group("moon_planks_button")
                        .criterion("wood", conditionsFromItem(MoonBlocks.RED_MOON_PLANKS))
                        .offerTo(exporter);
                createButtonRecipe(MoonBlocks.BLUE_MOON_PLANKS_BUTTON, Ingredient.ofItem(MoonBlocks.BLUE_MOON_PLANKS))
                        .group("moon_planks_button")
                        .criterion("wood", conditionsFromItem(MoonBlocks.BLUE_MOON_PLANKS))
                        .offerTo(exporter);
                createButtonRecipe(MoonBlocks.YELLOW_MOON_PLANKS_BUTTON, Ingredient.ofItem(MoonBlocks.YELLOW_MOON_PLANKS))
                        .group("moon_planks_button")
                        .criterion("wood", conditionsFromItem(MoonBlocks.YELLOW_MOON_PLANKS))
                        .offerTo(exporter);
                createFenceGateRecipe(MoonBlocks.MOON_PLANKS_FENCE_GATE, Ingredient.ofItem(MoonBlocks.MOON_PLANKS))
                        .group("moon_planks_fence_gate")
                        .criterion("wood", conditionsFromItem(MoonBlocks.MOON_PLANKS))
                        .offerTo(exporter);
                createFenceGateRecipe(MoonBlocks.PURPLE_MOON_PLANKS_FENCE_GATE, Ingredient.ofItem(MoonBlocks.PURPLE_MOON_PLANKS))
                        .group("moon_planks_fence_gate")
                        .criterion("wood", conditionsFromItem(MoonBlocks.PURPLE_MOON_PLANKS))
                        .offerTo(exporter);
                createFenceGateRecipe(MoonBlocks.RED_MOON_PLANKS_FENCE_GATE, Ingredient.ofItem(MoonBlocks.RED_MOON_PLANKS))
                        .group("moon_planks_fence_gate")
                        .criterion("wood", conditionsFromItem(MoonBlocks.RED_MOON_PLANKS))
                        .offerTo(exporter);
                createFenceGateRecipe(MoonBlocks.BLUE_MOON_PLANKS_FENCE_GATE, Ingredient.ofItem(MoonBlocks.BLUE_MOON_PLANKS))
                        .group("moon_planks_fence_gate")
                        .criterion("wood", conditionsFromItem(MoonBlocks.BLUE_MOON_PLANKS))
                        .offerTo(exporter);
                createFenceGateRecipe(MoonBlocks.YELLOW_MOON_PLANKS_FENCE_GATE, Ingredient.ofItem(MoonBlocks.YELLOW_MOON_PLANKS))
                        .group("moon_planks_fence_gate")
                        .criterion("wood", conditionsFromItem(MoonBlocks.YELLOW_MOON_PLANKS))
                        .offerTo(exporter);
                createFenceRecipe(MoonBlocks.MOON_PLANKS_FENCE, Ingredient.ofItem(MoonBlocks.MOON_PLANKS))
                        .group("moon_planks_fence")
                        .criterion("wood", conditionsFromItem(MoonBlocks.MOON_PLANKS))
                        .offerTo(exporter);
                createFenceRecipe(MoonBlocks.PURPLE_MOON_PLANKS_FENCE, Ingredient.ofItem(MoonBlocks.PURPLE_MOON_PLANKS))
                        .group("moon_planks_fence")
                        .criterion("wood", conditionsFromItem(MoonBlocks.PURPLE_MOON_PLANKS))
                        .offerTo(exporter);
                createFenceRecipe(MoonBlocks.RED_MOON_PLANKS_FENCE, Ingredient.ofItem(MoonBlocks.RED_MOON_PLANKS))
                        .group("moon_planks_fence")
                        .criterion("wood", conditionsFromItem(MoonBlocks.RED_MOON_PLANKS))
                        .offerTo(exporter);
                createFenceRecipe(MoonBlocks.BLUE_MOON_PLANKS_FENCE, Ingredient.ofItem(MoonBlocks.BLUE_MOON_PLANKS))
                        .group("moon_planks_fence")
                        .criterion("wood", conditionsFromItem(MoonBlocks.BLUE_MOON_PLANKS))
                        .offerTo(exporter);
                createFenceRecipe(MoonBlocks.YELLOW_MOON_PLANKS_FENCE, Ingredient.ofItem(MoonBlocks.YELLOW_MOON_PLANKS))
                        .group("moon_planks_fence")
                        .criterion("wood", conditionsFromItem(MoonBlocks.YELLOW_MOON_PLANKS))
                        .offerTo(exporter);
                // Star Tree
                createShapeless(RecipeCategory.BUILDING_BLOCKS, StarBlocks.STAR_PLANKS, 4)
                        .input(ItemTags.STAR_LOG)
                        .group("planks")
                        .criterion("has_log", this.conditionsFromTag(net.minecraft.registry.tag.ItemTags.LOGS))
                        .offerTo(this.exporter);
                // Star Flower
                createShaped(RecipeCategory.DECORATIONS, StarBlocks.CELESTIAL_STAR_FLOWER, 1)
                        .pattern("BPR")
                        .pattern("YFY")
                        .pattern("RPB")
                        .input('B', ItemTags.BLUE_STAR)
                        .input('P', ItemTags.PURPLE_STAR)
                        .input('R', ItemTags.RED_STAR)
                        .input('Y', ItemTags.YELLOW_STAR)
                        .input('F', ItemTags.STAR_FLOWER)
                        .group("star_flower")
                        .criterion(hasItem(StarBlocks.STAR_FLOWER.asItem()), conditionsFromItem(StarBlocks.STAR_FLOWER.asItem()))
                        .offerTo(exporter);

                // Moon Rock
                createShaped(RecipeCategory.BUILDING_BLOCKS, MoonBlocks.MOON_ROCK_BRICKS, 4)
                        .input('#', MoonBlocks.MOON_ROCK)
                        .pattern("##")
                        .pattern("##")
                        .criterion(hasItem(MoonBlocks.MOON_ROCK), this.conditionsFromItem(MoonBlocks.MOON_ROCK))
                        .offerTo(this.exporter);
                createSlabRecipe(RecipeCategory.BUILDING_BLOCKS, MoonBlocks.MOON_ROCK_BRICKS_SLAB, Ingredient.ofItem(MoonBlocks.MOON_ROCK_BRICKS))
                        .criterion("rock", conditionsFromItem(MoonBlocks.MOON_ROCK_BRICKS))
                        .offerTo(exporter);
                createStairsRecipe(MoonBlocks.MOON_ROCK_BRICKS_STAIRS, Ingredient.ofItem(MoonBlocks.MOON_ROCK))
                        .criterion("rock", conditionsFromItem(MoonBlocks.MOON_ROCK_BRICKS))
                        .offerTo(exporter);
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

