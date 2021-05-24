package com.github.chrisofnormandy.conlib.effects.particles;

import javax.annotation.Nullable;

import net.minecraft.client.particle.Particle;

import net.minecraft.block.Blocks;
import net.minecraft.client.particle.IParticleFactory;
import net.minecraft.client.particle.SplashParticle;
import net.minecraft.client.world.ClientWorld;
import net.minecraft.particles.BasicParticleType;
import net.minecraft.util.text.Color;
import net.minecraft.world.World;

public class ParticleFactory implements IParticleFactory<BasicParticleType> {
    public ParticleFactory() {
    }

    @Override
    public Particle createParticle(BasicParticleType p_199234_1_, ClientWorld worldIn, double x, double y, double z,
            double xSpeed, double ySpeed, double zSpeed) {
        Particle p = new ModParticle(worldIn, x, y, z, xSpeed, ySpeed, zSpeed);
        p.setColor(0, 0, 0);
        p.scale(1);
        return p;
    }
}
