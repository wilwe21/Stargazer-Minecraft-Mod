package com.github.wilwe21.gsad.block.custom;

import com.github.wilwe21.gsad.Gsad;
import com.github.wilwe21.gsad.Helpers;
import com.mojang.serialization.MapCodec;
import net.minecraft.block.*;
import net.minecraft.entity.Entity;
import net.minecraft.entity.LivingEntity;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.item.ItemPlacementContext;
import net.minecraft.sound.SoundCategory;
import net.minecraft.sound.SoundEvents;
import net.minecraft.state.StateManager;
import net.minecraft.state.property.BooleanProperty;
import net.minecraft.state.property.Properties;
import net.minecraft.util.ActionResult;
import net.minecraft.util.hit.BlockHitResult;
import net.minecraft.util.math.BlockPos;
import net.minecraft.util.math.Direction;
import net.minecraft.util.shape.VoxelShape;
import net.minecraft.world.BlockView;
import net.minecraft.world.World;

public class Spring extends FacingBlock {
    public static final float minX = 0.1f;
    public static final float minY = 0f;
    public static final float minZ = 0.1f;
    public static final float maxX = 0.9f;
    public static final float maxY = 0.15f;
    public static final float maxZ = 0.9f;
    public static final float aMinX = 0.1f;
    public static final float aMinY = 0f;
    public static final float aMinZ = 0.1f;
    public static final float aMaxX = 0.9f;
    public static final float aMaxY = 0.2f;
    public static final float aMaxZ = 0.9f;

    public static final float strength = 1.0f;

    public static final MapCodec<Spring> CODEC = Block.createCodec(Spring::new);

    public static final BooleanProperty ACTIVATED = BooleanProperty.of("activated");

    @Override
    protected void appendProperties(StateManager.Builder<Block, BlockState> builder) {
        builder.add(ACTIVATED);
        builder.add(Properties.FACING);
    }

    public Spring(AbstractBlock.Settings settings) {
        super(settings);

        setDefaultState(getDefaultState().with(ACTIVATED, false));
    }

    @Override
    protected MapCodec<? extends Spring> getCodec() {
        return CODEC;
    }

    @Override
    protected ActionResult onUse(BlockState state, World world, BlockPos pos, PlayerEntity player, BlockHitResult hit) {
        if (!player.getAbilities().allowModifyWorld) {
            return ActionResult.PASS;
        } else {
            boolean active = state.get(ACTIVATED);

            if (active) {
                world.setBlockState(pos, state.with(ACTIVATED, !active));
            }

            return ActionResult.SUCCESS;
        }
    }

    @Override
    public void onEntityCollision(BlockState state, World world, BlockPos pos, Entity entity) {
        if (entity instanceof LivingEntity) {
            LivingEntity ent = (LivingEntity) entity;
            if (Helpers.isIntersectSolid(world, ent, state, pos)) {
                boolean active = state.get(ACTIVATED);
                if (!active) {
                    int x = pos.getX();
                    int y = pos.getY();
                    int z = pos.getZ();
                    world.playSound(entity, pos, SoundEvents.ENTITY_SLIME_JUMP_SMALL, SoundCategory.BLOCKS, 1.0F, 1.0F);
                    Direction dir = state.get(FACING);
                    switch (dir) {
                        case DOWN -> ent.setVelocity(entity.getVelocity().x, -strength, entity.getVelocity().z);
                        case EAST -> ent.setVelocity(strength, entity.getVelocity().y+0.3, entity.getVelocity().z);
                        case WEST -> ent.setVelocity(-strength, entity.getVelocity().y+0.3, entity.getVelocity().z);
                        case SOUTH -> ent.setVelocity(entity.getVelocity().x, entity.getVelocity().y+0.3, strength);
                        case NORTH -> ent.setVelocity(entity.getVelocity().x, entity.getVelocity().y+0.3, -strength);
                        default -> ent.setVelocity(entity.getVelocity().x, strength, entity.getVelocity().z);
                    }
                    BlockPos pos2 = new BlockPos(x,y,z);
                    try {
                        new Thread(() -> {
                            try {
                                Thread.sleep(50);
                            } catch (Exception e) {
                                Gsad.LOGGER.error(e.toString());
                            }
                            try {
                                if (world.getBlockState(pos2).getBlock() instanceof Spring) {
                                    world.setBlockState(pos2, state.with(ACTIVATED, true));
                                }
                            } catch (Exception e) {
                                Gsad.LOGGER.error(e.toString());
                            }
                        }).start();
                    } catch (Exception e) {
                        Gsad.LOGGER.error(e.toString());
                    }
                    try {
                        new Thread(() -> {
                            try {
                                Thread.sleep(1500);
                            } catch (Exception e) {
                                Gsad.LOGGER.error(e.toString());
                            }
                            try {
                                if (world.getBlockState(pos2).getBlock() instanceof Spring) {
                                    world.setBlockState(pos2, state.with(ACTIVATED, false));
                                }
                            } catch (Exception e) {
                                Gsad.LOGGER.error(e.toString());
                            }
                        }).start();
                    } catch (Exception e) {
                        Gsad.LOGGER.error(e.toString());
                    }
                }
            }
        }
    }

    @Override
    public VoxelShape getOutlineShape(BlockState state, BlockView view, BlockPos pos, ShapeContext context) {
        Direction dir = state.get(FACING);
        if (!state.get(ACTIVATED)) {
            return Helpers.Facing(dir, minX, minY, minZ, maxX, maxY, maxZ);
        } else {
            return Helpers.Facing(dir, aMinX, aMinY, aMinZ, aMaxX, aMaxY, aMaxZ);
        }
    }
    @Override
    public BlockState getPlacementState(ItemPlacementContext ctx) {
        return super.getPlacementState(ctx).with(Properties.FACING, ctx.getSide());
    }
}
