package com.github.wilwe21.gsad;

import net.minecraft.entity.attribute.ClampedEntityAttribute;
import net.minecraft.entity.attribute.EntityAttribute;
import net.minecraft.registry.Registries;
import net.minecraft.registry.Registry;
import net.minecraft.registry.entry.RegistryEntry;
import net.minecraft.util.Identifier;

public class GsadAttributes {
    public static final RegistryEntry<EntityAttribute> DASH_LEVEL = registerCustom(Gsad.MOD_ID,
            "dash_level", new ClampedEntityAttribute("attribute.name.gsad.dash_level", 0.0, 0.0, 2.0).setTracked(true)
    );

    private static RegistryEntry<EntityAttribute> registerCustom(String id,String name, EntityAttribute attribute) {
        return Registry.registerReference(Registries.ATTRIBUTE, Identifier.of(id, name), attribute);
    }
    public static void init() {}
}