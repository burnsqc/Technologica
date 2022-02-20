package com.technologica.setup;

import com.technologica.data.ModBlockStateProvider;
import com.technologica.data.ModBlockTagsProvider;
import com.technologica.data.ModFluidTagsProvider;
import com.technologica.data.ModItemModelProvider;
import com.technologica.data.ModItemTagsProvider;
import com.technologica.data.ModLanguageProvider;
import com.technologica.data.ModLootTableProvider;
import com.technologica.data.ModRecipeProvider;

import net.minecraft.data.DataGenerator;
import net.minecraftforge.common.data.ExistingFileHelper;
import net.minecraftforge.fml.event.lifecycle.GatherDataEvent;

public class GatherData {
	public static void init(final GatherDataEvent event) {
		DataGenerator generator = event.getGenerator();
		ExistingFileHelper helper = event.getExistingFileHelper();
		
		if(event.includeClient()) {
			generator.addProvider(new ModLanguageProvider(generator));
			generator.addProvider(new ModBlockStateProvider(generator, helper));
			generator.addProvider(new ModItemModelProvider(generator, helper));
		}
		
		if(event.includeServer()) {
			ModBlockTagsProvider modBlockTagsProvider = new ModBlockTagsProvider(generator, helper);
			generator.addProvider(modBlockTagsProvider);
			generator.addProvider(new ModItemTagsProvider(generator, modBlockTagsProvider, helper));
			generator.addProvider(new ModRecipeProvider(generator));
			generator.addProvider(new ModLootTableProvider(generator));
			generator.addProvider(new ModFluidTagsProvider(generator, helper));
		}	
	}
}
