package com.github.chrisofnormandy.conlib.blocks.fluids;

import javax.annotation.Nullable;

import net.minecraft.core.BlockPos;
import net.minecraft.server.level.ServerLevel;
import net.minecraft.util.RandomSource;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.enchantment.EnchantmentHelper;
import net.minecraft.world.item.enchantment.Enchantments;
import net.minecraft.world.level.Level;
import net.minecraft.world.level.LightLayer;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.Blocks;
import net.minecraft.world.level.block.HalfTransparentBlock;
import net.minecraft.world.level.block.entity.BlockEntity;
import net.minecraft.world.level.block.state.BlockState;

public class CustomIce extends HalfTransparentBlock {

    private Block liquid = Blocks.WATER;

    public CustomIce(Properties properties) {
        super(properties);
    }

    public CustomIce(Properties properties, Block liquid) {
        super(properties);
        this.liquid = liquid;
    }

    // This is static in IceBlock, but cannot be used like that here.
    public BlockState meltsInto() {
        return this.liquid.defaultBlockState();
    }

    public void playerDestroy(Level level, Player player, BlockPos blockPos, BlockState blockState,
            @Nullable BlockEntity blockEntity, ItemStack itemStack) {
        super.playerDestroy(level, player, blockPos, blockState, blockEntity, itemStack);
        if (EnchantmentHelper.getTagEnchantmentLevel(Enchantments.SILK_TOUCH, itemStack) == 0) {
            if (level.dimensionType().ultraWarm()) {
                level.removeBlock(blockPos, false);
                return;
            }

            level.setBlockAndUpdate(blockPos, meltsInto());
        }

    }

    public void randomTick(BlockState blockState, ServerLevel level, BlockPos blockPos, RandomSource randomSource) {
        if (level.getBrightness(LightLayer.BLOCK, blockPos) > 11 - blockState.getLightBlock(level, blockPos)) {
            this.melt(blockState, level, blockPos);
        }

    }

    protected void melt(BlockState blockState, Level level, BlockPos blockPos) {
        if (level.dimensionType().ultraWarm()) {
            level.removeBlock(blockPos, false);
        } else {
            level.setBlockAndUpdate(blockPos, meltsInto());
            level.neighborChanged(blockPos, meltsInto().getBlock(), blockPos);
        }
    }
}
