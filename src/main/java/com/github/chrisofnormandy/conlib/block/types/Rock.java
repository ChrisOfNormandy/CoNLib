package com.github.chrisofnormandy.conlib.block.types;

import java.util.LinkedList;
import java.util.List;

import com.github.chrisofnormandy.conlib.block.subsets.Subsets;
import com.github.chrisofnormandy.conlib.registry.ModRegister;

import net.minecraft.block.Block;
import net.minecraft.block.SoundType;
import net.minecraft.block.material.Material;
import net.minecraft.item.ItemGroup;
import net.minecraftforge.common.ToolType;

public class Rock {
    public static Block create(int harvestLevel) {
        return new Block(Block.Properties.create(Material.ROCK)
            .hardnessAndResistance(3.0f)
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
        public static Block single(String name, int harvestLevel, ItemGroup group) {
            return ModRegister.registerBlock(name, create(harvestLevel), group);
        }

        public static List<Block> products(String name, Block parent, List<ItemGroup> groups) {
            List<Block> products = createProducts(parent);
            List<Block> list = new LinkedList<Block>();

            list.add(ModRegister.registerBlock(name + "_slab", products.get(0), groups.get(0)));
            list.add(ModRegister.registerBlock(name + "_stairs", products.get(1), groups.get(1)));
            list.add(ModRegister.registerBlock(name + "_wall", products.get(2), groups.get(2)));

            return list;
        }

        public static List<Block> suite(String name, int harvestLevel, List<ItemGroup> groups) {
            Block parent = single(name, harvestLevel, groups.remove(0));
            
            List<Block> products = products(name, parent, groups);

            List<Block> list = new LinkedList<Block>();
            list.add(parent);
            list.addAll(products);

            return list;
        }

        public static List<Block> suiteWithVariants(String name, int harvestLevel, List<ItemGroup> groups) {
            List<Block> list = new LinkedList<Block>();
            
            List<ItemGroup> IG_groups = groups;
            ItemGroup blocksIG = groups.remove(0);

            Block self = single(name, harvestLevel, blocksIG);
            Block mossy = single("mossy_" + name, harvestLevel, blocksIG);
            Block cracked = single("cracked_" + name, harvestLevel, blocksIG);

            List<Block> selfSuite = suite(name, harvestLevel, IG_groups);
            List<Block> mossySuite = suite("mossy_" + name, harvestLevel, IG_groups);
            List<Block> crackedSuite = suite("cracked_" + name, harvestLevel, IG_groups);

            list.add(self);
            list.add(mossy);
            list.add(cracked);
            list.addAll(selfSuite);
            list.addAll(mossySuite);
            list.addAll(crackedSuite);

            return list;
        }
    }
}