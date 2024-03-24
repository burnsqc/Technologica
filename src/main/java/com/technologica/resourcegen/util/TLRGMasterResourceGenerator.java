package com.technologica.resourcegen.util;

import java.util.List;
import java.util.concurrent.CompletableFuture;
import java.util.function.Supplier;

import com.technologica.resourcegen.assets.TLRGSoundsGenerator;
import com.technologica.resourcegen.assets.blockstates.TLRGBlockStateGenerator;
import com.technologica.resourcegen.assets.lang.TLRGLanguageGenerator;
import com.technologica.resourcegen.assets.models.items.TLRGModelItemGenerator;
import com.technologica.resourcegen.assets.particles.TLRGParticleGenerator;
import com.technologica.resourcegen.data.advancements.AdvancementDataGenerator;
import com.technologica.resourcegen.data.damagetype.DamageTypeProvider;
import com.technologica.resourcegen.data.dimension.DimensionProvider;
import com.technologica.resourcegen.data.dimensiontype.DimensionTypeProvider;
import com.technologica.resourcegen.data.lootmodifiers.blocks.BlockLootModifierDataGenerator;
import com.technologica.resourcegen.data.lootmodifiers.chests.ChestLootModifierDataGenerator;
import com.technologica.resourcegen.data.loottables.LootTableDataGenerator;
import com.technologica.resourcegen.data.recipes.RecipeDataGenerator;
import com.technologica.resourcegen.data.tags.blocks.BlockTagProvider;
import com.technologica.resourcegen.data.tags.entity.EntityTagProvider;
import com.technologica.resourcegen.data.tags.fluids.FluidTagDataGenerator;
import com.technologica.resourcegen.data.tags.items.ItemTagProvider;
import com.technologica.resourcegen.data.tags.paintingvariant.PaintingVariantTagProvider;
import com.technologica.resourcegen.data.tags.worldgen.biome.BiomeTagProvider;
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
	static CompletableFuture<HolderLookup.Provider> lookupProvider;
	static RegistrySetBuilder registrySetBuilder;

	protected static Supplier<TLRGBlockStateGenerator> BlockStateGenerator;
	protected static Supplier<TLRGLanguageGenerator> LanguageGenerator;
	protected static Supplier<TLRGModelItemGenerator> ModelItemGenerator;
	protected static Supplier<TLRGParticleGenerator> ParticleGenerator;
	protected static Supplier<TLRGSoundsGenerator> SoundsDataGenerator;

	public static void setGenerators(Supplier<TLRGBlockStateGenerator> TLRGBlockStateDataGenerator, Supplier<TLRGLanguageGenerator> TLRGLanguageDataGenerator, Supplier<TLRGModelItemGenerator> TLRGItemModelDataGenerator, Supplier<TLRGParticleGenerator> TLRGParticleGenerator) {
		BlockStateGenerator = TLRGBlockStateDataGenerator;
		LanguageGenerator = TLRGLanguageDataGenerator;
		ModelItemGenerator = TLRGItemModelDataGenerator;
		ParticleGenerator = TLRGParticleGenerator;
	}

	@SubscribeEvent
	public static void addGenerators(final GatherDataEvent eventIn) {
		event = eventIn;
		generator = event.getGenerator();
		packOutput = generator.getPackOutput();
		helper = event.getExistingFileHelper();
		lookupProvider = event.getLookupProvider();
		registrySetBuilder = new RegistrySetBuilder().add(Registries.DIMENSION_TYPE, DimensionTypeProvider::bootstrap).add(Registries.CONFIGURED_FEATURE, (RegistrySetBuilder.RegistryBootstrap) ConfiguredFeatureProvider::bootstrap).add(Registries.PLACED_FEATURE, PlacedFeatureProvider::bootstrap).add(Registries.STRUCTURE, StructureProvider::bootstrap).add(Registries.STRUCTURE_SET, StructureSetProvider::bootstrap).add(Registries.TEMPLATE_POOL, TemplatePoolProvider::bootstrap).add(Registries.BIOME, BiomeProvider::bootstrap).add(Registries.NOISE_SETTINGS, NoiseSettingsProvider::bootstrap).add(Registries.LEVEL_STEM, DimensionProvider::bootstrap).add(Registries.DAMAGE_TYPE, DamageTypeProvider::bootstrap).add(ForgeRegistries.Keys.BIOME_MODIFIERS, BiomeModifierProvider::bootstrap);

		// addAssetProvider(atlasProvider);
		// addAssetProvider(new FontDataGenerator(packOutput, helper));
		// addAssetProvider(new ShaderDataGenerator(packOutput, helper));
		// addAssetProvider(new TextsDataGenerator(packOutput, helper));
		addAssetGenerator(BlockStateGenerator);
		addAssetGenerator(LanguageGenerator);
		addAssetGenerator(ModelItemGenerator);
		addAssetGenerator(ParticleGenerator);
		addAssetGenerator(SoundsDataGenerator);

		AdvancementDataGenerator advancementProvider = new AdvancementDataGenerator(packOutput, lookupProvider, helper);
		DamageTypeProvider damageTypeProvider = new DamageTypeProvider(packOutput, lookupProvider, registrySetBuilder);
		BlockTagProvider blockTagProvider = new BlockTagProvider(packOutput, lookupProvider, helper);
		EntityTagProvider entityTagProvider = new EntityTagProvider(packOutput, lookupProvider, helper);
		FluidTagDataGenerator fluidTagProvider = new FluidTagDataGenerator(packOutput, lookupProvider, helper);
		ItemTagProvider itemTagProvider = new ItemTagProvider(packOutput, lookupProvider, blockTagProvider.contentsGetter(), helper);
		BiomeTagProvider biomeTagProvider = new BiomeTagProvider(packOutput, lookupProvider, helper);
		PaintingVariantTagProvider paintingVariantTagProvider = new PaintingVariantTagProvider(packOutput, lookupProvider, helper);

		// addDataProvider(new DimensionTypeDataGenerator(packOutput, lookupProvider, registrySetBuilder));
		addDataGenerator(new BlockLootModifierDataGenerator(packOutput));
		addDataGenerator(new ChestLootModifierDataGenerator(packOutput));
		// addDataProvider(new EntityLootModifierDataGenerator(packOutput));
		addDataGenerator(new LootTableDataGenerator(packOutput));
		// addDataProvider(new TechnologicaDatapackBuiltinEntriesProvider(packOutput, lookupProvider));
		addDataGenerator(new RecipeDataGenerator(packOutput));
		addIntermediateDataProvider(new TagIntermediateDataGenerator(blockTagProvider, entityTagProvider, fluidTagProvider, itemTagProvider, biomeTagProvider, paintingVariantTagProvider));

		addDataGenerator(advancementProvider);
		// addDataProvider(chatTypeProvider);
		addDataGenerator(damageTypeProvider);
	}

	private static void addAssetGenerator(Supplier<?> provider) {
		if (provider != null) {
			generator.addProvider(event.includeClient(), (DataProvider) provider.get());
		}
	}

	private static void addDataGenerator(DataProvider provider) {
		if (provider != null) {
			generator.addProvider(event.includeServer(), provider);
		}
	}

	private static void addIntermediateDataProvider(IntermediateDataGenerator intermediateProvider) {
		List<DataProvider> list = intermediateProvider.getSubProviders();
		for (DataProvider provider : list) {
			generator.addProvider(event.includeServer(), provider);
		}
	}
}
