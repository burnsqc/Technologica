package com.technologica.resourcegen.data.worldgen.noisesettings;

import java.util.List;
import java.util.stream.Stream;

import com.technologica.api.tlregen.resourcegen.data.worldgen.TLReGenWorldgenNoiseSettings;
import com.technologica.registration.deferred.TechnologicaBlocks;
import com.technologica.registration.key.TechnologicaNoiseGeneratorSettings;

import net.minecraft.core.HolderGetter;
import net.minecraft.core.registries.Registries;
import net.minecraft.data.worldgen.BootstapContext;
import net.minecraft.resources.ResourceKey;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.level.block.Blocks;
import net.minecraft.world.level.block.state.BlockState;
import net.minecraft.world.level.dimension.DimensionType;
import net.minecraft.world.level.levelgen.DensityFunction;
import net.minecraft.world.level.levelgen.DensityFunctions;
import net.minecraft.world.level.levelgen.NoiseGeneratorSettings;
import net.minecraft.world.level.levelgen.NoiseRouter;
import net.minecraft.world.level.levelgen.Noises;
import net.minecraft.world.level.levelgen.SurfaceRules;
import net.minecraft.world.level.levelgen.VerticalAnchor;
import net.minecraft.world.level.levelgen.synth.NormalNoise;

public class TLWorldgenNoiseSettings extends TLReGenWorldgenNoiseSettings {
	public static void bootstrap(BootstapContext<NoiseGeneratorSettings> noiseSettings) {
		noiseSettings.register(TechnologicaNoiseGeneratorSettings.MOON, noiseSettings(false, TechnologicaBlocks.MOON_ROCK.get().defaultBlockState(), Blocks.WATER.defaultBlockState(), false, false, noise(384, -64, 1, 2), TLNoiseRouterData.moon(noiseSettings.lookup(Registries.DENSITY_FUNCTION), noiseSettings.lookup(Registries.NOISE), true, true), false, -64, List.of(), TLSurfaceRuleData.MOON));
		noiseSettings.register(TechnologicaNoiseGeneratorSettings.CHALLENGER_DEEP, noiseSettings(false, Blocks.STONE.defaultBlockState(), Blocks.WATER.defaultBlockState(), false, false, noise(256, 0, 1, 2), TLNoiseRouterData.noiseRouter(DensityFunctions.zero(), DensityFunctions.zero(), DensityFunctions.zero(), DensityFunctions.zero(), DensityFunctions.mul(DensityFunctions.interpolated(DensityFunctions.blendDensity(DensityFunctions.lerp(DensityFunctions.yClampedGradient(-8, 4, 0.0D, 1.0D), 2.5D, DensityFunctions.lerp(DensityFunctions.yClampedGradient(242, 256, 1.0D, 0.0D), 0.9375D, new DensityFunctions.HolderHolder(noiseSettings.lookup(Registries.DENSITY_FUNCTION).getOrThrow(TLNoiseRouterData.BASE_3D_NOISE_NETHER)))))), DensityFunctions.constant(0.64D)).squeeze(), DensityFunctions.zero(), DensityFunctions.zero(), DensityFunctions.zero(), DensityFunctions.zero(), DensityFunctions.zero(), DensityFunctions.shiftedNoise2d(new DensityFunctions.HolderHolder(noiseSettings.lookup(Registries.DENSITY_FUNCTION).getOrThrow(TLNoiseRouterData.SHIFT_X)), new DensityFunctions.HolderHolder(noiseSettings.lookup(Registries.DENSITY_FUNCTION).getOrThrow(TLNoiseRouterData.SHIFT_Z)), 0.25D, noiseSettings.lookup(Registries.NOISE).getOrThrow(Noises.TEMPERATURE)), DensityFunctions.shiftedNoise2d(new DensityFunctions.HolderHolder(noiseSettings.lookup(Registries.DENSITY_FUNCTION).getOrThrow(TLNoiseRouterData.SHIFT_X)), new DensityFunctions.HolderHolder(noiseSettings.lookup(Registries.DENSITY_FUNCTION).getOrThrow(TLNoiseRouterData.SHIFT_Z)), 0.25D, noiseSettings.lookup(Registries.NOISE).getOrThrow(Noises.VEGETATION)), DensityFunctions.zero(), DensityFunctions.zero(), DensityFunctions.zero()), false, 256, List.of(), TLSurfaceRuleData.CHALLENGER_DEEP));
		noiseSettings.register(TechnologicaNoiseGeneratorSettings.OVERGROWTH, noiseSettings(false, Blocks.DIRT.defaultBlockState(), Blocks.WATER.defaultBlockState(), false, false, noise(128, 0, 1, 2), TLNoiseRouterData.noiseRouter(DensityFunctions.zero(), DensityFunctions.zero(), DensityFunctions.zero(), DensityFunctions.zero(), DensityFunctions.mul(DensityFunctions.interpolated(DensityFunctions.blendDensity(DensityFunctions.lerp(DensityFunctions.yClampedGradient(0 + -8, 0 + 24, 0.0D, 1.0D), 2.5D, DensityFunctions.lerp(DensityFunctions.yClampedGradient(0 + 128 - 24, 0 + 128 - 0, 1.0D, 0.0D), 0.9375D, new DensityFunctions.HolderHolder(noiseSettings.lookup(Registries.DENSITY_FUNCTION).getOrThrow(TLNoiseRouterData.BASE_3D_NOISE_NETHER)))))), DensityFunctions.constant(0.64D)).squeeze(), DensityFunctions.zero(), DensityFunctions.zero(), DensityFunctions.zero(), DensityFunctions.zero(), DensityFunctions.zero(), DensityFunctions.shiftedNoise2d(new DensityFunctions.HolderHolder(noiseSettings.lookup(Registries.DENSITY_FUNCTION).getOrThrow(TLNoiseRouterData.SHIFT_X)), new DensityFunctions.HolderHolder(noiseSettings.lookup(Registries.DENSITY_FUNCTION).getOrThrow(TLNoiseRouterData.SHIFT_Z)), 0.25D, noiseSettings.lookup(Registries.NOISE).getOrThrow(Noises.TEMPERATURE)), DensityFunctions.shiftedNoise2d(new DensityFunctions.HolderHolder(noiseSettings.lookup(Registries.DENSITY_FUNCTION).getOrThrow(TLNoiseRouterData.SHIFT_X)), new DensityFunctions.HolderHolder(noiseSettings.lookup(Registries.DENSITY_FUNCTION).getOrThrow(TLNoiseRouterData.SHIFT_Z)), 0.25D, noiseSettings.lookup(Registries.NOISE).getOrThrow(Noises.VEGETATION)), DensityFunctions.zero(), DensityFunctions.zero(), DensityFunctions.zero()), false, 32, List.of(), TLSurfaceRuleData.OVERGROWTH));
	}

