package com.technologica.api.tlrg.resourcegen;

import java.util.concurrent.CompletableFuture;
import java.util.function.Supplier;

import com.technologica.resourcegen.assets.TLSoundsGenerator;
import com.technologica.resourcegen.assets.blockstates.TLBlockStatesGenerator;
import com.technologica.resourcegen.assets.lang.TLLangGenerator;
import com.technologica.resourcegen.assets.models.items.TLModelsItemGenerator;
import com.technologica.resourcegen.assets.particles.TLParticlesGenerator;
import com.technologica.resourcegen.data.advancements.TLRGAdvancementGenerator;
import com.technologica.resourcegen.data.damagetype.TLDamageTypeGenerator;
import com.technologica.resourcegen.data.dimension.TLDimensionGenerator;
import com.technologica.resourcegen.data.dimensiontype.TLDimensionTypeGenerator;
import com.technologica.resourcegen.data.lootmodifiers.TLLootModifiersGenerator;
import com.technologica.resourcegen.data.recipes.TLRecipesGenerator;
import com.technologica.resourcegen.data.tags.blocks.TLTagBlocksGenerator;
import com.technologica.resourcegen.data.tags.entity.TLTagEntityTypeGenerator;
import com.technologica.resourcegen.data.tags.fluids.TLTagsFluidsGenerator;
import com.technologica.resourcegen.data.tags.items.TLTagItemsGenerator;
import com.technologica.resourcegen.data.tags.paintingvariant.TLTagsPaintingVariantGenerator;
import com.technologica.resourcegen.data.tags.worldgen.biome.TLTagWorldgenBiomeGenerator;
import com.technologica.resourcegen.data.worldgen.biome.BiomeModifierProvider;
import com.technologica.resourcegen.data.worldgen.biome.BiomeProvider;
import com.technologica.resourcegen.data.worldgen.configuredfeature.ConfiguredFeatureProvider;
import com.technologica.resourcegen.data.worldgen.noisesettings.NoiseSettingsProvider;
import com.technologica.resourcegen.data.worldgen.placedfeature.PlacedFeatureProvider;
import com.technologica.resourcegen.data.worldgen.structure.StructureProvider;
import com.technologica.resourcegen.data.worldgen.structuresets.StructureSetProvider;
import com.technologica.resourcegen.data.worldgen.templatepool.TemplatePoolProvider;

import net.minecraft.core.HolderLookup;
import net.minecraft.core.RegistrySetBuilder;
import net.minecraft.core.registries.Registries;
import net.minecraft.data.DataGenerator;
import net.minecraft.data.DataProvider;
import net.minecraft.data.PackOutput;
import net.minecraftforge.common.data.ExistingFileHelper;
import net.minecraftforge.data.event.GatherDataEvent;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.fml.common.Mod.EventBusSubscriber;
import net.minecraftforge.registries.ForgeRegistries;

@Mod.EventBusSubscriber(bus = EventBusSubscriber.Bus.MOD)
public abstract class TLRGMasterResourceGenerator {
	private static GatherDataEvent event;
	private static DataGenerator generator;
	public static PackOutput packOutput;
	public static ExistingFileHelper helper;
	public static CompletableFuture<HolderLookup.Provider> lookupProvider;
	public static RegistrySetBuilder registrySetBuilder;

	protected static Supplier<TLRGBlockStateGenerator> BlockStateGenerator;
	protected static Supplier<TLRGLanguageGenerator> LanguageGenerator;
	protected static Supplier<TLRGModelItemGenerator> ModelItemGenerator;
	protected static Supplier<TLRGParticleGenerator> ParticleGenerator;
	protected static Supplier<TLRGSoundsGenerator> SoundsGenerator;

	protected static Supplier<TLRGAdvancementGenerator> AdvancementGenerator;
	protected static Supplier<TLRGDamageTypeGenerator> DamageTypeGenerator;
	protected static Supplier<TLRGDimensionGenerator> DimensionGenerator;
	protected static Supplier<TLRGDimensionTypeGenerator> DimensionTypeGenerator;
	protected static Supplier<TLRGRecipeGenerator> RecipeGenerator;
	protected static Supplier<TLRGTagsBlocksGenerator> TagBlocksGenerator;
	protected static TLRGTagsBlocksGenerator TagBlocks;
	protected static Supplier<TLRGTagsEntityTypesGenerator> TagEntityTypeGenerator;
	protected static Supplier<TLRGTagsItemsGenerator> TagItemGenerator;

