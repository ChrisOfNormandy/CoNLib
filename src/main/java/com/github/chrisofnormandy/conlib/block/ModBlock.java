package com.github.chrisofnormandy.conlib.block;

import java.util.List;

import com.github.chrisofnormandy.conlib.block.types.BricksBase;
import com.github.chrisofnormandy.conlib.block.types.NodeBase;
import com.github.chrisofnormandy.conlib.block.types.OreBase;
import com.github.chrisofnormandy.conlib.block.types.RockBase;
import com.github.chrisofnormandy.conlib.block.types.WoodBase;
import com.github.chrisofnormandy.conlib.itemgroup.GroupList;
import com.github.chrisofnormandy.conlib.itemgroup.Groups;
import com.github.chrisofnormandy.conlib.tool.ToolMaterial;

import net.minecraft.block.Block;

public class ModBlock {
    public static String[] dyes = com.github.chrisofnormandy.conlib.item.ModItem.dyes;

    public static class Rock {
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
            return RockBase.create(harvestLevel);
        }

        /**
         * @param harvestLevel
         * <p>Gold: 0</p>
         * <p>Wood: 0</p>
         * <p>Stone: 1</p>
         * <p>Iron: 2</p>
         * <p>Diamond: 3</p>
         * <p>Netherite: 4</p>
         * @param hardness
         * <p>Obsidian: 50</p>
         * <p>Ancient Debris: 30</p>
         * <p>Ender Chest: 22.5</p>
         * <p>Block of Iron: 5</p>
         * <p>Cobweb: 4</p>
         * <p>Furnace: 3.5</p>
         * <p>Iron Ore: 3</p>
         * <p>Crafting Table: 2.5</p>
         * <p>Bricks: 2</p>
         * <p>Concrete: 1.8</p>
         * <p>Stone: 1.5</p>
         * <p>Pumpkin: 1</p>
         * <p>Sandstone: 0.8</p>
         * <p>Rail: 0.7</p>
         * <p>Clay: 0.6</p>
         * <p>Dirt: 0.5</p>
         * <p>Netherrack: 0.4</p>
         * <p>Glass: 0.3</p>
         * <p>Leaves: 0.2</p>
         * <p>Carpet: 0.1</p>
         * <p>Fire: 0</p>
         * @return A block.
         */
        public static Block create(Integer harvestLevel, Float hardness) {
            return RockBase.create(harvestLevel, hardness);
        }

        public static List<Block> createProducts(Block parent) {
            return RockBase.createProducts(parent);
        }

        public static Block register(String name, Integer harvestLevel, Groups group) {
            return RockBase.Register.single(name, harvestLevel, group);
        }

        /**
         * Registers a slab, stairs and wall block based on the parent.
         * @param name The root block name.
         * @param parent The parent block to base properties from.
         * @param groups List of creative tab groups.
         * @return
         */
        public static List<Block> registerSuite(String name, Block parent, GroupList groups) {
            return RockBase.Register.suite(name, parent, groups);
        }

        /**
         * Registers a slab, stairs and wall block based on the parent, plus a mossy and cracked version.
         * @param name The root block name.
         * @param parent The parent block to base properties from.
         * @param groups List of creative tab groups.
         * @return
         */
        public static List<Block> registerSuiteWithVariants(String name, Block parent, GroupList groups) {
            return RockBase.Register.suiteWithVariants(name, parent, groups);
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
        public static Block create(Integer minXP, Integer maxXP, Integer harvestLevel) {
            return new OreBase(minXP, maxXP, harvestLevel);
        }

        /**
         * @param harvestLevel
         * <p>Gold: 0</p>
         * <p>Wood: 0</p>
         * <p>Stone: 1</p>
         * <p>Iron: 2</p>
         * <p>Diamond: 3</p>
         * <p>Netherite: 4</p>
         * @param hardness
         * <p>Obsidian: 50</p>
         * <p>Ancient Debris: 30</p>
         * <p>Ender Chest: 22.5</p>
         * <p>Block of Iron: 5</p>
         * <p>Cobweb: 4</p>
         * <p>Furnace: 3.5</p>
         * <p>Iron Ore: 3</p>
         * <p>Crafting Table: 2.5</p>
         * <p>Bricks: 2</p>
         * <p>Concrete: 1.8</p>
         * <p>Stone: 1.5</p>
         * <p>Pumpkin: 1</p>
         * <p>Sandstone: 0.8</p>
         * <p>Rail: 0.7</p>
         * <p>Clay: 0.6</p>
         * <p>Dirt: 0.5</p>
         * <p>Netherrack: 0.4</p>
         * <p>Glass: 0.3</p>
         * <p>Leaves: 0.2</p>
         * <p>Carpet: 0.1</p>
         * <p>Fire: 0</p>
         * @return A block.
         */
        public static Block create(Integer minXP, Integer maxXP, Integer harvestLevel, Float hardness) {
            return new OreBase(minXP, maxXP, harvestLevel, hardness);
        }

        public static Block register(String name, Integer minXP, Integer maxXP, Integer harvestLevel, Groups group) {
            return OreBase.Register.single(name, minXP, maxXP, harvestLevel, group);
        }

        public static Block register(String name, Integer minXP, Integer maxXP, Integer harvestLevel, Float hardness,
                Groups group) {
            return OreBase.Register.single(name, minXP, maxXP, harvestLevel, hardness, group);
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
            return new NodeBase(Block.Properties.from(parent), tier, damage, parent.asItem());
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
