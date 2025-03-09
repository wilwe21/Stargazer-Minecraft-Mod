package com.github.wilwe21.stargazer.effects;

import com.github.wilwe21.stargazer.Stargazer;
import com.github.wilwe21.stargazer.mechanics.DamageTypeRegistry;
import net.minecraft.client.MinecraftClient;
import net.minecraft.client.network.ClientPlayerEntity;
import net.minecraft.entity.EntityType;
import net.minecraft.entity.LivingEntity;
import net.minecraft.entity.SpawnReason;
import net.minecraft.entity.damage.DamageSource;
import net.minecraft.entity.effect.StatusEffect;
import net.minecraft.entity.effect.StatusEffectCategory;
import net.minecraft.entity.mob.SilverfishEntity;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.item.ItemStack;
import net.minecraft.particle.ParticleEffect;
import net.minecraft.registry.RegistryKeys;
import net.minecraft.server.world.ServerWorld;
import net.minecraft.sound.SoundEvents;
import net.minecraft.util.math.MathHelper;
import net.minecraft.util.math.Vec3d;
import net.minecraft.util.math.random.Random;
import org.joml.Vector3f;

public class GlassHands extends StatusEffect {
    public GlassHands(StatusEffectCategory category, int color) {
        super(category, color);
    }

    protected GlassHands(StatusEffectCategory category, int color, ParticleEffect particleEffect) {
        super(category, color, particleEffect);
    }

    @Override
    public void onEntityDamage(ServerWorld world, LivingEntity entity, int amplifier, DamageSource source, float amount) {
        ItemStack mh = entity.getMainHandStack();
        ItemStack oh = entity.getOffHandStack();
        if (!mh.isEmpty()) {
            mh.decrement(1);
        } else if (!oh.isEmpty()) {
            oh.decrement(1);
        } else {
            DamageSource damageSource = new DamageSource(
                    world.getRegistryManager()
                            .getOrThrow(RegistryKeys.DAMAGE_TYPE)
                            .getEntry(DamageTypeRegistry.GLASS_CANNON.getValue()).get()
            );
            entity.damage(world, damageSource, entity.getHealth()-1);
        }
    }
}
