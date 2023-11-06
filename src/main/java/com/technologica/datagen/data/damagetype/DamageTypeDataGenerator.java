package com.technologica.datagen.data.damagetype;

import com.technologica.world.damagesource.TechnologicaDamageTypes;

import net.minecraft.data.worldgen.BootstapContext;
import net.minecraft.world.damagesource.DamageScaling;
import net.minecraft.world.damagesource.DamageType;

public class DamageTypeDataGenerator {
	public static void bootstrap(BootstapContext<DamageType> boostrapContextIn) {
		boostrapContextIn.register(TechnologicaDamageTypes.BLEED, new DamageType("bled_out", 0.1F));
		boostrapContextIn.register(TechnologicaDamageTypes.NITRO_BLAST, new DamageType("jostled_the_nitro", DamageScaling.ALWAYS, 0.1F));
	}
}