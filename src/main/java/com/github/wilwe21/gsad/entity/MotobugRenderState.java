package com.github.wilwe21.gsad.entity;

import net.fabricmc.api.EnvType;
import net.fabricmc.api.Environment;
import net.minecraft.client.render.entity.state.LivingEntityRenderState;

@Environment(EnvType.CLIENT)
public class MotobugRenderState extends LivingEntityRenderState {
    public float isMovingValue;
    public float inWaterValue = 1.0F;
    public float onGroundValue;
}
