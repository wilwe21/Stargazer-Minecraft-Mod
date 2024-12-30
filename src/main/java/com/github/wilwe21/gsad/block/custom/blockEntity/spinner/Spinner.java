package com.github.wilwe21.gsad.block.custom.blockEntity.spinner;

import com.github.wilwe21.gsad.Helpers;
import com.mojang.serialization.MapCodec;
import net.minecraft.block.BlockState;
import net.minecraft.block.BlockWithEntity;
import net.minecraft.block.ShapeContext;
import net.minecraft.block.entity.BlockEntity;
import net.minecraft.entity.Entity;
import net.minecraft.entity.LivingEntity;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.item.DyeItem;
import net.minecraft.item.ItemStack;
import net.minecraft.server.world.ServerWorld;
import net.minecraft.util.ActionResult;
import net.minecraft.util.Hand;
import net.minecraft.util.hit.BlockHitResult;
import net.minecraft.util.math.BlockPos;
import net.minecraft.util.math.ColorHelper;
import net.minecraft.util.shape.VoxelShape;
import net.minecraft.util.shape.VoxelShapes;
import net.minecraft.world.BlockView;
import net.minecraft.world.World;

public class Spinner extends BlockWithEntity {
    public static final float minX = 0.25f;
    public static final float minY = 0.25f;
    public static final float minZ = 0.25f;
    public static final float maxX = 0.75f;
    public static final float maxY = 0.75f;
    public static final float maxZ = 0.75f;
    public Spinner(Settings settings) {
        super(settings);
    }

    @Override
    protected ActionResult onUseWithItem(ItemStack stack, BlockState state, World world, BlockPos pos, PlayerEntity player, Hand hand, BlockHitResult hit) {
        if (stack.getItem() instanceof DyeItem dyeItem) {
            if (world.getBlockEntity(pos) instanceof SpinnerEntity spinnerEntity) {
                final int newColor = dyeItem.getColor().getEntityColor();
                final int originalColor = spinnerEntity.color;
                spinnerEntity.color = ColorHelper.average(newColor, originalColor);
                stack.decrementUnlessCreative(1, player);
                spinnerEntity.markDirty();
                world.updateListeners(pos, state, state, 0);
            }
        }
        return super.onUseWithItem(stack, state, world, pos, player, hand, hit);
    }

    public void onEntityCollision(BlockState state, World world, BlockPos pos, Entity entity) {
        if (entity instanceof LivingEntity ent && world instanceof ServerWorld w1) {
            if (!ent.isInCreativeMode()) {
                if (Helpers.isIntersect(world, ent, state, pos)) {
                    ent.kill(w1);
                }
            }
        }
    }

    @Override
    protected MapCodec<? extends Spinner> getCodec() {
        return createCodec(Spinner::new);
    }

    @Override
    public BlockEntity createBlockEntity(BlockPos pos, BlockState state) {
        return new SpinnerEntity(pos, state);
    }

    public VoxelShape getOutlineShape(BlockState state, BlockView view, BlockPos pos, ShapeContext context) {
        return VoxelShapes.cuboid(minX, minY, minZ, maxX, maxY, maxZ);
    }
}
