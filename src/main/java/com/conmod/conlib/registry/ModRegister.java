package com.conmod.conlib.registry;

import java.util.Collection;
import java.util.HashSet;
import java.util.Set;
import java.util.function.Function;
import java.util.function.Supplier;

// import com.conmod.conlib.block.OreBase;

import net.minecraft.block.Block;
import net.minecraft.item.BlockItem;
import net.minecraft.item.BlockNamedItem;
import net.minecraft.item.Item;
import net.minecraftforge.eventbus.api.IEventBus;
import net.minecraftforge.fml.RegistryObject;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.ForgeRegistries;

public class ModRegister {
    private final DeferredRegister<Block> blockRegister;
    private final DeferredRegister<Item> itemRegister;

    private final Set<DeferredRegister<?>> activeRegistries = new HashSet<>();

    private final String modid;

    public ModRegister(String modid) {
        this.modid = modid;

        this.blockRegister = new DeferredRegister<>(ForgeRegistries.BLOCKS, modid);
        this.itemRegister = new DeferredRegister<>(ForgeRegistries.ITEMS, modid);
    }

    public void registerEventBus(IEventBus bus) {
        this.activeRegistries.forEach(obj -> obj.register(bus));
    }

    public Collection<RegistryObject<Block>> getBlocks() {
        return blockRegister.getEntries();
    }

    public Collection<RegistryObject<Item>> getItems() {
        return itemRegister.getEntries();
    }

    public <T extends Item> RegistryObject<T> registerItem(final String name, final Supplier<T> supplier) {
        this.activeRegistries.add(this.itemRegister);
        return this.itemRegister.register(name, supplier);
    }

    public <T extends Block> RegistryObject<T> registerBlock(final String name, final Supplier<T> supplier,
            final Supplier<Item.Properties> itemblockProperties) {
        this.activeRegistries.add(this.itemRegister);
        RegistryObject<T> result = registerBlockWithoutItem(name, supplier);
        this.itemRegister.register(name, blockItem(result, itemblockProperties));
        return result;
    }

    public <T extends Block> RegistryObject<T> registerBlockWithoutItem(final String name, final Supplier<T> supplier) {
        this.activeRegistries.add(this.blockRegister);
        return this.blockRegister.register(name, supplier);
    }

    public <T extends Block> Supplier<BlockItem> blockItem(RegistryObject<T> block,
            Supplier<Item.Properties> properties) {
        return () -> new BlockItem(block.get(), properties.get());
    }

    public <T extends Block> Supplier<BlockNamedItem> blockNamedItem(Supplier<RegistryObject<T>> block,
            Supplier<Item.Properties> properties) {
        return () -> new BlockNamedItem(block.get().get(), properties.get());
    }

    // public Supplier<OreBase> ore(OreBuilder<BaseOreBlock> creator, MaterialType material) {
    //     return () -> creator.apply(material.getOreBlockProperties().get(), material.getMinXP(), material.getMaxXP());
    // }

    public <T extends Item> Supplier<T> item(Function<Item.Properties, T> creator,
            Supplier<Item.Properties> properties) {
        return () -> creator.apply(properties.get());
    }
}