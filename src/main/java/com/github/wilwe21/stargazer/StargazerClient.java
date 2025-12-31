package com.github.wilwe21.stargazer;

import com.github.wilwe21.stargazer.block.BlockTypes;
import com.github.wilwe21.stargazer.block.ModBlock;
import com.github.wilwe21.stargazer.block.clases.eyes.eyejar.EyeJarEntityRenderer;
import com.github.wilwe21.stargazer.block.clases.eyes.eyejar.EyeJarModel;
import com.github.wilwe21.stargazer.block.clases.moon.star_trap.StarTrapEntityRenderer;
import com.github.wilwe21.stargazer.block.clases.moon.star_trap.StarTrapModel;
import com.github.wilwe21.stargazer.block.clases.negative.NegativeBlockEntityRenderer;
import com.github.wilwe21.stargazer.block.clases.star.barrier.StarBarrierBlockEntityRenderer;
import com.github.wilwe21.stargazer.block.clases.star.cosmic.CosmicBlockEntityRenderer;
import com.github.wilwe21.stargazer.block.clases.star.leaves.StarLeavesEntityRenderer;
import com.github.wilwe21.stargazer.block.register.Crops;
import com.github.wilwe21.stargazer.block.register.EyeBloodBlocks;
import com.github.wilwe21.stargazer.block.register.MoonBlocks;
import com.github.wilwe21.stargazer.block.register.StarBlocks;
import com.github.wilwe21.stargazer.entity.EntityRegistry;
import com.github.wilwe21.stargazer.entity.renderers.AmethystTurtleRenderer;
import com.github.wilwe21.stargazer.entity.renderers.EyeBatRenderer;
import com.github.wilwe21.stargazer.entity.renderers.GhostRenderer;
import com.github.wilwe21.stargazer.entity.renderers.StarRenderer;
import com.github.wilwe21.stargazer.mechanics.PlayerCosmicGrav;
import com.github.wilwe21.stargazer.mechanics.star.Stargaze;
import com.github.wilwe21.stargazer.mechanics.dash.DashClient;
import com.github.wilwe21.stargazer.particle.Particles;
import com.github.wilwe21.stargazer.screens.ScreenHandlerTypes;
import com.github.wilwe21.stargazer.screens.handled.StarforgeHandled;
import dev.architectury.registry.client.rendering.BlockEntityRendererRegistry;
import net.fabricmc.api.ClientModInitializer;
import net.fabricmc.api.EnvType;
import net.fabricmc.api.Environment;
import net.fabricmc.fabric.api.blockrenderlayer.v1.BlockRenderLayerMap;
import net.fabricmc.fabric.api.client.event.lifecycle.v1.ClientTickEvents;
import net.fabricmc.fabric.api.client.rendering.v1.EntityRendererRegistry;
import net.minecraft.client.gui.screen.ingame.HandledScreens;
import net.minecraft.client.render.RenderLayer;
import net.minecraft.client.render.block.entity.BlockEntityRendererFactories;

