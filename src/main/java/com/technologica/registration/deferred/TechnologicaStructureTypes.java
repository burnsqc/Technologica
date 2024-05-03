package com.technologica.registration.deferred;

import com.technologica.Technologica;
import com.technologica.api.tlregen.registration.MasterDeferredRegistrar;
import com.technologica.world.level.levelgen.structure.structures.ElDoradoStructure;

import net.minecraft.world.level.levelgen.structure.StructureType;
import net.minecraftforge.registries.RegistryObject;

/**
 * <p>
 * This class contains Registry Objects for Structure Types.
 * The {@link #init} method is called by {@link Technologica#initDeferredRegisters} and returns a head-count to later be checked during registration and other setup activities.
 * </p>
 * 
 * @tl.status GREEN
 */
public final class TechnologicaStructureTypes extends MasterDeferredRegistrar {

	public static int init() {
		return STRUCTURE_TYPES.getEntries().size();
	}

	public static final RegistryObject<StructureType<ElDoradoStructure>> EL_DORADO = STRUCTURE_TYPES.register("el_dorado", () -> () -> ElDoradoStructure.CODEC);
}