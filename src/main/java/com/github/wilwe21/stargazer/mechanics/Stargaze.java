package com.github.wilwe21.stargazer.mechanics;

import com.github.wilwe21.stargazer.Stargazer;
import com.github.wilwe21.stargazer.item.ModItems;
import net.minecraft.client.MinecraftClient;
import net.minecraft.entity.ItemEntity;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.item.ItemStack;
import net.minecraft.world.LightType;
import net.minecraft.world.World;

import java.util.Random;

public class Stargaze {
    private static int timer = 0;
    public static void tick(MinecraftClient client) {
        try {
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
                            Stargazer.LOGGER.info("You feel lucky today");
                            timer = 20;
                            int starNumb = random.nextInt(5);
                            ItemStack star = null;
                            switch (starNumb) {
                                case 0 -> star = new ItemStack(ModItems.YELLOW_STAR, 1);
                                case 1 -> star = new ItemStack(ModItems.PURPLE_STAR, 1);
                                case 2 -> star = new ItemStack(ModItems.BLUE_STAR, 1);
                                case 3 -> star = new ItemStack(ModItems.GREEN_STAR, 1);
                                case 4 -> star = new ItemStack(ModItems.RED_STAR, 1);
                                default -> star = new ItemStack(ModItems.YELLOW_STAR, 1);
                            }
                            world.spawnEntity(new ItemEntity(world, player.getX(), player.getY(), player.getZ(), star));
                        }
                    }
                }
            }
        } catch (Exception e) {

        }
    }
}
