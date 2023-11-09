package com.technologica.datagen.data.worldgen.noisesettings;

import java.util.List;
import java.util.stream.Stream;

import com.technologica.datagen.data.worldgen.TechnologicaSurfaceRuleData;
import com.technologica.world.level.block.TechnologicaBlocks;
import com.technologica.world.level.levelgen.TechnologicaNoiseGeneratorSettings;

import net.minecraft.core.HolderGetter;
import net.minecraft.core.registries.Registries;
import net.minecraft.data.worldgen.BootstapContext;
import net.minecraft.resources.ResourceKey;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.level.biome.Climate;
import net.minecraft.world.level.block.Blocks;
import net.minecraft.world.level.block.state.BlockState;
import net.minecraft.world.level.dimension.DimensionType;
import net.minecraft.world.level.levelgen.DensityFunction;
import net.minecraft.world.level.levelgen.DensityFunctions;
import net.minecraft.world.level.levelgen.NoiseGeneratorSettings;
import net.minecraft.world.level.levelgen.NoiseRouter;
import net.minecraft.world.level.levelgen.NoiseSettings;
import net.minecraft.world.level.levelgen.Noises;
import net.minecraft.world.level.levelgen.SurfaceRules;
import net.minecraft.world.level.levelgen.synth.NormalNoise;

public class NoiseSettingsDataGenerator {
	/**
	 * <p>
	 * This method registers a Resource Key and Noise Generator Settings to the Noise Settings Registry.
	 * The structure of the Noise Generator Settings methods are a slight departure from the vanilla counterpart with the intent being ease of use.
	 * <p>
	 * 
	 * @param bootstrapContextIn of type NoiseGeneratorSettings
	 */
	public static void bootstrap(BootstapContext<NoiseGeneratorSettings> bootstrapContextIn) {
		bootstrapContextIn.register(TechnologicaNoiseGeneratorSettings.MOON, moon(bootstrapContextIn));
		bootstrapContextIn.register(TechnologicaNoiseGeneratorSettings.CHALLENGER_DEEP, challengerDeep(bootstrapContextIn));
		bootstrapContextIn.register(TechnologicaNoiseGeneratorSettings.OVERGROWTH, overgrowth(bootstrapContextIn));
	}

	/**
	 * <p>
	 * This method controls the contents of the Noise Settings json file for the Moon.
	 * Variables are defined in the order they will appear in the json file.
	 * <p>
	 * 
	 * @param bootstrapContextIn of type NoiseGeneratorSettings
	 * @return NoiseGeneratorSettings for the Moon
	 */
	private static NoiseGeneratorSettings moon(BootstapContext<?> bootstrapContextIn) {
		boolean aquifersEnabled = false;
		BlockState defaultBlock = TechnologicaBlocks.MOON_ROCK.get().defaultBlockState();
		BlockState defaultFluid = Blocks.WATER.defaultBlockState();
		boolean disabledMobGeneration = false;
		boolean legacyRandomSource = false;
		NoiseSettings noise = TechnologicaNoiseSettings.MOON_NOISE_SETTINGS;
		NoiseRouter noiseRouter = NoiseRouterData.moon(bootstrapContextIn.lookup(Registries.DENSITY_FUNCTION), bootstrapContextIn.lookup(Registries.NOISE), true, true);
		boolean oreVeinsEnabled = false;
		int seaLevel = -64;
		List<Climate.ParameterPoint> spawnTarget = List.of();
		SurfaceRules.RuleSource surfaceRule = TechnologicaSurfaceRuleData.moon();

		return new NoiseGeneratorSettings(noise, defaultBlock, defaultFluid, noiseRouter, surfaceRule, spawnTarget, seaLevel, disabledMobGeneration, aquifersEnabled, oreVeinsEnabled, legacyRandomSource);
	}

