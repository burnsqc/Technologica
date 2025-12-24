package com.technologica.world.level;

import java.util.function.Consumer;

import com.mojang.datafixers.util.Pair;

import net.minecraft.resources.ResourceKey;
import net.minecraft.util.VisibleForDebug;
import net.minecraft.world.level.biome.Biome;
import net.minecraft.world.level.biome.Biomes;
import net.minecraft.world.level.biome.Climate;
import net.minecraft.world.level.biome.OverworldBiomeBuilder;
import net.minecraft.world.level.levelgen.DensityFunction;
import net.minecraft.world.level.levelgen.NoiseRouterData;

/**
 * This class is a simple copy of {@link OverworldBiomeBuilder} with cleanup and added comments to better understand overworld biome generation. Unusued values have been removed.
 * <p>Unused values have been removed. Contrived spans have been redefined.</p>
 */
@SuppressWarnings("unchecked")
public final class TechnologicaOverworldBiomeBuilder {
	public static final float HIGH_START = 0.4F;
	public static final float PEAK_START = 0.56666666F;
	public static final float NEAR_INLAND_START = -0.11F;
	public static final float MID_INLAND_START = 0.03F;
	public static final float FAR_INLAND_START = 0.3F;
	public static final float EROSION_INDEX_1_START = -0.78F;
	public static final float EROSION_INDEX_2_START = -0.375F;
	private final Climate.Parameter FULL_RANGE = Climate.Parameter.span(-1.0F, 1.0F);
	private final Climate.Parameter[] temperatures = new Climate.Parameter[] { Climate.Parameter.span(-1.0F, -0.45F), Climate.Parameter.span(-0.45F, -0.15F), Climate.Parameter.span(-0.15F, 0.2F), Climate.Parameter.span(0.2F, 0.55F), Climate.Parameter.span(0.55F, 1.0F) };
	private final Climate.Parameter[] humidities = new Climate.Parameter[] { Climate.Parameter.span(-1.0F, -0.35F), Climate.Parameter.span(-0.35F, -0.1F), Climate.Parameter.span(-0.1F, 0.1F), Climate.Parameter.span(0.1F, 0.3F), Climate.Parameter.span(0.3F, 1.0F) };
	private final Climate.Parameter[] erosions = new Climate.Parameter[] { Climate.Parameter.span(-1.0F, -0.78F), Climate.Parameter.span(-0.78F, -0.375F), Climate.Parameter.span(-0.375F, -0.2225F), Climate.Parameter.span(-0.2225F, 0.05F), Climate.Parameter.span(0.05F, 0.45F), Climate.Parameter.span(0.45F, 0.55F), Climate.Parameter.span(0.55F, 1.0F) };
	private final Climate.Parameter FROZEN_RANGE = temperatures[0];
	private final Climate.Parameter UNFROZEN_RANGE = Climate.Parameter.span(temperatures[1], temperatures[4]);
	private final Climate.Parameter mushroomFieldsContinentalness = Climate.Parameter.span(-1.2F, -1.05F);
	private final Climate.Parameter deepOceanContinentalness = Climate.Parameter.span(-1.05F, -0.455F);
	private final Climate.Parameter oceanContinentalness = Climate.Parameter.span(-0.455F, -0.19F);
	private final Climate.Parameter coastContinentalness = Climate.Parameter.span(-0.19F, -0.11F);
	private final Climate.Parameter inlandContinentalness = Climate.Parameter.span(-0.11F, 0.55F);
	private final Climate.Parameter nearInlandContinentalness = Climate.Parameter.span(-0.11F, 0.03F);
	private final Climate.Parameter midInlandContinentalness = Climate.Parameter.span(0.03F, 0.3F);
	private final Climate.Parameter farInlandContinentalness = Climate.Parameter.span(0.3F, 1.0F);

	private final ResourceKey<Biome>[][] OCEANS = new ResourceKey[][] { 
		{ Biomes.DEEP_FROZEN_OCEAN, Biomes.DEEP_COLD_OCEAN, Biomes.DEEP_OCEAN, Biomes.DEEP_LUKEWARM_OCEAN, Biomes.WARM_OCEAN }, 
		{ Biomes.FROZEN_OCEAN, Biomes.COLD_OCEAN, Biomes.OCEAN, Biomes.LUKEWARM_OCEAN, Biomes.WARM_OCEAN } };

	private final ResourceKey<Biome>[][] MIDDLE_BIOMES = new ResourceKey[][] { 
		{ Biomes.SNOWY_PLAINS, Biomes.SNOWY_PLAINS, Biomes.SNOWY_PLAINS, Biomes.SNOWY_TAIGA, Biomes.TAIGA }, 
		{ Biomes.PLAINS, Biomes.PLAINS, Biomes.FOREST, Biomes.TAIGA, Biomes.OLD_GROWTH_SPRUCE_TAIGA }, 
		{ Biomes.FLOWER_FOREST, Biomes.PLAINS, Biomes.FOREST, Biomes.BIRCH_FOREST, Biomes.DARK_FOREST }, 
		{ Biomes.SAVANNA, Biomes.SAVANNA, Biomes.FOREST, Biomes.JUNGLE, Biomes.JUNGLE }, 
		{ Biomes.DESERT, Biomes.DESERT, Biomes.DESERT, Biomes.DESERT, Biomes.DESERT } };

