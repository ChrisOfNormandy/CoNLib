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
     * @return
     */
    private static Block _block(String name, Block block, Boolean transparent) {
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
     * @param name  The generic block name, like "my_block."
     * @param block The block instance.
     * @param group The creative tab the item should be grouped in.
     * @return Block
     */
    public static Block register(String name, Block block, ItemGroup group) {
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
    public static Block register(String name, Block block, ItemGroup group, Boolean transparent) {
        Block b = _block(name, block, transparent);

        BlockItem itemBlock = new BlockItem(b, new Item.Properties().tab(group));
        Items.register(name, itemBlock);

        return b;
    }

    /**
     * 
     * @param name  The generic block name, like "my_block."
     * @param block The block instance.
     * @return Block
     */
    public static Block register(String name, Block block) {
        return _block(name, block, false);
    }

    /**
     * 
     * @param name
     * @param block
     * @param transparent
     * @return
     */
    public static Block register(String name, Block block, Boolean transparent) {
        return _block(name, block, transparent);
    }

    /**
     * 
     * @param name       The generic block name, like "my_block."
     * @param block      The block instance.
     * @param properties Item properties for the ItemBlock item for the block.
     * @param group      The creative tab the item should be grouped in.
     * @return Block
     */
    public static Block register(String name, Block block, Item.Properties properties, ItemGroup group) {
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
    public static Block register(String name, Block block, Item.Properties properties, ItemGroup group,
            Boolean transparent) {
        Block b = _block(name, block, transparent);

        BlockItem itemBlock = new BlockItem(b, properties.tab(group));
        Items.register(name, itemBlock);

        return b;
    }

    /**
     * 
     * @param name       The generic block name, like "my_block."
     * @param block      The block instance.
     * @param properties Item properties for the ItemBlock item for the block.
     * @return Block
     */
    public static Block register(String name, Block block, Item.Properties properties) {
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
    public static Block register(String name, Block block, Item.Properties properties, Boolean transparent) {
        Block b = _block(name, block, transparent);

        BlockItem itemBlock = new BlockItem(b, properties);
        Items.register(name, itemBlock);

        return b;
    }

    /**
     * 
     * @param name           The generic material name, like "my_material."
     * @param color          The material color. See
     *                       <strong>net.minecraft.block.material</strong>.
     * @param isLiquid       Is the material a liquid? It cannot be liquid and
     *                       solid.
     * @param isSolid        Is the material a solid? It cannot be liquid and solid.
     * @param blocksMovement Does this material allow players to stand on it?
     * @param isOpaque       Does this material block light from passing through it?
     * @param flammable      Does this material burn?
     * @param replaceable    Can this material be replaced when a block is placed in
     *                       its space, like water does?
     * @param pushReaction   What happens when the block is pushed by a piston? See
     *                       <strong>net.minecraft.block.material</strong>.
     * @return Material
     */
    public static Material registerMaterial(String name, MaterialColor color, Boolean isLiquid, Boolean isSolid,
            Boolean blocksMovement, Boolean isOpaque, Boolean flammable, Boolean replaceable,
            PushReaction pushReaction) {
        Material material = new Material(color, isLiquid, isSolid, blocksMovement, isOpaque, flammable, replaceable,
                pushReaction);
        ModRegister.materials.put(name, material);
        return material;
    }
}
