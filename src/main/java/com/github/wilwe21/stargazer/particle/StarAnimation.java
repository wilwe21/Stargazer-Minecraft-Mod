package com.github.wilwe21.stargazer.particle;

import net.fabricmc.api.EnvType;
import net.fabricmc.api.Environment;
import net.minecraft.client.particle.ParticleTextureSheet;
import net.minecraft.client.particle.SpriteBillboardParticle;
import net.minecraft.client.particle.SpriteProvider;
import net.minecraft.client.world.ClientWorld;

@Environment(EnvType.CLIENT)
public class StarAnimation extends SpriteBillboardParticle {
    protected final SpriteProvider spriteProvider;
    private float targetRed;
    private float targetGreen;
    private float targetBlue;
    private boolean changesColor;
    private final float scaleMultiplyer = 0.001F;

    protected StarAnimation(ClientWorld world, double x, double y, double z, SpriteProvider spriteProvider, float upwardsAcceleration) {
        super(world, x, y, z);
        this.velocityMultiplier = 0.91F;
        this.gravityStrength = upwardsAcceleration;
        this.spriteProvider = spriteProvider;
        this.setSprite(spriteProvider);
    }

    public void setColor(int rgbHex) {
        float f = (float)((rgbHex & 0xFF0000) >> 16) / 255.0F;
        float g = (float)((rgbHex & 0xFF00) >> 8) / 255.0F;
        float h = (float)((rgbHex & 0xFF) >> 0) / 255.0F;
        float i = 1.0F;
        this.setColor(f * 1.0F, g * 1.0F, h * 1.0F);
    }

    public void setTargetColor(int rgbHex) {
        this.targetRed = (float)((rgbHex & 0xFF0000) >> 16) / 255.0F;
        this.targetGreen = (float)((rgbHex & 0xFF00) >> 8) / 255.0F;
        this.targetBlue = (float)((rgbHex & 0xFF) >> 0) / 255.0F;
        this.changesColor = true;
    }

    @Override
    public ParticleTextureSheet getType() {
        return ParticleTextureSheet.PARTICLE_SHEET_TRANSLUCENT;
    }

    @Override
    public void tick() {
        super.tick();
        if (this.scale - scaleMultiplyer > 0) {
            this.scale -= scaleMultiplyer;
        }
        if (this.age > this.maxAge / 2) {
            this.scale(1.0F - ((float)this.age - (float)(this.maxAge / 2)) / (float)this.maxAge);
            if (this.changesColor) {
                this.red = this.red + (this.targetRed - this.red) * 0.2F;
                this.green = this.green + (this.targetGreen - this.green) * 0.2F;
                this.blue = this.blue + (this.targetBlue - this.blue) * 0.2F;
            }
        }
    }

    @Override
    public int getBrightness(float tint) {
        return 15728880;
    }
}
