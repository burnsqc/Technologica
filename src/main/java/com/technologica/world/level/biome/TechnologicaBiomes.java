package com.technologica.world.level.biome;

import com.technologica.Technologica;

import net.minecraft.core.registries.Registries;
import net.minecraft.resources.ResourceKey;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.level.biome.Biome;

public class TechnologicaBiomes {
	public static final ResourceKey<Biome> SILENT_EXPANSES = register("silent_expanses");
	public static final ResourceKey<Biome> CRATER_FIELDS = register("crater_fields");
	public static final ResourceKey<Biome> SHATTERED_CORRIDORS = register("shattered_corridors");

	private static ResourceKey<Biome> register(String p_48229_) {
		return ResourceKey.create(Registries.BIOME, new ResourceLocation(Technologica.MODID, p_48229_));
	}
}
