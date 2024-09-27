package com.technologica.registration.deferred;

import com.technologica.api.tlregen.registration.MasterDeferredRegistrar;
import com.technologica.world.level.levelgen.placement.BoundedHeightmap;

import net.minecraft.world.level.levelgen.placement.PlacementModifierType;
import net.minecraftforge.registries.RegistryObject;

public final class TechnologicaPlacementModifierTypes extends MasterDeferredRegistrar {
	public static final RegistryObject<PlacementModifierType<BoundedHeightmap>> BOUNDED_HEIGHTMAP = PLACEMENT_MODIFIER_TYPES.register("bounded_heightmap", () -> () -> BoundedHeightmap.CODEC);
}