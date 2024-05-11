package com.technologica.registration.key;

import com.technologica.api.tlregen.registration.MasterKeyCreator;
import com.technologica.resourcegen.data.worldgen.biome.TLBiomes;

import net.minecraft.resources.ResourceKey;
import net.minecraft.world.level.biome.Biome;

/**
 * <p>
 * This class contains Resource Keys for Biomes.
 * The corresponding Biomes are created in json format during Data Generation in {@link TLBiomes}.
 * </p>
 * 
 * @tl.status GREEN
 */
public final class TechnologicaBiomes extends MasterKeyCreator {
	public static final ResourceKey<Biome> SILENT_EXPANSES = biome("silent_expanses");
	public static final ResourceKey<Biome> CRATER_FIELDS = biome("crater_fields");
	public static final ResourceKey<Biome> SHATTERED_CORRIDORS = biome("shattered_corridors");

	public static final ResourceKey<Biome> MISTY_MIRE = biome("misty_mire");
	public static final ResourceKey<Biome> BRAMBLE = biome("bramble");

	public static final ResourceKey<Biome> RUSTING_GROUNDS = biome("rusting_grounds");
}