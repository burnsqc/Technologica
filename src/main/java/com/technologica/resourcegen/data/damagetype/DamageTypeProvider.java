package com.technologica.resourcegen.data.damagetype;

import java.util.Set;
import java.util.concurrent.CompletableFuture;

import com.technologica.Technologica;
import com.technologica.registration.key.TechnologicaDamageTypes;

import net.minecraft.core.HolderLookup.Provider;
import net.minecraft.core.RegistrySetBuilder;
import net.minecraft.data.PackOutput;
import net.minecraft.data.worldgen.BootstapContext;
import net.minecraft.world.damagesource.DamageScaling;
import net.minecraft.world.damagesource.DamageType;
import net.minecraftforge.common.data.DatapackBuiltinEntriesProvider;

public class DamageTypeProvider extends DatapackBuiltinEntriesProvider {
	
	public DamageTypeProvider(PackOutput output, CompletableFuture<Provider> registries, RegistrySetBuilder builder) {
		super(output, registries, builder, Set.of(Technologica.MOD_ID));
	}

	public static void bootstrap(BootstapContext<DamageType> damageType) {
		damageType.register(TechnologicaDamageTypes.BLEED, new DamageType("bled_out", 0.1F));
		damageType.register(TechnologicaDamageTypes.NITRO_BLAST, new DamageType("jostled_the_nitro", DamageScaling.ALWAYS, 0.1F));
	}
	
	@Override
	public String getName() {
		return "Damage Types";
	}
}