package com.technologica.api.tlregen.resourcegen;

import java.util.Optional;
import java.util.concurrent.CompletableFuture;
import java.util.function.Supplier;
import java.util.stream.Stream;

import com.google.gson.JsonElement;
import com.mojang.serialization.DynamicOps;
import com.mojang.serialization.JsonOps;
import com.mojang.serialization.Lifecycle;
import com.technologica.Technologica;
import com.technologica.api.tlregen.resourcegen.assets.TLReGenBlockstates;
import com.technologica.api.tlregen.resourcegen.assets.TLReGenLang;
import com.technologica.api.tlregen.resourcegen.assets.TLReGenModelsItem;
import com.technologica.api.tlregen.resourcegen.assets.TLReGenParticles;
import com.technologica.api.tlregen.resourcegen.assets.TLReGenSounds;
import com.technologica.api.tlregen.resourcegen.data.TLRGLootTablesGenerator;
import com.technologica.api.tlregen.resourcegen.data.TLRGRecipeGenerator;
import com.technologica.api.tlregen.resourcegen.data.TLReGenDamageType;
import com.technologica.api.tlregen.resourcegen.data.TLReGenDimension;
import com.technologica.api.tlregen.resourcegen.data.TLReGenDimensionType;
import com.technologica.api.tlregen.resourcegen.data.tags.TLRGTagsItemsGenerator;
import com.technologica.api.tlregen.resourcegen.data.tags.TLReGenTagsBlocks;
import com.technologica.api.tlregen.resourcegen.data.tags.TLReGenTagsEntityTypes;
import com.technologica.api.tlregen.resourcegen.mirrors.TLReGenRegistrySetBuilder;
import com.technologica.registration.key.TechnologicaConfiguredFeatures;
import com.technologica.resourcegen.assets.TLAtlases;
import com.technologica.resourcegen.assets.TLBlockstates;
import com.technologica.resourcegen.assets.TLFont;
import com.technologica.resourcegen.assets.TLLang;
import com.technologica.resourcegen.assets.TLModelsBlock;
import com.technologica.resourcegen.assets.TLModelsItem;
import com.technologica.resourcegen.assets.TLParticles;
import com.technologica.resourcegen.assets.TLSounds;
import com.technologica.resourcegen.data.advancements.TLRGAdvancementGenerator;
import com.technologica.resourcegen.data.damagetype.TLDamageTypeGenerator;
import com.technologica.resourcegen.data.dimension.TLDimensions;
import com.technologica.resourcegen.data.dimensiontype.TLDimensionTypes;
import com.technologica.resourcegen.data.lootmodifiers.TLLootModifiersGenerator;
import com.technologica.resourcegen.data.recipes.TLRecipesGenerator;
import com.technologica.resourcegen.data.tags.blocks.TLTagBlocksGenerator;
import com.technologica.resourcegen.data.tags.entity.TLTagEntityTypeGenerator;
import com.technologica.resourcegen.data.tags.fluids.TLTagsFluidsGenerator;
import com.technologica.resourcegen.data.tags.items.TLTagItemsGenerator;
import com.technologica.resourcegen.data.tags.paintingvariant.TLTagsPaintingVariantGenerator;
import com.technologica.resourcegen.data.tags.worldgen.biome.TLTagWorldgenBiomeGenerator;
import com.technologica.resourcegen.data.worldgen.biome.TLForgeBiomeModifierGenerator;
import com.technologica.resourcegen.data.worldgen.biome.TLWorldgenBiomes;
import com.technologica.resourcegen.data.worldgen.configuredfeature.TLWorldgenConfiguredFeatures;
import com.technologica.resourcegen.data.worldgen.densityfunction.TLWorldgenDensityFunctions;
import com.technologica.resourcegen.data.worldgen.noise.TLWorldgenNoise;
import com.technologica.resourcegen.data.worldgen.noisesettings.TLWorldgenNoiseSettings;
import com.technologica.resourcegen.data.worldgen.placedfeature.TLWorldgenPlacedFeatures;
import com.technologica.resourcegen.data.worldgen.structure.TLWorldgenStructureGenerator;
import com.technologica.resourcegen.data.worldgen.structuresets.TLWorldgenStructureSetGenerator;
import com.technologica.resourcegen.data.worldgen.templatepool.TLWorldgenTemplatePoolGenerator;

