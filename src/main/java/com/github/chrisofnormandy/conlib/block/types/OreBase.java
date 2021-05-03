package com.github.chrisofnormandy.conlib.block.types;

import net.minecraft.block.Block;
import net.minecraft.block.OreBlock;
import net.minecraft.block.SoundType;
import net.minecraft.block.material.Material;
import net.minecraft.item.Item;
import net.minecraft.util.math.MathHelper;

import java.util.Random;

import com.github.chrisofnormandy.conlib.itemgroup.Groups;
import com.github.chrisofnormandy.conlib.registry.ModRegister;
import com.github.chrisofnormandy.conlib.tool.ToolMaterial;

public class OreBase extends OreBlock {
  private Integer minXP;
  private Integer maxXP;

  public OreBase(Integer minXP, Integer maxXP, Integer harvestLevel) {
    super(Properties.of(Material.STONE).sound(SoundType.STONE).harvestLevel(harvestLevel));
    this.minXP = minXP;
    this.maxXP = maxXP;
  }

  public static class Register {
    public static Block single(String name, Integer minXP, Integer maxXP, Integer harvestLevel, Groups group) {
      return ModRegister.registerOre(name, new OreBase(minXP, maxXP, harvestLevel), group);
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