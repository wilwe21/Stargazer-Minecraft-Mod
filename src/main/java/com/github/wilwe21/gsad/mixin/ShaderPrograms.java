package com.github.wilwe21.gsad.mixin;

import com.github.wilwe21.gsad.block.ModBlock;
import com.github.wilwe21.gsad.render.CustomRenderLayers;
import net.minecraft.block.Block;
import net.minecraft.client.render.RenderLayer;
import net.minecraft.client.render.RenderLayers;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfoReturnable;

import java.util.Map;

@Mixin(RenderLayers.class)
public class ShaderPrograms {
//	@Inject(at = @At("RETURN"), method = "BLOCKS")
//	private static void inject(CallbackInfoReturnable<Map<Block, RenderLayer>> cir) {
//		Map<Block, RenderLayer> map = cir.getReturnValue();
//		map.put(ModBlock.DREAM_BLOCK, CustomRenderLayers.DREAM);
//		map.put(ModBlock.TV_BLOCK, CustomRenderLayers.TV);
//		cir.setReturnValue(map);
//	}
}