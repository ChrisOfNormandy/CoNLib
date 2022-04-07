// package com.github.chrisofnormandy.conlib.feature;

// import java.util.Random;

// import net.minecraft.world.level.block.Block;
// import net.minecraft.world.level.block.BlockState;
// import net.minecraft.util.math.BlockPos;
// import net.minecraft.util.math.MathHelper;
// import net.minecraft.world.IWorld;
// import net.minecraft.world.biome.Biome;
// import net.minecraft.world.gen.feature.NoFeatureConfig;

// public class PlantFeature extends PlantFeatureNoConfig {
// private static Block[] BLOCKS;

// public PlantFeature(Block[] blocks) {
// BLOCKS = blocks;
// }

// @Override
// public BlockState getFlowerToPlace(Random random, BlockPos pos,
// NoFeatureConfig config) {
// double d0 = MathHelper.clamp((1.0D + Biome.INFO_NOISE.noiseAt((double)
// pos.getX() / 48.0D,
// (double) pos.getZ() / 48.0D, false)) / 2.0D, 0.0D, 0.9999D);
// Block block = BLOCKS[(int)(d0 * (double)BLOCKS.length)];
// return block.getDefaultState();
// }
// }