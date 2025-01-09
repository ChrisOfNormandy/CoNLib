package com.github.chrisofnormandy.conlib.blocks.plants.sponges;

import com.github.chrisofnormandy.conlib.blocks.plants.sponges.types.Sponge;
import com.github.chrisofnormandy.conlib.collections.Tuple;
import com.github.chrisofnormandy.conlib.registry.BlockRegistry;

import net.minecraft.resources.ResourceKey;
import net.minecraft.world.item.CreativeModeTab;
import net.minecraft.world.level.block.Blocks;
import net.minecraft.world.level.block.WetSpongeBlock;
import net.minecraft.world.level.block.state.BlockBehaviour.Properties;
import net.minecraftforge.registries.RegistryObject;

public class Sponges {

    public static class WetSponges {

        public static final RegistryObject<WetSpongeBlock> create(String name) {
            return create(name, Properties.copy(Blocks.WET_SPONGE));
        }

        public static final RegistryObject<WetSpongeBlock> create(String name,
                ResourceKey<CreativeModeTab> creativeTab) {
            return create(name, Properties.copy(Blocks.WET_SPONGE), creativeTab);
        }

        public static final RegistryObject<WetSpongeBlock> create(String name, Properties properties) {
            return BlockRegistry.register(name, () -> new WetSpongeBlock(properties));
        }

        public static final RegistryObject<WetSpongeBlock> create(String name, Properties properties,
                ResourceKey<CreativeModeTab> creativeTab) {
            return BlockRegistry.register(name, () -> new WetSpongeBlock(properties), creativeTab);
        }
    }

    // Add sea foliage and liquid to dry sponge after this.
    public static final Tuple<RegistryObject<Sponge>, RegistryObject<WetSpongeBlock>> create(String name,
            Properties dryProperties,
            Properties wetProperties) {
        var wet = WetSponges.create("wet_" + name, wetProperties);
        var dry = BlockRegistry.register(name, () -> new Sponge(dryProperties));
        dry.get().setWetSponge(wet.get());

        return new Tuple<>(dry, wet);
    }

    // Add sea foliage and liquid to dry sponge after this.
    public static final Tuple<RegistryObject<Sponge>, RegistryObject<WetSpongeBlock>> create(String name,
            Properties dryProperties,
            Properties wetProperties,
            ResourceKey<CreativeModeTab> creativeTab) {
        var wet = WetSponges.create("wet_" + name, wetProperties, creativeTab);
        var dry = BlockRegistry.register(name, () -> new Sponge(dryProperties), creativeTab);
        dry.get().setWetSponge(wet.get());

        return new Tuple<>(dry, wet);
    }
}
