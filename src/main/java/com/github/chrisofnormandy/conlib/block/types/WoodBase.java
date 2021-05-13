package com.github.chrisofnormandy.conlib.block.types;

import java.util.LinkedList;
import java.util.List;

import com.github.chrisofnormandy.conlib.block.subsets.Subsets;
import com.github.chrisofnormandy.conlib.itemgroup.GroupList;
import com.github.chrisofnormandy.conlib.itemgroup.Groups;
import com.github.chrisofnormandy.conlib.registry.ModRegister;

import net.minecraft.block.Block;
import net.minecraft.block.SoundType;
import net.minecraft.block.material.Material;
import net.minecraftforge.common.ToolType;

public class WoodBase {
    public static Block create(Integer harvestLevel) {
        return new Block(Block.Properties.of(Material.WOOD)
            .strength(2.0f)
            .sound(SoundType.WOOD)
            .harvestTool(ToolType.AXE)
            .harvestLevel(harvestLevel));
    }

    public static Block create(Integer harvestLevel, Float strength) {
        return new Block(Block.Properties.of(Material.WOOD)
            .strength(strength)
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
        public static Block single(String name, int harvestLevel, Groups group) {
            return ModRegister.registerBlock(name, create(harvestLevel), group);
        }

        public static Block single(String name, int harvestLevel, Float strength, Groups group) {
            return ModRegister.registerBlock(name, create(harvestLevel, strength), group);
        }

        public static List<Block> products(String name, Block parent, GroupList groups) {
            List<Block> products = createProducts(parent);
            List<Block> list = new LinkedList<Block>();

            list.add(ModRegister.registerBlock(name + "_slab", products.get(0), groups.slabs));
            list.add(ModRegister.registerBlock(name + "_stairs", products.get(1), groups.stairs));
            list.add(ModRegister.registerBlock(name + "_fence", products.get(2), groups.fences));
            list.add(ModRegister.registerBlock(name + "_fence_gate", products.get(3), groups.fences));

            return list;
        }

        public static List<Block> suite(String name, int harvestLevel, GroupList groups) {
            Block parent = single(name, harvestLevel, groups.blocks);
            
            List<Block> products = products(name, parent, groups);

            List<Block> list = new LinkedList<Block>();
            list.add(parent);
            list.addAll(products);

            return list;
        }
    }
}
