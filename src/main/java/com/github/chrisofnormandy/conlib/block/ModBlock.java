package com.github.chrisofnormandy.conlib.block;

import com.github.chrisofnormandy.conlib.block.decoration.Utility;
import com.github.chrisofnormandy.conlib.block.subsets.*;
import com.github.chrisofnormandy.conlib.block.types.OreBase;
import com.github.chrisofnormandy.conlib.block.types.custom.NodeBase;
import com.github.chrisofnormandy.conlib.registry.Blocks;
import com.github.chrisofnormandy.conlib.tool.ToolMaterial;

import net.minecraft.block.Block;
import net.minecraft.block.RotatedPillarBlock;
import net.minecraft.block.AbstractBlock.Properties;
import net.minecraft.item.DyeColor;
import net.minecraft.item.ItemGroup;

public class ModBlock {
    public static final String[] dyes = com.github.chrisofnormandy.conlib.item.ModItem.dyes;

    public static class Ore {
        /**
         * 
         * @param harvestLevel
         * @return
         */
        public static final Block create(Integer harvestLevel) {
            return new OreBase(harvestLevel);
        }

        /**
         * 
         * @param harvestLevel
         * @param strength
         * @return
         */
        public static final Block create(Integer harvestLevel, Float strength) {
            return new OreBase(harvestLevel, strength);
        }

        /**
         * 
         * @param name
         * @param harvestLevel
         * @param group
         * @return
         */
        public static final Block register(String name, Integer harvestLevel, ItemGroup group) {
            return OreBase.Register.single(name, harvestLevel, group);
        }

        /**
         * 
         * @param name
         * @param harvestLevel
         * @param strength
         * @param group
         * @return
         */
        public static final Block register(String name, Integer harvestLevel, Float strength, ItemGroup group) {
            return OreBase.Register.single(name, harvestLevel, strength, group);
        }

        /**
         * 
         * @param name
         * @param block
         * @param group
         * @return
         */
        public static final Block register(String name, OreBase block, ItemGroup group) {
            return OreBase.Register.single(name, block, group);
        }

        /**
         * 
         * @param name
         * @param oreName
         * @param block
         * @param material
         * @param itemGroup
         * @param toolGroup
         * @param blockGroup
         * @return
         */
        public static final Block registerGem(String name, String oreName, OreBase block, ToolMaterial material,
                ItemGroup itemGroup, ItemGroup toolGroup, ItemGroup blockGroup) {
            return OreBase.Register.asGem(name, oreName, block, material, itemGroup, toolGroup, blockGroup);
        }

        /**
         * 
         * @param name
         * @param oreName
         * @param block
         * @param material
         * @param itemGroup
         * @param toolGroup
         * @param blockGroup
         * @return
         */
        public static final Block registerMetal(String name, String oreName, OreBase block, ToolMaterial material,
                ItemGroup itemGroup, ItemGroup toolGroup, ItemGroup blockGroup) {
            return OreBase.Register.asMetal(name, oreName, block, material, itemGroup, toolGroup, blockGroup);
        }
    }

    public static class Generic {
        /**
         * 
         * @param name
         * @param properties
         * @return
         */
        public static final Block create(String name, Properties properties) {
            return Blocks.register(name, new Block(properties));
        }

        /**
         * 
         * @param name
         * @param properties
         * @param group
         * @return
         */
        public static final Block create(String name, Properties properties, ItemGroup group) {
            return Blocks.register(name, new Block(properties), group);
        }

        /**
         * 
         * @param name
         * @param properties
         * @return
         */
        public static final Block createColumn(String name, Properties properties) {
            return Blocks.register(name, new RotatedPillarBlock(properties));
        }

        /**
         * 
         * @param name
         * @param properties
         * @param group
         * @return
         */
        public static final Block createColumn(String name, Properties properties, ItemGroup group) {
            return Blocks.register(name, new RotatedPillarBlock(properties), group);
        }

        /**
         * 
         * @param name
         * @param properties
         * @return
         */
        public static final Block createTransparent(String name, Properties properties) {
            return Blocks.register(name, new Block(properties.noCollission()), true);
        }

        /**
         * 
         * @param name
         * @param properties
         * @param group
         * @return
         */
        public static final Block createTransparent(String name, Properties properties, ItemGroup group) {
            return Blocks.register(name, new Block(properties.noCollission()), group, true);
        }

        /**
         * 
         * @param name
         * @param parent
         * @return
         */
        public static final Block createSlab(String name, Block parent) {
            return Blocks.register(name, Subsets.create_slab(parent));
        }

        /**
         * 
         * @param name
         * @param parent
         * @param group
         * @return
         */
        public static final Block createSlab(String name, Block parent, ItemGroup group) {
            return Blocks.register(name, Subsets.create_slab(parent), group);
        }

        /**
         * 
         * @param name
         * @param parent
         * @return
         */
        public static final Block createStairs(String name, Block parent) {
            return Blocks.register(name, Subsets.create_stairs(parent));
        }

        /**
         * 
         * @param name
         * @param parent
         * @param group
         * @return
         */
        public static final Block createStairs(String name, Block parent, ItemGroup group) {
            return Blocks.register(name, Subsets.create_stairs(parent), group);
        }

        /**
         * 
         * @param name
         * @param parent
         * @return
         */
        public static final Block createWall(String name, Block parent) {
            return Blocks.register(name, Subsets.create_wall(parent));
        }

        /**
         * 
         * @param name
         * @param parent
         * @param group
         * @return
         */
        public static final Block createWall(String name, Block parent, ItemGroup group) {
            return Blocks.register(name, Subsets.create_wall(parent), group);
        }

