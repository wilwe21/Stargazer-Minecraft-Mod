package com.github.wilwe21.stargazer.block.clases.moon.plants;

import com.github.wilwe21.stargazer.block.clases.moon.MoonFarmland;
import com.github.wilwe21.stargazer.block.register.Crops;
import com.github.wilwe21.stargazer.block.register.MoonBlocks;
import com.mojang.serialization.MapCodec;
import net.minecraft.block.*;
import net.minecraft.entity.Entity;
import net.minecraft.entity.EntityCollisionHandler;
import net.minecraft.entity.mob.RavagerEntity;
import net.minecraft.item.Item;
import net.minecraft.item.ItemConvertible;
import net.minecraft.item.ItemStack;
import net.minecraft.item.Items;
import net.minecraft.server.world.ServerWorld;
import net.minecraft.state.StateManager;
import net.minecraft.state.property.IntProperty;
import net.minecraft.state.property.Properties;
import net.minecraft.util.math.BlockPos;
import net.minecraft.util.math.MathHelper;
import net.minecraft.util.math.random.Random;
import net.minecraft.util.shape.VoxelShape;
import net.minecraft.world.BlockView;
import net.minecraft.world.GameRules;
import net.minecraft.world.World;
import net.minecraft.world.WorldView;
import org.jetbrains.annotations.Nullable;

import java.util.ArrayList;
import java.util.List;

