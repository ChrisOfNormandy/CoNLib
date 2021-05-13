package com.github.chrisofnormandy.conlib.block.types;

import net.minecraft.block.Block;
import net.minecraft.block.OreBlock;
import net.minecraft.block.SoundType;
import net.minecraft.block.material.Material;
import net.minecraft.item.Item;

import com.github.chrisofnormandy.conlib.itemgroup.Groups;
import com.github.chrisofnormandy.conlib.registry.ModRegister;
import com.github.chrisofnormandy.conlib.tool.ToolMaterial;

public class OreBase extends OreBlock {
  public OreBase(Integer harvestLevel) {
    super(Properties.of(Material.STONE).requiresCorrectToolForDrops().strength(3.0f).sound(SoundType.STONE).harvestLevel(harvestLevel));
  }

  public OreBase(Integer harvestLevel, Float strength) {
    super(Properties.of(Material.STONE).requiresCorrectToolForDrops().strength(strength).sound(SoundType.STONE).harvestLevel(harvestLevel));
  }

  public static class Register {
    public static Block single(String name, Integer harvestLevel, Groups group) {
      return ModRegister.registerOre(name, new OreBase(harvestLevel), group);
    }

    public static Block single(String name, Integer harvestLevel, Float strength, Groups group) {
      return ModRegister.registerOre(name, new OreBase(harvestLevel, strength), group);
    }

    public static Block single(String name, OreBase block, Groups group) {
      return ModRegister.registerOre(name, block, group);
    }

    public static Block asGem(String name, String oreName, OreBase block, ToolMaterial material, Groups itemGroup, Groups toolGroup, Groups blockGroup) {
      ModRegister.registerItem(name, new Item.Properties(), itemGroup);
      ModRegister.registerTools(name, material, toolGroup);
      return single(oreName, block, blockGroup);
    }

    public static Block asMetal(String name, String oreName, OreBase block, ToolMaterial material, Groups itemGroup, Groups toolGroup, Groups blockGroup) {
      ModRegister.registerItem(name + "_ingot", new Item.Properties(), itemGroup);
      ModRegister.registerItem(name + "_nugget", new Item.Properties(), itemGroup);
      ModRegister.registerTools(name, material, toolGroup);
      return single(oreName, block, blockGroup);
    }
  }

  // @Override
  // protected int getExperience(Random rand) {
  //   return MathHelper.nextInt(rand, minXP, maxXP);
  // }
}