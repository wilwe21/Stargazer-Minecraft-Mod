package com.github.wilwe21.gsad.block.custom.random.negative;

import com.github.wilwe21.gsad.Helpers;
import com.github.wilwe21.gsad.dash.Dash;
import com.github.wilwe21.gsad.dash.DashClient;
import com.mojang.serialization.MapCodec;
import net.minecraft.block.*;
import net.minecraft.block.entity.BlockEntity;
import net.minecraft.entity.Entity;
import net.minecraft.entity.LivingEntity;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.util.math.BlockPos;
import net.minecraft.util.math.Box;
import net.minecraft.util.shape.VoxelShape;
import net.minecraft.util.shape.VoxelShapes;
import net.minecraft.world.BlockView;
import net.minecraft.world.World;

public class NegativeBlock extends BlockWithEntity {
    public boolean SOLID = true;
    @Override
    protected MapCodec<? extends NegativeBlock> getCodec() {
        return createCodec(NegativeBlock::new);
    }

    @Override
    public BlockEntity createBlockEntity(BlockPos pos, BlockState state) {
        return new NegativeBlockEntity(pos, state);
    }

    @Override
    protected void onEntityCollision(BlockState state, World world, BlockPos pos, Entity entity) {
        if (entity instanceof PlayerEntity pl) {
            LivingEntity ent = (LivingEntity) pl;
            Box shape = VoxelShapes.cuboid(0.09, 0.09, 0.09, 0.91, 0.91, 0.91).getBoundingBox();
            if (!(Helpers.isIntersectCustom(ent, pos, shape))) {
                SOLID = true;
            } else {
                SOLID = false;
            }
        }
    }

    @Override
    public VoxelShape getOutlineShape(BlockState state, BlockView view, BlockPos pos, ShapeContext context) {
        if (SOLID) {
            return VoxelShapes.fullCube();
        } else {
            return VoxelShapes.empty();
        }
    }

    public NegativeBlock(Settings settings) {
        super(settings);
    }
}
