package com.technologica.world.biome;

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

public class ModBiomes {
	public static final DeferredRegister<Biome> BIOMES = DeferredRegister.create(ForgeRegistries.BIOMES, MODID);
	
	public static final RegistryObject<Biome> SALT_FLATS = BIOMES.register("salt_flats", () -> new Biome.Builder()
			.precipitation(RainType.NONE)
			.category(Category.MESA)
			.depth(0)
			.scale(0)
			.temperature(0)
			.withTemperatureModifier(TemperatureModifier.NONE)
			.downfall(0)
			.setEffects(new BiomeAmbience.Builder()
					.setFogColor(0)
					.setWaterColor(0)
					.setWaterFogColor(0)
					.withSkyColor(0).build())
			.withMobSpawnSettings(MobSpawnInfo.EMPTY)
			.withGenerationSettings(BiomeGenerationSettings.DEFAULT_SETTINGS).build());
	public static final RegistryObject<Biome> REDWOOD_FOREST = BIOMES.register("redwood_forest", () -> new Biome.Builder()
			.precipitation(RainType.NONE)
			.category(Category.MESA)
			.depth(0)
			.scale(0)
			.temperature(0)
			.withTemperatureModifier(TemperatureModifier.NONE)
			.downfall(0)
			.setEffects(new BiomeAmbience.Builder()
					.setFogColor(0)
					.setWaterColor(0)
					.setWaterFogColor(0)
					.withSkyColor(0).build())
			.withMobSpawnSettings(MobSpawnInfo.EMPTY)
			.withGenerationSettings(BiomeGenerationSettings.DEFAULT_SETTINGS).build());
	public static final RegistryObject<Biome> RAINFOREST = BIOMES.register("rainforest", () -> new Biome.Builder()
			.precipitation(RainType.NONE)
			.category(Category.MESA)
			.depth(0)
			.scale(0)
			.temperature(0)
			.withTemperatureModifier(TemperatureModifier.NONE)
			.downfall(0)
			.setEffects(new BiomeAmbience.Builder()
					.setFogColor(0)
					.setWaterColor(0)
					.setWaterFogColor(0)
					.withSkyColor(0).build())
			.withMobSpawnSettings(MobSpawnInfo.EMPTY)
			.withGenerationSettings(BiomeGenerationSettings.DEFAULT_SETTINGS).build());
	
	public static void register() 
    {
        BIOMES.register(FMLJavaModLoadingContext.get().getModEventBus()); 
    }
}
