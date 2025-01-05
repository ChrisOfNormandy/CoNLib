package com.github.chrisofnormandy.conlib.blocks.decoration;

import com.github.chrisofnormandy.conlib.registry.BlockRegistry;

import net.minecraft.resources.ResourceKey;
import net.minecraft.world.item.CreativeModeTab;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.Blocks;
import net.minecraft.world.level.block.CampfireBlock;
import net.minecraft.world.level.block.state.BlockBehaviour.Properties;

public class Campfires {
    public static final Block create_campfire(String name, Boolean spawnParticles, Integer fireDamage) {
        return BlockRegistry.register(name,
                new CampfireBlock(spawnParticles, fireDamage, Properties.copy(Blocks.CAMPFIRE)));
    }

    public static final Block create_campfire(String name, Boolean spawnParticles, Integer fireDamage,
            ResourceKey<CreativeModeTab> creativeTab) {
        return BlockRegistry.register(name,
                new CampfireBlock(spawnParticles, fireDamage, Properties.copy(Blocks.CAMPFIRE)), creativeTab);
    }

    public static final Block create_campfire(String name, Boolean spawnParticles, Integer fireDamage,
            Properties properties) {
        return BlockRegistry.register(name, new CampfireBlock(spawnParticles, fireDamage, properties));
    }

    public static final Block create_campfire(String name, Boolean spawnParticles, Integer fireDamage,
            Properties properties, ResourceKey<CreativeModeTab> creativeTab) {
        return BlockRegistry.register(name, new CampfireBlock(spawnParticles, fireDamage, properties), creativeTab);
    }
}
