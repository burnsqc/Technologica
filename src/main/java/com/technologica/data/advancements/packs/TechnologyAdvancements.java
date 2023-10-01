package com.technologica.data.advancements.packs;

import java.util.function.Consumer;

import com.technologica.world.item.TechnologicaItems;

import net.minecraft.advancements.Advancement;
import net.minecraft.advancements.FrameType;
import net.minecraft.advancements.RequirementsStrategy;
import net.minecraft.advancements.critereon.ConsumeItemTrigger;
import net.minecraft.advancements.critereon.InventoryChangeTrigger;
import net.minecraft.core.HolderLookup.Provider;
import net.minecraft.network.chat.Component;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.level.block.Blocks;
import net.minecraftforge.common.data.ExistingFileHelper;
import net.minecraftforge.common.data.ForgeAdvancementProvider.AdvancementGenerator;

public class TechnologyAdvancements implements AdvancementGenerator {
	public TechnologyAdvancements() {
	}

	@Override
	public void generate(Provider p_255680_, Consumer<Advancement> p_251389_, ExistingFileHelper fileHelper) {
		Advancement advancement = this.createRoot(p_251389_);
		Advancement.Builder.advancement().parent(advancement).display(TechnologicaItems.PRIMITIVE_DAGGER.get(), Component.translatable("advancements.husbandry.plant_seed.title"), Component.translatable("advancements.husbandry.plant_seed.description"), (ResourceLocation) null, FrameType.TASK, true, true, false).requirements(RequirementsStrategy.OR).addCriterion("has_dagger", InventoryChangeTrigger.TriggerInstance.hasItems(TechnologicaItems.PRIMITIVE_DAGGER.get())).save(p_251389_, new ResourceLocation("technology/test"), fileHelper);
	}

	Advancement createRoot(Consumer<Advancement> p_262142_) {
		return Advancement.Builder.advancement().display(Blocks.HAY_BLOCK, Component.translatable("advancements.husbandry.root.title"), Component.translatable("advancements.husbandry.root.description"), new ResourceLocation("textures/gui/advancements/backgrounds/husbandry.png"), FrameType.TASK, false, false, false).addCriterion("consumed_item", ConsumeItemTrigger.TriggerInstance.usedItem()).save(p_262142_, "technology/root");
	}
}