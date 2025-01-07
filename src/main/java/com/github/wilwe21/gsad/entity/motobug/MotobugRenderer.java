package com.github.wilwe21.gsad.entity.motobug;

import com.github.wilwe21.gsad.Gsad;
import com.github.wilwe21.gsad.GsadClient;
import net.fabricmc.api.EnvType;
import net.fabricmc.api.Environment;
import net.minecraft.client.render.entity.EntityRendererFactory;
import net.minecraft.client.render.entity.MobEntityRenderer;
import net.minecraft.util.Identifier;

@Environment(EnvType.CLIENT)
public class MotobugRenderer extends MobEntityRenderer<Motobug, MotobugRenderState, MotobugModel> {

    public MotobugRenderer(EntityRendererFactory.Context context) {
        super(context, new MotobugModel(context.getPart(GsadClient.MOTOBUG_LAYER)), 0.5F);
    }

    @Override
    public MotobugRenderState createRenderState() {
        return new MotobugRenderState();
    }

    @Override
    public Identifier getTexture(MotobugRenderState state) {
        return Identifier.of(Gsad.MOD_ID, "textures/entity/motobug.png");
    }
}
