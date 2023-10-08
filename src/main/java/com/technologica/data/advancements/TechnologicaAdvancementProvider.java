package com.technologica.data.advancements;

import java.util.List;
import java.util.concurrent.CompletableFuture;

import com.technologica.data.advancements.packs.DominionAdvancements;
import com.technologica.data.advancements.packs.TechnologicaHusbandryAdvancements;
import com.technologica.data.advancements.packs.TechnologyAdvancements;
import com.technologica.data.advancements.packs.TribulationAdvancements;

import net.minecraft.core.HolderLookup.Provider;
import net.minecraft.data.PackOutput;
import net.minecraftforge.common.data.ExistingFileHelper;
import net.minecraftforge.common.data.ForgeAdvancementProvider;

public class TechnologicaAdvancementProvider extends ForgeAdvancementProvider {
	private final static List<AdvancementGenerator> SUB_PROVIDERS = List.of(new TechnologicaHusbandryAdvancements(), new TechnologyAdvancements(), new DominionAdvancements(), new TribulationAdvancements());

	public TechnologicaAdvancementProvider(PackOutput packOutputIn, CompletableFuture<Provider> lookupProviderIn, ExistingFileHelper existingFileHelper) {
		super(packOutputIn, lookupProviderIn, existingFileHelper, SUB_PROVIDERS);
	}
}
