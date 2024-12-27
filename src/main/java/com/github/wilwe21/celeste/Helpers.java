package com.github.wilwe21.celeste;

import net.minecraft.block.BlockState;
import net.minecraft.entity.LivingEntity;
import net.minecraft.util.math.BlockPos;
import net.minecraft.util.math.Box;
import net.minecraft.util.math.Direction;
import net.minecraft.util.shape.VoxelShape;
import net.minecraft.util.shape.VoxelShapes;
import net.minecraft.world.BlockView;
import net.minecraft.world.World;

public class Helpers {
    public static VoxelShape getVox(LivingEntity entity, BlockPos pos) {
        Box entBox = entity.getBoundingBox();
        double enminX = entBox.minX - pos.getX();
        double enminY = entBox.minY - pos.getY();
        double enminZ = entBox.minZ - pos.getZ();
        double enmaxX = entBox.maxX - pos.getX();
        double enmaxY = entBox.maxY - pos.getY();
        double enmaxZ = entBox.maxZ - pos.getZ();
        return VoxelShapes.cuboid(enminX, enminY, enminZ, enmaxX, enmaxY, enmaxZ);
    }
    public static boolean isIntersect(World world, LivingEntity entity, BlockState state, BlockPos pos) {
        BlockView bw = (BlockView) world;
        VoxelShape entVox = Helpers.getVox(entity, pos);
        VoxelShape blockVox = state.getOutlineShape(bw, pos);

        Box bBox = blockVox.getBoundingBox();
        Box eBox = entVox.getBoundingBox();
        return bBox.intersects(eBox);
    }
    public static boolean isIntersectSolid(World world, LivingEntity entity, BlockState state, BlockPos pos) {
        BlockView bw = (BlockView) world;
        VoxelShape entVox = Helpers.getVox(entity, pos);
        VoxelShape blockVox = state.getOutlineShape(bw, pos);

        Box bhBox = blockVox.getBoundingBox();
        Box bBox = VoxelShapes.cuboid(bhBox.minX - 0.1, bhBox.minY - 0.1, bhBox.minZ - 0.1, bhBox.maxX + 0.1, bhBox.maxY + 0.1, bhBox.maxZ + 0.1).getBoundingBox();
        Box eBox = entVox.getBoundingBox();
        return bBox.intersects(eBox);
    }
    public static VoxelShape Facing(Direction dir, float minX, float minY, float minZ, float maxX, float maxY, float maxZ) {
        return switch (dir) {
            case DOWN -> VoxelShapes.cuboid(1-maxX, 1-maxY, 1-maxZ, 1-minX, 1-minY, 1-minZ);
            case EAST -> VoxelShapes.cuboid(minY, minX, minZ, maxY, maxX, maxZ);
            case WEST -> VoxelShapes.cuboid(1-maxY, 1-maxX, 1-maxZ, 1-minY, 1-minX, 1-minZ);
            case NORTH -> VoxelShapes.cuboid(1-maxZ, 1-maxX, 1-maxY, 1-minZ, 1-minX, 1-minY);
            case SOUTH -> VoxelShapes.cuboid(minZ, minX, minY, maxZ, maxX, maxY);
            default ->  VoxelShapes.cuboid(minX, minY, minZ, maxX, maxY, maxZ);
        };

    }
}
