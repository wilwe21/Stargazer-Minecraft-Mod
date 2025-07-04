package com.github.wilwe21.stargazer.entity;

import net.minecraft.entity.EntityType;
import net.minecraft.entity.ai.control.FlightMoveControl;
import net.minecraft.entity.ai.pathing.BirdNavigation;
import net.minecraft.entity.ai.pathing.EntityNavigation;
import net.minecraft.entity.attribute.DefaultAttributeContainer;
import net.minecraft.entity.attribute.EntityAttributes;
import net.minecraft.entity.mob.FlyingEntity;
import net.minecraft.entity.mob.MobEntity;
import net.minecraft.util.math.Vec3d;
import net.minecraft.world.World;
import software.bernie.geckolib.animatable.GeoAnimatable;
import software.bernie.geckolib.animatable.GeoEntity;
import software.bernie.geckolib.animatable.instance.AnimatableInstanceCache;
import software.bernie.geckolib.animatable.manager.AnimatableManager;
import software.bernie.geckolib.animatable.processing.AnimationController;
import software.bernie.geckolib.animatable.processing.AnimationTest;
import software.bernie.geckolib.animation.PlayState;
import software.bernie.geckolib.animation.RawAnimation;

import software.bernie.geckolib.util.GeckoLibUtil;

public class Ghost extends FlyingEntity implements GeoEntity {
    protected static final RawAnimation FLY_ANIM = RawAnimation.begin().thenLoop("animation.ghost_move");
    protected static final RawAnimation IDLE_ANIM = RawAnimation.begin().thenPlay("animation.ghost_idle");
    protected static final RawAnimation IDLE2_ANIM = RawAnimation.begin().thenLoop("animation.ghost_idle2");

    private final AnimatableInstanceCache geoCache = GeckoLibUtil.createInstanceCache(this);

    public Ghost(EntityType<? extends Ghost> type, World world) {
        super(type, world);
        this.setNoGravity(true);
        this.moveControl = new FlightMoveControl(this, 20, true);
        this.noClip = true;
    }

    public static DefaultAttributeContainer.Builder createFlyingCreatureAttributes() {
        return MobEntity.createMobAttributes()
                .add(EntityAttributes.MAX_HEALTH, 10.0)
                .add(EntityAttributes.MOVEMENT_SPEED, 0.15)
                .add(EntityAttributes.FLYING_SPEED, 0.3);
    }

    protected EntityNavigation createNavigation(World world) {
        BirdNavigation birdNavigation = new BirdNavigation(this, world);
        birdNavigation.setCanPathThroughDoors(false);
        birdNavigation.setCanSwim(true);
        birdNavigation.setMaxFollowRange(48.0F);
        return birdNavigation;
    }

    @Override
    public void registerControllers(final AnimatableManager.ControllerRegistrar controllers) {
        controllers.add(new AnimationController<>("MovementController", 5, this::AnimController));
    }

    private PlayState AnimController(AnimationTest<GeoAnimatable> animTest) {
        int rand = this.random.nextInt(5);
        if (rand > 3 & !animTest.isMoving()) {
            return animTest.setAndContinue(IDLE_ANIM);
        } else if (rand <= 3 & !animTest.isMoving()) {
            return animTest.setAndContinue(IDLE2_ANIM);
        } else if (animTest.isMoving()) {
            return animTest.setAndContinue(FLY_ANIM);
        }
        return PlayState.STOP;
    }

    @Override
    public AnimatableInstanceCache getAnimatableInstanceCache() {
        return this.geoCache;
    }

    @Override
    public void travel(Vec3d movementInput) {
        super.travel(movementInput);
    }

    @Override
    public void tick() {
        super.tick();
        if (!this.hasPositionTarget() && this.random.nextInt(32) > 24) {
            this.setTargetPos(this.getPos().add(random.nextFloat() * 10 - 5, random.nextFloat() * 10 - 5, random.nextFloat() * 10 - 5));
        }
    }

    public void setTargetPos(Vec3d pos) {
        this.navigation.startMovingTo(pos.x, pos.y, pos.z, 0.7);
    }

    public boolean hasPositionTarget() {
        return !this.navigation.isIdle();
    }}