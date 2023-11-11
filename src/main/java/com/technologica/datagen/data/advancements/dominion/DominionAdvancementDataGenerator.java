package com.technologica.datagen.data.advancements.dominion;

import java.util.function.Consumer;

import com.technologica.util.text.TechnologicaLocation;
import com.technologica.world.entity.TechnologicaEntityType;
import com.technologica.world.item.TechnologicaItems;

import net.minecraft.advancements.Advancement;
import net.minecraft.advancements.FrameType;
import net.minecraft.advancements.RequirementsStrategy;
import net.minecraft.advancements.critereon.ConsumeItemTrigger;
import net.minecraft.advancements.critereon.EntityPredicate;
import net.minecraft.advancements.critereon.KilledTrigger;
import net.minecraft.core.HolderLookup.Provider;
import net.minecraft.network.chat.Component;
import net.minecraft.resources.ResourceLocation;
import net.minecraftforge.common.data.ExistingFileHelper;
import net.minecraftforge.common.data.ForgeAdvancementProvider.AdvancementGenerator;

public class DominionAdvancementDataGenerator implements AdvancementGenerator {
	public DominionAdvancementDataGenerator() {
	}

	@Override
	public void generate(Provider providerIn, Consumer<Advancement> consumerIn, ExistingFileHelper fileHelper) {
		Advancement advancement = this.createRoot(consumerIn);
		Advancement.Builder.advancement().parent(advancement).display(TechnologicaItems.FUR.get(), Component.translatable("advancements.dominion.a_sign_of_things_to_come.title"), Component.translatable("advancements.dominion.a_sign_of_things_to_come.description"), (ResourceLocation) null, FrameType.TASK, true, true, false).requirements(RequirementsStrategy.OR).addCriterion("failed_harvest", KilledTrigger.TriggerInstance.playerKilledEntity(EntityPredicate.Builder.entity().of(TechnologicaEntityType.DEER.get()))).save(consumerIn, new TechnologicaLocation("dominion/a_sign_of_things_to_come"), fileHelper);
	}

	Advancement createRoot(Consumer<Advancement> consumerIn) {
		return Advancement.Builder.advancement().display(TechnologicaItems.FUR.get(), Component.translatable("advancements.dominion.root.title"), Component.translatable("advancements.dominion.root.description"), new TechnologicaLocation("textures/block/mulch.png"), FrameType.TASK, false, false, false).addCriterion("consumed_item", ConsumeItemTrigger.TriggerInstance.usedItem()).save(consumerIn, "dominion/root");
	}
}