package com.github.chrisofnormandy.conlib.common;

import java.util.function.Consumer;

import net.minecraft.world.item.DyeColor;

public class Colors {
    public static final DyeColor[] dyes = new DyeColor[] {
            DyeColor.WHITE,
            DyeColor.ORANGE,
            DyeColor.MAGENTA,
            DyeColor.LIGHT_BLUE,
            DyeColor.YELLOW,
            DyeColor.LIME,
            DyeColor.PINK,
            DyeColor.GRAY,
            DyeColor.LIGHT_GRAY,
            DyeColor.CYAN,
            DyeColor.PURPLE,
            DyeColor.BLUE,
            DyeColor.BROWN,
            DyeColor.GREEN,
            DyeColor.RED,
            DyeColor.BLACK
    };

    public static final void forEachDye(Consumer<DyeColor> consumer) {
        for (DyeColor dye : dyes) {
            consumer.accept(dye);
        }
    }
}
