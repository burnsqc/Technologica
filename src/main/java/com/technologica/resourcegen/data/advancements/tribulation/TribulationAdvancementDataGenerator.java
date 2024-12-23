package com.technologica.resourcegen.data.advancements.tribulation;

import java.util.function.Consumer;

import com.technologica.registration.deferred.TechnologicaItems;
import com.technologica.resourcegen.data.advancements.AttemptedHarvestTrigger;
import com.technologica.util.text.TechnologicaLocation;

import net.minecraft.advancements.Advancement;
import net.minecraft.advancements.FrameType;
import net.minecraft.advancements.critereon.BlockPredicate;
import net.minecraft.advancements.critereon.ConsumeItemTrigger;
import net.minecraft.advancements.critereon.InventoryChangeTrigger;
import net.minecraft.advancements.critereon.ItemPredicate;
import net.minecraft.core.HolderLookup.Provider;
import net.minecraft.network.chat.Component;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.tags.BlockTags;
import net.minecraft.world.item.Items;
import net.minecraft.world.level.block.Blocks;
import net.minecraftforge.common.data.ExistingFileHelper;
import net.minecraftforge.common.data.ForgeAdvancementProvider.AdvancementGenerator;

public class TribulationAdvancementDataGenerator implements AdvancementGenerator {
	public TribulationAdvancementDataGenerator() {
	}

	@Override
	public void generate(Provider providerIn, Consumer<Advancement> consumerIn, ExistingFileHelper fileHelper) {
		Advancement root = Advancement.Builder.advancement().display(Blocks.BARRIER, Component.translatable("advancements.tribulation.root.title"), Component.translatable("advancements.tribulation.root.description"), new TechnologicaLocation("textures/block/salt.png"), FrameType.TASK, false, false, false).addCriterion("consumed_item", ConsumeItemTrigger.TriggerInstance.usedItem()).save(consumerIn, "tribulation/root");
		Advancement notSoFast = Advancement.Builder.advancement().parent(root).display(Items.OAK_LOG, Component.translatable("advancements.tribulation.not_so_fast.title"), Component.translatable("advancements.tribulation.not_so_fast.description"), (ResourceLocation) null, FrameType.TASK, true, true, true).addCriterion("failed_harvest", AttemptedHarvestTrigger.TriggerInstance.destroyedBlock(BlockPredicate.Builder.block().of(BlockTags.LOGS).build(), null)).save(consumerIn, new TechnologicaLocation("tribulation/not_so_fast"), fileHelper);
		Advancement humbleBeginnings = Advancement.Builder.advancement().parent(notSoFast).display(TechnologicaItems.CRUDE_SAW.get(), Component.translatable("advancements.tribulation.humble_beginnings.title"), Component.translatable("advancements.tribulation.humble_beginnings.description"), (ResourceLocation) null, FrameType.TASK, true, true, false).addCriterion("crafted_crude_saw", InventoryChangeTrigger.TriggerInstance.hasItems(TechnologicaItems.CRUDE_SAW.get())).save(consumerIn, new TechnologicaLocation("tribulation/crude_saw"), fileHelper);
		Advancement holdYourHorses = Advancement.Builder.advancement().parent(root).display(Items.WOODEN_PICKAXE, Component.translatable("advancements.tribulation.hold_your_horses.title"), Component.translatable("advancements.tribulation.hold_your_horses.description"), (ResourceLocation) null, FrameType.TASK, true, true, true).addCriterion("used_wooden_tool", ConsumeItemTrigger.TriggerInstance.usedItem(ItemPredicate.Builder.item().of(Items.WOODEN_AXE, Items.WOODEN_HOE, Items.WOODEN_PICKAXE, Items.WOODEN_SHOVEL, Items.WOODEN_SWORD).build())).save(consumerIn, new TechnologicaLocation("tribulation/hold_your_horses"), fileHelper);
		Advancement.Builder.advancement().parent(holdYourHorses).display(TechnologicaItems.PRIMITIVE_PICKAXE.get(), Component.translatable("advancements.tribulation.dawn_of_man.title"), Component.translatable("advancements.tribulation.dawn_of_man.description"), (ResourceLocation) null, FrameType.TASK, true, true, false).addCriterion("crafted_primitive_tool", InventoryChangeTrigger.TriggerInstance.hasItems(ItemPredicate.Builder.item().of(TechnologicaItems.PRIMITIVE_HATCHET.get(), TechnologicaItems.PRIMITIVE_HOE.get(), TechnologicaItems.PRIMITIVE_PICKAXE.get(), TechnologicaItems.PRIMITIVE_SHOVEL.get(), TechnologicaItems.PRIMITIVE_DAGGER.get()).build())).save(consumerIn, new TechnologicaLocation("tribulation/primitive_tool"), fileHelper);
	}
}
