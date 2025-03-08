package com.github.wilwe21.stargazer.mechanics.star;

import com.github.wilwe21.stargazer.block.register.MoonBlocks;
import com.github.wilwe21.stargazer.item.ModItems;
import com.github.wilwe21.stargazer.particle.Particles;
import net.minecraft.item.Item;
import net.minecraft.particle.ParticleType;
import net.minecraft.particle.ParticleTypes;
import net.minecraft.particle.SimpleParticleType;

import java.util.ArrayList;
import java.util.List;

public class FallingObjectsRegister {
    public static List<FallingObject> list = new ArrayList<>();
    public static List<FallingObject> chanceList = new ArrayList<>();
    public static final FallingObject YELLOW_STAR = register(40, ModItems.YELLOW_STAR, Particles.YELLOW_STAR, 200, 0.06F);
    public static final FallingObject RED_STAR = register(30, ModItems.RED_STAR, Particles.RED_STAR, 200, 0.06F);
    public static final FallingObject BLUE_STAR = register(10, ModItems.BLUE_STAR, Particles.BLUE_STAR, 200, 0.06F);
    public static final FallingObject PURPLE_STAR = register(5, ModItems.PURPLE_STAR, Particles.PURPLE_STAR, 200, 0.06F);
    public static final FallingObject MOON_STONE = register(5, MoonBlocks.MOON_ROCK.asItem(), ParticleTypes.CAMPFIRE_COSY_SMOKE, 200, 0.06F);

    public static FallingObject register(Item item, ParticleType<SimpleParticleType> fallParticleType, ParticleType<SimpleParticleType> hitParticleType, int particleAmount, float particleVelocity) {
        FallingObject fo = new FallingObject(item, (SimpleParticleType) fallParticleType, (SimpleParticleType) hitParticleType, particleAmount, particleVelocity);
        list.add(fo);
        chanceList.add(fo);
        return fo;
    }
    public static FallingObject register(Item item, ParticleType<SimpleParticleType> particleType, int particleAmount, float particleVelocity) {
        FallingObject fo = new FallingObject(item, (SimpleParticleType) particleType, (SimpleParticleType) particleType, particleAmount, particleVelocity);
        list.add(fo);
        chanceList.add(fo);
        return fo;
    }
    public static FallingObject register(int chance, Item item, ParticleType<SimpleParticleType> fallParticleType, ParticleType<SimpleParticleType> hitParticleType, int particleAmount, float particleVelocity) {
        FallingObject fo = new FallingObject(item, (SimpleParticleType) fallParticleType, (SimpleParticleType) hitParticleType, particleAmount, particleVelocity);
        list.add(fo);
        for (int i = 0; i < chance; i++) {
            chanceList.add(fo);
        }
        return fo;
    }
    public static FallingObject register(int chance, Item item, ParticleType<SimpleParticleType> particleType, int particleAmount, float particleVelocity) {
        FallingObject fo = new FallingObject(item, (SimpleParticleType) particleType, (SimpleParticleType) particleType, particleAmount, particleVelocity);
        list.add(fo);
        for (int i = 0; i < chance; i++) {
            chanceList.add(fo);
        }
        return fo;
    }
}
