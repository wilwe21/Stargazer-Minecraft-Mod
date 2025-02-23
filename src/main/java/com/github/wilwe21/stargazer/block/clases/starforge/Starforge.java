package com.github.wilwe21.stargazer.block.clases.starforge;

import com.github.wilwe21.stargazer.screenHandlers.ScreenHandlerType;
import com.github.wilwe21.stargazer.screenHandlers.StarforgeContainerScreen;
import com.github.wilwe21.stargazer.screenHandlers.StarforgeScreenHandler;
import com.mojang.serialization.MapCodec;
import net.minecraft.block.AbstractBlock;
import net.minecraft.block.Block;
import net.minecraft.block.BlockState;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.screen.NamedScreenHandlerFactory;
import net.minecraft.screen.ScreenHandler;
import net.minecraft.screen.SimpleNamedScreenHandlerFactory;
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
            StarforgeScreenHandler hand = ScreenHandlerType.STARFORGE.create(player.getRandom().nextInt(), player.getInventory());
            player.openHandledScreen(new SimpleNamedScreenHandlerFactory(
                    ((syncId, playerInventory, player1) -> hand), TITLE)
            );
        }

        return ActionResult.SUCCESS;
    }

    @Nullable
    @Override
    protected NamedScreenHandlerFactory createScreenHandlerFactory(BlockState state, World world, BlockPos pos) {
        return new SimpleNamedScreenHandlerFactory(
                (syncId, inventory, player) -> new StarforgeScreenHandler(syncId, inventory), TITLE
        );
    }
}
