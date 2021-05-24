package com.github.chrisofnormandy.conlib.effects.particles;

import com.mojang.blaze3d.vertex.IVertexBuilder;

import net.minecraft.client.particle.IParticleRenderType;
import net.minecraft.client.particle.Particle;
import net.minecraft.client.renderer.ActiveRenderInfo;
import net.minecraft.client.world.ClientWorld;

public class ModParticle extends Particle {

    public ModParticle(ClientWorld worldIn, double x, double y, double z) {
        super(worldIn, x, y, z);
     }
  
     public ModParticle(ClientWorld worldIn, double x, double y, double z, double xSpeed, double ySpeed, double zSpeed) {
        super(worldIn, x, y, z, xSpeed, ySpeed, zSpeed);
     }

    @Override
    public void render(IVertexBuilder p_225606_1_, ActiveRenderInfo p_225606_2_, float p_225606_3_) {
        // TODO Auto-generated method stub
        
    }

    @Override
    public IParticleRenderType getRenderType() {
        // TODO Auto-generated method stub
        return null;
    }
    
}
