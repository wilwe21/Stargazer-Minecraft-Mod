package com.github.wilwe21.stargazer.screenHandlers;

import com.github.wilwe21.stargazer.Stargazer;
import net.minecraft.client.gui.screen.ingame.HandledScreen;
import net.minecraft.registry.Registries;
import net.minecraft.registry.Registry;
import net.minecraft.resource.featuretoggle.FeatureFlags;
import net.minecraft.screen.ScreenHandler;
import net.minecraft.util.Identifier;

public class ScreenHandlerType <T extends ScreenHandler> {
    public static final net.minecraft.screen.ScreenHandlerType<StarforgeScreenHandler> STARFORGE = register("starforge", StarforgeScreenHandler::new);

    private static <T extends ScreenHandler> net.minecraft.screen.ScreenHandlerType<T> register(String id, net.minecraft.screen.ScreenHandlerType.Factory<T> factory) {
        return Registry.register(Registries.SCREEN_HANDLER, Identifier.of(Stargazer.MOD_ID, id), new net.minecraft.screen.ScreenHandlerType<>(factory, FeatureFlags.VANILLA_FEATURES));
    }

    public static void init() {
    }
}
