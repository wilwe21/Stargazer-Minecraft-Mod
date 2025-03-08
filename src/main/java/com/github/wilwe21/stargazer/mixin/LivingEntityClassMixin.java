package com.github.wilwe21.stargazer.mixin;

import com.github.wilwe21.stargazer.StargazerAttributes;
import net.minecraft.entity.LivingEntity;
import net.minecraft.entity.attribute.DefaultAttributeContainer;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.util.math.Box;
import net.minecraft.util.shape.VoxelShapes;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfoReturnable;

import javax.swing.*;

@Mixin(LivingEntity.class)
public class LivingEntityClassMixin {
	// Potion Effect ???
//	@Inject(at = @At("RETURN"), method = "hurtByWater", cancellable = true)
//	private static void injectAttributes(CallbackInfoReturnable<Boolean> cir) {
//		cir.setReturnValue(true);
//	}
}