	public static void setGenerators(Supplier<TLRGBlockStateGenerator> TLRGBlockStateDataGenerator, Supplier<TLRGLanguageGenerator> TLRGLanguageDataGenerator, Supplier<TLRGModelItemGenerator> TLRGItemModelDataGenerator, Supplier<TLRGParticleGenerator> TLRGParticleGenerator, Supplier<TLRGSoundsGenerator> TLRGSoundsGenerator, Supplier<TLRGAdvancementGenerator> TLRGAdvancementGenerator, Supplier<TLRGDamageTypeGenerator> TLRGDamageTypeGenerator, Supplier<TLRGDimensionGenerator> TLRGDimensionGenerator, Supplier<TLRGDimensionTypeGenerator> TLRGDimensionTypeGenerator, Supplier<TLRGRecipeGenerator> TLRGRecipeGenerator, Supplier<TLRGTagsBlocksGenerator> TLRGTagBlocksGenerator, Supplier<TLRGTagsEntityTypesGenerator> TLRGTagEntityTypeGenerator, Supplier<TLRGTagsItemsGenerator> TLRGTagItemsGenerator) {
		BlockStateGenerator = TLRGBlockStateDataGenerator;
		LanguageGenerator = TLRGLanguageDataGenerator;
		ModelItemGenerator = TLRGItemModelDataGenerator;
		ParticleGenerator = TLRGParticleGenerator;
		SoundsGenerator = TLRGSoundsGenerator;

		AdvancementGenerator = TLRGAdvancementGenerator;
		DamageTypeGenerator = TLRGDamageTypeGenerator;
		DimensionGenerator = TLRGDimensionGenerator;
		DimensionTypeGenerator = TLRGDimensionTypeGenerator;
		RecipeGenerator = TLRGRecipeGenerator;
		TagBlocksGenerator = TLRGTagBlocksGenerator;
		TagEntityTypeGenerator = TLRGTagEntityTypeGenerator;
		TagItemGenerator = TLRGTagItemsGenerator;
	}

	@SubscribeEvent
	public static void addGenerators(final GatherDataEvent eventIn) {
		setup(eventIn);
		setGenerators();
		addGenerators();

		// FluidTagDataGenerator fluidTagProvider = new FluidTagDataGenerator(packOutput, lookupProvider, helper);
		// BiomeTagProvider biomeTagProvider = new BiomeTagProvider(packOutput, lookupProvider, helper);
		// PaintingVariantTagProvider paintingVariantTagProvider = new PaintingVariantTagProvider(packOutput, lookupProvider, helper);

		// addDataGenerator(new BlockLootModifierDataGenerator(packOutput));
		// addDataGenerator(new ChestLootModifierDataGenerator(packOutput));
		// addDataProvider(new EntityLootModifierDataGenerator(packOutput));
		// addDataGenerator(new LootTableDataGenerator(packOutput));
		// addDataProvider(new TechnologicaDatapackBuiltinEntriesProvider(packOutput, lookupProvider));

	}

	@SuppressWarnings({ "unchecked", "rawtypes" })
	private static void setup(final GatherDataEvent eventIn) {
		event = eventIn;
		generator = event.getGenerator();
		packOutput = generator.getPackOutput();
		helper = event.getExistingFileHelper();
		lookupProvider = event.getLookupProvider();
		registrySetBuilder = new RegistrySetBuilder().add(Registries.DIMENSION_TYPE, TLDimensionTypeGenerator::bootstrap).add(Registries.CONFIGURED_FEATURE, (RegistrySetBuilder.RegistryBootstrap) ConfiguredFeatureProvider::bootstrap).add(Registries.PLACED_FEATURE, PlacedFeatureProvider::bootstrap).add(Registries.STRUCTURE, StructureProvider::bootstrap).add(Registries.STRUCTURE_SET, StructureSetProvider::bootstrap).add(Registries.TEMPLATE_POOL, TemplatePoolProvider::bootstrap).add(Registries.BIOME, BiomeProvider::bootstrap).add(Registries.NOISE_SETTINGS, NoiseSettingsProvider::bootstrap).add(Registries.DAMAGE_TYPE, TLDamageTypeGenerator::bootstrap).add(ForgeRegistries.Keys.BIOME_MODIFIERS, BiomeModifierProvider::bootstrap);
	}

	private static void setGenerators() {
		TagBlocks = new TLTagBlocksGenerator();
	}

	private static void addGenerators() {
		// atlases
		addAssetGenerator(new TLBlockStatesGenerator());
		// font
		addAssetGenerator(new TLLangGenerator());
		addAssetGenerator(new TLModelsItemGenerator());
		addAssetGenerator(new TLParticlesGenerator());
		// shaders
		// texts
		addAssetGenerator(new TLSoundsGenerator());

		addDataGenerator(new TLRGAdvancementGenerator());
		// chat_type
		addDataGenerator(new TLDamageTypeGenerator());
		// datapacks
		addDataGenerator(new TLDimensionGenerator());
		addDataGenerator(new TLDimensionTypeGenerator());
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
		// trime_material
		// trim_pattern
		// worldgen
	}

	private static void addAssetGenerator(DataProvider provider) {
		generator.addProvider(event.includeClient(), provider);
	}

	private static void addDataGenerator(DataProvider provider) {
		generator.addProvider(event.includeServer(), provider);
	}
}
