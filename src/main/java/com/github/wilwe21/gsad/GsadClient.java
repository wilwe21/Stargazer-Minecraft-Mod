package com.github.wilwe21.gsad;

import com.github.wilwe21.gsad.block.ModBlock;
import com.github.wilwe21.gsad.block.custom.blockEntity.celeste.dream.DreamBlockEntityRenderer;
import com.github.wilwe21.gsad.block.custom.blockEntity.celeste.tv.TvEntityRenderer;
import com.github.wilwe21.gsad.block.types.BlockTypes;
import com.github.wilwe21.gsad.dash.DashClient;
import net.fabricmc.api.ClientModInitializer;
import net.fabricmc.api.EnvType;
import net.fabricmc.api.Environment;
import net.fabricmc.fabric.api.blockrenderlayer.v1.BlockRenderLayerMap;
import net.fabricmc.fabric.api.client.event.lifecycle.v1.ClientTickEvents;
import net.fabricmc.fabric.api.client.rendering.v1.BlockEntityRendererRegistry;
import net.fabricmc.fabric.api.client.rendering.v1.ColorProviderRegistry;
import net.minecraft.client.render.RenderLayer;

@Environment(EnvType.CLIENT)
public class GsadClient implements ClientModInitializer {

    @Override
    public void onInitializeClient() {
        //Block rendering
        BlockRenderLayerMap.INSTANCE.putBlock(ModBlock.SPINNER, RenderLayer.getCutout());
        BlockRenderLayerMap.INSTANCE.putBlock(ModBlock.STRAWBERRY, RenderLayer.getCutout());
        BlockRenderLayerMap.INSTANCE.putBlock(ModBlock.RING, RenderLayer.getCutout());
        BlockRenderLayerMap.INSTANCE.putBlock(ModBlock.SPRING, RenderLayer.getCutout());
        BlockEntityRendererRegistry.register(BlockTypes.DREAM_BLOCK, DreamBlockEntityRenderer::new);
        BlockEntityRendererRegistry.register(BlockTypes.TV, TvEntityRenderer::new);
        ColorProviderRegistry.BLOCK.register((state, view, pos, tintIndex) -> view != null && view.getBlockEntityRenderData(pos) instanceof Integer integer ? integer : 0x3495eb, ModBlock.SPINNER);

        //Dash
        ClientTickEvents.END_CLIENT_TICK.register(client -> {
            DashClient.tick();
        });

    }
}
