package com.technologica.world.biome;

import static com.technologica.Technologica.LOGGER;
import static com.technologica.Technologica.MODID;

import net.minecraft.world.biome.Biome;
import net.minecraft.world.biome.Biome.Category;
import net.minecraft.world.biome.Biome.RainType;
import net.minecraft.world.biome.Biome.TemperatureModifier;
import net.minecraft.world.biome.BiomeAmbience;
import net.minecraft.world.biome.BiomeGenerationSettings;
import net.minecraft.world.biome.MobSpawnInfo;
import net.minecraftforge.fml.RegistryObject;
import net.minecraftforge.fml.javafmlmod.FMLJavaModLoadingContext;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.ForgeRegistries;

public class TechnologicaBiomes {
	public static final DeferredRegister<Biome> BIOMES = DeferredRegister.create(ForgeRegistries.BIOMES, MODID);
	
	public static void init() {
		LOGGER.info("INITIALIZING BIOMES");
        BIOMES.register(FMLJavaModLoadingContext.get().getModEventBus());
        LOGGER.info(BIOMES.getEntries().size() + " BIOMES INITIALIZED");
    }
	
	public static final RegistryObject<Biome> SALT_FLATS = BIOMES.register("salt_flats", () -> new Biome.Builder()
			.precipitation(RainType.NONE)
			.biomeCategory(Category.MESA)
			.depth(0)
			.scale(0)
			.temperature(0)
			.temperatureAdjustment(TemperatureModifier.NONE)
			.downfall(0)
			.specialEffects(new BiomeAmbience.Builder()
					.fogColor(0)
					.waterColor(0)
					.waterFogColor(0)
					.skyColor(0).build())
			.mobSpawnSettings(MobSpawnInfo.EMPTY)
			.generationSettings(BiomeGenerationSettings.EMPTY).build());
	public static final RegistryObject<Biome> REDWOOD_FOREST = BIOMES.register("redwood_forest", () -> new Biome.Builder()
			.precipitation(RainType.NONE)
			.biomeCategory(Category.MESA)
			.depth(0)
			.scale(0)
			.temperature(0)
			.temperatureAdjustment(TemperatureModifier.NONE)
			.downfall(0)
			.specialEffects(new BiomeAmbience.Builder()
					.fogColor(0)
					.waterColor(0)
					.waterFogColor(0)
					.skyColor(0).build())
			.mobSpawnSettings(MobSpawnInfo.EMPTY)
			.generationSettings(BiomeGenerationSettings.EMPTY).build());
	public static final RegistryObject<Biome> RAINFOREST = BIOMES.register("rainforest", () -> new Biome.Builder()
			.precipitation(RainType.NONE)
			.biomeCategory(Category.MESA)
			.depth(0)
			.scale(0)
			.temperature(0)
			.temperatureAdjustment(TemperatureModifier.NONE)
			.downfall(0)
			.specialEffects(new BiomeAmbience.Builder()
					.fogColor(0)
					.waterColor(0)
					.waterFogColor(0)
					.skyColor(0).build())
			.mobSpawnSettings(MobSpawnInfo.EMPTY)
			.generationSettings(BiomeGenerationSettings.EMPTY).build());
	public static final RegistryObject<Biome> COAST = BIOMES.register("coast", () -> new Biome.Builder()
			.precipitation(RainType.NONE)
			.biomeCategory(Category.MESA)
			.depth(0)
			.scale(0)
			.temperature(0)
			.temperatureAdjustment(TemperatureModifier.NONE)
			.downfall(0)
			.specialEffects(new BiomeAmbience.Builder()
					.fogColor(0)
					.waterColor(0)
					.waterFogColor(0)
					.skyColor(0).build())
			.mobSpawnSettings(MobSpawnInfo.EMPTY)
			.generationSettings(BiomeGenerationSettings.EMPTY).build());
}
