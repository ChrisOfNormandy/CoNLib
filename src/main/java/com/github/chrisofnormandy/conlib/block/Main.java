package com.github.chrisofnormandy.conlib.block;

import java.util.List;

import com.github.chrisofnormandy.conlib.block.types.Bricks;
import com.github.chrisofnormandy.conlib.block.types.Rock;
import com.github.chrisofnormandy.conlib.block.types.Wood;
import com.github.chrisofnormandy.conlib.config.Config;
import com.github.chrisofnormandy.conlib.registry.ModRegister;

import net.minecraft.block.Block;
import net.minecraft.item.ItemGroup;

public class Main {
    public static String[] dyes = com.github.chrisofnormandy.conlib.item.Main.dyes;

    public static class Rock_ {
        public static Block create(int harvestLevel) {
            return Rock.create(harvestLevel);
        }

        public static List<Block> createProducts(Block parent) {
            return Rock.createProducts(parent);
        }

        public static Block register(String name, int harvestLevel, ItemGroup group) {
            return Rock.Register.single(name, harvestLevel, group);
        }

        public static List<Block> registerSuite(String name, int harvestLevel, List<ItemGroup> groups) {
            return Rock.Register.suite(name, harvestLevel, groups);
        }

        public static List<Block> registerSuiteWithVariants(String name, int harvestLevel, List<ItemGroup> groups) {
            return Rock.Register.suiteWithVariants(name, harvestLevel, groups);
        }
    }

    public static class Wood_ {
        public static Block create(int harvestLevel) {
            return Wood.create(harvestLevel);
        }

        public static List<Block> createProducts(Block parent) {
            return Wood.createProducts(parent);
        }

        public static Block register(String name, int harvestLevel, ItemGroup group) {
            return Wood.Register.single(name, harvestLevel, group);
        }

        public static List<Block> registerSuite(String name, int harvestLevel, List<ItemGroup> groups) {
            return Wood.Register.suite(name, harvestLevel, groups);
        }
    }

    public static class Bricks_ {
        public static Block create(int harvestLevel) {
            return Bricks.create(harvestLevel);
        }

        public static List<Block> createProducts(Block parent) {
            return Bricks.createProducts(parent);
        }

        public static Block register(String name, int harvestLevel, ItemGroup group) {
            return Bricks.Register.single(name, harvestLevel, group);
        }

        public static List<Block> registerSuite(String name, int harvestLevel, List<ItemGroup> groups) {
            return Bricks.Register.suite(name, harvestLevel, groups);
        }

        public static List<Block> registerSuiteWithVariants(String name, int harvestLevel, List<ItemGroup> groups) {
            return Bricks.Register.suiteWithVariants(name, harvestLevel, groups);
        }
    }

    public static class Node_ {
        public static Node create(Block parent, Node.Tier tier, int damage) {
            return new Node(Block.Properties.from(parent), tier, damage, parent.asItem());
        }

        public static void register(String name, Block parent, Node.Tier tier, ItemGroup group) {
            int crude = Config.getRangeValue("nodes_crude_tiers");
            int normal = Config.getRangeValue("nodes_normal_tiers");
            int rich = Config.getRangeValue("nodes_rich_tiers");
    
            int count = 0;
    
            switch (tier) {
                case CRUDE: {
                    count = crude;
                    break;
                }
                case NORMAL: {
                    count = normal;
                    break;
                }
                case RICH: {
                    count = rich;
                    break;
                }
            }
    
            Node n = create(parent, tier, count);
    
            Block node = ModRegister.registerBlock(name, n, group);
            ModRegister.nodes.put(node.getRegistryName().toString(), n);
    
            Block old_ = node;
            Block new_ = null;
    
            for (int i = count - 1; i >= 0; i--) {
                new_ = (i > 0)
                    ? ModRegister.registerBlock(name + "_" + i, create(parent, tier, i))
                    : parent;
    
                old_ = ModRegister.setBlock_replaceable(old_, new_);
    
                ModRegister.registerNode(new_.getRegistryName().toString(), n);
            }
        }
    }
}
