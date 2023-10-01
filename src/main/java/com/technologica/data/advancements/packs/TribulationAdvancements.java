package com.technologica.data.advancements.packs;

import java.util.function.Consumer;

import com.technologica.Technologica;

import net.minecraft.advancements.Advancement;
import net.minecraft.advancements.FrameType;
import net.minecraft.advancements.RequirementsStrategy;
import net.minecraft.advancements.critereon.ConsumeItemTrigger;
import net.minecraft.advancements.critereon.InventoryChangeTrigger;
import net.minecraft.core.HolderLookup.Provider;
import net.minecraft.network.chat.Component;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.item.Items;
import net.minecraft.world.level.block.Blocks;
import net.minecraftforge.common.data.ExistingFileHelper;
import net.minecraftforge.common.data.ForgeAdvancementProvider.AdvancementGenerator;

public class TribulationAdvancements implements AdvancementGenerator {
	public TribulationAdvancements() {
	}

	@Override
	public void generate(Provider providerIn, Consumer<Advancement> consumerIn, ExistingFileHelper fileHelper) {
		Advancement advancement = this.createRoot(consumerIn);
		Advancement.Builder.advancement().parent(advancement).display(Items.OAK_LOG, Component.translatable("advancements.tribulation.a_sign_of_things_to_come.title"), Component.translatable("advancements.tribulation.a_sign_of_things_to_come.description"), (ResourceLocation) null, FrameType.TASK, true, true, false).requirements(RequirementsStrategy.OR).addCriterion("failed_harvest", InventoryChangeTrigger.TriggerInstance.hasItems(Items.OAK_LOG)).save(consumerIn, new ResourceLocation(Technologica.MODID, "tribulation/a_sign_of_things_to_come"), fileHelper);
	}

	Advancement createRoot(Consumer<Advancement> consumerIn) {
		return Advancement.Builder.advancement().display(Blocks.BARRIER, Component.translatable("advancements.tribulation.root.title"), Component.translatable("advancements.tribulation.root.description"), new ResourceLocation(Technologica.MODID, "textures/block/salt.png"), FrameType.TASK, false, false, false).addCriterion("consumed_item", ConsumeItemTrigger.TriggerInstance.usedItem()).save(consumerIn, "tribulation/root");
	}
}