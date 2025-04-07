package com.github.wilwe21.stargazer.block.clases.bonsai;

import com.github.wilwe21.stargazer.block.BlockTypes;
import net.minecraft.block.BlockState;
import net.minecraft.block.entity.BlockEntity;
import net.minecraft.nbt.NbtCompound;
import net.minecraft.registry.RegistryWrapper;
import net.minecraft.util.math.BlockPos;

public class LivingBonsaiLogEntity extends BlockEntity {
    public int ROOTX;
    public int ROOTY;
    public int ROOTZ;

    public LivingBonsaiLogEntity(BlockPos pos, BlockState state) {
        super(BlockTypes.BONSAI_LOG, pos, state);
        ROOTX = pos.getX();
        ROOTY = pos.getY();
        ROOTZ = pos.getZ();
    }

    @Override
    protected void readNbt(NbtCompound nbt, RegistryWrapper.WrapperLookup registries) {
        super.readNbt(nbt, registries);
        ROOTX = nbt.getInt("rootx");
        ROOTY = nbt.getInt("rooty");
        ROOTZ = nbt.getInt("rootz");

        if (world != null) {
            world.updateListeners(pos, getCachedState(), getCachedState(), 0);
        }
    }

    @Override
    protected void writeNbt(NbtCompound nbt, RegistryWrapper.WrapperLookup registries) {
        super.writeNbt(nbt, registries);
        nbt.putInt("rootx", ROOTX);
        nbt.putInt("rooty", ROOTY);
        nbt.putInt("rootz", ROOTZ);
    }

    public void setROOTX(int x) {
        ROOTX = x;
        markDirty();
    }
    public void setROOTY(int y) {
        ROOTY = y;
        markDirty();
    }
    public void setROOTZ(int z) {
        ROOTZ = z;
        markDirty();
    }
}
