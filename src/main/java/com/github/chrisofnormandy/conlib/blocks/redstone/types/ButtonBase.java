package com.github.chrisofnormandy.conlib.blocks.redstone.types;

import net.minecraft.world.level.block.ButtonBlock;
import net.minecraft.world.level.block.state.properties.BlockSetType;

public class ButtonBase extends ButtonBlock {

    public ButtonBase(Properties properties) {
        super(properties, BlockSetType.STONE, 0, true);
    }

    public ButtonBase(Properties properties, BlockSetType blockSetType) {
        super(properties, blockSetType, 0, true);
    }

    public ButtonBase(Properties properties, BlockSetType blockSetType, int tickTime) {
        super(properties, blockSetType, tickTime, true);
    }

    public ButtonBase(Properties properties, BlockSetType blockSetType, int tickTime, boolean shootable) {
        super(properties, blockSetType, tickTime, shootable);
    }
}
