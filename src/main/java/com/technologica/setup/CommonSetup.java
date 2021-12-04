package com.technologica.setup;

import java.util.Collection;
import java.util.function.Supplier;

import com.technologica.Technologica;
import com.technologica.block.TechnologicaBlocks;
import com.technologica.capabilities.TechnologicaCapabilities;
import com.technologica.network.play.server.Packets;

import net.minecraft.block.Block;
import net.minecraft.block.Blocks;
import net.minecraft.block.FlowerPotBlock;
import net.minecraft.block.SaplingBlock;
import net.minecraft.util.RegistryKey;
import net.minecraft.util.ResourceLocation;
import net.minecraft.util.registry.Registry;
import net.minecraft.world.biome.Biome;
import net.minecraftforge.common.BiomeManager;
import net.minecraftforge.common.BiomeManager.BiomeEntry;
import net.minecraftforge.common.BiomeManager.BiomeType;
import net.minecraftforge.fml.RegistryObject;
import net.minecraftforge.fml.event.lifecycle.FMLCommonSetupEvent;

public class CommonSetup {
	public static final RegistryKey<Biome> saltFlatsBiomeKey = RegistryKey.getOrCreateKey(Registry.BIOME_KEY, new ResourceLocation(Technologica.MODID, "salt_flats"));
	public static final RegistryKey<Biome> redwoodForestBiomeKey = RegistryKey.getOrCreateKey(Registry.BIOME_KEY, new ResourceLocation(Technologica.MODID, "redwood_forest"));
	public static final RegistryKey<Biome> rainforestBiomeKey = RegistryKey.getOrCreateKey(Registry.BIOME_KEY, new ResourceLocation(Technologica.MODID, "rainforest"));
	
	public static void init(final FMLCommonSetupEvent event) {
		TechnologicaCapabilities.register();
		Packets.onCommonSetupEvent();

		event.enqueueWork(() -> {
			automaticFlowerPots(TechnologicaBlocks.BLOCKS.getEntries());
			
			BiomeManager.addBiome(BiomeType.DESERT, new BiomeEntry(saltFlatsBiomeKey, 1000));
			BiomeManager.addBiome(BiomeType.COOL, new BiomeEntry(redwoodForestBiomeKey, 1000));
			BiomeManager.addBiome(BiomeType.WARM, new BiomeEntry(rainforestBiomeKey, 1000));
			
		});
	}

	private final static void automaticFlowerPots(Collection<RegistryObject<Block>> collection) {
		for (Supplier<? extends Block> blockSupplier : collection) {
			Block block = blockSupplier.get();
			
			for (Supplier<? extends Block> blockSupplier2 : collection) {
				Block block2 = blockSupplier2.get();
				
				if (block.getClass().equals(SaplingBlock.class) && block2.getClass().equals(FlowerPotBlock.class) && block2.getRegistryName().getPath().contains(block.getRegistryName().getPath())) {
					((FlowerPotBlock) Blocks.FLOWER_POT).addPlant(block.getRegistryName(), blockSupplier2);
				}	
			}
		}
	}
}