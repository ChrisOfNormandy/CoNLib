package com.github.chrisofnormandy.conlib.blocks.decoration.signs;

import com.github.chrisofnormandy.conlib.collections.Tuple;
import com.github.chrisofnormandy.conlib.registry.BlockRegistry;

import net.minecraft.resources.ResourceKey;
import net.minecraft.world.item.CreativeModeTab;
import net.minecraft.world.level.block.Blocks;
import net.minecraft.world.level.block.CeilingHangingSignBlock;
import net.minecraft.world.level.block.WallHangingSignBlock;
import net.minecraft.world.level.block.state.BlockBehaviour.Properties;
import net.minecraft.world.level.block.state.properties.WoodType;
import net.minecraftforge.registries.RegistryObject;

public class HangingSigns {
    public static class CeilingHangingSigns {

        public static final RegistryObject<CeilingHangingSignBlock> create(String name) {
            return create(name, Properties.copy(Blocks.OAK_SIGN), WoodType.OAK);
        }

        public static final RegistryObject<CeilingHangingSignBlock> create(String name,
                ResourceKey<CreativeModeTab> creativeTab) {
            return create(name, Properties.copy(Blocks.OAK_SIGN), WoodType.OAK, creativeTab);
        }

        public static final RegistryObject<CeilingHangingSignBlock> create(String name, Properties properties) {
            return create(name, properties, WoodType.OAK);
        }

        public static final RegistryObject<CeilingHangingSignBlock> create(String name, Properties properties,
                ResourceKey<CreativeModeTab> creativeTab) {
            return create(name, properties, WoodType.OAK, creativeTab);
        }

        public static final RegistryObject<CeilingHangingSignBlock> create(String name, Properties properties,
                WoodType woodType) {
            return BlockRegistry.register(name, () -> new CeilingHangingSignBlock(properties, woodType));
        }

        public static final RegistryObject<CeilingHangingSignBlock> create(String name, Properties properties,
                WoodType woodType,
                ResourceKey<CreativeModeTab> creativeTab) {
            return BlockRegistry.register(name, () -> new CeilingHangingSignBlock(properties, woodType), creativeTab);
        }
    }

    public static class WallHangingSigns {

        public static final RegistryObject<WallHangingSignBlock> create(String name) {
            return create(name, Properties.copy(Blocks.OAK_SIGN), WoodType.OAK);
        }

        public static final RegistryObject<WallHangingSignBlock> create(String name,
                ResourceKey<CreativeModeTab> creativeTab) {
            return create(name, Properties.copy(Blocks.OAK_SIGN), WoodType.OAK, creativeTab);
        }

        public static final RegistryObject<WallHangingSignBlock> create(String name, Properties properties) {
            return create(name, properties, WoodType.OAK);
        }

        public static final RegistryObject<WallHangingSignBlock> create(String name, Properties properties,
                ResourceKey<CreativeModeTab> creativeTab) {
            return create(name, properties, WoodType.OAK, creativeTab);
        }

        public static final RegistryObject<WallHangingSignBlock> create(String name, Properties properties,
                WoodType woodType) {
            return BlockRegistry.register(name, () -> new WallHangingSignBlock(properties, woodType));
        }

        public static final RegistryObject<WallHangingSignBlock> create(String name, Properties properties,
                WoodType woodType,
                ResourceKey<CreativeModeTab> creativeTab) {
            return BlockRegistry.register(name, () -> new WallHangingSignBlock(properties, woodType), creativeTab);
        }
    }

    public static final Tuple<RegistryObject<WallHangingSignBlock>, RegistryObject<CeilingHangingSignBlock>> create(
            String name) {
        var ceiling = CeilingHangingSigns.create(name);
        var wall = WallHangingSigns.create(name);

        return new Tuple<>(wall, ceiling);
    }

    public static final Tuple<RegistryObject<WallHangingSignBlock>, RegistryObject<CeilingHangingSignBlock>> create(
            String name,
            ResourceKey<CreativeModeTab> creativeTab) {
        var ceiling = CeilingHangingSigns.create(name, creativeTab);
        var wall = WallHangingSigns.create(name, creativeTab);

        return new Tuple<>(wall, ceiling);
    }

    public static final Tuple<RegistryObject<WallHangingSignBlock>, RegistryObject<CeilingHangingSignBlock>> create(
            String name,
            Properties properties) {
        var ceiling = CeilingHangingSigns.create(name, properties);
        var wall = WallHangingSigns.create(name, properties);

        return new Tuple<>(wall, ceiling);
    }

    public static final Tuple<RegistryObject<WallHangingSignBlock>, RegistryObject<CeilingHangingSignBlock>> create(
            String name, Properties properties,
            ResourceKey<CreativeModeTab> creativeTab) {
        var ceiling = CeilingHangingSigns.create("hanging_" + name + "_sign", properties, creativeTab);
        var wall = WallHangingSigns.create("hanging_" + name + "_wall_sign", properties, creativeTab);

        return new Tuple<>(wall, ceiling);
    }
}
