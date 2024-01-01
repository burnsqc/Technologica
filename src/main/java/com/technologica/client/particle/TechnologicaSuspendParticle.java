package com.technologica.client.particle;

import net.minecraft.client.multiplayer.ClientLevel;
import net.minecraft.client.particle.Particle;
import net.minecraft.client.particle.ParticleProvider;
import net.minecraft.client.particle.ParticleRenderType;
import net.minecraft.client.particle.SpriteSet;
import net.minecraft.client.particle.TextureSheetParticle;
import net.minecraft.core.particles.SimpleParticleType;

public class TechnologicaSuspendParticle extends TextureSheetParticle {
	TechnologicaSuspendParticle(ClientLevel clientLevel, SpriteSet spriteSet, double posX, double posY, double posZ) {
		super(clientLevel, posX, posY - 0.125D, posZ);
		this.setSize(0.01F, 0.01F);
		this.pickSprite(spriteSet);
		this.quadSize *= this.random.nextFloat() * 0.6F + 0.2F;
		this.lifetime = (int) (16.0D / (Math.random() * 0.8D + 0.2D));
		this.hasPhysics = false;
		this.friction = 1.0F;
		this.gravity = 0.0F;
	}

	TechnologicaSuspendParticle(ClientLevel clientLevel, SpriteSet spriteSet, double posX, double posY, double posZ, double p_172414_, double p_172415_, double p_172416_) {
		super(clientLevel, posX, posY - 0.125D, posZ, p_172414_, p_172415_, p_172416_);
		this.setSize(0.01F, 0.01F);
		this.pickSprite(spriteSet);
		this.quadSize *= this.random.nextFloat() * 0.6F + 0.6F;
		this.lifetime = (int) (16.0D / (Math.random() * 0.8D + 0.2D));
		this.hasPhysics = false;
		this.friction = 1.0F;
		this.gravity = 0.0F;
	}

	@Override
	public ParticleRenderType getRenderType() {
		return ParticleRenderType.PARTICLE_SHEET_OPAQUE;
	}

	public static class BrineProvider implements ParticleProvider<SimpleParticleType> {
		private final SpriteSet spriteSet;

		public BrineProvider(SpriteSet spriteSet) {
			this.spriteSet = spriteSet;
		}

		@Override
		public Particle createParticle(SimpleParticleType simpleParticleType, ClientLevel clientLevel, double posX, double posY, double posZ, double p_108079_, double p_108080_, double p_108081_) {
			TechnologicaSuspendParticle suspendedparticle = new TechnologicaSuspendParticle(clientLevel, this.spriteSet, posX, posY, posZ);
			suspendedparticle.setColor(0.66667F, 0.86275F, 1.00000F);
			return suspendedparticle;
		}
	}

	public static class BromineProvider implements ParticleProvider<SimpleParticleType> {
		private final SpriteSet spriteSet;

		public BromineProvider(SpriteSet spriteSet) {
			this.spriteSet = spriteSet;
		}

		@Override
		public Particle createParticle(SimpleParticleType simpleParticleType, ClientLevel clientLevel, double posX, double posY, double posZ, double p_108079_, double p_108080_, double p_108081_) {
			TechnologicaSuspendParticle suspendedparticle = new TechnologicaSuspendParticle(clientLevel, this.spriteSet, posX, posY, posZ);
			suspendedparticle.setColor(0.66667F, 0.21960F, 0.07450F);
			return suspendedparticle;
		}
	}

	public static class CoolantProvider implements ParticleProvider<SimpleParticleType> {
		private final SpriteSet spriteSet;

		public CoolantProvider(SpriteSet spriteSet) {
			this.spriteSet = spriteSet;
		}

		@Override
		public Particle createParticle(SimpleParticleType simpleParticleType, ClientLevel clientLevel, double posX, double posY, double posZ, double p_108079_, double p_108080_, double p_108081_) {
			TechnologicaSuspendParticle suspendedparticle = new TechnologicaSuspendParticle(clientLevel, this.spriteSet, posX, posY, posZ);
			suspendedparticle.setColor(0.74901F, 0.96862F, 0.32941F);
			return suspendedparticle;
		}
	}

	public static class GasolineProvider implements ParticleProvider<SimpleParticleType> {
		private final SpriteSet spriteSet;

