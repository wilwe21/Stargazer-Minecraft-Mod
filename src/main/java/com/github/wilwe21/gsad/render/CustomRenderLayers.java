package com.github.wilwe21.gsad.render;

import com.github.wilwe21.gsad.Gsad;
import com.github.wilwe21.gsad.block.custom.blockEntity.dream.DreamBlockEntityRenderer;
import com.github.wilwe21.gsad.block.custom.blockEntity.tv.TvEntityRenderer;
import net.fabricmc.api.EnvType;
import net.fabricmc.api.Environment;
import net.minecraft.client.gl.Defines;
import net.minecraft.client.gl.ShaderProgramKey;
import net.minecraft.client.render.*;
import net.minecraft.util.Identifier;

@Environment(EnvType.CLIENT)
public abstract class CustomRenderLayers {

    public static final ShaderProgramKey RENDERTYPE_DREAM = registerCustom(Gsad.MOD_ID, "rendertype_dream", VertexFormats.POSITION);
    public static final ShaderProgramKey RENDERTYPE_TV = registerCustom(Gsad.MOD_ID, "rendertype_tv", VertexFormats.POSITION);

    private static ShaderProgramKey registerCustom(String id, String name, VertexFormat format) {
        return registerCustom(id, name, format, Defines.EMPTY);
    }
    private static ShaderProgramKey registerCustom(String id, String name, VertexFormat format, Defines defines) {
        ShaderProgramKey shaderProgramKey = new ShaderProgramKey(Identifier.of(id, "core/" + name), format, defines);
        return shaderProgramKey;
    }

    public static final RenderPhase.ShaderProgram DREAM_PROGRAM = new RenderPhase.ShaderProgram(RENDERTYPE_DREAM);

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

    public static final RenderPhase.ShaderProgram TV_PROGRAM = new RenderPhase.ShaderProgram(RENDERTYPE_TV);

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

    public static void init() {}
}