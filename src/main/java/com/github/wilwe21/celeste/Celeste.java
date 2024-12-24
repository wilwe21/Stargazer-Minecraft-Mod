package com.github.wilwe21.celeste;

import com.github.wilwe21.celeste.CreativeTab.ItemGroup;
import com.github.wilwe21.celeste.block.ModBlock;
import net.fabricmc.api.ModInitializer;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.github.wilwe21.celeste.item.ModItems;

public class Celeste implements ModInitializer {
	public static final String MOD_ID = "celeste";
	public static final Logger LOGGER = LoggerFactory.getLogger(MOD_ID);

	public void onInitialize() {
		ModItems.init();
		ModBlock.init();
		ItemGroup.init();
	}
}
