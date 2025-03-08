package com.github.wilwe21.stargazer.effects;

import com.github.wilwe21.stargazer.StargazerAttributes;
import com.github.wilwe21.stargazer.mechanics.dash.DashClient;
import net.minecraft.client.MinecraftClient;
import net.minecraft.client.network.ClientPlayerEntity;
import net.minecraft.entity.LivingEntity;
import net.minecraft.entity.attribute.EntityAttributes;
import net.minecraft.entity.effect.StatusEffect;
import net.minecraft.entity.effect.StatusEffectCategory;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.server.world.ServerWorld;

import java.util.Random;

import static com.github.wilwe21.stargazer.mechanics.PlayerInside.*;
import static com.github.wilwe21.stargazer.mechanics.dash.DashClient.*;

public class CosmoFeeling extends StatusEffect {
    public CosmoFeeling(StatusEffectCategory category, int color) {
        super(category, color);
    }

    @Override
    public boolean applyUpdateEffect(ServerWorld world, LivingEntity entity, int amplifier) {
        try {
            ClientPlayerEntity player = MinecraftClient.getInstance().player;
            if (canRefresh(player)) {
                refresh(player, amplifier+1);
            }
        } catch (Exception ignored) {

        }
        return super.applyUpdateEffect(world, entity, amplifier);
    }

    @Override
    public boolean canApplyUpdateEffect(int duration, int amplifier) {
        return true;
    }
}
