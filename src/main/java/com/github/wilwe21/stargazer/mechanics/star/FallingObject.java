package com.github.wilwe21.stargazer.mechanics.star;

import net.minecraft.particle.SimpleParticleType;
import net.minecraft.world.World;

import java.util.Random;

public class FallingObject {
    private final static Random random = new Random();
    public final int amount;
    public final float velocity;
    public final SimpleParticleType particle;

    public FallingObject(SimpleParticleType particleType, int particleAmount, float particleVelocity) {
        amount = particleAmount;
        velocity = particleVelocity;
        particle = particleType;
    }

    public void spawnParticles(World world, int X, int Y, int Z) {
        for (int i = 1; i <= amount; i++) {
            world.addParticle(particle, true, true, X + 0.5F, Y + 200+ 0.5F, Z + 0.5F, 0.0, -amount/4.0F, 0.0);
        }
        for (int i = 1; i <= 5; i++) {
            world.addParticle(particle, true, true, X + 0.5F, Y + 0.5F, Z + 0.5F, -velocity + random.nextFloat(velocity*2), -velocity + random.nextFloat(velocity*2), -velocity + random.nextFloat(velocity *2));
        }
    }}
