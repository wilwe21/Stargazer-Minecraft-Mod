package com.github.wilwe21.stargazer.block.clases.moon.starforge;

import com.mojang.serialization.MapCodec;
import net.minecraft.block.AbstractBlock;
import net.minecraft.block.Block;

public class Starforge extends Block {
    public static final MapCodec<Starforge> CODEC = createCodec(Starforge::new);

    @Override
    public MapCodec<? extends Starforge> getCodec() {
        return CODEC;
    }

    public Starforge(AbstractBlock.Settings settings) {
        super(settings);
    }
}
