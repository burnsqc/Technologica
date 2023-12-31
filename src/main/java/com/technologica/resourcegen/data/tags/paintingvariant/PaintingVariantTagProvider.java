package com.technologica.resourcegen.data.tags.paintingvariant;

import java.util.concurrent.CompletableFuture;

import com.technologica.Technologica;
import com.technologica.registration.key.TechnologicaPaintingVariants;

import net.minecraft.core.HolderLookup.Provider;
import net.minecraft.data.PackOutput;
import net.minecraft.data.tags.PaintingVariantTagsProvider;
import net.minecraft.tags.PaintingVariantTags;
import net.minecraftforge.common.data.ExistingFileHelper;

public final class PaintingVariantTagProvider extends PaintingVariantTagsProvider {

	public PaintingVariantTagProvider(PackOutput output, CompletableFuture<Provider> lookupProvider, ExistingFileHelper existingFileHelper) {
		super(output, lookupProvider, Technologica.MOD_ID, existingFileHelper);
	}

	@Override
	protected void addTags(Provider p_256380_) {
		this.tag(PaintingVariantTags.PLACEABLE).add(TechnologicaPaintingVariants.AMNESIA);
	}

	@Override
	public String getName() {
		return "Tags - Painting Variants:" + Technologica.MOD_ID;
	}
}