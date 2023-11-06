package com.technologica.datagen;

import java.util.concurrent.CompletableFuture;

import com.technologica.datagen.assets.blockstates.BlockStateDataGenerator;
import com.technologica.datagen.assets.lang.LangDataGenerator;
import com.technologica.datagen.assets.models.items.ItemModelDataGenerator;
import com.technologica.datagen.data.advancements.AdvancementDataGenerator;
import com.technologica.datagen.data.lootmodifiers.LootModifierDataGenerator;
import com.technologica.datagen.data.loottables.LootTableDataGenerator;
import com.technologica.datagen.data.recipes.RecipeDataGenerator;
import com.technologica.datagen.data.tags.blocks.BlockTagDataGenerator;
import com.technologica.datagen.data.tags.fluids.FluidTagDataGenerator;
import com.technologica.datagen.data.tags.items.ItemTagDataGenerator;
import com.technologica.datagen.data.tags.worldgen.biome.BiomeTagDataGenerator;
import com.technologica.datagen.registries.TechnologicaDatapackBuiltinEntriesProvider;

import net.minecraft.core.HolderLookup;
import net.minecraft.data.DataGenerator;
import net.minecraft.data.PackOutput;
import net.minecraftforge.common.data.ExistingFileHelper;
import net.minecraftforge.data.event.GatherDataEvent;

/**
 * <p>
 * This class listens for GatherDataEvent which is fired on the mod-specific event bus.
 * When the event is intercepted, Technologica assets and data are generated.
 * </p>
 * 
 * @tl.status ORANGE
 */

public class GatherData {

	public static void onGatherDataEvent(final GatherDataEvent event) {
		DataGenerator generator = event.getGenerator();
		PackOutput packOutput = generator.getPackOutput();
		ExistingFileHelper helper = event.getExistingFileHelper();
		CompletableFuture<HolderLookup.Provider> lookupProvider = event.getLookupProvider();

		/*
		 * Assets
		 */
		generator.addProvider(event.includeClient(), new BlockStateDataGenerator(packOutput, helper));
		generator.addProvider(event.includeClient(), new LangDataGenerator(packOutput));
		generator.addProvider(event.includeClient(), new ItemModelDataGenerator(packOutput, helper));

		/*
		 * Data
		 */
		generator.addProvider(event.includeServer(), new AdvancementDataGenerator(packOutput, lookupProvider, helper));
		generator.addProvider(event.includeServer(), new TechnologicaDatapackBuiltinEntriesProvider(packOutput, lookupProvider));
		generator.addProvider(event.includeServer(), new LootTableDataGenerator(packOutput));

		generator.addProvider(event.includeServer(), new LootModifierDataGenerator(packOutput));

		generator.addProvider(event.includeServer(), new RecipeDataGenerator(packOutput));
		generator.addProvider(event.includeServer(), new BiomeTagDataGenerator(packOutput, lookupProvider, helper));
		BlockTagDataGenerator technologicaBlockTagsProvider = new BlockTagDataGenerator(packOutput, lookupProvider, helper);
		generator.addProvider(event.includeServer(), technologicaBlockTagsProvider);
		generator.addProvider(event.includeServer(), new ItemTagDataGenerator(packOutput, lookupProvider, technologicaBlockTagsProvider.contentsGetter(), helper));
		generator.addProvider(event.includeServer(), new FluidTagDataGenerator(packOutput, lookupProvider, helper));
	}
}