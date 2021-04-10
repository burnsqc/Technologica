package com.technologica.particles;

import com.technologica.setup.Registration;

import net.minecraft.client.Minecraft;
import net.minecraft.client.particle.IParticleFactory;
import net.minecraft.client.particle.IParticleRenderType;
import net.minecraft.client.particle.Particle;
import net.minecraft.client.particle.SpriteTexturedParticle;
import net.minecraft.client.world.ClientWorld;
import net.minecraft.particles.BasicParticleType;
import net.minecraftforge.api.distmarker.Dist;
import net.minecraftforge.api.distmarker.OnlyIn;

@OnlyIn(Dist.CLIENT)
public class OrangeParticle extends SpriteTexturedParticle {
	protected OrangeParticle(ClientWorld worldIn, double xCoordIn, double yCoordIn, double zCoordIn) {
		super(worldIn, xCoordIn, yCoordIn, zCoordIn);
		this.setSprite(Minecraft.getInstance().getItemRenderer().getItemModelMesher().getParticleIcon(Registration.ORANGE.get()));
		this.particleGravity = 0.0F;
		this.maxAge = 80;
	}

	@Override
	public IParticleRenderType getRenderType() {
		return IParticleRenderType.TERRAIN_SHEET;
	}
	
	public float getScale(float scaleFactor) {
	      return 0.3F;
	   }

	@OnlyIn(Dist.CLIENT)
	public static class Factory implements IParticleFactory<BasicParticleType> {
		public Particle makeParticle(BasicParticleType typeIn, ClientWorld worldIn, double x, double y, double z, double xSpeed, double ySpeed, double zSpeed) {
			return new OrangeParticle(worldIn, x, y, z);
		}
	}
}