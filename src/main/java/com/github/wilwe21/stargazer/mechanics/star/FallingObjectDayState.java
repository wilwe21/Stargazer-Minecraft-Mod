package com.github.wilwe21.stargazer.mechanics.star;

import net.minecraft.util.StringIdentifiable;

public enum FallingObjectDayState implements StringIdentifiable {
    Day("day"),
    Night("night"),
    Both("both");

    private final String ID;

    FallingObjectDayState(String id) {
        ID = id;
    }

    @Override
    public String asString() {
        return this.ID;
    }
}
