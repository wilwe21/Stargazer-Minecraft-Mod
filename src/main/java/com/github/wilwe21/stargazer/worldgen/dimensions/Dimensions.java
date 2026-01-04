package com.github.wilwe21.stargazer.worldgen.dimensions;

import com.github.wilwe21.stargazer.Stargazer;
import net.minecraft.registry.Registerable;
import net.minecraft.registry.Registries;
import net.minecraft.registry.RegistryKey;
import net.minecraft.registry.RegistryKeys;
import net.minecraft.registry.tag.BlockTags;
import net.minecraft.util.Identifier;
import net.minecraft.util.math.intprovider.UniformIntProvider;
import net.minecraft.world.World;
import net.minecraft.world.dimension.DimensionType;

import java.util.OptionalLong;

public class Dimensions {
    public static final RegistryKey<World> REG_COSMIC_WORLD = RegistryKey.of(RegistryKeys.WORLD, Identifier.of(Stargazer.MOD_ID,"cosmic"));
}
