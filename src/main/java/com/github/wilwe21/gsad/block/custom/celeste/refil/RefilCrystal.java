package com.github.wilwe21.gsad.block.custom.celeste.refil;

import com.github.wilwe21.gsad.Helpers;
import com.github.wilwe21.gsad.dash.DashClient;
import com.mojang.serialization.MapCodec;
import net.minecraft.block.Block;
import net.minecraft.block.BlockState;
import net.minecraft.block.BlockWithEntity;
import net.minecraft.block.ShapeContext;
import net.minecraft.block.entity.BlockEntity;
import net.minecraft.client.network.ClientPlayerEntity;
import net.minecraft.entity.Entity;
import net.minecraft.state.StateManager;
import net.minecraft.state.property.BooleanProperty;
import net.minecraft.util.math.BlockPos;
import net.minecraft.util.shape.VoxelShape;
import net.minecraft.util.shape.VoxelShapes;
import net.minecraft.world.BlockView;
import net.minecraft.world.World;
import org.jetbrains.annotations.Nullable;

public class RefilCrystal extends BlockWithEntity {
    public static final BooleanProperty ACTIVATED = BooleanProperty.of("activated");

    @Override
    protected void appendProperties(StateManager.Builder<Block, BlockState> builder) {
        builder.add(ACTIVATED);
    }

    public RefilCrystal(Settings settings) {
        super(settings);

        setDefaultState(getDefaultState().with(ACTIVATED, true));
    }

    @Override
    protected MapCodec<? extends BlockWithEntity> getCodec() {
        return null;
    }

    @Override
    public void onEntityCollision(BlockState state, World world, BlockPos pos, Entity entity) {
        if (entity instanceof ClientPlayerEntity pl) {
            if (Helpers.isIntersectSolid(world, pl, state, pos)) {
                boolean active = state.get(ACTIVATED);
                if (active) {
                    DashClient.refresh(pl);
                    world.setBlockState(pos, state.with(ACTIVATED, false));
                    if (world.getBlockEntity(pos) instanceof RefilCrystalEntity rce) {
                        rce.active = false;
                    }
                }
            }
        }
    }

    @Override
    public VoxelShape getOutlineShape(BlockState state, BlockView view, BlockPos pos, ShapeContext context) {
        return VoxelShapes.cuboid(0.25, 0.25, 0.25, 0.75, 0.75, 0.75);
    }

    @Override
    public @Nullable BlockEntity createBlockEntity(BlockPos pos, BlockState state) {
        return new RefilCrystalEntity(pos, state);
    }
}
