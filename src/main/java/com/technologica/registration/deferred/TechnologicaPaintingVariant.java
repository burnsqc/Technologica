package com.technologica.registration.deferred;

import com.technologica.Technologica;
import com.technologica.registration.deferred.util.MasterDeferredRegistrar;

import net.minecraft.world.entity.decoration.PaintingVariant;
import net.minecraftforge.registries.RegistryObject;

/**
 * <p>
 * This class contains Registry Objects for Attributes.
 * The {@link #init} method is called by {@link Technologica#initDeferredRegisters} and returns a head-count to later be checked during registration and other setup activities.
 * </p>
 * 
 * @tl.status GREEN
 */
public final class TechnologicaPaintingVariant extends MasterDeferredRegistrar {

	public static int init() {
		return PAINTING_VARIANTS.getEntries().size();
	}

	public static final RegistryObject<PaintingVariant> AMNESIA = PAINTING_VARIANTS.register("amnesia", () -> new PaintingVariant(32, 32));
}