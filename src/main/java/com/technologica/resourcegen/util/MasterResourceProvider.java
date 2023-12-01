package com.technologica.resourcegen.util;

import java.util.List;
import java.util.concurrent.CompletableFuture;

import com.technologica.resourcegen.data.damagetype.DamageTypeProvider;
import com.technologica.resourcegen.data.dimension.DimensionProvider;
import com.technologica.resourcegen.data.dimensiontype.DimensionTypeProvider;
import com.technologica.resourcegen.data.worldgen.biome.BiomeProvider;
import com.technologica.resourcegen.data.worldgen.biome.BiomeModifierProvider;
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
import net.minecraftforge.registries.ForgeRegistries;

public abstract class MasterResourceProvider {
	private static GatherDataEvent event;
	private static DataGenerator generator;
	static PackOutput packOutput;
	static ExistingFileHelper helper;
	static CompletableFuture<HolderLookup.Provider> lookupProvider;
	static RegistrySetBuilder registrySetBuilder;
	
	@SuppressWarnings({ "unchecked", "rawtypes" })
	protected static void setup(final GatherDataEvent eventIn) {
		event = eventIn;
		generator = event.getGenerator();
		packOutput = generator.getPackOutput();
		helper = event.getExistingFileHelper();
		lookupProvider = event.getLookupProvider();
		
		registrySetBuilder = new RegistrySetBuilder()
			.add(Registries.DIMENSION_TYPE, DimensionTypeProvider::bootstrap)
			
			.add(Registries.CONFIGURED_FEATURE, (RegistrySetBuilder.RegistryBootstrap) ConfiguredFeatureProvider::bootstrap)
			.add(Registries.PLACED_FEATURE, PlacedFeatureProvider::bootstrap)
			
			.add(Registries.STRUCTURE, StructureProvider::bootstrap)
			.add(Registries.STRUCTURE_SET, StructureSetProvider::bootstrap)
			.add(Registries.TEMPLATE_POOL, TemplatePoolProvider::bootstrap)
			.add(Registries.BIOME, BiomeProvider::bootstrap)
			.add(Registries.NOISE_SETTINGS, NoiseSettingsProvider::bootstrap)
			.add(Registries.LEVEL_STEM, DimensionProvider::bootstrap)
			.add(Registries.DAMAGE_TYPE, DamageTypeProvider::bootstrap)
			.add(ForgeRegistries.Keys.BIOME_MODIFIERS, BiomeModifierProvider::bootstrap);
	}
	
	protected static void addAssetProvider(DataProvider provider) {
		generator.addProvider(event.includeClient(), provider) ;
	}
	
	protected static void addDataProvider(DataProvider provider) {
		generator.addProvider(event.includeServer(), provider) ;
	}
	
	protected static void addIntermediateDataProvider(IntermediateDataGenerator intermediateProvider) {
		List<DataProvider> list = intermediateProvider.getSubProviders();
		for (DataProvider provider : list) {
			generator.addProvider(event.includeServer(), provider);
		}
	}
}