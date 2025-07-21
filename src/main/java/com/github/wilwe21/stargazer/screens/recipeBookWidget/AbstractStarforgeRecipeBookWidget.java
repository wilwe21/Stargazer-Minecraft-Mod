package com.github.wilwe21.stargazer.screens.recipeBookWidget;

import com.github.wilwe21.stargazer.screens.StarforgeScreenHandler;
import net.fabricmc.api.EnvType;
import net.fabricmc.api.Environment;
import net.minecraft.client.gui.screen.ButtonTextures;
import net.minecraft.client.gui.screen.recipebook.GhostRecipe;
import net.minecraft.client.gui.screen.recipebook.RecipeBookWidget;
import net.minecraft.client.gui.screen.recipebook.RecipeResultCollection;
import net.minecraft.client.recipebook.RecipeBookType;
import net.minecraft.item.Items;
import net.minecraft.recipe.RecipeFinder;
import net.minecraft.recipe.book.RecipeBookCategories;
import net.minecraft.recipe.display.RecipeDisplay;
import net.minecraft.screen.slot.Slot;
import net.minecraft.text.Text;
import net.minecraft.util.Identifier;
import net.minecraft.util.context.ContextParameterMap;

import java.util.List;

@Environment(value= EnvType.CLIENT)
public class AbstractStarforgeRecipeBookWidget
        extends RecipeBookWidget<StarforgeScreenHandler> {
    private static final ButtonTextures TEXTURES = new ButtonTextures(Identifier.ofVanilla("recipe_book/filter_enabled"), Identifier.ofVanilla("recipe_book/filter_disabled"), Identifier.ofVanilla("recipe_book/filter_enabled_highlighted"), Identifier.ofVanilla("recipe_book/filter_disabled_highlighted"));
    private static final Text TOGGLE_CRAFTABLE_TEXT = Text.translatable("gui.recipebook.toggleRecipes.craftable");
    private static final List<Tab> TABS = List.of(new RecipeBookWidget.Tab(RecipeBookType.CRAFTING), new RecipeBookWidget.Tab(Items.IRON_AXE, Items.GOLDEN_SWORD, RecipeBookCategories.CRAFTING_EQUIPMENT), new RecipeBookWidget.Tab(Items.BRICKS, RecipeBookCategories.CRAFTING_BUILDING_BLOCKS), new RecipeBookWidget.Tab(Items.LAVA_BUCKET, Items.APPLE, RecipeBookCategories.CRAFTING_MISC), new RecipeBookWidget.Tab(Items.REDSTONE, RecipeBookCategories.CRAFTING_REDSTONE));

    public AbstractStarforgeRecipeBookWidget(StarforgeScreenHandler screenHandler) {
        super(screenHandler, TABS);
    }

    @Override
    protected boolean isValid(Slot slot) {
        return ((StarforgeScreenHandler)this.craftingScreenHandler).getOutputSlot() == slot || ((StarforgeScreenHandler)this.craftingScreenHandler).getInputSlots().contains(slot);
    }

    private boolean canDisplay(RecipeDisplay display) {
//        int i = 3;
//        int j = 3;
//        RecipeDisplay recipeDisplay = display;
//        Objects.requireNonNull(recipeDisplay);
//        RecipeDisplay recipeDisplay2 = recipeDisplay;
//        int n = 0;
        return false;
    }

    @Override
    protected void setBookButtonTexture() {
        this.toggleCraftableButton.setTextures(TEXTURES);
    }

    @Override
    protected Text getToggleCraftableButtonText() {
        return TOGGLE_CRAFTABLE_TEXT;
    }

    @Override
    protected void showGhostRecipe(GhostRecipe ghostRecipe, RecipeDisplay display, ContextParameterMap context) {

    }

    @Override
    protected void populateRecipes(RecipeResultCollection recipeResultCollection, RecipeFinder recipeFinder) {
        recipeResultCollection.populateRecipes(recipeFinder, this::canDisplay);
    }
}