	/**
	 * <p>
	 * This method controls the contents of the Noise Settings json file for the Challenger Deep.
	 * Variables are defined in the order they will appear in the json file.
	 * <p>
	 * 
	 * @param bootstrapContextIn of type NoiseGeneratorSettings
	 * @return NoiseGeneratorSettings for the Challenger Deep
	 */
	private static NoiseGeneratorSettings challengerDeep(BootstapContext<?> bootstrapContextIn) {
		boolean aquifersEnabled = false;
		BlockState defaultBlock = Blocks.STONE.defaultBlockState();
		BlockState defaultFluid = Blocks.WATER.defaultBlockState();
		boolean disabledMobGeneration = false;
		boolean legacyRandomSource = false;
		NoiseSettings noise = TechnologicaNoiseSettings.CHALLENGER_DEEP_NOISE_SETTINGS;
		NoiseRouter noiseRouter = NoiseRouterData.challengerDeep(bootstrapContextIn.lookup(Registries.DENSITY_FUNCTION), bootstrapContextIn.lookup(Registries.NOISE));
		boolean oreVeinsEnabled = false;
		int seaLevel = 384;
		List<Climate.ParameterPoint> spawnTarget = List.of();
		SurfaceRules.RuleSource surfaceRule = TechnologicaSurfaceRuleData.challengerDeep();

		return new NoiseGeneratorSettings(noise, defaultBlock, defaultFluid, noiseRouter, surfaceRule, spawnTarget, seaLevel, disabledMobGeneration, aquifersEnabled, oreVeinsEnabled, legacyRandomSource);
	}

	/**
	 * <p>
	 * This method controls the contents of the Noise Settings json file for the Overgrowth.
	 * Variables are defined in the order they will appear in the json file.
	 * <p>
	 * 
	 * @param bootstrapContextIn of type NoiseGeneratorSettings
	 * @return NoiseGeneratorSettings for the Overgrowth
	 */
	private static NoiseGeneratorSettings overgrowth(BootstapContext<?> bootstrapContextIn) {
		boolean aquifersEnabled = false;
		BlockState defaultBlock = Blocks.DIRT.defaultBlockState();
		BlockState defaultFluid = Blocks.WATER.defaultBlockState();
		boolean disabledMobGeneration = false;
		boolean legacyRandomSource = false;
		NoiseSettings noise = TechnologicaNoiseSettings.OVERGROWTH_NOISE_SETTINGS;
		NoiseRouter noiseRouter = NoiseRouterData.challengerDeep(bootstrapContextIn.lookup(Registries.DENSITY_FUNCTION), bootstrapContextIn.lookup(Registries.NOISE));
		boolean oreVeinsEnabled = false;
		int seaLevel = 32;
		List<Climate.ParameterPoint> spawnTarget = List.of();
		SurfaceRules.RuleSource surfaceRule = TechnologicaSurfaceRuleData.overgrowth();

		return new NoiseGeneratorSettings(noise, defaultBlock, defaultFluid, noiseRouter, surfaceRule, spawnTarget, seaLevel, disabledMobGeneration, aquifersEnabled, oreVeinsEnabled, legacyRandomSource);
	}

	private class TechnologicaNoiseSettings {

		protected static final NoiseSettings MOON_NOISE_SETTINGS = moon();
		protected static final NoiseSettings CHALLENGER_DEEP_NOISE_SETTINGS = challengerDeep();
		protected static final NoiseSettings OVERGROWTH_NOISE_SETTINGS = overgrowth();

		/**
		 * <p>
		 * This method controls the contents of the noise property to be nested within the Noise Settings json file for the Moon.
		 * Variables are defined in the order they will appear in the json file.
		 * <p>
		 * 
		 * @return NoiseSettings for the Moon
		 */
		private static NoiseSettings moon() {
			int height = 384;
			int minY = -64;
			int sizeHorizontal = 1;
			int sizeVertical = 2;

			return NoiseSettings.create(minY, height, sizeHorizontal, sizeVertical);
		}

		/**
		 * <p>
		 * This method controls the contents of the noise property to be nested within the Noise Settings json file for the Challenger Deep.
		 * Variables are defined in the order they will appear in the json file.
		 * <p>
		 * 
		 * @return NoiseSettings for the Challenger Deep
		 */
		private static NoiseSettings challengerDeep() {
			int height = 384;
			int minY = -64;
			int sizeHorizontal = 1;
			int sizeVertical = 2;

			return NoiseSettings.create(minY, height, sizeHorizontal, sizeVertical);
		}

