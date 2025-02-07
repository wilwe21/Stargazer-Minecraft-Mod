package com.github.wilwe21.stargazer.mechanics.star;

import com.github.wilwe21.stargazer.item.ModItems;
import net.minecraft.client.MinecraftClient;
import net.minecraft.entity.ItemEntity;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.item.ItemStack;
import net.minecraft.world.LightType;
import net.minecraft.world.World;

import java.util.Random;

import static com.github.wilwe21.stargazer.mechanics.star.FallingStar.spawnStar;

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
                            timer = 20;
                            int starNumb = random.nextInt(5);
                            switch (starNumb) {
                                case 0 -> spawnStar(world, player, new ItemStack(ModItems.YELLOW_STAR, 1), "yellow'");
                                case 1 -> spawnStar(world, player, new ItemStack(ModItems.PURPLE_STAR, 1), "purple");
                                case 2 -> spawnStar(world, player, new ItemStack(ModItems.BLUE_STAR, 1), "blue");
                                case 3 -> spawnStar(world, player, new ItemStack(ModItems.GREEN_STAR, 1), "green'");
                                case 4 -> spawnStar(world, player, new ItemStack(ModItems.RED_STAR, 1), "red");
                                default -> spawnStar(world, player, new ItemStack(ModItems.YELLOW_STAR, 1), "yellow");
                            }
                        }
                    }
                }
            }
        } catch (Exception e) {

        }
    }
}
