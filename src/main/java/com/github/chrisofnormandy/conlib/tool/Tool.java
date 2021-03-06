package com.github.chrisofnormandy.conlib.tool;

import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
// import net.minecraft.item.Rarity;
import net.minecraft.world.World;
import net.minecraftforge.common.ToolType;

public class Tool extends Item {
    /**
     * 
     * @param properties Should use com.github.chrisofnormandy.conlib.tool.Material.setProperties(...)
     * @param toolType
     * @param level
     */
    public Tool(Item.Properties properties, ToolType toolType, int level) {
        super(properties.addToolType(toolType, level));
    }

    @Override
    public void onCreated(ItemStack stack, World worldIn, PlayerEntity playerIn) {
        
    }
}