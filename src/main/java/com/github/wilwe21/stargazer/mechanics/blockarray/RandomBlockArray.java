package com.github.wilwe21.stargazer.mechanics.blockarray;

import net.minecraft.block.Block;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Random;

public class RandomBlockArray {
    public final String name;
    public final List<Block> list = new ArrayList<>();
    public final List<Block> chanceList = new ArrayList<>();
    private static final Random random = new Random();

    public RandomBlockArray(String id) {
        name = id;
    }
    public RandomBlockArray(String id, List<Block> blockList, List<Block> blockChanceList) {
        name = id;
        list.addAll(blockList);
        chanceList.addAll(blockChanceList);
    }
    public RandomBlockArray(String id, List<Block> blockList) {
        name = id;
        list.addAll(blockList);
        chanceList.addAll(blockList);
    }

    public void add(Block block, int chance) {
        list.add(block);
        for (int i = 0; i < chance; i ++) {
            chanceList.add(block);
        }
    }
    public void add(Block block) {
        list.add(block);
        chanceList.add(block);
    }

    public Block getRandom() {
        return list.get(random.nextInt(list.size()));
    }
    public Block getRandomFromChance() {
        Collections.shuffle(chanceList);
        return chanceList.get(random.nextInt(chanceList.size()));
    }
}
