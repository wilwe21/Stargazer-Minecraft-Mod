package com.github.wilwe21.gsad.entity;


import com.github.wilwe21.gsad.Gsad;
import net.fabricmc.fabric.api.object.builder.v1.entity.FabricDefaultAttributeRegistry;
import net.minecraft.entity.Entity;
import net.minecraft.entity.EntityType;
import net.minecraft.entity.SpawnGroup;
import net.minecraft.registry.Registries;
import net.minecraft.registry.Registry;
import net.minecraft.registry.RegistryKey;
import net.minecraft.registry.RegistryKeys;
import net.minecraft.util.Identifier;

public class ModEntity {
    public static final EntityType<Test> TEST = register(
            "test",
            EntityType.Builder.create(Test::new, SpawnGroup.MONSTER)
                    .makeFireImmune()
                    .dimensions(0.6F, 1.95F)
                    .eyeHeight(1.79F)
                    .passengerAttachments(2.0F)
                    .vehicleAttachment(-0.7F)
                    .maxTrackingRange(8)
    );

    private static <T extends Entity> EntityType<T> register(String id, EntityType.Builder<T> type) {
        return register(keyOf(id), type);
    }

    private static <T extends Entity> EntityType<T> register(RegistryKey<EntityType<?>> key, EntityType.Builder<T> type) {
        return Registry.register(Registries.ENTITY_TYPE, key, type.build(key));
    }

    private static RegistryKey<EntityType<?>> keyOf(String id) {
        return RegistryKey.of(RegistryKeys.ENTITY_TYPE, Identifier.of(Gsad.MOD_ID, id));
    }
    public static void init() {
        FabricDefaultAttributeRegistry.register(TEST, Test.createMobAttributes());
    }
}
