package com.github.chrisofnormandy.conlib.crops.types;

import net.minecraft.core.BlockPos;
import net.minecraft.server.level.ServerLevel;
import net.minecraft.util.RandomSource;
import net.minecraft.world.item.Item;
import net.minecraft.world.level.BlockGetter;
import net.minecraft.world.level.ItemLike;
import net.minecraft.world.level.Level;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.Blocks;
import net.minecraft.world.level.block.CropBlock;
import net.minecraft.world.level.block.state.BlockState;
import net.minecraft.world.level.block.state.StateDefinition;
import net.minecraft.world.level.block.state.properties.BlockStateProperties;
import net.minecraft.world.level.block.state.properties.IntegerProperty;
import net.minecraft.world.phys.shapes.CollisionContext;
import net.minecraft.world.phys.shapes.VoxelShape;

public class Crop extends CropBlock {
    public final int MAX_AGE = 3;
    public final IntegerProperty AGE = BlockStateProperties.AGE_3;
    private final VoxelShape[] SHAPE_BY_AGE = new VoxelShape[] {
            Block.box(0.0D, 0.0D, 0.0D, 16.0D, 2.0D, 16.0D),
            Block.box(0.0D, 0.0D, 0.0D, 16.0D, 4.0D, 16.0D),
            Block.box(0.0D, 0.0D, 0.0D, 16.0D, 6.0D, 16.0D),
            Block.box(0.0D, 0.0D, 0.0D, 16.0D, 8.0D, 16.0D)
    };

    private Item plantableItem;

    public Crop(Item plantableItem) {
        super(Block.Properties.copy(Blocks.WHEAT));
        this.plantableItem = plantableItem;
    }

    public Crop(Properties properties, Item plantableItem) {
        super(properties);
        this.plantableItem = plantableItem;
    }

    protected IntegerProperty getAgeProperty() {
        return this.AGE;
    }

    public int getMaxAge() {
        return this.MAX_AGE;
    }

    protected ItemLike getBaseSeedId() {
        return this.plantableItem;
    }

    public void randomTick(BlockState blockState, ServerLevel serverLevel, BlockPos blockPos,
            RandomSource randomSource) {
        if (randomSource.nextInt(3) != 0)
            super.randomTick(blockState, serverLevel, blockPos, randomSource);
    }

    protected int getBonemealAgeIncrease(Level level) {
        return super.getBonemealAgeIncrease(level) / 3;
    }

    protected void createBlockStateDefinition(StateDefinition.Builder<Block, BlockState> builder) {
        builder.add(AGE);
    }

    public VoxelShape getShape(BlockState blockState, BlockGetter blockGetter, BlockPos blockPos,
            CollisionContext context) {
        return SHAPE_BY_AGE[this.getAge(blockState)];
    }
}