	private class TLSurfaceRuleData {
		private static final SurfaceRules.RuleSource BEDROCK_FLOOR = SurfaceRules.ifTrue(TLReGenWorldgenNoiseSettings.verticalGradient(VerticalAnchor.aboveBottom(5), "bedrock_floor", VerticalAnchor.bottom()), SurfaceRules.state(Blocks.BEDROCK.defaultBlockState()));
		private static final SurfaceRules.RuleSource BEDROCK_ROOF = SurfaceRules.ifTrue(SurfaceRules.not(TLReGenWorldgenNoiseSettings.verticalGradient(VerticalAnchor.top(), "bedrock_roof", VerticalAnchor.belowTop(5))), SurfaceRules.state(Blocks.BEDROCK.defaultBlockState()));
		private static final SurfaceRules.RuleSource GRASS_BLOCK = SurfaceRules.state(Blocks.GRASS_BLOCK.defaultBlockState());
		private static final SurfaceRules.RuleSource DIRT = SurfaceRules.state(Blocks.DIRT.defaultBlockState());
		private static final SurfaceRules.RuleSource STONE = SurfaceRules.state(Blocks.STONE.defaultBlockState());
		private static final SurfaceRules.RuleSource MOON_DUST = SurfaceRules.state(TechnologicaBlocks.MOON_DUST.get().defaultBlockState());
		private static final SurfaceRules.RuleSource MOON = SurfaceRules.sequence(BEDROCK_FLOOR, SurfaceRules.ifTrue(SurfaceRules.abovePreliminarySurface(), SurfaceRules.sequence(SurfaceRules.ifTrue(SurfaceRules.ON_FLOOR, SurfaceRules.ifTrue(SurfaceRules.waterBlockCheck(-1, 0), MOON_DUST)), SurfaceRules.ifTrue(SurfaceRules.waterStartCheck(-6, -1), SurfaceRules.ifTrue(SurfaceRules.UNDER_FLOOR, MOON_DUST)))));
		private static final SurfaceRules.RuleSource CHALLENGER_DEEP = SurfaceRules.sequence(BEDROCK_FLOOR, BEDROCK_ROOF, SurfaceRules.ifTrue(SurfaceRules.yBlockCheck(VerticalAnchor.belowTop(5), 0), STONE), SurfaceRules.ifTrue(SurfaceRules.ON_FLOOR, SurfaceRules.sequence(SurfaceRules.ifTrue(SurfaceRules.not(SurfaceRules.yBlockCheck(VerticalAnchor.absolute(32), 0)), SurfaceRules.ifTrue(SurfaceRules.hole(), STONE)))), STONE);
		private static final SurfaceRules.RuleSource OVERGROWTH = SurfaceRules.sequence(BEDROCK_FLOOR, BEDROCK_ROOF, SurfaceRules.sequence(SurfaceRules.ifTrue(SurfaceRules.ON_FLOOR, SurfaceRules.ifTrue(SurfaceRules.waterBlockCheck(-1, 0), SurfaceRules.sequence(SurfaceRules.ifTrue(SurfaceRules.waterBlockCheck(0, 0), GRASS_BLOCK), DIRT))), SurfaceRules.ifTrue(SurfaceRules.waterStartCheck(-6, -1), SurfaceRules.ifTrue(SurfaceRules.UNDER_FLOOR, DIRT)), SurfaceRules.ifTrue(SurfaceRules.ON_FLOOR, SurfaceRules.sequence(SurfaceRules.ifTrue(SurfaceRules.ON_CEILING, DIRT), DIRT))));
	}

