package com.technologica.setup;

import com.technologica.entity.monster.SharkEntity;
import com.technologica.entity.passive.DuckEntity;
import com.technologica.entity.passive.GrizzlyBearEntity;
import com.technologica.entity.passive.ZebraEntity;

import net.minecraft.entity.ai.attributes.GlobalEntityTypeAttributes;
import net.minecraftforge.fml.event.lifecycle.FMLCommonSetupEvent;

public class CommonSetup {

	public static void init(final FMLCommonSetupEvent event) {
		GlobalEntityTypeAttributes.put(Registration.DUCK.get(), DuckEntity.registerAttributes().create());
		GlobalEntityTypeAttributes.put(Registration.GRIZZLY_BEAR.get(), GrizzlyBearEntity.registerAttributes().create());
		GlobalEntityTypeAttributes.put(Registration.SHARK.get(), SharkEntity.registerAttributes().create());
		GlobalEntityTypeAttributes.put(Registration.ZEBRA.get(), ZebraEntity.func_234237_fg_().create());
	}
	
}