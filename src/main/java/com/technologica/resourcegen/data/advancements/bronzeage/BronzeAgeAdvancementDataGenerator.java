package com.technologica.resourcegen.data.advancements.bronzeage;

import java.util.function.Consumer;

import com.technologica.registration.deferred.TechnologicaItems;
import com.technologica.util.text.TechnologicaLocation;

import net.minecraft.advancements.Advancement;
import net.minecraft.advancements.FrameType;
import net.minecraft.advancements.critereon.EnterBlockTrigger;
import net.minecraft.core.HolderLookup.Provider;
import net.minecraft.network.chat.Component;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.level.block.Blocks;
import net.minecraftforge.common.data.ExistingFileHelper;
import net.minecraftforge.common.data.ForgeAdvancementProvider.AdvancementGenerator;

public class BronzeAgeAdvancementDataGenerator implements AdvancementGenerator {
	public BronzeAgeAdvancementDataGenerator() {
	}

	@Override
	public void generate(Provider providerIn, Consumer<Advancement> consumerIn, ExistingFileHelper fileHelper) {
		Advancement bronzeAge = Advancement.Builder.advancement().display(TechnologicaItems.BRONZE_INGOT.get(), Component.translatable("advancements.bronze_age.root.title"), Component.translatable("advancements.bronze_age.root.description"), new ResourceLocation("textures/block/quartz_pillar.png"), FrameType.CHALLENGE, true, true, false).addCriterion("exist", EnterBlockTrigger.TriggerInstance.entersBlock(Blocks.AIR)).save(consumerIn, new TechnologicaLocation("bronze_age/root"), fileHelper);

	}
}
