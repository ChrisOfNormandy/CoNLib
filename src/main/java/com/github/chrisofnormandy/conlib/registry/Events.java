package com.github.chrisofnormandy.conlib.registry;

import net.minecraftforge.common.MinecraftForge;

public class Events {
    /**
     * 
     * @param event The class that defines the event. See
     *              <strong>com.github.chrisofnormandy.conlib.event.BlockBreak</strong>
     *              for an example.
     */
    public static void register(Object event) {
        MinecraftForge.EVENT_BUS.register(event);

    }
}
