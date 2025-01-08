package com.github.chrisofnormandy.conlib.crops.types;

import javax.annotation.Nullable;

import net.minecraft.core.BlockPos;
import net.minecraft.core.Direction;
import net.minecraft.server.level.ServerLevel;
import net.minecraft.util.RandomSource;
import net.minecraft.world.entity.Entity;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.entity.monster.Ravager;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.context.BlockPlaceContext;
import net.minecraft.world.level.BlockGetter;
import net.minecraft.world.level.GameRules;
import net.minecraft.world.level.Level;
import net.minecraft.world.level.LevelAccessor;
import net.minecraft.world.level.LevelReader;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.Blocks;
import net.minecraft.world.level.block.BonemealableBlock;
import net.minecraft.world.level.block.DoublePlantBlock;
import net.minecraft.world.level.block.state.BlockState;
import net.minecraft.world.level.block.state.StateDefinition;
import net.minecraft.world.level.block.state.properties.BlockStateProperties;
import net.minecraft.world.level.block.state.properties.DoubleBlockHalf;
import net.minecraft.world.level.block.state.properties.IntegerProperty;
import net.minecraft.world.phys.shapes.CollisionContext;
import net.minecraft.world.phys.shapes.VoxelShape;
import net.minecraftforge.common.IPlantable;

public class TallCrop extends DoublePlantBlock implements BonemealableBlock {
    public static final IntegerProperty AGE = BlockStateProperties.AGE_4;
    public static final int MAX_AGE = 4;

    private static final int DOUBLE_PLANT_AGE_INTERSECTION = 3;
    private static final int BONEMEAL_INCREASE = 1;

    private static final VoxelShape FULL_UPPER_SHAPE = Block.box(3.0D, 0.0D, 3.0D, 13.0D, 15.0D, 13.0D);
    private static final VoxelShape FULL_LOWER_SHAPE = Block.box(3.0D, -1.0D, 3.0D, 13.0D, 16.0D, 13.0D);
    private static final VoxelShape COLLISION_SHAPE_BULB = Block.box(5.0D, -1.0D, 5.0D, 11.0D, 3.0D, 11.0D);
    private static final VoxelShape COLLISION_SHAPE_CROP = Block.box(3.0D, -1.0D, 3.0D, 13.0D, 5.0D, 13.0D);
    private static final VoxelShape[] UPPER_SHAPE_BY_AGE = new VoxelShape[] {
            Block.box(3.0D, 0.0D, 3.0D, 13.0D, 11.0D, 13.0D),
            FULL_UPPER_SHAPE
    };
    private static final VoxelShape[] LOWER_SHAPE_BY_AGE = new VoxelShape[] {
            COLLISION_SHAPE_BULB,
            Block.box(3.0D, -1.0D, 3.0D, 13.0D, 14.0D, 13.0D),
            FULL_LOWER_SHAPE,
            FULL_LOWER_SHAPE,
            FULL_LOWER_SHAPE
    };

    public TallCrop(Properties properties) {
        super(properties);
    }

    private boolean isMaxAge(BlockState blockState) {
        return blockState.getValue(AGE) >= MAX_AGE;
    }

    public boolean isRandomlyTicking(BlockState blockState) {
        return blockState.getValue(HALF) == DoubleBlockHalf.LOWER && !this.isMaxAge(blockState);
    }

    @Nullable
    public BlockState getStateForPlacement(BlockPlaceContext context) {
        return this.defaultBlockState();
    }

    public BlockState updateShape(BlockState blockState, Direction direction, BlockState sourceBlockState,
            LevelAccessor levelAccessor, BlockPos blockPos, BlockPos sourceBlockPos) {
        return !blockState.canSurvive(levelAccessor, blockPos)
                ? Blocks.AIR.defaultBlockState()
                : blockState;
    }

    public VoxelShape getCollisionShape(BlockState blockState, BlockGetter blockGetter, BlockPos blockPos,
            CollisionContext context) {
        if (blockState.getValue(AGE) == 0)
            return COLLISION_SHAPE_BULB;

        return blockState.getValue(HALF) == DoubleBlockHalf.LOWER
                ? COLLISION_SHAPE_CROP
                : super.getCollisionShape(blockState, blockGetter, blockPos, context);
    }

