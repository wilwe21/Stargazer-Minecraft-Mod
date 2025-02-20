package com.github.wilwe21.stargazer.screenHandlers;

import net.minecraft.entity.player.PlayerInventory;
import net.minecraft.screen.ScreenHandlerContext;
import net.minecraft.util.StringHelper;
import org.jetbrains.annotations.Nullable;

public class StarforgeScreenHandler extends AbstractStarforgeScreenHandler {
    public StarforgeScreenHandler(int syncId, PlayerInventory inventory) {
        this(syncId, inventory, ScreenHandlerContext.EMPTY);
    }

    public StarforgeScreenHandler(int syncId, PlayerInventory inventory, ScreenHandlerContext context) {
        super(syncId, inventory);
    }

    @Nullable
    private static String sanitize(String name) {
        String string = StringHelper.stripInvalidChars(name);
        return string.length() <= 50 ? string : null;
    }
}
