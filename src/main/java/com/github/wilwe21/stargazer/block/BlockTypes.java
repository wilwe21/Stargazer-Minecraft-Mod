package com.github.wilwe21.stargazer.block;

import com.github.wilwe21.stargazer.Stargazer;
import com.github.wilwe21.stargazer.block.clases.border.BorderBlockEntity;
import com.github.wilwe21.stargazer.block.clases.cosmic.CosmicBlockEntity;
import com.github.wilwe21.stargazer.block.clases.grave.GraveEntity;
import com.github.wilwe21.stargazer.block.clases.negative.NegativeBlockEntity;
import net.fabricmc.fabric.api.object.builder.v1.block.entity.FabricBlockEntityTypeBuilder;
import net.minecraft.block.entity.BlockEntityType;
import net.minecraft.registry.Registries;
import net.minecraft.registry.Registry;
import net.minecraft.util.Identifier;

public class BlockTypes {
    public static <T extends BlockEntityType<?>> T register(String path, T blockEntityType) {
        return Registry.register(Registries.BLOCK_ENTITY_TYPE, Identifier.of(Stargazer.MOD_ID, path), blockEntityType);
    }

    public static final BlockEntityType<GraveEntity> GRAVE = register(
            "grave",
            FabricBlockEntityTypeBuilder.create(GraveEntity::new, ModBlock.GRAVE).build()
    );
    public static final BlockEntityType<NegativeBlockEntity> NEGATIVE_BLOCK = register(
            "negativeblock",
            FabricBlockEntityTypeBuilder.create(NegativeBlockEntity::new, ModBlock.NEGATIVE_BLOCK).build()
    );
    public static final BlockEntityType<CosmicBlockEntity> COSMIC_BLOCK = register(
            "cosmicblock",
            FabricBlockEntityTypeBuilder.create(CosmicBlockEntity::new, ModBlock.COSMIC_BLOCK).build()
    );
    public static final BlockEntityType<BorderBlockEntity> BORDER_BLOCK = register(
            "borderblock",
            FabricBlockEntityTypeBuilder.create(BorderBlockEntity::new, ModBlock.BORDER_BLOCK).build()
    );
    public static void init() {
    }
}
