package com.github.wilwe21.stargazer.mechanics;

import com.github.wilwe21.stargazer.Stargazer;
import com.github.wilwe21.stargazer.block.ModBlock;
import com.google.common.collect.ImmutableSet;
import net.minecraft.block.Block;
import net.minecraft.block.BlockState;
import net.minecraft.block.Blocks;
import net.minecraft.registry.Registries;
import net.minecraft.registry.Registry;
import net.minecraft.registry.RegistryKey;
import net.minecraft.registry.RegistryKeys;
import net.minecraft.util.Identifier;
import net.minecraft.world.poi.PointOfInterestType;

import java.util.Set;

public class PointOfIntrests {
    public static final RegistryKey<PointOfInterestType> COPPER_TELEPORTER = of("copper_teleporter", getStatesOfBlock(ModBlock.COPPER_TELEPORTER), 0, 1);

    private static RegistryKey<PointOfInterestType> of(String id, Set<BlockState> states, int ticketCount, int searchDistance) {
        Identifier identifier = Identifier.of(Stargazer.MOD_ID, id);
        RegistryKey<PointOfInterestType> key = RegistryKey.of(RegistryKeys.POINT_OF_INTEREST_TYPE, Identifier.of(Stargazer.MOD_ID, id));
        PointOfInterestType type = new PointOfInterestType(states, ticketCount, searchDistance);
        Registry.register(Registries.POINT_OF_INTEREST_TYPE, identifier, type);
        return key;
    }

    private static Set<BlockState> getStatesOfBlock(Block block) {
        return ImmutableSet.copyOf(block.getStateManager().getStates());
    }

    public static void init() {}
}
