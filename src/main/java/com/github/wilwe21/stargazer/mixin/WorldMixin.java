package com.github.wilwe21.stargazer.mixin;

import com.github.wilwe21.stargazer.Stargazer;
import com.github.wilwe21.stargazer.renderer.CustomRederPipelines;
import com.mojang.blaze3d.buffers.GpuBuffer;
import com.mojang.blaze3d.systems.RenderPass;
import com.mojang.blaze3d.systems.RenderSystem;
import com.mojang.blaze3d.textures.GpuTexture;
import com.mojang.blaze3d.vertex.VertexFormat;
import net.minecraft.client.MinecraftClient;
import net.minecraft.client.render.SkyRendering;
import net.minecraft.client.texture.AbstractTexture;
import net.minecraft.client.texture.TextureManager;
import net.minecraft.server.command.WeatherCommand;
import net.minecraft.server.world.ServerWorld;
import net.minecraft.util.Identifier;
import net.minecraft.util.TriState;
import net.minecraft.world.World;
import net.minecraft.world.dimension.DimensionType;
import net.minecraft.world.level.ServerWorldProperties;
import org.spongepowered.asm.mixin.Final;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.Shadow;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfo;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfoReturnable;

import java.util.OptionalDouble;
import java.util.OptionalInt;

@Mixin(ServerWorld.class)
public abstract class WorldMixin {

    @Shadow
    @Final
    private ServerWorldProperties worldProperties;

    @Shadow
    public abstract ServerWorld toServerWorld();

    @Inject(method = "tickWeather", at = @At("HEAD"), cancellable = true)
    private void consmicWeather(CallbackInfo ci) {
        if (this.toServerWorld().getDimension().effects().equals(Identifier.of(Stargazer.MOD_ID, "cosmic"))) {
            ci.cancel();
        }
    }
}
