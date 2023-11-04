package com.technologica.world.level.biome;

import com.technologica.Technologica;
import com.technologica.data.worldgen.biome.TechnologicaBiomeData;

import net.minecraft.core.registries.Registries;
import net.minecraft.resources.ResourceKey;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.level.biome.Biome;

/**
 * <p>
 * This class contains Resource Keys for Biomes.
 * The corresponding Biomes are created in json format during Data Generation in {@link TechnologicaBiomeData}.
 * </p>
 * 
 * @tl.status GREEN
 */
public class TechnologicaBiomes {
	public static final ResourceKey<Biome> SILENT_EXPANSES = ResourceKey.create(Registries.BIOME, new ResourceLocation(Technologica.MODID, "silent_expanses"));
	public static final ResourceKey<Biome> CRATER_FIELDS = ResourceKey.create(Registries.BIOME, new ResourceLocation(Technologica.MODID, "crater_fields"));
	public static final ResourceKey<Biome> SHATTERED_CORRIDORS = ResourceKey.create(Registries.BIOME, new ResourceLocation(Technologica.MODID, "shattered_corridors"));
	public static final ResourceKey<Biome> MISTY_MIRE = ResourceKey.create(Registries.BIOME, new ResourceLocation(Technologica.MODID, "misty_mire"));
}