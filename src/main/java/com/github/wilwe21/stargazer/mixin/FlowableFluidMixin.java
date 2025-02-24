package com.github.wilwe21.stargazer.mixin;

import com.github.wilwe21.stargazer.block.ModBlock;
import net.minecraft.block.BlockState;
import net.minecraft.fluid.FlowableFluid;
import net.minecraft.util.math.BlockPos;
import net.minecraft.util.math.Direction;
import net.minecraft.world.BlockView;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfoReturnable;

@Mixin(FlowableFluid.class)
public class FlowableFluidMixin {
    @Inject(method = "isFlowBlocked", at = @At("HEAD"), cancellable = true)
    private void water(BlockView world, BlockPos pos, Direction direction, CallbackInfoReturnable<Boolean> cir) {
        BlockState blockState2 = world.getBlockState(pos);
        if (blockState2.getBlock().equals(ModBlock.COSMIC_BLOCK)) {
            cir.setReturnValue(true);
        }
    }
}
