package com.github.chrisofnormandy.conlib.blocks.decoration.lighting;

import com.github.chrisofnormandy.conlib.registry.BlockRegistry;

import net.minecraft.resources.ResourceKey;
import net.minecraft.world.item.CreativeModeTab;
import net.minecraft.world.level.block.Blocks;
import net.minecraft.world.level.block.CampfireBlock;
import net.minecraft.world.level.block.state.BlockBehaviour.Properties;
import net.minecraftforge.registries.RegistryObject;

public class Campfires {

    public static final RegistryObject<CampfireBlock> create(String name) {
        return create(name, Properties.copy(Blocks.CAMPFIRE), true, 1);
    }

    public static final RegistryObject<CampfireBlock> create(String name, ResourceKey<CreativeModeTab> creativeTab) {
        return create(name, Properties.copy(Blocks.CAMPFIRE), true, 1, creativeTab);
    }

    public static final RegistryObject<CampfireBlock> create(String name, Properties properties) {
        return create(name, properties, true, 1);
    }

    public static final RegistryObject<CampfireBlock> create(String name, Properties properties,
            ResourceKey<CreativeModeTab> creativeTab) {
        return create(name, properties, true, 1, creativeTab);
    }

    public static final RegistryObject<CampfireBlock> create(String name, Boolean spawnParticles) {
        return create(name, Properties.copy(Blocks.CAMPFIRE), spawnParticles, 1);
    }

    public static final RegistryObject<CampfireBlock> create(String name, Boolean spawnParticles,
            ResourceKey<CreativeModeTab> creativeTab) {
        return create(name, Properties.copy(Blocks.CAMPFIRE), spawnParticles, 1, creativeTab);
    }

    public static final RegistryObject<CampfireBlock> create(String name, Integer fireDamage) {
        return create(name, Properties.copy(Blocks.CAMPFIRE), true, fireDamage);
    }

    public static final RegistryObject<CampfireBlock> create(String name, Integer fireDamage,
            ResourceKey<CreativeModeTab> creativeTab) {
        return create(name, Properties.copy(Blocks.CAMPFIRE), true, fireDamage, creativeTab);
    }

    public static final RegistryObject<CampfireBlock> create(String name, Properties properties, Boolean spawnParticles,
            Integer fireDamage) {
        return BlockRegistry.register(name, () -> new CampfireBlock(spawnParticles, fireDamage, properties));
    }

    public static final RegistryObject<CampfireBlock> create(String name, Properties properties, Boolean spawnParticles,
            Integer fireDamage,
            ResourceKey<CreativeModeTab> creativeTab) {
        return BlockRegistry.register(name, () -> new CampfireBlock(spawnParticles, fireDamage, properties),
                creativeTab);
    }
}
