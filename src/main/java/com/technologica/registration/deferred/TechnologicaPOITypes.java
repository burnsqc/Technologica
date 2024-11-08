package com.technologica.registration.deferred;

import com.google.common.collect.ImmutableSet;
import com.technologica.Technologica;

import net.minecraft.world.entity.ai.village.poi.PoiType;
import net.minecraftforge.registries.RegistryObject;

public final class TechnologicaPOITypes {
	public static final RegistryObject<PoiType> ABYSS_PORTAL = Technologica.POINT_OF_INTEREST_TYPES.register("abyss_portal", () -> new PoiType(ImmutableSet.copyOf(TechnologicaBlocks.ABYSS_PORTAL.get().getStateDefinition().getPossibleStates()), 0, 1));
}
