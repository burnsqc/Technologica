package com.technologica.resourcegen.data.tags.worldgen.biome;

import com.technologica.api.tlregen.resourcegen.data.TLRGTagsWorldgenBiomeGenerator;
import com.technologica.registration.key.TechnologicaBiomeTags;
import com.technologica.registration.key.TechnologicaBiomes;

import net.minecraft.core.HolderLookup;

public final class TLTagWorldgenBiomeGenerator extends TLRGTagsWorldgenBiomeGenerator {
	@Override
	protected void addTags(HolderLookup.Provider providerIn) {
		tag(TechnologicaBiomeTags.HAS_EL_DORADO).addOptional(TechnologicaBiomes.MISTY_MIRE.location());
		tag(TechnologicaBiomeTags.HAS_DOME).addOptional(TechnologicaBiomes.SILENT_EXPANSES.location());
	}
}
