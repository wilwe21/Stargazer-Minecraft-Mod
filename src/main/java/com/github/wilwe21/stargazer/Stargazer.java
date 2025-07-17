package com.github.wilwe21.stargazer;

import com.github.wilwe21.stargazer.CreativeTab.ItemGroup;
import com.github.wilwe21.stargazer.block.ModBlock;
import com.github.wilwe21.stargazer.block.BlockTypes;
import com.github.wilwe21.stargazer.effects.Potions;
import com.github.wilwe21.stargazer.effects.StatusEffects;
import com.github.wilwe21.stargazer.entity.EntityRegistry;
import com.github.wilwe21.stargazer.mechanics.CustomFeatures;
import com.github.wilwe21.stargazer.mechanics.DamageTypeRegistry;
import com.github.wilwe21.stargazer.mechanics.Generators.Gens;
import com.github.wilwe21.stargazer.mechanics.blockarray.RandomBlockRegistry;
import com.github.wilwe21.stargazer.mechanics.features.TreesRegistry;
import com.github.wilwe21.stargazer.particle.Particles;
import com.github.wilwe21.stargazer.worldgen.BiomeReg;
import com.github.wilwe21.stargazer.worldgen.BiomeTags;
import net.fabricmc.api.ModInitializer;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.github.wilwe21.stargazer.item.ModItems;

public class Stargazer implements ModInitializer {
	public static final String MOD_ID = "stargazer";
	public static final Logger LOGGER = LoggerFactory.getLogger(MOD_ID);

	public void onInitialize() {
		CustomFeatures.init();
		Potions.init();
		DamageTypeRegistry.init();
		BiomeReg.init();
		BiomeTags.init();
		ModItems.init();
		BlockTypes.init();
		ModBlock.init();
		ItemGroup.init();
		Keybinds.init();
		StargazerAttributes.init();
		CustomTags.init();
		Particles.init();
		RandomBlockRegistry.init();
		TreesRegistry.init();
		Gens.init();
		StatusEffects.init();
		EntityRegistry.init();
	}
}
