package com.github.wilwe21.stargazer.block.clases.teleporter;

import com.github.wilwe21.stargazer.CustomWorlds;
import com.github.wilwe21.stargazer.block.ModBlock;
import com.github.wilwe21.stargazer.block.register.MoonBlocks;
import net.minecraft.block.*;
import net.minecraft.entity.Entity;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.fluid.FluidState;
import net.minecraft.fluid.Fluids;
import net.minecraft.item.ItemPlacementContext;
import net.minecraft.network.packet.s2c.play.PositionFlag;
import net.minecraft.registry.RegistryKey;
import net.minecraft.server.world.ServerWorld;
import net.minecraft.state.StateManager;
import net.minecraft.state.property.BooleanProperty;
import net.minecraft.state.property.EnumProperty;
import net.minecraft.state.property.Properties;
import net.minecraft.util.ActionResult;
import net.minecraft.util.hit.BlockHitResult;
import net.minecraft.util.math.BlockPos;
import net.minecraft.util.math.Direction;
import net.minecraft.util.math.Vec3d;
import net.minecraft.util.math.random.Random;
import net.minecraft.util.shape.VoxelShape;
import net.minecraft.util.shape.VoxelShapes;
import net.minecraft.world.*;
import net.minecraft.world.border.WorldBorder;
import net.minecraft.world.tick.ScheduledTickView;
import org.jetbrains.annotations.Nullable;

import java.util.Map;

public class CopperTeleporter extends Block {
    public static VoxelShape MIDDLESHAPE = VoxelShapes.union(
            VoxelShapes.cuboid(0, 0, 0, 1, 1, 0.0625),
            VoxelShapes.cuboid(0, 0, 0.9375, 1, 1, 1),
            VoxelShapes.cuboid(0, 0, 0.0625, 0.0625, 1, 0.9375),
            VoxelShapes.cuboid(0.9375, 0, 0.0625, 1, 1, 0.9375),
            VoxelShapes.cuboid(0.0625, 0, 0.0625, 0.9375, 0.0625, 0.9375),
            VoxelShapes.cuboid(0.0625, 0.875, 0.0625, 0.9375, 0.9375, 0.9375),
            VoxelShapes.cuboid(0.0625, 0.9375, 0.8125, 0.1875, 1, 0.9375),
            VoxelShapes.cuboid(0.0625, 0.9375, 0.0625, 0.1875, 1, 0.1875),
            VoxelShapes.cuboid(0.8125, 0.9375, 0.0625, 0.9375, 1, 0.1875),
            VoxelShapes.cuboid(0.8125, 0.9375, 0.8125, 0.9375, 1, 0.9375)
    );
    public static VoxelShape CORNERSHAPE = VoxelShapes.union(
            VoxelShapes.cuboid(0, 0, 0, 1, 0.625, 1),
            VoxelShapes.cuboid(0.25, 0.625, 0, 1, 0.9375, 0.75)
    );
    public static VoxelShape SIDESHAPE = VoxelShapes.union(
            VoxelShapes.cuboid(0, 0, 0, 1, 0.3125, 1),
            VoxelShapes.cuboid(0, 0.3125, 0.3125, 1, 0.625, 1),
            VoxelShapes.cuboid(0, 0.625, 0.625, 1, 0.9375, 1)
    );
    public static VoxelShape CORNERTOPSHAPE = VoxelShapes.union(
            VoxelShapes.cuboid(0.6875, -0.0625, 0.1875, 0.8125, 0.875, 0.3125),
            VoxelShapes.cuboid(0.5, 0.875, 0, 1, 1, 0.5)
    );

    public static final EnumProperty<CopperTeleporterState> STATE = EnumProperty.of("state", CopperTeleporterState.class);
    public static final BooleanProperty WATERLOGGED = Properties.WATERLOGGED;

    public CopperTeleporter(Settings settings) {
        super(settings);
        this.setDefaultState(
                this.stateManager.getDefaultState().with(STATE, CopperTeleporterState.middle).with(WATERLOGGED, Boolean.FALSE)
        );
    }

