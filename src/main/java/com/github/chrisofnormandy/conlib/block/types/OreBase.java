package com.github.chrisofnormandy.conlib.block.types;

import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.OreBlock;
import net.minecraft.world.level.block.SoundType;
import net.minecraft.world.level.material.Material;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.CreativeModeTab;

import com.github.chrisofnormandy.conlib.registry.ItemRegistry;
import com.github.chrisofnormandy.conlib.registry.OreRegistry;
// import com.github.chrisofnormandy.conlib.registry.Tools;
import com.github.chrisofnormandy.conlib.tool.ToolMaterial;

public class OreBase extends OreBlock {

    public OreBase() {
        super(Properties.of(Material.STONE).requiresCorrectToolForDrops().strength(3.0f).sound(SoundType.STONE));
    }

    /**
     * 
     * @param strength
     */
    public OreBase(Float strength) {
        super(Properties.of(Material.STONE).requiresCorrectToolForDrops().strength(strength).sound(SoundType.STONE));
    }

    public static class Register {
        /**
         * 
         * @param name
         * @param group
         * @return
         */
        public static final Block single(String name, CreativeModeTab group) {
            return OreRegistry.register(name, new OreBase(), group);
        }

        /**
         * 
         * @param name
         * @param strength
         * @param group
         * @return
         */
        public static final Block single(String name, Float strength, CreativeModeTab group) {
            return OreRegistry.register(name, new OreBase(strength), group);
        }

        /**
         * 
         * @param name
         * @param block
         * @param group
         * @return
         */
        public static final Block single(String name, OreBase block, CreativeModeTab group) {
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
                CreativeModeTab itemGroup, CreativeModeTab toolGroup, CreativeModeTab blockGroup) {
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
                CreativeModeTab itemGroup, CreativeModeTab toolGroup, CreativeModeTab blockGroup) {
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