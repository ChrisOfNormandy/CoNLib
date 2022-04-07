package com.github.chrisofnormandy.conlib.registry;

import com.github.chrisofnormandy.conlib.block.types.OreBase;

import net.minecraft.world.level.block.Block;
import net.minecraft.world.item.CreativeModeTab;

public class OreRegistry {
    /**
     * 
     * @param name
     * @param oreBase
     * @param group
     * @return
     */
    public static final Block register(String name, OreBase oreBase, CreativeModeTab group) {
        return BlockRegistry.register(name, oreBase, group);
    }
}
