package com.github.wilwe21.gsad.block.custom.blockEntity.dream;

import com.github.wilwe21.gsad.Gsad;
import com.github.wilwe21.gsad.block.ModBlock;
import com.github.wilwe21.gsad.dash.Dash;
import com.github.wilwe21.gsad.dash.DashClient;
import com.github.wilwe21.gsad.item.ModItems;
import com.mojang.serialization.MapCodec;
import net.minecraft.block.BlockState;
import net.minecraft.block.BlockWithEntity;
import net.minecraft.block.ShapeContext;
import net.minecraft.block.entity.BlockEntity;
import net.minecraft.client.network.ClientPlayerEntity;
import net.minecraft.entity.Entity;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.recipe.book.RecipeCategory;
import net.minecraft.util.math.BlockPos;
import net.minecraft.util.math.Vec3d;
import net.minecraft.util.shape.VoxelShape;
import net.minecraft.util.shape.VoxelShapes;
import net.minecraft.world.BlockView;
import net.minecraft.world.World;

public class DreamBlock extends BlockWithEntity {
    public boolean SOLID = true;
    public static boolean MULTI = false;

    @Override
    protected MapCodec<? extends DreamBlock> getCodec() {
        return createCodec(DreamBlock::new);
    }

    @Override
    public BlockEntity createBlockEntity(BlockPos pos, BlockState state) {
        return new DreamBlockEntity(pos, state);
    }

    public DreamBlock(Settings settings) {
        super(settings);
    }

    public static Vec3d lookDir = null;

    @Override
    protected void onEntityCollision(BlockState state, World world, BlockPos pos, Entity entity) {
        if (entity instanceof PlayerEntity pl) {
            if (!MULTI) {
                lookDir = null;
            }
            if (Dash.isPlayerDashing(pl.getUuid()) || MULTI) {
                if (lookDir == null) {
                    lookDir = pl.getRotationVector();
                }
                pl.setVelocity(lookDir.multiply(DashClient.DASH_SPEED));
                SOLID = false;
                MULTI = true;
            } else {
                SOLID = true;
            }
        }

    }

    public static int getLuminance(BlockState currentBlockState) {
        return 15;
    }

    public VoxelShape getOutlineShape(BlockState state, BlockView view, BlockPos pos, ShapeContext context) {
        if (SOLID) {
            return VoxelShapes.cuboid(0.01, 0.01, 0.01, 0.99, 0.99, 0.99);
        } else {
            return VoxelShapes.empty();
        }
    }
}
