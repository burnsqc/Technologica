package com.technologica.resourcegen.data.tags.worldgen.biome;

import com.technologica.api.tlregen.resourcegen.data.tags.TLReGenTagsWorldgenBiome;
import com.technologica.registration.key.TechnologicaBiomeTags;
import com.technologica.registration.key.TechnologicaBiomes;

import net.minecraft.core.HolderLookup;

public final class TLTagWorldgenBiomeGenerator extends TLReGenTagsWorldgenBiome {
	@Override
	protected void populate(HolderLookup.Provider providerIn) {
		tag(TechnologicaBiomeTags.HAS_EL_DORADO).addOptional(TechnologicaBiomes.MISTY_MIRE.location());
		tag(TechnologicaBiomeTags.HAS_DOME).addOptional(TechnologicaBiomes.SILENT_EXPANSES.location());
		tag(TechnologicaBiomeTags.HAS_WHALE_CARCASS).addOptional(TechnologicaBiomes.RUSTING_GROUNDS.location());
	}
}
