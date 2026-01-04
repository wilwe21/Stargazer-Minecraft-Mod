package com.github.wilwe21.stargazer.mixin;

import com.github.wilwe21.stargazer.Stargazer;
import com.github.wilwe21.stargazer.block.clases.star.cosmic.CosmicBlock;
import com.mojang.blaze3d.buffers.BufferType;
import com.mojang.blaze3d.buffers.BufferUsage;
import com.mojang.blaze3d.buffers.GpuBuffer;
import com.mojang.blaze3d.systems.RenderPass;
import com.mojang.blaze3d.systems.RenderSystem;
import com.mojang.blaze3d.textures.GpuTexture;
import com.mojang.blaze3d.vertex.VertexFormat;
import net.fabricmc.fabric.api.biome.v1.BiomeModificationContext;
import net.minecraft.client.MinecraftClient;
import net.minecraft.client.gl.RenderPipelines;
import net.minecraft.client.option.CloudRenderMode;
import net.minecraft.client.render.*;
import net.minecraft.client.texture.AbstractTexture;
import net.minecraft.client.texture.TextureManager;
import net.minecraft.client.util.BufferAllocator;
import net.minecraft.client.util.ObjectAllocator;
import net.minecraft.server.command.WeatherCommand;
import net.minecraft.test.TestEnvironmentDefinition;
import net.minecraft.util.Colors;
import net.minecraft.util.Identifier;
import net.minecraft.util.TriState;
import net.minecraft.util.math.Vec3d;
import net.minecraft.world.World;
import org.joml.Matrix4f;
import org.joml.Vector4f;
import org.spongepowered.asm.mixin.Final;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.Shadow;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.Redirect;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfo;

import java.util.OptionalDouble;
import java.util.OptionalInt;

@Mixin(WorldRenderer.class)
public class WorldRendererMixin {
    @Shadow @Final private MinecraftClient client;

    // Shadowing the SkyRendering object if it's a field in GameRenderer.
    // If it's a local variable or created within renderSky, the injection strategy would be different.
    @Shadow private SkyRendering skyRendering;
    @Shadow private CloudRenderer cloudRenderer;
    @Shadow private WeatherRendering weatherRendering;

    @Redirect(
            method = "renderSky(Lnet/minecraft/client/render/FrameGraphBuilder;Lnet/minecraft/client/render/Camera;FLnet/minecraft/client/render/Fog;)V",
            at = @At(
                    value = "INVOKE",
                    target = "Lnet/minecraft/client/render/FramePass;setRenderer(Ljava/lang/Runnable;)V"
            )
    )
    private void redirectFramePassSetRenderer(FramePass framePass, Runnable originalRunnable) {
        framePass.setRenderer(() -> {
            World world = client.world;
            if (world.getDimension().effects().equals(Identifier.of(Stargazer.MOD_ID, "cosmic"))) {
                this.skyRendering.renderEndSky();
                Camera camera = client.gameRenderer.getCamera();
                Fog fog = BackgroundRenderer.applyFog(camera, BackgroundRenderer.FogType.FOG_TERRAIN, new Vector4f(), 0, false, 0);
                RenderSystem.setShaderFog(fog);
            } else {
                originalRunnable.run();
            }
        });
    }
    @Inject(method = "renderClouds", at = @At("HEAD"), cancellable = true)
    private void injectAtRenderCloudsStart(
            FrameGraphBuilder frameGraphBuilder,
            CloudRenderMode mode,
            Vec3d cameraPos,
            float f,
            int color,
            float cloudHeight,
            CallbackInfo ci
    ) {
        World world = client.world;
        if (world.getDimension().effects().equals(Identifier.of(Stargazer.MOD_ID, "cosmic"))) {
            ci.cancel();
        }
    }
//    @Inject(method = "renderWeather", at = @At("HEAD"), cancellable = true)
//    private void InjectAtWeather(
//            FrameGraphBuilder frameGraphBuilder,
//            Vec3d cameraPos,
//            float tickProgress,
//            Fog fog,
//            CallbackInfo ci) {
//        World world = client.world;
//        if (world.getDimension().effects().equals(Identifier.of(Stargazer.MOD_ID, "cosmic"))) {
//            ci.cancel();
//        }
//    }
}
