package com.technologica.resourcegen.data.tags.worldgen.biome;

import com.technologica.registration.dynamic.TechnologicaBiomeTags;
import com.technologica.registration.dynamic.TechnologicaBiomes;
import com.tlregen.api.resourcegen.data.tags.TLReGenTagsWorldgenBiome;

import net.minecraft.core.HolderLookup;
import net.minecraft.tags.BiomeTags;

public final class TLTagWorldgenBiomeGenerator extends TLReGenTagsWorldgenBiome {
	@Override
	protected void populate(HolderLookup.Provider providerIn) {
		tag(TechnologicaBiomeTags.HAS_EL_DORADO).add(TechnologicaBiomes.MISTY_MIRE);
		tag(TechnologicaBiomeTags.HAS_DOME).addOptional(TechnologicaBiomes.SILENT_EXPANSES.location());
		tag(TechnologicaBiomeTags.HAS_WHALE_CARCASS).addOptional(TechnologicaBiomes.NAVAL_GRAVEYARD.location());
		tag(BiomeTags.ALLOWS_TROPICAL_FISH_SPAWNS_AT_ANY_HEIGHT).addOptional(TechnologicaBiomes.FORGOTTEN_REEF.location());
	}
}
