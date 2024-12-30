package com.github.wilwe21.gsad.block.custom.blockEntity.celeste;

import com.github.wilwe21.gsad.Helpers;
import com.mojang.serialization.MapCodec;
import net.minecraft.block.Block;
import net.minecraft.block.BlockState;
import net.minecraft.block.FacingBlock;
import net.minecraft.block.ShapeContext;
import net.minecraft.entity.Entity;
import net.minecraft.entity.LivingEntity;
import net.minecraft.item.ItemPlacementContext;
import net.minecraft.server.world.ServerWorld;
import net.minecraft.state.StateManager;
import net.minecraft.state.property.Properties;
import net.minecraft.util.math.BlockPos;
import net.minecraft.util.math.Direction;
import net.minecraft.util.shape.VoxelShape;
import net.minecraft.world.BlockView;
import net.minecraft.world.World;

public class Spikes extends FacingBlock {
    public static final float minX = 0.1f;
    public static final float minY = 0f;
    public static final float minZ = 0.1f;
    public static final float maxX = 0.9f;
    public static final float maxY = 0.15f;
    public static final float maxZ = 0.9f;

    public static final MapCodec<Spikes> CODEC = Block.createCodec(Spikes::new);

    @Override
    protected void appendProperties(StateManager.Builder<Block, BlockState> builder) {
        builder.add(Properties.FACING);
    }

    @Override
    protected MapCodec<? extends Spikes> getCodec() {
        return CODEC;
    }

    public Spikes(Settings settings) {
        super(settings);
    }

    public void onEntityCollision(BlockState state, World world, BlockPos pos, Entity entity) {
        if (entity instanceof LivingEntity && world instanceof ServerWorld) {
            LivingEntity ent = (LivingEntity) entity;
            ServerWorld w1 = (ServerWorld) world;

            if (!ent.isInCreativeMode()) {
                if (Helpers.isIntersect(world, ent, state, pos)) {
                    ent.kill(w1);
                }
            }
        }
    }

    public VoxelShape getOutlineShape(BlockState state, BlockView view, BlockPos pos, ShapeContext context) {
        Direction dir = state.get(FACING);
        return Helpers.Facing(dir, minX, minY, minZ, maxX, maxY, maxZ);
    }
    @Override
    public BlockState getPlacementState(ItemPlacementContext ctx) {
        return super.getPlacementState(ctx).with(Properties.FACING, ctx.getSide());
    }
}
