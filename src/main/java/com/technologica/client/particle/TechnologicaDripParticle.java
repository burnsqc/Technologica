package com.technologica.client.particle;

import com.technologica.particles.DrippingLiquidParticleData;
import com.technologica.particles.FallingLiquidParticleData;
import com.technologica.particles.LandingLiquidParticleData;

import net.minecraft.client.particle.IAnimatedSprite;
import net.minecraft.client.particle.IParticleFactory;
import net.minecraft.client.particle.IParticleRenderType;
import net.minecraft.client.particle.Particle;
import net.minecraft.client.particle.SpriteTexturedParticle;
import net.minecraft.client.world.ClientWorld;
import net.minecraft.fluid.Fluid;
import net.minecraft.fluid.FluidState;
import net.minecraft.fluid.Fluids;
import net.minecraft.util.SoundCategory;
import net.minecraft.util.SoundEvents;
import net.minecraft.util.math.BlockPos;

public class TechnologicaDripParticle extends SpriteTexturedParticle {
	private final Fluid fluid;
	protected boolean fullbright;
	
	private TechnologicaDripParticle(ClientWorld world, double x, double y, double z, Fluid fluid) {
		super(world, x, y, z);
		this.setSize(0.01F, 0.01F);
		this.gravity = 0.06F;
		this.fluid = fluid;
	}

	public IParticleRenderType getRenderType() {
		return IParticleRenderType.PARTICLE_SHEET_OPAQUE;
	}

	public int getLightColor(float partialTick) {
		return this.fullbright ? 240 : super.getLightColor(partialTick);
	}

	public void tick() {
		this.xo = this.x;
		this.yo = this.y;
		this.zo = this.z;
		this.ageParticle();
		if (!this.removed) {
			this.yd -= (double) this.gravity;
			this.move(this.xd, this.yd, this.zd);
			this.updateMotion();
			if (!this.removed) {
				this.xd *= (double) 0.98F;
				this.yd *= (double) 0.98F;
				this.zd *= (double) 0.98F;
				BlockPos blockpos = new BlockPos(this.x, this.y, this.z);
				FluidState fluidstate = this.level.getFluidState(blockpos);
				if (fluidstate.getType() == fluid && this.y < (double) ((float) blockpos.getY() + fluidstate.getHeight(this.level, blockpos))) {
					this.remove();
				}

			}
		}
	}

	protected void ageParticle() {
		if (this.lifetime-- <= 0) {
			this.remove();
		}
	}

	protected void updateMotion() {
	}

	static class Dripping extends TechnologicaDripParticle {
		private final DrippingLiquidParticleData particleData;

		private Dripping(ClientWorld world, double x, double y, double z, Fluid fluid, DrippingLiquidParticleData particleData) {
			super(world, x, y, z, fluid);
			this.particleData = particleData;
			this.gravity *= 0.02F;
			this.lifetime = 40;
		}

		protected void ageParticle() {
			if (this.lifetime-- <= 0) {
				this.remove();
				this.level.addParticle(new FallingLiquidParticleData(particleData.getRed(), particleData.getGreen(), particleData.getBlue()), this.x, this.y, this.z, this.xd, this.yd, this.zd);
			}
		}

		protected void updateMotion() {
			this.xd *= 0.02D;
			this.yd *= 0.02D;
			this.zd *= 0.02D;
		}
	}

	static class Falling extends TechnologicaDripParticle {
		protected final FallingLiquidParticleData particleData;
		
		private Falling(ClientWorld world, double x, double y, double z, Fluid fluid, FallingLiquidParticleData particleData) {
			super(world, x, y, z, fluid);
			this.particleData = particleData;
		}

		protected void updateMotion() {
			if (this.onGround) {
				this.remove();
				this.level.addParticle(new LandingLiquidParticleData(particleData.getRed(), particleData.getGreen(), particleData.getBlue()), this.x, this.y, this.z, 0.0D, 0.0D, 0.0D);
	            this.level.playLocalSound(this.x + 0.5D, this.y, this.z + 0.5D, SoundEvents.BEEHIVE_DRIP, SoundCategory.BLOCKS, 0.3F + this.level.random.nextFloat() * 2.0F / 3.0F, 1.0F, false);
			}

		}
	}

	static class Landing extends TechnologicaDripParticle {
		private Landing(ClientWorld world, double x, double y, double z, Fluid fluid) {
			super(world, x, y, z, fluid);
			this.lifetime = (int) (16.0D / (Math.random() * 0.8D + 0.2D));
		}
	}
	
	public static class DrippingFactory implements IParticleFactory<DrippingLiquidParticleData> {
		protected final IAnimatedSprite spriteWithAge;
		
		public DrippingFactory(IAnimatedSprite spriteWithAge) {
			this.spriteWithAge = spriteWithAge;
		}
		
		@Override
		public Particle createParticle(DrippingLiquidParticleData typeIn, ClientWorld worldIn, double x, double y, double z, double xSpeed, double ySpeed, double zSpeed) {
			TechnologicaDripParticle.Dripping dripparticle$dripping = new TechnologicaDripParticle.Dripping(worldIn, x, y, z, Fluids.EMPTY, typeIn);
			dripparticle$dripping.gravity *= 0.01F;
			dripparticle$dripping.lifetime = 100;
			dripparticle$dripping.setColor(typeIn.getRed(), typeIn.getGreen(), typeIn.getBlue());
			dripparticle$dripping.pickSprite(this.spriteWithAge);
			return dripparticle$dripping;
		}
	}
	
	public static class FallingFactory implements IParticleFactory<FallingLiquidParticleData> {
		protected final IAnimatedSprite spriteSet;

		public FallingFactory(IAnimatedSprite spriteSet) {
			this.spriteSet = spriteSet;
		}

		public Particle createParticle(FallingLiquidParticleData typeIn, ClientWorld worldIn, double x, double y, double z, double xSpeed, double ySpeed, double zSpeed) {
			TechnologicaDripParticle dripparticle = new TechnologicaDripParticle.Falling(worldIn, x, y, z, Fluids.EMPTY, typeIn);
			dripparticle.gravity = 0.01F;
			dripparticle.setColor(typeIn.getRed(), typeIn.getGreen(), typeIn.getBlue());
			dripparticle.pickSprite(this.spriteSet);
			return dripparticle;
		}
	}
	
	public static class LandingFactory implements IParticleFactory<LandingLiquidParticleData> {
		protected final IAnimatedSprite spriteSet;

		public LandingFactory(IAnimatedSprite spriteSet) {
			this.spriteSet = spriteSet;
		}

		public Particle createParticle(LandingLiquidParticleData typeIn, ClientWorld worldIn, double x, double y, double z, double xSpeed, double ySpeed, double zSpeed) {
			TechnologicaDripParticle dripparticle = new TechnologicaDripParticle.Landing(worldIn, x, y, z, Fluids.EMPTY);
			dripparticle.lifetime = (int) (128.0D / (Math.random() * 0.8D + 0.2D));
			dripparticle.setColor(typeIn.getRed(), typeIn.getGreen(), typeIn.getBlue());
			dripparticle.pickSprite(this.spriteSet);
			return dripparticle;
		}
	}
}