	private final ResourceKey<Biome>[][] MIDDLE_BIOMES_VARIANT = new ResourceKey[][] { 
		{ Biomes.ICE_SPIKES, null, Biomes.SNOWY_TAIGA, null, null }, 
		{ null, null, null, null, Biomes.OLD_GROWTH_PINE_TAIGA }, 
		{ Biomes.SUNFLOWER_PLAINS, null, null, Biomes.OLD_GROWTH_BIRCH_FOREST, null }, 
		{ null, null, Biomes.PLAINS, Biomes.SPARSE_JUNGLE, Biomes.BAMBOO_JUNGLE }, 
		{ null, null, null, null, null } };

	private final ResourceKey<Biome>[][] PLATEAU_BIOMES = new ResourceKey[][] { { Biomes.SNOWY_PLAINS, Biomes.SNOWY_PLAINS, Biomes.SNOWY_PLAINS, Biomes.SNOWY_TAIGA, Biomes.SNOWY_TAIGA }, { Biomes.MEADOW, Biomes.MEADOW, Biomes.FOREST, Biomes.TAIGA, Biomes.OLD_GROWTH_SPRUCE_TAIGA }, { Biomes.MEADOW, Biomes.MEADOW, Biomes.MEADOW, Biomes.MEADOW, Biomes.DARK_FOREST }, { Biomes.SAVANNA_PLATEAU, Biomes.SAVANNA_PLATEAU, Biomes.FOREST, Biomes.FOREST, Biomes.JUNGLE }, { Biomes.BADLANDS, Biomes.BADLANDS, Biomes.BADLANDS, Biomes.WOODED_BADLANDS, Biomes.WOODED_BADLANDS } };

	private final ResourceKey<Biome>[][] PLATEAU_BIOMES_VARIANT = new ResourceKey[][] { { Biomes.ICE_SPIKES, null, null, null, null }, { Biomes.CHERRY_GROVE, null, Biomes.MEADOW, Biomes.MEADOW, Biomes.OLD_GROWTH_PINE_TAIGA }, { Biomes.CHERRY_GROVE, Biomes.CHERRY_GROVE, Biomes.FOREST, Biomes.BIRCH_FOREST, null }, { null, null, null, null, null }, { Biomes.ERODED_BADLANDS, Biomes.ERODED_BADLANDS, null, null, null } };

	private final ResourceKey<Biome>[][] SHATTERED_BIOMES = new ResourceKey[][] { { Biomes.WINDSWEPT_GRAVELLY_HILLS, Biomes.WINDSWEPT_GRAVELLY_HILLS, Biomes.WINDSWEPT_HILLS, Biomes.WINDSWEPT_FOREST, Biomes.WINDSWEPT_FOREST }, { Biomes.WINDSWEPT_GRAVELLY_HILLS, Biomes.WINDSWEPT_GRAVELLY_HILLS, Biomes.WINDSWEPT_HILLS, Biomes.WINDSWEPT_FOREST, Biomes.WINDSWEPT_FOREST }, { Biomes.WINDSWEPT_HILLS, Biomes.WINDSWEPT_HILLS, Biomes.WINDSWEPT_HILLS, Biomes.WINDSWEPT_FOREST, Biomes.WINDSWEPT_FOREST }, { null, null, null, null, null }, { null, null, null, null, null } };

	protected void addBiomes(Consumer<Pair<Climate.ParameterPoint, ResourceKey<Biome>>> builder) {
		builder.accept(Pair.of(Climate.parameters(FULL_RANGE, FULL_RANGE, mushroomFieldsContinentalness, FULL_RANGE, Climate.Parameter.point(0.0F), FULL_RANGE, 0.0F), Biomes.MUSHROOM_FIELDS));
		builder.accept(Pair.of(Climate.parameters(FULL_RANGE, FULL_RANGE, mushroomFieldsContinentalness, FULL_RANGE, Climate.Parameter.point(1.0F), FULL_RANGE, 0.0F), Biomes.MUSHROOM_FIELDS));
		for (int temperatureBin = 0; temperatureBin < temperatures.length; ++temperatureBin) {
			Climate.Parameter temperatureRange = temperatures[temperatureBin];
			addSurfaceBiome(builder, temperatureRange, FULL_RANGE, deepOceanContinentalness, FULL_RANGE, FULL_RANGE, 0.0F, OCEANS[0][temperatureBin]);
			addSurfaceBiome(builder, temperatureRange, FULL_RANGE, oceanContinentalness, FULL_RANGE, FULL_RANGE, 0.0F, OCEANS[1][temperatureBin]);
		}

		addInlandBiomes(builder);

		builder.accept(Pair.of(Climate.parameters(FULL_RANGE, FULL_RANGE, FULL_RANGE, FULL_RANGE, Climate.Parameter.span(0.8F, 1.0F), FULL_RANGE, 0.0F), Biomes.DRIPSTONE_CAVES));
		builder.accept(Pair.of(Climate.parameters(FULL_RANGE, Climate.Parameter.span(0.7F, 1.0F), FULL_RANGE, FULL_RANGE, Climate.Parameter.span(0.2F, 0.9F), FULL_RANGE, 0.0F), Biomes.LUSH_CAVES));
		builder.accept(Pair.of(Climate.parameters(FULL_RANGE, FULL_RANGE, FULL_RANGE, Climate.Parameter.span(erosions[0], erosions[1]), Climate.Parameter.point(1.1F), FULL_RANGE, 0.0F), Biomes.DEEP_DARK));
	}

