package com.technologica.client.particle;

import net.minecraft.client.multiplayer.ClientLevel;
import net.minecraft.client.particle.Particle;
import net.minecraft.client.particle.ParticleProvider;
import net.minecraft.client.particle.SpriteSet;
import net.minecraft.client.particle.WaterDropParticle;
import net.minecraft.core.particles.SimpleParticleType;

public class TechnologicaSplashParticle extends WaterDropParticle {
	public TechnologicaSplashParticle(ClientLevel clientLevel, double posX, double posY, double posZ, double p_107933_, double p_107934_, double p_107935_) {
		super(clientLevel, posX, posY, posZ);
		this.gravity = 0.04F;
		if (p_107934_ == 0.0D && (p_107933_ != 0.0D || p_107935_ != 0.0D)) {
			this.xd = p_107933_;
			this.yd = 0.1D;
			this.zd = p_107935_;
		}
	}

	public static class BrineProvider implements ParticleProvider<SimpleParticleType> {
		private final SpriteSet spriteSet;

		public BrineProvider(SpriteSet spriteSet) {
			this.spriteSet = spriteSet;
		}

		@Override
		public Particle createParticle(SimpleParticleType simpleParticleType, ClientLevel clientLevel, double posX, double posY, double posZ, double p_107963_, double p_107964_, double p_107965_) {
			TechnologicaSplashParticle splashparticle = new TechnologicaSplashParticle(clientLevel, posX, posY, posZ, p_107963_, p_107964_, p_107965_);
			splashparticle.pickSprite(this.spriteSet);
			splashparticle.setColor(0.66667F, 0.86275F, 1.00000F);
			return splashparticle;
		}
	}
	
	public static class BromineProvider implements ParticleProvider<SimpleParticleType> {
		private final SpriteSet spriteSet;

		public BromineProvider(SpriteSet spriteSet) {
			this.spriteSet = spriteSet;
		}

		@Override
		public Particle createParticle(SimpleParticleType simpleParticleType, ClientLevel clientLevel, double posX, double posY, double posZ, double p_107963_, double p_107964_, double p_107965_) {
			TechnologicaSplashParticle splashparticle = new TechnologicaSplashParticle(clientLevel, posX, posY, posZ, p_107963_, p_107964_, p_107965_);
			splashparticle.pickSprite(this.spriteSet);
			splashparticle.setColor(0.66667F, 0.21960F, 0.07450F);
			return splashparticle;
		}
	}

	public static class CoolantProvider implements ParticleProvider<SimpleParticleType> {
		private final SpriteSet spriteSet;

		public CoolantProvider(SpriteSet spriteSet) {
			this.spriteSet = spriteSet;
		}

		@Override
		public Particle createParticle(SimpleParticleType simpleParticleType, ClientLevel clientLevel, double posX, double posY, double posZ, double p_107963_, double p_107964_, double p_107965_) {
			TechnologicaSplashParticle splashparticle = new TechnologicaSplashParticle(clientLevel, posX, posY, posZ, p_107963_, p_107964_, p_107965_);
			splashparticle.pickSprite(this.spriteSet);
			splashparticle.setColor(0.74901F, 0.96862F, 0.32941F);
			return splashparticle;
		}
	}
	
	public static class GasolineProvider implements ParticleProvider<SimpleParticleType> {
		private final SpriteSet spriteSet;

		public GasolineProvider(SpriteSet spriteSet) {
			this.spriteSet = spriteSet;
		}

		@Override
		public Particle createParticle(SimpleParticleType simpleParticleType, ClientLevel clientLevel, double posX, double posY, double posZ, double p_107963_, double p_107964_, double p_107965_) {
			TechnologicaSplashParticle splashparticle = new TechnologicaSplashParticle(clientLevel, posX, posY, posZ, p_107963_, p_107964_, p_107965_);
			splashparticle.pickSprite(this.spriteSet);
			splashparticle.setColor(0.83137F, 0.76078F, 0.41176F);
			return splashparticle;
		}
	}

	public static class MachineOilProvider implements ParticleProvider<SimpleParticleType> {
		private final SpriteSet spriteSet;

		public MachineOilProvider(SpriteSet spriteSet) {
			this.spriteSet = spriteSet;
		}

		@Override
		public Particle createParticle(SimpleParticleType simpleParticleType, ClientLevel clientLevel, double posX, double posY, double posZ, double p_107963_, double p_107964_, double p_107965_) {
			TechnologicaSplashParticle splashparticle = new TechnologicaSplashParticle(clientLevel, posX, posY, posZ, p_107963_, p_107964_, p_107965_);
			splashparticle.pickSprite(this.spriteSet);
			splashparticle.setColor(1.00000F, 1.00000F, 0.58823F);
			return splashparticle;
		}
	}
	
	public static class MercuryProvider implements ParticleProvider<SimpleParticleType> {
		private final SpriteSet spriteSet;

		public MercuryProvider(SpriteSet spriteSet) {
			this.spriteSet = spriteSet;
		}

		@Override
		public Particle createParticle(SimpleParticleType simpleParticleType, ClientLevel clientLevel, double posX, double posY, double posZ, double p_107963_, double p_107964_, double p_107965_) {
			TechnologicaSplashParticle splashparticle = new TechnologicaSplashParticle(clientLevel, posX, posY, posZ, p_107963_, p_107964_, p_107965_);
			splashparticle.pickSprite(this.spriteSet);
			splashparticle.setColor(0.88235F, 0.88235F, 0.88235F);
			return splashparticle;
		}
	}
}