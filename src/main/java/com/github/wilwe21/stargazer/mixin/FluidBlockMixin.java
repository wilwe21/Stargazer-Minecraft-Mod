package com.github.wilwe21.stargazer.mixin;

import com.github.wilwe21.stargazer.mechanics.CobbleGen;
import net.minecraft.block.*;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.World;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfoReturnable;

@Mixin(FluidBlock.class)
public class FluidBlockMixin {
    @Inject(method = "receiveNeighborFluids", at = @At("HEAD"), cancellable = true)
    private void water(World world, BlockPos pos, BlockState state, CallbackInfoReturnable<Boolean> cir) {
        if (!CobbleGen.test(world, pos)) {
            cir.setReturnValue(false);
        }
    }
}
