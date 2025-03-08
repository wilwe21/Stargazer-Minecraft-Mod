package com.github.wilwe21.stargazer.item;

import com.github.wilwe21.stargazer.Stargazer;
import net.minecraft.component.type.ConsumableComponent;
import net.minecraft.component.type.FoodComponent;
import net.minecraft.entity.LivingEntity;
import net.minecraft.item.*;
import net.minecraft.item.consume.ConsumeEffect;
import net.minecraft.registry.RegistryKey;
import net.minecraft.registry.RegistryKeys;
import net.minecraft.util.Identifier;
import net.minecraft.world.World;

import java.util.function.Function;

public final class ModItems {
    public static final Item STARDUST = register("stardust", Item::new, new Item.Settings());
    public static final Item YELLOW_STAR = register("yellow_star", Item::new, new Item.Settings());
    public static final Item RED_STAR = register("red_star", Item::new, new Item.Settings());
    public static final Item BLUE_STAR = register("blue_star", Item::new, new Item.Settings());
    public static final Item PURPLE_STAR = register("purple_star", Item::new, new Item.Settings());
    public static final Item GRAVICE = register("gravice", Item::new, new Item.Settings()
            .food(new FoodComponent(6, 6, true),
                    ConsumableComponent.builder()
                            .consumeEffect(new ConsumeEffect() {
                                @Override
                                public Type<? extends ConsumeEffect> getType() {
                                    return null;
                                }

                                @Override
                                public boolean onConsume(World world, ItemStack stack, LivingEntity user) {
                                    user.teleport(0.0d, user.prevY, 0.0d, true);
                                    return true;
                                }
                            })
                            .build()
            )
    );

    public static Item register(String path, Function<Item.Settings, Item> factory, Item.Settings settings) {
        final RegistryKey<Item> registryKey = RegistryKey.of(RegistryKeys.ITEM, Identifier.of(Stargazer.MOD_ID, path));
        return Items.register(registryKey, factory, settings);
    }

    public static void init() {}
}