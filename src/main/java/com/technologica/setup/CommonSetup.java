package com.technologica.setup;

import com.technologica.block.ModBlocks;
import com.technologica.capabilities.ModCapabilities;
import com.technologica.entity.ModEntities;
import com.technologica.entity.monster.ScorpionEntity;
import com.technologica.entity.monster.SharkEntity;
import com.technologica.entity.passive.DuckEntity;
import com.technologica.entity.passive.GrizzlyBearEntity;
import com.technologica.network.play.server.Packets;

import net.minecraft.block.Block;
import net.minecraft.block.Blocks;
import net.minecraft.block.FlowerPotBlock;
import net.minecraft.block.SaplingBlock;
import net.minecraft.entity.ai.attributes.GlobalEntityTypeAttributes;
import net.minecraftforge.fml.RegistryObject;
import net.minecraftforge.fml.event.lifecycle.FMLCommonSetupEvent;

import static net.minecraft.entity.passive.horse.AbstractHorseEntity.func_234237_fg_;

import java.util.Collection;
import java.util.function.Supplier;

public class CommonSetup {

	public static void init(final FMLCommonSetupEvent event) {
		ModCapabilities.register();
		Packets.onCommonSetupEvent();
		GlobalEntityTypeAttributes.put(ModEntities.DUCK.get(), DuckEntity.registerAttributes().create());
		GlobalEntityTypeAttributes.put(ModEntities.GRIZZLY_BEAR.get(), GrizzlyBearEntity.registerAttributes().create());
		GlobalEntityTypeAttributes.put(ModEntities.OSTRICH.get(), func_234237_fg_().create());
		GlobalEntityTypeAttributes.put(ModEntities.SCORPION.get(), ScorpionEntity.registerAttributes().create());
		GlobalEntityTypeAttributes.put(ModEntities.SHARK.get(), SharkEntity.registerAttributes().create());
		GlobalEntityTypeAttributes.put(ModEntities.ZEBRA.get(), func_234237_fg_().create());

		event.enqueueWork(() -> {
			automaticFlowerPots(ModBlocks.BLOCKS.getEntries());
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