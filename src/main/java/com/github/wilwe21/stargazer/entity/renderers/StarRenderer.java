package com.github.wilwe21.stargazer.entity.renderers;

import com.github.wilwe21.stargazer.entity.Ghost;
import com.github.wilwe21.stargazer.entity.Star;
import com.github.wilwe21.stargazer.entity.models.GhostModel;
import com.github.wilwe21.stargazer.entity.models.StarModel;
import net.minecraft.client.render.entity.EntityRendererFactory;
import net.minecraft.client.render.entity.state.LivingEntityRenderState;
import software.bernie.geckolib.renderer.GeoEntityRenderer;
import software.bernie.geckolib.renderer.base.GeoRenderState;
import software.bernie.geckolib.renderer.layer.AutoGlowingGeoLayer;

public class StarRenderer<R extends LivingEntityRenderState & GeoRenderState> extends GeoEntityRenderer<Star, R> {
    public StarRenderer(EntityRendererFactory.Context context) {
        super(context, new StarModel());
    }
}