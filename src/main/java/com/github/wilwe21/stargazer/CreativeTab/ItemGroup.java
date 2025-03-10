package com.github.wilwe21.stargazer.CreativeTab;

import com.github.wilwe21.stargazer.Stargazer;
import com.github.wilwe21.stargazer.block.ModBlock;
import com.github.wilwe21.stargazer.block.register.MoonBlocks;
import com.github.wilwe21.stargazer.item.ModItems;
import net.fabricmc.fabric.api.itemgroup.v1.FabricItemGroup;
import net.fabricmc.fabric.api.itemgroup.v1.ItemGroupEvents;
import net.minecraft.item.ItemStack;
import net.minecraft.registry.Registries;
import net.minecraft.registry.Registry;
import net.minecraft.registry.RegistryKey;
import net.minecraft.text.Text;
import net.minecraft.util.Identifier;

public class ItemGroup {
    public static final RegistryKey<net.minecraft.item.ItemGroup> STAR_GROUP_KEY = RegistryKey.of(Registries.ITEM_GROUP.getKey(), Identifier.of(Stargazer.MOD_ID, "star"));
    public static final net.minecraft.item.ItemGroup STAR_GROUP = FabricItemGroup.builder()
            .icon(() -> new ItemStack(ModItems.YELLOW_STAR))
            .displayName(Text.translatable("itemGroup.Stargazer"))
            .build();

    public static void init() {
        Registry.register(Registries.ITEM_GROUP, STAR_GROUP_KEY, STAR_GROUP);

        ItemGroupEvents.modifyEntriesEvent(STAR_GROUP_KEY).register(itemGroup -> {
            // Blocks
            itemGroup.add(ModBlock.GRAVE);
            itemGroup.add(ModBlock.NEGATIVE_BLOCK);
            itemGroup.add(ModBlock.COSMIC_BLOCK);
            itemGroup.add(ModBlock.STAR_BARRIER_BLOCK);
            itemGroup.add(ModBlock.BORDER_BLOCK);
            // Moon Rocks
            itemGroup.add(MoonBlocks.MOON_ROCK);
            itemGroup.add(MoonBlocks.MOON_ROCK_NYLIUM);
            itemGroup.add(MoonBlocks.BLACK_MOON_ROCK);
            itemGroup.add(MoonBlocks.MOON_ROCK_BRICKS);
            itemGroup.add(MoonBlocks.CRACKED_MOON_ROCK_BRICKS);
            itemGroup.add(MoonBlocks.CHISELED_MOON_ROCK_BRICKS);
            itemGroup.add(MoonBlocks.STAR_FORGE);
            itemGroup.add(MoonBlocks.STAR_STONE);
            // Moon Trees
            itemGroup.add(MoonBlocks.MOON_LOG);
            itemGroup.add(MoonBlocks.STRIPPED_MOON_LOG);
            itemGroup.add(MoonBlocks.MOON_LEAVES);
            itemGroup.add(MoonBlocks.MOON_SAPLING);
            itemGroup.add(MoonBlocks.MOON_PLANKS);
            itemGroup.add(MoonBlocks.PURPLE_MOON_PLANKS);
            itemGroup.add(MoonBlocks.BLUE_MOON_PLANKS);
            itemGroup.add(MoonBlocks.RED_MOON_PLANKS);
            itemGroup.add(MoonBlocks.YELLOW_MOON_PLANKS);
            // Items
            itemGroup.add(ModItems.GRAVICE);
            itemGroup.add(ModItems.STARDUST);
            itemGroup.add(ModItems.PURPLE_STAR);
            itemGroup.add(ModItems.BLUE_STAR);
            itemGroup.add(ModItems.RED_STAR);
            itemGroup.add(ModItems.YELLOW_STAR);
        });
    }
}
