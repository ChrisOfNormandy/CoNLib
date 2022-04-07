package com.github.chrisofnormandy.conlib.effects.particles;

import com.mojang.blaze3d.vertex.VertexConsumer;

import net.minecraft.client.Camera;
import net.minecraft.client.multiplayer.ClientLevel;
import net.minecraft.client.particle.Particle;
import net.minecraft.client.particle.ParticleRenderType;

public class ModParticle extends Particle {

    protected ModParticle(ClientLevel level, double x, double y, double z) {
        super(level, x, y, z);
    }

    @Override
    public void render(VertexConsumer p_107261_, Camera p_107262_, float p_107263_) {
        // TODO Auto-generated method stub

    }

    @Override
    public ParticleRenderType getRenderType() {
        // TODO Auto-generated method stub
        return null;
    }

}