	private class TLNoiseRouterData {
		private static final ResourceKey<DensityFunction> Y = createKey("y");
		private static final ResourceKey<DensityFunction> SHIFT_X = createKey("shift_x");
		private static final ResourceKey<DensityFunction> SHIFT_Z = createKey("shift_z");
		public static final ResourceKey<DensityFunction> CONTINENTS = createKey("overworld/continents");
		private static final ResourceKey<DensityFunction> BASE_3D_NOISE_NETHER = createKey("nether/base_3d_noise");
		public static final ResourceKey<DensityFunction> EROSION = createKey("overworld/erosion");
		public static final ResourceKey<DensityFunction> RIDGES = createKey("overworld/ridges");
		public static final ResourceKey<DensityFunction> FACTOR = createKey("overworld/factor");
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

		private static NoiseRouter noiseRouter(DensityFunction barrier, DensityFunction continents, DensityFunction depth, DensityFunction erosion, DensityFunction finalDensity, DensityFunction fluidLevelFloodedness, DensityFunction fluidLevelSpread, DensityFunction initialDensityWithoutJaggedness, DensityFunction lava, DensityFunction ridges, DensityFunction temperature, DensityFunction vegetation, DensityFunction veinGap, DensityFunction veinRidged, DensityFunction veinToggle) {
			return new NoiseRouter(barrier, fluidLevelFloodedness, fluidLevelSpread, lava, temperature, vegetation, continents, erosion, depth, ridges, initialDensityWithoutJaggedness, finalDensity, veinToggle, veinRidged, veinGap);
		}

		private static ResourceKey<DensityFunction> createKey(String p_209537_) {
			return ResourceKey.create(Registries.DENSITY_FUNCTION, new ResourceLocation(p_209537_));
		}

