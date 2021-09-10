package com.github.chrisofnormandy.conlib.block.types;

import net.minecraft.block.AbstractButtonBlock;
import net.minecraft.util.SoundEvent;
import net.minecraft.util.SoundEvents;

public class ButtonBase extends AbstractButtonBlock {
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