	private void addInlandBiomes(Consumer<Pair<Climate.ParameterPoint, ResourceKey<Biome>>> builder) {
		addMidSlice(builder, Climate.Parameter.span(-1.0F, -0.93333334F));
		addHighSlice(builder, Climate.Parameter.span(-0.93333334F, -0.7666667F));
		addPeaks(builder, Climate.Parameter.span(-0.7666667F, -0.56666666F));
		addHighSlice(builder, Climate.Parameter.span(-0.56666666F, -0.4F));
		addMidSlice(builder, Climate.Parameter.span(-0.4F, -0.26666668F));
		addLowSlice(builder, Climate.Parameter.span(-0.26666668F, -0.05F));
		addValleys(builder, Climate.Parameter.span(-0.05F, 0.05F));
		addLowSlice(builder, Climate.Parameter.span(0.05F, 0.26666668F));
		addMidSlice(builder, Climate.Parameter.span(0.26666668F, 0.4F));
		addHighSlice(builder, Climate.Parameter.span(0.4F, 0.56666666F));
		addPeaks(builder, Climate.Parameter.span(0.56666666F, 0.7666667F));
		addHighSlice(builder, Climate.Parameter.span(0.7666667F, 0.93333334F));
		addMidSlice(builder, Climate.Parameter.span(0.93333334F, 1.0F));
	}

	private void addPeaks(Consumer<Pair<Climate.ParameterPoint, ResourceKey<Biome>>> builder, Climate.Parameter weirdness) {
		for (int temperatureBin = 0; temperatureBin < temperatures.length; ++temperatureBin) {
			Climate.Parameter temperature = temperatures[temperatureBin];

			for (int humidityBin = 0; humidityBin < humidities.length; ++humidityBin) {
				Climate.Parameter humidity = humidities[humidityBin];
				ResourceKey<Biome> resourcekey = pickMiddleBiome(temperatureBin, humidityBin, weirdness);
				ResourceKey<Biome> resourcekey1 = pickMiddleBiomeOrBadlandsIfHot(temperatureBin, humidityBin, weirdness);
				ResourceKey<Biome> resourcekey2 = pickMiddleBiomeOrBadlandsIfHotOrSlopeIfCold(temperatureBin, humidityBin, weirdness);
				ResourceKey<Biome> resourcekey3 = pickPlateauBiome(temperatureBin, humidityBin, weirdness);
				ResourceKey<Biome> resourcekey4 = pickShatteredBiome(temperatureBin, humidityBin, weirdness);
				ResourceKey<Biome> resourcekey5 = maybePickWindsweptSavannaBiome(temperatureBin, humidityBin, weirdness, resourcekey4);
				ResourceKey<Biome> resourcekey6 = pickPeakBiome(temperatureBin, humidityBin, weirdness);
				addSurfaceBiome(builder, temperature, humidity, Climate.Parameter.span(coastContinentalness, farInlandContinentalness), erosions[0], weirdness, 0.0F, resourcekey6);
				addSurfaceBiome(builder, temperature, humidity, Climate.Parameter.span(coastContinentalness, nearInlandContinentalness), erosions[1], weirdness, 0.0F, resourcekey2);
				addSurfaceBiome(builder, temperature, humidity, Climate.Parameter.span(midInlandContinentalness, farInlandContinentalness), erosions[1], weirdness, 0.0F, resourcekey6);
				addSurfaceBiome(builder, temperature, humidity, Climate.Parameter.span(coastContinentalness, nearInlandContinentalness), Climate.Parameter.span(erosions[2], erosions[3]), weirdness, 0.0F, resourcekey);
				addSurfaceBiome(builder, temperature, humidity, Climate.Parameter.span(midInlandContinentalness, farInlandContinentalness), erosions[2], weirdness, 0.0F, resourcekey3);
				addSurfaceBiome(builder, temperature, humidity, midInlandContinentalness, erosions[3], weirdness, 0.0F, resourcekey1);
				addSurfaceBiome(builder, temperature, humidity, farInlandContinentalness, erosions[3], weirdness, 0.0F, resourcekey3);
				addSurfaceBiome(builder, temperature, humidity, Climate.Parameter.span(coastContinentalness, farInlandContinentalness), erosions[4], weirdness, 0.0F, resourcekey);
				addSurfaceBiome(builder, temperature, humidity, Climate.Parameter.span(coastContinentalness, nearInlandContinentalness), erosions[5], weirdness, 0.0F, resourcekey5);
				addSurfaceBiome(builder, temperature, humidity, Climate.Parameter.span(midInlandContinentalness, farInlandContinentalness), erosions[5], weirdness, 0.0F, resourcekey4);
				addSurfaceBiome(builder, temperature, humidity, Climate.Parameter.span(coastContinentalness, farInlandContinentalness), erosions[6], weirdness, 0.0F, resourcekey);
			}
		}

	}

