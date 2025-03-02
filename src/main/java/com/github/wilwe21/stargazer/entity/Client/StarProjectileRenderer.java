package com.github.wilwe21.stargazer.entity.Client;

import com.github.wilwe21.stargazer.entity.projectile.StarProjectileEntity;
import net.minecraft.client.render.Camera;
import net.minecraft.client.render.Frustum;
import net.minecraft.client.render.VertexConsumerProvider;
import net.minecraft.client.render.entity.EntityRenderer;
import net.minecraft.client.render.entity.EntityRendererFactory;
import net.minecraft.client.render.entity.state.EntityRenderState;
import net.minecraft.client.render.item.HeldItemRenderer;
import net.minecraft.client.util.math.MatrixStack;
import net.minecraft.entity.Entity;
import net.minecraft.resource.ResourceManager;
import net.minecraft.resource.ResourceReloader;
import net.minecraft.world.World;
import org.jetbrains.annotations.Nullable;
import org.joml.Quaternionf;

import java.util.concurrent.CompletableFuture;
import java.util.concurrent.Executor;

public class StarProjectileRenderer extends EntityRenderer {
    public StarProjectileRenderer(EntityRendererFactory.Context context) {
        super(context);
    }

    @Override
    public EntityRenderState createRenderState() {
        return null;
    }

    public void setRenderShadows(boolean renderShadows) {
        dispatcher.setRenderShadows(renderShadows);
    }

    public double getSquaredDistanceToCamera(Entity entity) {
        return dispatcher.getSquaredDistanceToCamera(entity);
    }

    public <E extends Entity> void render(E entity, double x, double y, double z, float tickDelta, MatrixStack matrices, VertexConsumerProvider vertexConsumers, int light) {
        dispatcher.render(entity, x, y, z, tickDelta, matrices, vertexConsumers, light);
    }

    public void reload(ResourceManager manager) {
        dispatcher.reload(manager);
    }

    public <T extends Entity> EntityRenderer<? super T, ?> getRenderer(T entity) {
        return dispatcher.getRenderer(entity);
    }

    public HeldItemRenderer getHeldItemRenderer() {
        return dispatcher.getHeldItemRenderer();
    }

    public void setRotation(Quaternionf rotation) {
        dispatcher.setRotation(rotation);
    }

    public void setWorld(@Nullable World world) {
        dispatcher.setWorld(world);
    }

    public Quaternionf getRotation() {
        return dispatcher.getRotation();
    }

    public void configure(World world, Camera camera, Entity target) {
        dispatcher.configure(world, camera, target);
    }

    public boolean shouldRenderHitboxes() {
        return dispatcher.shouldRenderHitboxes();
    }

    public void setRenderHitboxes(boolean renderHitboxes) {
        dispatcher.setRenderHitboxes(renderHitboxes);
    }

    public double getSquaredDistanceToCamera(double x, double y, double z) {
        return dispatcher.getSquaredDistanceToCamera(x, y, z);
    }

    public CompletableFuture<Void> reload(ResourceReloader.Synchronizer synchronizer, ResourceManager manager, Executor prepareExecutor, Executor applyExecutor) {
        return dispatcher.reload(synchronizer, manager, prepareExecutor, applyExecutor);
    }

    public String getName() {
        return dispatcher.getName();
    }
}
