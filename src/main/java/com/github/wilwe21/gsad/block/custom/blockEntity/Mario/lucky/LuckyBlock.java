package com.github.wilwe21.gsad.block.custom.blockEntity.Mario.lucky;

import com.github.wilwe21.gsad.dash.Dash;
import com.github.wilwe21.gsad.dash.DashClient;
import com.mojang.serialization.MapCodec;
import net.minecraft.block.BlockState;
import net.minecraft.block.BlockWithEntity;
import net.minecraft.block.ShapeContext;
import net.minecraft.block.entity.BlockEntity;
import net.minecraft.entity.Entity;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.util.math.BlockPos;
import net.minecraft.util.math.Vec3d;
import net.minecraft.util.shape.VoxelShape;
import net.minecraft.util.shape.VoxelShapes;
import net.minecraft.world.BlockView;
import net.minecraft.world.World;

public class LuckyBlock extends BlockWithEntity {
    public boolean SOLID = true;

    @Override
    protected MapCodec<? extends LuckyBlock> getCodec() {
        return createCodec(LuckyBlock::new);
    }

    @Override
    public BlockEntity createBlockEntity(BlockPos pos, BlockState state) {
        return new LuckyBlockEntity(pos, state);
    }

    public LuckyBlock(Settings settings) {
        super(settings);
    }

    public static Vec3d lookDir = null;

    @Override
    protected void onEntityCollision(BlockState state, World world, BlockPos pos, Entity entity) {
        if (entity instanceof PlayerEntity pl) {
            if (Dash.isPlayerDashing(pl.getUuid())) {
                if (lookDir == null) {
                    lookDir = pl.getRotationVector();
                }
                pl.setVelocity(lookDir.multiply(DashClient.DASH_SPEED));
                SOLID = false;
            } else {
                SOLID = true;
            }
        }

    }

    public VoxelShape getOutlineShape(BlockState state, BlockView view, BlockPos pos, ShapeContext context) {
        if (SOLID) {
            return VoxelShapes.cuboid(0.01, 0.01, 0.01, 0.99, 0.99, 0.99);
        } else {
            return VoxelShapes.empty();
        }
    }
}