	private void addHighSlice(Consumer<Pair<Climate.ParameterPoint, ResourceKey<Biome>>> builder, Climate.Parameter p_187199_) {
		for (int i = 0; i < temperatures.length; ++i) {
			Climate.Parameter climate$parameter = temperatures[i];

			for (int j = 0; j < humidities.length; ++j) {
				Climate.Parameter climate$parameter1 = humidities[j];
				ResourceKey<Biome> resourcekey = pickMiddleBiome(i, j, p_187199_);
				ResourceKey<Biome> resourcekey1 = pickMiddleBiomeOrBadlandsIfHot(i, j, p_187199_);
				ResourceKey<Biome> resourcekey2 = pickMiddleBiomeOrBadlandsIfHotOrSlopeIfCold(i, j, p_187199_);
				ResourceKey<Biome> resourcekey3 = pickPlateauBiome(i, j, p_187199_);
				ResourceKey<Biome> resourcekey4 = pickShatteredBiome(i, j, p_187199_);
				ResourceKey<Biome> resourcekey5 = maybePickWindsweptSavannaBiome(i, j, p_187199_, resourcekey);
				ResourceKey<Biome> resourcekey6 = pickSlopeBiome(i, j, p_187199_);
				ResourceKey<Biome> resourcekey7 = pickPeakBiome(i, j, p_187199_);
				addSurfaceBiome(builder, climate$parameter, climate$parameter1, coastContinentalness, Climate.Parameter.span(erosions[0], erosions[1]), p_187199_, 0.0F, resourcekey);
				addSurfaceBiome(builder, climate$parameter, climate$parameter1, nearInlandContinentalness, erosions[0], p_187199_, 0.0F, resourcekey6);
				addSurfaceBiome(builder, climate$parameter, climate$parameter1, Climate.Parameter.span(midInlandContinentalness, farInlandContinentalness), erosions[0], p_187199_, 0.0F, resourcekey7);
				addSurfaceBiome(builder, climate$parameter, climate$parameter1, nearInlandContinentalness, erosions[1], p_187199_, 0.0F, resourcekey2);
				addSurfaceBiome(builder, climate$parameter, climate$parameter1, Climate.Parameter.span(midInlandContinentalness, farInlandContinentalness), erosions[1], p_187199_, 0.0F, resourcekey6);
				addSurfaceBiome(builder, climate$parameter, climate$parameter1, Climate.Parameter.span(coastContinentalness, nearInlandContinentalness), Climate.Parameter.span(erosions[2], erosions[3]), p_187199_, 0.0F, resourcekey);
				addSurfaceBiome(builder, climate$parameter, climate$parameter1, Climate.Parameter.span(midInlandContinentalness, farInlandContinentalness), erosions[2], p_187199_, 0.0F, resourcekey3);
				addSurfaceBiome(builder, climate$parameter, climate$parameter1, midInlandContinentalness, erosions[3], p_187199_, 0.0F, resourcekey1);
				addSurfaceBiome(builder, climate$parameter, climate$parameter1, farInlandContinentalness, erosions[3], p_187199_, 0.0F, resourcekey3);
				addSurfaceBiome(builder, climate$parameter, climate$parameter1, Climate.Parameter.span(coastContinentalness, farInlandContinentalness), erosions[4], p_187199_, 0.0F, resourcekey);
				addSurfaceBiome(builder, climate$parameter, climate$parameter1, Climate.Parameter.span(coastContinentalness, nearInlandContinentalness), erosions[5], p_187199_, 0.0F, resourcekey5);
				addSurfaceBiome(builder, climate$parameter, climate$parameter1, Climate.Parameter.span(midInlandContinentalness, farInlandContinentalness), erosions[5], p_187199_, 0.0F, resourcekey4);
				addSurfaceBiome(builder, climate$parameter, climate$parameter1, Climate.Parameter.span(coastContinentalness, farInlandContinentalness), erosions[6], p_187199_, 0.0F, resourcekey);
			}
		}

	}

