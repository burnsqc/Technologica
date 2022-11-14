package com.technologica.client.particle;

import java.util.List;

import com.technologica.core.particles.FlyingRadiationParticleData;

import net.minecraft.client.multiplayer.ClientLevel;
import net.minecraft.client.particle.Particle;
import net.minecraft.client.particle.ParticleProvider;
import net.minecraft.client.particle.ParticleRenderType;
import net.minecraft.client.particle.SpriteSet;
import net.minecraft.client.particle.TextureSheetParticle;
import net.minecraft.core.BlockPos;
import net.minecraft.sounds.SoundEvents;
import net.minecraft.sounds.SoundSource;
import net.minecraft.world.entity.Entity;
import net.minecraft.world.level.material.Fluid;
import net.minecraft.world.level.material.FluidState;
import net.minecraft.world.level.material.Fluids;
import net.minecraft.world.phys.Vec3;

public class RadiationParticle extends TextureSheetParticle {
	private final Fluid fluid;
	protected boolean fullbright;
	protected boolean collided;

	private RadiationParticle(ClientLevel world, double x, double y, double z, Fluid fluid) {
		super(world, x, y, z);
		this.setSize(0.01F, 0.01F);
		this.gravity = 0.0F;
		this.fluid = fluid;
	}

	@Override
	public ParticleRenderType getRenderType() {
		return ParticleRenderType.PARTICLE_SHEET_TRANSLUCENT;
	}

	@Override
	public int getLightColor(float partialTick) {
		return this.fullbright ? 240 : super.getLightColor(partialTick);
	}

	@Override
	public void tick() {
		this.xo = this.x;
		this.yo = this.y;
		this.zo = this.z;
		this.ageParticle();
		if (!this.removed) {
			this.move(this.xd, this.yd, this.zd);

			if ((Math.abs(this.xd) >= 1.0E-5F && this.xo == this.x) || (Math.abs(this.yd) >= 1.0E-5F && this.yo == this.y) || (Math.abs(this.zd) >= 1.0E-5F && this.zo == this.z)) {
				this.collided = true;
			}
			this.updateMotion();
			if (!this.removed) {
				this.xd *= 0.98F;
				this.yd *= 0.98F;
				this.zd *= 0.98F;
				BlockPos blockpos = new BlockPos(this.x, this.y, this.z);
				FluidState fluidstate = this.level.getFluidState(blockpos);
				if (fluidstate.getType() == fluid && this.y < blockpos.getY() + fluidstate.getHeight(this.level, blockpos)) {
					this.remove();
				}

			}
		}
	}

	@Override
	public void move(double p_107246_, double p_107247_, double p_107248_) {
		if (!this.collided) {
			if (this.hasPhysics && (p_107246_ != 0.0D || p_107247_ != 0.0D || p_107248_ != 0.0D) && p_107246_ * p_107246_ + p_107247_ * p_107247_ + p_107248_ * p_107248_ < 10000.0D) {
				Vec3 vec3 = Entity.collideBoundingBox((Entity) null, new Vec3(p_107246_, p_107247_, p_107248_), this.getBoundingBox(), this.level, List.of());
				p_107246_ = vec3.x;
				p_107247_ = vec3.y;
				p_107248_ = vec3.z;
			}

			if (p_107246_ != 0.0D || p_107247_ != 0.0D || p_107248_ != 0.0D) {
				this.setBoundingBox(this.getBoundingBox().move(p_107246_, p_107247_, p_107248_));
				this.setLocationFromBoundingbox();
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

	static class Flying extends RadiationParticle {
		protected final FlyingRadiationParticleData particleData;

		private Flying(ClientLevel world, double x, double y, double z, Fluid fluid, FlyingRadiationParticleData particleData) {
			super(world, x, y, z, fluid);
			this.particleData = particleData;
		}

		@Override
		protected void updateMotion() {
			if (this.collided) {
				this.remove();
				// this.level.addParticle(FlyingRadiationParticleData.RADIATION, this.x, this.y, this.z, -this.xd, -this.yd, -this.zd);
				this.level.playLocalSound(this.x + 0.5D, this.y, this.z + 0.5D, SoundEvents.UI_BUTTON_CLICK, SoundSource.BLOCKS, (0.01F + this.level.random.nextFloat()) / 100.0F, 2.0F, false);
			}
		}
	}

	public static class FlyingFactory implements ParticleProvider<FlyingRadiationParticleData> {
		protected final SpriteSet spriteSet;

		public FlyingFactory(SpriteSet spriteSet) {
			this.spriteSet = spriteSet;
		}

		@Override
		public Particle createParticle(FlyingRadiationParticleData typeIn, ClientLevel worldIn, double x, double y, double z, double xSpeed, double ySpeed, double zSpeed) {
			RadiationParticle dripparticle = new RadiationParticle.Flying(worldIn, x, y, z, Fluids.EMPTY, typeIn);
			dripparticle.gravity = 0.00F;
			dripparticle.xd = xSpeed;
			dripparticle.yd = ySpeed;
			dripparticle.zd = zSpeed;
			dripparticle.setAlpha(0.25F);
			dripparticle.setColor(typeIn.getRed(), typeIn.getGreen(), typeIn.getBlue());
			dripparticle.pickSprite(this.spriteSet);
			return dripparticle;
		}
	}
}
