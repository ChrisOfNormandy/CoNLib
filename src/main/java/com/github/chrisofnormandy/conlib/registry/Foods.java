package com.github.chrisofnormandy.conlib.registry;

import net.minecraft.item.Food;
import net.minecraft.item.Item;
import net.minecraft.item.ItemGroup;

public class Foods {
    /**
     * 
     * @param hunger
     * @param saturation
     * @return
     */
    public static final Food registerFoodNoItem(Integer hunger, Float saturation) {
        return (new Food.Builder()).saturationMod(saturation).nutrition(hunger).build();
    }

    /**
     * 
     * @param name
     * @param hunger
     * @param saturation
     * @param group
     * @return
     */
    public static final Item registerFood(String name, Integer hunger, Float saturation, ItemGroup group) {
        Food food = (new Food.Builder()).saturationMod(saturation).nutrition(hunger).build();
        Item item = Items.register(name, new Item.Properties().food(food), group);
        ModRegister.foods.put(name, item);
        return item;
    }

    /**
     * 
     * @param name
     * @param food
     * @param group
     * @return
     */
    public static final Item registerFood(String name, Food food, ItemGroup group) {
        Item item = Items.register(name, new Item.Properties().food(food), group);
        ModRegister.foods.put(name, item);
        return item;
    }
}
