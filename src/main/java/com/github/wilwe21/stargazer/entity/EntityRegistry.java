package com.github.wilwe21.stargazer.entity;

import com.github.wilwe21.stargazer.Stargazer;
import net.fabricmc.fabric.api.object.builder.v1.entity.FabricDefaultAttributeRegistry;
import net.minecraft.entity.EntityType;
import net.minecraft.entity.SpawnGroup;
import net.minecraft.registry.Registries;
import net.minecraft.registry.Registry;
import net.minecraft.registry.RegistryKey;
import net.minecraft.registry.RegistryKeys;
import net.minecraft.util.Identifier;

public class EntityRegistry {

    public static final Identifier GHOST_ID = Identifier.of(Stargazer.MOD_ID, "ghost");
    public static final RegistryKey<EntityType<?>> GHOST_KEY =
            RegistryKey.of(RegistryKeys.ENTITY_TYPE, GHOST_ID);

    public static final EntityType<Ghost> GHOST_ENTITY = Registry.register(
            Registries.ENTITY_TYPE,
            GHOST_ID,
            EntityType.Builder.create(Ghost::new, SpawnGroup.CREATURE)
                    .dimensions(0.75f, 0.75f) // Adjust width and height as needed
                    .makeFireImmune()
                    .build(GHOST_KEY) // The build method might just take an empty string in newer Fabric versions, or no argument
    );

    public static void init() {
        FabricDefaultAttributeRegistry.register(GHOST_ENTITY, Ghost.createFlyingCreatureAttributes());
    }
}
