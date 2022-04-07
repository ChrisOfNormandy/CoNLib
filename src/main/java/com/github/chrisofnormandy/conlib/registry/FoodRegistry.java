package com.github.chrisofnormandy.conlib.registry;

import net.minecraft.world.item.Item;
import net.minecraft.world.food.FoodProperties;
import net.minecraft.world.item.CreativeModeTab;

public class FoodRegistry {
    /**
     * 
     * @param hunger
     * @param saturation
     * @return
     */
    public static final FoodProperties registerFoodNoItem(Integer hunger, Float saturation) {
        return new FoodProperties.Builder().saturationMod(saturation).nutrition(hunger).build();
    }

    /**
     * 
     * @param name
     * @param hunger
     * @param saturation
     * @param group
     * @return
     */
    public static final Item registerFood(String name, Integer hunger, Float saturation, CreativeModeTab group) {
        FoodProperties food = new FoodProperties.Builder().saturationMod(saturation).nutrition(hunger).build();
        Item item = ItemRegistry.register(name, new Item.Properties().food(food), group);
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
    public static final Item registerFood(String name, FoodProperties food, CreativeModeTab group) {
        Item item = ItemRegistry.register(name, new Item.Properties().food(food), group);
        ModRegister.foods.put(name, item);
        return item;
    }
}
