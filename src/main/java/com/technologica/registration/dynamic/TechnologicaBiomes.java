package com.technologica.registration.dynamic;

import com.technologica.api.tlregen.registration.MasterKeyCreator;
import com.technologica.resourcegen.data.worldgen.biome.TLWorldgenBiomes;

import net.minecraft.resources.ResourceKey;
import net.minecraft.world.level.biome.Biome;

/**
 * <p>
 * This class contains Resource Keys for Biomes.
 * The corresponding Biomes are created in json format during Data Generation in {@link TLWorldgenBiomes}.
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
	public static final ResourceKey<Biome> FORGOTTEN_REEF = biome("forgotten_reef");
	public static final ResourceKey<Biome> NAVAL_GRAVEYARD = biome("naval_graveyard");
	public static final ResourceKey<Biome> SUNKEN_FOREST = biome("sunken_forest");
	public static final ResourceKey<Biome> HYDROTHERMAL_CAVERN = biome("hydrothermal_cavern");
	public static final ResourceKey<Biome> ABYSSAL_DEPTHS = biome("abyssal_depths");
}