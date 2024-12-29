package com.github.wilwe21.gsad.dash;

import com.github.wilwe21.gsad.Keybinds;
import com.github.wilwe21.gsad.block.custom.blockEntity.dream.DreamBlock;
import com.github.wilwe21.gsad.GsadAttributes;
import net.minecraft.client.MinecraftClient;
import net.minecraft.client.network.ClientPlayerEntity;
import net.minecraft.util.math.BlockPos;
import net.minecraft.util.math.Direction;
import net.minecraft.util.math.Vec3d;

public class DashClient {

    private static final double DASH_SPEED = 1.0;
    private static final double DASH_END_SPEED = 0.4;
    private static final double HYPER_H_SPEED = 3.0;
    private static final double HYPER_V_SPEED = 0.5;
    private static final double SUPER_H_SPEED = 0.8;
    private static final double SUPER_V_SPEED = 1.0;
    private static final double BOUNCE_H_SPEED = 0.8;
    private static final double BOUNCE_V_SPEED = 1.5;

    private static boolean isOnCooldown = false;

    private static int groundCooldown = 0;
    private static int dashCooldown = 0;
    private static int dashes = 0;

    private static Vec3d dashDirection = null;
    private static double dashXRot = 0.0;
    private static double dashDeltaModifier = 0.0;

    private static boolean willHyper = false;
    private static boolean willSuper = false;
    private static boolean willBounce = false;
    private static Direction bounceDirection = null;

    private static BlockPos lastPos = null;

    public static void tick() {
        ClientPlayerEntity player = MinecraftClient.getInstance().player;
        if (player == null) return;
//        if (!player.hasEffect(EstrogenEffects.ESTROGEN_EFFECT.get())) {
//            reset();
//            return;
//        }

        // Refresh number of dashes
        if (canRefresh(player) && groundCooldown == 0) {
            groundCooldown = 4;
            refresh(player);
        }

        groundCooldown--;
        if (groundCooldown < 0) groundCooldown = 0;

        // Hyper
        if (willHyper) {
            willHyper = false;
            Vec3d hyperMotion = new Vec3d(
                    player.getRotationVector().x * HYPER_H_SPEED,
                    HYPER_V_SPEED,
                    player.getRotationVector().z * HYPER_H_SPEED
            );
            player.setVelocity(hyperMotion);
            dashCooldown = 0;
        }
        // Super
        if (willSuper) {
            willSuper = false;
            Vec3d superMotion = new Vec3d(
                    player.getRotationVector().x * SUPER_H_SPEED,
                    SUPER_V_SPEED,
                    player.getRotationVector().z * SUPER_H_SPEED
            );
            player.setVelocity(superMotion);
            dashCooldown = 0;
        }
        // Wall Bounce
        if (willBounce) {
            willBounce = false;
            if (bounceDirection != null) {
                player.setVelocity(bounceDirection.getDoubleVector().x * BOUNCE_H_SPEED, BOUNCE_V_SPEED, bounceDirection.getDoubleVector().z * BOUNCE_H_SPEED);
            } else {
                player.setVelocity(0, BOUNCE_V_SPEED, 0);
            }
            dashCooldown = 0;
        }

        // During Dash
        Dash:
        if (dashCooldown > 0) {
            dashCooldown--;

            // End Dash
            if (dashCooldown == 0) {
                Dash.removeDashing(player.getUuid());
                break Dash;
            }

            player.setVelocity(dashDirection.multiply(DASH_SPEED).multiply(dashDeltaModifier));

//            // Hyper and Super Detection
//            Detect:
//            if (MinecraftClient.getInstance().options.jumpKey.isPressed()) {
//                if (player.isOnGround()) {
//                    if (dashXRot > 15 && dashXRot < 60) willHyper = true;
//                    else if (dashXRot > 0 && dashXRot < 15) willSuper = true;
//                    break Detect;
//                }
//                if (dashXRot < -60) {
//                    for (Direction direction : Direction.) {
//                        // change required distance from wall here
//                        Vec3d vector = Vec3d.atLowerCornerOf(direction.getNormal()).scale(0.25);
//                        AABB aabb = player.getBoundingBox().expandTowards(vector);
//                        if (player.level.noCollision(player, aabb)) continue;
//                        bounceDirection = direction.getOpposite();
//                        willBounce = true;
//                        break Detect;
//                    }
//                }
//            }

            // Dash particles
            if (player.getBlockPos() != lastPos) {
//                EstrogenNetworkManager.CHANNEL.sendToServer(new DashPacket(false));
            }
            lastPos = player.getBlockPos();
        }

        isOnCooldown = dashCooldown > 0 || dashes == 0;

        // Here is when the dash happens
        if (Keybinds.DASH_KEY.isPressed() && !isOnCooldown()) {
            DreamBlock.lookAngle = null;
//            EstrogenNetworkManager.CHANNEL.sendToServer(new DashPacket(true));
            Dash.setDashing(player.getUuid());

            // Set counter to duration of dash
            dashCooldown = 5;
            // Decrement the dash counter
            dashes--;

            dashDirection = player.getRotationVector();
            dashXRot = player.getRotationVector().x;
//            dashDeltaModifier = EstrogenConfig.server().dashDeltaModifier.get();
        }
    }

    public static void reset() {
        dashes = 0;
        isOnCooldown = false;
        dashCooldown = 0;
    }

    public static void refresh(ClientPlayerEntity player) {
        dashes = (short) player.getAttributeValue(GsadAttributes.DASH_LEVEL);
    }

    private static boolean canRefresh(ClientPlayerEntity player) {
        return player.isOnGround();
    }

    public static boolean isOnCooldown() {
        return isOnCooldown;
    }
}