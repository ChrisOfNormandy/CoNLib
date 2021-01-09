package com.github.chrisofnormandy.conlib.block.types;

import java.util.LinkedList;
import java.util.List;

import com.github.chrisofnormandy.conlib.block.subsets.Subsets;
import com.github.chrisofnormandy.conlib.registry.ModRegister;

import net.minecraft.block.Block;
import net.minecraft.block.SoundType;
import net.minecraft.block.material.Material;
import net.minecraft.item.ItemGroup;
import net.minecraftforge.common.ToolType;

public class Wood {
    public static Block create(int harvestLevel) {
        return new Block(Block.Properties.create(Material.WOOD)
            .hardnessAndResistance(2.0f)
            .sound(SoundType.WOOD)
            .harvestTool(ToolType.AXE)
            .harvestLevel(harvestLevel));
    }

    public static List<Block> createProducts(Block parent) {
        List<Block> list = new LinkedList<Block>();

        list.add(Subsets.create_slab(parent));
        list.add(Subsets.create_stairs(parent));
        list.add(Subsets.create_fence(parent));
        list.add(Subsets.create_fenceGate(parent));

        return list;
    }

    public static class Register {
        public static Block single(String name, int harvestLevel, ItemGroup group) {
            return ModRegister.registerBlock(name, create(harvestLevel), group);
        }

        public static List<Block> products(String name, Block parent, List<ItemGroup> groups) {
            List<Block> products = createProducts(parent);
            List<Block> list = new LinkedList<Block>();

            list.add(ModRegister.registerBlock(name + "_slab", products.get(0), groups.get(0)));
            list.add(ModRegister.registerBlock(name + "_stairs", products.get(1), groups.get(1)));
            list.add(ModRegister.registerBlock(name + "_fence", products.get(2), groups.get(2)));
            list.add(ModRegister.registerBlock(name + "_fence_gate", products.get(2), groups.get(2)));

            return list;
        }

        public static List<Block> suite(String name, int harvestLevel, List<ItemGroup> groups) {
            Block parent = single(name, harvestLevel, groups.remove(0));
            
            List<Block> products = products(name, parent, groups);

            List<Block> list = new LinkedList<Block>();
            list.add(parent);
            list.addAll(products);

            return list;
        }
    }
}
