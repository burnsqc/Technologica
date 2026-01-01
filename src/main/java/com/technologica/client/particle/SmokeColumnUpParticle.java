package com.technologica.client.particle;

import net.minecraft.client.multiplayer.ClientLevel;
import net.minecraft.client.particle.LargeSmokeParticle;
import net.minecraft.client.particle.Particle;
import net.minecraft.client.particle.ParticleProvider;
import net.minecraft.client.particle.SpriteSet;
import net.minecraft.core.BlockPos;
import net.minecraft.core.particles.SimpleParticleType;
import net.minecraft.tags.FluidTags;

public class SmokeColumnUpParticle extends LargeSmokeParticle {

	SmokeColumnUpParticle(ClientLevel clientLevel, double posX, double posY, double posZ, double speedX, double speedY, double speedZ, SpriteSet spriteSet) {
		super(clientLevel, posX, posY, posZ, speedX, speedY, speedZ, spriteSet);
		this.gravity = -0.3F;
		this.lifetime = (int) (20.0F / (clientLevel.random.nextFloat() * 0.8F + 0.2F));
	}

	@Override
	public void tick() {
		super.tick();
		if (!this.removed && !this.level.getFluidState(BlockPos.containing(this.x, this.y, this.z)).is(FluidTags.WATER)) {
			this.remove();
		}
	}

	public static class Provider implements ParticleProvider<SimpleParticleType> {
		private final SpriteSet spriteSet;

		public Provider(SpriteSet spriteSet) {
			this.spriteSet = spriteSet;
		}

		@Override
		public Particle createParticle(SimpleParticleType simpleParticleType, ClientLevel clientLevel, double positionX, double positionY, double positionZ, double speedX, double speedY, double speedZ) {
			return new SmokeColumnUpParticle(clientLevel, positionX, positionY, positionZ, speedX, speedY, speedZ, this.spriteSet);
		}
	}
}