    @Override
    public void onBroken(WorldAccess world, BlockPos pos, BlockState state) {
        if (state.get(STATE).equals(CopperTeleporterState.middle)) {
            breakPortal(world, pos);
        }
        if (state.get(STATE).equals(CopperTeleporterState.north)) {
            breakPortal(world, pos.south());
        }
        if (state.get(STATE).equals(CopperTeleporterState.south)) {
            breakPortal(world, pos.north());
        }
        if (state.get(STATE).equals(CopperTeleporterState.west)) {
            breakPortal(world, pos.east());
        }
        if (state.get(STATE).equals(CopperTeleporterState.east)) {
            breakPortal(world, pos.west());
        }
        if (state.get(STATE).equals(CopperTeleporterState.north_west)) {
            breakPortal(world, pos.south().east());
        }
        if (state.get(STATE).equals(CopperTeleporterState.north_east)) {
            breakPortal(world, pos.south().west());
        }
        if (state.get(STATE).equals(CopperTeleporterState.south_west)) {
            breakPortal(world, pos.north().east());
        }
        if (state.get(STATE).equals(CopperTeleporterState.south_east)) {
            breakPortal(world, pos.north().west());
        }
        if (state.get(STATE).equals(CopperTeleporterState.ne_up)) {
            breakPortal(world, pos.south().west().down());
        }
        if (state.get(STATE).equals(CopperTeleporterState.nw_up)) {
            breakPortal(world, pos.south().east().down());
        }
        if (state.get(STATE).equals(CopperTeleporterState.se_up)) {
            breakPortal(world, pos.north().west().down());
        }
        if (state.get(STATE).equals(CopperTeleporterState.sw_up)) {
            breakPortal(world, pos.north().east().down());
        }
        super.onBroken(world, pos, state);
    }

    public void breakPortal(WorldAccess world, BlockPos root) {
        world.breakBlock(root, false);
        world.breakBlock(root.north(), false);
        world.breakBlock(root.south(), false);
        world.breakBlock(root.west(), false);
        world.breakBlock(root.east(), false);
        world.breakBlock(root.north().west(), false);
        world.breakBlock(root.north().east(), false);
        world.breakBlock(root.south().west(), false);
        world.breakBlock(root.south().east(), false);
        world.breakBlock(root.north().west().up(), false);
        world.breakBlock(root.north().east().up(), false);
        world.breakBlock(root.south().west().up(), false);
        world.breakBlock(root.south().east().up(), false);
    }

    @Override
    protected BlockState getStateForNeighborUpdate(
            BlockState state,
            WorldView world,
            ScheduledTickView tickView,
            BlockPos pos,
            Direction direction,
            BlockPos neighborPos,
            BlockState neighborState,
            Random random
    ) {
        if ((Boolean)state.get(WATERLOGGED)) {
            tickView.scheduleFluidTick(pos, Fluids.WATER, Fluids.WATER.getTickRate(world));
        }

        return state;
    }

    @Override
    protected ActionResult onUse(BlockState state, World world, BlockPos pos, PlayerEntity player, BlockHitResult hit) {
        if (state.get(STATE).equals(CopperTeleporterState.middle)) {
            if (world instanceof ServerWorld sw) {
                TeleportTarget target = createTeleportTarget(sw, player, pos);
                player.teleportTo(target);
            }
        }
        return ActionResult.PASS;
    }

    @Nullable
    public TeleportTarget createTeleportTarget(ServerWorld world, Entity entity, BlockPos pos) {
        RegistryKey<World> registryKey = world.getRegistryKey() == CustomWorlds.COSMIC ? World.OVERWORLD : CustomWorlds.COSMIC;
        ServerWorld serverWorld = world.getServer().getWorld(registryKey);
        if (serverWorld == null) {
            return null;
        }
        WorldBorder worldBorder = serverWorld.getWorldBorder();
        return this.getOrCreateExitPortalTarget(serverWorld, entity, pos, worldBorder);
    }

    private TeleportTarget getOrCreateExitPortalTarget(ServerWorld world, Entity entity2, BlockPos pos, WorldBorder worldBorder) {
        TeleportTarget.PostDimensionTransition postDimensionTransition;
        if (world.getBlockState(pos).equals(ModBlock.COPPER_TELEPORTER.getDefaultState().with(CopperTeleporter.STATE, CopperTeleporterState.middle))) {
            BlockState blockState = world.getBlockState(pos);
            postDimensionTransition = TeleportTarget.SEND_TRAVEL_THROUGH_PORTAL_PACKET.then(entity -> entity.addPortalChunkTicketAt(pos));
        } else {
            boolean isAir = false;
            boolean isPlatform = false;
            if (!(world.getBlockState(pos.up()).equals(Blocks.AIR) && world.getBlockState(pos.up(2)).equals(Blocks.AIR))) {
                isAir = true;
            }
            if (world.getBlockState(pos.down()).equals(Blocks.AIR)) {
                isPlatform = true;
            };
            portalPlace(world, pos, isAir, isPlatform);
            postDimensionTransition = TeleportTarget.SEND_TRAVEL_THROUGH_PORTAL_PACKET.then(TeleportTarget.ADD_PORTAL_CHUNK_TICKET);
        }
        return new TeleportTarget(world, pos.up().toCenterPos(), Vec3d.ZERO, entity2.getYaw(), entity2.getPitch(), PositionFlag.combine(PositionFlag.DELTA, PositionFlag.ROT), postDimensionTransition);
    }

    @Override
    protected FluidState getFluidState(BlockState state) {
        return state.get(WATERLOGGED) ? Fluids.WATER.getStill(false) : super.getFluidState(state);
    }

