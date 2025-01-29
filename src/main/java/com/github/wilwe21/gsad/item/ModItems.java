package com.github.wilwe21.gsad.item;

import com.github.wilwe21.gsad.Gsad;
import com.github.wilwe21.gsad.block.custom.celeste.Spring;
import net.minecraft.component.type.ConsumableComponent;
import net.minecraft.component.type.FoodComponent;
import net.minecraft.entity.LivingEntity;
import net.minecraft.entity.damage.DamageSource;
import net.minecraft.entity.damage.DamageSources;
import net.minecraft.entity.effect.StatusEffectInstance;
import net.minecraft.item.*;
import net.minecraft.item.consume.ConsumeEffect;
import net.minecraft.item.consume.UseAction;
import net.minecraft.registry.RegistryKey;
import net.minecraft.registry.RegistryKeys;
import net.minecraft.server.world.ServerWorld;
import net.minecraft.util.Identifier;
import net.minecraft.util.math.Vec3d;
import net.minecraft.world.World;

import java.util.function.Function;

public final class ModItems {
    public static final Item STARDUST = register("stardust", Item::new, new Item.Settings());
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
        final RegistryKey<Item> registryKey = RegistryKey.of(RegistryKeys.ITEM, Identifier.of(Gsad.MOD_ID, path));
        return Items.register(registryKey, factory, settings);
    }

    public static void init() {}
}