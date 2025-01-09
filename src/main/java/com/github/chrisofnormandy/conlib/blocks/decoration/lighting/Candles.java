package com.github.chrisofnormandy.conlib.blocks.decoration.lighting;

import com.github.chrisofnormandy.conlib.collections.Tuple;
import com.github.chrisofnormandy.conlib.registry.BlockRegistry;

import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.Blocks;
import net.minecraft.world.level.block.CandleBlock;
import net.minecraft.world.level.block.CandleCakeBlock;
import net.minecraft.world.level.block.state.BlockBehaviour.Properties;
import net.minecraftforge.registries.RegistryObject;
import net.minecraft.world.item.CreativeModeTab;
import net.minecraft.resources.ResourceKey;

public class Candles {
    public static class CakeCandles {

        public static final RegistryObject<CandleCakeBlock> create(String name, Block standingCandle) {
            return create(name, Properties.copy(Blocks.CANDLE_CAKE), standingCandle);
        }

        public static final RegistryObject<CandleCakeBlock> create(String name, Block standingCandle,
                ResourceKey<CreativeModeTab> creativeTab) {
            return create(name, Properties.copy(Blocks.CANDLE_CAKE), standingCandle, creativeTab);
        }

        public static final RegistryObject<CandleCakeBlock> create(String name, Properties properties,
                Block standingCandle) {
            return BlockRegistry.register(name, () -> new CandleCakeBlock(standingCandle, properties));
        }

        public static final RegistryObject<CandleCakeBlock> create(String name, Properties properties,
                Block standingCandle,
                ResourceKey<CreativeModeTab> creativeTab) {
            return BlockRegistry.register(name, () -> new CandleCakeBlock(standingCandle, properties), creativeTab);
        }
    }

    public static class PlainCandles {

        public static final RegistryObject<CandleBlock> create(String name) {
            return create(name, Properties.copy(Blocks.FIRE));
        }

        public static final RegistryObject<CandleBlock> create(String name, ResourceKey<CreativeModeTab> creativeTab) {
            return create(name, Properties.copy(Blocks.FIRE), creativeTab);
        }

        public static final RegistryObject<CandleBlock> create(String name, Properties properties) {
            return BlockRegistry.register(name, () -> new CandleBlock(properties));
        }

        public static final RegistryObject<CandleBlock> create(String name, Properties properties,
                ResourceKey<CreativeModeTab> creativeTab) {
            return BlockRegistry.register(name, () -> new CandleBlock(properties), creativeTab);
        }
    }

    public static final Tuple<RegistryObject<CandleBlock>, RegistryObject<CandleCakeBlock>> create(String name) {
        return create(name, Properties.copy(Blocks.WHITE_CANDLE));
    }

    public static final Tuple<RegistryObject<CandleBlock>, RegistryObject<CandleCakeBlock>> create(String name,
            ResourceKey<CreativeModeTab> creativeTab) {
        return create(name, Properties.copy(Blocks.WHITE_CANDLE), creativeTab);
    }

    public static final Tuple<RegistryObject<CandleBlock>, RegistryObject<CandleCakeBlock>> create(String name,
            Properties properties) {
        var standing = PlainCandles.create(name, properties);
        var cake = CakeCandles.create(name + "_cake", properties, standing.get());

        return new Tuple<>(standing, cake);
    }

    public static final Tuple<RegistryObject<CandleBlock>, RegistryObject<CandleCakeBlock>> create(String name,
            Properties properties,
            ResourceKey<CreativeModeTab> creativeTab) {
        var standing = PlainCandles.create(name, properties, creativeTab);
        var cake = CakeCandles.create(name + "_cake", properties, standing.get());

        return new Tuple<>(standing, cake);
    }
}