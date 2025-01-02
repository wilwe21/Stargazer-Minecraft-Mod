package com.github.wilwe21.gsad.block.custom.blockEntity.Mario.empty;

import com.github.wilwe21.gsad.Gsad;
import com.github.wilwe21.gsad.block.ModBlock;
import com.github.wilwe21.gsad.block.custom.blockEntity.Mario.lucky.LuckyBlockEntity;
import com.mojang.serialization.MapCodec;
import net.minecraft.block.Block;
import net.minecraft.block.BlockState;
import net.minecraft.block.entity.BlockEntity;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.item.Items;
import net.minecraft.util.ActionResult;
import net.minecraft.util.collection.DefaultedList;
import net.minecraft.util.hit.BlockHitResult;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.World;

import java.util.Stack;

public class EmptyBlock extends Block {
    public static final MapCodec<EmptyBlock> CODEC = createCodec(EmptyBlock::new);

    @Override
    public MapCodec<EmptyBlock> getCodec() {
        return CODEC;
    }

    public EmptyBlock(Settings settings) {
        super(settings);
    }

    @Override
    protected ActionResult onUse(BlockState state, World world, BlockPos pos, PlayerEntity player, BlockHitResult hit) {
        ItemStack stack = player.getStackInHand(player.getActiveHand());
        Item item = stack.getItem();

        if (item != Items.AIR) {
            if (!player.isCreative()) {
                stack.decrement(1);
            }
            world.setBlockState(pos, ModBlock.LUCKY_BLOCK.getDefaultState());
            BlockEntity be = world.getBlockEntity(pos);
            if (be instanceof LuckyBlockEntity lbe) {
                lbe.setNbtType("item");
                lbe.setNbtItems(DefaultedList.ofSize(1, stack));
            }

        }
        return ActionResult.SUCCESS;
    }
}
