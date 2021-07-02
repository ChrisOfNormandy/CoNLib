package com.github.chrisofnormandy.conlib.tool;

import net.minecraft.item.Item;
import net.minecraftforge.common.ToolType;

public class ToolBase extends Item {
    /**
     * 
     * @param properties Should use com.github.chrisofnormandy.conlib.tool.Material.setProperties(...)
     * @param toolType
     * @param level
     */
    public ToolBase(Item.Properties properties, ToolType toolType, int level) {
        super(properties.addToolType(toolType, level));
    }
}