package com.github.wilwe21.gsad.entity.motobug;

import net.minecraft.entity.EntityType;
import net.minecraft.entity.ai.brain.task.AttackTask;
import net.minecraft.entity.ai.goal.ActiveTargetGoal;
import net.minecraft.entity.ai.goal.AttackGoal;
import net.minecraft.entity.ai.goal.LookAroundGoal;
import net.minecraft.entity.ai.goal.WanderAroundGoal;
import net.minecraft.entity.mob.PathAwareEntity;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.world.World;

public class Motobug extends PathAwareEntity {

    public Motobug(EntityType<? extends PathAwareEntity> entityType, World world) {
        super(entityType, world);
    }

    @Override
    protected void initGoals() {
        this.goalSelector.add(0, new WanderAroundGoal(this, 0.4));
        this.goalSelector.add(1, new LookAroundGoal(this));
        this.goalSelector.add(3, new ActiveTargetGoal<PlayerEntity>(this, PlayerEntity.class, true));
        this.goalSelector.add(2, new AttackGoal(this));
    }

}
