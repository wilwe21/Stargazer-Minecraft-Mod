package com.github.wilwe21.stargazer.screens.slots;

import com.github.wilwe21.stargazer.screens.recipe.RecipeTypes;
import com.github.wilwe21.stargazer.screens.recipe.StarforgeRecipe;
import com.github.wilwe21.stargazer.screens.recipe.StarforgeRecipeInput;
import com.github.wilwe21.stargazer.screens.recipe.StarforgeRecipeInventory;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.inventory.Inventory;
import net.minecraft.inventory.RecipeInputInventory;
import net.minecraft.item.ItemStack;
import net.minecraft.recipe.CraftingRecipe;
import net.minecraft.recipe.RecipeType;
import net.minecraft.recipe.RecipeUnlocker;
import net.minecraft.recipe.input.CraftingRecipeInput;
import net.minecraft.screen.slot.Slot;
import net.minecraft.server.world.ServerWorld;
import net.minecraft.util.collection.DefaultedList;
import net.minecraft.world.World;

public class StarforgeResultSlot
        extends Slot {
    private final StarforgeRecipeInventory input;
    private final PlayerEntity player;
    private int amount;

    public StarforgeResultSlot(PlayerEntity player, StarforgeRecipeInventory input, Inventory inventory, int index, int x, int y) {
        super(inventory, index, x, y);
        this.player = player;
        this.input = input;
    }

    @Override
    public boolean canInsert(ItemStack stack) {
        return false;
    }

    @Override
    public ItemStack takeStack(int amount) {
        if (this.hasStack()) {
            this.amount += Math.min(amount, this.getStack().getCount());
        }
        return super.takeStack(amount);
    }

    @Override
    protected void onCrafted(ItemStack stack, int amount) {
        this.amount += amount;
        this.onCrafted(stack);
    }

    @Override
    protected void onTake(int amount) {
        this.amount += amount;
    }

    @Override
    protected void onCrafted(ItemStack stack) {
        Inventory inventory;
        if (this.amount > 0) {
            stack.onCraftByPlayer(this.player, this.amount);
        }
        if ((inventory = this.inventory) instanceof RecipeUnlocker) {
            RecipeUnlocker recipeUnlocker = (RecipeUnlocker)((Object)inventory);
            recipeUnlocker.unlockLastRecipe(this.player, this.input.getHeldStacks());
        }
        this.amount = 0;
    }

    private static DefaultedList<ItemStack> copyInput(StarforgeRecipeInput input) {
        DefaultedList<ItemStack> defaultedList = DefaultedList.ofSize(input.size(), ItemStack.EMPTY);
        for (int i = 0; i < defaultedList.size(); ++i) {
            defaultedList.set(i, input.getStackInSlot(i));
        }
        return defaultedList;
    }

    private DefaultedList<ItemStack> getRecipeRemainders(StarforgeRecipeInput input, World world) {
        if (world instanceof ServerWorld) {
            ServerWorld serverWorld = (ServerWorld)world;
            return serverWorld.getRecipeManager().getFirstMatch(RecipeTypes.STARFORGE, input, serverWorld).map(recipe -> ((StarforgeRecipe)recipe.value()).getRecipeRemainders(input)).orElseGet(() -> StarforgeResultSlot.copyInput(input));
        }
        return StarforgeRecipe.collectRecipeRemainders(input);
    }

    @Override
    public void onTakeItem(PlayerEntity player, ItemStack stack) {
        this.onCrafted(stack);
        StarforgeRecipeInput.Positioned positioned = this.input.createPositionedRecipeInput();
        StarforgeRecipeInput craftingRecipeInput = positioned.input();
        int i = positioned.left();
        int j = positioned.top();
        DefaultedList<ItemStack> defaultedList = this.getRecipeRemainders(craftingRecipeInput, player.getWorld());
        for (int k = 0; k < craftingRecipeInput.getHeight(); ++k) {
            for (int l = 0; l < craftingRecipeInput.getWidth(); ++l) {
                int m = l + i + (k + j) * this.input.getWidth();
                ItemStack itemStack = this.input.getStack(m);
                ItemStack itemStack2 = defaultedList.get(l + k * craftingRecipeInput.getWidth());
                if (!itemStack.isEmpty()) {
                    this.input.removeStack(m, 1);
                    itemStack = this.input.getStack(m);
                }
                if (itemStack2.isEmpty()) continue;
                if (itemStack.isEmpty()) {
                    this.input.setStack(m, itemStack2);
                    continue;
                }
                if (ItemStack.areItemsAndComponentsEqual(itemStack, itemStack2)) {
                    itemStack2.increment(itemStack.getCount());
                    this.input.setStack(m, itemStack2);
                    continue;
                }
                if (this.player.getInventory().insertStack(itemStack2)) continue;
                this.player.dropItem(itemStack2, false);
            }
        }
    }

    @Override
    public boolean disablesDynamicDisplay() {
        return true;
    }
}
