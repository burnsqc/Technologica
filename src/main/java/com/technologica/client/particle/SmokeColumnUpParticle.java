package com.technologica.client.particle;

import com.technologica.world.level.block.SmokeColumnBlock;

import net.minecraft.client.multiplayer.ClientLevel;
import net.minecraft.client.particle.LargeSmokeParticle;
import net.minecraft.client.particle.Particle;
import net.minecraft.client.particle.ParticleProvider;
import net.minecraft.client.particle.SpriteSet;
import net.minecraft.core.BlockPos;
import net.minecraft.core.particles.SimpleParticleType;
import net.minecraft.tags.FluidTags;

/**
 * This class is effectively a clone of {@link LargeSmokeParticle} with the following changes:
 * <ul>
 * Increased value of {@link Particle#lifetime} so that particles will not fade away as quickly.
 * <p>
 * Decreased value of {@link Particle#gravity} so that particles will rise more quickly.
 * <p>
 * Added logic to {@link SmokeColumnUpParticle#tick} to remove particles if they leave water.
 * </ul>
 * This class was created to spawn particles for {@link SmokeColumnBlock}.
 * 
 * @tl.status BLUE
 */
public class SmokeColumnUpParticle extends LargeSmokeParticle {

	SmokeColumnUpParticle(ClientLevel clientLevel, double positionX, double positionY, double positionZ, double velocityX, double velocityY, double velocityZ, SpriteSet spriteSet) {
		super(clientLevel, positionX, positionY, positionZ, velocityX, velocityY, velocityZ, spriteSet);
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
		public Particle createParticle(SimpleParticleType simpleParticleType, ClientLevel clientLevel, double positionX, double positionY, double positionZ, double velocityX, double velocityY, double velocityZ) {
			return new SmokeColumnUpParticle(clientLevel, positionX, positionY, positionZ, velocityX, velocityY, velocityZ, this.spriteSet);
		}
	}
}
