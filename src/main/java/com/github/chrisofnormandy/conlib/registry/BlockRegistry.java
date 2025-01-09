package com.github.chrisofnormandy.conlib.registry;

import java.util.HashMap;
import java.util.Map;
import java.util.function.Supplier;

import org.slf4j.Logger;

import com.github.chrisofnormandy.conlib.CoNLib;
import com.mojang.logging.LogUtils;

import net.minecraft.world.level.block.Block;
import net.minecraftforge.eventbus.api.IEventBus;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.ForgeRegistries;
import net.minecraftforge.registries.RegistryObject;
import net.minecraft.resources.ResourceKey;
import net.minecraft.world.item.BlockItem;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.CreativeModeTab;

public class BlockRegistry {
    private static final Logger LOGGER = LogUtils.getLogger();

    public static class BlockRegistryInit {
        private static String MOD_ID = CoNLib.MOD_ID;

        private static final Map<String, DeferredRegister<Block>> BLOCKS = new HashMap<>();

        public static final void using(String modId) {
            MOD_ID = modId;
            LOGGER.info("BLOCKS USE " + MOD_ID);
        }

        public static final void init(String modId) {
            BLOCKS.put(modId, DeferredRegister.create(ForgeRegistries.BLOCKS, modId));
            using(modId);
        }

        private static final DeferredRegister<Block> get() {
            LOGGER.info("REGISTER BLOCK UNDER " + MOD_ID);
            return BLOCKS.get(MOD_ID);
        }

        public static final void finish(IEventBus bus, String modId) {
            BLOCKS.get(modId).register(bus);
            using(modId);
        }
    }

    public static final <T extends Block> RegistryObject<T> register(String name, Supplier<T> block) {
        return BlockRegistryInit.get().register(name, block);
    }

    public static final <T extends Block> RegistryObject<T> register(String name,
            Supplier<T> block,
            ResourceKey<CreativeModeTab> creativeTab) {
        var blockRegistry = BlockRegistryInit.get().register(name, block);
        ItemRegistry.register(name, () -> new BlockItem(blockRegistry.get(), new Item.Properties()),
                creativeTab);

        return blockRegistry;
    }
}
