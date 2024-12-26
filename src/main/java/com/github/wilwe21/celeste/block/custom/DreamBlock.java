package com.github.wilwe21.celeste.block.custom;

import net.minecraft.block.Block;
import net.minecraft.block.BlockState;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.state.StateManager;
import net.minecraft.state.property.BooleanProperty;
import net.minecraft.util.ActionResult;
import net.minecraft.util.hit.BlockHitResult;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.World;

public class DreamBlock extends Block {
    public static final BooleanProperty ACTIVATED = BooleanProperty.of("activated");

    @Override
    protected void appendProperties(StateManager.Builder<Block, BlockState> builder) {
        builder.add(ACTIVATED);
    }

    public DreamBlock(Settings settings) {
        super(settings);

        setDefaultState(getDefaultState().with(ACTIVATED, true));
    }

    @Override
    protected ActionResult onUse(BlockState state, World world, BlockPos pos, PlayerEntity player, BlockHitResult hit) {
        if (!player.getAbilities().allowModifyWorld) {
            return ActionResult.PASS;
        } else {
            boolean activated = state.get(ACTIVATED);

            world.setBlockState(pos, state.with(ACTIVATED, !activated));

            return ActionResult.SUCCESS;
        }
    }

    public static int getLuminance(BlockState currentBlockState) {
        boolean activated = currentBlockState.get(DreamBlock.ACTIVATED);

        return activated ? 15 : 0;
    }
}