public class MoonCrop
        extends PlantBlock
        implements Fertilizable {
    public static final MapCodec<MoonCrop> CODEC = MoonCrop.createCodec(MoonCrop::new);
    public static final int MAX_AGE = 7;
    public static final IntProperty AGE = Properties.AGE_7;
    private static final VoxelShape[] SHAPES_BY_AGE = Block.createShapeArray(7, age -> Block.createColumnShape(16.0, 0.0, 2 + age * 2));

    @Nullable
    public Block giantCrop = null;

    public MapCodec<? extends MoonCrop> getCodec() {
        return CODEC;
    }


    public MoonCrop(AbstractBlock.Settings settings) {
        super(settings);
        this.setDefaultState((BlockState)((BlockState)this.stateManager.getDefaultState()).with(this.getAgeProperty(), 0));
    }

    public MoonCrop(AbstractBlock.Settings settings, Block crop) {
        super(settings);
        this.setDefaultState((BlockState)((BlockState)this.stateManager.getDefaultState()).with(this.getAgeProperty(), 0));
        this.giantCrop = crop;
    }

    @Override
    protected VoxelShape getOutlineShape(BlockState state, BlockView world, BlockPos pos, ShapeContext context) {
        return SHAPES_BY_AGE[this.getAge(state)];
    }


    @Override
    protected boolean canPlantOnTop(BlockState floor, BlockView world, BlockPos pos) {
        return floor.isOf(Blocks.FARMLAND);
    }

    protected IntProperty getAgeProperty() {
        return AGE;
    }

    public int getMaxAge() {
        return 7;
    }

    public int getAge(BlockState state) {
        return state.get(this.getAgeProperty());
    }

    public BlockState withAge(int age) {
        return (BlockState)this.getDefaultState().with(this.getAgeProperty(), age);
    }

    public final boolean isMature(BlockState state) {
        return this.getAge(state) >= this.getMaxAge();
    }

    @Override
    protected boolean hasRandomTicks(BlockState state) {
        return !this.isMature(state);
    }

    @Override
    protected void randomTick(BlockState state, ServerWorld world, BlockPos pos, Random random) {
        float f;
        int i;
        if (world.getBaseLightLevel(pos, 0) >= 9 && (i = this.getAge(state)) < this.getMaxAge() && random.nextInt((int)(25.0f / (f = MoonCrop.getAvailableMoisture(this, world, pos))) + 1) == 0) {
            world.setBlockState(pos, this.withAge(i + 1), Block.NOTIFY_LISTENERS);
        }
    }

    public void applyGrowth(World world, BlockPos pos, BlockState state) {
        int i = Math.min(this.getMaxAge(), this.getAge(state) + this.getGrowthAmount(world));
        world.setBlockState(pos, this.withAge(i), Block.NOTIFY_LISTENERS);

        if (state.get(AGE).equals(this.getMaxAge()) && giantCrop != null) {
            List<Boolean> list = new ArrayList<>();
            for (BlockPos blockPos : BlockPos.iterate(pos, pos.add(1, 0, 1))) {
                if (world.getBlockState(blockPos).equals(this.getDefaultState().with(AGE, this.getMaxAge())) && world.getBlockState(blockPos.up()).getBlock().equals(Blocks.AIR)) {
                    list.add(true);
                }
            }
            if (list.size() == 4) {
                GiantDragonCarrot.place(world, pos, giantCrop.getDefaultState().with(GiantCrop.SIDE, GiantCropSide.nwd));
                return;
            } else {
                list = new ArrayList<>();
            }
            for (BlockPos blockPos : BlockPos.iterate(pos, pos.add(-1, 0, -1))) {
                if (world.getBlockState(blockPos).equals(this.getDefaultState().with(AGE, this.getMaxAge())) && world.getBlockState(blockPos.up()).getBlock().equals(Blocks.AIR)) {
                    list.add(true);
                }
            }
            if (list.size() == 4) {
                GiantCrop.place(world, pos, giantCrop.getDefaultState().with(GiantCrop.SIDE, GiantCropSide.sed));
                return;
            } else {
                list = new ArrayList<>();
            }
            for (BlockPos blockPos : BlockPos.iterate(pos, pos.add(1, 0, -1))) {
                if (world.getBlockState(blockPos).equals(this.getDefaultState().with(AGE, this.getMaxAge())) && world.getBlockState(blockPos.up()).getBlock().equals(Blocks.AIR)) {
                    list.add(true);
                }
            }
            if (list.size() == 4) {
                GiantCrop.place(world, pos, giantCrop.getDefaultState().with(GiantCrop.SIDE, GiantCropSide.swd));
                return;
            } else {
                list = new ArrayList<>();
            }
            for (BlockPos blockPos : BlockPos.iterate(pos, pos.add(-1, 0, 1))) {
                if (world.getBlockState(blockPos).equals(this.getDefaultState().with(AGE, this.getMaxAge())) && world.getBlockState(blockPos.up()).getBlock().equals(Blocks.AIR)) {
                    list.add(true);
                }
            }
            if (list.size() == 4) {
                GiantCrop.place(world, pos, giantCrop.getDefaultState().with(GiantCrop.SIDE, GiantCropSide.ned));
            }
        }
    }

    protected int getGrowthAmount(World world) {
        return MathHelper.nextInt(world.random, 2, 5);
    }

    protected static float getAvailableMoisture(Block block, World world, BlockPos pos) {
        boolean bl2;
        float f = 1.0f;
        BlockPos blockPos = pos.down();
        for (int i = -1; i <= 1; ++i) {
            for (int j = -1; j <= 1; ++j) {
                float g = 0.0f;
                BlockState blockState = world.getBlockState(blockPos.add(i, 0, j));
                if (blockState.isOf(MoonBlocks.MOON_FARMLAND)) {
                    g = 1.0f;
                    if (blockState.get(MoonFarmland.MOISTURE)) {
                        g = 3.0f;
                    }
                }
                if (i != 0 || j != 0) {
                    g /= 4.0f;
                }
                f += g;
            }
        }
        BlockPos blockPos2 = pos.north();
        BlockPos blockPos3 = pos.south();
        BlockPos blockPos4 = pos.west();
        BlockPos blockPos5 = pos.east();
        boolean bl = world.getBlockState(blockPos4).isOf(block) || world.getBlockState(blockPos5).isOf(block);
        boolean bl3 = bl2 = world.getBlockState(blockPos2).isOf(block) || world.getBlockState(blockPos3).isOf(block);
        if (bl && bl2) {
            f /= 2.0f;
        } else {
            boolean bl32;
            boolean bl4 = bl32 = world.getBlockState(blockPos4.north()).isOf(block) || world.getBlockState(blockPos5.north()).isOf(block) || world.getBlockState(blockPos5.south()).isOf(block) || world.getBlockState(blockPos4.south()).isOf(block);
            if (bl32) {
                f /= 2.0f;
            }
        }
        return f;
    }

    @Override
    protected boolean canPlaceAt(BlockState state, WorldView world, BlockPos pos) {
        return world.getBlockState(pos.down()).isOf(MoonBlocks.MOON_FARMLAND);
    }

    protected static boolean hasEnoughLightAt(WorldView world, BlockPos pos) {
        return world.getBaseLightLevel(pos, 0) >= 8;
    }

    @Override
    protected void onEntityCollision(BlockState state, World world, BlockPos pos, Entity entity, EntityCollisionHandler handler) {
        if (world instanceof ServerWorld) {
            ServerWorld serverWorld = (ServerWorld)world;
            if (entity instanceof RavagerEntity && serverWorld.getGameRules().getBoolean(GameRules.DO_MOB_GRIEFING)) {
                serverWorld.breakBlock(pos, true, entity);
            }
        }
        super.onEntityCollision(state, world, pos, entity, handler);
    }

    @Override
    public boolean isFertilizable(WorldView world, BlockPos pos, BlockState state) {
        return !this.isMature(state);
    }

    @Override
    public boolean canGrow(World world, net.minecraft.util.math.random.Random random, BlockPos pos, BlockState state) {
        return true;
    }

    @Override
    public void grow(ServerWorld world, net.minecraft.util.math.random.Random random, BlockPos pos, BlockState state) {
        this.applyGrowth(world, pos, state);
    }

    @Override
    protected void appendProperties(StateManager.Builder<Block, BlockState> builder) {
        builder.add(AGE);
    }
}