package com.github.chrisofnormandy.conlib.block.types;

import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.Blocks;
import net.minecraft.world.level.block.DropExperienceBlock;
import net.minecraft.world.level.block.SoundType;
import net.minecraft.world.item.Item;
import net.minecraft.resources.ResourceKey;
import net.minecraft.world.item.CreativeModeTab;

import com.github.chrisofnormandy.conlib.registry.ItemRegistry;
import com.github.chrisofnormandy.conlib.registry.OreRegistry;
import com.github.chrisofnormandy.conlib.tool.ToolMaterial;

public class OreBase extends DropExperienceBlock {

    public OreBase() {
        super(Properties.copy(Blocks.IRON_ORE).requiresCorrectToolForDrops().strength(3.0f).sound(SoundType.STONE));
    }

    /**
     *
     * @param strength
     */
    public OreBase(Float strength) {
        super(Properties.copy(Blocks.IRON_ORE).requiresCorrectToolForDrops().strength(strength).sound(SoundType.STONE));
    }

    public static class Register {
        /**
         *
         * @param name
         * @param group
         * @return
         */
        public static final Block single(String name, ResourceKey<CreativeModeTab> creativeTab) {
            return OreRegistry.register(name, new OreBase(), creativeTab);
        }

        /**
         *
         * @param name
         * @param strength
         * @param group
         * @return
         */
        public static final Block single(String name, Float strength, ResourceKey<CreativeModeTab> creativeTab) {
            return OreRegistry.register(name, new OreBase(strength), creativeTab);
        }

        /**
         *
         * @param name
         * @param block
         * @param group
         * @return
         */
        public static final Block single(String name, OreBase block, ResourceKey<CreativeModeTab> creativeTab) {
            return OreRegistry.register(name, block, creativeTab);
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
        public static final Block asGem(String name, String oreName, OreBase block, ToolMaterial material,
                ResourceKey<CreativeModeTab> creativeTab_Item,
                ResourceKey<CreativeModeTab> creativeTab_Tool,
                ResourceKey<CreativeModeTab> creativeTab_Block) {
            ItemRegistry.register(name, new Item.Properties(), creativeTab_Item);
            // Tools.registerAll(name, material, toolGroup);
            return single(oreName, block, creativeTab_Block);
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
        public static final Block asMetal(String name, String oreName, OreBase block, ToolMaterial material,
                ResourceKey<CreativeModeTab> creativeTab_Item,
                ResourceKey<CreativeModeTab> creativeTab_Tool, ResourceKey<CreativeModeTab> creativeTab_Block) {
            ItemRegistry.register(name + "_ingot", new Item.Properties(), creativeTab_Item);
            ItemRegistry.register(name + "_nugget", new Item.Properties(), creativeTab_Tool);
            // Tools.registerAll(name, material, toolGroup);
            return single(oreName, block, creativeTab_Block);
        }
    }

    // @Override
    // protected int getExperience(Random rand) {
    // return MathHelper.nextInt(rand, minXP, maxXP);
    // }
}