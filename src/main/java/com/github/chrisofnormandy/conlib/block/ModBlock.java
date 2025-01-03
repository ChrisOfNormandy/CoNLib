package com.github.chrisofnormandy.conlib.block;

import com.github.chrisofnormandy.conlib.block.types.OreBase;
import com.github.chrisofnormandy.conlib.block.types.custom.NodeBase;
import com.github.chrisofnormandy.conlib.tool.ToolMaterial;

import net.minecraft.resources.ResourceKey;
import net.minecraft.world.item.CreativeModeTab;
import net.minecraft.world.level.block.Block;

public class ModBlock {
    public static final String[] dyes = com.github.chrisofnormandy.conlib.item.ModItem.dyes;

    public static class Ore {
        /**
         *
         * @return
         */
        public static final Block create() {
            return new OreBase();
        }

        /**
         *
         * @param strength
         * @return
         */
        public static final Block create(Float strength) {
            return new OreBase(strength);
        }

        /**
         *
         * @param name
         * @param group
         * @return
         */
        public static final Block register(String name, ResourceKey<CreativeModeTab> creativeTab) {
            return OreBase.Register.single(name, creativeTab);
        }

        /**
         *
         * @param name
         * @param strength
         * @param group
         * @return
         */
        public static final Block register(String name, Float strength, ResourceKey<CreativeModeTab> creativeTab) {
            return OreBase.Register.single(name, strength, creativeTab);
        }

        /**
         *
         * @param name
         * @param block
         * @param group
         * @return
         */
        public static final Block register(String name, OreBase block, ResourceKey<CreativeModeTab> creativeTab) {
            return OreBase.Register.single(name, block, creativeTab);
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
                ResourceKey<CreativeModeTab> creativeTab_Item,
                ResourceKey<CreativeModeTab> creativeTab_Tool, ResourceKey<CreativeModeTab> creativeTab_Block) {
            return OreBase.Register.asGem(name, oreName, block, material, creativeTab_Item, creativeTab_Tool,
                    creativeTab_Block);
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
                ResourceKey<CreativeModeTab> creativeTab_Item,
                ResourceKey<CreativeModeTab> creativeTab_Tool, ResourceKey<CreativeModeTab> creativeTab_Block) {
            return OreBase.Register.asMetal(name, oreName, block, material, creativeTab_Item, creativeTab_Tool,
                    creativeTab_Block);
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
        public static final void register(String name, Block parent, NodeBase.Tier tier,
                ResourceKey<CreativeModeTab> creativeTab) {
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
