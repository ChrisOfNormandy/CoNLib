package com.github.chrisofnormandy.conlib.registry;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.function.Supplier;

import com.github.chrisofnormandy.conlib.collections.Tuple;
import com.github.chrisofnormandy.conlib.mobs.types.CustomAnimal;
import com.github.chrisofnormandy.conlib.registry.BlockRegistry.BlockRegistryInit;
import com.github.chrisofnormandy.conlib.registry.CreativeTabRegistry.CreativeTabRegistryInit;
import com.github.chrisofnormandy.conlib.registry.ItemRegistry.ItemRegistryInit;
import com.github.chrisofnormandy.conlib.registry.MobRegistry.MobRegistryInit;

import net.minecraft.resources.ResourceKey;
import net.minecraft.world.entity.EntityType;
import net.minecraft.world.entity.ai.attributes.AttributeSupplier;
import net.minecraft.world.item.ArmorItem;
import net.minecraft.world.item.CreativeModeTab;
import net.minecraft.world.item.Item;
import net.minecraft.world.level.block.Block;
import net.minecraftforge.eventbus.api.IEventBus;
import net.minecraftforge.registries.RegistryObject;

public class ModRegister {

    // CREATIVE TAB ASSIGNMENTS
    public static final HashMap<ResourceKey<CreativeModeTab>, List<RegistryObject<? extends Item>>> creativeTabs = new HashMap<>();

    public static <T extends Item> RegistryObject<T> useCreativeTab(ResourceKey<CreativeModeTab> tab,
            RegistryObject<T> item) {
        var items = creativeTabs.get(tab);
        if (items == null) {
            items = new ArrayList<>();
            creativeTabs.put(tab, items);
        }

        items.add(item);

        return item;
    }

    public static final HashMap<RegistryObject<EntityType<CustomAnimal>>, Supplier<AttributeSupplier.Builder>> entityAttributes = new HashMap<>();
    public static final HashMap<String, Tuple<String, RegistryObject<EntityType<CustomAnimal>>>> entityRendering = new HashMap<>();

    public static void defineEntityAttributes(RegistryObject<EntityType<CustomAnimal>> entity,
            Supplier<AttributeSupplier.Builder> builder) {
        entityAttributes.put(entity, builder);
    }

    public static final HashMap<String, Object> events = new HashMap<>();
    public static final HashMap<String, RegistryObject<CreativeModeTab>> groups = new HashMap<>();
    public static final HashMap<String, RegistryObject<? extends Block>> blocks = new HashMap<>();
    public static final HashMap<String, RegistryObject<? extends Block>> transparentBlocks = new HashMap<>();
    public static final HashMap<String, RegistryObject<? extends Item>> items = new HashMap<>();
    public static final HashMap<String, RegistryObject<? extends Item>> tools = new HashMap<>();
    public static final HashMap<String, RegistryObject<? extends Item>> weapons = new HashMap<>();
    public static final HashMap<String, RegistryObject<? extends ArmorItem>> wearable = new HashMap<>();
    public static final HashMap<String, RegistryObject<? extends Item>> foods = new HashMap<>();
    public static final HashMap<String, RegistryObject<? extends EntityType<?>>> entities = new HashMap<>();

    public static void initRegistries(String modId) {
        BlockRegistryInit.init(modId);
        ItemRegistryInit.init(modId);
        CreativeTabRegistryInit.init(modId);
        MobRegistryInit.init(modId);
    }

    public static void finishRegistries(IEventBus bus, String modId) {
        BlockRegistryInit.finish(bus, modId);
        ItemRegistryInit.finish(bus, modId);
        CreativeTabRegistryInit.finish(bus, modId);
        MobRegistryInit.finish(bus, modId);
    }
}