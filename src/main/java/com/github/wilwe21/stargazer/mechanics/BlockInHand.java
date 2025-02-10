package com.github.wilwe21.stargazer.mechanics;

import com.github.wilwe21.stargazer.block.ModBlock;
import com.github.wilwe21.stargazer.block.cosmic.CosmicBlock;
import com.github.wilwe21.stargazer.block.negative.NegativeBlock;
import net.minecraft.client.MinecraftClient;
import net.minecraft.item.ItemStack;

public class BlockInHand {
    public static void tick(MinecraftClient client) {
        ItemStack mh = client.player.getMainHandStack();
        ItemStack oh = client.player.getOffHandStack();
        if (mh.isOf(ModBlock.NEGATIVE_BLOCK.asItem()) || oh.isOf(ModBlock.NEGATIVE_BLOCK.asItem())) {
            NegativeBlock.SOLID = true;
        } else {
            NegativeBlock.SOLID = false;
        }
        if (mh.isOf(ModBlock.COSMIC_BLOCK.asItem()) || oh.isOf(ModBlock.COSMIC_BLOCK.asItem())) {
            CosmicBlock.SOLID = true;
        } else {
            CosmicBlock.SOLID = false;
        }
    }
}
