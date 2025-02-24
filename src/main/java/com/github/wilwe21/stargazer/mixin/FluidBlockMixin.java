package com.github.wilwe21.stargazer.mixin;

import com.github.wilwe21.stargazer.Helpers;
import com.github.wilwe21.stargazer.block.ModBlock;
import com.github.wilwe21.stargazer.block.register.MoonBlocks;
import net.minecraft.block.*;
import net.minecraft.registry.tag.FluidTags;
import net.minecraft.state.property.Properties;
import net.minecraft.util.math.BlockPos;
import net.minecraft.util.math.Direction;
import net.minecraft.world.World;
import org.apache.logging.log4j.core.tools.picocli.CommandLine;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfoReturnable;

import static net.minecraft.block.FluidBlock.FLOW_DIRECTIONS;

@Mixin(FluidBlock.class)
public class FluidBlockMixin {
    @Inject(method = "receiveNeighborFluids", at = @At("HEAD"), cancellable = true)
    private void water(World world, BlockPos pos, BlockState state, CallbackInfoReturnable<Boolean> cir) {
        for (Direction direction : FLOW_DIRECTIONS) {
            if (Helpers.isColliding(ModBlock.COSMIC_BLOCK, world, pos, direction)) {
                BlockPos blockPos = pos.offset(direction.getOpposite());
                if (world.getFluidState(blockPos).isIn(FluidTags.WATER)) {
                    BlockState block = world.getFluidState(pos).isStill() ? MoonBlocks.MOON_LOG.getDefaultState().with(Properties.AXIS, Direction.Axis.Y) : MoonBlocks.MOON_ROCK.getDefaultState();
                    world.setBlockState(pos, block);
                    cir.setReturnValue(false);
                }
            }
        }
       if (world.getFluidState(pos).isStill()) {
           if (Helpers.isCollidingAny(ModBlock.COSMIC_BLOCK, world, pos, FLOW_DIRECTIONS)) {
               BlockState block = world.getFluidState(pos).isStill() ? MoonBlocks.MOON_LOG.getDefaultState().with(Properties.AXIS, Direction.Axis.Y) : MoonBlocks.MOON_ROCK.getDefaultState();
               world.setBlockState(pos, block);
               cir.setReturnValue(false);
           }
       }
    }
}
