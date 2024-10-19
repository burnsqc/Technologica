package com.technologica.registration.dynamic;

import com.technologica.Technologica;

import net.minecraft.resources.ResourceKey;
import net.minecraft.world.damagesource.DamageScaling;
import net.minecraft.world.damagesource.DamageType;

public final class TechnologicaDamageTypes {
	public static final ResourceKey<DamageType> BLEED = Technologica.DAMAGE_TYPES.register("bleed", () -> new DamageType("bleed", 0.1F));
	public static final ResourceKey<DamageType> NITRO_BLAST = Technologica.DAMAGE_TYPES.register("nitro_blast", () -> new DamageType("nitro_blast", DamageScaling.ALWAYS, 0.1F));
}
