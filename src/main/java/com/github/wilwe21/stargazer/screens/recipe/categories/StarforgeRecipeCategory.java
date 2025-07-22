package com.github.wilwe21.stargazer.screens.recipe.categories;

import com.mojang.serialization.Codec;
import io.netty.buffer.ByteBuf;
import net.minecraft.network.codec.PacketCodec;
import net.minecraft.network.codec.PacketCodecs;
import net.minecraft.util.StringIdentifiable;
import net.minecraft.util.function.ValueLists;

import java.util.function.IntFunction;

public enum StarforgeRecipeCategory implements StringIdentifiable {
    BUILDING("building", 0),
    REDSTONE("redstone", 1),
    EQUIPMENT("equipment", 2),
    MISC("misc", 3);

    public static final Codec<StarforgeRecipeCategory> CODEC;
    public static final IntFunction<StarforgeRecipeCategory> INDEX_TO_VALUE;
    public static final PacketCodec<ByteBuf, StarforgeRecipeCategory> PACKET_CODEC;
    private final String id;
    private final int index;

    private StarforgeRecipeCategory(String id, int index) {
        this.id = id;
        this.index = index;
    }

    @Override
    public String asString() {
        return this.id;
    }

    private int getIndex() {
        return this.index;
    }

    static {
        CODEC = StringIdentifiable.createCodec(StarforgeRecipeCategory::values);
        INDEX_TO_VALUE = ValueLists.createIndexToValueFunction(StarforgeRecipeCategory::getIndex, StarforgeRecipeCategory.values(), ValueLists.OutOfBoundsHandling.ZERO);
        PACKET_CODEC = PacketCodecs.indexed(INDEX_TO_VALUE, StarforgeRecipeCategory::getIndex);
    }
}
