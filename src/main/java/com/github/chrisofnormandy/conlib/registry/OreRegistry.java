package com.github.chrisofnormandy.conlib.registry;

import com.github.chrisofnormandy.conlib.block.types.OreBase;

import net.minecraft.world.level.block.Block;
import net.minecraft.resources.ResourceKey;
import net.minecraft.world.item.CreativeModeTab;

public class OreRegistry {
    /**
     *
     * @param name
     * @param oreBase
     * @param group
     * @return
     */
    public static final Block register(String name, OreBase oreBase, ResourceKey<CreativeModeTab> creativeTab) {
        return BlockRegistry.register(name, oreBase, creativeTab);
    }
}
