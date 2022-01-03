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
		this.particleGravity = 0.06F;
		this.fluid = fluid;
	}

	public IParticleRenderType getRenderType() {
		return IParticleRenderType.PARTICLE_SHEET_OPAQUE;
	}

	public int getBrightnessForRender(float partialTick) {
		return this.fullbright ? 240 : super.getBrightnessForRender(partialTick);
	}

	public void tick() {
		this.prevPosX = this.posX;
		this.prevPosY = this.posY;
		this.prevPosZ = this.posZ;
		this.ageParticle();
		if (!this.isExpired) {
			this.motionY -= (double) this.particleGravity;
			this.move(this.motionX, this.motionY, this.motionZ);
			this.updateMotion();
			if (!this.isExpired) {
				this.motionX *= (double) 0.98F;
				this.motionY *= (double) 0.98F;
				this.motionZ *= (double) 0.98F;
				BlockPos blockpos = new BlockPos(this.posX, this.posY, this.posZ);
				FluidState fluidstate = this.world.getFluidState(blockpos);
				if (fluidstate.getFluid() == fluid && this.posY < (double) ((float) blockpos.getY() + fluidstate.getActualHeight(this.world, blockpos))) {
					this.setExpired();
				}

			}
		}
	}

	protected void ageParticle() {
		if (this.maxAge-- <= 0) {
			this.setExpired();
		}
	}

	protected void updateMotion() {
	}

	static class Dripping extends TechnologicaDripParticle {
		private final DrippingLiquidParticleData particleData;

		private Dripping(ClientWorld world, double x, double y, double z, Fluid fluid, DrippingLiquidParticleData particleData) {
			super(world, x, y, z, fluid);
			this.particleData = particleData;
			this.particleGravity *= 0.02F;
			this.maxAge = 40;
		}

		protected void ageParticle() {
			if (this.maxAge-- <= 0) {
				this.setExpired();
				this.world.addParticle(new FallingLiquidParticleData(particleData.getRed(), particleData.getGreen(), particleData.getBlue()), this.posX, this.posY, this.posZ, this.motionX, this.motionY, this.motionZ);
			}
		}

		protected void updateMotion() {
			this.motionX *= 0.02D;
			this.motionY *= 0.02D;
			this.motionZ *= 0.02D;
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
				this.setExpired();
				this.world.addParticle(new LandingLiquidParticleData(particleData.getRed(), particleData.getGreen(), particleData.getBlue()), this.posX, this.posY, this.posZ, 0.0D, 0.0D, 0.0D);
	            this.world.playSound(this.posX + 0.5D, this.posY, this.posZ + 0.5D, SoundEvents.BLOCK_BEEHIVE_DROP, SoundCategory.BLOCKS, 0.3F + this.world.rand.nextFloat() * 2.0F / 3.0F, 1.0F, false);
			}

		}
	}

	static class Landing extends TechnologicaDripParticle {
		private Landing(ClientWorld world, double x, double y, double z, Fluid fluid) {
			super(world, x, y, z, fluid);
			this.maxAge = (int) (16.0D / (Math.random() * 0.8D + 0.2D));
		}
	}
	
	public static class DrippingFactory implements IParticleFactory<DrippingLiquidParticleData> {
		protected final IAnimatedSprite spriteWithAge;
		
		public DrippingFactory(IAnimatedSprite spriteWithAge) {
			this.spriteWithAge = spriteWithAge;
		}
		
		@Override
		public Particle makeParticle(DrippingLiquidParticleData typeIn, ClientWorld worldIn, double x, double y, double z, double xSpeed, double ySpeed, double zSpeed) {
			TechnologicaDripParticle.Dripping dripparticle$dripping = new TechnologicaDripParticle.Dripping(worldIn, x, y, z, Fluids.EMPTY, typeIn);
			dripparticle$dripping.particleGravity *= 0.01F;
			dripparticle$dripping.maxAge = 100;
			dripparticle$dripping.setColor(typeIn.getRed(), typeIn.getGreen(), typeIn.getBlue());
			dripparticle$dripping.selectSpriteRandomly(this.spriteWithAge);
			return dripparticle$dripping;
		}
	}
	
	public static class FallingFactory implements IParticleFactory<FallingLiquidParticleData> {
		protected final IAnimatedSprite spriteSet;

		public FallingFactory(IAnimatedSprite spriteSet) {
			this.spriteSet = spriteSet;
		}

		public Particle makeParticle(FallingLiquidParticleData typeIn, ClientWorld worldIn, double x, double y, double z, double xSpeed, double ySpeed, double zSpeed) {
			TechnologicaDripParticle dripparticle = new TechnologicaDripParticle.Falling(worldIn, x, y, z, Fluids.EMPTY, typeIn);
			dripparticle.particleGravity = 0.01F;
			dripparticle.setColor(typeIn.getRed(), typeIn.getGreen(), typeIn.getBlue());
			dripparticle.selectSpriteRandomly(this.spriteSet);
			return dripparticle;
		}
	}
	
	public static class LandingFactory implements IParticleFactory<LandingLiquidParticleData> {
		protected final IAnimatedSprite spriteSet;

		public LandingFactory(IAnimatedSprite spriteSet) {
			this.spriteSet = spriteSet;
		}

		public Particle makeParticle(LandingLiquidParticleData typeIn, ClientWorld worldIn, double x, double y, double z, double xSpeed, double ySpeed, double zSpeed) {
			TechnologicaDripParticle dripparticle = new TechnologicaDripParticle.Landing(worldIn, x, y, z, Fluids.EMPTY);
			dripparticle.maxAge = (int) (128.0D / (Math.random() * 0.8D + 0.2D));
			dripparticle.setColor(typeIn.getRed(), typeIn.getGreen(), typeIn.getBlue());
			dripparticle.selectSpriteRandomly(this.spriteSet);
			return dripparticle;
		}
	}
}
