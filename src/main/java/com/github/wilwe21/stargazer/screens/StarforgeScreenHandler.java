package com.github.wilwe21.stargazer.screens;

import com.github.wilwe21.stargazer.block.register.MoonBlocks;
import com.github.wilwe21.stargazer.screens.recipeInputs.StarforgeInventory;
import net.minecraft.block.Blocks;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.entity.player.PlayerInventory;
import net.minecraft.inventory.CraftingInventory;
import net.minecraft.inventory.CraftingResultInventory;
import net.minecraft.inventory.Inventory;
import net.minecraft.inventory.RecipeInputInventory;
import net.minecraft.item.ItemStack;
import net.minecraft.network.packet.s2c.play.ScreenHandlerSlotUpdateS2CPacket;
import net.minecraft.recipe.CraftingRecipe;
import net.minecraft.recipe.RecipeEntry;
import net.minecraft.recipe.RecipeFinder;
import net.minecraft.recipe.RecipeType;
import net.minecraft.recipe.book.RecipeBookType;
import net.minecraft.recipe.input.CraftingRecipeInput;
import net.minecraft.screen.*;
import net.minecraft.screen.slot.CraftingResultSlot;
import net.minecraft.screen.slot.Slot;
import net.minecraft.server.network.ServerPlayerEntity;
import net.minecraft.server.world.ServerWorld;
import net.minecraft.world.World;
import org.jetbrains.annotations.Nullable;

import java.util.List;
import java.util.Optional;

public class StarforgeScreenHandler
        extends AbstractRecipeScreenHandler {
    private final ScreenHandlerContext context;
    private final PlayerEntity player;
    private boolean filling;

    protected final RecipeInputInventory craftingInventory;
    protected final CraftingResultInventory craftingResultInventory = new CraftingResultInventory();

    public StarforgeScreenHandler(int syncId, PlayerInventory playerInventory) {
        this(syncId, playerInventory, ScreenHandlerContext.EMPTY);
    }

    public StarforgeScreenHandler(int syncId, PlayerInventory playerInventory, ScreenHandlerContext context) {
        super(ScreenHandlerTypes.STARFORGE_HANDLER, syncId);
        this.craftingInventory = new StarforgeInventory(this, 16);
        this.context = context;
        this.player = playerInventory.player;
        this.addResultSlot(this.player, 124, 35);
        this.addInputSlots(30, 32);
        this.addPlayerSlots(playerInventory, 8, 119);
    }

    protected static void updateResult(ScreenHandler handler, ServerWorld world, PlayerEntity player, RecipeInputInventory craftingInventory, CraftingResultInventory resultInventory, @Nullable RecipeEntry<CraftingRecipe> recipe) {
        CraftingRecipeInput craftingRecipeInput = craftingInventory.createRecipeInput();
        ServerPlayerEntity serverPlayerEntity = (ServerPlayerEntity)player;
        ItemStack itemStack = ItemStack.EMPTY;
        Optional<RecipeEntry<CraftingRecipe>> optional = world.getServer().getRecipeManager().getFirstMatch(RecipeType.CRAFTING, craftingRecipeInput, (World)world, recipe);
        if (optional.isPresent()) {
            ItemStack itemStack2;
            RecipeEntry<CraftingRecipe> recipeEntry = optional.get();
            CraftingRecipe craftingRecipe = recipeEntry.value();
            if (resultInventory.shouldCraftRecipe(serverPlayerEntity, recipeEntry) && (itemStack2 = craftingRecipe.craft(craftingRecipeInput, world.getRegistryManager())).isItemEnabled(world.getEnabledFeatures())) {
                itemStack = itemStack2;
            }
        }
        resultInventory.setStack(0, itemStack);
        handler.setReceivedStack(0, itemStack);
        serverPlayerEntity.networkHandler.sendPacket(new ScreenHandlerSlotUpdateS2CPacket(handler.syncId, handler.nextRevision(), 0, itemStack));
    }

    @Override
    public void onContentChanged(Inventory inventory) {
        if (!this.filling) {
            this.context.run((world, pos) -> {
                if (world instanceof ServerWorld) {
                    ServerWorld serverWorld = (ServerWorld)world;
                    updateResult(this, serverWorld, this.player, this.craftingInventory, this.craftingResultInventory, null);
                }
            });
        }
    }

    protected Slot addResultSlot(PlayerEntity player, int x, int y) {
        return this.addSlot(new CraftingResultSlot(player, this.craftingInventory, this.craftingResultInventory, 0, x, y));
    }

    protected void addInputSlots(int x, int y) {
        int slot = 1;
        for (int i = 0; i < 3; ++i) {
            for (int j = 0; j < 3; ++j) {
                this.addSlot(new Slot(this.craftingInventory, slot, x + j * 18, y + i * 18 - 1));
                slot += 1;
            }
        }
        this.addSlot(new Slot(this.craftingInventory,  slot+1, x - 18, y + 18 - 1));
        this.addSlot(new Slot(this.craftingInventory, slot+2, x + 3 * 18, y + 18 - 1));
        this.addSlot(new Slot(this.craftingInventory, slot+3, x + 18, y - 18 - 1));
        this.addSlot(new Slot(this.craftingInventory, slot+4, x + 3 * 18, y + 3 * 18 - 1));
        this.addSlot(new Slot(this.craftingInventory, slot+5, x - 18, y + 3 * 18 - 1));
    }

    public void onInputSlotFillStart() {
        this.filling = true;
    }

    public void onInputSlotFillFinish(ServerWorld world, RecipeEntry<CraftingRecipe> recipe) {
        this.filling = false;
        updateResult(this, world, this.player, this.craftingInventory, this.craftingResultInventory, recipe);
    }

    @Override
    public void onClosed(PlayerEntity player) {
        super.onClosed(player);
        this.context.run((world, pos) -> this.dropInventory(player, this.craftingInventory));
    }

    @Override
    public boolean canUse(PlayerEntity player) {
        return canUse(this.context, player, MoonBlocks.STAR_FORGE);
    }

    @Override
    public ItemStack quickMove(PlayerEntity player, int slot) {
        return null;
    }

    @Override
    public boolean canInsertIntoSlot(ItemStack stack, Slot slot) {
        return slot.inventory != this.craftingResultInventory && super.canInsertIntoSlot(stack, slot);
    }

    public Slot getOutputSlot() {
        return (Slot)this.slots.get(0);
    }

    public List<Slot> getInputSlots() {
        return this.slots.subList(1, 15);
    }

    @Override
    public PostFillAction fillInputSlots(boolean craftAll, boolean creative, RecipeEntry<?> recipe, ServerWorld world, PlayerInventory inventory) {
        return null;
    }

    @Override
    public void populateRecipeFinder(RecipeFinder finder) {

    }

    @Override
    public RecipeBookType getCategory() {
        return RecipeBookType.CRAFTING;
    }

    protected PlayerEntity getPlayer() {
        return this.player;
    }
}
