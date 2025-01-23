package com.github.wilwe21.gsad.item;

import com.github.wilwe21.gsad.Gsad;
import net.minecraft.item.Item;
import net.minecraft.registry.RegistryKeys;
import net.minecraft.registry.tag.TagKey;
import net.minecraft.util.Identifier;

public class ItemTags {
    public static final TagKey<Item> STARDUST = register(Gsad.MOD_ID, "stardust");
    public static final TagKey<Item> GRAVICE = register(Gsad.MOD_ID, "gravice");

    private static TagKey<Item> register(String id, String name) {
        return TagKey.of(RegistryKeys.ITEM, Identifier.of(id, name));
    }
    public static void init() {}
}
