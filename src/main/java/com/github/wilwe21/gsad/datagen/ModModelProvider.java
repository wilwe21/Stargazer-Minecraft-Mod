package com.github.wilwe21.gsad.datagen;

import com.github.wilwe21.gsad.Gsad;
import com.github.wilwe21.gsad.block.ModBlock;
import com.github.wilwe21.gsad.item.ModItems;
import net.fabricmc.fabric.api.client.datagen.v1.provider.FabricModelProvider;
import net.fabricmc.fabric.api.datagen.v1.FabricDataOutput;
import net.minecraft.block.Block;
import net.minecraft.client.data.*;
import net.minecraft.util.Identifier;

import java.util.function.Consumer;

import static net.minecraft.client.data.BlockStateModelGenerator.*;

public class ModModelProvider extends FabricModelProvider {
    public ModModelProvider(FabricDataOutput output) {
        super(output);
    }

    @Override
    public void generateBlockStateModels(BlockStateModelGenerator blockStateModelGenerator) {
    }

    @Override
    public void generateItemModels(ItemModelGenerator itemModelGenerator) {
    }
}
