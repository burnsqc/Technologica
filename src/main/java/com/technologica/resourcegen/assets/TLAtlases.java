package com.technologica.resourcegen.assets;

import java.util.List;
import java.util.Optional;

import com.technologica.api.tlregen.resourcegen.assets.TLReGenAtlases;
import com.technologica.util.text.TechnologicaLocation;

import net.minecraft.client.renderer.texture.atlas.sources.SingleFile;
import net.minecraft.resources.ResourceLocation;

public class TLAtlases extends TLReGenAtlases {
	private static final ResourceLocation TEST_ATLAS_1 = new TechnologicaLocation("test_atlas_1");
	private static final ResourceLocation TEST_ATLAS_2 = new TechnologicaLocation("test_atlas_2");

	@Override
	public void populate() {
		atlas(TEST_ATLAS_1, List.of(new SingleFile(new ResourceLocation("forge:white"), Optional.empty())));
		atlas(TEST_ATLAS_2, List.of(new SingleFile(new ResourceLocation("forge:white"), Optional.empty())));
		atlas(VanillaAtlases.BLOCKS, List.of(new SingleFile(new ResourceLocation("forge:white"), Optional.empty())));
	}
}