    public boolean canSurvive(BlockState blockState, LevelReader levelReader, BlockPos blockPos) {
        if (!isLower(blockState)) {
            return super.canSurvive(blockState, levelReader, blockPos);
        }

        BlockPos below = blockPos.below();
        boolean isSoil = this.mayPlaceOn(levelReader.getBlockState(below), levelReader, below);

        // Forge: This function is called during world gen and placement, before
        // this block is set, so if we are not 'here' then assume it's the
        // pre-check.
        if (blockState.getBlock() == this)
            isSoil = levelReader.getBlockState(below).canSustainPlant(levelReader, below, Direction.UP, this);

        return isSoil
                && sufficientLight(levelReader, blockPos)
                && (blockState.getValue(AGE) < MAX_AGE - 1 || isUpper(levelReader.getBlockState(blockPos.above())));
    }

    protected boolean mayPlaceOn(BlockState blockState, BlockGetter blockGetter, BlockPos blockPos) {
        return blockState.is(Blocks.FARMLAND);
    }

    protected void createBlockStateDefinition(StateDefinition.Builder<Block, BlockState> builder) {
        builder.add(AGE);
        super.createBlockStateDefinition(builder);
    }

    public VoxelShape getShape(BlockState blockState, BlockGetter blockGetter, BlockPos blockPos,
            CollisionContext context) {
        return blockState.getValue(HALF) == DoubleBlockHalf.UPPER
                ? UPPER_SHAPE_BY_AGE[Math.min(Math.abs(MAX_AGE - (blockState.getValue(AGE) + 1)),
                        UPPER_SHAPE_BY_AGE.length - 1)]
                : LOWER_SHAPE_BY_AGE[blockState.getValue(AGE)];
    }

    public void entityInside(BlockState blockState, Level level, BlockPos blockPos, Entity entity) {
        if (entity instanceof Ravager && level.getGameRules().getBoolean(GameRules.RULE_MOBGRIEFING))
            level.destroyBlock(blockPos, true, entity);

        super.entityInside(blockState, level, blockPos, entity);
    }

    public boolean canBeReplaced(BlockState blockState, BlockPlaceContext context) {
        return false;
    }

    public void setPlacedBy(Level level, BlockPos blockPos, BlockState blockState, LivingEntity entity,
            ItemStack itemStack) {
    }

    protected static float getGrowthSpeed(Block block, BlockGetter blockGetter, BlockPos blockPos) {
        float f = 1.0F;
        BlockPos blockpos = blockPos.below();

        for (int i = -1; i <= 1; ++i) {
            for (int j = -1; j <= 1; ++j) {
                float f1 = 0.0F;

                BlockState blockstate = blockGetter.getBlockState(blockpos.offset(i, 0, j));
                if (blockstate.canSustainPlant(blockGetter, blockpos.offset(i, 0, j), Direction.UP,
                        (IPlantable) block)) {
                    f1 = 1.0F;

                    if (blockstate.isFertile(blockGetter, blockPos.offset(i, 0, j)))
                        f1 = 3.0F;
                }

                if (i != 0 || j != 0)
                    f1 /= 4.0F;

                f += f1;
            }
        }

        BlockPos blockpos1 = blockPos.north();
        BlockPos blockpos2 = blockPos.south();
        BlockPos blockpos3 = blockPos.west();
        BlockPos blockpos4 = blockPos.east();

        boolean flag = blockGetter.getBlockState(blockpos3).is(block)
                || blockGetter.getBlockState(blockpos4).is(block);
        boolean flag1 = blockGetter.getBlockState(blockpos1).is(block)
                || blockGetter.getBlockState(blockpos2).is(block);

        if (flag && flag1)
            return f / 2.0F;

        boolean flag2 = blockGetter.getBlockState(blockpos3.north()).is(block)
                || blockGetter.getBlockState(blockpos4.north()).is(block)
                || blockGetter.getBlockState(blockpos4.south()).is(block)
                || blockGetter.getBlockState(blockpos3.south()).is(block);
        if (flag2)
            return f / 2.0F;

        return f;
    }

