package com.github.chrisofnormandy.conlib.block.types;

import net.minecraft.sounds.SoundEvent;
import net.minecraft.sounds.SoundEvents;
import net.minecraft.world.level.block.ButtonBlock;

public class ButtonBase extends ButtonBlock {
    private Boolean wooden = false;

    /**
     * 
     * @param isWood
     * @param properties
     */
    public ButtonBase(boolean isWood, Properties properties) {
        super(isWood, properties);
        wooden = isWood;
    }

    @Override
    protected SoundEvent getSound(boolean clicked) {
        return wooden ? clicked ? SoundEvents.STONE_BUTTON_CLICK_ON : SoundEvents.STONE_BUTTON_CLICK_OFF
                : clicked ? SoundEvents.WOODEN_BUTTON_CLICK_ON : SoundEvents.WOODEN_BUTTON_CLICK_OFF;
    }
}
