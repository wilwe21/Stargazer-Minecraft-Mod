package com.github.wilwe21.stargazer.mixin;

import com.github.wilwe21.stargazer.Stargazer;
import com.mojang.authlib.GameProfile;
import net.minecraft.client.network.AbstractClientPlayerEntity;
import net.minecraft.client.network.PlayerListEntry;
import net.minecraft.client.util.DefaultSkinHelper;
import net.minecraft.client.util.SkinTextures;
import net.minecraft.server.world.ServerWorld;
import net.minecraft.util.Identifier;
import net.minecraft.world.level.ServerWorldProperties;
import org.jetbrains.annotations.Nullable;
import org.spongepowered.asm.mixin.Final;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.Shadow;
import org.spongepowered.asm.mixin.Unique;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfo;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfoReturnable;

import java.util.UUID;

@Mixin(AbstractClientPlayerEntity.class)
public abstract class SkinMixin {
    @Shadow
    protected abstract @Nullable PlayerListEntry getPlayerListEntry();

    @Unique
    private static final Identifier skin = Identifier.of(Stargazer.MOD_ID, "textures/entity/player/slim/star_catcher_.png");
    @Unique
    private static final Identifier cape = Identifier.of(Stargazer.MOD_ID, "textures/entity/player/slim/star_catcher_cape.png");

    @Inject(method = "getSkinTextures", at = @At("HEAD"), cancellable = true)
    private void skins(CallbackInfoReturnable cir) {
        PlayerListEntry list = this.getPlayerListEntry();
        if (list.getProfile().getName().equals("star_catcher_")) {
            cir.setReturnValue(new SkinTextures(skin, null, cape, cape, SkinTextures.Model.SLIM, true));
        }
    }
}
