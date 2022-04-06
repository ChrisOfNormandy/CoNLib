package com.github.chrisofnormandy.conlib.block.types;

import net.minecraft.block.Block;
import net.minecraft.block.OreBlock;
import net.minecraft.block.SoundType;
import net.minecraft.block.material.Material;
import net.minecraft.item.Item;
import net.minecraft.item.ItemGroup;

import com.github.chrisofnormandy.conlib.registry.ItemRegistry;
import com.github.chrisofnormandy.conlib.registry.OreRegistry;
// import com.github.chrisofnormandy.conlib.registry.Tools;
import com.github.chrisofnormandy.conlib.tool.ToolMaterial;

public class OreBase extends OreBlock {
    /**
     * 
     * @param harvestLevel
     */
    public OreBase(Integer harvestLevel) {
        super(Properties.of(Material.STONE).requiresCorrectToolForDrops().strength(3.0f).sound(SoundType.STONE)
                .harvestLevel(harvestLevel));
    }

    /**
     * 
     * @param harvestLevel
     * @param strength
     */
    public OreBase(Integer harvestLevel, Float strength) {
        super(Properties.of(Material.STONE).requiresCorrectToolForDrops().strength(strength).sound(SoundType.STONE)
                .harvestLevel(harvestLevel));
    }

    public static class Register {
        /**
         * 
         * @param name
         * @param harvestLevel
         * @param group
         * @return
         */
        public static final Block single(String name, Integer harvestLevel, ItemGroup group) {
            return OreRegistry.register(name, new OreBase(harvestLevel), group);
        }

        /**
         * 
         * @param name
         * @param harvestLevel
         * @param strength
         * @param group
         * @return
         */
        public static final Block single(String name, Integer harvestLevel, Float strength, ItemGroup group) {
            return OreRegistry.register(name, new OreBase(harvestLevel, strength), group);
        }

        /**
         * 
         * @param name
         * @param block
         * @param group
         * @return
         */
        public static final Block single(String name, OreBase block, ItemGroup group) {
            return OreRegistry.register(name, block, group);
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
                ItemGroup itemGroup, ItemGroup toolGroup, ItemGroup blockGroup) {
            ItemRegistry.register(name, new Item.Properties(), itemGroup);
            // Tools.registerAll(name, material, toolGroup);
            return single(oreName, block, blockGroup);
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
                ItemGroup itemGroup, ItemGroup toolGroup, ItemGroup blockGroup) {
            ItemRegistry.register(name + "_ingot", new Item.Properties(), itemGroup);
            ItemRegistry.register(name + "_nugget", new Item.Properties(), itemGroup);
            // Tools.registerAll(name, material, toolGroup);
            return single(oreName, block, blockGroup);
        }
    }

    // @Override
    // protected int getExperience(Random rand) {
    // return MathHelper.nextInt(rand, minXP, maxXP);
    // }
}