package com.github.chrisofnormandy.conlib.misc;

import com.github.chrisofnormandy.conlib.registry.ModRegister;

import net.minecraft.entity.item.PaintingType;

public class ModPainting {
    public static PaintingType register(String name, Integer width, Integer height) {
        return ModRegister.registerPainting(name, new PaintingType(width, height));
    }

    public static PaintingType register(String name, Integer size) {
        return ModRegister.registerPainting(name, new PaintingType(size, size));
    }
}
