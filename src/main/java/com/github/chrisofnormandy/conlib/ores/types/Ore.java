package com.github.chrisofnormandy.conlib.ores.types;

import net.minecraft.util.valueproviders.IntProvider;
import net.minecraft.world.level.block.DropExperienceBlock;

public class Ore extends DropExperienceBlock {

    public Ore(Properties properties) {
        super(properties);
    }

    public Ore(Properties properties, IntProvider experience) {
        super(properties, experience);
    }
}
