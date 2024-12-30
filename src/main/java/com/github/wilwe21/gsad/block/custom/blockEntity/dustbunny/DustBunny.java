package com.github.wilwe21.gsad.block.custom.blockEntity.dustbunny;

import com.github.wilwe21.gsad.Helpers;
import com.mojang.serialization.MapCodec;
import net.minecraft.block.BlockState;
import net.minecraft.block.BlockWithEntity;
import net.minecraft.block.ShapeContext;
import net.minecraft.block.entity.BlockEntity;
import net.minecraft.entity.Entity;
import net.minecraft.entity.LivingEntity;
import net.minecraft.server.world.ServerWorld;
import net.minecraft.util.math.BlockPos;
import net.minecraft.util.shape.VoxelShape;
import net.minecraft.util.shape.VoxelShapes;
import net.minecraft.world.BlockView;
import net.minecraft.world.World;

public class DustBunny extends BlockWithEntity {
    public static final float minX = 0.25f;
    public static final float minY = 0.25f;
    public static final float minZ = 0.25f;
    public static final float maxX = 0.75f;
    public static final float maxY = 0.75f;
    public static final float maxZ = 0.75f;
    @Override
    protected MapCodec<? extends DustBunny> getCodec() {
        return createCodec(DustBunny::new);
    }

    @Override
    public BlockEntity createBlockEntity(BlockPos pos, BlockState state) {
        return new DustBunnyEntity(pos, state);
    }

    public DustBunny(Settings settings) {
        super(settings);
    }

    @Override
    protected void onEntityCollision(BlockState state, World world, BlockPos pos, Entity entity) {
        if (entity instanceof LivingEntity ent && world instanceof ServerWorld w1) {
            if (!ent.isInCreativeMode()) {
                if (Helpers.isIntersect(world, ent, state, pos)) {
                    ent.kill(w1);
                }
            }
        }
    }

    public VoxelShape getOutlineShape(BlockState state, BlockView view, BlockPos pos, ShapeContext context) {
        return VoxelShapes.cuboid(minX, minY, minZ, maxX, maxY, maxZ);
    }
}
