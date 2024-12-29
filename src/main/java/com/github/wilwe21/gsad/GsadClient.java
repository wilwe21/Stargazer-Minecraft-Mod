package com.github.wilwe21.gsad;

import com.github.wilwe21.gsad.block.ModBlock;
import com.github.wilwe21.gsad.block.custom.blockEntity.dream.DreamBlockEntityRenderer;
import com.github.wilwe21.gsad.block.custom.blockEntity.tv.TvEntityRenderer;
import com.github.wilwe21.gsad.block.types.BlockTypes;
import net.fabricmc.api.ClientModInitializer;
import net.fabricmc.api.EnvType;
import net.fabricmc.api.Environment;
import net.fabricmc.fabric.api.blockrenderlayer.v1.BlockRenderLayerMap;
import net.fabricmc.fabric.api.client.event.lifecycle.v1.ClientTickEvents;
import net.fabricmc.fabric.api.client.rendering.v1.BlockEntityRendererRegistry;
import net.fabricmc.fabric.api.client.rendering.v1.ColorProviderRegistry;
import net.minecraft.client.MinecraftClient;
import net.minecraft.client.network.ClientPlayerEntity;
import net.minecraft.client.render.RenderLayer;
import net.minecraft.util.math.Vec3d;

import static com.github.wilwe21.gsad.Keybinds.DASH_KEY;

@Environment(EnvType.CLIENT)
public class GsadClient implements ClientModInitializer {
    private static final float dashDistance = 0.8f;

    private boolean dashing = false;

    @Override
    public void onInitializeClient() {
        //Block rendering
        BlockRenderLayerMap.INSTANCE.putBlock(ModBlock.SPINNER, RenderLayer.getCutout());
        BlockRenderLayerMap.INSTANCE.putBlock(ModBlock.STRAWBERRY, RenderLayer.getCutout());
        BlockRenderLayerMap.INSTANCE.putBlock(ModBlock.SPRING, RenderLayer.getCutout());
        BlockEntityRendererRegistry.register(BlockTypes.DREAM_BLOCK, DreamBlockEntityRenderer::new);
        BlockEntityRendererRegistry.register(BlockTypes.TV, TvEntityRenderer::new);
        ColorProviderRegistry.BLOCK.register((state, view, pos, tintIndex) -> view != null && view.getBlockEntityRenderData(pos) instanceof Integer integer ? integer : 0x3495eb, ModBlock.SPINNER);

        //Dash
        ClientTickEvents.END_CLIENT_TICK.register(client -> {
            ClientPlayerEntity player = MinecraftClient.getInstance().player;

            if (player != null) {
                // Check for dash button press
                if (DASH_KEY.isPressed() && !dashing) {
                    DASH_KEY.setPressed(false);
                    dashing = true;
                    Vec3d lookAngle = player.getRotationVector();
                    player.setVelocity(lookAngle);
                }
                if (dashing) {
                    if (player.groundCollision && client.options.jumpKey.isPressed()) {
                        Gsad.LOGGER.info("WaveDash");
                        double yaw = Math.toRadians(player.getYaw());
                        double dashX = -Math.sin(yaw) * dashDistance * 1.2;
                        double dashZ = Math.cos(yaw) * dashDistance * 1.2;
                        player.setVelocity(dashX, player.getVelocity().y + 0.3, dashZ);
                        dashing = false;
                    } else if (player.horizontalCollision && client.options.jumpKey.isPressed()) {
                        Gsad.LOGGER.info("WallBounce");
                        double dashY = dashDistance * 1.2;
                        player.setVelocity(-player.getVelocity().x, dashY, -player.getVelocity().z);
                        dashing = false;
                    } else if (player.horizontalCollision || player.groundCollision) {
                        dashing = false;
                    }
                }
            }
        });

    }
}