		/**
		 * <p>
		 * This method controls the contents of the noise property to be nested within the Noise Settings json file for the Overgrowth.
		 * Variables are defined in the order they will appear in the json file.
		 * <p>
		 * 
		 * @return NoiseSettings for the Overgrowth
		 */
		private static NoiseSettings overgrowth() {
			int height = 128;
			int minY = 0;
			int sizeHorizontal = 1;
			int sizeVertical = 2;

			return NoiseSettings.create(minY, height, sizeHorizontal, sizeVertical);
		}
	}

	private class NoiseRouterData {
		public static final float GLOBAL_OFFSET = -0.50375F;
		public static final int ISLAND_CHUNK_DISTANCE = 64;
		public static final long ISLAND_CHUNK_DISTANCE_SQR = 4096L;
		private static final ResourceKey<DensityFunction> Y = createKey("y");
		private static final ResourceKey<DensityFunction> SHIFT_X = createKey("shift_x");
		private static final ResourceKey<DensityFunction> SHIFT_Z = createKey("shift_z");
		public static final ResourceKey<DensityFunction> CONTINENTS = createKey("overworld/continents");
		private static final ResourceKey<DensityFunction> BASE_3D_NOISE_NETHER = createKey("nether/base_3d_noise");
		public static final ResourceKey<DensityFunction> EROSION = createKey("overworld/erosion");
		public static final ResourceKey<DensityFunction> RIDGES = createKey("overworld/ridges");
		public static final ResourceKey<DensityFunction> RIDGES_FOLDED = createKey("overworld/ridges_folded");
		public static final ResourceKey<DensityFunction> OFFSET = createKey("overworld/offset");
		public static final ResourceKey<DensityFunction> FACTOR = createKey("overworld/factor");
		public static final ResourceKey<DensityFunction> JAGGEDNESS = createKey("overworld/jaggedness");
		public static final ResourceKey<DensityFunction> DEPTH = createKey("overworld/depth");
		private static final ResourceKey<DensityFunction> SLOPED_CHEESE = createKey("overworld/sloped_cheese");
		public static final ResourceKey<DensityFunction> CONTINENTS_LARGE = createKey("overworld_large_biomes/continents");
		public static final ResourceKey<DensityFunction> EROSION_LARGE = createKey("overworld_large_biomes/erosion");
		private static final ResourceKey<DensityFunction> FACTOR_LARGE = createKey("overworld_large_biomes/factor");
		private static final ResourceKey<DensityFunction> DEPTH_LARGE = createKey("overworld_large_biomes/depth");
		private static final ResourceKey<DensityFunction> SLOPED_CHEESE_LARGE = createKey("overworld_large_biomes/sloped_cheese");
		private static final ResourceKey<DensityFunction> FACTOR_AMPLIFIED = createKey("overworld_amplified/factor");
		private static final ResourceKey<DensityFunction> DEPTH_AMPLIFIED = createKey("overworld_amplified/depth");
		private static final ResourceKey<DensityFunction> SLOPED_CHEESE_AMPLIFIED = createKey("overworld_amplified/sloped_cheese");
		private static final ResourceKey<DensityFunction> SPAGHETTI_ROUGHNESS_FUNCTION = createKey("overworld/caves/spaghetti_roughness_function");
		private static final ResourceKey<DensityFunction> ENTRANCES = createKey("overworld/caves/entrances");
		private static final ResourceKey<DensityFunction> NOODLE = createKey("overworld/caves/noodle");
		private static final ResourceKey<DensityFunction> PILLARS = createKey("overworld/caves/pillars");
		private static final ResourceKey<DensityFunction> SPAGHETTI_2D = createKey("overworld/caves/spaghetti_2d");

		private static ResourceKey<DensityFunction> createKey(String p_209537_) {
			return ResourceKey.create(Registries.DENSITY_FUNCTION, new ResourceLocation(p_209537_));
		}

