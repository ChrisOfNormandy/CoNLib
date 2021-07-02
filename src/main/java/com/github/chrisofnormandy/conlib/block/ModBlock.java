package com.github.chrisofnormandy.conlib.block;

import com.github.chrisofnormandy.conlib.block.decoration.Utility;
import com.github.chrisofnormandy.conlib.block.subsets.Subsets;
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
    public static String[] dyes = com.github.chrisofnormandy.conlib.item.ModItem.dyes;

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

        public static Block create(Integer harvestLevel, Float strength) {
            return new OreBase(harvestLevel, strength);
        }

        public static Block register(String name, Integer harvestLevel, ItemGroup group) {
            return OreBase.Register.single(name, harvestLevel, group);
        }

        public static Block register(String name, Integer harvestLevel, Float strength, ItemGroup group) {
            return OreBase.Register.single(name, harvestLevel, strength, group);
        }

        public static Block register(String name, OreBase block, ItemGroup group) {
            return OreBase.Register.single(name, block, group);
        }

        public static Block registerGem(String name, String oreName, OreBase block, ToolMaterial material,
                ItemGroup itemGroup, ItemGroup toolGroup, ItemGroup blockGroup) {
            return OreBase.Register.asGem(name, oreName, block, material, itemGroup, toolGroup, blockGroup);
        }

        public static Block registerMetal(String name, String oreName, OreBase block, ToolMaterial material,
                ItemGroup itemGroup, ItemGroup toolGroup, ItemGroup blockGroup) {
            return OreBase.Register.asMetal(name, oreName, block, material, itemGroup, toolGroup, blockGroup);
        }
    }

    public static class Generic {
        public static Block create(String name, Properties properties) {
            return Blocks.register(name, new Block(properties));
        }

        public static Block create(String name, Properties properties, ItemGroup group) {
            return Blocks.register(name, new Block(properties), group);
        }

        public static Block createColumn(String name, Properties properties) {
            return Blocks.register(name, new RotatedPillarBlock(properties));
        }

        public static Block createColumn(String name, Properties properties, ItemGroup group) {
            return Blocks.register(name, new RotatedPillarBlock(properties), group);
        }

        public static Block createSlab(String name, Block parent) {
            return Blocks.register(name, Subsets.create_slab(parent));
        }

        public static Block createSlab(String name, Block parent, ItemGroup group) {
            return Blocks.register(name, Subsets.create_slab(parent), group);
        }

        public static Block createStairs(String name, Block parent) {
            return Blocks.register(name, Subsets.create_stairs(parent));
        }

        public static Block createStairs(String name, Block parent, ItemGroup group) {
            return Blocks.register(name, Subsets.create_stairs(parent), group);
        }

        public static Block createWall(String name, Block parent) {
            return Blocks.register(name, Subsets.create_wall(parent));
        }

        public static Block createWall(String name, Block parent, ItemGroup group) {
            return Blocks.register(name, Subsets.create_wall(parent), group);
        }

        public static Block createFence(String name, Block parent) {
            return Blocks.register(name, Subsets.create_fence(parent));
        }

        public static Block createFence(String name, Block parent, ItemGroup group) {
            return Blocks.register(name, Subsets.create_fence(parent), group);
        }

        public static Block createFenceGate(String name, Block parent) {
            return Blocks.register(name, Subsets.create_fenceGate(parent));
        }

        public static Block createFenceGate(String name, Block parent, ItemGroup group) {
            return Blocks.register(name, Subsets.create_fenceGate(parent), group);
        }

        public static Block createDoor(String name, Block parent) {
            return Blocks.register(name, Subsets.create_door(parent));
        }

        public static Block createDoor(String name, Block parent, ItemGroup group) {
            return Blocks.register(name, Subsets.create_door(parent), group);
        }

        public static Block createTrapdoor(String name, Block parent) {
            return Blocks.register(name, Subsets.create_trapdoor(parent));
        }

        public static Block createTrapdoor(String name, Block parent, ItemGroup group) {
            return Blocks.register(name, Subsets.create_trapdoor(parent), group);
        }
    }

    public static class Interactive {
        public static Block createBarrel(String name, Block parent) {
            return Blocks.register(name, Utility.create_barrel(parent));
        }

        public static Block createBarrel(String name, Block parent, ItemGroup group) {
            return Blocks.register(name, Utility.create_barrel(parent), group);
        }

        public static Block createShulker(String name, DyeColor color, Block parent) {
            return Blocks.register(name, Utility.create_shulker(color, parent));
        }

        public static Block createShulker(String name, DyeColor color, Block parent, ItemGroup group) {
            return Blocks.register(name, Utility.create_shulker(color, parent), group);
        }
    }

    public static class Node_ {
        public static NodeBase create(Block parent, NodeBase.Tier tier, Integer damage) {
            return new NodeBase(Block.Properties.copy(parent), tier, damage, parent.asItem());
        }

        public static void register(String name, Block parent, NodeBase.Tier tier, ItemGroup group) {
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
