package com.technologica.data.advancements;

import java.util.List;
import java.util.concurrent.CompletableFuture;

import com.technologica.data.advancements.packs.TechnologicaHusbandryAdvancements;

import net.minecraft.core.HolderLookup.Provider;
import net.minecraft.data.PackOutput;
import net.minecraftforge.common.data.ExistingFileHelper;
import net.minecraftforge.common.data.ForgeAdvancementProvider;

public class TechnologicaAdvancementProvider extends ForgeAdvancementProvider {
	private final static List<AdvancementGenerator> subProviders = List.of(new TechnologicaHusbandryAdvancements());

    public TechnologicaAdvancementProvider(PackOutput packOutputIn, CompletableFuture<Provider> lookupProviderIn, ExistingFileHelper existingFileHelper) {
    	super(packOutputIn, lookupProviderIn, existingFileHelper, subProviders);
    }
}
