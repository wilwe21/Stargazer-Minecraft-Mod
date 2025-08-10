package com.github.wilwe21.stargazer.block.register;

import com.github.wilwe21.stargazer.block.clases.moon.plants.DragonCarrot;
import com.github.wilwe21.stargazer.block.clases.moon.plants.GiantCrop;
import com.github.wilwe21.stargazer.item.ModItems;
import net.minecraft.block.AbstractBlock;
import net.minecraft.block.Block;
import net.minecraft.block.piston.PistonBehavior;
import net.minecraft.component.type.FoodComponent;
import net.minecraft.item.Item;
import net.minecraft.sound.BlockSoundGroup;

import static com.github.wilwe21.stargazer.block.ModBlock.register;
import static com.github.wilwe21.stargazer.block.ModBlock.registerWoItem;

public class Crops {
    public static final Block DRAGON_CARROT_BLOCK = registerWoItem("dragon_carrot_block", DragonCarrot::new, AbstractBlock.Settings.create()
            .noCollision()
            .breakInstantly()
            .sounds(BlockSoundGroup.GRASS)
            .pistonBehavior(PistonBehavior.DESTROY)
    );

    public static final Block GIANG_DRAGON_CARROT = register("gian_dragon_carrot", GiantCrop::new, AbstractBlock.Settings.create()
    );

    public static final Item DRAGON_CARROT = ModItems.register("dragon_carrot", ModItems.createBlockItemWithUniqueName(DRAGON_CARROT_BLOCK), new Item.Settings()
            .food(new FoodComponent(6, 12, false))
    );

    public static void init() {}
}
