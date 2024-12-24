package com.github.wilwe21.celeste.block.types;

import com.github.wilwe21.celeste.Celeste;
import com.github.wilwe21.celeste.block.ModBlock;
import com.github.wilwe21.celeste.block.custom.SpinnerEntity;
import net.fabricmc.fabric.api.object.builder.v1.block.entity.FabricBlockEntityTypeBuilder;
import net.minecraft.block.entity.BlockEntityType;
import net.minecraft.registry.Registries;
import net.minecraft.registry.Registry;
import net.minecraft.util.Identifier;

public class BlockTypes {
    public static <T extends BlockEntityType<?>> T register(String path, T blockEntityType) {
        return Registry.register(Registries.BLOCK_ENTITY_TYPE, Identifier.of(Celeste.MOD_ID, path), blockEntityType);
    }

    public static final BlockEntityType<SpinnerEntity> SPINNER = register(
            "spinner_block",
            FabricBlockEntityTypeBuilder.create(SpinnerEntity::new, ModBlock.SPINNER).build()
    );

    public static void init() {
    }
}
