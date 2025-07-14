package com.github.wilwe21.stargazer.block.clases.teleporter;

import net.minecraft.util.StringIdentifiable;

public enum CopperTeleporterState implements StringIdentifiable {
    middle("middle"),
    north("north"),
    south("south"),
    west("west"),
    east("east"),
    north_east("north_east"),
    north_west("north_west"),
    south_east("south_east"),
    south_west("south_west");

    private final String ID;

    CopperTeleporterState(String id) {
        ID = id;
    }

    @Override
    public String asString() {
        return this.ID;
    }
}
