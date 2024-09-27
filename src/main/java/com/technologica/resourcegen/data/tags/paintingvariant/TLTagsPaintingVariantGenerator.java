package com.technologica.resourcegen.data.tags.paintingvariant;

import com.technologica.api.tlregen.resourcegen.data.tags.TLReGenTagsPaintingVariant;
import com.technologica.registration.dynamic.TechnologicaPaintingVariants;

import net.minecraft.core.HolderLookup.Provider;
import net.minecraft.tags.PaintingVariantTags;

public final class TLTagsPaintingVariantGenerator extends TLReGenTagsPaintingVariant {
	@Override
	protected void populate(Provider p_256380_) {
		tag(PaintingVariantTags.PLACEABLE).add(TechnologicaPaintingVariants.AMNESIA);
	}

	@Override
	protected void populate() {
		// TODO Auto-generated method stub

	}
}
