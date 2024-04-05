package com.technologica.api.tlregen.resourcegen;

import java.util.concurrent.CompletableFuture;
import java.util.function.Supplier;

import com.technologica.Technologica;
import com.technologica.api.tlregen.resourcegen.assets.TLReGenBlockstates;
import com.technologica.api.tlregen.resourcegen.assets.TLReGenLang;
import com.technologica.api.tlregen.resourcegen.assets.TLReGenModelsItem;
import com.technologica.api.tlregen.resourcegen.assets.TLReGenParticles;
import com.technologica.api.tlregen.resourcegen.assets.TLReGenSounds;
import com.technologica.api.tlregen.resourcegen.data.TLRGDimensionTypeGenerator;
import com.technologica.api.tlregen.resourcegen.data.TLRGLootTablesGenerator;
import com.technologica.api.tlregen.resourcegen.data.TLRGRecipeGenerator;
import com.technologica.api.tlregen.resourcegen.data.TLRGTagsBlocksGenerator;
import com.technologica.api.tlregen.resourcegen.data.TLRGTagsEntityTypesGenerator;
import com.technologica.api.tlregen.resourcegen.data.TLRGTagsItemsGenerator;
import com.technologica.api.tlregen.resourcegen.data.TLReGenDamageType;
import com.technologica.api.tlregen.resourcegen.data.TLReGenDimension;
import com.technologica.resourcegen.assets.TLAtlasesGenerator;
import com.technologica.resourcegen.assets.TLFontGenerator;
import com.technologica.resourcegen.assets.TLSoundsGenerator;
import com.technologica.resourcegen.assets.blockstates.TLBlockstatesGenerator;
import com.technologica.resourcegen.assets.lang.TLLangGenerator;
import com.technologica.resourcegen.assets.models.items.TLModelsGenerator;
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
import com.technologica.resourcegen.data.worldgen.biome.TLForgeBiomeModifierGenerator;
import com.technologica.resourcegen.data.worldgen.biome.TLWorldgenBiomeGenerator;
import com.technologica.resourcegen.data.worldgen.configuredfeature.TLWorldgenConfiguredFeatureGenerator;
import com.technologica.resourcegen.data.worldgen.noisesettings.TLWorldgenNoiseSettingsGenerator;
import com.technologica.resourcegen.data.worldgen.placedfeature.TLWorldgenPlacedFeatureGenerator;
import com.technologica.resourcegen.data.worldgen.structure.TLWorldgenStructureGenerator;
import com.technologica.resourcegen.data.worldgen.structuresets.TLWorldgenStructureSetGenerator;
import com.technologica.resourcegen.data.worldgen.templatepool.TLWorldgenTemplatePoolGenerator;

import net.minecraft.core.HolderLookup;
import net.minecraft.core.RegistrySetBuilder;
import net.minecraft.data.DataGenerator;
import net.minecraft.data.DataProvider;
import net.minecraft.data.PackOutput;
import net.minecraftforge.common.data.ExistingFileHelper;
import net.minecraftforge.data.event.GatherDataEvent;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.fml.common.Mod.EventBusSubscriber;

@Mod.EventBusSubscriber(bus = EventBusSubscriber.Bus.MOD)
public abstract class TLRGMasterResourceGenerator {
	private static GatherDataEvent event;
	private static DataGenerator generator;
	public static PackOutput packOutput;
	public static ExistingFileHelper helper;
	public static CompletableFuture<HolderLookup.Provider> lookupProvider;
	public static RegistrySetBuilder registrySetBuilder;
	public static String modid = Technologica.MOD_ID;

	protected static Supplier<TLReGenBlockstates> BlockStateGenerator;
	protected static Supplier<TLReGenLang> LanguageGenerator;
	protected static Supplier<TLReGenModelsItem> ModelItemGenerator;
	protected static Supplier<TLReGenParticles> ParticleGenerator;
	protected static Supplier<TLReGenSounds> SoundsGenerator;

	protected static Supplier<TLRGAdvancementGenerator> AdvancementGenerator;
	protected static Supplier<TLReGenDamageType> DamageTypeGenerator;
	protected static Supplier<TLReGenDimension> DimensionGenerator;
	protected static Supplier<TLRGDimensionTypeGenerator> DimensionTypeGenerator;
	protected static Supplier<TLRGRecipeGenerator> RecipeGenerator;
	protected static Supplier<TLRGTagsBlocksGenerator> TagBlocksGenerator;
	public static TLRGTagsBlocksGenerator TagBlocks;
	protected static Supplier<TLRGTagsEntityTypesGenerator> TagEntityTypeGenerator;
	protected static Supplier<TLRGTagsItemsGenerator> TagItemGenerator;

	public static void setGenerators(Supplier<TLReGenBlockstates> TLRGBlockStateDataGenerator, Supplier<TLReGenLang> TLRGLanguageDataGenerator, Supplier<TLReGenModelsItem> TLRGItemModelDataGenerator, Supplier<TLReGenParticles> TLRGParticleGenerator, Supplier<TLReGenSounds> TLRGSoundsGenerator, Supplier<TLRGAdvancementGenerator> TLRGAdvancementGenerator, Supplier<TLReGenDamageType> TLRGDamageTypeGenerator, Supplier<TLReGenDimension> TLRGDimensionGenerator, Supplier<TLRGDimensionTypeGenerator> TLRGDimensionTypeGenerator, Supplier<TLRGRecipeGenerator> TLRGRecipeGenerator, Supplier<TLRGTagsBlocksGenerator> TLRGTagBlocksGenerator, Supplier<TLRGTagsEntityTypesGenerator> TLRGTagEntityTypeGenerator, Supplier<TLRGTagsItemsGenerator> TLRGTagItemsGenerator) {

	}

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
	}

	private static void setGenerators() {
		TagBlocks = new TLTagBlocksGenerator();
	}

	private static void addGenerators() {
		addAssetGenerator(new TLAtlasesGenerator());
		addAssetGenerator(new TLBlockstatesGenerator());
		addAssetGenerator(new TLFontGenerator());
		addAssetGenerator(new TLLangGenerator());
		addAssetGenerator(new TLModelsGenerator());
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
		addDataGenerator(new TLWorldgenBiomeGenerator());
		addDataGenerator(new TLWorldgenConfiguredFeatureGenerator());
		addDataGenerator(new TLWorldgenNoiseSettingsGenerator());
		addDataGenerator(new TLWorldgenPlacedFeatureGenerator());
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
}