	private void addMidSlice(Consumer<Pair<Climate.ParameterPoint, ResourceKey<Biome>>> builder, Climate.Parameter p_187219_) {
		addSurfaceBiome(builder, FULL_RANGE, FULL_RANGE, coastContinentalness, Climate.Parameter.span(erosions[0], erosions[2]), p_187219_, 0.0F, Biomes.STONY_SHORE);
		addSurfaceBiome(builder, Climate.Parameter.span(temperatures[1], temperatures[2]), FULL_RANGE, Climate.Parameter.span(nearInlandContinentalness, farInlandContinentalness), erosions[6], p_187219_, 0.0F, Biomes.SWAMP);
		addSurfaceBiome(builder, Climate.Parameter.span(temperatures[3], temperatures[4]), FULL_RANGE, Climate.Parameter.span(nearInlandContinentalness, farInlandContinentalness), erosions[6], p_187219_, 0.0F, Biomes.MANGROVE_SWAMP);

		for (int i = 0; i < temperatures.length; ++i) {
			Climate.Parameter climate$parameter = temperatures[i];

			for (int j = 0; j < humidities.length; ++j) {
				Climate.Parameter climate$parameter1 = humidities[j];
				ResourceKey<Biome> resourcekey = pickMiddleBiome(i, j, p_187219_);
				ResourceKey<Biome> resourcekey1 = pickMiddleBiomeOrBadlandsIfHot(i, j, p_187219_);
				ResourceKey<Biome> resourcekey2 = pickMiddleBiomeOrBadlandsIfHotOrSlopeIfCold(i, j, p_187219_);
				ResourceKey<Biome> resourcekey3 = pickShatteredBiome(i, j, p_187219_);
				ResourceKey<Biome> resourcekey4 = pickPlateauBiome(i, j, p_187219_);
				ResourceKey<Biome> resourcekey5 = pickBeachBiome(i, j);
				ResourceKey<Biome> resourcekey6 = maybePickWindsweptSavannaBiome(i, j, p_187219_, resourcekey);
				ResourceKey<Biome> resourcekey7 = pickShatteredCoastBiome(i, j, p_187219_);
				ResourceKey<Biome> resourcekey8 = pickSlopeBiome(i, j, p_187219_);
				addSurfaceBiome(builder, climate$parameter, climate$parameter1, Climate.Parameter.span(nearInlandContinentalness, farInlandContinentalness), erosions[0], p_187219_, 0.0F, resourcekey8);
				addSurfaceBiome(builder, climate$parameter, climate$parameter1, Climate.Parameter.span(nearInlandContinentalness, midInlandContinentalness), erosions[1], p_187219_, 0.0F, resourcekey2);
				addSurfaceBiome(builder, climate$parameter, climate$parameter1, farInlandContinentalness, erosions[1], p_187219_, 0.0F, i == 0 ? resourcekey8 : resourcekey4);
				addSurfaceBiome(builder, climate$parameter, climate$parameter1, nearInlandContinentalness, erosions[2], p_187219_, 0.0F, resourcekey);
				addSurfaceBiome(builder, climate$parameter, climate$parameter1, midInlandContinentalness, erosions[2], p_187219_, 0.0F, resourcekey1);
				addSurfaceBiome(builder, climate$parameter, climate$parameter1, farInlandContinentalness, erosions[2], p_187219_, 0.0F, resourcekey4);
				addSurfaceBiome(builder, climate$parameter, climate$parameter1, Climate.Parameter.span(coastContinentalness, nearInlandContinentalness), erosions[3], p_187219_, 0.0F, resourcekey);
				addSurfaceBiome(builder, climate$parameter, climate$parameter1, Climate.Parameter.span(midInlandContinentalness, farInlandContinentalness), erosions[3], p_187219_, 0.0F, resourcekey1);
				if (p_187219_.max() < 0L) {
					addSurfaceBiome(builder, climate$parameter, climate$parameter1, coastContinentalness, erosions[4], p_187219_, 0.0F, resourcekey5);
					addSurfaceBiome(builder, climate$parameter, climate$parameter1, Climate.Parameter.span(nearInlandContinentalness, farInlandContinentalness), erosions[4], p_187219_, 0.0F, resourcekey);
				} else {
					addSurfaceBiome(builder, climate$parameter, climate$parameter1, Climate.Parameter.span(coastContinentalness, farInlandContinentalness), erosions[4], p_187219_, 0.0F, resourcekey);
				}

				addSurfaceBiome(builder, climate$parameter, climate$parameter1, coastContinentalness, erosions[5], p_187219_, 0.0F, resourcekey7);
				addSurfaceBiome(builder, climate$parameter, climate$parameter1, nearInlandContinentalness, erosions[5], p_187219_, 0.0F, resourcekey6);
				addSurfaceBiome(builder, climate$parameter, climate$parameter1, Climate.Parameter.span(midInlandContinentalness, farInlandContinentalness), erosions[5], p_187219_, 0.0F, resourcekey3);
				if (p_187219_.max() < 0L) {
					addSurfaceBiome(builder, climate$parameter, climate$parameter1, coastContinentalness, erosions[6], p_187219_, 0.0F, resourcekey5);
				} else {
					addSurfaceBiome(builder, climate$parameter, climate$parameter1, coastContinentalness, erosions[6], p_187219_, 0.0F, resourcekey);
				}

				if (i == 0) {
					addSurfaceBiome(builder, climate$parameter, climate$parameter1, Climate.Parameter.span(nearInlandContinentalness, farInlandContinentalness), erosions[6], p_187219_, 0.0F, resourcekey);
				}
			}
		}

	}

