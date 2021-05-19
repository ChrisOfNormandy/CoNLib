package com.github.chrisofnormandy.conlib.registry;

import net.minecraft.entity.item.PaintingType;
import net.minecraft.util.ResourceLocation;
import net.minecraftforge.registries.ForgeRegistries;

public class Decoration {
    /**
     * 
     * @param name     The painting name.
     * @param painting The painting instance.
     * @return PaintingType
     */
    public static PaintingType registerPainting(String name, PaintingType painting) {
        painting.setRegistryName(new ResourceLocation(ModRegister.getModId(), name));
        ForgeRegistries.PAINTING_TYPES.register(painting);
        return painting;
    }
}
