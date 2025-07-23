package com.github.wilwe21.stargazer.screens.handled;

import com.github.wilwe21.stargazer.Stargazer;
import com.github.wilwe21.stargazer.screens.StarforgeScreenHandler;
import net.minecraft.client.gui.DrawContext;
import net.minecraft.client.gui.screen.ingame.HandledScreen;
import net.minecraft.client.render.RenderLayer;
import net.minecraft.entity.player.PlayerInventory;
import net.minecraft.text.Text;
import net.minecraft.util.Identifier;

public class StarforgeHandled extends HandledScreen<StarforgeScreenHandler> {
    private static final Identifier TEXTURE = Identifier.of(Stargazer.MOD_ID, "textures/gui/starforge/starforge.png");

    public StarforgeHandled(StarforgeScreenHandler handler, PlayerInventory inventory, Text title) {
        super(handler, inventory, title);
        this.titleX = 110;
        this.titleY = 10;
        this.playerInventoryTitleY = 108;
        this.backgroundHeight = 200;
    }

    @Override
    protected void init() {
        super.init();
    }

//    @Override
//    protected ScreenPos getRecipeBookButtonPos() {
//        return new ScreenPos(this.x + 120, this.y + 66);
//    }

    @Override
    protected void drawBackground(DrawContext context, float deltaTicks, int mouseX, int mouseY) {
        int i = this.x;
        int j = (this.height - this.backgroundHeight) / 2;
        context.drawTexture(RenderLayer::getGuiTextured, TEXTURE, i, j, 0.0f, 0.0f, this.backgroundWidth, this.backgroundHeight , 256, 256);
    }
}