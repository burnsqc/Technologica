package com.technologica.setup;

import com.technologica.Technologica;
import com.technologica.capabilities.TechnologicaCapabilities;
import com.technologica.network.play.server.Packets;
import com.technologica.world.level.block.TechnologicaBlocks;
import com.technologica.world.level.block.state.properties.TechnologicaWoodType;

import net.minecraft.world.level.block.Blocks;
import net.minecraft.world.level.block.FlowerPotBlock;
import net.minecraft.world.level.block.state.properties.WoodType;
import net.minecraft.resources.ResourceKey;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.core.Registry;
import net.minecraft.world.level.biome.Biome;
import net.minecraftforge.common.BiomeManager;
import net.minecraftforge.common.BiomeManager.BiomeEntry;
import net.minecraftforge.common.BiomeManager.BiomeType;
import net.minecraftforge.fml.event.lifecycle.FMLCommonSetupEvent;

public class CommonSetup {
	public static final ResourceKey<Biome> saltFlatsBiomeKey = ResourceKey.create(Registry.BIOME_REGISTRY, new ResourceLocation(Technologica.MODID, "salt_flats"));
	public static final ResourceKey<Biome> redwoodForestBiomeKey = ResourceKey.create(Registry.BIOME_REGISTRY, new ResourceLocation(Technologica.MODID, "redwood_forest"));
	public static final ResourceKey<Biome> rainforestBiomeKey = ResourceKey.create(Registry.BIOME_REGISTRY, new ResourceLocation(Technologica.MODID, "rainforest"));
	public static final ResourceKey<Biome> coastBiomeKey = ResourceKey.create(Registry.BIOME_REGISTRY, new ResourceLocation(Technologica.MODID, "coast"));
	
