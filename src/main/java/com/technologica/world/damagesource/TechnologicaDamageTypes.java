package com.technologica.world.damagesource;

import com.technologica.util.text.TechnologicaLocation;

import net.minecraft.core.registries.Registries;
import net.minecraft.resources.ResourceKey;
import net.minecraft.world.damagesource.DamageType;

public interface TechnologicaDamageTypes {
	ResourceKey<DamageType> BLEED = ResourceKey.create(Registries.DAMAGE_TYPE, new TechnologicaLocation("bleed"));
	ResourceKey<DamageType> NITRO_BLAST = ResourceKey.create(Registries.DAMAGE_TYPE, new TechnologicaLocation("nitro_blast"));
}