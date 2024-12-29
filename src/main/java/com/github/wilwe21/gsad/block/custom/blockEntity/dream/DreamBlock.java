package com.github.wilwe21.gsad.block.custom.blockEntity.dream;

import com.mojang.serialization.MapCodec;
import net.minecraft.block.BlockState;
import net.minecraft.block.BlockWithEntity;
import net.minecraft.block.entity.BlockEntity;
import net.minecraft.client.network.ClientPlayerEntity;
import net.minecraft.entity.Entity;
import net.minecraft.util.math.BlockPos;
import net.minecraft.util.math.Vec3d;
import net.minecraft.world.World;

public class DreamBlock extends BlockWithEntity {

//    public static final BooleanProperty UP = BooleanProperty.of("up");
//    public static final BooleanProperty DOWN = BooleanProperty.of("down");
//    public static final BooleanProperty NORTH = BooleanProperty.of("north");
//    public static final BooleanProperty SOUTH = BooleanProperty.of("south");
//    public static final BooleanProperty EAST = BooleanProperty.of("east");
//    public static final BooleanProperty WEST = BooleanProperty.of("west");

    @Override
    protected MapCodec<? extends DreamBlock> getCodec() {
        return createCodec(DreamBlock::new);
    }

//    @Override
//    protected void appendProperties(StateManager.Builder<Block, BlockState> builder) {
//        builder.add(UP);
//        builder.add(DOWN);
//        builder.add(NORTH);
//        builder.add(SOUTH);
//        builder.add(EAST);
//        builder.add(WEST);
//    }

    @Override
    public BlockEntity createBlockEntity(BlockPos pos, BlockState state) {
        return new DreamBlockEntity(pos, state);
    }

    public DreamBlock(Settings settings) {
        super(settings);

//        setDefaultState(getDefaultState().with(UP, false));
//        setDefaultState(getDefaultState().with(DOWN, false));
//        setDefaultState(getDefaultState().with(NORTH, false));
//        setDefaultState(getDefaultState().with(SOUTH, false));
//        setDefaultState(getDefaultState().with(EAST, false));
//        setDefaultState(getDefaultState().with(WEST, false));
    }

    public static Vec3d lookAngle = null;

    @Override
    public void onEntityCollision(BlockState state, World world, BlockPos pos, Entity entity) {
//        entity.resetFallDistance();
        if (entity instanceof ClientPlayerEntity player) {
//            ClientDash.refresh(player);
            lookAngle = player.getRotationVector();

            // if player hits a wall while inside dream blocks, make them bounce
            // Vec3 movement = player.getDeltaMovement();
            // if (movement.x() == 0 && lookAngle.x() != 0) lookAngle = lookAngle.multiply(-1, 1, 1);
            // if (movement.y() == 0 && lookAngle.y() != 0) lookAngle = lookAngle.multiply(1, -1, 1);
            // if (movement.z() == 0 && lookAngle.z() != 0) lookAngle = lookAngle.multiply(1, 1, -1);

            player.setVelocity(lookAngle);
        }
    }

    public static int getLuminance(BlockState currentBlockState) {
        return 15;
    }
}