	private void addLowSlice(Consumer<Pair<Climate.ParameterPoint, ResourceKey<Biome>>> builder, Climate.Parameter p_187230_) {
		addSurfaceBiome(builder, FULL_RANGE, FULL_RANGE, coastContinentalness, Climate.Parameter.span(erosions[0], erosions[2]), p_187230_, 0.0F, Biomes.STONY_SHORE);
		addSurfaceBiome(builder, Climate.Parameter.span(temperatures[1], temperatures[2]), FULL_RANGE, Climate.Parameter.span(nearInlandContinentalness, farInlandContinentalness), erosions[6], p_187230_, 0.0F, Biomes.SWAMP);
		addSurfaceBiome(builder, Climate.Parameter.span(temperatures[3], temperatures[4]), FULL_RANGE, Climate.Parameter.span(nearInlandContinentalness, farInlandContinentalness), erosions[6], p_187230_, 0.0F, Biomes.MANGROVE_SWAMP);

		for (int i = 0; i < temperatures.length; ++i) {
			Climate.Parameter climate$parameter = temperatures[i];

			for (int j = 0; j < humidities.length; ++j) {
				Climate.Parameter climate$parameter1 = humidities[j];
				ResourceKey<Biome> resourcekey = pickMiddleBiome(i, j, p_187230_);
				ResourceKey<Biome> resourcekey1 = pickMiddleBiomeOrBadlandsIfHot(i, j, p_187230_);
				ResourceKey<Biome> resourcekey2 = pickMiddleBiomeOrBadlandsIfHotOrSlopeIfCold(i, j, p_187230_);
				ResourceKey<Biome> resourcekey3 = pickBeachBiome(i, j);
				ResourceKey<Biome> resourcekey4 = maybePickWindsweptSavannaBiome(i, j, p_187230_, resourcekey);
				ResourceKey<Biome> resourcekey5 = pickShatteredCoastBiome(i, j, p_187230_);
				addSurfaceBiome(builder, climate$parameter, climate$parameter1, nearInlandContinentalness, Climate.Parameter.span(erosions[0], erosions[1]), p_187230_, 0.0F, resourcekey1);
				addSurfaceBiome(builder, climate$parameter, climate$parameter1, Climate.Parameter.span(midInlandContinentalness, farInlandContinentalness), Climate.Parameter.span(erosions[0], erosions[1]), p_187230_, 0.0F, resourcekey2);
				addSurfaceBiome(builder, climate$parameter, climate$parameter1, nearInlandContinentalness, Climate.Parameter.span(erosions[2], erosions[3]), p_187230_, 0.0F, resourcekey);
				addSurfaceBiome(builder, climate$parameter, climate$parameter1, Climate.Parameter.span(midInlandContinentalness, farInlandContinentalness), Climate.Parameter.span(erosions[2], erosions[3]), p_187230_, 0.0F, resourcekey1);
				addSurfaceBiome(builder, climate$parameter, climate$parameter1, coastContinentalness, Climate.Parameter.span(erosions[3], erosions[4]), p_187230_, 0.0F, resourcekey3);
				addSurfaceBiome(builder, climate$parameter, climate$parameter1, Climate.Parameter.span(nearInlandContinentalness, farInlandContinentalness), erosions[4], p_187230_, 0.0F, resourcekey);
				addSurfaceBiome(builder, climate$parameter, climate$parameter1, coastContinentalness, erosions[5], p_187230_, 0.0F, resourcekey5);
				addSurfaceBiome(builder, climate$parameter, climate$parameter1, nearInlandContinentalness, erosions[5], p_187230_, 0.0F, resourcekey4);
				addSurfaceBiome(builder, climate$parameter, climate$parameter1, Climate.Parameter.span(midInlandContinentalness, farInlandContinentalness), erosions[5], p_187230_, 0.0F, resourcekey);
				addSurfaceBiome(builder, climate$parameter, climate$parameter1, coastContinentalness, erosions[6], p_187230_, 0.0F, resourcekey3);
				if (i == 0) {
					addSurfaceBiome(builder, climate$parameter, climate$parameter1, Climate.Parameter.span(nearInlandContinentalness, farInlandContinentalness), erosions[6], p_187230_, 0.0F, resourcekey);
				}
			}
		}

	}

	private void addValleys(Consumer<Pair<Climate.ParameterPoint, ResourceKey<Biome>>> builder, Climate.Parameter p_187239_) {
		addSurfaceBiome(builder, FROZEN_RANGE, FULL_RANGE, coastContinentalness, Climate.Parameter.span(erosions[0], erosions[1]), p_187239_, 0.0F, p_187239_.max() < 0L ? Biomes.STONY_SHORE : Biomes.FROZEN_RIVER);
		addSurfaceBiome(builder, UNFROZEN_RANGE, FULL_RANGE, coastContinentalness, Climate.Parameter.span(erosions[0], erosions[1]), p_187239_, 0.0F, p_187239_.max() < 0L ? Biomes.STONY_SHORE : Biomes.RIVER);
		addSurfaceBiome(builder, FROZEN_RANGE, FULL_RANGE, nearInlandContinentalness, Climate.Parameter.span(erosions[0], erosions[1]), p_187239_, 0.0F, Biomes.FROZEN_RIVER);
		addSurfaceBiome(builder, UNFROZEN_RANGE, FULL_RANGE, nearInlandContinentalness, Climate.Parameter.span(erosions[0], erosions[1]), p_187239_, 0.0F, Biomes.RIVER);
		addSurfaceBiome(builder, FROZEN_RANGE, FULL_RANGE, Climate.Parameter.span(coastContinentalness, farInlandContinentalness), Climate.Parameter.span(erosions[2], erosions[5]), p_187239_, 0.0F, Biomes.FROZEN_RIVER);
		addSurfaceBiome(builder, UNFROZEN_RANGE, FULL_RANGE, Climate.Parameter.span(coastContinentalness, farInlandContinentalness), Climate.Parameter.span(erosions[2], erosions[5]), p_187239_, 0.0F, Biomes.RIVER);
		addSurfaceBiome(builder, FROZEN_RANGE, FULL_RANGE, coastContinentalness, erosions[6], p_187239_, 0.0F, Biomes.FROZEN_RIVER);
		addSurfaceBiome(builder, UNFROZEN_RANGE, FULL_RANGE, coastContinentalness, erosions[6], p_187239_, 0.0F, Biomes.RIVER);
		addSurfaceBiome(builder, Climate.Parameter.span(temperatures[1], temperatures[2]), FULL_RANGE, Climate.Parameter.span(inlandContinentalness, farInlandContinentalness), erosions[6], p_187239_, 0.0F, Biomes.SWAMP);
		addSurfaceBiome(builder, Climate.Parameter.span(temperatures[3], temperatures[4]), FULL_RANGE, Climate.Parameter.span(inlandContinentalness, farInlandContinentalness), erosions[6], p_187239_, 0.0F, Biomes.MANGROVE_SWAMP);
		addSurfaceBiome(builder, FROZEN_RANGE, FULL_RANGE, Climate.Parameter.span(inlandContinentalness, farInlandContinentalness), erosions[6], p_187239_, 0.0F, Biomes.FROZEN_RIVER);

		for (int i = 0; i < temperatures.length; ++i) {
			Climate.Parameter climate$parameter = temperatures[i];

			for (int j = 0; j < humidities.length; ++j) {
				Climate.Parameter climate$parameter1 = humidities[j];
				ResourceKey<Biome> resourcekey = pickMiddleBiomeOrBadlandsIfHot(i, j, p_187239_);
				addSurfaceBiome(builder, climate$parameter, climate$parameter1, Climate.Parameter.span(midInlandContinentalness, farInlandContinentalness), Climate.Parameter.span(erosions[0], erosions[1]), p_187239_, 0.0F, resourcekey);
			}
		}

	}



