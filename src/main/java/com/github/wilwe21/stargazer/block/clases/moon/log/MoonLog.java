package com.github.wilwe21.stargazer.block.clases.moon.log;

import com.github.wilwe21.stargazer.Stargazer;
import com.github.wilwe21.stargazer.block.register.MoonBlocks;
import com.github.wilwe21.stargazer.sound.SoundEffects;
import com.mojang.serialization.MapCodec;
import net.minecraft.advancement.criterion.Criteria;
import net.minecraft.block.Block;
import net.minecraft.block.BlockState;
import net.minecraft.block.Blocks;
import net.minecraft.block.FacingBlock;
import net.minecraft.entity.LivingEntity;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.item.ItemPlacementContext;
import net.minecraft.item.ItemStack;
import net.minecraft.item.Items;
import net.minecraft.registry.tag.ItemTags;
import net.minecraft.registry.tag.TagKey;
import net.minecraft.server.network.ServerPlayerEntity;
import net.minecraft.sound.SoundCategory;
import net.minecraft.sound.SoundEvent;
import net.minecraft.sound.SoundEvents;
import net.minecraft.state.StateManager;
import net.minecraft.state.property.Properties;
import net.minecraft.util.ActionResult;
import net.minecraft.util.Hand;
import net.minecraft.util.Identifier;
import net.minecraft.util.hit.BlockHitResult;
import net.minecraft.util.math.BlockPos;
import net.minecraft.util.math.Direction;
import net.minecraft.world.World;
import net.minecraft.world.event.GameEvent;

public class MoonLog extends FacingBlock {
    @Override
    protected MapCodec<? extends FacingBlock> getCodec() {
        return null;
    }

    @Override
    protected ActionResult onUseWithItem(ItemStack stack, BlockState state, World world, BlockPos pos, PlayerEntity player, Hand hand, BlockHitResult hit) {
        if (stack.streamTags().toList().contains(ItemTags.AXES)) {
            BlockState newState = MoonBlocks.STRIPPED_MOON_LOG.getDefaultState().with(Properties.AXIS, state.get(Properties.AXIS));
            world.playSound(player, pos, SoundEvents.ITEM_AXE_STRIP, SoundCategory.BLOCKS, 1.0F, 1.0F);
            if (player instanceof ServerPlayerEntity) {
                Criteria.ITEM_USED_ON_BLOCK.trigger((ServerPlayerEntity)player, pos, stack);
            }
            world.setBlockState(pos, newState, Block.NOTIFY_ALL_AND_REDRAW);
            world.emitGameEvent(GameEvent.BLOCK_CHANGE, pos, GameEvent.Emitter.of(player, newState));
            if (player != null) {
                if (!player.isInCreativeMode() && stack.isDamageable()) {
                    stack.damage(1, player);
                }
            }
            return ActionResult.SUCCESS;
        } else {
            return ActionResult.PASS;
        }
    }

    public MoonLog(Settings settings) {
        super(settings);
        this.setDefaultState(this.getDefaultState().with(Properties.AXIS, Direction.Axis.Y));
    }

    @Override
    protected void appendProperties(StateManager.Builder<Block, BlockState> builder) {
        builder.add(Properties.AXIS);
    }

    @Override
    public BlockState getPlacementState(ItemPlacementContext ctx) {
        return super.getPlacementState(ctx).with(Properties.AXIS, ctx.getSide().getAxis());
    }
}
