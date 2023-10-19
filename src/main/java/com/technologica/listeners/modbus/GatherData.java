package com.technologica.listeners.modbus;

import java.util.concurrent.CompletableFuture;

import com.technologica.data.advancements.TechnologicaAdvancementProvider;
import com.technologica.data.lang.TechnologicaLanguageProvider;
import com.technologica.data.loot.TechnologicaGlobalLootModifierProvider;
import com.technologica.data.loot.TechnologicaLootTableProvider;
import com.technologica.data.models.blockstates.TechnologicaBlockStateProvider;
import com.technologica.data.models.model.TechnologicaItemModelProvider;
import com.technologica.data.recipes.packs.TechnologicaRecipeProvider;
import com.technologica.data.registries.TechnologicaDatapackBuiltinEntriesProvider;
import com.technologica.data.tags.TechnologicaBlockTagsProvider;
import com.technologica.data.tags.TechnologicaFluidTagsProvider;
import com.technologica.data.tags.TechnologicaItemTagsProvider;

import net.minecraft.core.HolderLookup;
import net.minecraft.data.DataGenerator;
import net.minecraft.data.PackOutput;
import net.minecraftforge.common.data.ExistingFileHelper;
import net.minecraftforge.data.event.GatherDataEvent;

public class GatherData {
	
	public static void onGatherDataEvent(final GatherDataEvent event) {
		DataGenerator generator = event.getGenerator();
		PackOutput packOutput = generator.getPackOutput();
		ExistingFileHelper helper = event.getExistingFileHelper();
		CompletableFuture<HolderLookup.Provider> lookupProvider = event.getLookupProvider();
		
		/*
		 * Assets
		 */
		generator.addProvider(event.includeClient(), new TechnologicaBlockStateProvider(packOutput, helper));
		generator.addProvider(event.includeClient(), new TechnologicaLanguageProvider(packOutput));
		generator.addProvider(event.includeClient(), new TechnologicaItemModelProvider(packOutput, helper));
		
		/*
		 * Data
		 */
		generator.addProvider(event.includeServer(), new TechnologicaAdvancementProvider(packOutput, lookupProvider, helper));
		generator.addProvider(event.includeServer(), new TechnologicaDatapackBuiltinEntriesProvider(packOutput, lookupProvider));
		generator.addProvider(event.includeServer(), new TechnologicaLootTableProvider(packOutput));
		generator.addProvider(event.includeServer(), new TechnologicaGlobalLootModifierProvider(packOutput));
		generator.addProvider(event.includeServer(), new TechnologicaRecipeProvider(packOutput));
		TechnologicaBlockTagsProvider technologicaBlockTagsProvider = new TechnologicaBlockTagsProvider(packOutput, lookupProvider, helper);
		generator.addProvider(event.includeServer(), technologicaBlockTagsProvider);
		generator.addProvider(event.includeServer(), new TechnologicaItemTagsProvider(packOutput, lookupProvider, technologicaBlockTagsProvider, helper));
		generator.addProvider(event.includeServer(), new TechnologicaFluidTagsProvider(packOutput, lookupProvider, helper));
	}
}
