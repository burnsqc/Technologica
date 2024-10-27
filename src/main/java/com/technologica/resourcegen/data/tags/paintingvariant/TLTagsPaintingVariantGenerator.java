package com.technologica.resourcegen.data.tags.paintingvariant;

import com.technologica.registration.dynamic.TechnologicaPaintingVariantsDyn;
import com.tlregen.api.resourcegen.data.tags.TLReGenTagsPaintingVariant;

import net.minecraft.core.HolderLookup.Provider;
import net.minecraft.tags.PaintingVariantTags;

public final class TLTagsPaintingVariantGenerator extends TLReGenTagsPaintingVariant {
	@Override
	protected void populate(Provider p_256380_) {
		tag(PaintingVariantTags.PLACEABLE).add(TechnologicaPaintingVariantsDyn.AMNESIA);
	}
}
