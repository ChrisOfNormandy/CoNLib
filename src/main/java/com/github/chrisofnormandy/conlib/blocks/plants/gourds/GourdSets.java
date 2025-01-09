package com.github.chrisofnormandy.conlib.blocks.plants.gourds;

import com.github.chrisofnormandy.conlib.crops.Stems;

import net.minecraft.world.item.Item;
import net.minecraftforge.registries.RegistryObject;

public class GourdSets {

    public static final RegistryObject<?>[] create(String name, Item seeds) {
        // CarvedGourd carved = CarvedGourds.create(name);
        var weableCarved = EquipableGourds.create(name);
        var lantern = CarvedGourdLanterns.create(name);

        var gourdRegistry = Gourds.create(name);
        var gourd = gourdRegistry.get();
        gourd.setCarvedBlock(weableCarved.get())
                .setSeeds(seeds);

        var stems = Stems.create(name, gourd, seeds);

        gourd.setStemBlock(stems.x.get())
                .setAttachedStemBlock(stems.y.get());

        return new RegistryObject<?>[] {
                gourdRegistry,
                weableCarved,
                lantern,
                stems.x,
                stems.y
        };
    }
}
