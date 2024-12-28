package com.github.wilwe21.celeste.render;

import com.github.wilwe21.celeste.block.custom.DreamBlockEntityRenderer;
import net.fabricmc.api.EnvType;
import net.fabricmc.api.Environment;
import net.minecraft.client.render.*;
import net.minecraft.client.render.block.entity.EndPortalBlockEntityRenderer;

@Environment(EnvType.CLIENT)
public abstract class DreamRenderLayer {

    public static final RenderLayer DREAM = RenderLayer.of(
            "dream",
            VertexFormats.POSITION,
            VertexFormat.DrawMode.QUADS,
            1536,
            false,
            false,
            RenderLayer.MultiPhaseParameters.builder()
                    .program(RenderPhase.END_GATEWAY_PROGRAM)
                    .texture(
                            RenderPhase.Textures.create()
                                    .add(DreamBlockEntityRenderer.DREAM_TEXTURE, false, false)
                                    .add(DreamBlockEntityRenderer.DREAM_TEXTURE, false, false)
                                    .build()
                    )
                    .build(false)
    );
}