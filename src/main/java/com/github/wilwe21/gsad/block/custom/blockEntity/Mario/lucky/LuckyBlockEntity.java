package com.github.wilwe21.gsad.block.custom.blockEntity.Mario.lucky;

import com.github.wilwe21.gsad.block.BlockTypes;
import com.github.wilwe21.gsad.block.ModBlock;
import net.minecraft.block.BlockState;
import net.minecraft.block.entity.*;
import net.minecraft.inventory.Inventories;
import net.minecraft.inventory.Inventory;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.nbt.NbtCompound;
import net.minecraft.registry.RegistryWrapper;
import net.minecraft.util.collection.DefaultedList;
import net.minecraft.util.math.BlockPos;

public class LuckyBlockEntity extends BlockEntity {
	public String TYPE = "item";
	public DefaultedList<ItemStack> items = DefaultedList.ofSize(1, ItemStack.EMPTY);

	public LuckyBlockEntity(BlockPos pos, BlockState state) {
		super(BlockTypes.LUCKY_BLOCK, pos, state);
	}

	@Override
	protected void readNbt(NbtCompound nbt, RegistryWrapper.WrapperLookup registryLookup) {
		super.readNbt(nbt, registryLookup);
		TYPE = nbt.getString("type");
		Inventories.readNbt(nbt, items, registryLookup);

		if (world != null) {
			world.updateListeners(pos, getCachedState(), getCachedState(), 0);
		}
	}

	@Override
	protected void writeNbt(NbtCompound nbt, RegistryWrapper.WrapperLookup registryLookup) {
		super.writeNbt(nbt, registryLookup);
		nbt.putString("type", TYPE);
		Inventories.writeNbt(nbt, items, registryLookup);
	}

	public String getNbtType() {
		return TYPE;
	}

	public void setNbtType(String value) {
		TYPE = value;
		markDirty();
	}

	public DefaultedList<ItemStack> getNbtItems() {
		return items;
	}

	public void setNbtItems(DefaultedList<ItemStack> value) {
		items = value;
		markDirty();
	}
}