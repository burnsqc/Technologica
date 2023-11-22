package com.technologica.resourcegen.data.tags.worldgen.biome;

import java.util.concurrent.CompletableFuture;

import com.technologica.Technologica;
import com.technologica.registration.key.TechnologicaBiomeTags;
import com.technologica.registration.key.TechnologicaBiomes;

import net.minecraft.core.HolderLookup;
import net.minecraft.data.PackOutput;
import net.minecraft.data.tags.BiomeTagsProvider;
import net.minecraftforge.common.data.ExistingFileHelper;

public final class BiomeTagProvider extends BiomeTagsProvider {

	public BiomeTagProvider(PackOutput packOutputIn, CompletableFuture<HolderLookup.Provider> lookupProviderIn, ExistingFileHelper existingFileHelperIn) {
		super(packOutputIn, lookupProviderIn, Technologica.MOD_ID, existingFileHelperIn);
	}

	@Override
	protected void addTags(HolderLookup.Provider providerIn) {
		tag(TechnologicaBiomeTags.HAS_EL_DORADO).addOptional(TechnologicaBiomes.MISTY_MIRE.location());
		tag(TechnologicaBiomeTags.HAS_DOME).addOptional(TechnologicaBiomes.SILENT_EXPANSES.location());
	}

	@Override
	public String getName() {
		return "Biome Tags: " + Technologica.MOD_ID;
	}
}