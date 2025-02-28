package com.github.wilwe21.stargazer.mechanics.star;

import net.minecraft.client.MinecraftClient;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.world.LightType;
import net.minecraft.world.World;

import java.util.Random;

public class Stargaze {
    private static int timer = 0;
    public static int range = 12;
    public static void tick(MinecraftClient client) {
        if (!(client.getServer().getOverworld().isDay())) {
            PlayerEntity player = client.player;
            World world = client.getServer().getOverworld();
            if (timer != 0 ) {
                timer -= 1;
                return;
            }
            if (world.getLightLevel(LightType.SKY, player.getBlockPos()) == 15) {
                if (player.getPitch() < -60.0 && player.isUsingSpyglass()) {
                    Random random = new Random();
                    int randomNumb = random.nextInt(100);
                    if (randomNumb < 10) {
                        timer = 20;
                        FallingObject star = FallingObjectsRegister.list.get(random.nextInt(FallingObjectsRegister.list.size()));
                        star.spawn(client, player);
                    }
                }
            }
        }
    }
}
