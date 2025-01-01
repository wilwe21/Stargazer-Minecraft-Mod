package com.github.wilwe21.gsad.block.custom.blockEntity.Mario.lucky;

import com.github.wilwe21.gsad.block.BlockTypes;
import com.github.wilwe21.gsad.block.ModBlock;
import net.minecraft.block.BlockState;
import net.minecraft.block.entity.*;
import net.minecraft.item.Item;
import net.minecraft.nbt.NbtCompound;
import net.minecraft.registry.RegistryWrapper;
import net.minecraft.util.math.BlockPos;

public class LuckyBlockEntity extends BlockEntity {
	public String TYPE = "item";
	public int ITEM = Item.getRawId(ModBlock.STRAWBERRY.asItem());

	public LuckyBlockEntity(BlockPos pos, BlockState state) {
		super(BlockTypes.LUCKY_BLOCK, pos, state);
	}

	@Override
	protected void readNbt(NbtCompound nbt, RegistryWrapper.WrapperLookup registryLookup) {
		super.readNbt(nbt, registryLookup);
		TYPE = nbt.getString("type");
		ITEM = nbt.getInt("item");

		if (world != null) {
			world.updateListeners(pos, getCachedState(), getCachedState(), 0);
		}
	}

	@Override
	protected void writeNbt(NbtCompound nbt, RegistryWrapper.WrapperLookup registryLookup) {
		super.writeNbt(nbt, registryLookup);
		nbt.putString("type", TYPE);
		nbt.putInt("item", ITEM);
	}

	public String getNbtType() {
		return TYPE;
	}

	public void setNbtType(String value) {
		TYPE = value;
		markDirty(); // Notify the game that the block entity has changed
	}

	public int getNbtItem() {
		return ITEM;
	}

	public void setNbtItem(int value) {
		ITEM = value;
		markDirty(); // Notify the game that the block entity has changed
	}
}