		private static DensityFunction getFunction(HolderGetter<DensityFunction> p_256312_, ResourceKey<DensityFunction> p_256077_) {
			return new DensityFunctions.HolderHolder(p_256312_.getOrThrow(p_256077_));
		}

		private static DensityFunction underground(HolderGetter<DensityFunction> p_256548_, HolderGetter<NormalNoise.NoiseParameters> p_256236_, DensityFunction p_256658_) {
			DensityFunction densityfunction = getFunction(p_256548_, SPAGHETTI_2D);
			DensityFunction densityfunction1 = getFunction(p_256548_, SPAGHETTI_ROUGHNESS_FUNCTION);
			DensityFunction densityfunction2 = DensityFunctions.noise(p_256236_.getOrThrow(Noises.CAVE_LAYER), 8.0D);
			DensityFunction densityfunction3 = DensityFunctions.mul(DensityFunctions.constant(4.0D), densityfunction2.square());
			DensityFunction densityfunction4 = DensityFunctions.noise(p_256236_.getOrThrow(Noises.CAVE_CHEESE), 0.6666666666666666D);
			DensityFunction densityfunction5 = DensityFunctions.add(DensityFunctions.add(DensityFunctions.constant(0.27D), densityfunction4).clamp(-1.0D, 1.0D), DensityFunctions.add(DensityFunctions.constant(1.5D), DensityFunctions.mul(DensityFunctions.constant(-0.64D), p_256658_)).clamp(0.0D, 0.5D));
			DensityFunction densityfunction6 = DensityFunctions.add(densityfunction3, densityfunction5);
			DensityFunction densityfunction7 = DensityFunctions.min(DensityFunctions.min(densityfunction6, getFunction(p_256548_, ENTRANCES)), DensityFunctions.add(densityfunction, densityfunction1));
			DensityFunction densityfunction8 = getFunction(p_256548_, PILLARS);
			DensityFunction densityfunction9 = DensityFunctions.rangeChoice(densityfunction8, -1000000.0D, 0.03D, DensityFunctions.constant(-1000000.0D), densityfunction8);
			return DensityFunctions.max(densityfunction7, densityfunction9);
		}

		private static DensityFunction postProcess(DensityFunction p_224493_) {
			DensityFunction densityfunction = DensityFunctions.blendDensity(p_224493_);
			return DensityFunctions.mul(DensityFunctions.interpolated(densityfunction), DensityFunctions.constant(0.64D)).squeeze();
		}

