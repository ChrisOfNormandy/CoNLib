package com.github.chrisofnormandy.conlib;

import net.minecraft.world.item.CreativeModeTabs;
import net.minecraft.world.item.Item;
import net.minecraftforge.common.MinecraftForge;
import net.minecraftforge.event.BuildCreativeModeTabContentsEvent;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.fml.common.Mod;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import com.github.chrisofnormandy.conlib.block.ModBlock;
import com.github.chrisofnormandy.conlib.registry.ModRegister;

@Mod("conlib")
public class Main {
    public static final Logger LOG = LogManager.getLogger();
    public static String MOD_ID = "conlib";
    public static Mod_Config config = new Mod_Config();

    public Main() {
        config.Init();
        MinecraftForge.EVENT_BUS.register(this);
    }

    // Registered on the MOD event bus
    // Assume we have RegistryObject<Item> and RegistryObject<Block> called ITEM and
    // BLOCK
    @SubscribeEvent
    public void buildContents(BuildCreativeModeTabContentsEvent event) {
        // Add to ingredients tab
        if (event.getTabKey() == CreativeModeTabs.INGREDIENTS) {
            ModRegister.items.forEach((String key, Item item) -> event.accept(item));
        }
        // Add others here...
    }
}