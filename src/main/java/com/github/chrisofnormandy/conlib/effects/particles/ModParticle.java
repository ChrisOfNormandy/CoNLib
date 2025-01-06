package com.github.chrisofnormandy.conlib.effects.particles;

import net.minecraft.core.particles.SimpleParticleType;

public class ModParticle extends SimpleParticleType {
    public ModParticle() {
        super(false);
    }

    public ModParticle(boolean overrideLimiter) {
        super(overrideLimiter);
    }
}
