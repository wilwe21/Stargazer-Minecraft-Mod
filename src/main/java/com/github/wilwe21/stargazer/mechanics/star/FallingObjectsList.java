package com.github.wilwe21.stargazer.mechanics.star;

import com.mojang.serialization.Codec;
import com.mojang.serialization.codecs.RecordCodecBuilder;
import net.minecraft.registry.RegistryKey;
import net.minecraft.util.dynamic.Codecs;
import net.minecraft.world.World;

import java.util.ArrayList;
import java.util.List;

public class FallingObjectsList {
    public static final Codec<FallingObjectsList> CODEC = RecordCodecBuilder.create(instance -> instance.group(
            World.CODEC.fieldOf("world").forGetter(FallingObjectsList::getWorld),
            FallingObject.CODEC.listOf().fieldOf("objects").forGetter(FallingObjectsList::getList),
            Codecs.POSITIVE_INT.listOf().fieldOf("chances").forGetter(FallingObjectsList::getChanceList)
    ).apply(instance, FallingObjectsList::new));

    public List<FallingObject> list;
    public RegistryKey<World> world;
    public List<Integer> chanceList;
    public List<FallingObject> weightedList;

    public FallingObjectsList(RegistryKey<World> world, List<FallingObject> list, List<Integer> chanceList) {
        this.list = list;
        this.world = world;
        this.chanceList = chanceList;
        this.weightedList = new ArrayList<>();
        for (int i = 0; i < list.size(); i++) {
            FallingObject cur = list.get(i);
            if (i > chanceList.size()) {
                this.weightedList.add(cur);
            } else {
                Integer a = chanceList.get(i);
                for (int w = 0; w < a; w++) {
                    this.weightedList.add(cur);
                }
            }
        }
    }

    private List<FallingObject> getList() {
        return this.list;
    }
    private RegistryKey<World> getWorld() {
        return this.world;
    }
    private List<Integer> getChanceList() {
        return this.chanceList;
    }
}
