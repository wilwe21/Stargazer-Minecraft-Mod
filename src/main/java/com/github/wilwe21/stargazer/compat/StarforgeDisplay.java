package com.github.wilwe21.stargazer.compat;

import com.github.wilwe21.stargazer.screens.recipe.serializer.ShapedStarforgeRecipe;
import me.shedaniel.rei.api.common.category.CategoryIdentifier;
import me.shedaniel.rei.api.common.display.Display;
import me.shedaniel.rei.api.common.display.DisplaySerializer;
import me.shedaniel.rei.api.common.display.basic.BasicDisplay;
import me.shedaniel.rei.api.common.entry.EntryIngredient;
import me.shedaniel.rei.api.common.util.EntryIngredients;
import net.minecraft.recipe.RecipeEntry;
import org.jetbrains.annotations.Nullable;

import java.util.Collections;
import java.util.List;

public class StarforgeDisplay extends BasicDisplay {
    public StarforgeDisplay(ShapedStarforgeRecipe recipe) {
        this(EntryIngredients.ofIngredients(recipe.getIngredientPlacement().getIngredients()), Collections.singletonList(EntryIngredients.of(recipe.getResult())));
    }

    public StarforgeDisplay(List<EntryIngredient> inputs, List<EntryIngredient> outputs) {
        super(inputs, outputs);
    }

    @Override
    public CategoryIdentifier<?> getCategoryIdentifier() {
        return StarforgeCategory.STARFORGE;
    }

    @Override
    public @Nullable DisplaySerializer<? extends Display> getSerializer() {
        return null;
    }
}
