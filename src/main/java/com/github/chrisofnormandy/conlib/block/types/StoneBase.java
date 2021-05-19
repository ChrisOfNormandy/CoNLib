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

public class StoneBase {
    /**
     * 
     * @param harvestLevel
     * @return
     */
    public static Block create(Integer harvestLevel) {
        return new Block(Block.Properties.of(Material.STONE).requiresCorrectToolForDrops().strength(1.5f)
                .sound(SoundType.STONE).harvestTool(ToolType.PICKAXE).harvestLevel(harvestLevel));
    }

    /**
     * 
     * @param harvestLevel
     * @param strength
     * @return
     */
    public static Block create(Integer harvestLevel, Float strength) {
        return new Block(Block.Properties.of(Material.STONE).requiresCorrectToolForDrops().strength(strength)
                .sound(SoundType.STONE).harvestTool(ToolType.PICKAXE).harvestLevel(harvestLevel));
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
        list.add(Subsets.create_wall(parent));

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
        public static Block single(String name, Integer harvestLevel, Groups group) {
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
        public static Block single(String name, Integer harvestLevel, Float strength, Groups group) {
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
            list.add(Blocks.register(name + "_wall", products.get(2), groups.walls));

            return list;
        }

        /**
         * 
         * @param name
         * @param parent
         * @param groups
         * @return
         */
        public static List<Block> suite(String name, Block parent, GroupList groups) {
            List<Block> products = products(name, parent, groups);

            List<Block> list = new LinkedList<Block>();
            list.add(parent);
            list.addAll(products);

            return list;
        }

        /**
         * 
         * @param name
         * @param parent
         * @param groups
         * @return
         */
        public static List<Block> suiteWithVariants(String name, Block parent, GroupList groups) {
            List<Block> list = new LinkedList<Block>();

            List<Block> selfSuite = suite(name, parent, groups);
            List<Block> mossySuite = suite("mossy_" + name, parent, groups);
            List<Block> crackedSuite = suite("cracked_" + name, parent, groups);

            list.addAll(selfSuite);
            list.addAll(mossySuite);
            list.addAll(crackedSuite);

            return list;
        }
    }
}