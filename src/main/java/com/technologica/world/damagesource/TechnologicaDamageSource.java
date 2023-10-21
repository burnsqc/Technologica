package com.technologica.world.damagesource;

import net.minecraft.core.Holder;
import net.minecraft.world.damagesource.DamageSource;
import net.minecraft.world.damagesource.DamageType;

public class TechnologicaDamageSource extends DamageSource {
	// public static final DamageSource BLEED = (new TechnologicaDamageSource("bled_out")).bypassArmor();
	// public static final DamageSource NITRO_BLAST = (new TechnologicaDamageSource("jostled_the_nitro")).bypassArmor();

	public TechnologicaDamageSource(Holder<DamageType> p_19333_) {
		super(p_19333_);
	}
}