package com.github.wilwe21.stargazer.screenHandlers;

import com.github.wilwe21.stargazer.Stargazer;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.inventory.CraftingInventory;
import net.minecraft.inventory.CraftingResultInventory;
import net.minecraft.inventory.RecipeInputInventory;
import net.minecraft.recipe.CraftingRecipe;
import net.minecraft.recipe.RecipeEntry;
import net.minecraft.screen.ScreenHandler;
import net.minecraft.screen.ScreenHandlerType;
import net.minecraft.screen.slot.CraftingResultSlot;
import net.minecraft.screen.slot.Slot;
import net.minecraft.server.world.ServerWorld;

import java.util.List;

public abstract class AbstractStarforgeScreenHandler extends ScreenHandler {
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
            for (int j = 0; j < this.height; j++) {
                this.addSlot(new Slot(this.craftingInventory, j + i * this.width, x + j * 18, y + i * 18));
            }
        }
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
}
