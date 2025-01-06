package com.github.chrisofnormandy.conlib;

import net.minecraftforge.common.MinecraftForge;
import net.minecraftforge.event.BuildCreativeModeTabContentsEvent;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.fml.common.Mod;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import com.github.chrisofnormandy.conlib.registry.ModRegister;

@Mod("conlib")
public class Main {
    public static final Logger LOG = LogManager.getLogger();
    public static String MOD_ID = "conlib";
    public static ModConfig config = new ModConfig();

    public Main() {
        config.Init();
        MinecraftForge.EVENT_BUS.register(this);
    }

    // Registered on the MOD event bus
    // Assume we have RegistryObject<Item> and RegistryObject<Block> called ITEM and
    // BLOCK
    @SubscribeEvent
    public void buildContents(BuildCreativeModeTabContentsEvent event) {
        ModRegister.assignCreativeTabs(event);
    }
}