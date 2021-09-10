package com.github.chrisofnormandy.conlib.registry;

import net.minecraftforge.common.MinecraftForge;

public class Events {
    /**
     * 
     * @param event
     */
    public static final void register(Object event) {
        MinecraftForge.EVENT_BUS.register(event);
    }
}
