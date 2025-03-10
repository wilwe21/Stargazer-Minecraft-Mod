package com.github.wilwe21.stargazer.worldgen.dimensions;

import com.github.wilwe21.stargazer.Stargazer;
import net.minecraft.registry.Registerable;
import net.minecraft.registry.RegistryKey;
import net.minecraft.registry.RegistryKeys;
import net.minecraft.registry.tag.BlockTags;
import net.minecraft.util.Identifier;
import net.minecraft.util.math.intprovider.UniformIntProvider;
import net.minecraft.world.World;
import net.minecraft.world.dimension.DimensionType;

import java.util.OptionalLong;

public class Dimensions {
    public static final RegistryKey<DimensionType> COSMIC = of("cosmic");
    public static final Identifier COSMIC_ID = Identifier.of(Stargazer.MOD_ID,"cosmic");
    public static final RegistryKey<World> REG_COSMIC_WORLD = RegistryKey.of(RegistryKeys.WORLD, Identifier.of(Stargazer.MOD_ID,"cosmic"));

    private static RegistryKey<DimensionType> of(String id) {
        return RegistryKey.of(RegistryKeys.DIMENSION_TYPE, Identifier.of(Stargazer.MOD_ID,id));
    }
    public static void bootstrap(Registerable<DimensionType> context) {
        context.register(
                COSMIC,
                new DimensionType(
                        OptionalLong.empty(),
                        true,
                        false,
                        false,
                        false,
                        100.0,
                        false,
                        false,
                        -64,
                        384,
                        384,
                        BlockTags.INFINIBURN_END,
                        COSMIC_ID,
                        0.0F,
                        new DimensionType.MonsterSettings(false, true, UniformIntProvider.create(0, 7), 0)
                )
        );
    }
}
