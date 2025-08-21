package com.github.wilwe21.stargazer.mechanics.star;

import com.mojang.serialization.Codec;
import com.mojang.serialization.codecs.RecordCodecBuilder;
import net.minecraft.util.StringIdentifiable;
import net.minecraft.util.dynamic.Codecs;

public enum FallingObjectDayState implements StringIdentifiable {
    Day("day"),
    Night("night"),
    Both("both");

    private final String ID;

    public static final Codec<FallingObjectDayState> CODEC = StringIdentifiable.createCodec(() -> FallingObjectDayState.values());

    FallingObjectDayState(String id) {
        ID = id;
    }

    public static FallingObjectDayState newDayState(String id) {
        if (id.equals("day")) {
            return FallingObjectDayState.Day;
        } else if (id.equals("night")) {
            return FallingObjectDayState.Night;
        } else {
            return FallingObjectDayState.Both;
        }
    }

    @Override
    public String asString() {
        return this.ID;
    }

    private String getId() {
        return this.ID;
    }
}
