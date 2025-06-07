package com.github.wilwe21.stargazer.renderer;

import com.github.wilwe21.stargazer.Stargazer;
import com.mojang.blaze3d.pipeline.RenderPipeline;
import com.mojang.blaze3d.vertex.VertexFormat;
import net.minecraft.client.gl.RenderPipelines;
import net.minecraft.client.gl.UniformType;
import net.minecraft.client.render.VertexFormats;
import net.minecraft.util.Identifier;

import static net.minecraft.client.gl.RenderPipelines.FOG_SNIPPET;
import static net.minecraft.client.gl.RenderPipelines.MATRICES_SNIPPET;

public class CustomRederPipelines {
    // SNIPPETS
    public static final RenderPipeline.Snippet RENDERTYPE_COSMIC_SNIPPET = RenderPipeline.builder(MATRICES_SNIPPET, FOG_SNIPPET).withVertexShader(Identifier.of(Stargazer.MOD_ID, "core/rendertype_cosmic")).withFragmentShader(Identifier.of(Stargazer.MOD_ID, "core/rendertype_cosmic")).withSampler("Sampler0").withUniform("GameTime", UniformType.FLOAT).withVertexFormat(VertexFormats.POSITION, VertexFormat.DrawMode.QUADS).buildSnippet();
    public static final RenderPipeline.Snippet RENDERTYPE_NEGATIVE_SNIPPET = RenderPipeline.builder(MATRICES_SNIPPET, FOG_SNIPPET).withVertexShader(Identifier.of(Stargazer.MOD_ID, "core/rendertype_negative")).withFragmentShader(Identifier.of(Stargazer.MOD_ID, "core/rendertype_negative")).withSampler("Sampler2").withSampler("InSampler").withUniform("GameTime", UniformType.FLOAT).withVertexFormat(VertexFormats.POSITION, VertexFormat.DrawMode.QUADS).buildSnippet();

    // PIPELINES
    public static final RenderPipeline COSMIC = RenderPipelines.register(RenderPipeline.builder(RENDERTYPE_COSMIC_SNIPPET).withLocation(Identifier.of(Stargazer.MOD_ID, "pipeline/cosmic")).withShaderDefine("StarLayers", 8).build());
    public static final RenderPipeline NEGATIVE = RenderPipelines.register(RenderPipeline.builder(RENDERTYPE_NEGATIVE_SNIPPET).withLocation(Identifier.of(Stargazer.MOD_ID, "pipeline/negative")).withShaderDefine("ALPHA_CUTOUT", 0.1F).build());
}
