package com.github.chrisofnormandy.conlib.blocks.plants.sponges;

import com.github.chrisofnormandy.conlib.collections.Tuple;
import com.github.chrisofnormandy.conlib.registry.BlockRegistry;

import net.minecraft.resources.ResourceKey;
import net.minecraft.world.item.CreativeModeTab;
import net.minecraft.world.level.block.Blocks;
import net.minecraft.world.level.block.WetSpongeBlock;
import net.minecraft.world.level.block.state.BlockBehaviour.Properties;

public class Sponges {

    public static class WetSponges {
        public static final WetSpongeBlock create(String name) {
            return create(name, Properties.copy(Blocks.WET_SPONGE));
        }

        public static final WetSpongeBlock create(String name, ResourceKey<CreativeModeTab> creativeTab) {
            return create(name, Properties.copy(Blocks.WET_SPONGE), creativeTab);
        }

        public static final WetSpongeBlock create(String name, Properties properties) {
            return BlockRegistry.register(name, new WetSpongeBlock(properties));
        }

        public static final WetSpongeBlock create(String name, Properties properties,
                ResourceKey<CreativeModeTab> creativeTab) {
            return BlockRegistry.register(name, new WetSpongeBlock(properties), creativeTab);
        }
    }

    // Add sea foliage and liquid to dry sponge after this.
    public static final Tuple<Sponge, WetSpongeBlock> create(String name,
            Properties dryProperties,
            Properties wetProperties) {
        WetSpongeBlock wet = WetSponges.create("wet_" + name, wetProperties);
        Sponge dry = BlockRegistry.register(name, new Sponge(dryProperties)).setWetSponge(wet);

        return new Tuple<Sponge, WetSpongeBlock>(dry, wet);
    }

    // Add sea foliage and liquid to dry sponge after this.
    public static final Tuple<Sponge, WetSpongeBlock> create(String name,
            Properties dryProperties,
            Properties wetProperties,
            ResourceKey<CreativeModeTab> creativeTab) {
        WetSpongeBlock wet = WetSponges.create("wet_" + name, wetProperties, creativeTab);
        Sponge dry = BlockRegistry.register(name, new Sponge(dryProperties), creativeTab).setWetSponge(wet);

        return new Tuple<Sponge, WetSpongeBlock>(dry, wet);
    }
}
