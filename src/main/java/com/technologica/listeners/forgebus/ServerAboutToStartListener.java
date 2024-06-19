package com.technologica.listeners.forgebus;

import java.util.ArrayList;
import java.util.List;

import com.google.common.collect.ImmutableList;
import com.technologica.registration.deferred.TechnologicaBlocks;

import net.minecraft.core.Registry;
import net.minecraft.core.registries.Registries;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.level.block.Blocks;
import net.minecraft.world.level.levelgen.structure.templatesystem.AlwaysTrueTest;
import net.minecraft.world.level.levelgen.structure.templatesystem.ProcessorRule;
import net.minecraft.world.level.levelgen.structure.templatesystem.RandomBlockMatchTest;
import net.minecraft.world.level.levelgen.structure.templatesystem.RuleProcessor;
import net.minecraft.world.level.levelgen.structure.templatesystem.StructureProcessor;
import net.minecraft.world.level.levelgen.structure.templatesystem.StructureProcessorList;
import net.minecraftforge.event.server.ServerAboutToStartEvent;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.fml.common.Mod.EventBusSubscriber;

@Mod.EventBusSubscriber(bus = EventBusSubscriber.Bus.FORGE)
public class ServerAboutToStartListener {

	@SubscribeEvent
	public static void onServerAboutToStartEvent(final ServerAboutToStartEvent event) { // NO_UCD (unused code)
		Registry<StructureProcessorList> processorListRegistry = event.getServer().registryAccess().registry(Registries.PROCESSOR_LIST).orElseThrow();
		StructureProcessor technologicaDesertFarmProcessorList = new RuleProcessor(ImmutableList.of(new ProcessorRule(new RandomBlockMatchTest(Blocks.WHEAT, 0.2F), AlwaysTrueTest.INSTANCE, TechnologicaBlocks.BARLEY.get().defaultBlockState()), new ProcessorRule(new RandomBlockMatchTest(Blocks.WHEAT, 0.2F), AlwaysTrueTest.INSTANCE, TechnologicaBlocks.OATS.get().defaultBlockState()), new ProcessorRule(new RandomBlockMatchTest(Blocks.WHEAT, 0.2F), AlwaysTrueTest.INSTANCE, TechnologicaBlocks.RYE.get().defaultBlockState()), new ProcessorRule(new RandomBlockMatchTest(Blocks.WHEAT, 0.2F), AlwaysTrueTest.INSTANCE, TechnologicaBlocks.CHILI_PEPPERS.get().defaultBlockState())));
		StructureProcessor technologicaPlainsFarmProcessorList = new RuleProcessor(ImmutableList.of(new ProcessorRule(new RandomBlockMatchTest(Blocks.WHEAT, 0.2F), AlwaysTrueTest.INSTANCE, TechnologicaBlocks.BARLEY.get().defaultBlockState()), new ProcessorRule(new RandomBlockMatchTest(Blocks.WHEAT, 0.2F), AlwaysTrueTest.INSTANCE, TechnologicaBlocks.OATS.get().defaultBlockState()), new ProcessorRule(new RandomBlockMatchTest(Blocks.WHEAT, 0.2F), AlwaysTrueTest.INSTANCE, TechnologicaBlocks.RYE.get().defaultBlockState()), new ProcessorRule(new RandomBlockMatchTest(Blocks.WHEAT, 0.2F), AlwaysTrueTest.INSTANCE, TechnologicaBlocks.CORN.get().defaultBlockState()), new ProcessorRule(new RandomBlockMatchTest(Blocks.WHEAT, 0.2F), AlwaysTrueTest.INSTANCE, TechnologicaBlocks.LETTUCE.get().defaultBlockState()), new ProcessorRule(new RandomBlockMatchTest(Blocks.WHEAT, 0.2F), AlwaysTrueTest.INSTANCE, TechnologicaBlocks.MUSTARD_GREENS.get().defaultBlockState()), new ProcessorRule(new RandomBlockMatchTest(Blocks.WHEAT, 0.2F), AlwaysTrueTest.INSTANCE, TechnologicaBlocks.PEAS.get().defaultBlockState())));
		StructureProcessor technologicaSavannaFarmProcessorList = new RuleProcessor(ImmutableList.of(new ProcessorRule(new RandomBlockMatchTest(Blocks.WHEAT, 0.2F), AlwaysTrueTest.INSTANCE, TechnologicaBlocks.BARLEY.get().defaultBlockState()), new ProcessorRule(new RandomBlockMatchTest(Blocks.WHEAT, 0.2F), AlwaysTrueTest.INSTANCE, TechnologicaBlocks.OATS.get().defaultBlockState()), new ProcessorRule(new RandomBlockMatchTest(Blocks.WHEAT, 0.2F), AlwaysTrueTest.INSTANCE, TechnologicaBlocks.RYE.get().defaultBlockState()), new ProcessorRule(new RandomBlockMatchTest(Blocks.WHEAT, 0.2F), AlwaysTrueTest.INSTANCE, TechnologicaBlocks.CORN.get().defaultBlockState()), new ProcessorRule(new RandomBlockMatchTest(Blocks.WHEAT, 0.2F), AlwaysTrueTest.INSTANCE, TechnologicaBlocks.COFFEE.get().defaultBlockState()), new ProcessorRule(new RandomBlockMatchTest(Blocks.WHEAT, 0.2F), AlwaysTrueTest.INSTANCE, TechnologicaBlocks.GARLIC.get().defaultBlockState()), new ProcessorRule(new RandomBlockMatchTest(Blocks.WHEAT, 0.2F), AlwaysTrueTest.INSTANCE, TechnologicaBlocks.GINGER.get().defaultBlockState()), new ProcessorRule(new RandomBlockMatchTest(Blocks.WHEAT, 0.2F), AlwaysTrueTest.INSTANCE, TechnologicaBlocks.ONIONS.get().defaultBlockState()), new ProcessorRule(new RandomBlockMatchTest(Blocks.WHEAT, 0.2F), AlwaysTrueTest.INSTANCE, TechnologicaBlocks.PEANUTS.get().defaultBlockState()), new ProcessorRule(new RandomBlockMatchTest(Blocks.WHEAT, 0.2F), AlwaysTrueTest.INSTANCE, TechnologicaBlocks.PINEAPPLES.get().defaultBlockState()), new ProcessorRule(new RandomBlockMatchTest(Blocks.WHEAT, 0.2F), AlwaysTrueTest.INSTANCE, TechnologicaBlocks.SWEET_POTATOES.get().defaultBlockState()), new ProcessorRule(new RandomBlockMatchTest(Blocks.WHEAT, 0.2F), AlwaysTrueTest.INSTANCE, TechnologicaBlocks.TEA.get().defaultBlockState())));
		StructureProcessor technologicaSnowyFarmProcessorList = new RuleProcessor(ImmutableList.of(new ProcessorRule(new RandomBlockMatchTest(Blocks.WHEAT, 0.2F), AlwaysTrueTest.INSTANCE, TechnologicaBlocks.BARLEY.get().defaultBlockState()), new ProcessorRule(new RandomBlockMatchTest(Blocks.WHEAT, 0.2F), AlwaysTrueTest.INSTANCE, TechnologicaBlocks.OATS.get().defaultBlockState()), new ProcessorRule(new RandomBlockMatchTest(Blocks.WHEAT, 0.2F), AlwaysTrueTest.INSTANCE, TechnologicaBlocks.RYE.get().defaultBlockState()), new ProcessorRule(new RandomBlockMatchTest(Blocks.WHEAT, 0.2F), AlwaysTrueTest.INSTANCE, TechnologicaBlocks.RADISHES.get().defaultBlockState()), new ProcessorRule(new RandomBlockMatchTest(Blocks.WHEAT, 0.2F), AlwaysTrueTest.INSTANCE, TechnologicaBlocks.TURNIPS.get().defaultBlockState())));
		StructureProcessor technologicaTaigaFarmProcessorList = new RuleProcessor(ImmutableList.of(new ProcessorRule(new RandomBlockMatchTest(Blocks.WHEAT, 0.2F), AlwaysTrueTest.INSTANCE, TechnologicaBlocks.BARLEY.get().defaultBlockState()), new ProcessorRule(new RandomBlockMatchTest(Blocks.WHEAT, 0.2F), AlwaysTrueTest.INSTANCE, TechnologicaBlocks.OATS.get().defaultBlockState()), new ProcessorRule(new RandomBlockMatchTest(Blocks.WHEAT, 0.2F), AlwaysTrueTest.INSTANCE, TechnologicaBlocks.RYE.get().defaultBlockState()), new ProcessorRule(new RandomBlockMatchTest(Blocks.WHEAT, 0.2F), AlwaysTrueTest.INSTANCE, TechnologicaBlocks.ASPARAGUS.get().defaultBlockState()), new ProcessorRule(new RandomBlockMatchTest(Blocks.WHEAT, 0.2F), AlwaysTrueTest.INSTANCE, TechnologicaBlocks.BROCCOLI.get().defaultBlockState()), new ProcessorRule(new RandomBlockMatchTest(Blocks.WHEAT, 0.2F), AlwaysTrueTest.INSTANCE, TechnologicaBlocks.CELERY.get().defaultBlockState()), new ProcessorRule(new RandomBlockMatchTest(Blocks.WHEAT, 0.2F), AlwaysTrueTest.INSTANCE, TechnologicaBlocks.PURPLE_CABBAGE.get().defaultBlockState()), new ProcessorRule(new RandomBlockMatchTest(Blocks.WHEAT, 0.2F), AlwaysTrueTest.INSTANCE, TechnologicaBlocks.RED_BEANS.get().defaultBlockState()), new ProcessorRule(new RandomBlockMatchTest(Blocks.WHEAT, 0.2F), AlwaysTrueTest.INSTANCE, TechnologicaBlocks.SOY_BEANS.get().defaultBlockState()), new ProcessorRule(new RandomBlockMatchTest(Blocks.WHEAT, 0.3F), AlwaysTrueTest.INSTANCE, TechnologicaBlocks.CUCUMBER_STEM.get().defaultBlockState()), new ProcessorRule(new RandomBlockMatchTest(Blocks.WHEAT, 0.3F), AlwaysTrueTest.INSTANCE, TechnologicaBlocks.SQUASH_STEM.get().defaultBlockState()), new ProcessorRule(new RandomBlockMatchTest(Blocks.WHEAT, 0.2F), AlwaysTrueTest.INSTANCE, TechnologicaBlocks.ZUCCHINI_STEM.get().defaultBlockState())));

		addNewRuleToProcessorList(new ResourceLocation("minecraft:farm_desert"), technologicaDesertFarmProcessorList, processorListRegistry);
		addNewRuleToProcessorList(new ResourceLocation("minecraft:zombie_desert"), technologicaDesertFarmProcessorList, processorListRegistry);
		addNewRuleToProcessorList(new ResourceLocation("minecraft:farm_plains"), technologicaPlainsFarmProcessorList, processorListRegistry);
		addNewRuleToProcessorList(new ResourceLocation("minecraft:zombie_savanna"), technologicaPlainsFarmProcessorList, processorListRegistry);
		addNewRuleToProcessorList(new ResourceLocation("minecraft:farm_savanna"), technologicaSavannaFarmProcessorList, processorListRegistry);
		addNewRuleToProcessorList(new ResourceLocation("minecraft:zombie_plains"), technologicaSavannaFarmProcessorList, processorListRegistry);
		addNewRuleToProcessorList(new ResourceLocation("minecraft:farm_snowy"), technologicaSnowyFarmProcessorList, processorListRegistry);
		addNewRuleToProcessorList(new ResourceLocation("minecraft:zombie_snowy"), technologicaSnowyFarmProcessorList, processorListRegistry);
		addNewRuleToProcessorList(new ResourceLocation("minecraft:farm_taiga"), technologicaTaigaFarmProcessorList, processorListRegistry);
		addNewRuleToProcessorList(new ResourceLocation("minecraft:zombie_taiga"), technologicaTaigaFarmProcessorList, processorListRegistry);
	}

	private static void addNewRuleToProcessorList(ResourceLocation targetProcessorList, StructureProcessor processorToAdd, Registry<StructureProcessorList> processorListRegistry) {
		processorListRegistry.getOptional(targetProcessorList).ifPresent(processorList -> {
			List<StructureProcessor> newSafeList = new ArrayList<>(processorList.list());
			newSafeList.add(processorToAdd);
			processorList.list = newSafeList;
		});
	}
}