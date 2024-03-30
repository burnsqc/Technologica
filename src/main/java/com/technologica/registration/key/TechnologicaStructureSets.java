package com.technologica.registration.key;

import com.technologica.registration.key.util.MasterKeyCreator;
import com.technologica.resourcegen.data.worldgen.structuresets.TLWorldgenStructureSetGenerator;

import net.minecraft.resources.ResourceKey;
import net.minecraft.world.level.levelgen.structure.StructureSet;

/**
 * <p>
 * This class contains Resource Keys for Structure Sets.
 * The corresponding Structure Sets are created in json format during Data Generation in {@link TLWorldgenStructureSetGenerator}.
 * </p>
 * 
 * @tl.status GREEN
 */
public final class TechnologicaStructureSets extends MasterKeyCreator {
	public static final ResourceKey<StructureSet> EL_DORADO = structureSet("el_dorado");
	public static final ResourceKey<StructureSet> DOME = structureSet("dome");
}