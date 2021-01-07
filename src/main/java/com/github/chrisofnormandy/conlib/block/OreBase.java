package com.github.chrisofnormandy.conlib.block;

import net.minecraft.block.OreBlock;
import net.minecraft.block.SoundType;
import net.minecraft.block.material.Material;
import net.minecraft.util.math.MathHelper;

import java.util.Random;

public class OreBase extends OreBlock {
  private int minXP;
  private int maxXP;

  public OreBase(int minXP, int maxXP, int harvestLevel) {
    super(Properties.create(Material.ROCK).hardnessAndResistance(3.0f).sound(SoundType.STONE).harvestLevel(harvestLevel));
    this.minXP = minXP;
    this.maxXP = maxXP;
  }

  @Override
  protected int getExperience(Random rand) {
    return MathHelper.nextInt(rand, minXP, maxXP);
  }
}