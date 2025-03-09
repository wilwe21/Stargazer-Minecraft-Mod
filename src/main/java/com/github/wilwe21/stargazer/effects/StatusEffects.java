package com.github.wilwe21.stargazer.effects;

import com.github.wilwe21.stargazer.Stargazer;
import net.minecraft.entity.effect.StatusEffect;
import net.minecraft.entity.effect.StatusEffectCategory;
import net.minecraft.registry.Registries;
import net.minecraft.registry.Registry;
import net.minecraft.util.Identifier;

import java.util.function.Function;

public class StatusEffects {
    public static StatusEffect HYDRO = register("hydrophobic", new Hydrophobic(StatusEffectCategory.HARMFUL, 500));
    public static StatusEffect COSMO = register("cosmofeeling", new CosmoFeeling(StatusEffectCategory.BENEFICIAL, 50));
    public static StatusEffect GLASS = register("glasshands", new GlassHands(StatusEffectCategory.HARMFUL, 500000));

    public static StatusEffect register(String path, StatusEffect status) {
        final Identifier identifier = Identifier.of(Stargazer.MOD_ID, path);
        Registry.registerReference(Registries.STATUS_EFFECT, identifier, status);
        return status;
    }

    public static void init() {

    }
}
