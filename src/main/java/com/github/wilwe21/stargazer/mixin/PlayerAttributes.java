package com.github.wilwe21.stargazer.mixin;

import com.github.wilwe21.stargazer.StargazerAttributes;
import net.minecraft.entity.attribute.DefaultAttributeContainer;
import net.minecraft.entity.player.PlayerEntity;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfoReturnable;

@Mixin(PlayerEntity.class)
public class PlayerAttributes {
	@Inject(at = @At("RETURN"), method = "createPlayerAttributes", cancellable = true)
	private static void injectAttributes(CallbackInfoReturnable<DefaultAttributeContainer.Builder> cir) {
		cir.setReturnValue(cir.getReturnValue().add(StargazerAttributes.DASH_LEVEL, 1.0));
	}
}