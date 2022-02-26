package com.technologica.world.level.biome;

import static com.technologica.Technologica.LOGGER;
import static com.technologica.Technologica.MODID;

import net.minecraft.world.level.biome.Biome;
import net.minecraft.world.level.biome.Biome.BiomeCategory;
import net.minecraft.world.level.biome.Biome.Precipitation;
import net.minecraft.world.level.biome.Biome.TemperatureModifier;
import net.minecraft.world.level.biome.BiomeGenerationSettings;
import net.minecraft.world.level.biome.BiomeSpecialEffects;
import net.minecraft.world.level.biome.MobSpawnSettings;
import net.minecraftforge.fml.javafmlmod.FMLJavaModLoadingContext;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.ForgeRegistries;
import net.minecraftforge.registries.RegistryObject;

public class TechnologicaBiomes {
	public static final DeferredRegister<Biome> BIOMES = DeferredRegister.create(ForgeRegistries.BIOMES, MODID);
	
	public static void init() {
		LOGGER.info("INITIALIZING BIOMES");
        BIOMES.register(FMLJavaModLoadingContext.get().getModEventBus());
        LOGGER.info(BIOMES.getEntries().size() + " BIOMES INITIALIZED");
    }
	
	public static final RegistryObject<Biome> SALT_FLATS = BIOMES.register("salt_flats", () -> new Biome.BiomeBuilder()
			.precipitation(Precipitation.NONE)
			.biomeCategory(BiomeCategory.MESA)
			.temperature(0)
			.temperatureAdjustment(TemperatureModifier.NONE)
			.downfall(0)
			.specialEffects(new BiomeSpecialEffects.Builder()
					.fogColor(0)
					.waterColor(0)
					.waterFogColor(0)
					.skyColor(0).build())
			.mobSpawnSettings(MobSpawnSettings.EMPTY)
			.generationSettings(BiomeGenerationSettings.EMPTY).build());
	public static final RegistryObject<Biome> REDWOOD_FOREST = BIOMES.register("redwood_forest", () -> new Biome.BiomeBuilder()
			.precipitation(Precipitation.NONE)
			.biomeCategory(BiomeCategory.MESA)
			.temperature(0)
			.temperatureAdjustment(TemperatureModifier.NONE)
			.downfall(0)
			.specialEffects(new BiomeSpecialEffects.Builder()
					.fogColor(0)
					.waterColor(0)
					.waterFogColor(0)
					.skyColor(0).build())
			.mobSpawnSettings(MobSpawnSettings.EMPTY)
			.generationSettings(BiomeGenerationSettings.EMPTY).build());
	public static final RegistryObject<Biome> RAINFOREST = BIOMES.register("rainforest", () -> new Biome.BiomeBuilder()
			.precipitation(Precipitation.NONE)
			.biomeCategory(BiomeCategory.MESA)
			.temperature(0)
			.temperatureAdjustment(TemperatureModifier.NONE)
			.downfall(0)
			.specialEffects(new BiomeSpecialEffects.Builder()
					.fogColor(0)
					.waterColor(0)
					.waterFogColor(0)
					.skyColor(0).build())
			.mobSpawnSettings(MobSpawnSettings.EMPTY)
			.generationSettings(BiomeGenerationSettings.EMPTY).build());
	public static final RegistryObject<Biome> COAST = BIOMES.register("coast", () -> new Biome.BiomeBuilder()
			.precipitation(Precipitation.NONE)
			.biomeCategory(BiomeCategory.MESA)
			.temperature(0)
			.temperatureAdjustment(TemperatureModifier.NONE)
			.downfall(0)
			.specialEffects(new BiomeSpecialEffects.Builder()
					.fogColor(0)
					.waterColor(0)
					.waterFogColor(0)
					.skyColor(0).build())
			.mobSpawnSettings(MobSpawnSettings.EMPTY)
			.generationSettings(BiomeGenerationSettings.EMPTY).build());
}