    @Override
    protected VoxelShape getCollisionShape(BlockState state, BlockView world, BlockPos pos, ShapeContext context) {
        return collision(state,world,pos,context);
    }

    @Override
    protected VoxelShape getOutlineShape(BlockState state, BlockView world, BlockPos pos, ShapeContext context) {
        return collision(state,world,pos,context);
    }

    protected VoxelShape collision(BlockState state, BlockView world, BlockPos pos, ShapeContext context) {
        Map<Direction, VoxelShape> SIDEMAP = VoxelShapes.createFacingShapeMap(SIDESHAPE);
        Map<Direction, VoxelShape> CORNERMAP = VoxelShapes.createFacingShapeMap(CORNERSHAPE);
        Map<Direction, VoxelShape> CORNERTOPMAP = VoxelShapes.createFacingShapeMap(CORNERTOPSHAPE);
        if (state.get(STATE).equals(CopperTeleporterState.north)) {
            return SIDEMAP.get(Direction.NORTH);
        }
        if (state.get(STATE).equals(CopperTeleporterState.south)) {
            return SIDEMAP.get(Direction.SOUTH);
        }
        if (state.get(STATE).equals(CopperTeleporterState.east)) {
            return SIDEMAP.get(Direction.EAST);
        }
        if (state.get(STATE).equals(CopperTeleporterState.west)) {
            return SIDEMAP.get(Direction.WEST);
        }
        if (state.get(STATE).equals(CopperTeleporterState.north_east)) {
            return CORNERMAP.get(Direction.NORTH);
        }
        if (state.get(STATE).equals(CopperTeleporterState.north_west)) {
            return CORNERMAP.get(Direction.WEST);
        }
        if (state.get(STATE).equals(CopperTeleporterState.south_east)) {
            return CORNERMAP.get(Direction.EAST);
        }
        if (state.get(STATE).equals(CopperTeleporterState.south_west)) {
            return CORNERMAP.get(Direction.SOUTH);
        }
        if (state.get(STATE).equals(CopperTeleporterState.ne_up)) {
            return CORNERTOPMAP.get(Direction.NORTH);
        }
        if (state.get(STATE).equals(CopperTeleporterState.nw_up)) {
            return CORNERTOPMAP.get(Direction.WEST);
        }
        if (state.get(STATE).equals(CopperTeleporterState.se_up)) {
            return CORNERTOPMAP.get(Direction.EAST);
        }
        if (state.get(STATE).equals(CopperTeleporterState.sw_up)) {
            return CORNERTOPMAP.get(Direction.SOUTH);
        }
        return MIDDLESHAPE;
    }

    @Override
    protected void appendProperties(StateManager.Builder<Block, BlockState> builder) {
        builder.add(STATE, WATERLOGGED);
    }

    @Override
    public BlockState getPlacementState(ItemPlacementContext ctx) {
        FluidState fluidState = ctx.getWorld().getFluidState(ctx.getBlockPos());
        BlockState blockState = this.getDefaultState()
                .with(STATE, CopperTeleporterState.middle)
                .with(WATERLOGGED, Boolean.valueOf(fluidState.getFluid() == Fluids.WATER));
        return blockState;
    }

