package com.github.chrisofnormandy.conlib.blocks.plants.melons;

import com.github.chrisofnormandy.conlib.crops.Stems;

import net.minecraft.world.item.Item;
import net.minecraftforge.registries.RegistryObject;

public class MelonSets {

    public static final RegistryObject<?>[] create(String name, Item seeds) {
        var melon = Melons.create(name);

        var stems = Stems.create(name, melon.get(), seeds);
        melon.get().setStem(stems.x.get())
                .setAttachedStem(stems.y.get());

        return new RegistryObject<?>[] { melon, stems.x, stems.y };
    }
}
