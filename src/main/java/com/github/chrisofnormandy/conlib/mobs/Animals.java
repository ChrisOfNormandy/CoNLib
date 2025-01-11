package com.github.chrisofnormandy.conlib.mobs;

import com.github.chrisofnormandy.conlib.mobs.types.CustomAnimal;
import com.github.chrisofnormandy.conlib.registry.MobRegistry;

public class Animals {
    public static final void create(String name) {
        MobRegistry.register(name, CustomAnimal::new);
    }
}
