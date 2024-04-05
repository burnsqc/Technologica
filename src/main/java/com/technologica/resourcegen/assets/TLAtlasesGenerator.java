package com.technologica.resourcegen.assets;

import java.util.Optional;

import com.technologica.api.tlregen.resourcegen.assets.TLReGenAtlases;

import net.minecraft.client.renderer.texture.atlas.sources.SingleFile;
import net.minecraft.resources.ResourceLocation;

public class TLAtlasesGenerator extends TLReGenAtlases {
	protected static final ResourceLocation ARMOR_TRIMS_ATLAS = new ResourceLocation("armor_trims");

	@Override
	public void populate() {
		atlas(ARMOR_TRIMS_ATLAS).addSource(new SingleFile(new ResourceLocation("forge:white"), Optional.empty()));
	}
}