		protected static NoiseRouter moon(HolderGetter<DensityFunction> p_255681_, HolderGetter<NormalNoise.NoiseParameters> p_256005_, boolean p_255649_, boolean p_255617_) {
			DensityFunction densityfunction = DensityFunctions.noise(p_256005_.getOrThrow(Noises.AQUIFER_BARRIER), 0.5D);
			DensityFunction densityfunction1 = DensityFunctions.noise(p_256005_.getOrThrow(Noises.AQUIFER_FLUID_LEVEL_FLOODEDNESS), 0.67D);
			DensityFunction densityfunction2 = DensityFunctions.noise(p_256005_.getOrThrow(Noises.AQUIFER_FLUID_LEVEL_SPREAD), 0.7142857142857143D);
			DensityFunction densityfunction3 = DensityFunctions.noise(p_256005_.getOrThrow(Noises.AQUIFER_LAVA));
			DensityFunction densityfunction4 = getFunction(p_255681_, SHIFT_X);
			DensityFunction densityfunction5 = getFunction(p_255681_, SHIFT_Z);
			DensityFunction densityfunction6 = DensityFunctions.shiftedNoise2d(densityfunction4, densityfunction5, 0.25D, p_256005_.getOrThrow(p_255649_ ? Noises.TEMPERATURE_LARGE : Noises.TEMPERATURE));
			DensityFunction densityfunction7 = DensityFunctions.shiftedNoise2d(densityfunction4, densityfunction5, 0.25D, p_256005_.getOrThrow(p_255649_ ? Noises.VEGETATION_LARGE : Noises.VEGETATION));
			DensityFunction densityfunction8 = getFunction(p_255681_, p_255649_ ? FACTOR_LARGE : (p_255617_ ? FACTOR_AMPLIFIED : FACTOR));
			DensityFunction densityfunction9 = getFunction(p_255681_, p_255649_ ? DEPTH_LARGE : (p_255617_ ? DEPTH_AMPLIFIED : DEPTH));
			DensityFunction densityfunction10 = noiseGradientDensity(DensityFunctions.cache2d(densityfunction8), densityfunction9);
			DensityFunction densityfunction11 = getFunction(p_255681_, p_255649_ ? SLOPED_CHEESE_LARGE : (p_255617_ ? SLOPED_CHEESE_AMPLIFIED : SLOPED_CHEESE));
			DensityFunction densityfunction12 = DensityFunctions.min(densityfunction11, DensityFunctions.mul(DensityFunctions.constant(5.0D), getFunction(p_255681_, ENTRANCES)));
			DensityFunction densityfunction13 = DensityFunctions.rangeChoice(densityfunction11, -1000000.0D, 1.5625D, densityfunction12, underground(p_255681_, p_256005_, densityfunction11));
			DensityFunction densityfunction14 = DensityFunctions.min(postProcess(slideOverworld(p_255617_, densityfunction13)), getFunction(p_255681_, NOODLE));
			DensityFunction densityfunction15 = getFunction(p_255681_, Y);
			int i = Stream.of(OreVeinifier.VeinType.values()).mapToInt((p_224495_) -> {
				return p_224495_.minY;
			}).min().orElse(-DimensionType.MIN_Y * 2);
			int j = Stream.of(OreVeinifier.VeinType.values()).mapToInt((p_224457_) -> {
				return p_224457_.maxY;
			}).max().orElse(-DimensionType.MIN_Y * 2);
			DensityFunction densityfunction16 = yLimitedInterpolatable(densityfunction15, DensityFunctions.noise(p_256005_.getOrThrow(Noises.ORE_VEININESS), 1.5D, 1.5D), i, j, 0);
			DensityFunction densityfunction17 = yLimitedInterpolatable(densityfunction15, DensityFunctions.noise(p_256005_.getOrThrow(Noises.ORE_VEIN_A), 4.0D, 4.0D), i, j, 0).abs();
			DensityFunction densityfunction18 = yLimitedInterpolatable(densityfunction15, DensityFunctions.noise(p_256005_.getOrThrow(Noises.ORE_VEIN_B), 4.0D, 4.0D), i, j, 0).abs();
			DensityFunction densityfunction19 = DensityFunctions.add(DensityFunctions.constant(-0.08F), DensityFunctions.max(densityfunction17, densityfunction18));
			DensityFunction densityfunction20 = DensityFunctions.noise(p_256005_.getOrThrow(Noises.ORE_GAP));
			return new NoiseRouter(densityfunction, densityfunction1, densityfunction2, densityfunction3, densityfunction6, densityfunction7, getFunction(p_255681_, p_255649_ ? CONTINENTS_LARGE : CONTINENTS), getFunction(p_255681_, p_255649_ ? EROSION_LARGE : EROSION), densityfunction9, getFunction(p_255681_, RIDGES), slideOverworld(p_255617_, DensityFunctions.add(densityfunction10, DensityFunctions.constant(-0.703125D)).clamp(-64.0D, 64.0D)), densityfunction14, densityfunction16, densityfunction19, densityfunction20);
		}

