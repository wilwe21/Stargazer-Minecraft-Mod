package com.github.wilwe21.celeste;

import com.github.wilwe21.celeste.block.ModBlock;
import net.fabricmc.api.ClientModInitializer;
import net.fabricmc.api.EnvType;
import net.fabricmc.api.Environment;
import net.fabricmc.fabric.api.blockrenderlayer.v1.BlockRenderLayerMap;
import net.fabricmc.fabric.api.client.event.lifecycle.v1.ClientTickEvents;
import net.fabricmc.fabric.api.client.keybinding.v1.KeyBindingHelper;
import net.fabricmc.fabric.api.client.rendering.v1.ColorProviderRegistry;
import net.minecraft.client.MinecraftClient;
import net.minecraft.client.network.ClientPlayerEntity;
import net.minecraft.client.option.KeyBinding;
import net.minecraft.client.render.RenderLayer;
import net.minecraft.client.util.InputUtil;
import org.lwjgl.glfw.GLFW;

@Environment(EnvType.CLIENT)
public class CelesteClient implements ClientModInitializer {

    private static final float dashDistance = 0.8f;

    private boolean dashing = false;

    public static final KeyBinding dashKey = KeyBindingHelper.registerKeyBinding(
            new KeyBinding(
                    "celeste.dash",
                    InputUtil.Type.KEYSYM,
                    GLFW.GLFW_KEY_X,
                    "category.celeste.dash"
            )
    );

    @Override
    public void onInitializeClient() {
        //Block rendering
        BlockRenderLayerMap.INSTANCE.putBlock(ModBlock.SPINNER, RenderLayer.getCutout());
        BlockRenderLayerMap.INSTANCE.putBlock(ModBlock.STRAWBERRY, RenderLayer.getCutout());
        BlockRenderLayerMap.INSTANCE.putBlock(ModBlock.SPRING, RenderLayer.getCutout());
        ColorProviderRegistry.BLOCK.register((state, view, pos, tintIndex) -> view != null && view.getBlockEntityRenderData(pos) instanceof Integer integer ? integer : 0x3495eb, ModBlock.SPINNER);

        //Dash
        ClientTickEvents.END_CLIENT_TICK.register(client -> {
            ClientPlayerEntity player = MinecraftClient.getInstance().player;

            if (player != null) {
                // Check for dash button press
                if (dashKey.isPressed() && !dashing) {
                    dashKey.setPressed(false);
                    double yaw = Math.toRadians(player.getYaw());
                    double pitch = Math.toRadians(player.getPitch());
                    double dashX = -Math.sin(yaw) * dashDistance;
                    double dashZ = Math.cos(yaw) * dashDistance;
                    double dashY = -Math.sin(pitch) * dashDistance;

                    // Apply the dash
                    player.setNoGravity(true);
                    dashing = true;
                    if (player.getPitch() == -90.0f || player.getPitch() == 90.0f) {
                        player.addVelocity(player.getVelocity().x, dashY, player.getVelocity().z);
                    } else {
                        player.addVelocity(dashX, dashY, dashZ);
                    }
                    new Thread(() -> {
                        try {
                            Thread.sleep(500);
                        } catch (Exception e) {
                            Celeste.LOGGER.error(e.toString());
                        }
                        player.setNoGravity(false);
                        dashing = false;
                    }).start();
                }
                if (dashing) {
                    if (player.groundCollision && client.options.jumpKey.isPressed()) {
                        Celeste.LOGGER.info("WaveDash");
                        double yaw = Math.toRadians(player.getYaw());
                        double dashX = -Math.sin(yaw) * dashDistance * 1.2;
                        double dashZ = Math.cos(yaw) * dashDistance * 1.2;
                        player.setVelocity(dashX, player.getVelocity().y + 0.3, dashZ);
                        dashing = false;
                        player.setNoGravity(false);
                    } else if (player.horizontalCollision && client.options.jumpKey.isPressed()) {
                        Celeste.LOGGER.info("WallBounce");
                        double dashY = dashDistance * 1.2;
                        player.setVelocity(-player.getVelocity().x, dashY, -player.getVelocity().z);
                        dashing = false;
                        player.setNoGravity(false);
                    } else if (player.horizontalCollision || player.groundCollision) {
                        dashing = false;
                        player.setNoGravity(false);
                    }
                }
            }
        });

    }
}
