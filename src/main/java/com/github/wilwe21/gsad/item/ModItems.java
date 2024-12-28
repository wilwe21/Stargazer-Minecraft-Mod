package com.github.wilwe21.gsad.item;

import com.github.wilwe21.gsad.Gsad;
import net.minecraft.item.*;
import net.minecraft.registry.RegistryKey;
import net.minecraft.registry.RegistryKeys;
import net.minecraft.util.Identifier;

import java.util.function.Function;

public final class ModItems {
    public static final Item STARDUST = register("stardust", Item::new, new Item.Settings());

    public static Item register(String path, Function<Item.Settings, Item> factory, Item.Settings settings) {
        final RegistryKey<Item> registryKey = RegistryKey.of(RegistryKeys.ITEM, Identifier.of(Gsad.MOD_ID, path));
        return Items.register(registryKey, factory, settings);
    }

    public static void init() {}
}