package com.technologica.listeners;

import static com.technologica.Technologica.LOGGER;

import com.technologica.item.ModSpawnEggItem;

import net.minecraft.block.Block;
import net.minecraft.entity.EntityType;
import net.minecraft.fluid.Fluid;
import net.minecraft.inventory.container.ContainerType;
import net.minecraft.item.Item;
import net.minecraft.item.crafting.IRecipeSerializer;
import net.minecraft.particles.ParticleType;
import net.minecraft.tileentity.TileEntityType;
import net.minecraft.util.SoundEvent;
import net.minecraft.world.biome.Biome;
import net.minecraft.world.gen.feature.Feature;
import net.minecraft.world.gen.foliageplacer.FoliagePlacerType;
import net.minecraft.world.gen.surfacebuilders.SurfaceBuilder;
import net.minecraftforge.event.RegistryEvent.Register;
import net.minecraftforge.eventbus.api.SubscribeEvent;

public class RegistrationListener {

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
	public static void onRegisterTileEntities(final Register<TileEntityType<?>> event) {
		LOGGER.info("REGISTERING TILE ENTITIES");
		LOGGER.info(event.getRegistry().getEntries().size());
	}
	
	@SubscribeEvent
	public static void onRegisterEntities(final Register<EntityType<?>> event) {
		LOGGER.info("REGISTERING ENTITIES");
		ModSpawnEggItem.initSpawnEggs();
		LOGGER.info(event.getRegistry().getEntries().size());
	}
	
	@SubscribeEvent
	public static void onRegisterFluids(final Register<Fluid> event) {
		LOGGER.info("REGISTERING FLUIDS");
		LOGGER.info(event.getRegistry().getEntries().size());
	}
	
	@SubscribeEvent
	public static void onRegisterRecipeSerializers(final Register<IRecipeSerializer<?>> event) {
		LOGGER.info("REGISTERING RECIPE SERIALIZERS");
		LOGGER.info(event.getRegistry().getEntries().size());
	}
	
	@SubscribeEvent
	public static void onRegisterContainers(final Register<ContainerType<?>> event) {
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
	
	@SubscribeEvent
	public static void onRegisterSurfaceBuilders(final Register<SurfaceBuilder<?>> event) {
		LOGGER.info("REGISTERING SURFACE BUILDERS");
		LOGGER.info(event.getRegistry().getEntries().size());
	}
	
	@SubscribeEvent
	public static void onRegisterBiomes(final Register<Biome> event) {
		LOGGER.info("REGISTERING BIOMES");
		LOGGER.info(event.getRegistry().getEntries().size());
	}
}