		private static DensityFunction getFunction(HolderGetter<DensityFunction> p_256312_, ResourceKey<DensityFunction> p_256077_) {
			return new DensityFunctions.HolderHolder(p_256312_.getOrThrow(p_256077_));
		}

		private static DensityFunction underground(HolderGetter<DensityFunction> p_256548_, HolderGetter<NormalNoise.NoiseParameters> p_256236_, DensityFunction p_256658_) {
			return DensityFunctions.max(DensityFunctions.min(DensityFunctions.min(DensityFunctions.add(DensityFunctions.mul(DensityFunctions.constant(4.0D), DensityFunctions.noise(p_256236_.getOrThrow(Noises.CAVE_LAYER), 8.0D).square()), DensityFunctions.add(DensityFunctions.add(DensityFunctions.constant(0.27D), DensityFunctions.noise(p_256236_.getOrThrow(Noises.CAVE_CHEESE), 0.6666666666666666D)).clamp(-1.0D, 1.0D), DensityFunctions.add(DensityFunctions.constant(1.5D), DensityFunctions.mul(DensityFunctions.constant(-0.64D), p_256658_)).clamp(0.0D, 0.5D))), getFunction(p_256548_, ENTRANCES)), DensityFunctions.add(getFunction(p_256548_, SPAGHETTI_2D), getFunction(p_256548_, SPAGHETTI_ROUGHNESS_FUNCTION))), DensityFunctions.rangeChoice(getFunction(p_256548_, PILLARS), -1000000.0D, 0.03D, DensityFunctions.constant(-1000000.0D), getFunction(p_256548_, PILLARS)));
		}

		private static DensityFunction postProcess(DensityFunction densityFunction) {
			return DensityFunctions.mul(DensityFunctions.interpolated(DensityFunctions.blendDensity(densityFunction)), DensityFunctions.constant(0.64D)).squeeze();
		}

