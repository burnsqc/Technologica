package com.technologica.registration.deferred;

import com.technologica.Technologica;
import com.technologica.world.level.levelgen.placement.BoundedHeightmap;

import net.minecraft.world.level.levelgen.placement.PlacementModifierType;
import net.minecraftforge.registries.RegistryObject;

public final class TechnologicaPlacementModifierTypes {
	public static final RegistryObject<PlacementModifierType<BoundedHeightmap>> BOUNDED_HEIGHTMAP = Technologica.PLACEMENT_MODIFIER_TYPES.register("bounded_heightmap", () -> () -> BoundedHeightmap.CODEC);
}
