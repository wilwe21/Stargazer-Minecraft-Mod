package com.github.wilwe21.stargazer.mechanics.star;

import com.github.wilwe21.stargazer.particle.Particles;
import net.minecraft.entity.ItemEntity;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.item.ItemStack;
import net.minecraft.particle.SimpleParticleType;
import net.minecraft.world.World;

public class FallingStar {
    public static void spawnStar(World world, PlayerEntity player, ItemStack star, String name) {
        world.spawnEntity(new ItemEntity(world, player.getX(), player.getY()+30, player.getZ(), star));
        switch (name) {
            case "yellow" -> world.addParticle((SimpleParticleType) Particles.YELLOW_STAR, player.getX(), player.getY()+30, player.getZ(), 0.0, -1.3, 0.0);
            case "red" -> world.addParticle((SimpleParticleType) Particles.RED_STAR, player.getX(), player.getY()+30, player.getZ(), 0.0, -1.3, 0.0);
            case "green" -> world.addParticle((SimpleParticleType) Particles.GREEN_STAR, player.getX(), player.getY()+30, player.getZ(), 0.0, -1.3, 0.0);
            case "blue" -> world.addParticle((SimpleParticleType) Particles.BLUE_STAR, player.getX(), player.getY()+30, player.getZ(), 0.0, -1.3, 0.0);
            case "purple" -> world.addParticle((SimpleParticleType) Particles.PURPLE_STAR, player.getX(), player.getY()+30, player.getZ(), 0.0, -1.3, 0.0);
        }
    }
}
