package com.technologica.setup;

import static net.minecraft.entity.passive.horse.AbstractHorseEntity.func_234237_fg_;

import java.util.Collection;
import java.util.function.Supplier;

import com.technologica.Technologica;
import com.technologica.block.TechnologicaBlocks;
import com.technologica.capabilities.TechnologicaCapabilities;
import com.technologica.entity.TechnologicaEntityType;
import com.technologica.entity.passive.AlligatorEntity;
import com.technologica.entity.passive.BeaverEntity;
import com.technologica.entity.passive.BuffaloEntity;
import com.technologica.entity.passive.CamelEntity;
import com.technologica.entity.passive.CobraEntity;
import com.technologica.entity.passive.CottonmouthEntity;
import com.technologica.entity.passive.CoyoteEntity;
import com.technologica.entity.passive.CrabEntity;
import com.technologica.entity.passive.DeerEntity;
import com.technologica.entity.passive.DuckEntity;
import com.technologica.entity.passive.ElephantEntity;
import com.technologica.entity.passive.FlamingoEntity;
import com.technologica.entity.passive.FrogEntity;
import com.technologica.entity.passive.GorillaEntity;
import com.technologica.entity.passive.GrizzlyBearEntity;
import com.technologica.entity.passive.JaguarEntity;
import com.technologica.entity.passive.KingCrabEntity;
import com.technologica.entity.passive.LeopardSealEntity;
import com.technologica.entity.passive.LionEntity;
import com.technologica.entity.passive.LizardEntity;
import com.technologica.entity.passive.MooseEntity;
import com.technologica.entity.passive.NarwhalEntity;
import com.technologica.entity.passive.OctopusEntity;
import com.technologica.entity.passive.OwlEntity;
import com.technologica.entity.passive.PenguinEntity;
import com.technologica.entity.passive.PoisonDartFrogEntity;
import com.technologica.entity.passive.RaccoonEntity;
import com.technologica.entity.passive.ScorpionEntity;
import com.technologica.entity.passive.SharkEntity;
import com.technologica.entity.passive.SlothEntity;
import com.technologica.entity.passive.StingrayEntity;
import com.technologica.entity.passive.TurkeyEntity;
import com.technologica.entity.passive.VultureEntity;
import com.technologica.entity.passive.WalrusEntity;
import com.technologica.entity.passive.fish.PiranhaEntity;
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
		
		GlobalEntityTypeAttributes.put(TechnologicaEntityType.ALLIGATOR.get(), AlligatorEntity.registerAttributes().create());
		GlobalEntityTypeAttributes.put(TechnologicaEntityType.BEAVER.get(), BeaverEntity.registerAttributes().create());
		GlobalEntityTypeAttributes.put(TechnologicaEntityType.BUFFALO.get(), BuffaloEntity.registerAttributes().create());
		GlobalEntityTypeAttributes.put(TechnologicaEntityType.CAMEL.get(), CamelEntity.registerAttributes().create());
		GlobalEntityTypeAttributes.put(TechnologicaEntityType.COBRA.get(), CobraEntity.registerAttributes().create());
		GlobalEntityTypeAttributes.put(TechnologicaEntityType.COTTONMOUTH.get(), CottonmouthEntity.registerAttributes().create());
		GlobalEntityTypeAttributes.put(TechnologicaEntityType.COYOTE.get(), CoyoteEntity.registerAttributes().create());
		GlobalEntityTypeAttributes.put(TechnologicaEntityType.CRAB.get(), CrabEntity.registerAttributes().create());
		GlobalEntityTypeAttributes.put(TechnologicaEntityType.DEER.get(), DeerEntity.registerAttributes().create());
		GlobalEntityTypeAttributes.put(TechnologicaEntityType.DUCK.get(), DuckEntity.registerAttributes().create());
		GlobalEntityTypeAttributes.put(TechnologicaEntityType.ELEPHANT.get(), ElephantEntity.registerAttributes().create());
		GlobalEntityTypeAttributes.put(TechnologicaEntityType.FLAMINGO.get(), FlamingoEntity.registerAttributes().create());
		GlobalEntityTypeAttributes.put(TechnologicaEntityType.FROG.get(), FrogEntity.registerAttributes().create());
		GlobalEntityTypeAttributes.put(TechnologicaEntityType.GIRAFFE.get(), func_234237_fg_().create());
		GlobalEntityTypeAttributes.put(TechnologicaEntityType.GORILLA.get(), GorillaEntity.registerAttributes().create());
		GlobalEntityTypeAttributes.put(TechnologicaEntityType.GRIZZLY_BEAR.get(), GrizzlyBearEntity.registerAttributes().create());
		GlobalEntityTypeAttributes.put(TechnologicaEntityType.JAGUAR.get(), JaguarEntity.registerAttributes().create());
		GlobalEntityTypeAttributes.put(TechnologicaEntityType.KING_CRAB.get(), KingCrabEntity.registerAttributes().create());
		GlobalEntityTypeAttributes.put(TechnologicaEntityType.LEOPARD_SEAL.get(), LeopardSealEntity.registerAttributes().create());
		GlobalEntityTypeAttributes.put(TechnologicaEntityType.LION.get(), LionEntity.registerAttributes().create());
		GlobalEntityTypeAttributes.put(TechnologicaEntityType.LIZARD.get(), LizardEntity.registerAttributes().create());
		GlobalEntityTypeAttributes.put(TechnologicaEntityType.MOOSE.get(), MooseEntity.registerAttributes().create());
		GlobalEntityTypeAttributes.put(TechnologicaEntityType.NARWHAL.get(), NarwhalEntity.registerAttributes().create());
		GlobalEntityTypeAttributes.put(TechnologicaEntityType.OCTOPUS.get(), OctopusEntity.registerAttributes().create());
		GlobalEntityTypeAttributes.put(TechnologicaEntityType.OSTRICH.get(), func_234237_fg_().create());
		GlobalEntityTypeAttributes.put(TechnologicaEntityType.OWL.get(), OwlEntity.registerAttributes().create());
		GlobalEntityTypeAttributes.put(TechnologicaEntityType.PENGUIN.get(), PenguinEntity.registerAttributes().create());
		GlobalEntityTypeAttributes.put(TechnologicaEntityType.PIRANHA.get(), PiranhaEntity.registerAttributes().create());
		GlobalEntityTypeAttributes.put(TechnologicaEntityType.POISON_DART_FROG.get(), PoisonDartFrogEntity.registerAttributes().create());
		GlobalEntityTypeAttributes.put(TechnologicaEntityType.RACCOON.get(), RaccoonEntity.registerAttributes().create());
		GlobalEntityTypeAttributes.put(TechnologicaEntityType.SCORPION.get(), ScorpionEntity.func_234305_eI_().create());
		GlobalEntityTypeAttributes.put(TechnologicaEntityType.SHARK.get(), SharkEntity.registerAttributes().create());
		GlobalEntityTypeAttributes.put(TechnologicaEntityType.SLOTH.get(), SlothEntity.registerAttributes().create());
		GlobalEntityTypeAttributes.put(TechnologicaEntityType.STINGRAY.get(), StingrayEntity.registerAttributes().create());
		GlobalEntityTypeAttributes.put(TechnologicaEntityType.TURKEY.get(), TurkeyEntity.registerAttributes().create());
		GlobalEntityTypeAttributes.put(TechnologicaEntityType.VULTURE.get(), VultureEntity.registerAttributes().create());
		GlobalEntityTypeAttributes.put(TechnologicaEntityType.WALRUS.get(), WalrusEntity.registerAttributes().create());
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