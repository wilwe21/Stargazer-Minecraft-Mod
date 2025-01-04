package com.github.wilwe21.gsad.entity;

import com.github.wilwe21.gsad.Gsad;
import com.github.wilwe21.gsad.GsadClient;
import net.fabricmc.api.EnvType;
import net.fabricmc.api.Environment;
import net.minecraft.client.render.entity.EntityRendererFactory;
import net.minecraft.client.render.entity.MobEntityRenderer;
import net.minecraft.util.Identifier;

@Environment(EnvType.CLIENT)
public class TestRenderer extends MobEntityRenderer<Test, TestRenderState, TestModel> {

    public TestRenderer(EntityRendererFactory.Context context) {
        super(context, new TestModel(context.getPart(GsadClient.MODEL_TEST_LAYER)), 0.4F);
    }

    @Override
    public TestRenderState createRenderState() {
        return null;
    }

    @Override
    public Identifier getTexture(TestRenderState state) {
        return Identifier.of(Gsad.MOD_ID, "textures/entity/motobug.png");
    }
}
