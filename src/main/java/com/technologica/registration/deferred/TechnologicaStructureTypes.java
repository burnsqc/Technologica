package com.technologica.registration.deferred;

import com.technologica.Technologica;
import com.technologica.registration.deferred.util.MasterDeferredRegistrar;
import com.technologica.world.level.levelgen.structure.structures.ElDoradoStructure;

import net.minecraft.world.level.levelgen.structure.StructureType;
import net.minecraftforge.registries.RegistryObject;

public final class TechnologicaStructureTypes extends MasterDeferredRegistrar {
	
	public static int init() {
		STRUCTURE_TYPES.register(Technologica.MOD_EVENT_BUS);
		return STRUCTURE_TYPES.getEntries().size();
	}

	public static final RegistryObject<StructureType<ElDoradoStructure>> EL_DORADO = STRUCTURE_TYPES.register("el_dorado", () -> () -> ElDoradoStructure.CODEC);	
}