package com.github.wilwe21.stargazer.mixin;

import com.github.wilwe21.stargazer.StargazerAttributes;
import com.github.wilwe21.stargazer.block.cosmic.CosmicBlock;
import com.llamalad7.mixinextras.sugar.Local;
import com.llamalad7.mixinextras.sugar.ref.LocalRef;
import net.minecraft.block.BlockState;
import net.minecraft.entity.attribute.DefaultAttributeContainer;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.util.math.BlockPos;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfo;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfoReturnable;

@Mixin(PlayerEntity.class)
public class PlayerClassMixin {
	@Inject(at = @At("RETURN"), method = "createPlayerAttributes", cancellable = true)
	private static void injectAttributes(CallbackInfoReturnable<DefaultAttributeContainer.Builder> cir) {
		cir.setReturnValue(cir.getReturnValue().add(StargazerAttributes.DASH_LEVEL, 0.0));
	}
}