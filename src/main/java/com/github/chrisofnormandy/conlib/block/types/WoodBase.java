package com.github.chrisofnormandy.conlib.block.types;

import java.util.LinkedList;
import java.util.List;

import com.github.chrisofnormandy.conlib.block.subsets.Subsets;
import com.github.chrisofnormandy.conlib.itemgroup.GroupList;
import com.github.chrisofnormandy.conlib.itemgroup.Groups;
import com.github.chrisofnormandy.conlib.registry.Blocks;

import net.minecraft.block.Block;
import net.minecraft.block.SoundType;
import net.minecraft.block.material.Material;
import net.minecraftforge.common.ToolType;

public class WoodBase {
    /**
     * 
     * @param harvestLevel
     * @return
     */
    public static Block create(Integer harvestLevel) {
        return new Block(Block.Properties.of(Material.WOOD)
            .strength(2.0f)
            .sound(SoundType.WOOD)
            .harvestTool(ToolType.AXE)
            .harvestLevel(harvestLevel));
    }

    /**
     * 
     * @param harvestLevel
     * @param strength
     * @return
     */
    public static Block create(Integer harvestLevel, Float strength) {
        return new Block(Block.Properties.of(Material.WOOD)
            .strength(strength)
            .sound(SoundType.WOOD)
            .harvestTool(ToolType.AXE)
            .harvestLevel(harvestLevel));
    }

    /**
     * 
     * @param parent
     * @return
     */
    public static List<Block> createProducts(Block parent) {
        List<Block> list = new LinkedList<Block>();

        list.add(Subsets.create_slab(parent));
        list.add(Subsets.create_stairs(parent));
        list.add(Subsets.create_fence(parent));
        list.add(Subsets.create_fenceGate(parent));

        return list;
    }

    public static class Register {
        /**
         * 
         * @param name
         * @param harvestLevel
         * @param group
         * @return
         */
        public static Block single(String name, int harvestLevel, Groups group) {
            return Blocks.register(name, create(harvestLevel), group);
        }

        /**
         * 
         * @param name
         * @param harvestLevel
         * @param strength
         * @param group
         * @return
         */
        public static Block single(String name, int harvestLevel, Float strength, Groups group) {
            return Blocks.register(name, create(harvestLevel, strength), group);
        }

        /**
         * 
         * @param name
         * @param parent
         * @param groups
         * @return
         */
        public static List<Block> products(String name, Block parent, GroupList groups) {
            List<Block> products = createProducts(parent);
            List<Block> list = new LinkedList<Block>();

            list.add(Blocks.register(name + "_slab", products.get(0), groups.slabs));
            list.add(Blocks.register(name + "_stairs", products.get(1), groups.stairs));
            list.add(Blocks.register(name + "_fence", products.get(2), groups.fences));
            list.add(Blocks.register(name + "_fence_gate", products.get(3), groups.fences));

            return list;
        }

        /**
         * 
         * @param name
         * @param harvestLevel
         * @param groups
         * @return
         */
        public static List<Block> suite(String name, int harvestLevel, GroupList groups) {
            Block parent = single(name, harvestLevel, groups.blocks);
            
            List<Block> products = products(name, parent, groups);

            List<Block> list = new LinkedList<Block>();
            list.add(parent);
            list.addAll(products);

            return list;
        }
    }
}
