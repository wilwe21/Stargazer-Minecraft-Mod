package com.github.wilwe21.stargazer.block.clases.starforge;

import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.entity.player.PlayerInventory;
import net.minecraft.inventory.CraftingInventory;
import net.minecraft.inventory.CraftingResultInventory;
import net.minecraft.inventory.RecipeInputInventory;
import net.minecraft.recipe.CraftingRecipe;
import net.minecraft.recipe.InputSlotFiller;
import net.minecraft.recipe.RecipeEntry;
import net.minecraft.recipe.RecipeFinder;
import net.minecraft.screen.AbstractRecipeScreenHandler;
import net.minecraft.screen.ScreenHandlerType;
import net.minecraft.screen.slot.CraftingResultSlot;
import net.minecraft.screen.slot.Slot;
import net.minecraft.server.world.ServerWorld;

import java.util.List;

public abstract class AbstractStarforgeScreenHandler extends AbstractRecipeScreenHandler {
    private final int width;
    private final int height;
    protected final RecipeInputInventory craftingInventory;
    protected final CraftingResultInventory craftingResultInventory = new CraftingResultInventory();

    public AbstractStarforgeScreenHandler(ScreenHandlerType<?> type, int syncId, int width, int height) {
        super(type, syncId);
        this.width = width;
        this.height = height;
        this.craftingInventory = new CraftingInventory(this, width, height);
    }

    protected Slot addResultSlot(PlayerEntity player, int x, int y) {
        return this.addSlot(new CraftingResultSlot(player, this.craftingInventory, this.craftingResultInventory, 0, x, y));
    }

    protected void addInputSlots(int x, int y) {
        for (int i = 0; i < this.width; i++) {
            this.addSlot(new Slot(this.craftingInventory, 0 + i * this.width, x - 36 + 0 * 36, y -36 + i * 18));
            this.addSlot(new Slot(this.craftingInventory, 1 + i * this.width, x - 36 + 1 * 36, y -36 + i * 18));
            this.addSlot(new Slot(this.craftingInventory, 2 + i * this.width, x - 36 + 2 * 36, y -36 + i * 18));
        }
    }

    @Override
    public AbstractRecipeScreenHandler.PostFillAction fillInputSlots(
            boolean craftAll, boolean creative, RecipeEntry<?> recipe, ServerWorld world, PlayerInventory inventory
    ) {
        RecipeEntry<CraftingRecipe> recipeEntry = (RecipeEntry<CraftingRecipe>)recipe;
        this.onInputSlotFillStart();

        AbstractRecipeScreenHandler.PostFillAction var8;
        try {
            List<Slot> list = this.getInputSlots();
            var8 = InputSlotFiller.fill(
                    new InputSlotFiller.Handler<CraftingRecipe>() {
                        @Override
                        public void populateRecipeFinder(RecipeFinder finder) {
                            AbstractStarforgeScreenHandler.this.populateRecipeFinder(finder);
                        }

                        @Override
                        public void clear() {
                            AbstractStarforgeScreenHandler.this.craftingResultInventory.clear();
                            AbstractStarforgeScreenHandler.this.craftingInventory.clear();
                        }

                        @Override
                        public boolean matches(RecipeEntry<CraftingRecipe> entry) {
                            return entry.value()
                                    .matches(AbstractStarforgeScreenHandler.this.craftingInventory.createRecipeInput(), AbstractStarforgeScreenHandler.this.getPlayer().getWorld());
                        }
                    },
                    this.width,
                    this.height,
                    list,
                    list,
                    inventory,
                    recipeEntry,
                    craftAll,
                    creative
            );
        } finally {
            this.onInputSlotFillFinish(world, (RecipeEntry<CraftingRecipe>)recipe);
        }

        return var8;
    }

    protected void onInputSlotFillStart() {
    }

    protected void onInputSlotFillFinish(ServerWorld world, RecipeEntry<CraftingRecipe> recipe) {
    }

    public abstract Slot getOutputSlot();

    public abstract List<Slot> getInputSlots();

    public int getWidth() {
        return this.width;
    }

    public int getHeight() {
        return this.height;
    }

    protected abstract PlayerEntity getPlayer();

    @Override
    public void populateRecipeFinder(RecipeFinder finder) {
        this.craftingInventory.provideRecipeInputs(finder);
    }
}