@Environment(EnvType.CLIENT)
public class StargazerClient implements ClientModInitializer {
    @Override
    public void onInitializeClient() {
        // Block rendering
        Stargazer.LOGGER.info("Loading Block Rendering");
        BlockRenderLayerMap.INSTANCE.putBlock(ModBlock.GRAVE, RenderLayer.getCutout());
        BlockRenderLayerMap.INSTANCE.putBlock(StarBlocks.BORDER_BLOCK, RenderLayer.getCutout());
        BlockRenderLayerMap.INSTANCE.putBlock(MoonBlocks.MOON_LEAVES, RenderLayer.getCutout());
        BlockRenderLayerMap.INSTANCE.putBlock(MoonBlocks.MOON_SAPLING, RenderLayer.getCutout());
        BlockRenderLayerMap.INSTANCE.putBlock(MoonBlocks.MOON_PLANKS_DOOR, RenderLayer.getCutout());
        BlockRenderLayerMap.INSTANCE.putBlock(StarBlocks.STAR_SAPLING, RenderLayer.getCutout());
        BlockRenderLayerMap.INSTANCE.putBlock(StarBlocks.STAR_FLOWER, RenderLayer.getCutout());
        BlockRenderLayerMap.INSTANCE.putBlock(StarBlocks.CELESTIAL_STAR_FLOWER, RenderLayer.getCutout());
        BlockRenderLayerMap.INSTANCE.putBlock(MoonBlocks.CURVE_LEAVES, RenderLayer.getCutout());
        BlockRenderLayerMap.INSTANCE.putBlock(MoonBlocks.CURVE_SAPLING, RenderLayer.getCutout());
        BlockRenderLayerMap.INSTANCE.putBlock(EyeBloodBlocks.EYE_LEAVES, RenderLayer.getCutout());
        BlockRenderLayerMap.INSTANCE.putBlock(MoonBlocks.MOON_GRASS, RenderLayer.getCutout());
        BlockRenderLayerMap.INSTANCE.putBlock(MoonBlocks.TALL_MOON_GRASS, RenderLayer.getCutout());
        BlockRenderLayerMap.INSTANCE.putBlock(ModBlock.BONE_LEAVES, RenderLayer.getCutout());
        BlockRenderLayerMap.INSTANCE.putBlock(MoonBlocks.GEODE_FRUIT, RenderLayer.getCutout());
        BlockRenderLayerMap.INSTANCE.putBlock(Crops.DRAGON_CARROT_BLOCK, RenderLayer.getCutout());
        BlockRenderLayerMap.INSTANCE.putBlock(MoonBlocks.MOON_FERN, RenderLayer.getCutout());
        BlockRenderLayerMap.INSTANCE.putBlock(EyeBloodBlocks.EYE_FERN, RenderLayer.getCutout());
        BlockRenderLayerMap.INSTANCE.putBlock(EyeBloodBlocks.EYES, RenderLayer.getCutout());
        BlockRenderLayerMap.INSTANCE.putBlock(Crops.GIANT_DRAGON_CARROT, RenderLayer.getCutout());
        BlockRenderLayerMap.INSTANCE.putBlock(MoonBlocks.PURPLE_MUSHROOM, RenderLayer.getCutout());
        BlockEntityRendererFactories.register(BlockTypes.COSMIC_BLOCK, CosmicBlockEntityRenderer::new);
        BlockEntityRendererFactories.register(BlockTypes.STAR_BARRIER_BLOCK, StarBarrierBlockEntityRenderer::new);
        BlockEntityRendererFactories.register(BlockTypes.NEGATIVE_BLOCK, NegativeBlockEntityRenderer::new);
        BlockEntityRendererFactories.register(BlockTypes.STAR_LEAVES, StarLeavesEntityRenderer::new);

        BlockEntityRendererRegistry.register(BlockTypes.STAR_TRAP, (context) -> new StarTrapEntityRenderer(new StarTrapModel()));
        BlockEntityRendererRegistry.register(BlockTypes.EYE_JAR, (context) -> new EyeJarEntityRenderer(new EyeJarModel()));

        // Particles
        Particles.clientInit();

        // Entity
        EntityRendererRegistry.register(EntityRegistry.GHOST_ENTITY, GhostRenderer::new);
        EntityRendererRegistry.register(EntityRegistry.AMETHYST_TURTLE_ENTITY, AmethystTurtleRenderer::new);
        EntityRendererRegistry.register(EntityRegistry.EYE_BAT_ENTITY, EyeBatRenderer::new);
        EntityRendererRegistry.register(EntityRegistry.STAR_ENTITY, StarRenderer::new);

        // Screens
        HandledScreens.register(ScreenHandlerTypes.STARFORGE_HANDLER, StarforgeHandled::new);

        // Tick Events
        Stargazer.LOGGER.info("Loading End Client Tick Events");
        ClientTickEvents.END_CLIENT_TICK.register(client -> {
            try {
                if (client != null && client.world != null && client.player != null) {
                    DashClient.tick();
                    PlayerCosmicGrav.tick(client);
                    Stargaze.tick(client);
                }
            } catch (Exception ignored) {

            }
        });
    }
}
