package com.github.wilwe21.gsad.entity;

import net.minecraft.entity.EntityType;
import net.minecraft.entity.mob.PathAwareEntity;
import net.minecraft.world.World;

public class Test extends PathAwareEntity {
    protected Test(EntityType<? extends PathAwareEntity> entityType, World world) {
        super(entityType, world);
    }
}
