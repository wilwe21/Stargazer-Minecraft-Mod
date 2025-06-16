package com.github.wilwe21.stargazer.mechanics.features;

import com.mojang.serialization.Codec;
import com.mojang.serialization.codecs.RecordCodecBuilder;
import net.minecraft.util.dynamic.Codecs;
import net.minecraft.world.gen.feature.FeatureConfig;

import java.util.List;

public class TreeConfig implements FeatureConfig {
    public final List<String> NAMES;
    public final Boolean BLACKLIST;
    public static final Codec<TreeConfig> CODEC = RecordCodecBuilder.create(instance -> instance.group(
            Codec.BOOL.fieldOf("blacklist").forGetter(config -> config.BLACKLIST),
            Codecs.NON_EMPTY_STRING.listOf().fieldOf("names").forGetter(config -> config.NAMES)
    ).apply(instance, TreeConfig::new));

    public TreeConfig(boolean blacklist, List<String> NAMES) {
        this.BLACKLIST = blacklist;
        this.NAMES = NAMES;
    }
}
