package com.technologica.datagen.registries;

import java.util.Set;
import java.util.concurrent.CompletableFuture;

import com.technologica.Technologica;
import com.technologica.datagen.data.damagetype.DamageTypeDataGenerator;
import com.technologica.datagen.data.dimension.DimensionDataGenerator;
import com.technologica.datagen.data.dimensiontype.DimensionTypeDataGenerator;
import com.technologica.datagen.data.worldgen.biome.BiomeDataGenerator;
import com.technologica.datagen.data.worldgen.biome.TechnologicaBiomeModifiers;
import com.technologica.datagen.data.worldgen.configuredfeature.TechnologicaFeatureUtils;
import com.technologica.datagen.data.worldgen.noisesettings.NoiseSettingsDataGenerator;
import com.technologica.datagen.data.worldgen.placedfeature.TechnologicaPlacementUtils;
import com.technologica.datagen.data.worldgen.structure.StructureDataGenerator;
import com.technologica.datagen.data.worldgen.structuresets.StructureSetDataGenerator;

import net.minecraft.core.HolderLookup.Provider;
import net.minecraft.core.RegistrySetBuilder;
import net.minecraft.core.registries.Registries;
import net.minecraft.data.PackOutput;
import net.minecraftforge.common.data.DatapackBuiltinEntriesProvider;
import net.minecraftforge.registries.ForgeRegistries;

public class TechnologicaDatapackBuiltinEntriesProvider extends DatapackBuiltinEntriesProvider {

	@SuppressWarnings({ "unchecked", "rawtypes" })
	private static final RegistrySetBuilder BUILDER = new RegistrySetBuilder().add(Registries.DIMENSION_TYPE, DimensionTypeDataGenerator::bootstrap).add(Registries.CONFIGURED_FEATURE, (RegistrySetBuilder.RegistryBootstrap) TechnologicaFeatureUtils::bootstrap).add(Registries.PLACED_FEATURE, TechnologicaPlacementUtils::bootstrap).add(Registries.STRUCTURE, StructureDataGenerator::bootstrap).add(Registries.STRUCTURE_SET, StructureSetDataGenerator::bootstrap).add(Registries.BIOME, BiomeDataGenerator::bootstrap).add(Registries.NOISE_SETTINGS, NoiseSettingsDataGenerator::bootstrap).add(Registries.LEVEL_STEM, DimensionDataGenerator::bootstrap).add(Registries.DAMAGE_TYPE, DamageTypeDataGenerator::bootstrap);

	public TechnologicaDatapackBuiltinEntriesProvider(PackOutput output, CompletableFuture<Provider> registries) {
		super(output, registries, BUILDER.add(ForgeRegistries.Keys.BIOME_MODIFIERS, context -> {
			TechnologicaBiomeModifiers.bootstrap(context);
		}), Set.of(Technologica.MODID));
	}
}