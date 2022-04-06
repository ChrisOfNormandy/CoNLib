package com.github.chrisofnormandy.conlib.tool;

import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;

public class CraftingTool extends Item {
    /**
     * 
     * @param properties
     */
    public CraftingTool(Item.Properties properties) {
        super(properties);
    }

    @Override
    public ItemStack getContainerItem(ItemStack stack) {
        return stack.copy();
    }

    @Override
    public boolean hasContainerItem(ItemStack stack) {
        return true;
    }
}