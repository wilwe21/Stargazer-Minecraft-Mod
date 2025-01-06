package com.github.wilwe21.gsad.entity;

import net.minecraft.client.model.*;
import net.minecraft.client.render.RenderLayer;
import net.minecraft.client.render.entity.model.EntityModel;

public class MotobugModel extends EntityModel<MotobugRenderState> {
	private final ModelPart body;
	private final ModelPart wheel;
	private final ModelPart head;

	protected MotobugModel(ModelPart root) {
		super(root);
		this.body = root.getChild("body");
		this.wheel = this.body.getChild("wheel");
		this.head = this.body.getChild("head");
	}


	public static TexturedModelData getTexturedModelData() {
		ModelData modelData = new ModelData();
		ModelPartData modelPartData = modelData.getRoot();
		ModelPartData body = modelPartData.addChild("body", ModelPartBuilder.create(), ModelTransform.pivot(1.0F, 18.0F, -3.5F));

		ModelPartData wheel = body.addChild("wheel", ModelPartBuilder.create().uv(0, 16).cuboid(-2.0F, -4.0F, -4.0F, 4.0F, 8.0F, 8.0F, new Dilation(0.0F)), ModelTransform.pivot(-1.0F, 2.0F, 3.5F));

		ModelPartData head = body.addChild("head", ModelPartBuilder.create().uv(24, 20).cuboid(1.0F, -8.0F, -6.0F, 0.0F, 3.0F, 1.0F, new Dilation(0.0F))
				.uv(0, 0).cuboid(-3.0F, -6.0F, -5.0F, 6.0F, 6.0F, 10.0F, new Dilation(0.0F))
				.uv(24, 16).cuboid(-1.0F, -8.0F, -6.0F, 0.0F, 3.0F, 1.0F, new Dilation(0.0F)), ModelTransform.pivot(-1.0F, 2.0F, 3.5F));
		return TexturedModelData.of(modelData, 32, 32);
	}
}