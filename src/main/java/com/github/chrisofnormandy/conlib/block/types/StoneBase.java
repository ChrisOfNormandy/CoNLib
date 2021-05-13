package com.github.chrisofnormandy.conlib.block.types;

import java.util.LinkedList;
import java.util.List;

import com.github.chrisofnormandy.conlib.block.subsets.Subsets;
import com.github.chrisofnormandy.conlib.itemgroup.GroupList;
import com.github.chrisofnormandy.conlib.itemgroup.Groups;
import com.github.chrisofnormandy.conlib.registry.ModRegister;

import net.minecraft.block.Block;
import net.minecraft.block.SoundType;
import net.minecraft.block.material.Material;
import net.minecraftforge.common.ToolType;

public class StoneBase {
    public static Block create(Integer harvestLevel) {
        return new Block(Block.Properties.of(Material.STONE)
            .requiresCorrectToolForDrops()
            .strength(1.5f)
            .sound(SoundType.STONE)
            .harvestTool(ToolType.PICKAXE)
            .harvestLevel(harvestLevel));
    }

    public static Block create(Integer harvestLevel, Float strength) {
        return new Block(Block.Properties.of(Material.STONE)
            .requiresCorrectToolForDrops()
            .strength(strength)
            .sound(SoundType.STONE)
            .harvestTool(ToolType.PICKAXE)
            .harvestLevel(harvestLevel));
    }

    public static List<Block> createProducts(Block parent) {
        List<Block> list = new LinkedList<Block>();

        list.add(Subsets.create_slab(parent));
        list.add(Subsets.create_stairs(parent));
        list.add(Subsets.create_wall(parent));

        return list;
    }

    public static class Register {
        public static Block single(String name, Integer harvestLevel, Groups group) {
            return ModRegister.registerBlock(name, create(harvestLevel), group);
        }

        public static Block single(String name, Integer harvestLevel, Float strength, Groups group) {
            return ModRegister.registerBlock(name, create(harvestLevel, strength), group);
        }

        public static List<Block> products(String name, Block parent, GroupList groups) {
            List<Block> products = createProducts(parent);
            List<Block> list = new LinkedList<Block>();

            list.add(ModRegister.registerBlock(name + "_slab", products.get(0), groups.slabs));
            list.add(ModRegister.registerBlock(name + "_stairs", products.get(1), groups.stairs));
            list.add(ModRegister.registerBlock(name + "_wall", products.get(2), groups.walls));

            return list;
        }

        public static List<Block> suite(String name, Block parent, GroupList groups) {           
            List<Block> products = products(name, parent, groups);

            List<Block> list = new LinkedList<Block>();
            list.add(parent);
            list.addAll(products);

            return list;
        }

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