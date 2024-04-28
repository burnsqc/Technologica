package com.technologica.resourcegen.assets;

import com.technologica.api.tlregen.resourcegen.assets.TLReGenParticles;
import com.technologica.registration.deferred.TechnologicaParticleTypes;
import com.technologica.util.text.TechnologicaLocation;

import net.minecraft.resources.ResourceLocation;

public class TLParticles extends TLReGenParticles {
	@Override
	protected void populate() {
		sprite(TechnologicaParticleTypes.DRIPPING_BRINE, new ResourceLocation("drip_hang"));
		sprite(TechnologicaParticleTypes.FALLING_BRINE, new ResourceLocation("drip_fall"));
		spriteSet(TechnologicaParticleTypes.SPLASHING_BRINE, new TechnologicaLocation("splash"), 4, false);
		sprite(TechnologicaParticleTypes.SUBMERGED_BRINE, new ResourceLocation("generic_0"));
		sprite(TechnologicaParticleTypes.DRIPPING_BROMINE, new ResourceLocation("drip_hang"));
		sprite(TechnologicaParticleTypes.FALLING_BROMINE, new ResourceLocation("drip_fall"));
		spriteSet(TechnologicaParticleTypes.SPLASHING_BROMINE, new TechnologicaLocation("splash"), 4, false);
		sprite(TechnologicaParticleTypes.SUBMERGED_BROMINE, new ResourceLocation("generic_0"));
		sprite(TechnologicaParticleTypes.DRIPPING_COOLANT, new ResourceLocation("drip_hang"));
		sprite(TechnologicaParticleTypes.FALLING_COOLANT, new ResourceLocation("drip_fall"));
		spriteSet(TechnologicaParticleTypes.SPLASHING_COOLANT, new TechnologicaLocation("splash"), 4, false);
		sprite(TechnologicaParticleTypes.SUBMERGED_COOLANT, new ResourceLocation("generic_0"));
		sprite(TechnologicaParticleTypes.DRIPPING_GASOLINE, new ResourceLocation("drip_hang"));
		sprite(TechnologicaParticleTypes.FALLING_GASOLINE, new ResourceLocation("drip_fall"));
		spriteSet(TechnologicaParticleTypes.SPLASHING_GASOLINE, new TechnologicaLocation("splash"), 4, false);
		sprite(TechnologicaParticleTypes.SUBMERGED_GASOLINE, new ResourceLocation("generic_0"));
		sprite(TechnologicaParticleTypes.DRIPPING_MACHINE_OIL, new ResourceLocation("drip_hang"));
		sprite(TechnologicaParticleTypes.FALLING_MACHINE_OIL, new ResourceLocation("drip_fall"));
		spriteSet(TechnologicaParticleTypes.SPLASHING_MACHINE_OIL, new TechnologicaLocation("splash"), 4, false);
		sprite(TechnologicaParticleTypes.SUBMERGED_MACHINE_OIL, new ResourceLocation("generic_0"));
		sprite(TechnologicaParticleTypes.DRIPPING_MAPLE_SYRUP, new ResourceLocation("drip_hang"));
		sprite(TechnologicaParticleTypes.FALLING_MAPLE_SYRUP, new ResourceLocation("drip_fall"));
		sprite(TechnologicaParticleTypes.STICKING_MAPLE_SYRUP, new ResourceLocation("drip_land"));
		sprite(TechnologicaParticleTypes.SUBMERGED_MAPLE_SYRUP, new ResourceLocation("generic_0"));
		sprite(TechnologicaParticleTypes.DRIPPING_MERCURY, new ResourceLocation("drip_hang"));
		sprite(TechnologicaParticleTypes.FALLING_MERCURY, new ResourceLocation("drip_fall"));
		spriteSet(TechnologicaParticleTypes.SPLASHING_MERCURY, new TechnologicaLocation("splash"), 4, false);
		sprite(TechnologicaParticleTypes.SUBMERGED_MERCURY, new ResourceLocation("generic_0"));
		sprite(TechnologicaParticleTypes.DRIPPING_OIL, new ResourceLocation("drip_hang"));
		sprite(TechnologicaParticleTypes.FALLING_OIL, new ResourceLocation("drip_fall"));
		sprite(TechnologicaParticleTypes.STICKING_OIL, new ResourceLocation("drip_land"));
		sprite(TechnologicaParticleTypes.SUBMERGED_OIL, new ResourceLocation("generic_0"));
		sprite(TechnologicaParticleTypes.DRIPPING_RUBBER_RESIN, new ResourceLocation("drip_hang"));
		sprite(TechnologicaParticleTypes.FALLING_RUBBER_RESIN, new ResourceLocation("drip_fall"));
		sprite(TechnologicaParticleTypes.STICKING_RUBBER_RESIN, new ResourceLocation("drip_land"));
		sprite(TechnologicaParticleTypes.SUBMERGED_RUBBER_RESIN, new ResourceLocation("generic_0"));
		sprite(TechnologicaParticleTypes.FLYING_RADIATION, new ResourceLocation("drip_fall"));
		sprite(TechnologicaParticleTypes.FLYING_SONAR, new ResourceLocation("drip_fall"));
	}
}
