package com.technologica.resourcegen.data.tags.entity;

import com.technologica.api.tlregen.resourcegen.data.TLRGTagsEntityTypesGenerator;
import com.technologica.registration.deferred.TechnologicaEntityTypes;

import net.minecraft.core.HolderLookup.Provider;
import net.minecraft.tags.EntityTypeTags;

public class TLTagEntityTypeGenerator extends TLRGTagsEntityTypesGenerator {
	@Override
	protected void addTags(Provider providerIn) {
		tag(EntityTypeTags.FALL_DAMAGE_IMMUNE).add(TechnologicaEntityTypes.DUCK.get());
	}
}
