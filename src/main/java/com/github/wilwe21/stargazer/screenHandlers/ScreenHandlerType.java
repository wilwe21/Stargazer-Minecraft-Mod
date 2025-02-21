package com.github.wilwe21.stargazer.screenHandlers;

import com.github.wilwe21.stargazer.Stargazer;
import net.minecraft.entity.player.PlayerInventory;
import net.minecraft.registry.Registries;
import net.minecraft.registry.Registry;
import net.minecraft.resource.featuretoggle.FeatureFlag;
import net.minecraft.resource.featuretoggle.FeatureFlags;
import net.minecraft.resource.featuretoggle.FeatureSet;
import net.minecraft.resource.featuretoggle.ToggleableFeature;
import net.minecraft.screen.Generic3x3ContainerScreenHandler;
import net.minecraft.screen.ScreenHandler;
import net.minecraft.util.Identifier;

public class ScreenHandlerType <T extends ScreenHandler> implements ToggleableFeature {
    public static final net.minecraft.screen.ScreenHandlerType<StarforgeScreenHandler> STARFORGE = register("starforge", StarforgeScreenHandler::new);
    public static final net.minecraft.screen.ScreenHandlerType<AbstractStarforgeScreenHandler> ABSSTARFORGE = register("abstractstarforge", AbstractStarforgeScreenHandler::new);

    private final FeatureSet requiredFeatures;
    private final net.minecraft.screen.ScreenHandlerType.Factory<T> factory;

    private static <T extends ScreenHandler> net.minecraft.screen.ScreenHandlerType<T> register(String id, net.minecraft.screen.ScreenHandlerType.Factory<T> factory) {
        return Registry.register(Registries.SCREEN_HANDLER, Identifier.of(Stargazer.MOD_ID, id), new net.minecraft.screen.ScreenHandlerType<>(factory, FeatureFlags.DEFAULT_ENABLED_FEATURES));
    }

    private static <T extends ScreenHandler> net.minecraft.screen.ScreenHandlerType<T> register(String id, net.minecraft.screen.ScreenHandlerType.Factory<T> factory, FeatureFlag... requiredFeatures) {
        return Registry.register(Registries.SCREEN_HANDLER, Identifier.of(Stargazer.MOD_ID, id), new net.minecraft.screen.ScreenHandlerType<>(factory, FeatureFlags.FEATURE_MANAGER.featureSetOf(requiredFeatures)));
    }

    public ScreenHandlerType(net.minecraft.screen.ScreenHandlerType.Factory<T> factory, FeatureSet requiredFeatures) {
        this.factory = factory;
        this.requiredFeatures = requiredFeatures;
    }

    public T create(int syncId, PlayerInventory playerInventory) {
        return this.factory.create(syncId, playerInventory);
    }

    @Override
    public FeatureSet getRequiredFeatures() {
        return this.requiredFeatures;
    }

    /**
     * A functional interface that creates a screen handler instance on the client.
     *
     * <p>Screen handlers usually have a constructor that can be used as an implementation.
     * See the note on {@link ScreenHandler}.
     */
    public interface Factory<T extends ScreenHandler> {
        T create(int syncId, PlayerInventory playerInventory);
    }

    public static void init() {

    }
}
