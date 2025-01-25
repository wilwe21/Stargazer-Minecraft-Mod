package com.github.wilwe21.gsad.block.custom.celeste.refil;

import com.github.wilwe21.gsad.block.BlockTypes;
import net.minecraft.block.BlockState;
import net.minecraft.block.entity.BlockEntity;
import net.minecraft.inventory.Inventories;
import net.minecraft.nbt.NbtCompound;
import net.minecraft.registry.RegistryWrapper;
import net.minecraft.util.math.BlockPos;

public class RefilCrystalEntity extends BlockEntity {
    public boolean active = true;
    public RefilCrystalEntity(BlockPos pos, BlockState state) {
        super(BlockTypes.REFIL, pos, state);
    }

    @Override
    protected void readNbt(NbtCompound nbt, RegistryWrapper.WrapperLookup registryLookup) {
        super.readNbt(nbt, registryLookup);
        active = nbt.getBoolean("activated");
    }

    @Override
    protected void writeNbt(NbtCompound nbt, RegistryWrapper.WrapperLookup registryLookup) {
        super.writeNbt(nbt, registryLookup);
        nbt.putBoolean("activated", true);
    }
}
