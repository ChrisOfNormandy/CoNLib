package com.github.chrisofnormandy.conlib.registry;

import com.github.chrisofnormandy.conlib.block.types.OreBase;

import net.minecraft.block.Block;
import net.minecraft.item.ItemGroup;

public class OreRegistry {
    /**
     * 
     * @param name
     * @param oreBase
     * @param group
     * @return
     */
    public static final Block register(String name, OreBase oreBase, ItemGroup group) {
        return BlockRegistry.register(name, oreBase, group);
    }
}
