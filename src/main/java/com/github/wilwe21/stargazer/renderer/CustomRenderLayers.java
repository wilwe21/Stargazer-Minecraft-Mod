package com.github.wilwe21.stargazer.renderer;

import com.github.wilwe21.stargazer.block.clases.star.cosmic.CosmicBlock;
import net.minecraft.client.render.RenderLayer;
import net.minecraft.client.render.RenderPhase;

public class CustomRenderLayers {
    public static final RenderLayer COSMIC = RenderLayer.of("cosmic", 1536, false, false, CustomRederPipelines.COSMIC, RenderLayer.MultiPhaseParameters.builder().texture(RenderPhase.Textures.create().add(CosmicBlock.TEXTURE, false, false).add(CosmicBlock.TEXTURE, false, false).build()).build(false));
}
