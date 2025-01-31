package com.github.wilwe21.gsad.block.custom.celeste.summit;

import com.mojang.serialization.MapCodec;
import net.minecraft.block.BlockState;
import net.minecraft.block.BlockWithEntity;
import net.minecraft.block.entity.BlockEntity;
import net.minecraft.item.ItemStack;
import net.minecraft.util.DyeColor;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.WorldView;

public abstract class AbstractSummit extends BlockWithEntity {
	private final DyeColor color;

	protected AbstractSummit(DyeColor color, Settings settings) {
		super(settings);
		this.color = color;
	}

	@Override
	protected abstract MapCodec<? extends AbstractSummit> getCodec();

	@Override
	public boolean canMobSpawnInside(BlockState state) {
		return true;
	}

	@Override
	public BlockEntity createBlockEntity(BlockPos pos, BlockState state) {
		return new SummitEntity(pos, state, this.color);
	}

	@Override
	protected ItemStack getPickStack(WorldView world, BlockPos pos, BlockState state, boolean includeData) {
		return world.getBlockEntity(pos) instanceof SummitEntity bannerBlockEntity
			? bannerBlockEntity.getPickStack()
			: super.getPickStack(world, pos, state, includeData);
	}

	public DyeColor getColor() {
		return this.color;
	}
}