import net.minecraft.core.Holder.Reference;
import net.minecraft.core.HolderLookup;
import net.minecraft.core.HolderOwner;
import net.minecraft.core.HolderSet.Named;
import net.minecraft.core.Registry;
import net.minecraft.core.RegistrySetBuilder;
import net.minecraft.data.DataGenerator;
import net.minecraft.data.DataProvider;
import net.minecraft.data.PackOutput;
import net.minecraft.resources.ResourceKey;
import net.minecraft.tags.TagKey;
import net.minecraft.world.level.levelgen.feature.ConfiguredFeature;
import net.minecraft.world.level.levelgen.placement.PlacedFeature;
import net.minecraftforge.common.data.ExistingFileHelper;
import net.minecraftforge.data.event.GatherDataEvent;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.fml.common.Mod.EventBusSubscriber;

@Mod.EventBusSubscriber(bus = EventBusSubscriber.Bus.MOD)
public abstract class TLReGenMasterResourceGenerator implements DataProvider {
	private static GatherDataEvent event;
	private static DataGenerator generator;
	public static PackOutput packOutput;
	public static ExistingFileHelper helper;
	public static CompletableFuture<HolderLookup.Provider> lookupProvider;
	public static RegistrySetBuilder registrySetBuilder;
	public static TLReGenRegistrySetBuilder registrySetBuilder2;
	public static TLReGenRegistrySetBuilder registrySetBuilder3;
	public static String modid = Technologica.MOD_ID;
	protected final DynamicOps<JsonElement> dynamicOps = JsonOps.INSTANCE;

	protected static Supplier<TLReGenBlockstates> BlockStateGenerator;
	protected static Supplier<TLReGenLang> LanguageGenerator;
	protected static Supplier<TLReGenModelsItem> ModelItemGenerator;
	protected static Supplier<TLReGenParticles> ParticleGenerator;
	protected static Supplier<TLReGenSounds> SoundsGenerator;

	protected static Supplier<TLRGAdvancementGenerator> AdvancementGenerator;
	protected static Supplier<TLReGenDamageType> DamageTypeGenerator;
	protected static Supplier<TLReGenDimension> DimensionGenerator;
	protected static Supplier<TLReGenDimensionType> DimensionTypeGenerator;
	protected static Supplier<TLRGRecipeGenerator> RecipeGenerator;
	protected static Supplier<TLReGenTagsBlocks> TagBlocksGenerator;
	public static TLReGenTagsBlocks TagBlocks;
	protected static Supplier<TLReGenTagsEntityTypes> TagEntityTypeGenerator;
	protected static Supplier<TLRGTagsItemsGenerator> TagItemGenerator;

	protected static HolderOwner<PlacedFeature> ho = new HolderLookup.RegistryLookup<PlacedFeature>() {

		@Override
		public Stream<Reference<PlacedFeature>> listElements() {
			return null;
		}

		@Override
		public Stream<Named<PlacedFeature>> listTags() {
			return null;
		}

		@Override
		public Optional<Reference<PlacedFeature>> get(ResourceKey<PlacedFeature> p_255645_) {
			return Optional.empty();
		}

		@Override
		public Optional<Named<PlacedFeature>> get(TagKey<PlacedFeature> p_256283_) {
			return Optional.empty();
		}

		@Override
		public ResourceKey<? extends Registry<? extends PlacedFeature>> key() {
			return null;
		}

		@Override
		public Lifecycle registryLifecycle() {
			return null;
		}
	};

