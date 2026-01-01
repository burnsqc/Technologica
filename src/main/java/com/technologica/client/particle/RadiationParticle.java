package com.technologica.client.particle;

import java.util.List;

import net.minecraft.client.multiplayer.ClientLevel;
import net.minecraft.client.particle.Particle;
import net.minecraft.client.particle.ParticleProvider;
import net.minecraft.client.particle.ParticleRenderType;
import net.minecraft.client.particle.SpriteSet;
import net.minecraft.client.particle.TextureSheetParticle;
import net.minecraft.core.particles.SimpleParticleType;
import net.minecraft.sounds.SoundEvents;
import net.minecraft.sounds.SoundSource;
import net.minecraft.world.entity.Entity;
import net.minecraft.world.phys.Vec3;

public class RadiationParticle extends TextureSheetParticle {
	protected boolean fullbright;
	protected boolean collidedX;
	protected boolean collidedY;
	protected boolean collidedZ;

	private RadiationParticle(ClientLevel clientLevel, double posX, double posY, double posZ) {
		super(clientLevel, posX, posY, posZ);
		this.setSize(0.01F, 0.01F);
		this.gravity = 0.0F;
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
			if (Math.abs(this.xd) >= 1.0E-5F && this.xo == this.x) {
				this.collidedX = true;
			}
			if (Math.abs(this.yd) >= 1.0E-5F && this.yo == this.y) {
				this.collidedY = true;
			}
			if (Math.abs(this.zd) >= 1.0E-5F && this.zo == this.z) {
				this.collidedZ = true;
			}
			this.updateMotion();
		}
	}

	@Override
	public void move(double posX, double posY, double posZ) {
		if (this.hasPhysics && (posX != 0.0D || posY != 0.0D || posZ != 0.0D) && posX * posX + posY * posY + posZ * posZ < 10000.0D) {
			Vec3 vec3 = Entity.collideBoundingBox((Entity) null, new Vec3(posX, posY, posZ), this.getBoundingBox(), this.level, List.of());
			posX = vec3.x;
			posY = vec3.y;
			posZ = vec3.z;
		}
		if (posX != 0.0D || posY != 0.0D || posZ != 0.0D) {
			this.setBoundingBox(this.getBoundingBox().move(posX, posY, posZ));
			this.setLocationFromBoundingbox();
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
		protected final SimpleParticleType particleData;

		private Flying(ClientLevel clientLevel, double posX, double posY, double posZ, SimpleParticleType simpleParticleType) {
			super(clientLevel, posX, posY, posZ);
			this.particleData = simpleParticleType;
		}

		@Override
		protected void updateMotion() {
			if (this.collidedX) {
				this.xd = -this.xd;
				this.level.playLocalSound(this.x + 0.5D, this.y, this.z + 0.5D, SoundEvents.UI_BUTTON_CLICK.get(), SoundSource.BLOCKS, (0.01F + this.level.random.nextFloat()) / 100.0F, 2.0F, false);
				this.collidedX = false;
			}
			if (this.collidedY) {
				this.yd = -this.yd;
				this.level.playLocalSound(this.x + 0.5D, this.y, this.z + 0.5D, SoundEvents.UI_BUTTON_CLICK.get(), SoundSource.BLOCKS, (0.01F + this.level.random.nextFloat()) / 100.0F, 2.0F, false);
				this.collidedY = false;
			}
			if (this.collidedZ) {
				this.zd = -this.zd;
				this.level.playLocalSound(this.x + 0.5D, this.y, this.z + 0.5D, SoundEvents.UI_BUTTON_CLICK.get(), SoundSource.BLOCKS, (0.01F + this.level.random.nextFloat()) / 100.0F, 2.0F, false);
				this.collidedZ = false;
			}
		}
	}

	public static class Provider implements ParticleProvider<SimpleParticleType> {
		protected final SpriteSet spriteSet;

		public Provider(SpriteSet spriteSet) {
			this.spriteSet = spriteSet;
		}

		@Override
		public Particle createParticle(SimpleParticleType simpleParticleType, ClientLevel clientLevel, double posX, double posY, double posZ, double speedX, double speedY, double speedZ) {
			RadiationParticle radiationParticle = new RadiationParticle.Flying(clientLevel, posX, posY, posZ, simpleParticleType);
			radiationParticle.xd = speedX;
			radiationParticle.yd = speedY;
			radiationParticle.zd = speedZ;
			radiationParticle.setAlpha(0.25F);
			radiationParticle.setColor(0.0F, 0.75F, 1.0F);
			radiationParticle.pickSprite(this.spriteSet);
			return radiationParticle;
		}
	}
}