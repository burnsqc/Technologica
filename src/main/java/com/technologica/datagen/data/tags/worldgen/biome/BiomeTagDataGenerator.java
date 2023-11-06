package com.technologica.datagen.data.tags.worldgen.biome;

import java.util.concurrent.CompletableFuture;

import com.technologica.Technologica;
import com.technologica.tags.TechnologicaBiomeTags;

import net.minecraft.core.HolderLookup;
import net.minecraft.data.PackOutput;
import net.minecraft.data.tags.BiomeTagsProvider;
import net.minecraft.world.level.biome.Biomes;
import net.minecraftforge.common.data.ExistingFileHelper;

public final class BiomeTagDataGenerator extends BiomeTagsProvider {

	public BiomeTagDataGenerator(PackOutput packOutputIn, CompletableFuture<HolderLookup.Provider> lookupProviderIn, ExistingFileHelper existingFileHelperIn) {
		super(packOutputIn, lookupProviderIn, Technologica.MODID, existingFileHelperIn);
	}

	@Override
	protected void addTags(HolderLookup.Provider providerIn) {
		tag(TechnologicaBiomeTags.HAS_EL_DORADO).add(Biomes.BADLANDS);

	}

	@Override
	public String getName() {
		return "Biome Tags: " + Technologica.MODID;
	}
}