        /**
         * 
         * @param name
         * @param parent
         * @return
         */
        public static final Block createFence(String name, Block parent) {
            return Blocks.register(name, Subsets.create_fence(parent));
        }

        /**
         * 
         * @param name
         * @param parent
         * @param group
         * @return
         */
        public static final Block createFence(String name, Block parent, ItemGroup group) {
            return Blocks.register(name, Subsets.create_fence(parent), group);
        }
    }

    public static class RedstoneGeneric {
        /**
         * 
         * @param name
         * @param parent
         * @return
         */
        public static final Block createFenceGate(String name, Block parent) {
            return Blocks.register(name, Subsets.create_fenceGate(parent));
        }

        /**
         * 
         * @param name
         * @param parent
         * @param group
         * @return
         */
        public static final Block createFenceGate(String name, Block parent, ItemGroup group) {
            return Blocks.register(name, Subsets.create_fenceGate(parent), group);
        }

        /**
         * 
         * @param name
         * @param parent
         * @return
         */
        public static final Block createDoor(String name, Block parent) {
            return Blocks.register(name, Subsets.create_door(parent), true);
        }

        /**
         * 
         * @param name
         * @param parent
         * @param group
         * @return
         */
        public static final Block createDoor(String name, Block parent, ItemGroup group) {
            return Blocks.register(name, Subsets.create_door(parent), group, true);
        }

        /**
         * 
         * @param name
         * @param parent
         * @return
         */
        public static final Block createTrapdoor(String name, Block parent) {
            return Blocks.register(name, Subsets.create_trapdoor(parent), true);
        }

        /**
         * 
         * @param name
         * @param parent
         * @param group
         * @return
         */
        public static final Block createTrapdoor(String name, Block parent, ItemGroup group) {
            return Blocks.register(name, Subsets.create_trapdoor(parent), group, true);
        }

        /**
         * 
         * @param name
         * @param parent
         * @param group
         * @return
         */
        public static final Block createPressurePlate_stone(String name, Block parent, ItemGroup group) {
            return Blocks.register(name, Redstone.create_pressurePlate_stone(parent), group);
        }

        /**
         * 
         * @param name
         * @param parent
         * @param group
         * @return
         */
        public static final Block createPressurePlate_wood(String name, Block parent, ItemGroup group) {
            return Blocks.register(name, Redstone.create_pressurePlate_wood(parent), group);
        }

        /**
         * 
         * @param name
         * @param parent
         * @param group
         * @return
         */
        public static final Block createButton_stone(String name, Block parent, ItemGroup group) {
            return Blocks.register(name, Redstone.create_button_stone(parent), group);
        }

        /**
         * 
         * @param name
         * @param parent
         * @param group
         * @return
         */
        public static final Block createButton_wood(String name, Block parent, ItemGroup group) {
            return Blocks.register(name, Redstone.create_button_wood(parent), group);
        }

        /**
         * 
         * @param name
         * @param parent
         * @param group
         * @return
         */
        public static final Block createLever(String name, Block parent, ItemGroup group) {
            return Blocks.register(name, Redstone.create_lever(parent), group);
        }
    }

    public static class Inventory {
        /**
         * 
         * @param name
         * @param parent
         * @return
         */
        public static final Block createBarrel(String name, Block parent) {
            return Blocks.register(name, Utility.create_barrel(parent));
        }

        /**
         * 
         * @param name
         * @param parent
         * @param group
         * @return
         */
        public static final Block createBarrel(String name, Block parent, ItemGroup group) {
            return Blocks.register(name, Utility.create_barrel(parent), group);
        }

        /**
         * 
         * @param name
         * @param color
         * @param parent
         * @return
         */
        public static final Block createShulker(String name, DyeColor color, Block parent) {
            return Blocks.register(name, Utility.create_shulker(color, parent));
        }

        /**
         * 
         * @param name
         * @param color
         * @param parent
         * @param group
         * @return
         */
        public static final Block createShulker(String name, DyeColor color, Block parent, ItemGroup group) {
            return Blocks.register(name, Utility.create_shulker(color, parent), group);
        }
    }

    public static class Node_ {
        /**
         * 
         * @param parent
         * @param tier
         * @param damage
         * @return
         */
        public static final NodeBase create(Block parent, NodeBase.Tier tier, Integer damage) {
            return new NodeBase(Block.Properties.copy(parent), tier, damage, parent.asItem());
        }

        /**
         * 
         * @param name
         * @param parent
         * @param tier
         * @param group
         */
        public static final void register(String name, Block parent, NodeBase.Tier tier, ItemGroup group) {
            // Integer crude = Config.getRangeValue("nodes_crude_tiers");
            // Integer normal = Config.getRangeValue("nodes_normal_tiers");
            // Integer rich = Config.getRangeValue("nodes_rich_tiers");

            // Integer count = 0;

            // switch (tier) {
            // case CRUDE: {
            // count = crude;
            // break;
            // }
            // case NORMAL: {
            // count = normal;
            // break;
            // }
            // case RICH: {
            // count = rich;
            // break;
            // }
            // }

            // Node n = create(parent, tier, count);

            // Block node = ModRegister.registerBlock(name, n, group);
            // ModRegister.nodes.put(node.getRegistryName().toString(), n);

            // Block old_ = node;
            // Block new_ = null;

            // for (Integer i = count - 1; i >= 0; i--) {
            // new_ = (i > 0)
            // ? ModRegister.registerBlock(name + "_" + i, create(parent, tier, i))
            // : parent;

            // old_ = ModRegister.setBlock_replaceable(old_, new_);

            // ModRegister.registerNode(new_.getRegistryName().toString(), n);
            // }
        }
    }
}
