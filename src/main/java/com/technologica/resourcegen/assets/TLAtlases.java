package com.technologica.resourcegen.assets;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Optional;

import com.technologica.util.text.TechnologicaLocation;
import com.tlregen.api.resourcegen.assets.TLReGenAtlases.VanillaAtlases;

import net.minecraft.client.renderer.texture.atlas.SpriteSource;
import net.minecraft.client.renderer.texture.atlas.sources.SingleFile;
import net.minecraft.resources.ResourceLocation;

public class TLAtlases {
	public static final Map<ResourceLocation, List<SpriteSource>> ATLASES = new HashMap<>();
	private static final ResourceLocation TEST_ATLAS_1 = new TechnologicaLocation("test_atlas_1");
	private static final ResourceLocation TEST_ATLAS_2 = new TechnologicaLocation("test_atlas_2");

	static {
		ATLASES.put(TEST_ATLAS_1, List.of(new SingleFile(new ResourceLocation("forge:white"), Optional.empty())));
		ATLASES.put(TEST_ATLAS_2, List.of(new SingleFile(new ResourceLocation("forge:white"), Optional.empty())));
		ATLASES.put(VanillaAtlases.BLOCKS, List.of(new SingleFile(new ResourceLocation("forge:white"), Optional.empty())));

	}
}
