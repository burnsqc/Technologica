package com.technologica.setup;

import com.technologica.entity.monster.SharkEntity;
import com.technologica.entity.passive.DuckEntity;
import com.technologica.entity.passive.GrizzlyBearEntity;
import com.technologica.entity.passive.ZebraEntity;

import net.minecraft.block.Blocks;
import net.minecraft.block.FlowerPotBlock;
import net.minecraft.entity.ai.attributes.GlobalEntityTypeAttributes;
import net.minecraftforge.fml.event.lifecycle.FMLCommonSetupEvent;

public class CommonSetup {

	public static void init(final FMLCommonSetupEvent event) {
		GlobalEntityTypeAttributes.put(Registration.DUCK.get(), DuckEntity.registerAttributes().create());
		GlobalEntityTypeAttributes.put(Registration.GRIZZLY_BEAR.get(), GrizzlyBearEntity.registerAttributes().create());
		GlobalEntityTypeAttributes.put(Registration.SHARK.get(), SharkEntity.registerAttributes().create());
		GlobalEntityTypeAttributes.put(Registration.ZEBRA.get(), ZebraEntity.func_234237_fg_().create());
		
		event.enqueueWork(() -> {
			((FlowerPotBlock) Blocks.FLOWER_POT).addPlant(Registration.BANANA_SAPLING.getId(), Registration.POTTED_BANANA_SAPLING::get);
			((FlowerPotBlock) Blocks.FLOWER_POT).addPlant(Registration.CHERRY_SAPLING.getId(), Registration.POTTED_CHERRY_SAPLING::get);
			((FlowerPotBlock) Blocks.FLOWER_POT).addPlant(Registration.COCONUT_SAPLING.getId(), Registration.POTTED_COCONUT_SAPLING::get);
			((FlowerPotBlock) Blocks.FLOWER_POT).addPlant(Registration.KIWI_SAPLING.getId(), Registration.POTTED_KIWI_SAPLING::get);
			((FlowerPotBlock) Blocks.FLOWER_POT).addPlant(Registration.LEMON_SAPLING.getId(), Registration.POTTED_LEMON_SAPLING::get);
			((FlowerPotBlock) Blocks.FLOWER_POT).addPlant(Registration.LIME_SAPLING.getId(), Registration.POTTED_LIME_SAPLING::get);
			((FlowerPotBlock) Blocks.FLOWER_POT).addPlant(Registration.ORANGE_SAPLING.getId(), Registration.POTTED_ORANGE_SAPLING::get);
			((FlowerPotBlock) Blocks.FLOWER_POT).addPlant(Registration.PEACH_SAPLING.getId(), Registration.POTTED_PEACH_SAPLING::get);
			((FlowerPotBlock) Blocks.FLOWER_POT).addPlant(Registration.PEAR_SAPLING.getId(), Registration.POTTED_PEAR_SAPLING::get);
		});
	}
	
}