package com.technologica.data.tags;

import java.util.concurrent.CompletableFuture;

import com.technologica.Technologica;
import com.technologica.tags.TechnologicaBiomeTags;
import com.technologica.world.level.biome.TechnologicaBiomes;

import net.minecraft.core.HolderLookup;
import net.minecraft.data.PackOutput;
import net.minecraft.data.tags.BiomeTagsProvider;
import net.minecraftforge.common.data.ExistingFileHelper;

public final class TechnologicaBiomeTagsProvider extends BiomeTagsProvider {

	public TechnologicaBiomeTagsProvider(PackOutput packOutputIn, CompletableFuture<HolderLookup.Provider> lookupProviderIn, ExistingFileHelper existingFileHelperIn) {
		super(packOutputIn, lookupProviderIn, Technologica.MODID, existingFileHelperIn);
	}

	@Override
	protected void addTags(HolderLookup.Provider providerIn) {
		tag(TechnologicaBiomeTags.HAS_EL_DORADO).add(TechnologicaBiomes.MISTY_MIRE);

	}

	@Override
	public String getName() {
		return "Technologica Biome Tags";
	}
}