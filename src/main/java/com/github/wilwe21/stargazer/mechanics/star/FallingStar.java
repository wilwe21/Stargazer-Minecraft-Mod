package com.github.wilwe21.stargazer.mechanics.star;

import com.github.wilwe21.stargazer.Stargazer;
import com.github.wilwe21.stargazer.particle.Particles;
import net.minecraft.entity.ItemEntity;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.item.ItemStack;
import net.minecraft.particle.SimpleParticleType;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.World;

import java.util.Random;

public class FallingStar {
    private final static int range = 12;
    private final static float velocity = 0.06F;
    private final static int amount = 200;
    private final static Random random = new Random();

    public static int airEnd(World world, BlockPos pos) {
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
    public static void spawnParticles(World world, SimpleParticleType particle, int X, int Y, int Z) {
        for (int i = 1; i <= amount; i++) {
            world.addParticle(particle, true, true, X + 0.5F, Y + 200+ 0.5F, Z + 0.5F, 0.0, -amount/4.0F, 0.0);
        }
        for (int i = 1; i <= 5; i++) {
            world.addParticle(particle, true, true, X + 0.5F, Y + 0.5F, Z + 0.5F, -velocity + random.nextFloat(velocity*2), -velocity + random.nextFloat(velocity*2), -velocity + random.nextFloat(velocity *2));
        }
    }
    public static void spawnStar(World world, World world2, PlayerEntity player, ItemStack star, String name) {
        int X = (int) player.getX() - range + random.nextInt(range * 2);
        int Y = (int) player.getY();
        int Z = (int) player.getZ() - range + random.nextInt(range * 2);
        Y = airEnd(world, new BlockPos(X, Y, Z));
        world.spawnEntity(new ItemEntity(world, X+0.5, Y+0.5, Z+0.5, star));
        switch (name) {
            case "yellow" -> spawnParticles(world2, (SimpleParticleType) Particles.YELLOW_STAR, X, Y, Z);
            case "red" -> spawnParticles(world2, (SimpleParticleType) Particles.RED_STAR, X, Y, Z);
            case "green" -> spawnParticles(world2, (SimpleParticleType) Particles.GREEN_STAR, X, Y, Z);
            case "blue" -> spawnParticles(world2, (SimpleParticleType) Particles.BLUE_STAR, X, Y, Z);
            case "purple" -> spawnParticles(world2, (SimpleParticleType) Particles.PURPLE_STAR, X, Y, Z);
        }
    }
}
