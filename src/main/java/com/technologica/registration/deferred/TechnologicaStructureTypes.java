package com.technologica.registration.deferred;

import com.technologica.Technologica;
import com.technologica.world.level.levelgen.structure.structures.DeepSeaStructure;
import com.technologica.world.level.levelgen.structure.structures.ElDoradoStructure;

import net.minecraft.world.level.levelgen.structure.StructureType;
import net.minecraftforge.registries.RegistryObject;

public final class TechnologicaStructureTypes {
	public static final RegistryObject<StructureType<ElDoradoStructure>> EL_DORADO = Technologica.STRUCTURE_TYPES.register("el_dorado", () -> () -> ElDoradoStructure.CODEC);
	public static final RegistryObject<StructureType<DeepSeaStructure>> DEEP_SEA = Technologica.STRUCTURE_TYPES.register("deep_sea", () -> () -> DeepSeaStructure.CODEC);
}
