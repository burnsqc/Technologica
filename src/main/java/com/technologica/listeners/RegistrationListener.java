package com.technologica.listeners;

import static com.technologica.Technologica.LOGGER;

import java.util.ArrayList;
import java.util.List;

import net.minecraft.core.particles.ParticleType;
import net.minecraft.sounds.SoundEvent;
import net.minecraft.world.entity.EntityType;
import net.minecraft.world.inventory.MenuType;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.crafting.RecipeSerializer;
import net.minecraft.world.level.biome.Biome;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.entity.BlockEntityType;
import net.minecraft.world.level.levelgen.feature.Feature;
import net.minecraft.world.level.levelgen.feature.foliageplacers.FoliagePlacerType;
import net.minecraft.world.level.material.Fluid;
import net.minecraftforge.common.ForgeSpawnEggItem;
import net.minecraftforge.event.RegistryEvent.Register;
import net.minecraftforge.eventbus.api.SubscribeEvent;

public class RegistrationListener {
	protected static final List<ForgeSpawnEggItem> UNADDED_EGGS = new ArrayList<>();
	@SubscribeEvent
	public static void onRegisterBlocks(final Register<Block> event) {
		LOGGER.info("REGISTERING BLOCKS");
		LOGGER.info(event.getRegistry().getEntries().size());
	}
	
	@SubscribeEvent
	public static void onRegisterItems(final Register<Item> event) {
		LOGGER.info("REGISTERING ITEMS");
		LOGGER.info(event.getRegistry().getEntries().size());
	}
	
	@SubscribeEvent
	public static void onRegisterTileEntities(final Register<BlockEntityType<?>> event) {
		LOGGER.info("REGISTERING TILE ENTITIES");
		LOGGER.info(event.getRegistry().getEntries().size());
	}
	
	@SubscribeEvent
	public static void onRegisterEntities(final Register<EntityType<?>> event) {
		LOGGER.info("REGISTERING ENTITIES");
		LOGGER.info(event.getRegistry().getEntries().size());
	}
	
	@SubscribeEvent
	public static void onRegisterFluids(final Register<Fluid> event) {
		LOGGER.info("REGISTERING FLUIDS");
		LOGGER.info(event.getRegistry().getEntries().size());
	}
	
	@SubscribeEvent
	public static void onRegisterRecipeSerializers(final Register<RecipeSerializer<?>> event) {
		LOGGER.info("REGISTERING RECIPE SERIALIZERS");
		LOGGER.info(event.getRegistry().getEntries().size());
	}
	
	@SubscribeEvent
	public static void onRegisterContainers(final Register<MenuType<?>> event) {
		LOGGER.info("REGISTERING CONTAINERS");
		LOGGER.info(event.getRegistry().getEntries().size());
	}
	
	@SubscribeEvent
	public static void onRegisterParticles(final Register<ParticleType<?>> event) {
		LOGGER.info("REGISTERING PARTICLES");
		LOGGER.info(event.getRegistry().getEntries().size());
	}
	
	@SubscribeEvent
	public static void onRegisterSoundEvents(final Register<SoundEvent> event) {
		LOGGER.info("REGISTERING SOUND EVENTS");
		LOGGER.info(event.getRegistry().getEntries().size());
	}
	
	@SubscribeEvent
	public static void onRegisterFeatures(final Register<Feature<?>> event) {
		LOGGER.info("REGISTERING FEATURES");
		LOGGER.info(event.getRegistry().getEntries().size());
	}
	
	@SubscribeEvent
	public static void onRegisterFoliagePlacers(final Register<FoliagePlacerType<?>> event) {
		LOGGER.info("REGISTERING FOLIAGE PLACERS");
		LOGGER.info(event.getRegistry().getEntries().size());
	}
	
	//@SubscribeEvent
	//public static void onRegisterSurfaceBuilders(final Register<SurfaceBuilder<?>> event) {
	//	LOGGER.info("REGISTERING SURFACE BUILDERS");
	//	LOGGER.info(event.getRegistry().getEntries().size());
	//}
	
	@SubscribeEvent
	public static void onRegisterBiomes(final Register<Biome> event) {
		LOGGER.info("REGISTERING BIOMES");
		LOGGER.info(event.getRegistry().getEntries().size());
	}
}
