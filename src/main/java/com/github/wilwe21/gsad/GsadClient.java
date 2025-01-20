package com.github.wilwe21.gsad;

import com.github.wilwe21.gsad.block.ModBlock;
import com.github.wilwe21.gsad.block.custom.celeste.dream.DreamBlockEntityRenderer;
import com.github.wilwe21.gsad.block.custom.celeste.tv.TvEntityRenderer;
import com.github.wilwe21.gsad.block.BlockTypes;
import com.github.wilwe21.gsad.block.custom.random.border.BorderBlockEntityRenderer;
import com.github.wilwe21.gsad.block.custom.random.negative.NegativeBlock;
import com.github.wilwe21.gsad.block.custom.random.negative.NegativeBlockEntityRenderer;
import com.github.wilwe21.gsad.dash.DashClient;
import com.github.wilwe21.gsad.entity.ModEntity;
import com.github.wilwe21.gsad.entity.motobug.MotobugModel;
import com.github.wilwe21.gsad.entity.motobug.MotobugRenderer;
import net.fabricmc.api.ClientModInitializer;
import net.fabricmc.api.EnvType;
import net.fabricmc.api.Environment;
import net.fabricmc.fabric.api.blockrenderlayer.v1.BlockRenderLayerMap;
import net.fabricmc.fabric.api.client.event.lifecycle.v1.ClientTickEvents;
import net.fabricmc.fabric.api.client.rendering.v1.BlockEntityRendererRegistry;
import net.fabricmc.fabric.api.client.rendering.v1.ColorProviderRegistry;
import net.fabricmc.fabric.api.client.rendering.v1.EntityModelLayerRegistry;
import net.fabricmc.fabric.api.client.rendering.v1.EntityRendererRegistry;
import net.minecraft.client.model.TexturedModelData;
import net.minecraft.client.render.RenderLayer;
import net.minecraft.client.render.entity.model.EntityModelLayer;
import net.minecraft.util.Identifier;

@Environment(EnvType.CLIENT)
public class GsadClient implements ClientModInitializer {
    //Entity Model Layer
    public static final EntityModelLayer MOTOBUG_LAYER = new EntityModelLayer(Identifier.of(Gsad.MOD_ID, "motobug"), "main");

    @Override
    public void onInitializeClient() {
        //Block rendering
        Gsad.LOGGER.info("Loading Block Rendering");
        BlockRenderLayerMap.INSTANCE.putBlock(ModBlock.GRAVE, RenderLayer.getCutout());
        BlockRenderLayerMap.INSTANCE.putBlock(ModBlock.SPINNER, RenderLayer.getCutout());
        BlockRenderLayerMap.INSTANCE.putBlock(ModBlock.STRAWBERRY, RenderLayer.getCutout());
        BlockRenderLayerMap.INSTANCE.putBlock(ModBlock.SUMMIT, RenderLayer.getCutout());
        BlockRenderLayerMap.INSTANCE.putBlock(ModBlock.RING, RenderLayer.getCutout());
        BlockRenderLayerMap.INSTANCE.putBlock(ModBlock.SPRING, RenderLayer.getCutout());
        BlockEntityRendererRegistry.register(BlockTypes.NEGATIVE_BLOCK, NegativeBlockEntityRenderer::new);
        BlockEntityRendererRegistry.register(BlockTypes.DREAM_BLOCK, DreamBlockEntityRenderer::new);
        BlockEntityRendererRegistry.register(BlockTypes.TV, TvEntityRenderer::new);
        BlockEntityRendererRegistry.register(BlockTypes.BORDER_BLOCK, BorderBlockEntityRenderer::new);
        ColorProviderRegistry.BLOCK.register((state, view, pos, tintIndex) -> view != null && view.getBlockEntityRenderData(pos) instanceof Integer integer ? integer : 0x3495eb, ModBlock.SPINNER);

        //Entity Rendering
        Gsad.LOGGER.info("Loading Entity Rendering");
        EntityModelLayerRegistry.registerModelLayer(MOTOBUG_LAYER, new EntityModelLayerRegistry.TexturedModelDataProvider() {
            @Override
            public TexturedModelData createModelData() {
                return MotobugModel.getTexturedModelData();
            }
        });
        EntityRendererRegistry.register(ModEntity.MOTOBUG, (context) -> new MotobugRenderer(context));

        //Dash
        Gsad.LOGGER.info("Loading End Client Tick Events");
        ClientTickEvents.END_CLIENT_TICK.register(client -> {
            DashClient.tick();
        });

    }
}
