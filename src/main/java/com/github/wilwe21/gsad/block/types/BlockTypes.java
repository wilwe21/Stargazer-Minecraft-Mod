package com.github.wilwe21.gsad.block.types;

import com.github.wilwe21.gsad.Gsad;
import com.github.wilwe21.gsad.block.ModBlock;
import com.github.wilwe21.gsad.block.custom.blockEntity.dream.DreamBlockEntity;
import com.github.wilwe21.gsad.block.custom.blockEntity.spinner.SpinnerEntity;
import com.github.wilwe21.gsad.block.custom.blockEntity.strawberry.StrawberryEntity;
import com.github.wilwe21.gsad.block.custom.blockEntity.tv.TvEntity;
import net.fabricmc.fabric.api.object.builder.v1.block.entity.FabricBlockEntityTypeBuilder;
import net.minecraft.block.entity.BlockEntityType;
import net.minecraft.registry.Registries;
import net.minecraft.registry.Registry;
import net.minecraft.util.Identifier;

public class BlockTypes {
    public static <T extends BlockEntityType<?>> T register(String path, T blockEntityType) {
        return Registry.register(Registries.BLOCK_ENTITY_TYPE, Identifier.of(Gsad.MOD_ID, path), blockEntityType);
    }

    public static final BlockEntityType<SpinnerEntity> SPINNER = register(
            "spinner_block",
            FabricBlockEntityTypeBuilder.create(SpinnerEntity::new, ModBlock.SPINNER).build()
    );
    public static final BlockEntityType<StrawberryEntity> STRAWBERRY = register(
            "strawberry",
            FabricBlockEntityTypeBuilder.create(StrawberryEntity::new, ModBlock.STRAWBERRY).build()
    );
    public static final BlockEntityType<DreamBlockEntity> DREAM_BLOCK = register(
            "dreamblock",
            FabricBlockEntityTypeBuilder.create(DreamBlockEntity::new, ModBlock.DREAM_BLOCK).build()
    );
    public static final BlockEntityType<TvEntity> TV = register(
            "tv",
            FabricBlockEntityTypeBuilder.create(TvEntity::new, ModBlock.TV_BLOCK).build()
    );

    public static void init() {
    }
}