		public GasolineProvider(SpriteSet spriteSet) {
			this.spriteSet = spriteSet;
		}

		@Override
		public Particle createParticle(SimpleParticleType simpleParticleType, ClientLevel clientLevel, double posX, double posY, double posZ, double p_108079_, double p_108080_, double p_108081_) {
			TechnologicaSuspendParticle suspendedparticle = new TechnologicaSuspendParticle(clientLevel, this.spriteSet, posX, posY, posZ);
			suspendedparticle.setColor(0.83137F, 0.76078F, 0.41176F);
			return suspendedparticle;
		}
	}

	public static class MachineOilProvider implements ParticleProvider<SimpleParticleType> {
		private final SpriteSet spriteSet;

		public MachineOilProvider(SpriteSet spriteSet) {
			this.spriteSet = spriteSet;
		}

		@Override
		public Particle createParticle(SimpleParticleType simpleParticleType, ClientLevel clientLevel, double posX, double posY, double posZ, double p_108079_, double p_108080_, double p_108081_) {
			TechnologicaSuspendParticle suspendedparticle = new TechnologicaSuspendParticle(clientLevel, this.spriteSet, posX, posY, posZ);
			suspendedparticle.setColor(1.00000F, 1.00000F, 0.58823F);
			return suspendedparticle;
		}
	}

	public static class MapleSyrupProvider implements ParticleProvider<SimpleParticleType> {
		private final SpriteSet spriteSet;

		public MapleSyrupProvider(SpriteSet spriteSet) {
			this.spriteSet = spriteSet;
		}

		@Override
		public Particle createParticle(SimpleParticleType simpleParticleType, ClientLevel clientLevel, double posX, double posY, double posZ, double p_108079_, double p_108080_, double p_108081_) {
			TechnologicaSuspendParticle suspendedparticle = new TechnologicaSuspendParticle(clientLevel, this.spriteSet, posX, posY, posZ);
			suspendedparticle.setColor(0.35294F, 0.16863F, 0.09412F);
			return suspendedparticle;
		}
	}

	public static class MercuryProvider implements ParticleProvider<SimpleParticleType> {
		private final SpriteSet spriteSet;

		public MercuryProvider(SpriteSet spriteSet) {
			this.spriteSet = spriteSet;
		}

		@Override
		public Particle createParticle(SimpleParticleType simpleParticleType, ClientLevel clientLevel, double posX, double posY, double posZ, double p_108079_, double p_108080_, double p_108081_) {
			TechnologicaSuspendParticle suspendedparticle = new TechnologicaSuspendParticle(clientLevel, this.spriteSet, posX, posY, posZ);
			suspendedparticle.setColor(0.88235F, 0.88235F, 0.88235F);
			return suspendedparticle;
		}
	}

	public static class OilProvider implements ParticleProvider<SimpleParticleType> {
		private final SpriteSet spriteSet;

		public OilProvider(SpriteSet spriteSet) {
			this.spriteSet = spriteSet;
		}

		@Override
		public Particle createParticle(SimpleParticleType simpleParticleType, ClientLevel clientLevel, double posX, double posY, double posZ, double p_108079_, double p_108080_, double p_108081_) {
			TechnologicaSuspendParticle suspendedparticle = new TechnologicaSuspendParticle(clientLevel, this.spriteSet, posX, posY, posZ);
			suspendedparticle.setColor(0.19607F, 0.19607F, 0.19607F);
			return suspendedparticle;
		}
	}

	public static class RubberResinProvider implements ParticleProvider<SimpleParticleType> {
		private final SpriteSet spriteSet;

		public RubberResinProvider(SpriteSet spriteSet) {
			this.spriteSet = spriteSet;
		}

		@Override
		public Particle createParticle(SimpleParticleType simpleParticleType, ClientLevel clientLevel, double posX, double posY, double posZ, double p_108079_, double p_108080_, double p_108081_) {
			TechnologicaSuspendParticle suspendedparticle = new TechnologicaSuspendParticle(clientLevel, this.spriteSet, posX, posY, posZ);
			suspendedparticle.setColor(0.94118F, 0.94118F, 0.81569F);
			return suspendedparticle;
		}
	}
}