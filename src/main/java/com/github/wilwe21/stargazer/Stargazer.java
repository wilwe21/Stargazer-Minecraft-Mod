package com.github.wilwe21.stargazer;

import com.github.wilwe21.stargazer.CreativeTab.ItemGroup;
import com.github.wilwe21.stargazer.block.ModBlock;
import com.github.wilwe21.stargazer.block.BlockTypes;
import com.github.wilwe21.stargazer.entity.ModEntities;
import com.github.wilwe21.stargazer.item.ItemTags;
import com.github.wilwe21.stargazer.mechanics.Generators.Gens;
import com.github.wilwe21.stargazer.mechanics.blockarray.RandomBlockRegistry;
import com.github.wilwe21.stargazer.mechanics.trees.TreesRegistry;
import com.github.wilwe21.stargazer.particle.Particles;
import com.github.wilwe21.stargazer.render.CustomRenderLayers;
import net.fabricmc.api.ModInitializer;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.github.wilwe21.stargazer.item.ModItems;

public class Stargazer implements ModInitializer {
	public static final String MOD_ID = "stargazer";
	public static final Logger LOGGER = LoggerFactory.getLogger(MOD_ID);

	public void onInitialize() {
		ModItems.init();
		BlockTypes.init();
		ModBlock.init();
		ItemGroup.init();
		Keybinds.init();
		StargazerAttributes.init();
		CustomRenderLayers.init();
		ItemTags.init();
		Particles.init();
		RandomBlockRegistry.init();
		TreesRegistry.init();
		Gens.init();
//		ModEntities.init();
	}
}
