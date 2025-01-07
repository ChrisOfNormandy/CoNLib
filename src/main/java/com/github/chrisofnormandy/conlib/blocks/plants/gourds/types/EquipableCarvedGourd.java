package com.github.chrisofnormandy.conlib.blocks.plants.gourds.types;

import net.minecraft.world.entity.EquipmentSlot;
import net.minecraft.world.item.Equipable;

public class EquipableCarvedGourd extends CarvedGourd implements Equipable {
    public EquipableCarvedGourd(Properties properties) {
        super(properties);
    }

    public EquipmentSlot getEquipmentSlot() {
        return EquipmentSlot.HEAD;
    }
}