	private ResourceKey<Biome> pickMiddleBiome(int temperatureBin, int humidityBin, Climate.Parameter weirdness) {
		if (weirdness.max() < 0L) {
			return MIDDLE_BIOMES[temperatureBin][humidityBin];
		} else {
			ResourceKey<Biome> resourcekey = MIDDLE_BIOMES_VARIANT[temperatureBin][humidityBin];
			return resourcekey == null ? MIDDLE_BIOMES[temperatureBin][humidityBin] : resourcekey;
		}
	}

	private ResourceKey<Biome> pickMiddleBiomeOrBadlandsIfHot(int p_187192_, int p_187193_, Climate.Parameter p_187194_) {
		return p_187192_ == 4 ? pickBadlandsBiome(p_187193_, p_187194_) : pickMiddleBiome(p_187192_, p_187193_, p_187194_);
	}

	private ResourceKey<Biome> pickMiddleBiomeOrBadlandsIfHotOrSlopeIfCold(int p_187212_, int p_187213_, Climate.Parameter p_187214_) {
		return p_187212_ == 0 ? pickSlopeBiome(p_187212_, p_187213_, p_187214_) : pickMiddleBiomeOrBadlandsIfHot(p_187212_, p_187213_, p_187214_);
	}

	private ResourceKey<Biome> maybePickWindsweptSavannaBiome(int p_201991_, int p_201992_, Climate.Parameter p_201993_, ResourceKey<Biome> p_201994_) {
		return p_201991_ > 1 && p_201992_ < 4 && p_201993_.max() >= 0L ? Biomes.WINDSWEPT_SAVANNA : p_201994_;
	}

	private ResourceKey<Biome> pickShatteredCoastBiome(int p_187223_, int p_187224_, Climate.Parameter p_187225_) {
		ResourceKey<Biome> resourcekey = p_187225_.max() >= 0L ? pickMiddleBiome(p_187223_, p_187224_, p_187225_) : pickBeachBiome(p_187223_, p_187224_);
		return maybePickWindsweptSavannaBiome(p_187223_, p_187224_, p_187225_, resourcekey);
	}

	private ResourceKey<Biome> pickBeachBiome(int p_187161_, int p_187162_) {
		if (p_187161_ == 0) {
			return Biomes.SNOWY_BEACH;
		} else {
			return p_187161_ == 4 ? Biomes.DESERT : Biomes.BEACH;
		}
	}

	private ResourceKey<Biome> pickBadlandsBiome(int p_187173_, Climate.Parameter p_187174_) {
		if (p_187173_ < 2) {
			return p_187174_.max() < 0L ? Biomes.BADLANDS : Biomes.ERODED_BADLANDS;
		} else {
			return p_187173_ < 3 ? Biomes.BADLANDS : Biomes.WOODED_BADLANDS;
		}
	}

	private ResourceKey<Biome> pickPlateauBiome(int p_187234_, int p_187235_, Climate.Parameter p_187236_) {
		if (p_187236_.max() >= 0L) {
			ResourceKey<Biome> resourcekey = PLATEAU_BIOMES_VARIANT[p_187234_][p_187235_];
			if (resourcekey != null) {
				return resourcekey;
			}
		}

		return PLATEAU_BIOMES[p_187234_][p_187235_];
	}

	private ResourceKey<Biome> pickPeakBiome(int p_187241_, int p_187242_, Climate.Parameter p_187243_) {
		if (p_187241_ <= 2) {
			return p_187243_.max() < 0L ? Biomes.JAGGED_PEAKS : Biomes.FROZEN_PEAKS;
		} else {
			return p_187241_ == 3 ? Biomes.STONY_PEAKS : pickBadlandsBiome(p_187242_, p_187243_);
		}
	}

	private ResourceKey<Biome> pickSlopeBiome(int p_187245_, int p_187246_, Climate.Parameter p_187247_) {
		if (p_187245_ >= 3) {
			return pickPlateauBiome(p_187245_, p_187246_, p_187247_);
		} else {
			return p_187246_ <= 1 ? Biomes.SNOWY_SLOPES : Biomes.GROVE;
		}
	}

