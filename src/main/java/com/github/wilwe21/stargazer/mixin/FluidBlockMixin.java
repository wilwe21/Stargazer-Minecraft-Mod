package com.github.wilwe21.stargazer.mixin;

import com.github.wilwe21.stargazer.Stargazer;
import com.github.wilwe21.stargazer.mechanics.Generators.CobbleGen;
import com.github.wilwe21.stargazer.mechanics.Generators.Gens;
import net.minecraft.block.*;
import net.minecraft.registry.tag.BlockTags;
import net.minecraft.registry.tag.FluidTags;
import net.minecraft.util.Identifier;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.World;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfo;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfoReturnable;

@Mixin(FluidBlock.class)
public class FluidBlockMixin {
    @Inject(method = "onBlockAdded", at = @At("HEAD"), cancellable = true)
    private void add(BlockState state, World world, BlockPos pos, BlockState oldState, boolean notify, CallbackInfo ci) {
        if (world.getDimension().effects().equals(Identifier.of(Stargazer.MOD_ID, "cosmic"))) {
            if (state.getFluidState().isIn(FluidTags.WATER)) {
                world.setBlockState(pos, Blocks.ICE.getDefaultState());
            }
            if (state.getFluidState().isIn(FluidTags.LAVA)) {
                world.setBlockState(pos, Blocks.MAGMA_BLOCK.getDefaultState());
            }
            ci.cancel();
        }
    }
    @Inject(method = "receiveNeighborFluids", at = @At("HEAD"), cancellable = true)
    private void water(World world, BlockPos pos, BlockState state, CallbackInfoReturnable<Boolean> cir) {
        for (CobbleGen gen : Gens.list) {
            if (gen.ARRAYUSE) {
                if (!gen.genFromArray(world, pos)) {
                    cir.setReturnValue(false);
                }
            } else {
                if (!gen.gen(world, pos)) {
                    cir.setReturnValue(false);
                }
            }
        }
    }
}
