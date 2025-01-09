package com.github.chrisofnormandy.conlib.items.tools;

import com.github.chrisofnormandy.conlib.registry.ItemRegistry;
import com.github.chrisofnormandy.conlib.registry.ModRegister;

import net.minecraft.resources.ResourceKey;
import net.minecraft.world.item.BucketItem;
import net.minecraft.world.item.CreativeModeTab;
import net.minecraft.world.item.Item.Properties;
import net.minecraft.world.level.material.Fluid;
import net.minecraft.world.level.material.Fluids;
import net.minecraftforge.registries.RegistryObject;

public class Buckets {

    public static final RegistryObject<BucketItem> create(String name) {
        return create(name, new Properties());
    }

    public static final RegistryObject<BucketItem> create(String name, ResourceKey<CreativeModeTab> creativeTab) {
        return create(name, new Properties(), creativeTab);
    }

    public static final RegistryObject<BucketItem> create(String name, Properties properties) {
        return create(name, properties, Fluids.EMPTY);
    }

    public static final RegistryObject<BucketItem> create(String name, Properties properties,
            ResourceKey<CreativeModeTab> creativeTab) {
        return create(name, properties, Fluids.EMPTY, creativeTab);
    }

    public static final RegistryObject<BucketItem> create(String name, Properties properties,
            Fluid fluid) {
        var bucket = ItemRegistry.register(name, () -> new BucketItem(() -> fluid, properties));
        ModRegister.tools.put(name, bucket);

        return bucket;
    }

    public static final RegistryObject<BucketItem> create(String name, Properties properties,
            Fluid fluid,
            ResourceKey<CreativeModeTab> creativeTab) {
        var bucket = ItemRegistry.register(name, () -> new BucketItem(() -> fluid, properties), creativeTab);
        ModRegister.tools.put(name, bucket);

        return bucket;
    }
}
