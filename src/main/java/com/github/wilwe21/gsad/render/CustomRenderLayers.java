package com.github.wilwe21.gsad.render;

import com.github.wilwe21.gsad.block.custom.dream.DreamBlockEntityRenderer;
import com.github.wilwe21.gsad.block.custom.tv.TvEntityRenderer;
import net.fabricmc.api.EnvType;
import net.fabricmc.api.Environment;
import net.minecraft.client.gl.ShaderProgramKeys;
import net.minecraft.client.render.*;

@Environment(EnvType.CLIENT)
public abstract class CustomRenderLayers {
    public static final RenderPhase.ShaderProgram DREAM_PROGRAM = new RenderPhase.ShaderProgram(ShaderProgramKeys.RENDERTYPE_END_GATEWAY);

    public static final RenderLayer DREAM = RenderLayer.of(
            "dream",
            VertexFormats.POSITION,
            VertexFormat.DrawMode.QUADS,
            1536,
            false,
            false,
            RenderLayer.MultiPhaseParameters.builder()
                    .program(DREAM_PROGRAM)
                    .texture(
                            RenderPhase.Textures.create()
                                    .add(DreamBlockEntityRenderer.DREAM_TEXTURE, false, false)
                                    .add(DreamBlockEntityRenderer.DREAM_TEXTURE, false, false)
                                    .build()
                    )
                    .build(false)
    );

    public static final RenderPhase.ShaderProgram TV_PROGRAM = new RenderPhase.ShaderProgram(ShaderProgramKeys.RENDERTYPE_END_GATEWAY);

    public static final RenderLayer TV = RenderLayer.of(
            "tv",
            VertexFormats.POSITION,
            VertexFormat.DrawMode.QUADS,
            1536,
            false,
            false,
            RenderLayer.MultiPhaseParameters.builder()
                    .program(TV_PROGRAM)
                    .texture(
                            RenderPhase.Textures.create()
                                    .add(TvEntityRenderer.TV_TEXTURE, false, false)
                                    .build()
                    )
                    .build(false)
    );
}