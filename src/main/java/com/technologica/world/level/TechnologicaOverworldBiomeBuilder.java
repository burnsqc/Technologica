package com.technologica.world.level;

import java.util.List;
import java.util.function.Consumer;

import com.mojang.datafixers.util.Pair;

import net.minecraft.resources.ResourceKey;
import net.minecraft.util.VisibleForDebug;
import net.minecraft.world.level.biome.Biome;
import net.minecraft.world.level.biome.Biomes;
import net.minecraft.world.level.biome.Climate;
import net.minecraft.world.level.levelgen.DensityFunction;
import net.minecraft.world.level.levelgen.NoiseRouterData;

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
	private final Climate.Parameter FROZEN_RANGE = this.temperatures[0];
	private final Climate.Parameter UNFROZEN_RANGE = Climate.Parameter.span(this.temperatures[1], this.temperatures[4]);

	private final Climate.Parameter[] temperatures = new Climate.Parameter[] { Climate.Parameter.span(-1.0F, -0.45F), Climate.Parameter.span(-0.45F, -0.15F), Climate.Parameter.span(-0.15F, 0.2F), Climate.Parameter.span(0.2F, 0.55F), Climate.Parameter.span(0.55F, 1.0F) };
	private final Climate.Parameter[] humidities = new Climate.Parameter[] { Climate.Parameter.span(-1.0F, -0.35F), Climate.Parameter.span(-0.35F, -0.1F), Climate.Parameter.span(-0.1F, 0.1F), Climate.Parameter.span(0.1F, 0.3F), Climate.Parameter.span(0.3F, 1.0F) };
	private final Climate.Parameter[] erosions = new Climate.Parameter[] { Climate.Parameter.span(-1.0F, -0.78F), Climate.Parameter.span(-0.78F, -0.375F), Climate.Parameter.span(-0.375F, -0.2225F), Climate.Parameter.span(-0.2225F, 0.05F), Climate.Parameter.span(0.05F, 0.45F), Climate.Parameter.span(0.45F, 0.55F), Climate.Parameter.span(0.55F, 1.0F) };

	private final Climate.Parameter mushroomFieldsContinentalness = Climate.Parameter.span(-1.2F, -1.05F);
	private final Climate.Parameter deepOceanContinentalness = Climate.Parameter.span(-1.05F, -0.455F);
	private final Climate.Parameter oceanContinentalness = Climate.Parameter.span(-0.455F, -0.19F);
	private final Climate.Parameter coastContinentalness = Climate.Parameter.span(-0.19F, -0.11F);
	private final Climate.Parameter inlandContinentalness = Climate.Parameter.span(-0.11F, 0.55F);
	private final Climate.Parameter nearInlandContinentalness = Climate.Parameter.span(-0.11F, 0.03F);
	private final Climate.Parameter midInlandContinentalness = Climate.Parameter.span(0.03F, 0.3F);
	private final Climate.Parameter farInlandContinentalness = Climate.Parameter.span(0.3F, 1.0F);

	private final ResourceKey<Biome>[][] OCEANS = new ResourceKey[][] { 
		{ Biomes.DEEP_FROZEN_OCEAN,	Biomes.DEEP_COLD_OCEAN, Biomes.DEEP_OCEAN, 		Biomes.DEEP_LUKEWARM_OCEAN, Biomes.WARM_OCEAN }, 
		{ Biomes.FROZEN_OCEAN, 		Biomes.COLD_OCEAN, 		Biomes.OCEAN, 			Biomes.LUKEWARM_OCEAN, 		Biomes.WARM_OCEAN } };
	private final ResourceKey<Biome>[][] MIDDLE_BIOMES = new ResourceKey[][] { 
		{ Biomes.SNOWY_PLAINS, 		Biomes.SNOWY_PLAINS, 	Biomes.SNOWY_PLAINS, 	Biomes.SNOWY_TAIGA, 		Biomes.TAIGA }, 
		{ Biomes.PLAINS, 			Biomes.PLAINS, 			Biomes.FOREST, 			Biomes.TAIGA, 				Biomes.OLD_GROWTH_SPRUCE_TAIGA }, 
		{ Biomes.FLOWER_FOREST, 	Biomes.PLAINS, 			Biomes.FOREST, 			Biomes.BIRCH_FOREST, 		Biomes.DARK_FOREST }, 
		{ Biomes.SAVANNA, 			Biomes.SAVANNA, 		Biomes.FOREST, 			Biomes.JUNGLE, 				Biomes.JUNGLE }, 
		{ Biomes.DESERT, 			Biomes.DESERT, 			Biomes.DESERT, 			Biomes.DESERT, 				Biomes.DESERT } };
	private final ResourceKey<Biome>[][] MIDDLE_BIOMES_VARIANT = new ResourceKey[][] { 
		{ Biomes.ICE_SPIKES, null, Biomes.SNOWY_TAIGA, null, null }, 
		{ null, null, null, null, Biomes.OLD_GROWTH_PINE_TAIGA }, 
		{ Biomes.SUNFLOWER_PLAINS, null, null, Biomes.OLD_GROWTH_BIRCH_FOREST, null }, 
		{ null, null, Biomes.PLAINS, Biomes.SPARSE_JUNGLE, Biomes.BAMBOO_JUNGLE }, 
		{ null, null, null, null, null } };
	private final ResourceKey<Biome>[][] PLATEAU_BIOMES = new ResourceKey[][] { { Biomes.SNOWY_PLAINS, Biomes.SNOWY_PLAINS, Biomes.SNOWY_PLAINS, Biomes.SNOWY_TAIGA, Biomes.SNOWY_TAIGA }, { Biomes.MEADOW, Biomes.MEADOW, Biomes.FOREST, Biomes.TAIGA, Biomes.OLD_GROWTH_SPRUCE_TAIGA }, { Biomes.MEADOW, Biomes.MEADOW, Biomes.MEADOW, Biomes.MEADOW, Biomes.DARK_FOREST }, { Biomes.SAVANNA_PLATEAU, Biomes.SAVANNA_PLATEAU, Biomes.FOREST, Biomes.FOREST, Biomes.JUNGLE }, { Biomes.BADLANDS, Biomes.BADLANDS, Biomes.BADLANDS, Biomes.WOODED_BADLANDS, Biomes.WOODED_BADLANDS } };
	private final ResourceKey<Biome>[][] PLATEAU_BIOMES_VARIANT = new ResourceKey[][] { { Biomes.ICE_SPIKES, null, null, null, null }, { Biomes.CHERRY_GROVE, null, Biomes.MEADOW, Biomes.MEADOW, Biomes.OLD_GROWTH_PINE_TAIGA }, { Biomes.CHERRY_GROVE, Biomes.CHERRY_GROVE, Biomes.FOREST, Biomes.BIRCH_FOREST, null }, { null, null, null, null, null }, { Biomes.ERODED_BADLANDS, Biomes.ERODED_BADLANDS, null, null, null } };
	private final ResourceKey<Biome>[][] SHATTERED_BIOMES = new ResourceKey[][] { { Biomes.WINDSWEPT_GRAVELLY_HILLS, Biomes.WINDSWEPT_GRAVELLY_HILLS, Biomes.WINDSWEPT_HILLS, Biomes.WINDSWEPT_FOREST, Biomes.WINDSWEPT_FOREST }, { Biomes.WINDSWEPT_GRAVELLY_HILLS, Biomes.WINDSWEPT_GRAVELLY_HILLS, Biomes.WINDSWEPT_HILLS, Biomes.WINDSWEPT_FOREST, Biomes.WINDSWEPT_FOREST }, { Biomes.WINDSWEPT_HILLS, Biomes.WINDSWEPT_HILLS, Biomes.WINDSWEPT_HILLS, Biomes.WINDSWEPT_FOREST, Biomes.WINDSWEPT_FOREST }, { null, null, null, null, null }, { null, null, null, null, null } };

	public List<Climate.ParameterPoint> spawnTarget() {
		Climate.Parameter depth = Climate.Parameter.point(0.0F);
		return List.of(
			new Climate.ParameterPoint(
				this.FULL_RANGE, 
				this.FULL_RANGE, 
				Climate.Parameter.span(this.inlandContinentalness, this.FULL_RANGE), 
				this.FULL_RANGE, 
				depth, 
				Climate.Parameter.span(-1.0F, -0.16F), 
				0L
			), 
			new Climate.ParameterPoint(
				this.FULL_RANGE, 
				this.FULL_RANGE, 
				Climate.Parameter.span(this.inlandContinentalness, this.FULL_RANGE), 
				this.FULL_RANGE, 
				depth, 
				Climate.Parameter.span(0.16F, 1.0F), 
				0L
			));
	}

	protected void addBiomes(Consumer<Pair<Climate.ParameterPoint, ResourceKey<Biome>>> builder) {
		this.addOffCoastBiomes(builder);
		this.addInlandBiomes(builder);
		this.addUndergroundBiomes(builder);
	}

	private void addOffCoastBiomes(Consumer<Pair<Climate.ParameterPoint, ResourceKey<Biome>>> builder) {
		this.addSurfaceBiome(builder, this.FULL_RANGE, this.FULL_RANGE, this.mushroomFieldsContinentalness, this.FULL_RANGE, this.FULL_RANGE, 0.0F, Biomes.MUSHROOM_FIELDS);
		for (int temperatureIndex = 0; temperatureIndex < this.temperatures.length; ++temperatureIndex) {
			Climate.Parameter temperature = this.temperatures[temperatureIndex];
			this.addSurfaceBiome(builder, temperature, this.FULL_RANGE, this.deepOceanContinentalness, this.FULL_RANGE, this.FULL_RANGE, 0.0F, this.OCEANS[0][temperatureIndex]);
			this.addSurfaceBiome(builder, temperature, this.FULL_RANGE, this.oceanContinentalness, this.FULL_RANGE, this.FULL_RANGE, 0.0F, this.OCEANS[1][temperatureIndex]);
		}
	}

	private void addInlandBiomes(Consumer<Pair<Climate.ParameterPoint, ResourceKey<Biome>>> builder) {
		this.addMidSlice(builder, Climate.Parameter.span(-1.0F, -0.93333334F));
		this.addHighSlice(builder, Climate.Parameter.span(-0.93333334F, -0.7666667F));
		this.addPeaks(builder, Climate.Parameter.span(-0.7666667F, -0.56666666F));
		this.addHighSlice(builder, Climate.Parameter.span(-0.56666666F, -0.4F));
		this.addMidSlice(builder, Climate.Parameter.span(-0.4F, -0.26666668F));
		this.addLowSlice(builder, Climate.Parameter.span(-0.26666668F, -0.05F));
		this.addValleys(builder, Climate.Parameter.span(-0.05F, 0.05F));
		this.addLowSlice(builder, Climate.Parameter.span(0.05F, 0.26666668F));
		this.addMidSlice(builder, Climate.Parameter.span(0.26666668F, 0.4F));
		this.addHighSlice(builder, Climate.Parameter.span(0.4F, 0.56666666F));
		this.addPeaks(builder, Climate.Parameter.span(0.56666666F, 0.7666667F));
		this.addHighSlice(builder, Climate.Parameter.span(0.7666667F, 0.93333334F));
		this.addMidSlice(builder, Climate.Parameter.span(0.93333334F, 1.0F));
	}

	private void addUndergroundBiomes(Consumer<Pair<Climate.ParameterPoint, ResourceKey<Biome>>> builder) {
		this.addUndergroundBiome(builder, this.FULL_RANGE, this.FULL_RANGE, Climate.Parameter.span(0.8F, 1.0F), this.FULL_RANGE, this.FULL_RANGE, 0.0F, Biomes.DRIPSTONE_CAVES);
		this.addUndergroundBiome(builder, this.FULL_RANGE, Climate.Parameter.span(0.7F, 1.0F), this.FULL_RANGE, this.FULL_RANGE, this.FULL_RANGE, 0.0F, Biomes.LUSH_CAVES);
		this.addBottomBiome(builder, this.FULL_RANGE, this.FULL_RANGE, this.FULL_RANGE, Climate.Parameter.span(this.erosions[0], this.erosions[1]), this.FULL_RANGE, 0.0F, Biomes.DEEP_DARK);
	}

	private void addPeaks(Consumer<Pair<Climate.ParameterPoint, ResourceKey<Biome>>> builder, Climate.Parameter weirdness) {
		for (int temperatureIndex = 0; temperatureIndex < this.temperatures.length; ++temperatureIndex) {
			Climate.Parameter temperature = this.temperatures[temperatureIndex];
			for (int humidityIndex = 0; humidityIndex < this.humidities.length; ++humidityIndex) {
				Climate.Parameter humidity = this.humidities[humidityIndex];
				ResourceKey<Biome> biome1 = this.pickMiddleBiome(temperatureIndex, humidityIndex, weirdness);
				ResourceKey<Biome> biome2 = this.pickMiddleBiomeOrBadlandsIfHot(temperatureIndex, humidityIndex, weirdness);
				ResourceKey<Biome> biome3 = this.pickMiddleBiomeOrBadlandsIfHotOrSlopeIfCold(temperatureIndex, humidityIndex, weirdness);
				ResourceKey<Biome> biome4 = this.pickPlateauBiome(temperatureIndex, humidityIndex, weirdness);
				ResourceKey<Biome> biome5 = this.pickShatteredBiome(temperatureIndex, humidityIndex, weirdness);
				ResourceKey<Biome> biome6 = this.maybePickWindsweptSavannaBiome(temperatureIndex, humidityIndex, weirdness, biome5);
				ResourceKey<Biome> biome7 = this.pickPeakBiome(temperatureIndex, humidityIndex, weirdness);
				this.addSurfaceBiome(builder, temperature, humidity, Climate.Parameter.span(this.coastContinentalness, this.farInlandContinentalness), this.erosions[0], weirdness, 0.0F, biome7);
				this.addSurfaceBiome(builder, temperature, humidity, Climate.Parameter.span(this.coastContinentalness, this.nearInlandContinentalness), this.erosions[1], weirdness, 0.0F, biome3);
				this.addSurfaceBiome(builder, temperature, humidity, Climate.Parameter.span(this.midInlandContinentalness, this.farInlandContinentalness), this.erosions[1], weirdness, 0.0F, biome7);
				this.addSurfaceBiome(builder, temperature, humidity, Climate.Parameter.span(this.coastContinentalness, this.nearInlandContinentalness), Climate.Parameter.span(this.erosions[2], this.erosions[3]), weirdness, 0.0F, biome1);
				this.addSurfaceBiome(builder, temperature, humidity, Climate.Parameter.span(this.midInlandContinentalness, this.farInlandContinentalness), this.erosions[2], weirdness, 0.0F, biome4);
				this.addSurfaceBiome(builder, temperature, humidity, this.midInlandContinentalness, this.erosions[3], weirdness, 0.0F, biome2);
				this.addSurfaceBiome(builder, temperature, humidity, this.farInlandContinentalness, this.erosions[3], weirdness, 0.0F, biome4);
				this.addSurfaceBiome(builder, temperature, humidity, Climate.Parameter.span(this.coastContinentalness, this.farInlandContinentalness), this.erosions[4], weirdness, 0.0F, biome1);
				this.addSurfaceBiome(builder, temperature, humidity, Climate.Parameter.span(this.coastContinentalness, this.nearInlandContinentalness), this.erosions[5], weirdness, 0.0F, biome6);
				this.addSurfaceBiome(builder, temperature, humidity, Climate.Parameter.span(this.midInlandContinentalness, this.farInlandContinentalness), this.erosions[5], weirdness, 0.0F, biome5);
				this.addSurfaceBiome(builder, temperature, humidity, Climate.Parameter.span(this.coastContinentalness, this.farInlandContinentalness), this.erosions[6], weirdness, 0.0F, biome1);
			}
		}
	}

	private void addHighSlice(Consumer<Pair<Climate.ParameterPoint, ResourceKey<Biome>>> builder, Climate.Parameter weirdness) {
		for (int temperatureIndex = 0; temperatureIndex < this.temperatures.length; ++temperatureIndex) {
			Climate.Parameter temperature = this.temperatures[temperatureIndex];
			for (int humidityIndex = 0; humidityIndex < this.humidities.length; ++humidityIndex) {
				Climate.Parameter humidity = this.humidities[humidityIndex];
				ResourceKey<Biome> biome1 = this.pickMiddleBiome(temperatureIndex, humidityIndex, weirdness);
				ResourceKey<Biome> biome2 = this.pickMiddleBiomeOrBadlandsIfHot(temperatureIndex, humidityIndex, weirdness);
				ResourceKey<Biome> biome3 = this.pickMiddleBiomeOrBadlandsIfHotOrSlopeIfCold(temperatureIndex, humidityIndex, weirdness);
				ResourceKey<Biome> biome4 = this.pickPlateauBiome(temperatureIndex, humidityIndex, weirdness);
				ResourceKey<Biome> biome5 = this.pickShatteredBiome(temperatureIndex, humidityIndex, weirdness);
				ResourceKey<Biome> biome6 = this.maybePickWindsweptSavannaBiome(temperatureIndex, humidityIndex, weirdness, biome1);
				ResourceKey<Biome> biome7 = this.pickSlopeBiome(temperatureIndex, humidityIndex, weirdness);
				ResourceKey<Biome> biome8 = this.pickPeakBiome(temperatureIndex, humidityIndex, weirdness);
				this.addSurfaceBiome(builder, temperature, humidity, this.coastContinentalness, Climate.Parameter.span(this.erosions[0], this.erosions[1]), weirdness, 0.0F, biome1);
				this.addSurfaceBiome(builder, temperature, humidity, this.nearInlandContinentalness, this.erosions[0], weirdness, 0.0F, biome7);
				this.addSurfaceBiome(builder, temperature, humidity, Climate.Parameter.span(this.midInlandContinentalness, this.farInlandContinentalness), this.erosions[0], weirdness, 0.0F, biome8);
				this.addSurfaceBiome(builder, temperature, humidity, this.nearInlandContinentalness, this.erosions[1], weirdness, 0.0F, biome3);
				this.addSurfaceBiome(builder, temperature, humidity, Climate.Parameter.span(this.midInlandContinentalness, this.farInlandContinentalness), this.erosions[1], weirdness, 0.0F, biome7);
				this.addSurfaceBiome(builder, temperature, humidity, Climate.Parameter.span(this.coastContinentalness, this.nearInlandContinentalness), Climate.Parameter.span(this.erosions[2], this.erosions[3]), weirdness, 0.0F, biome1);
				this.addSurfaceBiome(builder, temperature, humidity, Climate.Parameter.span(this.midInlandContinentalness, this.farInlandContinentalness), this.erosions[2], weirdness, 0.0F, biome4);
				this.addSurfaceBiome(builder, temperature, humidity, this.midInlandContinentalness, this.erosions[3], weirdness, 0.0F, biome2);
				this.addSurfaceBiome(builder, temperature, humidity, this.farInlandContinentalness, this.erosions[3], weirdness, 0.0F, biome4);
				this.addSurfaceBiome(builder, temperature, humidity, Climate.Parameter.span(this.coastContinentalness, this.farInlandContinentalness), this.erosions[4], weirdness, 0.0F, biome1);
				this.addSurfaceBiome(builder, temperature, humidity, Climate.Parameter.span(this.coastContinentalness, this.nearInlandContinentalness), this.erosions[5], weirdness, 0.0F, biome6);
				this.addSurfaceBiome(builder, temperature, humidity, Climate.Parameter.span(this.midInlandContinentalness, this.farInlandContinentalness), this.erosions[5], weirdness, 0.0F, biome5);
				this.addSurfaceBiome(builder, temperature, humidity, Climate.Parameter.span(this.coastContinentalness, this.farInlandContinentalness), this.erosions[6], weirdness, 0.0F, biome1);
			}
		}
	}

	private void addMidSlice(Consumer<Pair<Climate.ParameterPoint, ResourceKey<Biome>>> builder, Climate.Parameter weirdness) {
		this.addSurfaceBiome(builder, this.FULL_RANGE, this.FULL_RANGE, this.coastContinentalness, Climate.Parameter.span(this.erosions[0], this.erosions[2]), weirdness, 0.0F, Biomes.STONY_SHORE);
		this.addSurfaceBiome(builder, Climate.Parameter.span(this.temperatures[1], this.temperatures[2]), this.FULL_RANGE, Climate.Parameter.span(this.nearInlandContinentalness, this.farInlandContinentalness), this.erosions[6], weirdness, 0.0F, Biomes.SWAMP);
		this.addSurfaceBiome(builder, Climate.Parameter.span(this.temperatures[3], this.temperatures[4]), this.FULL_RANGE, Climate.Parameter.span(this.nearInlandContinentalness, this.farInlandContinentalness), this.erosions[6], weirdness, 0.0F, Biomes.MANGROVE_SWAMP);
		for (int temperatureIndex = 0; temperatureIndex < this.temperatures.length; ++temperatureIndex) {
			Climate.Parameter temperature = this.temperatures[temperatureIndex];
			for (int humidityIndex = 0; humidityIndex < this.humidities.length; ++humidityIndex) {
				Climate.Parameter humidity = this.humidities[humidityIndex];
				ResourceKey<Biome> resourcekey = this.pickMiddleBiome(temperatureIndex, humidityIndex, weirdness);
				ResourceKey<Biome> resourcekey1 = this.pickMiddleBiomeOrBadlandsIfHot(temperatureIndex, humidityIndex, weirdness);
				ResourceKey<Biome> resourcekey2 = this.pickMiddleBiomeOrBadlandsIfHotOrSlopeIfCold(temperatureIndex, humidityIndex, weirdness);
				ResourceKey<Biome> resourcekey3 = this.pickShatteredBiome(temperatureIndex, humidityIndex, weirdness);
				ResourceKey<Biome> resourcekey4 = this.pickPlateauBiome(temperatureIndex, humidityIndex, weirdness);
				ResourceKey<Biome> resourcekey5 = this.pickBeachBiome(temperatureIndex, humidityIndex);
				ResourceKey<Biome> resourcekey6 = this.maybePickWindsweptSavannaBiome(temperatureIndex, humidityIndex, weirdness, resourcekey);
				ResourceKey<Biome> resourcekey7 = this.pickShatteredCoastBiome(temperatureIndex, humidityIndex, weirdness);
				ResourceKey<Biome> resourcekey8 = this.pickSlopeBiome(temperatureIndex, humidityIndex, weirdness);
				this.addSurfaceBiome(builder, temperature, humidity, Climate.Parameter.span(this.nearInlandContinentalness, this.farInlandContinentalness), this.erosions[0], weirdness, 0.0F, resourcekey8);
				this.addSurfaceBiome(builder, temperature, humidity, Climate.Parameter.span(this.nearInlandContinentalness, this.midInlandContinentalness), this.erosions[1], weirdness, 0.0F, resourcekey2);
				this.addSurfaceBiome(builder, temperature, humidity, this.farInlandContinentalness, this.erosions[1], weirdness, 0.0F, temperatureIndex == 0 ? resourcekey8 : resourcekey4);
				this.addSurfaceBiome(builder, temperature, humidity, this.nearInlandContinentalness, this.erosions[2], weirdness, 0.0F, resourcekey);
				this.addSurfaceBiome(builder, temperature, humidity, this.midInlandContinentalness, this.erosions[2], weirdness, 0.0F, resourcekey1);
				this.addSurfaceBiome(builder, temperature, humidity, this.farInlandContinentalness, this.erosions[2], weirdness, 0.0F, resourcekey4);
				this.addSurfaceBiome(builder, temperature, humidity, Climate.Parameter.span(this.coastContinentalness, this.nearInlandContinentalness), this.erosions[3], weirdness, 0.0F, resourcekey);
				this.addSurfaceBiome(builder, temperature, humidity, Climate.Parameter.span(this.midInlandContinentalness, this.farInlandContinentalness), this.erosions[3], weirdness, 0.0F, resourcekey1);
				if (weirdness.max() < 0L) {
					this.addSurfaceBiome(builder, temperature, humidity, this.coastContinentalness, this.erosions[4], weirdness, 0.0F, resourcekey5);
					this.addSurfaceBiome(builder, temperature, humidity, Climate.Parameter.span(this.nearInlandContinentalness, this.farInlandContinentalness), this.erosions[4], weirdness, 0.0F, resourcekey);
				} else {
					this.addSurfaceBiome(builder, temperature, humidity, Climate.Parameter.span(this.coastContinentalness, this.farInlandContinentalness), this.erosions[4], weirdness, 0.0F, resourcekey);
				}
				this.addSurfaceBiome(builder, temperature, humidity, this.coastContinentalness, this.erosions[5], weirdness, 0.0F, resourcekey7);
				this.addSurfaceBiome(builder, temperature, humidity, this.nearInlandContinentalness, this.erosions[5], weirdness, 0.0F, resourcekey6);
				this.addSurfaceBiome(builder, temperature, humidity, Climate.Parameter.span(this.midInlandContinentalness, this.farInlandContinentalness), this.erosions[5], weirdness, 0.0F, resourcekey3);
				if (weirdness.max() < 0L) {
					this.addSurfaceBiome(builder, temperature, humidity, this.coastContinentalness, this.erosions[6], weirdness, 0.0F, resourcekey5);
				} else {
					this.addSurfaceBiome(builder, temperature, humidity, this.coastContinentalness, this.erosions[6], weirdness, 0.0F, resourcekey);
				}
				if (temperatureIndex == 0) {
					this.addSurfaceBiome(builder, temperature, humidity, Climate.Parameter.span(this.nearInlandContinentalness, this.farInlandContinentalness), this.erosions[6], weirdness, 0.0F, resourcekey);
				}
			}
		}
	}

	private void addLowSlice(Consumer<Pair<Climate.ParameterPoint, ResourceKey<Biome>>> builder, Climate.Parameter weirdness) {
		this.addSurfaceBiome(builder, this.FULL_RANGE, this.FULL_RANGE, this.coastContinentalness, Climate.Parameter.span(this.erosions[0], this.erosions[2]), weirdness, 0.0F, Biomes.STONY_SHORE);
		this.addSurfaceBiome(builder, Climate.Parameter.span(this.temperatures[1], this.temperatures[2]), this.FULL_RANGE, Climate.Parameter.span(this.nearInlandContinentalness, this.farInlandContinentalness), this.erosions[6], weirdness, 0.0F, Biomes.SWAMP);
		this.addSurfaceBiome(builder, Climate.Parameter.span(this.temperatures[3], this.temperatures[4]), this.FULL_RANGE, Climate.Parameter.span(this.nearInlandContinentalness, this.farInlandContinentalness), this.erosions[6], weirdness, 0.0F, Biomes.MANGROVE_SWAMP);
		for (int temperatureIndex = 0; temperatureIndex < this.temperatures.length; ++temperatureIndex) {
			Climate.Parameter temperature = this.temperatures[temperatureIndex];
			for (int humidityIndex = 0; humidityIndex < this.humidities.length; ++humidityIndex) {
				Climate.Parameter humidity = this.humidities[humidityIndex];
				ResourceKey<Biome> resourcekey = this.pickMiddleBiome(temperatureIndex, humidityIndex, weirdness);
				ResourceKey<Biome> resourcekey1 = this.pickMiddleBiomeOrBadlandsIfHot(temperatureIndex, humidityIndex, weirdness);
				ResourceKey<Biome> resourcekey2 = this.pickMiddleBiomeOrBadlandsIfHotOrSlopeIfCold(temperatureIndex, humidityIndex, weirdness);
				ResourceKey<Biome> resourcekey3 = this.pickBeachBiome(temperatureIndex, humidityIndex);
				ResourceKey<Biome> resourcekey4 = this.maybePickWindsweptSavannaBiome(temperatureIndex, humidityIndex, weirdness, resourcekey);
				ResourceKey<Biome> resourcekey5 = this.pickShatteredCoastBiome(temperatureIndex, humidityIndex, weirdness);
				this.addSurfaceBiome(builder, temperature, humidity, this.nearInlandContinentalness, Climate.Parameter.span(this.erosions[0], this.erosions[1]), weirdness, 0.0F, resourcekey1);
				this.addSurfaceBiome(builder, temperature, humidity, Climate.Parameter.span(this.midInlandContinentalness, this.farInlandContinentalness), Climate.Parameter.span(this.erosions[0], this.erosions[1]), weirdness, 0.0F, resourcekey2);
				this.addSurfaceBiome(builder, temperature, humidity, this.nearInlandContinentalness, Climate.Parameter.span(this.erosions[2], this.erosions[3]), weirdness, 0.0F, resourcekey);
				this.addSurfaceBiome(builder, temperature, humidity, Climate.Parameter.span(this.midInlandContinentalness, this.farInlandContinentalness), Climate.Parameter.span(this.erosions[2], this.erosions[3]), weirdness, 0.0F, resourcekey1);
				this.addSurfaceBiome(builder, temperature, humidity, this.coastContinentalness, Climate.Parameter.span(this.erosions[3], this.erosions[4]), weirdness, 0.0F, resourcekey3);
				this.addSurfaceBiome(builder, temperature, humidity, Climate.Parameter.span(this.nearInlandContinentalness, this.farInlandContinentalness), this.erosions[4], weirdness, 0.0F, resourcekey);
				this.addSurfaceBiome(builder, temperature, humidity, this.coastContinentalness, this.erosions[5], weirdness, 0.0F, resourcekey5);
				this.addSurfaceBiome(builder, temperature, humidity, this.nearInlandContinentalness, this.erosions[5], weirdness, 0.0F, resourcekey4);
				this.addSurfaceBiome(builder, temperature, humidity, Climate.Parameter.span(this.midInlandContinentalness, this.farInlandContinentalness), this.erosions[5], weirdness, 0.0F, resourcekey);
				this.addSurfaceBiome(builder, temperature, humidity, this.coastContinentalness, this.erosions[6], weirdness, 0.0F, resourcekey3);
				if (temperatureIndex == 0) {
					this.addSurfaceBiome(builder, temperature, humidity, Climate.Parameter.span(this.nearInlandContinentalness, this.farInlandContinentalness), this.erosions[6], weirdness, 0.0F, resourcekey);
				}
			}
		}
	}

	private void addValleys(Consumer<Pair<Climate.ParameterPoint, ResourceKey<Biome>>> builder, Climate.Parameter weirdness) {
		this.addSurfaceBiome(builder, this.FROZEN_RANGE, this.FULL_RANGE, this.coastContinentalness, Climate.Parameter.span(this.erosions[0], this.erosions[1]), weirdness, 0.0F, weirdness.max() < 0L ? Biomes.STONY_SHORE : Biomes.FROZEN_RIVER);
		this.addSurfaceBiome(builder, this.UNFROZEN_RANGE, this.FULL_RANGE, this.coastContinentalness, Climate.Parameter.span(this.erosions[0], this.erosions[1]), weirdness, 0.0F, weirdness.max() < 0L ? Biomes.STONY_SHORE : Biomes.RIVER);
		this.addSurfaceBiome(builder, this.FROZEN_RANGE, this.FULL_RANGE, this.nearInlandContinentalness, Climate.Parameter.span(this.erosions[0], this.erosions[1]), weirdness, 0.0F, Biomes.FROZEN_RIVER);
		this.addSurfaceBiome(builder, this.UNFROZEN_RANGE, this.FULL_RANGE, this.nearInlandContinentalness, Climate.Parameter.span(this.erosions[0], this.erosions[1]), weirdness, 0.0F, Biomes.RIVER);
		this.addSurfaceBiome(builder, this.FROZEN_RANGE, this.FULL_RANGE, Climate.Parameter.span(this.coastContinentalness, this.farInlandContinentalness), Climate.Parameter.span(this.erosions[2], this.erosions[5]), weirdness, 0.0F, Biomes.FROZEN_RIVER);
		this.addSurfaceBiome(builder, this.UNFROZEN_RANGE, this.FULL_RANGE, Climate.Parameter.span(this.coastContinentalness, this.farInlandContinentalness), Climate.Parameter.span(this.erosions[2], this.erosions[5]), weirdness, 0.0F, Biomes.RIVER);
		this.addSurfaceBiome(builder, this.FROZEN_RANGE, this.FULL_RANGE, this.coastContinentalness, this.erosions[6], weirdness, 0.0F, Biomes.FROZEN_RIVER);
		this.addSurfaceBiome(builder, this.UNFROZEN_RANGE, this.FULL_RANGE, this.coastContinentalness, this.erosions[6], weirdness, 0.0F, Biomes.RIVER);
		this.addSurfaceBiome(builder, Climate.Parameter.span(this.temperatures[1], this.temperatures[2]), this.FULL_RANGE, Climate.Parameter.span(this.inlandContinentalness, this.farInlandContinentalness), this.erosions[6], weirdness, 0.0F, Biomes.SWAMP);
		this.addSurfaceBiome(builder, Climate.Parameter.span(this.temperatures[3], this.temperatures[4]), this.FULL_RANGE, Climate.Parameter.span(this.inlandContinentalness, this.farInlandContinentalness), this.erosions[6], weirdness, 0.0F, Biomes.MANGROVE_SWAMP);
		this.addSurfaceBiome(builder, this.FROZEN_RANGE, this.FULL_RANGE, Climate.Parameter.span(this.inlandContinentalness, this.farInlandContinentalness), this.erosions[6], weirdness, 0.0F, Biomes.FROZEN_RIVER);
		for (int temperatureIndex = 0; temperatureIndex < this.temperatures.length; ++temperatureIndex) {
			Climate.Parameter temperature = this.temperatures[temperatureIndex];
			for (int humidityIndex = 0; humidityIndex < this.humidities.length; ++humidityIndex) {
				Climate.Parameter humidity = this.humidities[humidityIndex];
				ResourceKey<Biome> resourcekey = this.pickMiddleBiomeOrBadlandsIfHot(temperatureIndex, humidityIndex, weirdness);
				this.addSurfaceBiome(builder, temperature, humidity, Climate.Parameter.span(this.midInlandContinentalness, this.farInlandContinentalness), Climate.Parameter.span(this.erosions[0], this.erosions[1]), weirdness, 0.0F, resourcekey);
			}
		}
	}

	private ResourceKey<Biome> pickMiddleBiome(int temperature, int humidity, Climate.Parameter weirdness) {
		if (weirdness.max() < 0L) {
			return this.MIDDLE_BIOMES[temperature][humidity];
		} else {
			ResourceKey<Biome> resourcekey = this.MIDDLE_BIOMES_VARIANT[temperature][humidity];
			return resourcekey == null ? this.MIDDLE_BIOMES[temperature][humidity] : resourcekey;
		}
	}

	private ResourceKey<Biome> pickMiddleBiomeOrBadlandsIfHot(int temperature, int humidity, Climate.Parameter weirdness) {
		return temperature == 4 ? this.pickBadlandsBiome(humidity, weirdness) : this.pickMiddleBiome(temperature, humidity, weirdness);
	}

	private ResourceKey<Biome> pickMiddleBiomeOrBadlandsIfHotOrSlopeIfCold(int p_187212_, int p_187213_, Climate.Parameter p_187214_) {
		return p_187212_ == 0 ? this.pickSlopeBiome(p_187212_, p_187213_, p_187214_) : this.pickMiddleBiomeOrBadlandsIfHot(p_187212_, p_187213_, p_187214_);
	}

	private ResourceKey<Biome> maybePickWindsweptSavannaBiome(int p_201991_, int p_201992_, Climate.Parameter p_201993_, ResourceKey<Biome> p_201994_) {
		return p_201991_ > 1 && p_201992_ < 4 && p_201993_.max() >= 0L ? Biomes.WINDSWEPT_SAVANNA : p_201994_;
	}

	private ResourceKey<Biome> pickShatteredCoastBiome(int p_187223_, int p_187224_, Climate.Parameter p_187225_) {
		ResourceKey<Biome> resourcekey = p_187225_.max() >= 0L ? this.pickMiddleBiome(p_187223_, p_187224_, p_187225_) : this.pickBeachBiome(p_187223_, p_187224_);
		return this.maybePickWindsweptSavannaBiome(p_187223_, p_187224_, p_187225_, resourcekey);
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
			ResourceKey<Biome> resourcekey = this.PLATEAU_BIOMES_VARIANT[p_187234_][p_187235_];
			if (resourcekey != null) {
				return resourcekey;
			}
		}

		return this.PLATEAU_BIOMES[p_187234_][p_187235_];
	}

	private ResourceKey<Biome> pickPeakBiome(int p_187241_, int p_187242_, Climate.Parameter p_187243_) {
		if (p_187241_ <= 2) {
			return p_187243_.max() < 0L ? Biomes.JAGGED_PEAKS : Biomes.FROZEN_PEAKS;
		} else {
			return p_187241_ == 3 ? Biomes.STONY_PEAKS : this.pickBadlandsBiome(p_187242_, p_187243_);
		}
	}

	private ResourceKey<Biome> pickSlopeBiome(int p_187245_, int p_187246_, Climate.Parameter p_187247_) {
		if (p_187245_ >= 3) {
			return this.pickPlateauBiome(p_187245_, p_187246_, p_187247_);
		} else {
			return p_187246_ <= 1 ? Biomes.SNOWY_SLOPES : Biomes.GROVE;
		}
	}

	private ResourceKey<Biome> pickShatteredBiome(int p_202002_, int p_202003_, Climate.Parameter p_202004_) {
		ResourceKey<Biome> resourcekey = this.SHATTERED_BIOMES[p_202002_][p_202003_];
		return resourcekey == null ? this.pickMiddleBiome(p_202002_, p_202003_, p_202004_) : resourcekey;
	}

	private void addSurfaceBiome(Consumer<Pair<Climate.ParameterPoint, ResourceKey<Biome>>> builder, Climate.Parameter temperature, Climate.Parameter humidity, Climate.Parameter continentalness, Climate.Parameter erosion, Climate.Parameter weirdness, float offset, ResourceKey<Biome> biome) {
		builder.accept(Pair.of(Climate.parameters(temperature, humidity, continentalness, erosion, Climate.Parameter.point(0.0F), weirdness, offset), biome));
		builder.accept(Pair.of(Climate.parameters(temperature, humidity, continentalness, erosion, Climate.Parameter.point(1.0F), weirdness, offset), biome));
	}

	private void addUndergroundBiome(Consumer<Pair<Climate.ParameterPoint, ResourceKey<Biome>>> builder, Climate.Parameter temperature, Climate.Parameter humidity, Climate.Parameter continentalness, Climate.Parameter erosion, Climate.Parameter weirdness, float offset, ResourceKey<Biome> biome) {
		builder.accept(Pair.of(Climate.parameters(temperature, humidity, continentalness, erosion, Climate.Parameter.span(0.2F, 0.9F), weirdness, offset), biome));
	}

	private void addBottomBiome(Consumer<Pair<Climate.ParameterPoint, ResourceKey<Biome>>> builder, Climate.Parameter temperature, Climate.Parameter humidity, Climate.Parameter continentalness, Climate.Parameter erosion, Climate.Parameter weirdness, float offset, ResourceKey<Biome> biome) {
		builder.accept(Pair.of(Climate.parameters(temperature, humidity, continentalness, erosion, Climate.Parameter.point(1.1F), weirdness, offset), biome));
	}

	public static boolean isDeepDarkRegion(DensityFunction p_252040_, DensityFunction p_250447_, DensityFunction.FunctionContext p_249270_) {
		return p_252040_.compute(p_249270_) < -0.225F && p_250447_.compute(p_249270_) > 0.9F;
	}

	public static String getDebugStringForPeaksAndValleys(double p_187156_) {
		if (p_187156_ < NoiseRouterData.peaksAndValleys(0.05F)) {
			return "Valley";
		} else if (p_187156_ < NoiseRouterData.peaksAndValleys(0.26666668F)) {
			return "Low";
		} else if (p_187156_ < NoiseRouterData.peaksAndValleys(0.4F)) {
			return "Mid";
		} else {
			return p_187156_ < NoiseRouterData.peaksAndValleys(0.56666666F) ? "High" : "Peak";
		}
	}

	public String getDebugStringForContinentalness(double p_187190_) {
		double d0 = Climate.quantizeCoord((float) p_187190_);
		if (d0 < this.mushroomFieldsContinentalness.max()) {
			return "Mushroom fields";
		} else if (d0 < this.deepOceanContinentalness.max()) {
			return "Deep ocean";
		} else if (d0 < this.oceanContinentalness.max()) {
			return "Ocean";
		} else if (d0 < this.coastContinentalness.max()) {
			return "Coast";
		} else if (d0 < this.nearInlandContinentalness.max()) {
			return "Near inland";
		} else {
			return d0 < this.midInlandContinentalness.max() ? "Mid inland" : "Far inland";
		}
	}

	public String getDebugStringForErosion(double p_187210_) {
		return getDebugStringForNoiseValue(p_187210_, this.erosions);
	}

	public String getDebugStringForTemperature(double p_187221_) {
		return getDebugStringForNoiseValue(p_187221_, this.temperatures);
	}

	public String getDebugStringForHumidity(double p_187232_) {
		return getDebugStringForNoiseValue(p_187232_, this.humidities);
	}

	private static String getDebugStringForNoiseValue(double p_187158_, Climate.Parameter[] p_187159_) {
		double d0 = Climate.quantizeCoord((float) p_187158_);

		for (int i = 0; i < p_187159_.length; ++i) {
			if (d0 < p_187159_[i].max()) {
				return "" + i;
			}
		}

		return "?";
	}

	@VisibleForDebug
	public Climate.Parameter[] getTemperatureThresholds() {
		return this.temperatures;
	}

	@VisibleForDebug
	public Climate.Parameter[] getHumidityThresholds() {
		return this.humidities;
	}

	@VisibleForDebug
	public Climate.Parameter[] getErosionThresholds() {
		return this.erosions;
	}

	@VisibleForDebug
	public Climate.Parameter[] getContinentalnessThresholds() {
		return new Climate.Parameter[] { this.mushroomFieldsContinentalness, this.deepOceanContinentalness, this.oceanContinentalness, this.coastContinentalness, this.nearInlandContinentalness, this.midInlandContinentalness, this.farInlandContinentalness };
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