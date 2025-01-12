package com.github.wilwe21.gsad.block;

import com.github.wilwe21.gsad.Gsad;
import com.github.wilwe21.gsad.block.custom.Mario.brick.BrickEntity;
import com.github.wilwe21.gsad.block.custom.Mario.lucky.LuckyBlockEntity;
import com.github.wilwe21.gsad.block.custom.celeste.dream.DreamBlockEntity;
import com.github.wilwe21.gsad.block.custom.celeste.dustbunny.DustBunnyEntity;
import com.github.wilwe21.gsad.block.custom.Sonic.ring.RingEntity;
import com.github.wilwe21.gsad.block.custom.celeste.spinner.SpinnerEntity;
import com.github.wilwe21.gsad.block.custom.celeste.strawberry.StrawberryEntity;
import com.github.wilwe21.gsad.block.custom.celeste.tv.TvEntity;
import com.github.wilwe21.gsad.block.custom.random.grave.GraveEntity;
import com.github.wilwe21.gsad.block.custom.random.negative.NegativeBlockEntity;
import net.fabricmc.fabric.api.object.builder.v1.block.entity.FabricBlockEntityTypeBuilder;
import net.minecraft.block.entity.BlockEntityType;
import net.minecraft.registry.Registries;
import net.minecraft.registry.Registry;
import net.minecraft.util.Identifier;

public class BlockTypes {
    public static <T extends BlockEntityType<?>> T register(String path, T blockEntityType) {
        return Registry.register(Registries.BLOCK_ENTITY_TYPE, Identifier.of(Gsad.MOD_ID, path), blockEntityType);
    }

    // Gsad
    public static final BlockEntityType<GraveEntity> GRAVE = register(
            "grave",
            FabricBlockEntityTypeBuilder.create(GraveEntity::new, ModBlock.GRAVE).build()
    );
    public static final BlockEntityType<NegativeBlockEntity> NEGATIVE_BLOCK = register(
            "negativeblock",
            FabricBlockEntityTypeBuilder.create(NegativeBlockEntity::new, ModBlock.NEGATIVE_BLOCK).build()
    );

    // Celeste
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
    public static final BlockEntityType<DustBunnyEntity> DUST_BUNNY = register(
            "dust_bunny",
            FabricBlockEntityTypeBuilder.create(DustBunnyEntity::new, ModBlock.DUST_BUNNY).build()
    );

    // Sonic
    public static final BlockEntityType<RingEntity> RING = register(
            "ring",
            FabricBlockEntityTypeBuilder.create(RingEntity::new, ModBlock.RING).build()
    );

    // Mario
    public static final BlockEntityType<LuckyBlockEntity> LUCKY_BLOCK = register(
            "lucky_block",
            FabricBlockEntityTypeBuilder.create(LuckyBlockEntity::new, ModBlock.LUCKY_BLOCK).build()
    );
    public static final BlockEntityType<BrickEntity> BRICK = register(
            "brick",
            FabricBlockEntityTypeBuilder.create(BrickEntity::new, ModBlock.BRICK).build()
    );

    public static void init() {
    }
}
