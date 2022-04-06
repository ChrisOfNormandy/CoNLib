package com.github.chrisofnormandy.conlib.misc;

import com.github.chrisofnormandy.conlib.registry.DecorationRegistry;

import net.minecraft.entity.item.PaintingType;

public class ModPainting {
    /**
     * 
     * @param name
     * @param width
     * @param height
     * @return
     */
    public static final PaintingType register(String name, Integer width, Integer height) {
        return DecorationRegistry.registerPainting(name, new PaintingType(width, height));
    }

    /**
     * 
     * @param name
     * @param size
     * @return
     */
    public static final PaintingType register(String name, Integer size) {
        return DecorationRegistry.registerPainting(name, new PaintingType(size, size));
    }
}
