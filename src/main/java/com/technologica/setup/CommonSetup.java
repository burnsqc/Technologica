package com.technologica.setup;

import com.technologica.entity.passive.DuckEntity;

import net.minecraft.entity.ai.attributes.GlobalEntityTypeAttributes;
import net.minecraftforge.fml.event.lifecycle.FMLCommonSetupEvent;

public class CommonSetup {

	public static void init(final FMLCommonSetupEvent event) {
		GlobalEntityTypeAttributes.put(Registration.DUCK.get(), DuckEntity.registerAttributes().create());
		GlobalEntityTypeAttributes.put(Registration.GRIZZLY_BEAR.get(), DuckEntity.registerAttributes().create());
	}
	
}