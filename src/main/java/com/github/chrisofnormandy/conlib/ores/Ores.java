package com.github.chrisofnormandy.conlib.ores;

import com.github.chrisofnormandy.conlib.items.ModItem;
import com.github.chrisofnormandy.conlib.ores.types.Ore;
import com.github.chrisofnormandy.conlib.registry.BlockRegistry;
import com.github.chrisofnormandy.conlib.registry.features.OreFeature;

import net.minecraft.resources.ResourceKey;
import net.minecraft.world.item.CreativeModeTab;
import net.minecraft.world.item.Tier;
import net.minecraft.world.level.block.Blocks;
import net.minecraft.world.level.block.state.BlockBehaviour.Properties;
import net.minecraftforge.registries.RegistryObject;

// RedstoneOre

public class Ores {

    public static class GemOre {
        public static final void create(String name,
                net.minecraft.world.item.Item.Properties toolProperties,
                Tier toolTier,
                ResourceKey<CreativeModeTab> creativeTab_Item,
                ResourceKey<CreativeModeTab> creativeTab_Block) {
            ModItem.create(name, creativeTab_Item);
            Ores.create(name + "_ore", creativeTab_Block);
        }
    }

    public static class MetalOre {
        public static final void create(String name,
                net.minecraft.world.item.Item.Properties ingotProperties,
                net.minecraft.world.item.Item.Properties toolProperties,
                Tier toolTier,
                ResourceKey<CreativeModeTab> creativeTab_Item,
                ResourceKey<CreativeModeTab> creativeTab_Block) {
            ModItem.create(name + "_ingot", ingotProperties, creativeTab_Item);
            ModItem.create(name + "_nugget", ingotProperties, creativeTab_Item);
            Ores.create(name + "_ore", creativeTab_Block);
        }
    }

    public static final RegistryObject<Ore> create(String name) {
        return create(name, Properties.copy(Blocks.IRON_ORE));
    }

    public static final RegistryObject<Ore> create(String name, ResourceKey<CreativeModeTab> creativeTab) {
        return create(name, Properties.copy(Blocks.IRON_ORE), creativeTab);
    }

    public static final RegistryObject<Ore> create(String name, Properties properties) {
        var ore = BlockRegistry.register(name, () -> new Ore(properties.requiresCorrectToolForDrops()));
        OreFeature.register(name, ore.get());

        return ore;
    }

    public static final RegistryObject<Ore> create(String name, Properties properties,
            ResourceKey<CreativeModeTab> creativeTab) {
        var ore = BlockRegistry.register(name, () -> new Ore(properties.requiresCorrectToolForDrops()), creativeTab);
        OreFeature.register(name, ore.get());

        return ore;
    }
}