	protected static HolderOwner<ConfiguredFeature<?, ?>> ho2 = new HolderLookup.RegistryLookup<ConfiguredFeature<?, ?>>() {

		@Override
		public Stream<Reference<ConfiguredFeature<?, ?>>> listElements() {
			return null;
		}

		@Override
		public Stream<Named<ConfiguredFeature<?, ?>>> listTags() {
			return null;
		}

		@Override
		public Optional<Reference<ConfiguredFeature<?, ?>>> get(ResourceKey<ConfiguredFeature<?, ?>> p_255645_) {
			return Optional.empty();
		}

		@Override
		public Optional<Named<ConfiguredFeature<?, ?>>> get(TagKey<ConfiguredFeature<?, ?>> p_256283_) {
			return Optional.empty();
		}

		@Override
		public ResourceKey<? extends Registry<? extends ConfiguredFeature<?, ?>>> key() {
			return null;
		}

		@Override
		public Lifecycle registryLifecycle() {
			return null;
		}
	};

	@SubscribeEvent
	public static void addGenerators(final GatherDataEvent eventIn) {
		setup(eventIn);
		setGenerators();
		addGenerators();
	}

	private static void setup(final GatherDataEvent eventIn) {
		event = eventIn;
		generator = event.getGenerator();
		packOutput = generator.getPackOutput();
		helper = event.getExistingFileHelper();
		lookupProvider = event.getLookupProvider();
		registrySetBuilder = new RegistrySetBuilder();
		registrySetBuilder2 = new TLReGenRegistrySetBuilder();
		registrySetBuilder3 = new TLReGenRegistrySetBuilder();
		TechnologicaConfiguredFeatures.bootstrap();
		// TechnologicaPlacedFeatures.bootstrap();
	}

	private static void setGenerators() {
		TagBlocks = new TLTagBlocksGenerator();
	}

	private static void addGenerators() {
		addAssetGenerator(new TLAtlases());
		addAssetGenerator(new TLBlockstates());
		addAssetGenerator(new TLFont());
		addAssetGenerator(new TLLang());
		addAssetGenerator(new TLModelsBlock());
		addAssetGenerator(new TLModelsItem());
		addAssetGenerator(new TLParticles());
		// shaders
		// texts
		addAssetGenerator(new TLSounds());

		addDataGenerator(new TLRGAdvancementGenerator());
		// chat_type
		addDataGenerator(new TLDamageTypeGenerator());
		// datapacks
		addDataGenerator(new TLDimensions());
		addDataGenerator(new TLDimensionTypes());
		addDataGenerator(new TLForgeBiomeModifierGenerator());
		addDataGenerator(new TLLootModifiersGenerator());
		addDataGenerator(new TLRGLootTablesGenerator());
		addDataGenerator(new TLRecipesGenerator());
		// structures
		addDataGenerator(TagBlocks);
		addDataGenerator(new TLTagEntityTypeGenerator());
		addDataGenerator(new TLTagsFluidsGenerator());
		addDataGenerator(new TLTagItemsGenerator());
		addDataGenerator(new TLTagsPaintingVariantGenerator());
		addDataGenerator(new TLTagWorldgenBiomeGenerator());
		// trim_material
		// trim_pattern
		addDataGenerator(new TLWorldgenBiomes());
		addDataGenerator(new TLWorldgenConfiguredFeatures());
		addDataGenerator(new TLWorldgenDensityFunctions());
		addDataGenerator(new TLWorldgenNoise());
		addDataGenerator(new TLWorldgenNoiseSettings());
		addDataGenerator(new TLWorldgenPlacedFeatures());
		addDataGenerator(new TLWorldgenStructureGenerator());
		addDataGenerator(new TLWorldgenStructureSetGenerator());
		addDataGenerator(new TLWorldgenTemplatePoolGenerator());
	}

	private static void addAssetGenerator(DataProvider provider) {
		generator.addProvider(event.includeClient(), provider);
	}

	private static void addDataGenerator(DataProvider provider) {
		generator.addProvider(event.includeServer(), provider);
	}

	/**
	 * OVERRIDE ME TO ADD RESOURCES
	 */
	protected abstract void populate();

	public static enum ValidationLevel {
		MIN("minimum"),
		MED("medium"),
		MAX("maximum");

		final String level;

		private ValidationLevel(String level) {
			this.level = level;
		}
	}

	@Override
	public String getName() {
		return modid;
	}
}
