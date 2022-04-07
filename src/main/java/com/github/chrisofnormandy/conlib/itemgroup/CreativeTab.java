package com.github.chrisofnormandy.conlib.itemgroup;

import com.google.common.base.Supplier;

import net.minecraft.world.level.block.Block;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.CreativeModeTab;
import net.minecraft.world.item.ItemStack;

import com.github.chrisofnormandy.conlib.registry.ModRegister;

public class CreativeTab extends CreativeModeTab {
    private Supplier<ItemStack> displayStack;

    /**
     * 
     * @param label
     * @param icon
     */
    private CreativeTab(String label, Supplier<ItemStack> icon) {
        super(label);
        this.displayStack = icon;
    }

    /**
     * 
     * @param name
     * @param icon_itemName
     * @return
     */
    public static final CreativeTab createGroup(String name, String icon_itemName) {
        Item item = ModRegister.items.containsKey(icon_itemName) ? ModRegister.items.get(icon_itemName)
                : ModRegister.blocks.get(icon_itemName).asItem();
        return new CreativeTab(name, () -> new ItemStack(item));
    }

    /**
     * 
     * @param name
     * @param block
     * @return
     */
    public static final CreativeTab createGroup(String name, Block block) {
        Item item = block.asItem();
        return new CreativeTab(name, () -> new ItemStack(item));
    }

    /**
     * 
     * @param name
     * @param item
     * @return
     */
    public static final CreativeTab createGroup(String name, Item item) {
        return new CreativeTab(name, () -> new ItemStack(item));
    }

    @Override
    public ItemStack makeIcon() {
        return displayStack.get();
    }
}