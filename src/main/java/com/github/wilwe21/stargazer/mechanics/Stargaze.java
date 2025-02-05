package com.github.wilwe21.stargazer.mechanics;

import com.github.wilwe21.stargazer.Stargazer;
import net.minecraft.client.MinecraftClient;
import net.minecraft.entity.player.PlayerEntity;

public class Stargaze {
    public static void tick(MinecraftClient client) {
        try {
            if (!(client.getServer().getOverworld().isDay())) {
                PlayerEntity player = client.player;
                if (player.getPitch() < -60.0) {
                    Stargazer.LOGGER.info("night");
                }
            }
        } catch (Exception e) {

        }
    }
}