	public static void init(final FMLCommonSetupEvent event) {
		FlowerPotBlock flowerPotBlock = (FlowerPotBlock) Blocks.FLOWER_POT;
		TechnologicaCapabilities.init();
		Packets.onCommonSetupEvent();

		event.enqueueWork(() -> {
			WoodType.register(TechnologicaWoodType.ALCHEMICAL);
			WoodType.register(TechnologicaWoodType.APRICOT);
			WoodType.register(TechnologicaWoodType.ASPEN);
			WoodType.register(TechnologicaWoodType.AVOCADO);
			WoodType.register(TechnologicaWoodType.BANANA);
			WoodType.register(TechnologicaWoodType.BENEVOLENT);
			WoodType.register(TechnologicaWoodType.CHERRY);
			WoodType.register(TechnologicaWoodType.CHESTNUT);
			WoodType.register(TechnologicaWoodType.CINNAMON);
			WoodType.register(TechnologicaWoodType.COCONUT);
			WoodType.register(TechnologicaWoodType.CONDUCTIVE);
			WoodType.register(TechnologicaWoodType.EBONY);
			WoodType.register(TechnologicaWoodType.FROSTBITTEN);
			WoodType.register(TechnologicaWoodType.FRUITFUL);
			WoodType.register(TechnologicaWoodType.INFERNAL);
			WoodType.register(TechnologicaWoodType.KIWI);
			WoodType.register(TechnologicaWoodType.LEMON);
			WoodType.register(TechnologicaWoodType.LIME);
			WoodType.register(TechnologicaWoodType.MAHOGANY);
			WoodType.register(TechnologicaWoodType.MALEVOLENT);
			WoodType.register(TechnologicaWoodType.MAPLE);
			WoodType.register(TechnologicaWoodType.NECROTIC);
			WoodType.register(TechnologicaWoodType.OLIVE);
			WoodType.register(TechnologicaWoodType.ORANGE);
			WoodType.register(TechnologicaWoodType.PEACH);
			WoodType.register(TechnologicaWoodType.PEAR);
			WoodType.register(TechnologicaWoodType.PLUM);
			WoodType.register(TechnologicaWoodType.REDWOOD);
			WoodType.register(TechnologicaWoodType.ROSEWOOD);
			WoodType.register(TechnologicaWoodType.RUBBER);
			WoodType.register(TechnologicaWoodType.TEAK);
			WoodType.register(TechnologicaWoodType.WALNUT);
			WoodType.register(TechnologicaWoodType.ZEBRAWOOD);
			
			flowerPotBlock.addPlant(TechnologicaBlocks.APRICOT_SAPLING.get().getRegistryName(), TechnologicaBlocks.POTTED_APRICOT_SAPLING);
			flowerPotBlock.addPlant(TechnologicaBlocks.ASPEN_SAPLING.get().getRegistryName(), TechnologicaBlocks.POTTED_ASPEN_SAPLING);
			flowerPotBlock.addPlant(TechnologicaBlocks.AVOCADO_SAPLING.get().getRegistryName(), TechnologicaBlocks.POTTED_AVOCADO_SAPLING);
			flowerPotBlock.addPlant(TechnologicaBlocks.BANANA_SAPLING.get().getRegistryName(), TechnologicaBlocks.POTTED_BANANA_SAPLING);
			flowerPotBlock.addPlant(TechnologicaBlocks.CHERRY_SAPLING.get().getRegistryName(), TechnologicaBlocks.POTTED_CHERRY_SAPLING);
			flowerPotBlock.addPlant(TechnologicaBlocks.CHESTNUT_SAPLING.get().getRegistryName(), TechnologicaBlocks.POTTED_CHESTNUT_SAPLING);
			flowerPotBlock.addPlant(TechnologicaBlocks.CINNAMON_SAPLING.get().getRegistryName(), TechnologicaBlocks.POTTED_CINNAMON_SAPLING);
			flowerPotBlock.addPlant(TechnologicaBlocks.COCONUT_SAPLING.get().getRegistryName(), TechnologicaBlocks.POTTED_COCONUT_SAPLING);
			flowerPotBlock.addPlant(TechnologicaBlocks.EBONY_SAPLING.get().getRegistryName(), TechnologicaBlocks.POTTED_EBONY_SAPLING);
			flowerPotBlock.addPlant(TechnologicaBlocks.KIWI_SAPLING.get().getRegistryName(), TechnologicaBlocks.POTTED_KIWI_SAPLING);
			flowerPotBlock.addPlant(TechnologicaBlocks.LEMON_SAPLING.get().getRegistryName(), TechnologicaBlocks.POTTED_LEMON_SAPLING);
			flowerPotBlock.addPlant(TechnologicaBlocks.LIME_SAPLING.get().getRegistryName(), TechnologicaBlocks.POTTED_LIME_SAPLING);
			flowerPotBlock.addPlant(TechnologicaBlocks.MAHOGANY_SAPLING.get().getRegistryName(), TechnologicaBlocks.POTTED_MAHOGANY_SAPLING);
			flowerPotBlock.addPlant(TechnologicaBlocks.MAPLE_SAPLING.get().getRegistryName(), TechnologicaBlocks.POTTED_MAPLE_SAPLING);
			flowerPotBlock.addPlant(TechnologicaBlocks.OLIVE_SAPLING.get().getRegistryName(), TechnologicaBlocks.POTTED_OLIVE_SAPLING);
			flowerPotBlock.addPlant(TechnologicaBlocks.ORANGE_SAPLING.get().getRegistryName(), TechnologicaBlocks.POTTED_ORANGE_SAPLING);
			flowerPotBlock.addPlant(TechnologicaBlocks.PEACH_SAPLING.get().getRegistryName(), TechnologicaBlocks.POTTED_PEACH_SAPLING);
			flowerPotBlock.addPlant(TechnologicaBlocks.PEAR_SAPLING.get().getRegistryName(), TechnologicaBlocks.POTTED_PEAR_SAPLING);
			flowerPotBlock.addPlant(TechnologicaBlocks.PLUM_SAPLING.get().getRegistryName(), TechnologicaBlocks.POTTED_PLUM_SAPLING);
			flowerPotBlock.addPlant(TechnologicaBlocks.REDWOOD_SAPLING.get().getRegistryName(), TechnologicaBlocks.POTTED_REDWOOD_SAPLING);
			flowerPotBlock.addPlant(TechnologicaBlocks.ROSEWOOD_SAPLING.get().getRegistryName(), TechnologicaBlocks.POTTED_ROSEWOOD_SAPLING);
			flowerPotBlock.addPlant(TechnologicaBlocks.RUBBER_SAPLING.get().getRegistryName(), TechnologicaBlocks.POTTED_RUBBER_SAPLING);
			flowerPotBlock.addPlant(TechnologicaBlocks.TEAK_SAPLING.get().getRegistryName(), TechnologicaBlocks.POTTED_TEAK_SAPLING);
			flowerPotBlock.addPlant(TechnologicaBlocks.WALNUT_SAPLING.get().getRegistryName(), TechnologicaBlocks.POTTED_WALNUT_SAPLING);
			flowerPotBlock.addPlant(TechnologicaBlocks.ZEBRAWOOD_SAPLING.get().getRegistryName(), TechnologicaBlocks.POTTED_ZEBRAWOOD_SAPLING);
			flowerPotBlock.addPlant(TechnologicaBlocks.ANCIENT_AMBROSIA_SAPLING.get().getRegistryName(), TechnologicaBlocks.POTTED_ANCIENT_AMBROSIA_SAPLING);
			flowerPotBlock.addPlant(TechnologicaBlocks.BENEVOLENT_APOTHECARY_SAPLING.get().getRegistryName(), TechnologicaBlocks.POTTED_BENEVOLENT_APOTHECARY_SAPLING);
			flowerPotBlock.addPlant(TechnologicaBlocks.CRYOGENIC_SPIRE_SAPLING.get().getRegistryName(), TechnologicaBlocks.POTTED_CRYOGENIC_SPIRE_SAPLING);
			flowerPotBlock.addPlant(TechnologicaBlocks.MALEVOLENT_APOTHECARY_SAPLING.get().getRegistryName(), TechnologicaBlocks.POTTED_MALEVOLENT_APOTHECARY_SAPLING);
			flowerPotBlock.addPlant(TechnologicaBlocks.NECROTIC_SAPLING.get().getRegistryName(), TechnologicaBlocks.POTTED_NECROTIC_SAPLING);
			flowerPotBlock.addPlant(TechnologicaBlocks.SERENDIPITOUS_APOTHECARY_SAPLING.get().getRegistryName(), TechnologicaBlocks.POTTED_SERENDIPITOUS_APOTHECARY_SAPLING);
			flowerPotBlock.addPlant(TechnologicaBlocks.THUNDEROUS_CONDUCTOR_SAPLING.get().getRegistryName(), TechnologicaBlocks.POTTED_THUNDEROUS_CONDUCTOR_SAPLING);
			flowerPotBlock.addPlant(TechnologicaBlocks.TOWERING_INFERNO_SAPLING.get().getRegistryName(), TechnologicaBlocks.POTTED_TOWERING_INFERNO_SAPLING);
			
			BiomeManager.addBiome(BiomeType.DESERT, new BiomeEntry(saltFlatsBiomeKey, 1000));
			BiomeManager.addBiome(BiomeType.COOL, new BiomeEntry(redwoodForestBiomeKey, 1000));
			BiomeManager.addBiome(BiomeType.WARM, new BiomeEntry(rainforestBiomeKey, 1000));
			BiomeManager.addBiome(BiomeType.WARM, new BiomeEntry(coastBiomeKey, 1000));
		});
	}
}
