package com.github.chrisofnormandy.conlib.event;

import java.util.Random;

import com.github.chrisofnormandy.conlib.collections.Tuple;
import com.github.chrisofnormandy.conlib.registry.ModRegister;

import net.minecraft.block.Block;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.item.ItemStack;
import net.minecraftforge.event.world.BlockEvent;
import net.minecraftforge.eventbus.api.SubscribeEvent;


public class BlockBreak {
    @SubscribeEvent
    public static void cancelBlockBreak(final BlockEvent.BreakEvent event) {
        Block blockIn = event.getState().getBlock();

        if (ModRegister.blocks_unbreakable.containsKey(blockIn.getRegistryName().toString()))
            event.setCanceled(true);
    }

    @SubscribeEvent
    public static void replaceBlock(final BlockEvent.BreakEvent event) {
        Block blockIn = event.getState().getBlock();
        PlayerEntity player = event.getPlayer();

        if (ModRegister.blocks_replaceable.containsKey(blockIn.getRegistryName().toString())) {

            if (player.hasCorrectToolForDrops(event.getState())) {
                Random rand = new Random();
                event.setCanceled(true);

                Tuple<Block, Block> repl = ModRegister.blocks_replaceable.get(blockIn.getRegistryName().toString());

                event.getWorld().setBlock(event.getPos(), repl.y.defaultBlockState(), 1);

                ItemStack stack = new ItemStack(blockIn.asItem(), rand.nextInt());
                event.getPlayer().addItem(stack);
            }
        }
    }
}
