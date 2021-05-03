package com.github.chrisofnormandy.conlib.biome;

import java.util.function.Consumer;

import com.github.chrisofnormandy.conlib.biome.Biomes.RegistrationBase;

public class BiomeRegistration<T extends RegistrationBase> {
    Consumer<T> function;
    T data;

    public BiomeRegistration(Consumer<T> func, T data) {
        this.function = func;
        this.data = data;
    }

    public void register() {
        this.function.accept(this.data);
    }
}
