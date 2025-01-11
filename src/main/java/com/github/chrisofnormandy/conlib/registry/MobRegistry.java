package com.github.chrisofnormandy.conlib.registry;

import java.util.HashMap;
import java.util.Map;

import org.slf4j.Logger;

import com.github.chrisofnormandy.conlib.CoNLib;
import com.github.chrisofnormandy.conlib.collections.Tuple;
import com.github.chrisofnormandy.conlib.mobs.types.CustomAnimal;
import com.mojang.logging.LogUtils;

import net.minecraft.world.entity.EntityType;
import net.minecraft.world.entity.EntityType.EntityFactory;
import net.minecraft.world.entity.MobCategory;
import net.minecraftforge.eventbus.api.IEventBus;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.ForgeRegistries;
import net.minecraftforge.registries.RegistryObject;

public class MobRegistry {
    private static final Logger LOGGER = LogUtils.getLogger();

    public static class MobRegistryInit {
        private static String MOD_ID = CoNLib.MOD_ID;

        private static final Map<String, DeferredRegister<EntityType<?>>> ENTITIES = new HashMap<>();

        public static final void using(String modId) {
            MOD_ID = modId;
            LOGGER.info("ENTITIES USE " + MOD_ID);
        }

        public static final void init(String modId) {
            ENTITIES.put(modId, DeferredRegister.create(ForgeRegistries.ENTITY_TYPES, modId));
            using(modId);
        }

        private static final DeferredRegister<EntityType<?>> get() {
            LOGGER.info("REGISTER ENTITY UNDER " + MOD_ID);
            return ENTITIES.get(MOD_ID);
        }

        public static final void finish(IEventBus bus, String modId) {
            ENTITIES.get(modId).register(bus);
            using(modId);
        }
    }

    public static final RegistryObject<EntityType<CustomAnimal>> register(String name,
            EntityFactory<CustomAnimal> factory) {
        var registry = MobRegistryInit.get().register(name, () -> EntityType.Builder.of(factory, MobCategory.CREATURE)
                .sized(0.6F, 1.8F)
                .build(name));
        ModRegister.entities.put(name, registry);
        ModRegister.defineEntityAttributes(registry, () -> CustomAnimal.createAttributes());
        ModRegister.entityRendering.put(name, new Tuple<>(MobRegistryInit.MOD_ID, registry));

        return registry;
    }
}
