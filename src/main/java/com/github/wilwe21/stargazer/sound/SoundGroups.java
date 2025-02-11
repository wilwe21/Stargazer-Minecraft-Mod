package com.github.wilwe21.stargazer.sound;

import net.minecraft.sound.BlockSoundGroup;
import net.minecraft.sound.SoundEvents;

public class SoundGroups {
    public static final BlockSoundGroup STAR = new BlockSoundGroup(
            0.4F,
            1.4F,
            SoundEffects.BLOCK_COSMIC_BREAK,
            SoundEvents.INTENTIONALLY_EMPTY,
            SoundEffects.BLOCK_COSMIC_PLACE,
            SoundEvents.INTENTIONALLY_EMPTY,
            SoundEffects.BLOCK_COSMIC_LAND
    );
}
