package com.github.wilwe21.gsad.CreativeTab;

import com.github.wilwe21.gsad.Gsad;
import com.github.wilwe21.gsad.block.ModBlock;
import com.github.wilwe21.gsad.item.ModItems;
import net.fabricmc.fabric.api.itemgroup.v1.FabricItemGroup;
import net.fabricmc.fabric.api.itemgroup.v1.ItemGroupEvents;
import net.minecraft.item.ItemStack;
import net.minecraft.registry.Registries;
import net.minecraft.registry.Registry;
import net.minecraft.registry.RegistryKey;
import net.minecraft.text.Text;
import net.minecraft.util.Identifier;

public class ItemGroup {
    public static final RegistryKey<net.minecraft.item.ItemGroup> GSAD_GROUP_KEY = RegistryKey.of(Registries.ITEM_GROUP.getKey(), Identifier.of(Gsad.MOD_ID, "gsad"));
    public static final net.minecraft.item.ItemGroup GSAD_GROUP = FabricItemGroup.builder()
            .icon(() -> new ItemStack(ModBlock.GRAVE))
            .displayName(Text.translatable("itemGroup.GSAD"))
            .build();

    public static final RegistryKey<net.minecraft.item.ItemGroup> CELESTE_GROUP_KEY = RegistryKey.of(Registries.ITEM_GROUP.getKey(), Identifier.of(Gsad.MOD_ID, "celeste"));
    public static final net.minecraft.item.ItemGroup CELESTE_GROUP = FabricItemGroup.builder()
            .icon(() -> new ItemStack(ModBlock.STRAWBERRY))
            .displayName(Text.translatable("itemGroup.celeste"))
            .build();

    public static final RegistryKey<net.minecraft.item.ItemGroup> SONIC_GROUP_KEY = RegistryKey.of(Registries.ITEM_GROUP.getKey(), Identifier.of(Gsad.MOD_ID, "sonic"));
    public static final net.minecraft.item.ItemGroup SONIC_GROUP = FabricItemGroup.builder()
            .icon(() -> new ItemStack(ModBlock.RING))
            .displayName(Text.translatable("itemGroup.sonic"))
            .build();

    public static final RegistryKey<net.minecraft.item.ItemGroup> MARIO_GROUP_KEY = RegistryKey.of(Registries.ITEM_GROUP.getKey(), Identifier.of(Gsad.MOD_ID, "mario"));
    public static final net.minecraft.item.ItemGroup MARIO_GROUP = FabricItemGroup.builder()
            .icon(() -> new ItemStack(ModBlock.LUCKY_BLOCK))
            .displayName(Text.translatable("itemGroup.mario"))
            .build();
    public static void init() {
        Registry.register(Registries.ITEM_GROUP, GSAD_GROUP_KEY, GSAD_GROUP);
        Registry.register(Registries.ITEM_GROUP, CELESTE_GROUP_KEY, CELESTE_GROUP);
        Registry.register(Registries.ITEM_GROUP, SONIC_GROUP_KEY, SONIC_GROUP);
        Registry.register(Registries.ITEM_GROUP, MARIO_GROUP_KEY, MARIO_GROUP);

        ItemGroupEvents.modifyEntriesEvent(GSAD_GROUP_KEY).register(itemGroup -> {
            itemGroup.add(ModBlock.GRAVE);
        });

        ItemGroupEvents.modifyEntriesEvent(CELESTE_GROUP_KEY).register(itemGroup -> {
            itemGroup.add(ModItems.STARDUST);
            itemGroup.add(ModBlock.STRAWBERRY);
            itemGroup.add(ModBlock.DREAM_BLOCK);
            itemGroup.add(ModBlock.TV_BLOCK);
            itemGroup.add(ModBlock.DUST_BUNNY);
            itemGroup.add(ModBlock.SPINNER);
            itemGroup.add(ModBlock.SPRING);
            itemGroup.add(ModBlock.SPIKES);
            itemGroup.add(ModBlock.SCAFFOLDING);
            itemGroup.add(ModBlock.SUMMIT);
        });

        ItemGroupEvents.modifyEntriesEvent(SONIC_GROUP_KEY).register(itemGroup -> {
            itemGroup.add(ModBlock.RING);
            itemGroup.add(ModBlock.Sonic_DIRT);
            itemGroup.add(ModBlock.Sonic_GRASS);
        });

        ItemGroupEvents.modifyEntriesEvent(MARIO_GROUP_KEY).register(itemGroup -> {
            itemGroup.add(ModBlock.LUCKY_BLOCK);
            itemGroup.add(ModBlock.EMPTY_BLOCK);
            itemGroup.add(ModBlock.GROUND_BLOCK);
            itemGroup.add(ModBlock.BRICK);
        });
    }
}
