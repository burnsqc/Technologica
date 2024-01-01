package com.technologica.resourcegen.data.advancements;

import java.util.List;
import java.util.concurrent.CompletableFuture;

import com.technologica.resourcegen.data.advancements.dominion.DominionAdvancementDataGenerator;
import com.technologica.resourcegen.data.advancements.husbandry.HusbandryAdvancementDataGenerator;
import com.technologica.resourcegen.data.advancements.technology.TechnologyAdvancementDataProvider;
import com.technologica.resourcegen.data.advancements.tribulation.TribulationAdvancementDataGenerator;

import net.minecraft.core.HolderLookup.Provider;
import net.minecraft.data.PackOutput;
import net.minecraftforge.common.data.ExistingFileHelper;
import net.minecraftforge.common.data.ForgeAdvancementProvider;

public class AdvancementDataGenerator extends ForgeAdvancementProvider {
	private final static List<AdvancementGenerator> SUB_GENERATORS = List.of(new DominionAdvancementDataGenerator(), new HusbandryAdvancementDataGenerator(), new TechnologyAdvancementDataProvider(), new TribulationAdvancementDataGenerator());

	public AdvancementDataGenerator(PackOutput packOutputIn, CompletableFuture<Provider> lookupProviderIn, ExistingFileHelper existingFileHelper) {
		super(packOutputIn, lookupProviderIn, existingFileHelper, SUB_GENERATORS);
	}
}
