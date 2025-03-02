package com.github.wilwe21.stargazer.entity.Client;

import com.github.wilwe21.stargazer.Stargazer;
import com.github.wilwe21.stargazer.entity.projectile.StarProjectileEntity;
import net.minecraft.client.model.*;
import net.minecraft.client.render.entity.model.EntityModel;
import net.minecraft.client.render.entity.model.EntityModelLayer;
import net.minecraft.util.Identifier;

public class StarProjectileModel extends EntityModel<StarProjectileEntity> {
    public static final EntityModelLayer STAR = new EntityModelLayer(Identifier.of(Stargazer.MOD_ID, "star"), "main");
    private final ModelPart star;

    public StarProjectileModel(ModelPart root, ModelPart star) {
        super(root);
        this.star = star;
    }

    @Override
    public void setAngles(StarProjectileEntity state) {
        super.setAngles(state);
    }

    public static TexturedModelData getTexturedModelData() {
        ModelData modelData = new ModelData();
        ModelPartData modelPartData = modelData.getRoot();
        ModelPartData star = modelPartData.addChild("star", ModelPartBuilder.create().uv(0, 16).cuboid(-7.0F, 8.0F, -1.0F, 4.0F, 2.0F, 2.0F, new Dilation(0.0F))
                .uv(16, 8).cuboid(-1.0F, 8.0F, -1.0F, 4.0F, 2.0F, 2.0F, new Dilation(0.0F))
                .uv(0, 8).cuboid(-5.0F, 6.0F, -1.0F, 6.0F, 2.0F, 2.0F, new Dilation(0.0F))
                .uv(0, 4).cuboid(-7.0F, 4.0F, -1.0F, 10.0F, 2.0F, 2.0F, new Dilation(0.0F))
                .uv(0, 0).cuboid(-9.0F, 2.0F, -1.0F, 14.0F, 2.0F, 2.0F, new Dilation(0.0F))
                .uv(0, 12).cuboid(-5.0F, 0.0F, -1.0F, 6.0F, 2.0F, 2.0F, new Dilation(0.0F))
                .uv(12, 16).cuboid(-3.0F, -2.0F, -1.0F, 2.0F, 2.0F, 2.0F, new Dilation(0.0F)), ModelTransform.pivot(2.0F, 14.0F, 0.0F));
        return TexturedModelData.of(modelData, 32, 32);
    }
}
