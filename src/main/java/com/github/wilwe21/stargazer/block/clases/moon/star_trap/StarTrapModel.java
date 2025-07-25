package com.github.wilwe21.stargazer.block.clases.moon.star_trap;

import com.github.wilwe21.stargazer.Stargazer;
import com.github.wilwe21.stargazer.entity.Ghost;
import net.minecraft.util.Identifier;
import software.bernie.geckolib.model.GeoModel;
import software.bernie.geckolib.renderer.base.GeoRenderState;

public class StarTrapModel extends GeoModel<StarTrapEntity> {
    private final Identifier model = Identifier.of(Stargazer.MOD_ID, "geckolib/models/block/star_trap");
    private final Identifier animations = Identifier.of(Stargazer.MOD_ID, "geckolib/animations/block/star_trap");
    private final Identifier texture = Identifier.of(Stargazer.MOD_ID, "textures/block/star_trap.png");

    @Override
    public Identifier getModelResource(GeoRenderState renderState) {
        return model;
    }

    @Override
    public Identifier getTextureResource(GeoRenderState renderState) {
        return texture;
    }

    @Override
    public Identifier getAnimationResource(StarTrapEntity animatable) {
        return animations;
    }
}