    public static void portalPlace(World world, BlockPos root, Boolean isAir, Boolean isPlatform) {
        world.setBlockState(root, ModBlock.COPPER_TELEPORTER.getDefaultState().with(CopperTeleporter.STATE, CopperTeleporterState.middle));
        world.setBlockState(root.north(), ModBlock.COPPER_TELEPORTER.getDefaultState().with(CopperTeleporter.STATE, CopperTeleporterState.north));
        world.setBlockState(root.south(), ModBlock.COPPER_TELEPORTER.getDefaultState().with(CopperTeleporter.STATE, CopperTeleporterState.south));
        world.setBlockState(root.west(), ModBlock.COPPER_TELEPORTER.getDefaultState().with(CopperTeleporter.STATE, CopperTeleporterState.west));
        world.setBlockState(root.east(), ModBlock.COPPER_TELEPORTER.getDefaultState().with(CopperTeleporter.STATE, CopperTeleporterState.east));
        world.setBlockState(root.north().west(), ModBlock.COPPER_TELEPORTER.getDefaultState().with(CopperTeleporter.STATE, CopperTeleporterState.north_west));
        world.setBlockState(root.north().east(), ModBlock.COPPER_TELEPORTER.getDefaultState().with(CopperTeleporter.STATE, CopperTeleporterState.north_east));
        world.setBlockState(root.south().west(), ModBlock.COPPER_TELEPORTER.getDefaultState().with(CopperTeleporter.STATE, CopperTeleporterState.south_west));
        world.setBlockState(root.south().east(), ModBlock.COPPER_TELEPORTER.getDefaultState().with(CopperTeleporter.STATE, CopperTeleporterState.south_east));
        world.setBlockState(root.north().west().up(), ModBlock.COPPER_TELEPORTER.getDefaultState().with(CopperTeleporter.STATE, CopperTeleporterState.nw_up));
        world.setBlockState(root.north().east().up(), ModBlock.COPPER_TELEPORTER.getDefaultState().with(CopperTeleporter.STATE, CopperTeleporterState.ne_up));
        world.setBlockState(root.south().west().up(), ModBlock.COPPER_TELEPORTER.getDefaultState().with(CopperTeleporter.STATE, CopperTeleporterState.sw_up));
        world.setBlockState(root.south().east().up(), ModBlock.COPPER_TELEPORTER.getDefaultState().with(CopperTeleporter.STATE, CopperTeleporterState.se_up));

        if (isAir) {
            world.setBlockState(root.up(), Blocks.AIR.getDefaultState());
            world.setBlockState(root.north().up(), Blocks.AIR.getDefaultState());
            world.setBlockState(root.south().up(), Blocks.AIR.getDefaultState());
            world.setBlockState(root.west().up(), Blocks.AIR.getDefaultState());
            world.setBlockState(root.east().up(), Blocks.AIR.getDefaultState());
            world.setBlockState(root.north().east().up(2), Blocks.AIR.getDefaultState());
            world.setBlockState(root.south().west().up(2), Blocks.AIR.getDefaultState());
            world.setBlockState(root.west().north().up(2), Blocks.AIR.getDefaultState());
            world.setBlockState(root.east().south().up(2), Blocks.AIR.getDefaultState());
            world.setBlockState(root.up(2), Blocks.AIR.getDefaultState());
            world.setBlockState(root.north().up(2), Blocks.AIR.getDefaultState());
            world.setBlockState(root.south().up(2), Blocks.AIR.getDefaultState());
            world.setBlockState(root.west().up(2), Blocks.AIR.getDefaultState());
            world.setBlockState(root.east().up(2), Blocks.AIR.getDefaultState());
        }
        if (isPlatform) {
            world.setBlockState(root.down(), MoonBlocks.MOON_ROCK.getDefaultState());
            world.setBlockState(root.down().north(), MoonBlocks.MOON_ROCK.getDefaultState());
            world.setBlockState(root.down().north(2), MoonBlocks.MOON_ROCK.getDefaultState());
            world.setBlockState(root.down().north(3), MoonBlocks.MOON_ROCK.getDefaultState());
            world.setBlockState(root.down().north(4), MoonBlocks.MOON_ROCK.getDefaultState());
            world.setBlockState(root.down().west().north(4), MoonBlocks.MOON_ROCK.getDefaultState());
            world.setBlockState(root.down().west(2).north(4), MoonBlocks.MOON_ROCK.getDefaultState());
            world.setBlockState(root.down().south(), MoonBlocks.MOON_ROCK.getDefaultState());
            world.setBlockState(root.down().south(2), MoonBlocks.MOON_ROCK.getDefaultState());
            world.setBlockState(root.down().south(3), MoonBlocks.MOON_ROCK.getDefaultState());
            world.setBlockState(root.down().south(4), MoonBlocks.MOON_ROCK.getDefaultState());
            world.setBlockState(root.down().east().south(4), MoonBlocks.MOON_ROCK.getDefaultState());
            world.setBlockState(root.down().east(2).south(4), MoonBlocks.MOON_ROCK.getDefaultState());
            world.setBlockState(root.down().west(), MoonBlocks.MOON_ROCK.getDefaultState());
            world.setBlockState(root.down().west(2), MoonBlocks.MOON_ROCK.getDefaultState());
            world.setBlockState(root.down().west(3), MoonBlocks.MOON_ROCK.getDefaultState());
            world.setBlockState(root.down().west(4), MoonBlocks.MOON_ROCK.getDefaultState());
            world.setBlockState(root.down().south().west(4), MoonBlocks.MOON_ROCK.getDefaultState());
            world.setBlockState(root.down().south(2).west(4), MoonBlocks.MOON_ROCK.getDefaultState());
            world.setBlockState(root.down().east(), MoonBlocks.MOON_ROCK.getDefaultState());
            world.setBlockState(root.down().east(2), MoonBlocks.MOON_ROCK.getDefaultState());
            world.setBlockState(root.down().east(3), MoonBlocks.MOON_ROCK.getDefaultState());
            world.setBlockState(root.down().east(4), MoonBlocks.MOON_ROCK.getDefaultState());
            world.setBlockState(root.down().north().east(4), MoonBlocks.MOON_ROCK.getDefaultState());
            world.setBlockState(root.down().north(2).east(4), MoonBlocks.MOON_ROCK.getDefaultState());
        }
    }
}
