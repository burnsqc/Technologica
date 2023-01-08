package com.technologica.data.worldgen;

import java.util.Set;
import java.util.concurrent.CompletableFuture;

import com.technologica.Technologica;
import com.technologica.data.worldgen.placement.TechnologicaMiscOverworldPlacements;

import net.minecraft.core.HolderLookup.Provider;
import net.minecraft.data.PackOutput;
import net.minecraftforge.common.data.DatapackBuiltinEntriesProvider;

public class TechnologicaBiomeModifierProvider extends DatapackBuiltinEntriesProvider {
	public TechnologicaBiomeModifierProvider(PackOutput output, CompletableFuture<Provider> registries) {
		super(output, registries, TechnologicaMiscOverworldPlacements.BUILDER, Set.of(Technologica.MODID));
	}

	@Override
    public String getName() {
        return "Biome Modifier Registries: " + Technologica.MODID;
    }
}
