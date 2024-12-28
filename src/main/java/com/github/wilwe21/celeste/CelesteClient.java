package com.github.wilwe21.celeste;

import com.github.wilwe21.celeste.block.ModBlock;
import com.github.wilwe21.celeste.block.custom.DreamBlock;
import com.github.wilwe21.celeste.block.custom.DreamBlockEntityRenderer;
import com.github.wilwe21.celeste.block.types.BlockTypes;
import net.fabricmc.api.ClientModInitializer;
import net.fabricmc.api.EnvType;
import net.fabricmc.api.Environment;
import net.fabricmc.fabric.api.blockrenderlayer.v1.BlockRenderLayerMap;
import net.fabricmc.fabric.api.client.event.lifecycle.v1.ClientTickEvents;
import net.fabricmc.fabric.api.client.keybinding.v1.KeyBindingHelper;
import net.fabricmc.fabric.api.client.rendering.v1.BlockEntityRendererRegistry;
import net.fabricmc.fabric.api.client.rendering.v1.ColorProviderRegistry;
import net.minecraft.block.Block;
import net.minecraft.block.BlockState;
import net.minecraft.client.MinecraftClient;
import net.minecraft.client.network.ClientPlayerEntity;
import net.minecraft.client.option.KeyBinding;
import net.minecraft.client.render.RenderLayer;
import net.minecraft.client.util.InputUtil;
import net.minecraft.entity.LivingEntity;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.World;
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
        BlockEntityRendererRegistry.register(BlockTypes.DREAM_BLOCK, DreamBlockEntityRenderer::new);
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
                    if (!dream(client, player)) {
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
                    } else {
                        Celeste.LOGGER.info("Twoja stara dreamblock");
                    }
                }
                if (dashing) {
                    if (dream(client, player)) {
                        Celeste.LOGGER.error("Twoja stara dream block");
                        dashing = false;
                        player.setNoGravity(false);
                    } else if (player.groundCollision && client.options.jumpKey.isPressed()) {
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
    public static boolean dream(MinecraftClient client, ClientPlayerEntity player) {
        World world = client.world;
        double preY = 1.0;
        if (player.getPitch() < 45.0 && player.getPitch() > -45) {
            preY = 0.0;
        } else if (player.getPitch() >= 45.0) {
            preY = -1.0;
        }
        double preX = 0.0;
        double preZ = 0.0;
        switch (player.getHorizontalFacing()) {
            case NORTH -> preZ = -1.0;
            case SOUTH -> preZ = 1.0;
            case EAST -> preX = 1.0;
            case WEST -> preX = -1.0;
        }
        int X = (int) (Math.floor(player.getPos().x + preX));
        int Y = (int) (Math.floor(player.getPos().y) + preY);
        int Z = (int) (Math.floor(player.getPos().z) + preZ);
        if (player.getPitch() < -80 || player.getPitch() > 80) {
            X = (int) Math.floor(player.getPos().x);
            Z = (int) Math.floor(player.getPos().z);
        }
        BlockState block = world.getBlockState(new BlockPos(X, Y, Z));
        Celeste.LOGGER.info("X: " + X + " Y: " + Y + " Z: " + Z);
        Celeste.LOGGER.info(block.toString());
        if (block.getBlock() instanceof DreamBlock) {
            return true;
        }
        return false;
    }
}
