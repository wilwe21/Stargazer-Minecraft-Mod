package com.github.wilwe21.celeste;

import com.github.wilwe21.celeste.CreativeTab.ItemGroup;
import com.github.wilwe21.celeste.block.ModBlock;
import com.github.wilwe21.celeste.block.types.BlockTypes;
import net.fabricmc.api.ModInitializer;

import net.fabricmc.fabric.api.client.event.lifecycle.v1.ClientTickEvents;
import net.fabricmc.fabric.api.client.keybinding.v1.KeyBindingHelper;
import net.minecraft.client.MinecraftClient;
import net.minecraft.client.network.ClientPlayerEntity;
import net.minecraft.client.option.KeyBinding;
import net.minecraft.client.util.InputUtil;
import org.lwjgl.glfw.GLFW;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.github.wilwe21.celeste.item.ModItems;

public class Celeste implements ModInitializer {
	public static final String MOD_ID = "celeste";
	public static final Logger LOGGER = LoggerFactory.getLogger(MOD_ID);

	public void onInitialize() {
		ModItems.init();
		BlockTypes.init();
		ModBlock.init();
		ItemGroup.init();
	}
}
