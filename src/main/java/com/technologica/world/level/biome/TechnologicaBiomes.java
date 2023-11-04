package com.technologica.world.level.biome;

import com.technologica.Technologica;
import com.technologica.data.worldgen.biome.MoonBiomes;
import com.technologica.data.worldgen.biome.OvergrowthBiomes;

import net.minecraft.core.HolderGetter;
import net.minecraft.core.registries.Registries;
import net.minecraft.data.worldgen.BootstapContext;
import net.minecraft.resources.ResourceKey;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.level.biome.Biome;
import net.minecraft.world.level.levelgen.carver.ConfiguredWorldCarver;
import net.minecraft.world.level.levelgen.placement.PlacedFeature;

/**
 * <p>
 * This class contains Resource Keys for Biomes.
 * The corresponding Biomes are created in json format during Data Generation in {@link TechnologicaBiomeData}.
 * </p>
 * 
 * @tl.status GREEN
 */
public abstract class TechnologicaBiomes {
	public static final ResourceKey<Biome> SILENT_EXPANSES = ResourceKey.create(Registries.BIOME, new ResourceLocation(Technologica.MODID, "silent_expanses"));
	public static final ResourceKey<Biome> CRATER_FIELDS = ResourceKey.create(Registries.BIOME, new ResourceLocation(Technologica.MODID, "crater_fields"));
	public static final ResourceKey<Biome> SHATTERED_CORRIDORS = ResourceKey.create(Registries.BIOME, new ResourceLocation(Technologica.MODID, "shattered_corridors"));
	public static final ResourceKey<Biome> MISTY_MIRE = ResourceKey.create(Registries.BIOME, new ResourceLocation(Technologica.MODID, "misty_mire"));

	public static void bootstrap(BootstapContext<Biome> biomes) {
		HolderGetter<PlacedFeature> placedFeatures = biomes.lookup(Registries.PLACED_FEATURE);
		HolderGetter<ConfiguredWorldCarver<?>> configuredCarvers = biomes.lookup(Registries.CONFIGURED_CARVER);
		biomes.register(TechnologicaBiomes.SILENT_EXPANSES, MoonBiomes.silentExpanses(placedFeatures, configuredCarvers, false));
		biomes.register(TechnologicaBiomes.CRATER_FIELDS, MoonBiomes.craterFields(placedFeatures, configuredCarvers, false));
		biomes.register(TechnologicaBiomes.SHATTERED_CORRIDORS, MoonBiomes.shatteredCorridors(placedFeatures, configuredCarvers, false));
		biomes.register(TechnologicaBiomes.MISTY_MIRE, OvergrowthBiomes.mistyMire(placedFeatures, configuredCarvers, false));
	}
}