package com.github.wilwe21.stargazer.block.clases.bonsai;

import com.github.wilwe21.stargazer.block.BlockTypes;
import net.minecraft.block.BlockState;
import net.minecraft.block.entity.BeehiveBlockEntity;
import net.minecraft.block.entity.BlockEntity;
import net.minecraft.nbt.NbtCompound;
import net.minecraft.registry.RegistryWrapper;
import net.minecraft.server.network.DebugInfoSender;
import net.minecraft.sound.SoundCategory;
import net.minecraft.sound.SoundEvents;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.World;

public class BonsaiLogEntity extends BlockEntity {
    public int ROOTX;
    public int ROOTY;
    public int ROOTZ;

    public BonsaiLogEntity(BlockPos pos, BlockState state) {
        super(BlockTypes.BONSAI_LOG, pos, state);
        BlockEntity otherEntity = this.getWorld().getBlockEntity(pos.down(1));
        if (otherEntity instanceof BonsaiLogEntity ble) {
            ROOTX = ble.ROOTX;
            ROOTY = ble.ROOTY;
            ROOTZ = ble.ROOTZ;
        } else {
            ROOTX = pos.getX();
            ROOTY = pos.getY();
            ROOTZ = pos.getZ();
        }
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

    public static void serverTick(World world, BlockPos pos, BlockState state, BeehiveBlockEntity blockEntity) {
        DebugInfoSender.sendBeehiveDebugData(world, pos, state, blockEntity);
    }
}
