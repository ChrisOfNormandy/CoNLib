package com.github.chrisofnormandy.conlib.itemgroup;

import com.google.common.base.Supplier;

import net.minecraft.block.Block;
import net.minecraft.item.Item;
import net.minecraft.item.ItemGroup;
import net.minecraft.item.ItemStack;

import com.github.chrisofnormandy.conlib.registry.ModRegister;

public class Groups extends ItemGroup {
    private Supplier<ItemStack> displayStack;

    private Groups(String label, Supplier<ItemStack> icon) {
        super(label);
        this.displayStack = icon;
    }

    public static final Groups createGroup(String name, String icon_itemName) {
        Item item = ModRegister.items.containsKey(icon_itemName)
            ? ModRegister.items.get(icon_itemName)
            : ModRegister.blocks.get(icon_itemName).asItem();
        return new Groups(name, () -> new ItemStack(item));
    }

    public static final Groups createGroup(String name, Block block) {
        Item item = block.asItem();
        return new Groups(name, () -> new ItemStack(item));
    }

    public static final Groups createGroup(String name, Item item) {
        return new Groups(name, () -> new ItemStack(item));
    }

    @Override
    public ItemStack createIcon() {
        return displayStack.get();
    }
}