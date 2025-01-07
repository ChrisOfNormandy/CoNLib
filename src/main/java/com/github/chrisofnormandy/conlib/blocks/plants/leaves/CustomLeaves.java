package com.github.chrisofnormandy.conlib.blocks.plants.leaves;

import net.minecraft.core.BlockPos;
import net.minecraft.core.Direction;
import net.minecraft.core.particles.ParticleOptions;
import net.minecraft.util.ParticleUtils;
import net.minecraft.util.RandomSource;
import net.minecraft.world.level.Level;
import net.minecraft.world.level.block.CherryLeavesBlock;
import net.minecraft.world.level.block.state.BlockState;

// Implement methods for mangrove leaves?

public class CustomLeaves extends CherryLeavesBlock {

    ParticleOptions particles;

    public CustomLeaves(Properties properties) {
        super(properties);
    }

    public CustomLeaves(Properties properties, ParticleOptions particles) {
        super(properties);
        this.particles = particles;
    }

    @Override
    public void animateTick(BlockState blockState, Level level, BlockPos blockPos, RandomSource randomSource) {
        super.animateTick(blockState, level, blockPos, randomSource);

        if (this.particles != null && randomSource.nextInt(10) == 0) {
            BlockPos blockpos = blockPos.below();
            BlockState blockstate = level.getBlockState(blockpos);

            if (!isFaceFull(blockstate.getCollisionShape(level, blockpos), Direction.UP)) {
                ParticleUtils.spawnParticleBelow(level, blockPos, randomSource, this.particles);
            }
        }
    }
}
