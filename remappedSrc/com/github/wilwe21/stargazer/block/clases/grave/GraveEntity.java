package com.github.wilwe21.stargazer.block.clases.grave;

import com.github.wilwe21.stargazer.block.BlockTypes;
import net.minecraft.block.BlockState;
import net.minecraft.block.entity.BlockEntity;
import net.minecraft.inventory.Inventories;
import net.minecraft.item.ItemStack;
import net.minecraft.nbt.NbtCompound;
import net.minecraft.registry.RegistryWrapper;
import net.minecraft.util.collection.DefaultedList;
import net.minecraft.util.math.BlockPos;

public class GraveEntity extends BlockEntity {
	public String TYPE = "item";
	public DefaultedList<ItemStack> items = DefaultedList.ofSize(1, ItemStack.EMPTY);

	public GraveEntity(BlockPos pos, BlockState state) {
		super(BlockTypes.GRAVE, pos, state);
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