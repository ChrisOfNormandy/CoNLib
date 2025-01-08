package com.github.chrisofnormandy.conlib.dimensions.portals;

import com.google.common.base.Predicates;

import net.minecraft.core.BlockPos;
import net.minecraft.core.Direction;
import net.minecraft.world.item.context.BlockPlaceContext;
import net.minecraft.world.level.BlockGetter;
import net.minecraft.world.level.Level;
import net.minecraft.world.level.LevelAccessor;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.HorizontalDirectionalBlock;
import net.minecraft.world.level.block.Mirror;
import net.minecraft.world.level.block.Rotation;
import net.minecraft.world.level.block.state.BlockState;
import net.minecraft.world.level.block.state.StateDefinition;
import net.minecraft.world.level.block.state.pattern.BlockInWorld;
import net.minecraft.world.level.block.state.pattern.BlockPattern;
import net.minecraft.world.level.block.state.pattern.BlockPatternBuilder;
import net.minecraft.world.level.block.state.predicate.BlockStatePredicate;
import net.minecraft.world.level.block.state.properties.BooleanProperty;
import net.minecraft.world.level.block.state.properties.DirectionProperty;
import net.minecraft.world.level.pathfinder.PathComputationType;
import net.minecraft.world.phys.shapes.CollisionContext;
import net.minecraft.world.phys.shapes.Shapes;
import net.minecraft.world.phys.shapes.VoxelShape;

public class HorizontalPortalFrame extends Block {
    public static final DirectionProperty FACING = HorizontalDirectionalBlock.FACING;
    public static final BooleanProperty HAS_ACTIVATED = BooleanProperty.create("activated");
    protected static final VoxelShape BASE_SHAPE = Block.box(0.0D, 0.0D, 0.0D, 16.0D, 13.0D, 16.0D);
    protected static final VoxelShape ACTIVATED_SHAPE = Block.box(4.0D, 13.0D, 4.0D, 12.0D, 16.0D, 12.0D);
    protected static final VoxelShape FULL_SHAPE = Shapes.or(BASE_SHAPE, ACTIVATED_SHAPE);
    private static BlockPattern portalShape;

    public HorizontalPortalFrame(Properties properties) {
        super(properties);
        this.registerDefaultState(
                this.stateDefinition.any().setValue(FACING, Direction.NORTH).setValue(HAS_ACTIVATED,
                        Boolean.valueOf(false)));
    }

    public boolean useShapeForLightOcclusion(BlockState blockState) {
        return true;
    }

    public VoxelShape getShape(BlockState blockState, BlockGetter blockGetter, BlockPos blockPos,
            CollisionContext context) {
        return blockState.getValue(HAS_ACTIVATED)
                ? FULL_SHAPE
                : BASE_SHAPE;
    }

    public BlockState getStateForPlacement(BlockPlaceContext context) {
        return this.defaultBlockState()
                .setValue(FACING, context.getHorizontalDirection().getOpposite())
                .setValue(HAS_ACTIVATED, Boolean.valueOf(false));
    }

    public boolean hasAnalogOutputSignal(BlockState blockState) {
        return true;
    }

    public int getAnalogOutputSignal(BlockState blockState, Level level, BlockPos blockPos) {
        return blockState.getValue(HAS_ACTIVATED)
                ? 15
                : 0;
    }

    public BlockState rotate(BlockState blockState, Rotation rotation) {
        return blockState.setValue(FACING, rotation.rotate(blockState.getValue(FACING)));
    }

    public BlockState mirror(BlockState blockState, Mirror mirror) {
        return blockState.rotate(mirror.getRotation(blockState.getValue(FACING)));
    }

    // Custom implementation, might not work...
    public BlockState mirror(BlockState blockState, Mirror mirror, LevelAccessor levelAccessor, BlockPos blockPos,
            Rotation rotation) {
        return blockState.rotate(levelAccessor, blockPos, mirror.getRotation(blockState.getValue(FACING)));
    }

    protected void createBlockStateDefinition(StateDefinition.Builder<Block, BlockState> builder) {
        builder.add(FACING, HAS_ACTIVATED);
    }

    public BlockPattern getOrCreatePortalShape() {
        if (portalShape == null) {
            portalShape = BlockPatternBuilder.start().aisle("?vvv?", ">???<", ">???<", ">???<", "?^^^?")
                    .where('?', BlockInWorld.hasState(BlockStatePredicate.ANY))
                    .where('^',
                            BlockInWorld.hasState(BlockStatePredicate.forBlock(this)
                                    .where(HAS_ACTIVATED, Predicates.equalTo(true))
                                    .where(FACING, Predicates.equalTo(Direction.SOUTH))))
                    .where('>',
                            BlockInWorld.hasState(BlockStatePredicate.forBlock(this)
                                    .where(HAS_ACTIVATED, Predicates.equalTo(true))
                                    .where(FACING, Predicates.equalTo(Direction.WEST))))
                    .where('v',
                            BlockInWorld.hasState(BlockStatePredicate.forBlock(this)
                                    .where(HAS_ACTIVATED, Predicates.equalTo(true))
                                    .where(FACING, Predicates.equalTo(Direction.NORTH))))
                    .where('<',
                            BlockInWorld.hasState(BlockStatePredicate.forBlock(this)
                                    .where(HAS_ACTIVATED, Predicates.equalTo(true))
                                    .where(FACING, Predicates.equalTo(Direction.EAST))))
                    .build();
        }

        return portalShape;
    }

    public boolean isPathfindable(BlockState blockState, BlockGetter blockGetter, BlockPos blockPos,
            PathComputationType pathComputationType) {
        return false;
    }
}
