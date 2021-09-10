package com.github.chrisofnormandy.conlib.registry;

import com.github.chrisofnormandy.conlib.Main;

import net.minecraft.block.Block;
import net.minecraft.block.material.Material;
import net.minecraft.block.material.MaterialColor;
import net.minecraft.block.material.PushReaction;
import net.minecraft.item.BlockItem;
import net.minecraft.item.Item;
import net.minecraft.item.ItemGroup;
import net.minecraftforge.registries.ForgeRegistries;

public class Blocks {
    /**
     * 
     * @param name
     * @param block
     * @param transparent
     * @return
     */
    private static final Block _block(String name, Block block, Boolean transparent) {
        block.setRegistryName(name);
        ForgeRegistries.BLOCKS.register(block);
        ModRegister.blocks.put(name, block);

        if (transparent)
            ModRegister.transparentBlocks.put(name, block);

        Main.LOG.info("Registered new block: " + block.getRegistryName());
        return block;
    }

    /**
     * 
     * @param name
     * @param block
     * @param group
     * @return
     */
    public static final Block register(String name, Block block, ItemGroup group) {
        Block b = _block(name, block, false);

        BlockItem itemBlock = new BlockItem(b, new Item.Properties().tab(group));
        Items.register(name, itemBlock);

        return b;
    }

    /**
     * 
     * @param name
     * @param block
     * @param group
     * @param transparent
     * @return
     */
    public static final Block register(String name, Block block, ItemGroup group, Boolean transparent) {
        Block b = _block(name, block, transparent);

        BlockItem itemBlock = new BlockItem(b, new Item.Properties().tab(group));
        Items.register(name, itemBlock);

        return b;
    }

    /**
     * 
     * @param name
     * @param block
     * @return
     */
    public static final Block register(String name, Block block) {
        return _block(name, block, false);
    }

    /**
     * 
     * @param name
     * @param block
     * @param transparent
     * @return
     */
    public static final Block register(String name, Block block, Boolean transparent) {
        return _block(name, block, transparent);
    }

    /**
     * 
     * @param name
     * @param block
     * @param properties
     * @param group
     * @return
     */
    public static final Block register(String name, Block block, Item.Properties properties, ItemGroup group) {
        Block b = _block(name, block, false);

        BlockItem itemBlock = new BlockItem(b, properties.tab(group));
        Items.register(name, itemBlock);

        return b;
    }

    /**
     * 
     * @param name
     * @param block
     * @param properties
     * @param group
     * @param transparent
     * @return
     */
    public static final Block register(String name, Block block, Item.Properties properties, ItemGroup group,
            Boolean transparent) {
        Block b = _block(name, block, transparent);

        BlockItem itemBlock = new BlockItem(b, properties.tab(group));
        Items.register(name, itemBlock);

        return b;
    }

    /**
     * 
     * @param name
     * @param block
     * @param properties
     * @return
     */
    public static final Block register(String name, Block block, Item.Properties properties) {
        Block b = _block(name, block, false);

        BlockItem itemBlock = new BlockItem(b, properties);
        Items.register(name, itemBlock);

        return b;
    }

    /**
     * 
     * @param name
     * @param block
     * @param properties
     * @param transparent
     * @return
     */
    public static final Block register(String name, Block block, Item.Properties properties, Boolean transparent) {
        Block b = _block(name, block, transparent);

        BlockItem itemBlock = new BlockItem(b, properties);
        Items.register(name, itemBlock);

        return b;
    }

    /**
     * 
     * @param name
     * @param color
     * @param isLiquid
     * @param isSolid
     * @param blocksMovement
     * @param isOpaque
     * @param flammable
     * @param replaceable
     * @param pushReaction
     * @return
     */
    public static final Material registerMaterial(String name, MaterialColor color, Boolean isLiquid, Boolean isSolid,
            Boolean blocksMovement, Boolean isOpaque, Boolean flammable, Boolean replaceable,
            PushReaction pushReaction) {
        Material material = new Material(color, isLiquid, isSolid, blocksMovement, isOpaque, flammable, replaceable,
                pushReaction);
        ModRegister.materials.put(name, material);
        return material;
    }
}
