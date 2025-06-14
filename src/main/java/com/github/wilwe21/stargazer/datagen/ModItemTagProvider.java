package com.github.wilwe21.stargazer.datagen;

import com.github.wilwe21.stargazer.block.register.MoonBlocks;
import com.github.wilwe21.stargazer.block.register.StarBlocks;
import com.github.wilwe21.stargazer.item.ItemTags;
import com.github.wilwe21.stargazer.item.ModItems;
import net.fabricmc.fabric.api.datagen.v1.FabricDataOutput;
import net.fabricmc.fabric.api.datagen.v1.provider.FabricTagProvider;
import net.minecraft.registry.RegistryWrapper;

import java.util.concurrent.CompletableFuture;

import static com.github.wilwe21.stargazer.item.ItemTags.STARDUST;

public class ModItemTagProvider extends FabricTagProvider.ItemTagProvider {

    public ModItemTagProvider(FabricDataOutput output, CompletableFuture<RegistryWrapper.WrapperLookup> completableFuture) {
        super(output, completableFuture);
    }

    @Override
    protected void configure(RegistryWrapper.WrapperLookup wrapperLookup) {
        getOrCreateTagBuilder(net.minecraft.registry.tag.ItemTags.LOGS)
                .add(MoonBlocks.MOON_LOG.asItem())
                .add(MoonBlocks.STRIPPED_MOON_LOG.asItem())
                .add(MoonBlocks.CURVE_LOG.asItem())
                .add(StarBlocks.STAR_LOG.asItem())
                .add(StarBlocks.STRIPPED_STAR_LOG.asItem());
        getOrCreateTagBuilder(STARDUST)
                .add(ModItems.STARDUST);
        getOrCreateTagBuilder(ItemTags.ICECREAM)
                .add(ModItems.GRAVICE);
        getOrCreateTagBuilder(ItemTags.STAR)
                .add(ModItems.PURPLE_STAR)
                .add(ModItems.RED_STAR)
                .add(ModItems.BLUE_STAR)
                .add(ModItems.YELLOW_STAR);
       getOrCreateTagBuilder(ItemTags.PURPLE_STAR)
                .add(ModItems.PURPLE_STAR);
       getOrCreateTagBuilder(ItemTags.RED_STAR)
                .add(ModItems.RED_STAR);
       getOrCreateTagBuilder(ItemTags.BLUE_STAR)
                .add(ModItems.BLUE_STAR);
       getOrCreateTagBuilder(ItemTags.YELLOW_STAR)
                .add(ModItems.YELLOW_STAR);
        getOrCreateTagBuilder(ItemTags.MOON_LOG)
                .add(MoonBlocks.MOON_LOG.asItem())
                .add(MoonBlocks.STRIPPED_MOON_LOG.asItem());
        getOrCreateTagBuilder(ItemTags.STAR_LOG)
                .add(StarBlocks.STAR_LOG.asItem())
                .add(StarBlocks.STRIPPED_STAR_LOG.asItem());
        getOrCreateTagBuilder(net.minecraft.registry.tag.ItemTags.PLANKS)
                .add(MoonBlocks.RED_MOON_PLANKS.asItem())
                .add(MoonBlocks.BLUE_MOON_PLANKS.asItem())
                .add(MoonBlocks.PURPLE_MOON_PLANKS.asItem())
                .add(MoonBlocks.YELLOW_MOON_PLANKS.asItem())
                .add(StarBlocks.STAR_PLANKS.asItem())
                .add(MoonBlocks.CURVE_PLANKS.asItem())
                .add(MoonBlocks.MOON_PLANKS.asItem());
        getOrCreateTagBuilder(net.minecraft.registry.tag.ItemTags.STONE_TOOL_MATERIALS)
                .add(MoonBlocks.MOON_ROCK.asItem());
        getOrCreateTagBuilder(ItemTags.STAR_FLOWER)
                .add(StarBlocks.STAR_FLOWER.asItem());
    }
}
