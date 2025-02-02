package com.github.wilwe21.stargazer.CreativeTab;

import com.github.wilwe21.stargazer.Stargazer;
import com.github.wilwe21.stargazer.block.ModBlock;
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
            .icon(() -> new ItemStack(ModBlock.GRAVE))
            .displayName(Text.translatable("itemGroup.Stargazer"))
            .build();

    public static void init() {
        Registry.register(Registries.ITEM_GROUP, STAR_GROUP_KEY, STAR_GROUP);

        ItemGroupEvents.modifyEntriesEvent(STAR_GROUP_KEY).register(itemGroup -> {
            itemGroup.add(ModBlock.GRAVE);
            itemGroup.add(ModItems.GRAVICE);
            itemGroup.add(ModBlock.NEGATIVE_BLOCK);
            itemGroup.add(ModBlock.COSMIC_BLOCK);
            itemGroup.add(ModBlock.BORDER_BLOCK);
        });
    }
}
