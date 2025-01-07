package com.github.chrisofnormandy.conlib.crops;

import com.github.chrisofnormandy.conlib.collections.Tuple;
import com.github.chrisofnormandy.conlib.registry.BlockRegistry;

import net.minecraft.world.item.Item;
import net.minecraft.world.level.block.AttachedStemBlock;
import net.minecraft.world.level.block.Blocks;
import net.minecraft.world.level.block.StemBlock;
import net.minecraft.world.level.block.StemGrownBlock;
import net.minecraft.world.level.block.state.BlockBehaviour.Properties;

public class Stems {
    public static class AttachedStems {
        public static final AttachedStemBlock create(String name, StemGrownBlock fruit,
                Item seeds) {
            return BlockRegistry.register(name,
                    new AttachedStemBlock(fruit, () -> seeds, Properties.copy(Blocks.ATTACHED_PUMPKIN_STEM)));
        }

        public static final AttachedStemBlock create(String name, Properties properties, StemGrownBlock fruit,
                Item seeds) {
            return BlockRegistry.register(name, new AttachedStemBlock(fruit, () -> seeds, properties));
        }
    }

    public static class GrowingStems {
        public static final StemBlock create(String name, StemGrownBlock fruit, Item seeds) {
            return BlockRegistry.register(name,
                    new StemBlock(fruit, () -> seeds, Properties.copy(Blocks.PUMPKIN_STEM)));
        }

        public static final StemBlock create(String name, Properties properties,
                StemGrownBlock fruit, Item seeds) {
            return BlockRegistry.register(name, new StemBlock(fruit, () -> seeds, properties));
        }
    }

    public static Tuple<StemBlock, AttachedStemBlock> create(String name, Properties properties,
            StemGrownBlock fruit, Item seeds) {
        StemBlock stem = GrowingStems.create(name, properties, fruit, seeds);
        AttachedStemBlock attachedStem = AttachedStems.create("attached_" + name, properties, fruit, seeds);

        return new Tuple<>(stem, attachedStem);
    }

    public static Tuple<StemBlock, AttachedStemBlock> create(String name, StemGrownBlock fruit, Item seeds) {
        StemBlock stem = GrowingStems.create(name, fruit, seeds);
        AttachedStemBlock attachedStem = AttachedStems.create("attached_" + name, fruit, seeds);

        return new Tuple<>(stem, attachedStem);
    }
}
