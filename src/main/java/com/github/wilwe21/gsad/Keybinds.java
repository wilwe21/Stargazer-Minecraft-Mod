package com.github.wilwe21.gsad;

import net.fabricmc.fabric.api.client.keybinding.v1.KeyBindingHelper;
import net.minecraft.client.option.KeyBinding;
import net.minecraft.client.util.InputUtil;
import org.lwjgl.glfw.GLFW;

public class Keybinds {
    public static final KeyBinding DASH_KEY = KeyBindingHelper.registerKeyBinding(
            new KeyBinding(
                    "celeste.dash",
                    InputUtil.Type.KEYSYM,
                    GLFW.GLFW_KEY_X,
                    "category.celeste.dash"
            )
    );
    public static void init() {}
}
