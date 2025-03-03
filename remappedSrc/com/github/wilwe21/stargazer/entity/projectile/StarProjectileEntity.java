package com.github.wilwe21.stargazer.entity.projectile;

import com.github.wilwe21.stargazer.entity.ModEntities;
import com.github.wilwe21.stargazer.item.ModItems;
import net.minecraft.entity.EntityType;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.entity.projectile.PersistentProjectileEntity;
import net.minecraft.item.ItemStack;
import net.minecraft.util.hit.BlockHitResult;
import net.minecraft.util.hit.EntityHitResult;
import net.minecraft.world.World;
import org.joml.Vector2f;

public class StarProjectileEntity extends PersistentProjectileEntity {
//    private float rotation;
//    public Vector2f groundOffset;
//
//    public StarProjectileEntity(EntityType<? extends PersistentProjectileEntity> entityType, World world) {
//        super(entityType, world);
//    }
//
//    @Override
//    protected void onEntityHit(EntityHitResult entityHitResult) {
//        super.onEntityHit(entityHitResult);
//    }
//
//    @Override
//    protected void onBlockHit(BlockHitResult blockHitResult) {
//        super.onBlockHit(blockHitResult);
//    }
//
//    public StarProjectileEntity(World world, PlayerEntity player) {
//        super(ModEntities.STAR, player, world, new ItemStack(ModItems.YELLOW_STAR), null);
//    }
//
//    @Override
//    protected ItemStack getDefaultItemStack() {
//        return new ItemStack(ModItems.YELLOW_STAR);
//    }
//
//    public float getRenderingRotation() {
//        rotation += 0.5f;
//        if (rotation > 360) {
//            rotation = 0;
//        }
//        return rotation;
//    }
}
