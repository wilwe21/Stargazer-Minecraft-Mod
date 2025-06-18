package com.github.wilwe21.stargazer.entity.models;

import com.github.wilwe21.stargazer.Stargazer;
import com.github.wilwe21.stargazer.entity.Ghost;
import net.minecraft.util.Identifier;
import software.bernie.geckolib.model.GeoModel;
import software.bernie.geckolib.renderer.base.GeoRenderState;

public class GhostModel extends GeoModel<Ghost> {
    private final Identifier model = Identifier.of(Stargazer.MOD_ID, "geckolib/models/entity/ghost");
    private final Identifier animations = Identifier.of(Stargazer.MOD_ID, "geckolib/animations/entity/ghost");
    private final Identifier texture = Identifier.of(Stargazer.MOD_ID, "textures/entity/ghost.png");

    @Override
    public Identifier getModelResource(GeoRenderState renderState) {
        return model;
    }

    @Override
    public Identifier getTextureResource(GeoRenderState renderState) {
        return texture;
    }

    @Override
    public Identifier getAnimationResource(Ghost animatable) {
        return animations;
    }
}
