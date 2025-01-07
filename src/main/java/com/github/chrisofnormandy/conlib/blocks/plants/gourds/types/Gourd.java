package com.github.chrisofnormandy.conlib.blocks.plants.gourds.types;

import net.minecraft.core.BlockPos;
import net.minecraft.core.Direction;
import net.minecraft.sounds.SoundEvents;
import net.minecraft.sounds.SoundSource;
import net.minecraft.stats.Stats;
import net.minecraft.world.InteractionHand;
import net.minecraft.world.InteractionResult;
import net.minecraft.world.entity.item.ItemEntity;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.Items;
import net.minecraft.world.level.Level;
import net.minecraft.world.level.block.AttachedStemBlock;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.CarvedPumpkinBlock;
import net.minecraft.world.level.block.PumpkinBlock;
import net.minecraft.world.level.block.StemBlock;
import net.minecraft.world.level.block.state.BlockState;
import net.minecraft.world.level.gameevent.GameEvent;
import net.minecraft.world.phys.BlockHitResult;

public class Gourd extends PumpkinBlock {

    private Block carvedBlock;

    private StemBlock stemBlock;
    private AttachedStemBlock attachedStemBlock;

    private Item seeds;
    private int seedCount = 4;

    private Item carveItem = Items.SHEARS;

    public Gourd(Properties properties) {
        super(properties);
    }

    public Gourd(Properties properties, Block carvedBlock, StemBlock stemBlock, AttachedStemBlock attachedStemBlock,
            Item seeds) {
        super(properties);
        this.carvedBlock = carvedBlock;
        this.stemBlock = stemBlock;
        this.attachedStemBlock = attachedStemBlock;
        this.seeds = seeds;
    }

    public Gourd setSeeds(Item seeds) {
        this.seeds = seeds;
        return this;
    }

    public Gourd setCarvedBlock(Block block) {
        this.carvedBlock = block;
        return this;
    }

    public Gourd setStemBlock(StemBlock block) {
        this.stemBlock = block;
        return this;
    }

    public Gourd setAttachedStemBlock(AttachedStemBlock block) {
        this.attachedStemBlock = block;
        return this;
    }

    public Gourd setCarveItem(Item item) {
        this.carveItem = item;
        return this;
    }

    public Gourd setSeedCount(int count) {
        this.seedCount = count;
        return this;
    }

    @Override
    public InteractionResult use(BlockState blockState,
            Level level,
            BlockPos blockPos,
            Player player,
            InteractionHand hand,
            BlockHitResult hitResult) {
        ItemStack itemstack = player.getItemInHand(hand);

        if (itemstack.canPerformAction(net.minecraftforge.common.ToolActions.SHEARS_CARVE)) {
            if (!level.isClientSide) {
                Direction direction = hitResult.getDirection();
                Direction direction1 = direction.getAxis() == Direction.Axis.Y ? player.getDirection().getOpposite()
                        : direction;

                level.playSound((Player) null, blockPos, SoundEvents.PUMPKIN_CARVE, SoundSource.BLOCKS, 1.0F, 1.0F);

                level.setBlock(blockPos,
                        this.carvedBlock.defaultBlockState().setValue(CarvedPumpkinBlock.FACING, direction1),
                        11);

                ItemEntity itementity = new ItemEntity(level,
                        (double) blockPos.getX() + 0.5D + (double) direction1.getStepX() * 0.65D,
                        (double) blockPos.getY() + 0.1D,
                        (double) blockPos.getZ() + 0.5D + (double) direction1.getStepZ() * 0.65D,
                        new ItemStack(this.seeds, this.seedCount));

                itementity.setDeltaMovement(
                        0.05D * (double) direction1.getStepX() + level.random.nextDouble() * 0.02D, 0.05D,
                        0.05D * (double) direction1.getStepZ() + level.random.nextDouble() * 0.02D);

                level.addFreshEntity(itementity);

                itemstack.hurtAndBreak(1, player, (playerConsumer) -> {
                    playerConsumer.broadcastBreakEvent(hand);
                });

                level.gameEvent(player, GameEvent.SHEAR, blockPos);
                player.awardStat(Stats.ITEM_USED.get(this.carveItem));
            }

            return InteractionResult.sidedSuccess(level.isClientSide);
        } else {
            return super.use(blockState, level, blockPos, player, hand, hitResult);
        }
    }

    @Override
    public StemBlock getStem() {
        return this.stemBlock;
    }

    @Override
    public AttachedStemBlock getAttachedStem() {
        return this.attachedStemBlock;
    }
}
