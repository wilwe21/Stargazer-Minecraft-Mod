package com.github.wilwe21.gsad.block.custom.blockEntity.Mario.lucky;

import com.github.wilwe21.gsad.block.ModBlock;
import com.mojang.serialization.MapCodec;
import net.minecraft.block.*;
import net.minecraft.block.entity.BlockEntity;
import net.minecraft.entity.Entity;
import net.minecraft.entity.ItemEntity;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.sound.SoundCategory;
import net.minecraft.sound.SoundEvents;
import net.minecraft.util.math.BlockPos;
import net.minecraft.util.shape.VoxelShape;
import net.minecraft.util.shape.VoxelShapes;
import net.minecraft.world.BlockView;
import net.minecraft.world.World;

public class LuckyBlock extends BlockWithEntity {
    public static final MapCodec<LuckyBlock> CODEC = createCodec(LuckyBlock::new);

    @Override
    public MapCodec<LuckyBlock> getCodec() {
        return CODEC;
    }

    @Override
    public BlockEntity createBlockEntity(BlockPos pos, BlockState state) {
        return new LuckyBlockEntity(pos, state);
    }

    public LuckyBlock(Settings settings) {
        super(settings);
    }

    @Override
    protected void onEntityCollision(BlockState state, World world, BlockPos pos, Entity entity) {
        if (entity instanceof PlayerEntity) {
            world.playSound(entity, pos, SoundEvents.BLOCK_AMETHYST_CLUSTER_BREAK, SoundCategory.BLOCKS, 1.0F, 1.0F);
            BlockEntity be = world.getBlockEntity(pos);
            world.setBlockState(pos, ModBlock.EMPTY_BLOCK.getDefaultState());
            if (be instanceof LuckyBlockEntity lbe) {
                if (lbe.TYPE.equals("item")) {
                    Item i = Item.byRawId(lbe.ITEM);
                    world.spawnEntity(new ItemEntity(world, pos.getX(), pos.getY() + 1, pos.getZ(), new ItemStack(i)));
                }
            }
        }

    }

    public VoxelShape getOutlineShape(BlockState state, BlockView view, BlockPos pos, ShapeContext context) {
        return VoxelShapes.cuboid(0.0, 0.01, 0.0, 1.0, 1.0, 1.0);
    }
}
