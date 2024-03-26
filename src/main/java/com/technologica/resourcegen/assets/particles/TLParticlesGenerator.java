package com.technologica.resourcegen.assets.particles;

import com.technologica.api.tlrg.resourcegen.TLRGParticleGenerator;
import com.technologica.registration.deferred.TechnologicaParticleTypes;
import com.technologica.util.text.TechnologicaLocation;

import net.minecraft.resources.ResourceLocation;

public class TLParticlesGenerator extends TLRGParticleGenerator {
	@Override
	protected void addDescriptions() {
		sprite(TechnologicaParticleTypes.DRIPPING_BRINE.get(), new ResourceLocation("drip_hang"));
		sprite(TechnologicaParticleTypes.FALLING_BRINE.get(), new ResourceLocation("drip_fall"));
		spriteSet(TechnologicaParticleTypes.SPLASHING_BRINE.get(), new TechnologicaLocation("splash"), 4, false);
		sprite(TechnologicaParticleTypes.SUBMERGED_BRINE.get(), new ResourceLocation("generic_0"));
		sprite(TechnologicaParticleTypes.DRIPPING_BROMINE.get(), new ResourceLocation("drip_hang"));
		sprite(TechnologicaParticleTypes.FALLING_BROMINE.get(), new ResourceLocation("drip_fall"));
		spriteSet(TechnologicaParticleTypes.SPLASHING_BROMINE.get(), new TechnologicaLocation("splash"), 4, false);
		sprite(TechnologicaParticleTypes.SUBMERGED_BROMINE.get(), new ResourceLocation("generic_0"));
		sprite(TechnologicaParticleTypes.DRIPPING_COOLANT.get(), new ResourceLocation("drip_hang"));
		sprite(TechnologicaParticleTypes.FALLING_COOLANT.get(), new ResourceLocation("drip_fall"));
		spriteSet(TechnologicaParticleTypes.SPLASHING_COOLANT.get(), new TechnologicaLocation("splash"), 4, false);
		sprite(TechnologicaParticleTypes.SUBMERGED_COOLANT.get(), new ResourceLocation("generic_0"));
		sprite(TechnologicaParticleTypes.DRIPPING_GASOLINE.get(), new ResourceLocation("drip_hang"));
		sprite(TechnologicaParticleTypes.FALLING_GASOLINE.get(), new ResourceLocation("drip_fall"));
		spriteSet(TechnologicaParticleTypes.SPLASHING_GASOLINE.get(), new TechnologicaLocation("splash"), 4, false);
		sprite(TechnologicaParticleTypes.SUBMERGED_GASOLINE.get(), new ResourceLocation("generic_0"));
		sprite(TechnologicaParticleTypes.DRIPPING_MACHINE_OIL.get(), new ResourceLocation("drip_hang"));
		sprite(TechnologicaParticleTypes.FALLING_MACHINE_OIL.get(), new ResourceLocation("drip_fall"));
		spriteSet(TechnologicaParticleTypes.SPLASHING_MACHINE_OIL.get(), new TechnologicaLocation("splash"), 4, false);
		sprite(TechnologicaParticleTypes.SUBMERGED_MACHINE_OIL.get(), new ResourceLocation("generic_0"));
		sprite(TechnologicaParticleTypes.DRIPPING_MAPLE_SYRUP.get(), new ResourceLocation("drip_hang"));
		sprite(TechnologicaParticleTypes.FALLING_MAPLE_SYRUP.get(), new ResourceLocation("drip_fall"));
		sprite(TechnologicaParticleTypes.STICKING_MAPLE_SYRUP.get(), new ResourceLocation("drip_land"));
		sprite(TechnologicaParticleTypes.SUBMERGED_MAPLE_SYRUP.get(), new ResourceLocation("generic_0"));
		sprite(TechnologicaParticleTypes.DRIPPING_MERCURY.get(), new ResourceLocation("drip_hang"));
		sprite(TechnologicaParticleTypes.FALLING_MERCURY.get(), new ResourceLocation("drip_fall"));
		spriteSet(TechnologicaParticleTypes.SPLASHING_MERCURY.get(), new TechnologicaLocation("splash"), 4, false);
		sprite(TechnologicaParticleTypes.SUBMERGED_MERCURY.get(), new ResourceLocation("generic_0"));
		sprite(TechnologicaParticleTypes.DRIPPING_OIL.get(), new ResourceLocation("drip_hang"));
		sprite(TechnologicaParticleTypes.FALLING_OIL.get(), new ResourceLocation("drip_fall"));
		sprite(TechnologicaParticleTypes.STICKING_OIL.get(), new ResourceLocation("drip_land"));
		sprite(TechnologicaParticleTypes.SUBMERGED_OIL.get(), new ResourceLocation("generic_0"));
		sprite(TechnologicaParticleTypes.DRIPPING_RUBBER_RESIN.get(), new ResourceLocation("drip_hang"));
		sprite(TechnologicaParticleTypes.FALLING_RUBBER_RESIN.get(), new ResourceLocation("drip_fall"));
		sprite(TechnologicaParticleTypes.STICKING_RUBBER_RESIN.get(), new ResourceLocation("drip_land"));
		sprite(TechnologicaParticleTypes.SUBMERGED_RUBBER_RESIN.get(), new ResourceLocation("generic_0"));
		sprite(TechnologicaParticleTypes.FLYING_RADIATION.get(), new ResourceLocation("drip_fall"));
	}
}
