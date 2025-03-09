package com.github.wilwe21.stargazer.item;

import com.github.wilwe21.stargazer.Stargazer;
import net.minecraft.item.Item;
import net.minecraft.registry.RegistryKeys;
import net.minecraft.registry.tag.TagKey;
import net.minecraft.util.Identifier;

import javax.swing.text.html.HTML;

public class ItemTags {
    public static final TagKey<Item> STARDUST = register("stardust");
    public static final TagKey<Item> ICECREAM = register("icecream");
    public static final TagKey<Item> STAR = register("star");
    public static final TagKey<Item> MOON_LOG = register("moonlog");

    private static TagKey<Item> register(String name) {
        return TagKey.of(RegistryKeys.ITEM, Identifier.of(Stargazer.MOD_ID, name));
    }
    public static void init() {}
}
