package com.github.wilwe21.stargazer.render;

import com.github.wilwe21.stargazer.Stargazer;
import net.fabricmc.api.EnvType;
import net.fabricmc.api.Environment;
import net.minecraft.client.gl.Defines;
import net.minecraft.client.gl.ShaderProgramKey;
import net.minecraft.client.render.*;
import net.minecraft.util.Identifier;

@Environment(EnvType.CLIENT)
public abstract class CustomRenderLayers {

    public static final ShaderProgramKey RENDERTYPE_NEGATIVE = registerCustom(Stargazer.MOD_ID, "rendertype_negative", VertexFormats.POSITION);

    public static final ShaderProgramKey RENDERTYPE_COSMIC = registerCustom(Stargazer.MOD_ID, "rendertype_cosmic", VertexFormats.POSITION);

    private static ShaderProgramKey registerCustom(String id, String name, VertexFormat format) {
        return registerCustom(id, name, format, Defines.EMPTY);
    }
    private static ShaderProgramKey registerCustom(String id, String name, VertexFormat format, Defines defines) {
        ShaderProgramKey shaderProgramKey = new ShaderProgramKey(Identifier.of(id, "core/" + name), format, defines);
        return shaderProgramKey;
    }


    public static final RenderPhase.ShaderProgram NEGATIVE_PROGRAM = new RenderPhase.ShaderProgram(RENDERTYPE_NEGATIVE);

    public static final RenderLayer NEGATIVE = RenderLayer.of(
            "negative",
            VertexFormats.POSITION,
            VertexFormat.DrawMode.QUADS,
            16,
            false,
            true,
            RenderLayer.MultiPhaseParameters.builder()
                    .program(NEGATIVE_PROGRAM)
                    .colorLogic(RenderPhase.ColorLogic.OR_REVERSE)
                    .build(false)
    );

    public static final RenderPhase.ShaderProgram COSMIC_PROGRAM = new RenderPhase.ShaderProgram(RENDERTYPE_COSMIC);
    public static final Identifier DREAM_TEXTURE = Identifier.of(Stargazer.MOD_ID, "textures/block/dream_block.png");


    public static final RenderLayer COSMIC = RenderLayer.of(
            "cosmic",
            VertexFormats.POSITION,
            VertexFormat.DrawMode.QUADS,
            1536,
            false,
            false,
            RenderLayer.MultiPhaseParameters.builder()
                    .program(COSMIC_PROGRAM)
                    .texture(
                            RenderPhase.Textures.create()
                                    .add(DREAM_TEXTURE, false, false)
                                    .add(DREAM_TEXTURE, false, false)
                                    .build()
                    )
                    .build(false)
    );

    public static void init() {}
}