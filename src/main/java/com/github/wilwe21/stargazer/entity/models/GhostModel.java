package com.github.wilwe21.stargazer.entity.models;

import com.github.wilwe21.stargazer.Stargazer;
import com.github.wilwe21.stargazer.entity.Ghost;
import net.minecraft.client.render.entity.state.LivingEntityRenderState;
import net.minecraft.util.Identifier;
import software.bernie.geckolib.model.GeoModel;
import software.bernie.geckolib.renderer.base.GeoRenderState;

public class GhostModel extends GeoModel<Ghost> {
    private final Identifier model = Identifier.of(Stargazer.MOD_ID, "geckolib/models/entity/ghost");
    private final Identifier animations = Identifier.of(Stargazer.MOD_ID, "geckolib/animations/entity/ghost");
    private final Identifier texture = Identifier.of(Stargazer.MOD_ID, "textures/entity/ghost.png");
    private final Identifier texture_blinky = Identifier.of(Stargazer.MOD_ID, "textures/entity/ghost_blinky.png");
    private final Identifier texture_clyde = Identifier.of(Stargazer.MOD_ID, "textures/entity/ghost_clyde.png");
    private final Identifier texture_inky = Identifier.of(Stargazer.MOD_ID, "textures/entity/ghost_inky.png");
    private final Identifier texture_pinky = Identifier.of(Stargazer.MOD_ID, "textures/entity/ghost_pinky.png");

    @Override
    public Identifier getModelResource(GeoRenderState renderState) {
        return model;
    }

    @Override
    public Identifier getTextureResource(GeoRenderState renderState) {
        if (renderState instanceof LivingEntityRenderState entityState && entityState.customName != null) {
            String name = entityState.customName.getString().toLowerCase();
            switch (name) {
                case "blinky" -> {
                    return texture_blinky;
                }
                case "clyde" -> {
                    return texture_clyde;
                }
                case "inky" -> {
                    return texture_inky;
                }
                case "pinky" -> {
                    return texture_pinky;
                }
            }
        }
        return texture;
    }

    @Override
    public Identifier getAnimationResource(Ghost animatable) {
        return animations;
    }
}
