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
    public static final TagKey<Item> MOON_LOG = register("moon_log");
    public static final TagKey<Item> STAR_LOG = register("star_log");
//    public static final TagKey<Item> BONSAI_LOG = register("bonsai_log");
    public static final TagKey<Item> PURPLE_STAR = register("purple_star");
    public static final TagKey<Item> YELLOW_STAR = register("yellow_star");
    public static final TagKey<Item> RED_STAR = register("red_star");
    public static final TagKey<Item> BLUE_STAR = register("blue_star");
    public static final TagKey<Item> STAR_FLOWER = register("star_flower");

    private static TagKey<Item> register(String name) {
        return TagKey.of(RegistryKeys.ITEM, Identifier.of(Stargazer.MOD_ID, name));
    }
    public static void init() {}
}
