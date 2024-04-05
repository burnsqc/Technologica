package com.technologica.resourcegen.data.damagetype;

import com.technologica.api.tlregen.resourcegen.data.TLReGenDamageType;
import com.technologica.registration.key.TechnologicaDamageTypes;

import net.minecraft.data.worldgen.BootstapContext;
import net.minecraft.world.damagesource.DamageScaling;
import net.minecraft.world.damagesource.DamageType;

public final class TLDamageTypeGenerator extends TLReGenDamageType {
	public static void bootstrap(BootstapContext<DamageType> damageType) {
		damageType.register(TechnologicaDamageTypes.BLEED, new DamageType("bled_out", 0.1F));
		damageType.register(TechnologicaDamageTypes.NITRO_BLAST, new DamageType("jostled_the_nitro", DamageScaling.ALWAYS, 0.1F));
	}
}
