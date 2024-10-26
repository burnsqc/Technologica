package com.technologica.api.tlregen.resourcegen;

import java.util.concurrent.CompletableFuture;
import java.util.function.Supplier;

import com.google.gson.JsonElement;
import com.mojang.serialization.DynamicOps;
import com.mojang.serialization.JsonOps;
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
import com.technologica.api.tlregen.resourcegen.data.worldgen.TLReGenWorldgenBiome;
import com.technologica.api.tlregen.resourcegen.data.worldgen.TLReGenWorldgenConfiguredFeature;
import com.technologica.api.tlregen.resourcegen.data.worldgen.TLReGenWorldgenDensityFunction;
import com.technologica.api.tlregen.resourcegen.data.worldgen.TLReGenWorldgenPlacedFeature;
import com.technologica.api.tlregen.resourcegen.data.worldgen.TLReGenWorldgenStructure;
import com.technologica.resourcegen.assets.TLAtlases;
import com.technologica.resourcegen.assets.TLBlockstates;
import com.technologica.resourcegen.assets.TLFont;
import com.technologica.resourcegen.assets.TLLang;
import com.technologica.resourcegen.assets.TLModelsBlock;
import com.technologica.resourcegen.assets.TLModelsItem;
import com.technologica.resourcegen.assets.TLParticles;
import com.technologica.resourcegen.assets.TLSounds;
import com.technologica.resourcegen.data.advancements.TLRGAdvancementGenerator;
import com.technologica.resourcegen.data.lootmodifiers.TLLootModifiersGenerator;
import com.technologica.resourcegen.data.recipes.TLRecipesGenerator;
import com.technologica.resourcegen.data.tags.blocks.TLTagBlocksGenerator;
import com.technologica.resourcegen.data.tags.entity.TLTagEntityTypeGenerator;
import com.technologica.resourcegen.data.tags.fluids.TLTagsFluidsGenerator;
import com.technologica.resourcegen.data.tags.items.TLTagItemsGenerator;
import com.technologica.resourcegen.data.tags.paintingvariant.TLTagsPaintingVariantGenerator;
import com.technologica.resourcegen.data.tags.worldgen.biome.TLTagWorldgenBiomeGenerator;
import com.technologica.resourcegen.data.worldgen.biome.TLForgeBiomeModifierGenerator;
import com.technologica.resourcegen.data.worldgen.noise.TLWorldgenNoise;
import com.technologica.resourcegen.data.worldgen.noisesettings.TLWorldgenNoiseSettings;
import com.technologica.resourcegen.data.worldgen.structuresets.TLWorldgenStructureSetGenerator;
import com.technologica.resourcegen.data.worldgen.templatepool.TLWorldgenTemplatePoolGenerator;

import net.minecraft.core.HolderLookup;
import net.minecraft.data.DataGenerator;
import net.minecraft.data.DataProvider;
import net.minecraft.data.PackOutput;
import net.minecraftforge.common.data.ExistingFileHelper;
import net.minecraftforge.data.event.GatherDataEvent;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.fml.common.Mod.EventBusSubscriber;

@Mod.EventBusSubscriber(bus = EventBusSubscriber.Bus.MOD)
public abstract class MasterResourceGenerator implements DataProvider {
	private static GatherDataEvent event;
	private static DataGenerator generator;
	public static PackOutput packOutput;
	public static ExistingFileHelper helper;
	public static CompletableFuture<HolderLookup.Provider> lookupProvider;
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

	@SubscribeEvent
	public static void addGenerators(final GatherDataEvent eventIn) {
		event = eventIn;
		generator = event.getGenerator();
		packOutput = generator.getPackOutput();
		helper = event.getExistingFileHelper();
		lookupProvider = event.getLookupProvider();
		TagBlocks = new TLTagBlocksGenerator();
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
		addDataGenerator(new TLReGenDamageType(Technologica.DAMAGE_TYPES));
		// datapacks
		addDataGenerator(new TLReGenDimension(Technologica.DIMENSIONS));
		addDataGenerator(new TLReGenDimensionType(Technologica.DIMENSION_TYPES));
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
		addDataGenerator(new TLReGenWorldgenBiome(Technologica.BIOMES));
		addDataGenerator(new TLReGenWorldgenConfiguredFeature(Technologica.CONFIGURED_FEATURES));
		addDataGenerator(new TLReGenWorldgenDensityFunction(Technologica.DENSITY_FUNCTIONS));
		addDataGenerator(new TLWorldgenNoise());
		addDataGenerator(new TLWorldgenNoiseSettings());
		addDataGenerator(new TLReGenWorldgenPlacedFeature(Technologica.PLACED_FEATURES));
		addDataGenerator(new TLReGenWorldgenStructure(Technologica.STRUCTURES));
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
	protected void populate() {
	};

	public static enum ValidationLevel {
		MIN("minimum"), MED("medium"), MAX("maximum");

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
