package com.github.wilwe21.stargazer.screens.recipe;

import net.minecraft.item.ItemStack;
import net.minecraft.recipe.RecipeFinder;
import net.minecraft.recipe.input.CraftingRecipeInput;
import net.minecraft.recipe.input.RecipeInput;

import java.util.ArrayList;
import java.util.List;

public class StarforgeRecipeInput
        implements RecipeInput {
    public static final StarforgeRecipeInput EMPTY = new StarforgeRecipeInput(0, 0, List.of());
    private final int width;
    private final int height;
    private final List<ItemStack> stacks;
    private final RecipeFinder matcher = new RecipeFinder();
    private final int stackCount;

    private StarforgeRecipeInput(int width, int height, List<ItemStack> stacks) {
        this.width = width;
        this.height = height;
        this.stacks = stacks;
        int i = 0;
        for (ItemStack itemStack : stacks) {
            if (itemStack.isEmpty()) continue;
            ++i;
            this.matcher.addInput(itemStack, 1);
        }
        this.stackCount = i;
    }

    public static StarforgeRecipeInput create(int width, int height, List<ItemStack> stacks) {
        return StarforgeRecipeInput.createPositioned(width, height, stacks).input();
    }

    public static StarforgeRecipeInput.Positioned createPositioned(int width, int height, List<ItemStack> stacks) {
        int m;
        if (width == 0 || height == 0) {
            return StarforgeRecipeInput.Positioned.EMPTY;
        }
        int i = width - 1;
        int j = 0;
        int k = height - 1;
        int l = 0;
        for (m = 0; m < 3; ++m) {
            boolean bl = true;
            for (int n = 0; n < 5; ++n) {
                ItemStack itemStack = stacks.get(n + m * 3);
                if (itemStack.isEmpty()) continue;
                i = Math.min(i, n);
                j = Math.max(j, n);
                bl = false;
            }
            if (bl) continue;
            k = Math.min(k, m);
            l = Math.max(l, m);
        }
        m = j - i + 1;
        int o = l - k + 1;
        if (m <= 0 || o <= 0) {
            return StarforgeRecipeInput.Positioned.EMPTY;
        }
        if (m == 3 && o == 3) {
            return new StarforgeRecipeInput.Positioned(new StarforgeRecipeInput(3, 3, stacks), i, k);
        }
        ArrayList<ItemStack> list = new ArrayList<ItemStack>(m * o);
        for (int p = 0; p < o; ++p) {
            for (int q = 0; q < m; ++q) {
                int r = q + i + (p + k) * 3;
                list.add(stacks.get(r));
            }
        }
        return new StarforgeRecipeInput.Positioned(new StarforgeRecipeInput(m, o, list), i, k);
    }

    @Override
    public ItemStack getStackInSlot(int slot) {
        return this.stacks.get(slot);
    }

    public ItemStack getStackInSlot(int x, int y) {
        return this.stacks.get(x + y * this.width);
    }

    @Override
    public int size() {
        return this.stacks.size();
    }

    @Override
    public boolean isEmpty() {
        return this.stackCount == 0;
    }

    public RecipeFinder getRecipeMatcher() {
        return this.matcher;
    }

    public List<ItemStack> getStacks() {
        return this.stacks;
    }

    public int getStackCount() {
        return this.stackCount;
    }

    public int getWidth() {
        return this.width;
    }

    public int getHeight() {
        return this.height;
    }

    public boolean equals(Object o) {
        if (o == this) {
            return true;
        }
        if (o instanceof StarforgeRecipeInput) {
            StarforgeRecipeInput craftingRecipeInput = (StarforgeRecipeInput) o;
            return this.width == craftingRecipeInput.width && this.height == craftingRecipeInput.height && this.stackCount == craftingRecipeInput.stackCount && ItemStack.stacksEqual(this.stacks, craftingRecipeInput.stacks);
        }
        return false;
    }

    public int hashCode() {
        int i = ItemStack.listHashCode(this.stacks);
        i = 31 * i + this.width;
        i = 31 * i + this.height;
        return i;
    }


    public record Positioned(StarforgeRecipeInput input, int left, int top) {
        public static final StarforgeRecipeInput.Positioned EMPTY = new StarforgeRecipeInput.Positioned(StarforgeRecipeInput.EMPTY, 0, 0);
    }
}
