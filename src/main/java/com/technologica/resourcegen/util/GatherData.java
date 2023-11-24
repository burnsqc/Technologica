package com.technologica.resourcegen.util;

import com.technologica.resourcegen.assets.SoundsDataGenerator;
import com.technologica.resourcegen.assets.blockstates.BlockStateDataGenerator;
import com.technologica.resourcegen.assets.lang.LanguageDataGenerator;
import com.technologica.resourcegen.assets.models.items.ItemModelDataGenerator;
import com.technologica.resourcegen.assets.particles.ParticleProvider;
import com.technologica.resourcegen.data.advancements.AdvancementDataGenerator;
import com.technologica.resourcegen.data.damagetype.DamageTypeProvider;
import com.technologica.resourcegen.data.lootmodifiers.blocks.BlockLootModifierDataGenerator;
import com.technologica.resourcegen.data.lootmodifiers.chests.ChestLootModifierDataGenerator;
import com.technologica.resourcegen.data.loottables.LootTableDataGenerator;
import com.technologica.resourcegen.data.recipes.RecipeDataGenerator;
import com.technologica.resourcegen.data.tags.blocks.BlockTagProvider;
import com.technologica.resourcegen.data.tags.fluids.FluidTagDataGenerator;
import com.technologica.resourcegen.data.tags.items.ItemTagProvider;
import com.technologica.resourcegen.data.tags.worldgen.biome.BiomeTagProvider;

import net.minecraftforge.data.event.GatherDataEvent;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.fml.common.Mod.EventBusSubscriber;

/**
 * <p>
 * This class listens for GatherDataEvent which is fired on the mod-specific event bus.
 * When the event is intercepted, Technologica assets and data are generated.
 * </p>
 * 
 * @tl.status ORANGE
 */
@Mod.EventBusSubscriber(bus = EventBusSubscriber.Bus.MOD)
public class GatherData extends MasterResourceProvider {
	
	@SubscribeEvent
	public static void addProviders(final GatherDataEvent eventIn) {
		MasterResourceProvider.setup(eventIn);
		
		/*
		 * ASSETS
		 */
		
		BlockStateDataGenerator blockStateProvider = new BlockStateDataGenerator(packOutput, helper);
		LanguageDataGenerator languageProvider = new LanguageDataGenerator(packOutput);
		ItemModelDataGenerator itemModelProvider = new ItemModelDataGenerator(packOutput, helper);
		ParticleProvider particleProvider = new ParticleProvider(packOutput, helper);
		SoundsDataGenerator soundProvider = new SoundsDataGenerator(packOutput, helper);
		
		//addAssetProvider(atlasProvider);
		addAssetProvider(blockStateProvider);
		//addAssetProvider(new FontDataGenerator(packOutput, helper));
		addAssetProvider(languageProvider);
			addAssetProvider(itemModelProvider);
		addAssetProvider(particleProvider);
		//addAssetProvider(new ShaderDataGenerator(packOutput, helper));
		//addAssetProvider(new TextsDataGenerator(packOutput, helper));
		addAssetProvider(soundProvider);
		
		/*
		 * DATA
		 */
		
		AdvancementDataGenerator advancementProvider = new AdvancementDataGenerator(packOutput, lookupProvider, helper);
		DamageTypeProvider damageTypeProvider = new DamageTypeProvider(packOutput, lookupProvider, registrySetBuilder);
		
		BlockTagProvider blockTagProvider = new BlockTagProvider(packOutput, lookupProvider, helper);
		FluidTagDataGenerator fluidTagProvider = new FluidTagDataGenerator(packOutput, lookupProvider, helper);
		ItemTagProvider itemTagProvider = new ItemTagProvider(packOutput, lookupProvider, blockTagProvider.contentsGetter(), helper);
		BiomeTagProvider biomeTagProvider = new BiomeTagProvider(packOutput, lookupProvider, helper);
		
		//addDataProvider(new DimensionTypeDataGenerator(packOutput, lookupProvider, registrySetBuilder));
		addDataProvider(new BlockLootModifierDataGenerator(packOutput));
		addDataProvider(new ChestLootModifierDataGenerator(packOutput));
		//addDataProvider(new EntityLootModifierDataGenerator(packOutput));
		addDataProvider(new LootTableDataGenerator(packOutput));
		//addDataProvider(new TechnologicaDatapackBuiltinEntriesProvider(packOutput, lookupProvider));
		addDataProvider(new RecipeDataGenerator(packOutput));
		addIntermediateDataProvider(new TagIntermediateDataGenerator(
			blockTagProvider, 
			fluidTagProvider, 
			itemTagProvider, 
			biomeTagProvider));
		
		addDataProvider(advancementProvider);
		//addDataProvider(chatTypeProvider);
		addDataProvider(damageTypeProvider);
	}
}