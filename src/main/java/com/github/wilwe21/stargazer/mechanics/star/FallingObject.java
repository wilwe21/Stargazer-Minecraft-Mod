package com.github.wilwe21.stargazer.mechanics.star;

import net.minecraft.client.MinecraftClient;
import net.minecraft.entity.ItemEntity;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.particle.SimpleParticleType;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.World;

import java.util.Random;

import static com.github.wilwe21.stargazer.mechanics.star.Stargaze.range;

public class FallingObject {
    private final static Random random = new Random();
    public final Item item;
    public final int amount;
    public final float velocity;
    public final SimpleParticleType particle;

    public FallingObject(Item itemConstruct, SimpleParticleType particleType, int particleAmount, float particleVelocity) {
        item = itemConstruct;
        amount = particleAmount;
        velocity = particleVelocity;
        particle = particleType;
    }

    public void hitParticles(World world, int X, int Y, int Z) {
        for (int i = 1; i <= 5; i++) {
            world.addParticle(particle, true, true, X + 0.5F, Y + 0.5F, Z + 0.5F, -velocity + random.nextFloat(velocity*2), -velocity + random.nextFloat(velocity*2), -velocity + random.nextFloat(velocity *2));
        }
    }

    public void fallParticles(World world, int X, int Y, int Z) {
        for (int i = 1; i <= amount; i++) {
            world.addParticle(particle, true, true, X + 0.5F, Y + 200+ 0.5F, Z + 0.5F, 0.0, -amount/4.0F, 0.0);
        }
    }
    public void spawn(MinecraftClient client, int X, int Y, int Z) {
        fallParticles(client.world, X, Y, Z);
        hitParticles(client.world, X, Y, Z);
        client.getServer().getOverworld().spawnEntity(new ItemEntity(client.getServer().getOverworld(), X+0.5, Y+0.5, Z+0.5, new ItemStack(item)));
    }
    public int airEnd(World world, BlockPos pos) {
        if (world.isAir(pos)) {
            if (!(world.isAir(pos.down(1)))) {
                return pos.getY();
            } else {
                return airEnd(world, pos.down(1));
            }
        } else {
            return airEnd(world, pos.up(1));
        }
    }
    public void spawn(MinecraftClient client, PlayerEntity player) {
        int X = (int) player.getX() - range + random.nextInt(range * 2);
        int Y = (int) player.getY();
        int Z = (int) player.getZ() - range + random.nextInt(range * 2);
        Y = airEnd(client.world, new BlockPos(X, Y, Z));
        spawn(client, X, Y, Z);
    }
}