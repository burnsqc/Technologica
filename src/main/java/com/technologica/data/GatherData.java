package com.technologica.data;

import com.technologica.data.advancements.TechnologicaAdvancementProvider;
import com.technologica.data.loot.TechnologicaLootTableProvider;
import com.technologica.data.recipes.TechnologicaRecipeProvider;
import com.technologica.data.tags.TechnologicaBlockTagsProvider;
import com.technologica.data.tags.TechnologicaFluidTagsProvider;
import com.technologica.data.tags.TechnologicaItemTagsProvider;

import net.minecraft.data.DataGenerator;
import net.minecraftforge.common.data.ExistingFileHelper;
import net.minecraftforge.data.event.GatherDataEvent;

public class GatherData {
	public static void onGatherDataEvent(final GatherDataEvent event) {
		DataGenerator generator = event.getGenerator();
		ExistingFileHelper helper = event.getExistingFileHelper();

		generator.addProvider(event.includeClient(), new TechnologicaLanguageProvider(generator));
		generator.addProvider(event.includeClient(), new TechnologicaBlockStateProvider(generator, helper));
		generator.addProvider(event.includeClient(), new TechnologicaItemModelProvider(generator, helper));

		generator.addProvider(event.includeServer(), new TechnologicaFluidTagsProvider(generator, helper));
		TechnologicaBlockTagsProvider technologicaBlockTagsProvider = new TechnologicaBlockTagsProvider(generator, helper);
		generator.addProvider(event.includeServer(), technologicaBlockTagsProvider);
		generator.addProvider(event.includeServer(), new TechnologicaItemTagsProvider(generator, technologicaBlockTagsProvider, helper));
		generator.addProvider(event.includeServer(), new TechnologicaRecipeProvider(generator));
		generator.addProvider(event.includeServer(), new TechnologicaAdvancementProvider(generator, helper));
		generator.addProvider(event.includeServer(), new TechnologicaLootTableProvider(generator));
	}
}