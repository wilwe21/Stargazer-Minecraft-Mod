package com.github.wilwe21.stargazer;

import com.github.wilwe21.stargazer.block.ModBlock;
import com.github.wilwe21.stargazer.block.BlockTypes;
import com.github.wilwe21.stargazer.block.clases.barrier.StarBarrierBlockEntityRenderer;
import com.github.wilwe21.stargazer.block.clases.cosmic.CosmicBlockEntityRenderer;
import com.github.wilwe21.stargazer.block.clases.negative.NegativeBlockEntityRenderer;
import com.github.wilwe21.stargazer.mechanics.BlockInHand;
import com.github.wilwe21.stargazer.mechanics.PlayerInside;
import com.github.wilwe21.stargazer.mechanics.star.Stargaze;
import com.github.wilwe21.stargazer.mechanics.dash.DashClient;
import com.github.wilwe21.stargazer.particle.Particles;
import com.github.wilwe21.stargazer.screenHandlers.StarforgeContainerScreen;
import net.fabricmc.api.ClientModInitializer;
import net.fabricmc.api.EnvType;
import net.fabricmc.api.Environment;
import net.fabricmc.fabric.api.blockrenderlayer.v1.BlockRenderLayerMap;
import net.fabricmc.fabric.api.client.event.lifecycle.v1.ClientTickEvents;
import net.fabricmc.fabric.api.client.rendering.v1.BlockEntityRendererRegistry;
import net.minecraft.client.render.RenderLayer;

@Environment(EnvType.CLIENT)
public class StargazerClient implements ClientModInitializer {
    @Override
    public void onInitializeClient() {
        // Block rendering
        Stargazer.LOGGER.info("Loading Block Rendering");
        BlockRenderLayerMap.INSTANCE.putBlock(ModBlock.GRAVE, RenderLayer.getCutout());
        BlockRenderLayerMap.INSTANCE.putBlock(ModBlock.BORDER_BLOCK, RenderLayer.getCutout());
        BlockEntityRendererRegistry.register(BlockTypes.NEGATIVE_BLOCK, NegativeBlockEntityRenderer::new);
        BlockEntityRendererRegistry.register(BlockTypes.COSMIC_BLOCK, CosmicBlockEntityRenderer::new);
        BlockEntityRendererRegistry.register(BlockTypes.STAR_BARRIER_BLOCK, StarBarrierBlockEntityRenderer::new);

        // Particles
        Particles.clientInit();

        // Tick Events
        Stargazer.LOGGER.info("Loading End Client Tick Events");
        ClientTickEvents.END_CLIENT_TICK.register(client -> {
            try {
                if (client != null && client.world != null && client.player != null) {
                    DashClient.tick();
                    BlockInHand.tick(client);
                    PlayerInside.tick(client);
                    Stargaze.tick(client);
                }
            } catch (NullPointerException e) {

            }
        });
    }
}
