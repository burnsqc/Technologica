package com.technologica.world.damagesource;

import com.technologica.Technologica;

import net.minecraft.core.registries.Registries;
import net.minecraft.data.worldgen.BootstapContext;
import net.minecraft.resources.ResourceKey;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.damagesource.DamageScaling;
import net.minecraft.world.damagesource.DamageType;

public interface TechnologicaDamageTypes {
	ResourceKey<DamageType> BLEED = ResourceKey.create(Registries.DAMAGE_TYPE, new ResourceLocation(Technologica.MODID, "bleed"));
	ResourceKey<DamageType> NITRO_BLAST = ResourceKey.create(Registries.DAMAGE_TYPE, new ResourceLocation(Technologica.MODID, "nitro_blast"));

	static void bootstrap(BootstapContext<DamageType> damageType) {
		damageType.register(BLEED, new DamageType("bled_out", 0.1F));
		damageType.register(NITRO_BLAST, new DamageType("jostled_the_nitro", DamageScaling.ALWAYS, 0.1F));
	}
}