package com.github.wilwe21.stargazer.mechanics.trees.moon;

import com.mojang.serialization.Codec;
import com.mojang.serialization.codecs.RecordCodecBuilder;
import net.minecraft.world.gen.feature.FeatureConfig;

public record MoonTreesConfig(int height) implements FeatureConfig {
    public static final Codec<MoonTreesConfig> CODEC = RecordCodecBuilder.create(instance -> instance.group(
            Codec.INT.fieldOf("height").forGetter(MoonTreesConfig::height)
    ).apply(instance, MoonTreesConfig::new));
}