		protected static NoiseRouter moon(HolderGetter<DensityFunction> p_255681_, HolderGetter<NormalNoise.NoiseParameters> p_256005_, boolean p_255649_, boolean p_255617_) {
			int i = Stream.of(OreVeinifier.VeinType.values()).mapToInt((p_224495_) -> {
				return p_224495_.minY;
			}).min().orElse(-DimensionType.MIN_Y * 2);
			int j = Stream.of(OreVeinifier.VeinType.values()).mapToInt((p_224457_) -> {
				return p_224457_.maxY;
			}).max().orElse(-DimensionType.MIN_Y * 2);
			DensityFunction densityfunction18 = yLimitedInterpolatable(getFunction(p_255681_, Y), DensityFunctions.noise(p_256005_.getOrThrow(Noises.ORE_VEIN_B), 4.0D, 4.0D), i, j, 0).abs();

			return new NoiseRouter(DensityFunctions.noise(p_256005_.getOrThrow(Noises.AQUIFER_BARRIER), 0.5D), DensityFunctions.noise(p_256005_.getOrThrow(Noises.AQUIFER_FLUID_LEVEL_FLOODEDNESS), 0.67D), DensityFunctions.noise(p_256005_.getOrThrow(Noises.AQUIFER_FLUID_LEVEL_SPREAD), 0.7142857142857143D), DensityFunctions.noise(p_256005_.getOrThrow(Noises.AQUIFER_LAVA)), DensityFunctions.shiftedNoise2d(getFunction(p_255681_, SHIFT_X), new DensityFunctions.HolderHolder(p_255681_.getOrThrow(SHIFT_Z)), 0.25D, p_256005_.getOrThrow(p_255649_ ? Noises.TEMPERATURE_LARGE : Noises.TEMPERATURE)), DensityFunctions.shiftedNoise2d(getFunction(p_255681_, SHIFT_X), new DensityFunctions.HolderHolder(p_255681_.getOrThrow(SHIFT_Z)), 0.25D, p_256005_.getOrThrow(p_255649_ ? Noises.VEGETATION_LARGE : Noises.VEGETATION)), new DensityFunctions.HolderHolder(p_255681_.getOrThrow(p_255649_ ? CONTINENTS_LARGE : CONTINENTS)), new DensityFunctions.HolderHolder(p_255681_.getOrThrow(p_255649_ ? EROSION_LARGE : EROSION)), new DensityFunctions.HolderHolder(p_255681_.getOrThrow(p_255649_ ? DEPTH_LARGE : (p_255617_ ? DEPTH_AMPLIFIED : DEPTH))), new DensityFunctions.HolderHolder(p_255681_.getOrThrow(RIDGES)), slideOverworld(p_255617_, DensityFunctions.add(noiseGradientDensity(DensityFunctions.cache2d(getFunction(p_255681_, p_255649_ ? FACTOR_LARGE : (p_255617_ ? FACTOR_AMPLIFIED : FACTOR))), getFunction(p_255681_, p_255649_ ? DEPTH_LARGE : (p_255617_ ? DEPTH_AMPLIFIED : DEPTH))), DensityFunctions.constant(-0.703125D)).clamp(-64.0D, 64.0D)), DensityFunctions.min(postProcess(slideOverworld(p_255617_, DensityFunctions.rangeChoice(getFunction(p_255681_, p_255649_ ? SLOPED_CHEESE_LARGE : (p_255617_ ? SLOPED_CHEESE_AMPLIFIED : SLOPED_CHEESE)), -1000000.0D, 1.5625D, DensityFunctions.min(getFunction(p_255681_, p_255649_ ? SLOPED_CHEESE_LARGE : (p_255617_ ? SLOPED_CHEESE_AMPLIFIED : SLOPED_CHEESE)), DensityFunctions.mul(DensityFunctions.constant(5.0D), getFunction(p_255681_, ENTRANCES))), underground(p_255681_, p_256005_, getFunction(p_255681_, p_255649_ ? SLOPED_CHEESE_LARGE : (p_255617_ ? SLOPED_CHEESE_AMPLIFIED : SLOPED_CHEESE)))))), getFunction(p_255681_, NOODLE)), yLimitedInterpolatable(getFunction(p_255681_, Y), DensityFunctions.noise(p_256005_.getOrThrow(Noises.ORE_VEININESS), 1.5D, 1.5D), i, j, 0), DensityFunctions.add(DensityFunctions.constant(-0.08F), DensityFunctions.max(yLimitedInterpolatable(getFunction(p_255681_, Y), DensityFunctions.noise(p_256005_.getOrThrow(Noises.ORE_VEIN_A), 4.0D, 4.0D), i, j, 0).abs(), densityfunction18 = yLimitedInterpolatable(getFunction(p_255681_, Y), DensityFunctions.noise(p_256005_.getOrThrow(Noises.ORE_VEIN_B), 4.0D, 4.0D), i, j, 0).abs())), DensityFunctions.noise(p_256005_.getOrThrow(Noises.ORE_GAP)));
		}

		private static DensityFunction slideOverworld(boolean p_224490_, DensityFunction p_224491_) {
			return DensityFunctions.lerp(DensityFunctions.yClampedGradient(-64 + 0, -64 + 24, 0.0D, 1.0D), p_224490_ ? 0.4D : 0.1171875D, DensityFunctions.lerp(DensityFunctions.yClampedGradient(-64 + 384 - (p_224490_ ? 16 : 80), -64 + 384 - (p_224490_ ? 0 : 64), 1.0D, 0.0D), -0.078125D, p_224491_));
		}

		private static DensityFunction noiseGradientDensity(DensityFunction p_212272_, DensityFunction p_212273_) {
			return DensityFunctions.mul(DensityFunctions.constant(4.0D), DensityFunctions.mul(p_212273_, p_212272_).quarterNegative());
		}

		private static DensityFunction yLimitedInterpolatable(DensityFunction p_209472_, DensityFunction p_209473_, int p_209474_, int p_209475_, int p_209476_) {
			return DensityFunctions.interpolated(DensityFunctions.rangeChoice(p_209472_, p_209474_, p_209475_ + 1, p_209473_, DensityFunctions.constant(p_209476_)));
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

	@Override
	protected void populate() {
		// TODO Auto-generated method stub

	}
}
