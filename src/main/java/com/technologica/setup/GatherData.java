package com.technologica.setup;

import com.technologica.data.TechnologicaBlockStateProvider;
import com.technologica.data.TechnologicaItemModelProvider;
import com.technologica.data.TechnologicaLanguageProvider;
import com.technologica.data.loot.TechnologicaLootTableProvider;
import com.technologica.data.recipes.TechnologicaRecipeProvider;
import com.technologica.data.tags.TechnologicaFluidTagsProvider;
import com.technologica.data.tags.TechnologicaItemTagsProvider;
import com.technologica.data.tags.TechnologicaBlockTagsProvider;

import net.minecraft.data.DataGenerator;
import net.minecraftforge.common.data.ExistingFileHelper;
import net.minecraftforge.forge.event.lifecycle.GatherDataEvent;

public class GatherData {
	public static void init(final GatherDataEvent event) {
		DataGenerator generator = event.getGenerator();
		ExistingFileHelper helper = event.getExistingFileHelper();
		
		if(event.includeClient()) {
			generator.addProvider(new TechnologicaLanguageProvider(generator));
			generator.addProvider(new TechnologicaBlockStateProvider(generator, helper));
			generator.addProvider(new TechnologicaItemModelProvider(generator, helper));
		}
		
		if(event.includeServer()) {
			TechnologicaBlockTagsProvider modBlockTagsProvider = new TechnologicaBlockTagsProvider(generator, helper);
			generator.addProvider(modBlockTagsProvider);
			generator.addProvider(new TechnologicaItemTagsProvider(generator, modBlockTagsProvider, helper));
			generator.addProvider(new TechnologicaRecipeProvider(generator));
			generator.addProvider(new TechnologicaLootTableProvider(generator));
			generator.addProvider(new TechnologicaFluidTagsProvider(generator, helper));
		}	
	}
}