	private ResourceKey<Biome> pickShatteredBiome(int p_202002_, int p_202003_, Climate.Parameter p_202004_) {
		ResourceKey<Biome> resourcekey = SHATTERED_BIOMES[p_202002_][p_202003_];
		return resourcekey == null ? pickMiddleBiome(p_202002_, p_202003_, p_202004_) : resourcekey;
	}

	private void addSurfaceBiome(Consumer<Pair<Climate.ParameterPoint, ResourceKey<Biome>>> builder, Climate.Parameter temperature, Climate.Parameter humidity, Climate.Parameter continentalness, Climate.Parameter erosion, Climate.Parameter weirdness, float offset, ResourceKey<Biome> biome) {
		builder.accept(Pair.of(Climate.parameters(temperature, humidity, continentalness, erosion, Climate.Parameter.point(0.0F), weirdness, offset), biome));
		builder.accept(Pair.of(Climate.parameters(temperature, humidity, continentalness, erosion, Climate.Parameter.point(1.0F), weirdness, offset), biome));
	}

	public static boolean isDeepDarkRegion(DensityFunction p_252040_, DensityFunction p_250447_, DensityFunction.FunctionContext p_249270_) {
		return p_252040_.compute(p_249270_) < -0.225F && p_250447_.compute(p_249270_) > 0.9F;
	}

	/**
	 * This method returns the plain english name associated with the peaksAndValleys bin to be displayed to the debug screen.
	 * 
	 * @param continentalness
	 * 
	 * @return
	 */
	public static String getDebugStringForPeaksAndValleys(double peaksAndValleys) {
		if (peaksAndValleys < NoiseRouterData.peaksAndValleys(0.05F)) {
			return "Valley";
		} else if (peaksAndValleys < NoiseRouterData.peaksAndValleys(0.26666668F)) {
			return "Low";
		} else if (peaksAndValleys < NoiseRouterData.peaksAndValleys(0.4F)) {
			return "Mid";
		} else {
			return peaksAndValleys < NoiseRouterData.peaksAndValleys(0.56666666F) ? "High" : "Peak";
		}
	}

	/**
	 * This method returns the plain english name associated with the continentalness bin to be displayed to the debug screen.
	 * 
	 * @param continentalness
	 * 
	 * @return
	 */
	public String getDebugStringForContinentalness(double continentalness) {
		double continentalnessQuantized = Climate.quantizeCoord((float) continentalness);
		if (continentalnessQuantized < mushroomFieldsContinentalness.max()) {
			return "Mushroom fields";
		} else if (continentalnessQuantized < deepOceanContinentalness.max()) {
			return "Deep ocean";
		} else if (continentalnessQuantized < oceanContinentalness.max()) {
			return "Ocean";
		} else if (continentalnessQuantized < coastContinentalness.max()) {
			return "Coast";
		} else if (continentalnessQuantized < nearInlandContinentalness.max()) {
			return "Near inland";
		} else {
			return continentalnessQuantized < midInlandContinentalness.max() ? "Mid inland" : "Far inland";
		}
	}

	public String getDebugStringForErosion(double erosion) {
		return getDebugStringForNoiseValue(erosion, erosions);
	}

	public String getDebugStringForTemperature(double temperature) {
		return getDebugStringForNoiseValue(temperature, temperatures);
	}

	public String getDebugStringForHumidity(double humidity) {
		return getDebugStringForNoiseValue(humidity, humidities);
	}

	private static String getDebugStringForNoiseValue(double value, Climate.Parameter[] bins) {
		double valueQuantized = Climate.quantizeCoord((float) value);
		for (int index = 0; index < bins.length; ++index) {
			if (valueQuantized < bins[index].max()) {
				return "" + index;
			}
		}
		return "?";
	}

	@VisibleForDebug
	public Climate.Parameter[] getTemperatureThresholds() {
		return temperatures;
	}

	@VisibleForDebug
	public Climate.Parameter[] getHumidityThresholds() {
		return humidities;
	}

	@VisibleForDebug
	public Climate.Parameter[] getErosionThresholds() {
		return erosions;
	}

	@VisibleForDebug
	public Climate.Parameter[] getContinentalnessThresholds() {
		return new Climate.Parameter[] { mushroomFieldsContinentalness, deepOceanContinentalness, oceanContinentalness, coastContinentalness, nearInlandContinentalness, midInlandContinentalness, farInlandContinentalness };
	}

	@VisibleForDebug
	public Climate.Parameter[] getPeaksAndValleysThresholds() {
		return new Climate.Parameter[] { Climate.Parameter.span(-2.0F, NoiseRouterData.peaksAndValleys(0.05F)), Climate.Parameter.span(NoiseRouterData.peaksAndValleys(0.05F), NoiseRouterData.peaksAndValleys(0.26666668F)), Climate.Parameter.span(NoiseRouterData.peaksAndValleys(0.26666668F), NoiseRouterData.peaksAndValleys(0.4F)), Climate.Parameter.span(NoiseRouterData.peaksAndValleys(0.4F), NoiseRouterData.peaksAndValleys(0.56666666F)), Climate.Parameter.span(NoiseRouterData.peaksAndValleys(0.56666666F), 2.0F) };
	}

	@VisibleForDebug
	public Climate.Parameter[] getWeirdnessThresholds() {
		return new Climate.Parameter[] { Climate.Parameter.span(-2.0F, 0.0F), Climate.Parameter.span(0.0F, 2.0F) };
	}
}