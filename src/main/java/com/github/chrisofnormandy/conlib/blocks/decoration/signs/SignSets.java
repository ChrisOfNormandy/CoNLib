package com.github.chrisofnormandy.conlib.blocks.decoration.signs;

import com.github.chrisofnormandy.conlib.blocks.decoration.signs.HangingSigns.CeilingHangingSigns;
import com.github.chrisofnormandy.conlib.blocks.decoration.signs.HangingSigns.WallHangingSigns;
import com.github.chrisofnormandy.conlib.blocks.decoration.signs.Signs.StandingSigns;
import com.github.chrisofnormandy.conlib.blocks.decoration.signs.Signs.WallSigns;

import net.minecraft.resources.ResourceKey;
import net.minecraft.world.item.CreativeModeTab;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.state.BlockBehaviour.Properties;

public class SignSets {
    public static final Block[] create(String name) {
        return new Block[] {
                StandingSigns.create(name),
                WallSigns.create("wall_" + name),
                CeilingHangingSigns.create("hanging_" + name),
                WallHangingSigns.create("wall_hanging_" + name)
        };
    }

    public static final Block[] create(String name, ResourceKey<CreativeModeTab> creativeTab) {
        return new Block[] {
                StandingSigns.create(name, creativeTab),
                WallSigns.create("wall_" + name, creativeTab),
                CeilingHangingSigns.create("hanging_" + name, creativeTab),
                WallHangingSigns.create("wall_hanging_" + name, creativeTab)
        };
    }

    public static final Block[] create(String name, Properties properties) {
        return new Block[] {
                StandingSigns.create(name, properties),
                WallSigns.create("wall_" + name, properties),
                CeilingHangingSigns.create("hanging_" + name, properties),
                WallHangingSigns.create("wall_hanging_" + name, properties)
        };
    }

    public static final Block[] create(String name, Properties properties, ResourceKey<CreativeModeTab> creativeTab) {
        return new Block[] {
                StandingSigns.create(name, properties, creativeTab),
                WallSigns.create("wall_" + name, properties, creativeTab),
                CeilingHangingSigns.create("hanging_" + name, properties, creativeTab),
                WallHangingSigns.create("wall_hanging_" + name, properties, creativeTab)
        };
    }
}
