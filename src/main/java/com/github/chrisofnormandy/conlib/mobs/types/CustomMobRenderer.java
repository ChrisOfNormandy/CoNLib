package com.github.chrisofnormandy.conlib.mobs.types;

import net.minecraft.client.renderer.entity.EntityRendererProvider.Context;
import net.minecraft.client.renderer.entity.MobRenderer;
import net.minecraft.resources.ResourceLocation;

public class CustomMobRenderer extends MobRenderer<CustomAnimal, CustomAnimalModel<CustomAnimal>> {
    public CustomMobRenderer(Context context, CustomAnimalModel<CustomAnimal> customAnimalModel, float f) {
        super(context, customAnimalModel, f);
    }

    @Override
    public ResourceLocation getTextureLocation(CustomAnimal p_114482_) {
        throw new UnsupportedOperationException("Unimplemented method 'getTextureLocation'");
    }
}
