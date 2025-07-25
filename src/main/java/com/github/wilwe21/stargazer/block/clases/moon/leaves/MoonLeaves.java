package com.github.wilwe21.stargazer.block.clases.moon.leaves;

import com.github.wilwe21.stargazer.block.clases.CustomLeaves;
import com.github.wilwe21.stargazer.block.clases.moon.geode_fruit.GeodeFruit;
import com.github.wilwe21.stargazer.block.clases.moon.geode_fruit.GeodeFruitStage;
import com.github.wilwe21.stargazer.block.register.MoonBlocks;
import com.mojang.serialization.MapCodec;
import net.minecraft.block.BlockState;
import net.minecraft.block.Blocks;
import net.minecraft.block.LeavesBlock;
import net.minecraft.block.TintedParticleLeavesBlock;
import net.minecraft.particle.EntityEffectParticleEffect;
import net.minecraft.particle.ParticleTypes;
import net.minecraft.particle.ParticleUtil;
import net.minecraft.server.world.ServerWorld;
import net.minecraft.state.property.Properties;
import net.minecraft.util.Colors;
import net.minecraft.util.math.BlockPos;
import net.minecraft.util.math.Direction;
import net.minecraft.util.math.random.Random;
import net.minecraft.world.BlockRenderView;
import net.minecraft.world.World;
import org.jetbrains.annotations.Nullable;

public class MoonLeaves extends CustomLeaves {
    public MoonLeaves(int tin, Settings settings) {
        super(tin, settings);
    }

    @Override
    protected boolean hasRandomTicks(BlockState state) {
        return !state.get(Properties.PERSISTENT);
    }

    @Override
    protected void randomTick(BlockState state, ServerWorld world, BlockPos pos, Random random) {
        if (state.get(DISTANCE) == 7) {
            super.randomTick(state, world, pos, random);
        } else {
            if (world.getBlockState(pos.down()).isAir() && random.nextInt(45) == 0) {
                world.setBlockState(pos.down(), MoonBlocks.GEODE_FRUIT.getDefaultState().with(GeodeFruit.STAGE, GeodeFruitStage.start).with(GeodeFruit.FACING, GeodeFruit.FACING.getValues().get(random.nextBetween(0, GeodeFruit.FACING.getValues().size() - 1))));
            }
        }
    }
}
