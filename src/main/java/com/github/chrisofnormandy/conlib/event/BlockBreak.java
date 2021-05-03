package com.github.chrisofnormandy.conlib.event;

import java.util.Random;

import com.github.chrisofnormandy.conlib.registry.ModRegister;

// import org.apache.logging.log4j.LogManager;
// import org.apache.logging.log4j.Logger;

import net.minecraft.block.Block;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.item.Item;
import net.minecraftforge.common.ToolType;
import net.minecraftforge.event.world.BlockEvent;
import net.minecraftforge.eventbus.api.SubscribeEvent;


public class BlockBreak {
    // private static Logger LOG = LogManager.getLogger();

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

            // if (player.getHeldItemMainhand() != null) {
            //     Item heldItem = player.getHeldItemMainhand().getItem();
    
            //     if (heldItem.getHarvestLevel(player.getHeldItemMainhand(), ToolType.PICKAXE, player, blockIn.getDefaultState()) != -1) {
            //         Random rand = new Random();
            //         event.setCanceled(true);

            //         event.getWorld().setBlockState(event.getPos(), ModRegister.blocks_replaceable.get(blockIn.getRegistryName().toString()).getDefaultState(), 1);

            //         event.getPlayer().addItemStackToInventory(ModRegister.nodes.get(blockIn.getRegistryName().toString()).getDrop(rand));
            //         // event.getWorld().playSound(player, event.getPos(), new SoundEvent(new ResourceLocation("minecraft", "entity.item.pickup")), SoundCategory.NEUTRAL, 1.0f, 1.0f);
            //     }
            // }
        }
    }
}
