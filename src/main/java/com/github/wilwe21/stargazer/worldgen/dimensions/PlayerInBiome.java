package com.github.wilwe21.stargazer.worldgen.dimensions;

import com.github.wilwe21.stargazer.block.ModBlock;
import com.github.wilwe21.stargazer.worldgen.BiomeTags;
import net.minecraft.client.MinecraftClient;
import net.minecraft.entity.LivingEntity;
import net.minecraft.registry.tag.TagKey;
import net.minecraft.world.World;
import static com.github.wilwe21.stargazer.mechanics.PlayerInside.applyEffect;
import static com.github.wilwe21.stargazer.mechanics.PlayerInside.removeEffect;

public class PlayerInBiome {
    public static void tick(MinecraftClient client) {
        LivingEntity player = client.player;
        World world = player.getEntityWorld();
        if (world.getBiome(player.getBlockPos()).isIn(BiomeTags.MOON)) {
            applyEffect(player);
        } else {
            if (!world.getBlockState(player.getBlockPos()).getBlock().equals(ModBlock.COSMIC_BLOCK)) {
                removeEffect(player);
            }
        }
    }
}
