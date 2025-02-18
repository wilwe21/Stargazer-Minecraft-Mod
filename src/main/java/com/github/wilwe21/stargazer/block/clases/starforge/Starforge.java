package com.github.wilwe21.stargazer.block.clases.starforge;

import com.github.wilwe21.stargazer.Stargazer;
import com.github.wilwe21.stargazer.screenHandlers.AbstractStarforgeScreenHandler;
import com.github.wilwe21.stargazer.screenHandlers.ScreenHandlerType;
import com.github.wilwe21.stargazer.screenHandlers.StarforgeScreenHandler;
import com.mojang.serialization.MapCodec;
import net.fabricmc.fabric.api.screenhandler.v1.ExtendedScreenHandlerFactory;
import net.minecraft.block.AbstractBlock;
import net.minecraft.block.Block;
import net.minecraft.block.BlockState;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.entity.player.PlayerInventory;
import net.minecraft.screen.NamedScreenHandlerFactory;
import net.minecraft.screen.ScreenHandler;
import net.minecraft.screen.ScreenHandlerContext;
import net.minecraft.screen.SimpleNamedScreenHandlerFactory;
import net.minecraft.server.network.ServerPlayerEntity;
import net.minecraft.text.Text;
import net.minecraft.util.ActionResult;
import net.minecraft.util.hit.BlockHitResult;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.World;
import org.jetbrains.annotations.Nullable;

public class Starforge extends Block {
    public static final MapCodec<Starforge> CODEC = createCodec(Starforge::new);
    private static final Text TITLE = Text.translatable("container.starforge");

    @Override
    public MapCodec<? extends Starforge> getCodec() {
        return CODEC;
    }

    public Starforge(AbstractBlock.Settings settings) {
        super(settings);
    }

    @Override
    protected ActionResult onUse(BlockState state, World world, BlockPos pos, PlayerEntity player, BlockHitResult hit) {
        if (!world.isClient) {
//            player.openHandledScreen(state.createScreenHandlerFactory(world, pos));
            player.openHandledScreen(new SimpleNamedScreenHandlerFactory(
                    (syncId, inv, playerEntity) ->
                        new StarforgeScreenHandler(syncId, inv, ScreenHandlerContext.create(world, pos)
                    ), TITLE)
            );
        }

        return ActionResult.SUCCESS;
    }

    @Override
    protected NamedScreenHandlerFactory createScreenHandlerFactory(BlockState state, World world, BlockPos pos) {
        return new SimpleNamedScreenHandlerFactory(
                (syncId, inventory, player) -> new StarforgeScreenHandler(syncId, inventory, ScreenHandlerContext.create(world, pos)), TITLE
        );
    }
}
