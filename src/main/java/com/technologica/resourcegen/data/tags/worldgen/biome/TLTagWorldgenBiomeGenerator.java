package com.technologica.resourcegen.data.tags.worldgen.biome;

import com.technologica.api.tlregen.resourcegen.data.tags.TLReGenTagsWorldgenBiome;
import com.technologica.registration.dynamic.TechnologicaBiomeTags;
import com.technologica.registration.dynamic.TechnologicaBiomes;

import net.minecraft.core.HolderLookup;
import net.minecraft.tags.BiomeTags;

public final class TLTagWorldgenBiomeGenerator extends TLReGenTagsWorldgenBiome {
	@Override
	protected void populate(HolderLookup.Provider providerIn) {
		tag(TechnologicaBiomeTags.HAS_EL_DORADO).addOptional(TechnologicaBiomes.MISTY_MIRE.location());
		tag(TechnologicaBiomeTags.HAS_DOME).addOptional(TechnologicaBiomes.SILENT_EXPANSES.location());
		tag(TechnologicaBiomeTags.HAS_WHALE_CARCASS).addOptional(TechnologicaBiomes.NAVAL_GRAVEYARD.location());
		tag(BiomeTags.ALLOWS_TROPICAL_FISH_SPAWNS_AT_ANY_HEIGHT).addOptional(TechnologicaBiomes.FORGOTTEN_REEF.location());
	}

	@Override
	protected void populate() {
		// TODO Auto-generated method stub
	}
}
