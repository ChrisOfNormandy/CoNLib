package com.github.chrisofnormandy.conlib.block;

import java.util.List;

import com.github.chrisofnormandy.conlib.block.types.BricksBase;
import com.github.chrisofnormandy.conlib.block.types.RockBase;
import com.github.chrisofnormandy.conlib.block.types.WoodBase;
import com.github.chrisofnormandy.conlib.itemgroup.GroupList;
import com.github.chrisofnormandy.conlib.itemgroup.Groups;

import net.minecraft.block.Block;

public class Main {
    public static String[] dyes = com.github.chrisofnormandy.conlib.item.Main.dyes;

    public static class Rock {
        public static Block create(int harvestLevel) {
            return RockBase.create(harvestLevel);
        }

        public static List<Block> createProducts(Block parent) {
            return RockBase.createProducts(parent);
        }

        public static Block register(String name, int harvestLevel, Groups group) {
            return RockBase.Register.single(name, harvestLevel, group);
        }

        public static List<Block> registerSuite(String name, int harvestLevel, GroupList groups) {
            return RockBase.Register.suite(name, harvestLevel, groups);
        }

        public static List<Block> registerSuiteWithVariants(String name, int harvestLevel, GroupList groups) {
            return RockBase.Register.suiteWithVariants(name, harvestLevel, groups);
        }
    }

    public static class Wood {
        public static Block create(int harvestLevel) {
            return WoodBase.create(harvestLevel);
        }

        public static List<Block> createProducts(Block parent) {
            return WoodBase.createProducts(parent);
        }

        public static Block register(String name, int harvestLevel, Groups group) {
            return WoodBase.Register.single(name, harvestLevel, group);
        }

        public static List<Block> registerSuite(String name, int harvestLevel, GroupList groups) {
            return WoodBase.Register.suite(name, harvestLevel, groups);
        }
    }

    public static class Bricks {
        public static Block create(int harvestLevel) {
            return BricksBase.create(harvestLevel);
        }

        public static List<Block> createProducts(Block parent) {
            return BricksBase.createProducts(parent);
        }

        public static Block register(String name, int harvestLevel, Groups group) {
            return BricksBase.Register.single(name, harvestLevel, group);
        }

        public static List<Block> registerSuite(String name, int harvestLevel, GroupList groups) {
            return BricksBase.Register.suite(name, harvestLevel, groups);
        }

        public static List<Block> registerSuiteWithVariants(String name, int harvestLevel, GroupList groups) {
            return BricksBase.Register.suiteWithVariants(name, harvestLevel, groups);
        }
    }

    public static class Node_ {
        public static Node create(Block parent, Node.Tier tier, int damage) {
            return new Node(Block.Properties.from(parent), tier, damage, parent.asItem());
        }

        public static void register(String name, Block parent, Node.Tier tier, Groups group) {
            // int crude = Config.getRangeValue("nodes_crude_tiers");
            // int normal = Config.getRangeValue("nodes_normal_tiers");
            // int rich = Config.getRangeValue("nodes_rich_tiers");
    
            // int count = 0;
    
            // switch (tier) {
            //     case CRUDE: {
            //         count = crude;
            //         break;
            //     }
            //     case NORMAL: {
            //         count = normal;
            //         break;
            //     }
            //     case RICH: {
            //         count = rich;
            //         break;
            //     }
            // }
    
            // Node n = create(parent, tier, count);
    
            // Block node = ModRegister.registerBlock(name, n, group);
            // ModRegister.nodes.put(node.getRegistryName().toString(), n);
    
            // Block old_ = node;
            // Block new_ = null;
    
            // for (int i = count - 1; i >= 0; i--) {
            //     new_ = (i > 0)
            //         ? ModRegister.registerBlock(name + "_" + i, create(parent, tier, i))
            //         : parent;
    
            //     old_ = ModRegister.setBlock_replaceable(old_, new_);
    
            //     ModRegister.registerNode(new_.getRegistryName().toString(), n);
            // }
        }
    }
}
