package com.technologica.setup;

import static net.minecraft.entity.passive.horse.AbstractHorseEntity.func_234237_fg_;

import java.util.Collection;
import java.util.function.Supplier;

import com.technologica.Technologica;
import com.technologica.block.TechnologicaBlocks;
import com.technologica.capabilities.TechnologicaCapabilities;
import com.technologica.entity.TechnologicaEntityType;
import com.technologica.entity.monster.ScorpionEntity;
import com.technologica.entity.monster.SharkEntity;
import com.technologica.entity.passive.CoyoteEntity;
import com.technologica.entity.passive.DuckEntity;
import com.technologica.entity.passive.GrizzlyBearEntity;
import com.technologica.network.play.server.Packets;

import net.minecraft.block.Block;
import net.minecraft.block.Blocks;
import net.minecraft.block.FlowerPotBlock;
import net.minecraft.block.SaplingBlock;
import net.minecraft.entity.ai.attributes.GlobalEntityTypeAttributes;
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
	
	@SuppressWarnings("deprecation")
	public static void init(final FMLCommonSetupEvent event) {
		TechnologicaCapabilities.register();
		Packets.onCommonSetupEvent();
		GlobalEntityTypeAttributes.put(TechnologicaEntityType.COYOTE.get(), CoyoteEntity.registerAttributes().create());
		GlobalEntityTypeAttributes.put(TechnologicaEntityType.DUCK.get(), DuckEntity.registerAttributes().create());
		GlobalEntityTypeAttributes.put(TechnologicaEntityType.GIRAFFE.get(), func_234237_fg_().create());
		GlobalEntityTypeAttributes.put(TechnologicaEntityType.GRIZZLY_BEAR.get(), GrizzlyBearEntity.registerAttributes().create());
		GlobalEntityTypeAttributes.put(TechnologicaEntityType.OSTRICH.get(), func_234237_fg_().create());
		GlobalEntityTypeAttributes.put(TechnologicaEntityType.SCORPION.get(), ScorpionEntity.registerAttributes().create());
		GlobalEntityTypeAttributes.put(TechnologicaEntityType.SHARK.get(), SharkEntity.registerAttributes().create());
		GlobalEntityTypeAttributes.put(TechnologicaEntityType.ZEBRA.get(), func_234237_fg_().create());
		GlobalEntityTypeAttributes.put(TechnologicaEntityType.PEEPER.get(), func_234237_fg_().create());
		GlobalEntityTypeAttributes.put(TechnologicaEntityType.SWEEPER.get(), func_234237_fg_().create());

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