package com.github.wilwe21.stargazer.renderer;

import com.github.wilwe21.stargazer.Stargazer;
import com.mojang.blaze3d.pipeline.BlendFunction;
import com.mojang.blaze3d.pipeline.RenderPipeline;
import com.mojang.blaze3d.platform.LogicOp;
import com.mojang.blaze3d.vertex.VertexFormat;
import net.minecraft.client.gl.RenderPipelines;
import net.minecraft.client.gl.UniformType;
import net.minecraft.client.render.VertexFormats;
import net.minecraft.util.Identifier;

import static net.minecraft.client.gl.RenderPipelines.*;

public class CustomRederPipelines {
    // SNIPPETS
    // SKY
    public static final RenderPipeline.Snippet COSMIC_MATRICES_COLOR_SNIPPET = RenderPipeline.builder(MATRICES_SNIPPET).withUniform("ColorModulator", UniformType.VEC4).withUniform("GameTime", UniformType.FLOAT).buildSnippet();
    // BLOCKS
    public static final RenderPipeline.Snippet RENDERTYPE_COSMIC_SNIPPET = RenderPipeline.builder(MATRICES_SNIPPET, FOG_SNIPPET).withVertexShader(Identifier.of(Stargazer.MOD_ID, "core/rendertype_cosmic")).withFragmentShader(Identifier.of(Stargazer.MOD_ID, "core/rendertype_cosmic")).withSampler("Sampler0").withUniform("GameTime", UniformType.FLOAT).withVertexFormat(VertexFormats.POSITION, VertexFormat.DrawMode.QUADS).buildSnippet();
    public static final RenderPipeline.Snippet RENDERTYPE_STAR_LEAVES_SNIPPET = RenderPipeline.builder(MATRICES_SNIPPET, FOG_SNIPPET).withVertexShader(Identifier.of(Stargazer.MOD_ID, "core/rendertype_star_leaves")).withFragmentShader(Identifier.of(Stargazer.MOD_ID, "core/rendertype_star_leaves")).withSampler("Sampler0").withUniform("GameTime", UniformType.FLOAT).withVertexFormat(VertexFormats.POSITION, VertexFormat.DrawMode.QUADS).buildSnippet();
    public static final RenderPipeline.Snippet RENDERTYPE_STAR_BARIER_SNIPPET = RenderPipeline.builder(MATRICES_SNIPPET, FOG_SNIPPET).withVertexShader(Identifier.of(Stargazer.MOD_ID, "core/rendertype_star_barrier")).withFragmentShader(Identifier.of(Stargazer.MOD_ID, "core/rendertype_star_barrier")).withSampler("Sampler0").withUniform("GameTime", UniformType.FLOAT).withVertexFormat(VertexFormats.POSITION, VertexFormat.DrawMode.QUADS).buildSnippet();
    public static final RenderPipeline.Snippet RENDERTYPE_NEGATIVE_SNIPPET = RenderPipeline.builder(MATRICES_SNIPPET, FOG_SNIPPET).withVertexShader("core/terrain").withFragmentShader("core/terrain").withColorLogic(LogicOp.OR_REVERSE).withVertexFormat(VertexFormats.POSITION, VertexFormat.DrawMode.QUADS).buildSnippet();

    // PIPELINES
    // SKY
    public static final RenderPipeline POSITION_TEX_COLOR_COSMIC_SKY = RenderPipelines.register(RenderPipeline.builder(COSMIC_MATRICES_COLOR_SNIPPET).withLocation("pipeline/cosmic_sky").withVertexShader(Identifier.of(Stargazer.MOD_ID, "core/cosmic_position_color")).withFragmentShader(Identifier.of(Stargazer.MOD_ID, "core/cosmic_position_color")).withSampler("Sampler0").withBlend(BlendFunction.TRANSLUCENT).withDepthWrite(false).withVertexFormat(VertexFormats.POSITION_TEXTURE_COLOR, VertexFormat.DrawMode.QUADS).build());
    // BLOCKS
    public static final RenderPipeline COSMIC = RenderPipelines.register(RenderPipeline.builder(RENDERTYPE_COSMIC_SNIPPET).withLocation(Identifier.of(Stargazer.MOD_ID, "pipeline/cosmic")).build());
    public static final RenderPipeline STAR_LEAVES = RenderPipelines.register(RenderPipeline.builder(RENDERTYPE_STAR_LEAVES_SNIPPET).withLocation(Identifier.of(Stargazer.MOD_ID, "pipeline/star_leaves")).withShaderDefine("ALPHA_CUTOUT", 0.1F).build());
    public static final RenderPipeline STAR_BARRIER = RenderPipelines.register(RenderPipeline.builder(RENDERTYPE_STAR_BARIER_SNIPPET).withLocation(Identifier.of(Stargazer.MOD_ID, "pipeline/star_barrier")).withShaderDefine("ALPHA_CUTOUT", 0.1F).build());
    public static final RenderPipeline NEGATIVE = RenderPipelines.register(RenderPipeline.builder(RENDERTYPE_NEGATIVE_SNIPPET).withLocation(Identifier.of(Stargazer.MOD_ID, "pipeline/negative")).build());
}
