package com.technologica.registration.deferred;

import com.technologica.Technologica;
import com.technologica.registration.deferred.util.MasterDeferredRegistrar;

import net.minecraft.world.entity.ai.attributes.Attribute;
import net.minecraft.world.entity.ai.attributes.RangedAttribute;
import net.minecraftforge.registries.RegistryObject;

/**
 * <p>
 * This class contains Registry Objects for Attributes.
 * The {@link #init} method is called by {@link Technologica#initDeferredRegisters} and returns a head-count to later be checked during registration and other setup activities.
 * </p>
 * 
 * @tl.status GREEN
 */
public final class TechnologicaAttributes extends MasterDeferredRegistrar {

	public static int init() {
		return ATTRIBUTES.getEntries().size();
	}

	public static final RegistryObject<Attribute> DIVER = ATTRIBUTES.register("diver", () -> new RangedAttribute("diver", 0, 0, 1).setSyncable(true));
}