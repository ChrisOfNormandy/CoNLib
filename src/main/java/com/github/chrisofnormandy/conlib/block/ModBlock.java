package com.github.chrisofnormandy.conlib.block;

import java.util.List;

import com.github.chrisofnormandy.conlib.block.types.BricksBase;
import com.github.chrisofnormandy.conlib.block.types.OreBase;
import com.github.chrisofnormandy.conlib.block.types.StoneBase;
import com.github.chrisofnormandy.conlib.block.types.WoodBase;
import com.github.chrisofnormandy.conlib.block.types.custom.NodeBase;
import com.github.chrisofnormandy.conlib.itemgroup.GroupList;
import com.github.chrisofnormandy.conlib.itemgroup.Groups;
import com.github.chrisofnormandy.conlib.tool.ToolMaterial;

import net.minecraft.block.Block;

public class ModBlock {
    public static String[] dyes = com.github.chrisofnormandy.conlib.item.ModItem.dyes;

    public static class Stone {
        /**
         * @param harvestLevel
         * <p>Gold: 0</p>
         * <p>Wood: 0</p>
         * <p>Stone: 1</p>
         * <p>Iron: 2</p>
         * <p>Diamond: 3</p>
         * <p>Netherite: 4</p>
         * @return A block with default 1.5 hardness - stone.
         */
        public static Block create(Integer harvestLevel) {
            return StoneBase.create(harvestLevel);
        }

        public static List<Block> createProducts(Block parent) {
            return StoneBase.createProducts(parent);
        }

        public static Block register(String name, Integer harvestLevel, Groups group) {
            return StoneBase.Register.single(name, harvestLevel, group);
        }

        /**
         * Registers a slab, stairs and wall block based on the parent.
         * @param name The root block name.
         * @param parent The parent block to base properties from.
         * @param groups List of creative tab groups.
         * @return
         */
        public static List<Block> registerSuite(String name, Block parent, GroupList groups) {
            return StoneBase.Register.suite(name, parent, groups);
        }

        /**
         * Registers a slab, stairs and wall block based on the parent, plus a mossy and cracked version.
         * @param name The root block name.
         * @param parent The parent block to base properties from.
         * @param groups List of creative tab groups.
         * @return
         */
        public static List<Block> registerSuiteWithVariants(String name, Block parent, GroupList groups) {
            return StoneBase.Register.suiteWithVariants(name, parent, groups);
        }
    }

    public static class Wood {
        public static Block create(Integer harvestLevel) {
            return WoodBase.create(harvestLevel);
        }

        public static List<Block> createProducts(Block parent) {
            return WoodBase.createProducts(parent);
        }

        public static Block register(String name, Integer harvestLevel, Groups group) {
            return WoodBase.Register.single(name, harvestLevel, group);
        }

        public static List<Block> registerSuite(String name, Integer harvestLevel, GroupList groups) {
            return WoodBase.Register.suite(name, harvestLevel, groups);
        }
    }

    public static class Bricks {
        public static Block create(Integer harvestLevel) {
            return BricksBase.create(harvestLevel);
        }

        public static List<Block> createProducts(Block parent) {
            return BricksBase.createProducts(parent);
        }

        public static Block register(String name, Integer harvestLevel, Groups group) {
            return BricksBase.Register.single(name, harvestLevel, group);
        }

        public static List<Block> registerSuite(String name, Integer harvestLevel, GroupList groups) {
            return BricksBase.Register.suite(name, harvestLevel, groups);
        }

        public static List<Block> registerSuiteWithVariants(String name, Integer harvestLevel, GroupList groups) {
            return BricksBase.Register.suiteWithVariants(name, harvestLevel, groups);
        }
    }

    public static class Ore {
        /**
         * @param harvestLevel
         * <p>Gold: 0</p>
         * <p>Wood: 0</p>
         * <p>Stone: 1</p>
         * <p>Iron: 2</p>
         * <p>Diamond: 3</p>
         * <p>Netherite: 4</p>
         * @return A block with default 3 hardness - iron ore.
         */
        public static Block create(Integer harvestLevel) {
            return new OreBase(harvestLevel);
        }

        public static Block register(String name, Integer minXP, Integer maxXP, Integer harvestLevel, Groups group) {
            return OreBase.Register.single(name, minXP, maxXP, harvestLevel, group);
        }

        public static Block register(String name, OreBase block, Groups group) {
            return OreBase.Register.single(name, block, group);
        }

        public static Block registerGem(String name, String oreName, OreBase block, ToolMaterial material,
                Groups itemGroup, Groups toolGroup, Groups blockGroup) {
            return OreBase.Register.asGem(name, oreName, block, material, itemGroup, toolGroup, blockGroup);
        }

        public static Block registerMetal(String name, String oreName, OreBase block, ToolMaterial material,
                Groups itemGroup, Groups toolGroup, Groups blockGroup) {
            return OreBase.Register.asMetal(name, oreName, block, material, itemGroup, toolGroup, blockGroup);
        }
    }

    public static class Node_ {
        public static NodeBase create(Block parent, NodeBase.Tier tier, Integer damage) {
            return new NodeBase(Block.Properties.copy(parent), tier, damage, parent.asItem());
        }

        public static void register(String name, Block parent, NodeBase.Tier tier, Groups group) {
            // Integer crude = Config.getRangeValue("nodes_crude_tiers");
            // Integer normal = Config.getRangeValue("nodes_normal_tiers");
            // Integer rich = Config.getRangeValue("nodes_rich_tiers");
    
            // Integer count = 0;
    
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
    
            // for (Integer i = count - 1; i >= 0; i--) {
            //     new_ = (i > 0)
            //         ? ModRegister.registerBlock(name + "_" + i, create(parent, tier, i))
            //         : parent;
    
            //     old_ = ModRegister.setBlock_replaceable(old_, new_);
    
            //     ModRegister.registerNode(new_.getRegistryName().toString(), n);
            // }
        }
    }
}
