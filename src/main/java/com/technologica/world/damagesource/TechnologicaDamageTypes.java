package com.technologica.world.damagesource;

import com.technologica.Technologica;

import net.minecraft.core.registries.Registries;
import net.minecraft.resources.ResourceKey;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.damagesource.DamageType;

public interface TechnologicaDamageTypes {
	ResourceKey<DamageType> BLEED = ResourceKey.create(Registries.DAMAGE_TYPE, new ResourceLocation(Technologica.MODID, "bleed"));
	ResourceKey<DamageType> NITRO_BLAST = ResourceKey.create(Registries.DAMAGE_TYPE, new ResourceLocation(Technologica.MODID, "nitro_blast"));
}