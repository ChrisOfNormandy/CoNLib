package com.github.chrisofnormandy.conlib.items.tools;

import com.github.chrisofnormandy.conlib.registry.ItemRegistry;
import com.github.chrisofnormandy.conlib.registry.ModRegister;

import net.minecraft.resources.ResourceKey;
import net.minecraft.world.item.BucketItem;
import net.minecraft.world.item.CreativeModeTab;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.Item.Properties;
import net.minecraft.world.level.material.Fluid;
import net.minecraft.world.level.material.Fluids;

public class Buckets {

    public static final Item create(String name) {
        return create(name, new Properties());
    }

    public static final Item create(String name, ResourceKey<CreativeModeTab> creativeTab) {
        return create(name, new Properties(), creativeTab);
    }

    public static final Item create(String name, Properties properties) {
        return create(name, properties, Fluids.EMPTY);
    }

    public static final Item create(String name, Properties properties, ResourceKey<CreativeModeTab> creativeTab) {
        return create(name, properties, Fluids.EMPTY, creativeTab);
    }

    public static final Item create(String name, Properties properties,
            Fluid fluid) {
        Item bucket = new BucketItem(() -> fluid, properties);
        ModRegister.tools.put(name, bucket);

        return ItemRegistry.register(name, bucket);
    }

    public static final Item create(String name, Properties properties,
            Fluid fluid,
            ResourceKey<CreativeModeTab> creativeTab) {
        Item bucket = new BucketItem(() -> fluid, properties);
        ModRegister.tools.put(name, bucket);

        return ItemRegistry.register(name, bucket, creativeTab);
    }
}
