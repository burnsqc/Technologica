package com.technologica.world.level.biome;

import com.technologica.datagen.data.worldgen.biome.BiomeDataGenerator;
import com.technologica.util.text.TechnologicaLocation;

import net.minecraft.core.registries.Registries;
import net.minecraft.resources.ResourceKey;
import net.minecraft.world.level.biome.Biome;

/**
 * <p>
 * This class contains Resource Keys for Biomes.
 * The corresponding Biomes are created in json format during Data Generation in {@link BiomeDataGenerator}.
 * </p>
 * 
 * @tl.status GREEN
 */
public class TechnologicaBiomes {
	public static final ResourceKey<Biome> SILENT_EXPANSES = ResourceKey.create(Registries.BIOME, new TechnologicaLocation("silent_expanses"));
	public static final ResourceKey<Biome> CRATER_FIELDS = ResourceKey.create(Registries.BIOME, new TechnologicaLocation("crater_fields"));
	public static final ResourceKey<Biome> SHATTERED_CORRIDORS = ResourceKey.create(Registries.BIOME, new TechnologicaLocation("shattered_corridors"));
	public static final ResourceKey<Biome> MISTY_MIRE = ResourceKey.create(Registries.BIOME, new TechnologicaLocation("misty_mire"));
	public static final ResourceKey<Biome> BRAMBLE = ResourceKey.create(Registries.BIOME, new TechnologicaLocation("bramble"));
}