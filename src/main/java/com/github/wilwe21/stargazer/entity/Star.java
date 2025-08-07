package com.github.wilwe21.stargazer.entity;

import com.github.wilwe21.stargazer.item.ModItems;
import net.minecraft.entity.*;
import net.minecraft.entity.vehicle.AbstractBoatEntity;
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

public class Star extends AbstractBoatEntity implements GeoEntity {
    protected static final RawAnimation ROTATO = RawAnimation.begin().thenLoop("star.rotate");

    private final AnimatableInstanceCache geoCache = GeckoLibUtil.createInstanceCache(this);

    public Star(EntityType<? extends Star> type, World world) {
        super(type, world, () -> ModItems.YELLOW_STAR);
    }

    @Override
    public void registerControllers(final AnimatableManager.ControllerRegistrar controllers) {
        controllers.add(new AnimationController<>("MovementController", 5, this::AnimController));
    }

    private PlayState AnimController(AnimationTest<GeoAnimatable> animTest) {
        return animTest.setAndContinue(ROTATO);
    }

    @Override
    public AnimatableInstanceCache getAnimatableInstanceCache() {
        return this.geoCache;
    }

    @Override
    protected double getPassengerAttachmentY(EntityDimensions dimensions) {
        return 10;
    }
}