    public void randomTick(BlockState blockState, ServerLevel serverLevel, BlockPos blockPos,
            RandomSource randomSource) {
        float f = getGrowthSpeed(this, serverLevel, blockPos);
        boolean flag = randomSource.nextInt((int) (25.0F / f) + 1) == 0;
        if (flag) {
            this.grow(serverLevel, blockState, blockPos, 1);
        }

    }

    private void grow(ServerLevel serverLevel, BlockState blockState, BlockPos blockPos, int growthAmount) {
        int i = Math.min(blockState.getValue(AGE) + growthAmount, MAX_AGE);
        if (this.canGrow(serverLevel, blockPos, blockState, i)) {
            serverLevel.setBlock(blockPos, blockState.setValue(AGE, Integer.valueOf(i)), 2);
            if (i >= 3) {
                BlockPos blockpos = blockPos.above();
                serverLevel.setBlock(blockpos, copyWaterloggedFrom(serverLevel, blockPos, this.defaultBlockState()
                        .setValue(AGE, Integer.valueOf(i)).setValue(HALF, DoubleBlockHalf.UPPER)), 3);
            }
        }
    }

    private static boolean canGrowInto(LevelReader levelReader, BlockPos blockPos) {
        BlockState blockstate = levelReader.getBlockState(blockPos);
        return blockstate.isAir() || blockstate.is(Blocks.PITCHER_CROP);
    }

    private static boolean sufficientLight(LevelReader levelReader, BlockPos blockPos) {
        return levelReader.getRawBrightness(blockPos, 0) >= 8 || levelReader.canSeeSky(blockPos);
    }

    private static boolean isLower(BlockState blockState) {
        return blockState.is(Blocks.PITCHER_CROP) && blockState.getValue(HALF) == DoubleBlockHalf.LOWER;
    }

    private static boolean isUpper(BlockState blockState) {
        return blockState.is(Blocks.PITCHER_CROP) && blockState.getValue(HALF) == DoubleBlockHalf.UPPER;
    }

    private boolean canGrow(LevelReader levelReader, BlockPos blockPos, BlockState blockState, int growthAmount) {
        return !this.isMaxAge(blockState) && sufficientLight(levelReader, blockPos)
                && (growthAmount < MAX_AGE - 1 || canGrowInto(levelReader, blockPos.above()));
    }

    @Nullable
    private PosAndState getLowerHalf(LevelReader levelReader, BlockPos blockPos, BlockState blockState) {
        if (isLower(blockState)) {
            return new PosAndState(blockPos, blockState);
        } else {
            BlockPos blockpos = blockPos.below();
            BlockState blockstate = levelReader.getBlockState(blockpos);
            return isLower(blockstate) ? new PosAndState(blockpos, blockstate) : null;
        }
    }

    public boolean isValidBonemealTarget(LevelReader levelReader, BlockPos blockPos, BlockState blockState,
            boolean unused) {
        PosAndState pitchercropblock$posandstate = this.getLowerHalf(levelReader, blockPos, blockState);
        return pitchercropblock$posandstate == null ? false
                : this.canGrow(levelReader, pitchercropblock$posandstate.pos, pitchercropblock$posandstate.state,
                        pitchercropblock$posandstate.state.getValue(AGE) + 1);
    }

    public boolean isBonemealSuccess(Level level, RandomSource randomSource, BlockPos blockPos,
            BlockState blockState) {
        return true;
    }

    public void performBonemeal(ServerLevel serverLevel, RandomSource randomSource, BlockPos blockPos,
            BlockState blockState) {
        PosAndState pitchercropblock$posandstate = this.getLowerHalf(serverLevel, blockPos, blockState);
        if (pitchercropblock$posandstate != null) {
            this.grow(serverLevel, pitchercropblock$posandstate.state, pitchercropblock$posandstate.pos, 1);
        }
    }

    static record PosAndState(BlockPos pos, BlockState state) {
    }
}
