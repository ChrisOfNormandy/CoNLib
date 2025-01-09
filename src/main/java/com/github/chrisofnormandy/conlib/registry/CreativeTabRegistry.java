package com.github.chrisofnormandy.conlib.registry;

import java.util.HashMap;
import java.util.Map;

import com.github.chrisofnormandy.conlib.CoNLib;

import net.minecraft.core.registries.Registries;
import net.minecraft.world.item.CreativeModeTab;
import net.minecraft.world.item.CreativeModeTabs;
import net.minecraft.world.item.Item;
import net.minecraftforge.eventbus.api.IEventBus;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.RegistryObject;

public class CreativeTabRegistry {

    public static class CreativeTabRegistryInit {
        private static String MOD_ID = CoNLib.MOD_ID;

        private static final Map<String, DeferredRegister<CreativeModeTab>> CREATIVE_MODE_TABS = new HashMap<>();

        public static final void using(String modId) {
            MOD_ID = modId;
        }

        public static final void init(String modId) {
            CREATIVE_MODE_TABS.put(modId, DeferredRegister.create(Registries.CREATIVE_MODE_TAB, modId));
            using(modId);
        }

        public static final DeferredRegister<CreativeModeTab> get() {
            return CREATIVE_MODE_TABS.get(MOD_ID);
        }

        public static final void finish(IEventBus bus, String modId) {
            CREATIVE_MODE_TABS.get(modId).register(bus);
            using(modId);
        }
    }

    public static final void register(String name, RegistryObject<Item> icon) {
        CreativeTabRegistryInit.get().register(name, () -> CreativeModeTab.builder()
                .withTabsBefore(CreativeModeTabs.COMBAT)
                .icon(() -> icon.get().getDefaultInstance())
                .displayItems((parameters, output) -> {
                    output.accept(icon.get()); // Add the example item to the tab. For your own tabs, this
                                               // method is preferred over the event
                }).build());
    }
}
