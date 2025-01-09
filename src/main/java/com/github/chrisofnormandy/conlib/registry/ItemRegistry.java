package com.github.chrisofnormandy.conlib.registry;

import net.minecraft.world.item.Item;

import java.util.HashMap;
import java.util.Map;
import java.util.function.Supplier;

import org.slf4j.Logger;

import com.github.chrisofnormandy.conlib.CoNLib;
import com.mojang.logging.LogUtils;

import net.minecraft.resources.ResourceKey;
import net.minecraft.world.item.CreativeModeTab;
import net.minecraftforge.eventbus.api.IEventBus;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.ForgeRegistries;
import net.minecraftforge.registries.RegistryObject;

public class ItemRegistry {
    private static final Logger LOGGER = LogUtils.getLogger();

    public static class ItemRegistryInit {
        private static String MOD_ID = CoNLib.MOD_ID;

        private static final Map<String, DeferredRegister<Item>> ITEMS = new HashMap<>();

        public static final void using(String modId) {
            MOD_ID = modId;
            LOGGER.info("ITEMS USE " + MOD_ID);
        }

        public static final void init(String modId) {
            ITEMS.put(modId, DeferredRegister.create(ForgeRegistries.ITEMS, modId));
            using(modId);
        }

        public static final DeferredRegister<Item> get() {
            LOGGER.info("REGISTER ITEM UNDER " + MOD_ID);
            return ITEMS.get(MOD_ID);
        }

        public static final void finish(IEventBus bus, String modId) {
            ITEMS.get(modId).register(bus);
            using(modId);
        }
    }

    public static final <T extends Item> RegistryObject<T> register(String name, Supplier<T> item) {
        var registry = ItemRegistryInit.get().register(name, item);
        ModRegister.items.put(name, registry);

        LOGGER.info("Registered new item (not in creative tab): " + name);

        return registry;
    }

    public static final <T extends Item> RegistryObject<T> register(String name, Supplier<T> item,
            ResourceKey<CreativeModeTab> creativeTab) {
        var registry = ItemRegistryInit.get().register(name, item);
        ModRegister.items.put(name, registry);

        ModRegister.useCreativeTab(creativeTab, registry);

        LOGGER.info("Registered new item: " + ItemRegistryInit.MOD_ID + ":" + name);

        return registry;
    }
}
