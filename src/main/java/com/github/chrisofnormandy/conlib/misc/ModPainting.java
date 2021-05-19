package com.github.chrisofnormandy.conlib.misc;

import com.github.chrisofnormandy.conlib.registry.Decoration;

import net.minecraft.entity.item.PaintingType;

public class ModPainting {
    /**
     * 
     * @param name
     * @param width
     * @param height
     * @return
     */
    public static PaintingType register(String name, Integer width, Integer height) {
        return Decoration.registerPainting(name, new PaintingType(width, height));
    }

    /**
     * 
     * @param name
     * @param size
     * @return
     */
    public static PaintingType register(String name, Integer size) {
        return Decoration.registerPainting(name, new PaintingType(size, size));
    }
}
