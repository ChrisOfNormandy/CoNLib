package com.github.chrisofnormandy.conlib.registry;

import net.minecraft.item.Food;
import net.minecraft.item.Item;
import net.minecraft.item.ItemGroup;

public class Foods {
    /**
     * 
     * @param hunger     How many hunger points (20 for full) the food item rewards.
     * @param saturation How many saturation points (20 for full) the food item
     *                   rewards.
     * @return
     */
    public static Food registerFoodNoItem(Integer hunger, Float saturation) {
        return (new Food.Builder()).saturationMod(saturation).nutrition(hunger).build();
    }

    /**
     * 
     * @param name       The food item name.
     * @param hunger     How many hunger points (20 for full) the food item rewards.
     * @param saturation How many saturation points (20 for full) the food item
     *                   rewards.
     * @param group      The creative tab the item should be grouped in.
     * @return
     */
    public static Item registerFood(String name, Integer hunger, Float saturation, ItemGroup group) {
        Food food = (new Food.Builder()).saturationMod(saturation).nutrition(hunger).build();
        Item item = Items.register(name, new Item.Properties().food(food), group);
        ModRegister.foods.put(name, item);
        return item;
    }

    /**
     * 
     * @param name  The food item name.
     * @param food  The food instance. Try using <strong>registerFoodNoItem</strong>
     *              for this.
     * @param group The creative tab the item should be grouped in.
     * @return
     */
    public static Item registerFood(String name, Food food, ItemGroup group) {
        Item item = Items.register(name, new Item.Properties().food(food), group);
        ModRegister.foods.put(name, item);
        return item;
    }
}
