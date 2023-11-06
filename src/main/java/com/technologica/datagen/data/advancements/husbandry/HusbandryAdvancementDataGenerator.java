package com.technologica.datagen.data.advancements.husbandry;

import java.util.function.Consumer;

import com.technologica.world.level.block.TechnologicaBlocks;

import net.minecraft.advancements.Advancement;
import net.minecraft.advancements.FrameType;
import net.minecraft.advancements.RequirementsStrategy;
import net.minecraft.advancements.critereon.ItemUsedOnLocationTrigger;
import net.minecraft.core.HolderLookup.Provider;
import net.minecraft.network.chat.Component;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.item.Items;
import net.minecraft.world.level.block.Blocks;
import net.minecraftforge.common.data.ExistingFileHelper;
import net.minecraftforge.common.data.ForgeAdvancementProvider.AdvancementGenerator;

public class HusbandryAdvancementDataGenerator implements AdvancementGenerator {
	public HusbandryAdvancementDataGenerator() {
	}

	@Override
	public void generate(Provider p_255680_, Consumer<Advancement> p_251389_, ExistingFileHelper fileHelper) {
		Advancement.Builder.advancement().parent(new ResourceLocation("husbandry/root")).display(Items.WHEAT, Component.translatable("advancements.husbandry.plant_seed.title"), Component.translatable("advancements.husbandry.plant_seed.description"), (ResourceLocation) null, FrameType.TASK, true, true, false).requirements(RequirementsStrategy.OR).addCriterion("wheat", ItemUsedOnLocationTrigger.TriggerInstance.placedBlock(Blocks.WHEAT)).addCriterion("pumpkin_stem", ItemUsedOnLocationTrigger.TriggerInstance.placedBlock(Blocks.PUMPKIN_STEM)).addCriterion("melon_stem", ItemUsedOnLocationTrigger.TriggerInstance.placedBlock(Blocks.MELON_STEM)).addCriterion("beetroots", ItemUsedOnLocationTrigger.TriggerInstance.placedBlock(Blocks.BEETROOTS)).addCriterion("nether_wart", ItemUsedOnLocationTrigger.TriggerInstance.placedBlock(Blocks.NETHER_WART)).addCriterion("barley", ItemUsedOnLocationTrigger.TriggerInstance.placedBlock(TechnologicaBlocks.BARLEY.get())).addCriterion("oats", ItemUsedOnLocationTrigger.TriggerInstance.placedBlock(TechnologicaBlocks.OATS.get())).addCriterion("rye", ItemUsedOnLocationTrigger.TriggerInstance.placedBlock(TechnologicaBlocks.RYE.get())).addCriterion("corn", ItemUsedOnLocationTrigger.TriggerInstance.placedBlock(TechnologicaBlocks.CORN.get())).addCriterion("rice", ItemUsedOnLocationTrigger.TriggerInstance.placedBlock(TechnologicaBlocks.RICE.get())).save(p_251389_, new ResourceLocation("husbandry/plant_seed"), fileHelper);
	}
}