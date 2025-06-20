package com.github.wilwe21.stargazer.renderer;

import com.github.wilwe21.stargazer.Stargazer;
import com.github.wilwe21.stargazer.block.clases.star.barrier.StarBarrierBlock;
import com.github.wilwe21.stargazer.block.clases.star.cosmic.CosmicBlock;
import com.github.wilwe21.stargazer.block.clases.star.leaves.StarLeaves;
import com.mojang.blaze3d.pipeline.BlendFunction;
import com.mojang.blaze3d.pipeline.RenderPipeline;
import com.mojang.blaze3d.vertex.VertexFormat;
import net.minecraft.client.gl.RenderPipelines;
import net.minecraft.client.render.RenderLayer;
import net.minecraft.client.render.RenderPhase;
import net.minecraft.client.render.VertexFormats;
import net.minecraft.util.Identifier;

import static net.minecraft.client.gl.RenderPipelines.MATRICES_COLOR_SNIPPET;

public class CustomRenderLayers {

    public static final RenderLayer COSMIC = RenderLayer.of("cosmic", 1536, false, false, CustomRederPipelines.COSMIC, RenderLayer.MultiPhaseParameters.builder().texture(RenderPhase.Textures.create().add(CosmicBlock.TEXTURE, false, false).build()).build(false));
    public static final RenderLayer STAR_LEAVES = RenderLayer.of("star_leaves", 1536, false, false, CustomRederPipelines.STAR_LEAVES, RenderLayer.MultiPhaseParameters.builder().texture(RenderPhase.Textures.create().add(StarLeaves.TEXTURE, false, false).build()).build(false));
    public static final RenderLayer STAR_BARRIER = RenderLayer.of("star_barrier", 1536, false, false, CustomRederPipelines.STAR_BARRIER, RenderLayer.MultiPhaseParameters.builder().texture(RenderPhase.Textures.create().add(StarBarrierBlock.TEXTURE, false, false).build()).build(false));
    public static final RenderLayer NEGATIVE = RenderLayer.of("negative", 16, false, true, CustomRederPipelines.NEGATIVE, RenderLayer.MultiPhaseParameters.builder().build(true));
}
