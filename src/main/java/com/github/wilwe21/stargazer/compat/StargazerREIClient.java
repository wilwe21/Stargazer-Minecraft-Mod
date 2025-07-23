package com.github.wilwe21.stargazer.compat;

import com.github.wilwe21.stargazer.block.register.MoonBlocks;
import com.github.wilwe21.stargazer.screens.recipe.serializer.ShapedStarforgeRecipe;
import me.shedaniel.rei.api.client.plugins.REIClientPlugin;
import me.shedaniel.rei.api.client.registry.category.CategoryRegistry;
import me.shedaniel.rei.api.client.registry.display.DisplayRegistry;
import me.shedaniel.rei.api.client.registry.screen.ScreenRegistry;
import me.shedaniel.rei.api.common.util.EntryStacks;

public class StargazerREIClient implements REIClientPlugin {
    @Override
    public void registerCategories(CategoryRegistry registry) {
        registry.add(new StarforgeCategory());
        registry.addWorkstations(StarforgeCategory.STARFORGE, EntryStacks.of(MoonBlocks.STAR_FORGE.asItem().getDefaultStack()));
    }

    @Override
    public void registerDisplays(DisplayRegistry registry) {
        registry.beginFiller(ShapedStarforgeRecipe.class).fill(StarforgeDisplay::new);
    }

    @Override
    public void registerScreens(ScreenRegistry registry) {
    }
}
