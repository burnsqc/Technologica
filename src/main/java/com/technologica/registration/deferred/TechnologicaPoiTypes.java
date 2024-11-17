package com.technologica.registration.deferred;

import com.google.common.collect.ImmutableSet;
import com.technologica.Technologica;

import net.minecraft.world.entity.ai.village.poi.PoiType;
import net.minecraftforge.registries.RegistryObject;

public final class TechnologicaPoiTypes {
	public static final RegistryObject<PoiType> ABYSS_PORTAL = Technologica.POI_TYPES.register("abyss_portal", () -> new PoiType(ImmutableSet.copyOf(TechnologicaBlocks.ABYSS_PORTAL.get().getStateDefinition().getPossibleStates()), 0, 1));
}
