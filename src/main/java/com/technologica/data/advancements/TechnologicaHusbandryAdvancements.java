package com.technologica.data.advancements;

import java.util.function.Consumer;

import com.technologica.world.level.block.TechnologicaBlocks;

import net.minecraft.advancements.Advancement;
import net.minecraft.advancements.FrameType;
import net.minecraft.advancements.RequirementsStrategy;
import net.minecraft.advancements.critereon.PlacedBlockTrigger;
import net.minecraft.core.HolderLookup.Provider;
import net.minecraft.network.chat.Component;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.item.Items;
import net.minecraft.world.level.block.Blocks;
import net.minecraftforge.common.data.ExistingFileHelper;
import net.minecraftforge.common.data.ForgeAdvancementProvider.AdvancementGenerator;

public class TechnologicaHusbandryAdvancements implements AdvancementGenerator {
	public TechnologicaHusbandryAdvancements() {
	}

	@Override
	public void generate(Provider p_255680_, Consumer<Advancement> p_251389_, ExistingFileHelper fileHelper) {
		Advancement.Builder.advancement().parent(new ResourceLocation("husbandry/root")).display(Items.WHEAT, Component.translatable("advancements.husbandry.plant_seed.title"), Component.translatable("advancements.husbandry.plant_seed.description"), (ResourceLocation) null, FrameType.TASK, true, true, false).requirements(RequirementsStrategy.OR).addCriterion("wheat", PlacedBlockTrigger.TriggerInstance.placedBlock(Blocks.WHEAT)).addCriterion("pumpkin_stem", PlacedBlockTrigger.TriggerInstance.placedBlock(Blocks.PUMPKIN_STEM)).addCriterion("melon_stem", PlacedBlockTrigger.TriggerInstance.placedBlock(Blocks.MELON_STEM)).addCriterion("beetroots", PlacedBlockTrigger.TriggerInstance.placedBlock(Blocks.BEETROOTS)).addCriterion("nether_wart", PlacedBlockTrigger.TriggerInstance.placedBlock(Blocks.NETHER_WART)).addCriterion("barley", PlacedBlockTrigger.TriggerInstance.placedBlock(TechnologicaBlocks.BARLEY.get())).addCriterion("oats", PlacedBlockTrigger.TriggerInstance.placedBlock(TechnologicaBlocks.OATS.get())).addCriterion("rye", PlacedBlockTrigger.TriggerInstance.placedBlock(TechnologicaBlocks.RYE.get())).addCriterion("corn", PlacedBlockTrigger.TriggerInstance.placedBlock(TechnologicaBlocks.CORN.get())).addCriterion("rice", PlacedBlockTrigger.TriggerInstance.placedBlock(TechnologicaBlocks.RICE.get())).save(p_251389_, new ResourceLocation("husbandry/plant_seed"), fileHelper);
	}
}