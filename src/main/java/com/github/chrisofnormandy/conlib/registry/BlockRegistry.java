package com.github.chrisofnormandy.conlib.registry;

import com.github.chrisofnormandy.conlib.Main;

import net.minecraft.world.level.block.Block;
import net.minecraft.resources.ResourceKey;
import net.minecraft.world.item.BlockItem;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.CreativeModeTab;
import net.minecraftforge.registries.ForgeRegistries;

public class BlockRegistry {
    /**
     *
     * @param name
     * @param block
     * @param transparent
     * @return
     */
    private static final Block _block(String name, Block block, Boolean transparent) {
        ForgeRegistries.BLOCKS.register(name, block);
        ModRegister.blocks.put(name, block);

        if (transparent)
            ModRegister.transparentBlocks.put(name, block);

        Main.LOG.info("Registered new block: " + block.getName());
        return block;
    }

    /**
     *
     * @param name
     * @param block
     * @param group
     * @return
     */
    public static final Block register(String name, Block block, ResourceKey<CreativeModeTab> creativeTab) {
        Block b = _block(name, block, false);

        BlockItem itemBlock = new BlockItem(b, new Item.Properties());
        ItemRegistry.register(name, itemBlock);

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
    public static final Block register(String name, Block block, CreativeModeTab group, Boolean transparent) {
        Block b = _block(name, block, transparent);

        BlockItem itemBlock = new BlockItem(b, new Item.Properties());
        ItemRegistry.register(name, itemBlock);

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
    public static final Block register(String name, Block block, Item.Properties properties,
            ResourceKey<CreativeModeTab> creativeTab) {
        Block b = _block(name, block, false);

        BlockItem itemBlock = new BlockItem(b, properties);
        ItemRegistry.register(name, itemBlock, creativeTab);

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
    public static final Block register(String name, Block block, Item.Properties properties,
            ResourceKey<CreativeModeTab> creativeTab,
            Boolean transparent) {
        Block b = _block(name, block, transparent);

        BlockItem itemBlock = new BlockItem(b, properties);
        ItemRegistry.register(name, itemBlock, creativeTab);

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
        ItemRegistry.register(name, itemBlock);

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
        ItemRegistry.register(name, itemBlock);

        return b;
    }
}
