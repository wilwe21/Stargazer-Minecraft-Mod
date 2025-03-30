package com.github.wilwe21.stargazer.block.clases.bonsai;

import com.mojang.serialization.MapCodec;
import net.minecraft.block.Block;
import net.minecraft.block.BlockState;
import net.minecraft.block.FacingBlock;
import net.minecraft.item.ItemPlacementContext;
import net.minecraft.server.world.ServerWorld;
import net.minecraft.state.StateManager;
import net.minecraft.state.property.BooleanProperty;
import net.minecraft.state.property.Properties;
import net.minecraft.util.math.BlockPos;
import net.minecraft.util.math.random.Random;

public class BonsaiLog extends FacingBlock {
    public BooleanProperty NATURAL = BooleanProperty.of("natural");
    @Override
    protected MapCodec<? extends FacingBlock> getCodec() {
        return null;
    }

    public BonsaiLog(Settings settings) {
        super(settings);
        this.setDefaultState(this.getDefaultState().with(NATURAL, true));
    }

    @Override
    protected void randomTick(BlockState state, ServerWorld world, BlockPos pos, Random random) {
//        if (state.get(NATURAL) && random.nextInt(15) == 0) {
//            world.setBlockState(pos.up(1), state);
//        }
        super.randomTick(state, world, pos, random);
    }

    @Override
    protected void appendProperties(StateManager.Builder<Block, BlockState> builder) {
        builder.add(Properties.AXIS);
        builder.add(NATURAL);
    }

    @Override
    public BlockState getPlacementState(ItemPlacementContext ctx) {
        return super.getPlacementState(ctx).with(Properties.AXIS, ctx.getSide().getAxis());
    }
}
