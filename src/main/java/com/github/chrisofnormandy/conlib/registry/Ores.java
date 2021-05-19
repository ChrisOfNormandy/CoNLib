package com.github.chrisofnormandy.conlib.registry;

import com.github.chrisofnormandy.conlib.block.types.OreBase;

import net.minecraft.block.Block;
import net.minecraft.item.ItemGroup;

public class Ores {
    /**
     * 
     * @param name    The generic block name, such as "my_block_ore."
     * @param oreBase The block instance.
     * @param group   The creative tab the item should be grouped in.
     * @return Block
     */
    public static Block register(String name, OreBase oreBase, ItemGroup group) {
        return Blocks.register(name, oreBase, group);
    }
}
