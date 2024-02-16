package com.technologica.resourcegen.data.tags.entity;

import java.util.concurrent.CompletableFuture;

import org.jetbrains.annotations.Nullable;

import com.technologica.Technologica;
import com.technologica.registration.deferred.TechnologicaEntityTypes;

import net.minecraft.core.HolderLookup.Provider;
import net.minecraft.data.PackOutput;
import net.minecraft.data.tags.EntityTypeTagsProvider;
import net.minecraft.tags.EntityTypeTags;
import net.minecraftforge.common.data.ExistingFileHelper;

public class EntityTagProvider extends EntityTypeTagsProvider {

	public EntityTagProvider(PackOutput packOutputIn, CompletableFuture<Provider> lookupProviderIn, @Nullable ExistingFileHelper existingFileHelperIn) {
		super(packOutputIn, lookupProviderIn, Technologica.MOD_ID, existingFileHelperIn);
	}

	@Override
	protected void addTags(Provider providerIn) {
		tag(EntityTypeTags.FALL_DAMAGE_IMMUNE).add(TechnologicaEntityTypes.DUCK.get());
	}

	@Override
	public String getName() {
		return "Tags - Entities:" + Technologica.MOD_ID;
	}
}