		protected static NoiseRouter challengerDeep(HolderGetter<DensityFunction> p_255724_, HolderGetter<NormalNoise.NoiseParameters> p_255986_, DensityFunction p_256378_) {
			DensityFunction densityfunction = getFunction(p_255724_, SHIFT_X);
			DensityFunction densityfunction1 = getFunction(p_255724_, SHIFT_Z);
			DensityFunction densityfunction2 = DensityFunctions.shiftedNoise2d(densityfunction, densityfunction1, 0.25D, p_255986_.getOrThrow(Noises.TEMPERATURE));
			DensityFunction densityfunction3 = DensityFunctions.shiftedNoise2d(densityfunction, densityfunction1, 0.25D, p_255986_.getOrThrow(Noises.VEGETATION));
			DensityFunction densityfunction4 = postProcess(p_256378_);
			return new NoiseRouter(DensityFunctions.zero(), DensityFunctions.zero(), DensityFunctions.zero(), DensityFunctions.zero(), densityfunction2, densityfunction3, DensityFunctions.zero(), DensityFunctions.zero(), DensityFunctions.zero(), DensityFunctions.zero(), DensityFunctions.zero(), densityfunction4, DensityFunctions.zero(), DensityFunctions.zero(), DensityFunctions.zero());
		}

		public static NoiseRouter challengerDeep(HolderGetter<DensityFunction> p_255681_, HolderGetter<NormalNoise.NoiseParameters> p_256005_) {
			return challengerDeep(p_255681_, p_256005_, slideNetherLike(p_255681_, 0, 128));
		}

		private static DensityFunction slideOverworld(boolean p_224490_, DensityFunction p_224491_) {
			return slide(p_224491_, -64, 384, p_224490_ ? 16 : 80, p_224490_ ? 0 : 64, -0.078125D, 0, 24, p_224490_ ? 0.4D : 0.1171875D);
		}

		private static DensityFunction slideNetherLike(HolderGetter<DensityFunction> p_256084_, int p_255802_, int p_255834_) {
			return slide(getFunction(p_256084_, BASE_3D_NOISE_NETHER), p_255802_, p_255834_, 24, 0, 0.9375D, -8, 24, 2.5D);
		}

		private static DensityFunction noiseGradientDensity(DensityFunction p_212272_, DensityFunction p_212273_) {
			DensityFunction densityfunction = DensityFunctions.mul(p_212273_, p_212272_);
			return DensityFunctions.mul(DensityFunctions.constant(4.0D), densityfunction.quarterNegative());
		}

		private static DensityFunction yLimitedInterpolatable(DensityFunction p_209472_, DensityFunction p_209473_, int p_209474_, int p_209475_, int p_209476_) {
			return DensityFunctions.interpolated(DensityFunctions.rangeChoice(p_209472_, p_209474_, p_209475_ + 1, p_209473_, DensityFunctions.constant(p_209476_)));
		}

		private static DensityFunction slide(DensityFunction p_224444_, int p_224445_, int p_224446_, int p_224447_, int p_224448_, double p_224449_, int p_224450_, int p_224451_, double p_224452_) {
			DensityFunction densityfunction1 = DensityFunctions.yClampedGradient(p_224445_ + p_224446_ - p_224447_, p_224445_ + p_224446_ - p_224448_, 1.0D, 0.0D);
			DensityFunction $$9 = DensityFunctions.lerp(densityfunction1, p_224449_, p_224444_);
			DensityFunction densityfunction2 = DensityFunctions.yClampedGradient(p_224445_ + p_224450_, p_224445_ + p_224451_, 0.0D, 1.0D);
			return DensityFunctions.lerp(densityfunction2, p_224452_, $$9);
		}

	}

	private class OreVeinifier {
		protected static enum VeinType {
			COPPER(Blocks.COPPER_ORE.defaultBlockState(), Blocks.RAW_COPPER_BLOCK.defaultBlockState(), Blocks.GRANITE.defaultBlockState(), 0, 50), IRON(Blocks.DEEPSLATE_IRON_ORE.defaultBlockState(), Blocks.RAW_IRON_BLOCK.defaultBlockState(), Blocks.TUFF.defaultBlockState(), -60, -8);

			final BlockState ore;
			final BlockState rawOreBlock;
			final BlockState filler;
			protected final int minY;
			protected final int maxY;

			private VeinType(BlockState p_209684_, BlockState p_209685_, BlockState p_209686_, int p_209687_, int p_209688_) {
				this.ore = p_209684_;
				this.rawOreBlock = p_209685_;
				this.filler = p_209686_;
				this.minY = p_209687_;
				this.maxY = p_209688_;
			}
		}
	}
}
