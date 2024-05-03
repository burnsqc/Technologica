package com.technologica.registration.key;

import com.technologica.api.tlregen.registration.MasterKeyCreator;
import com.technologica.resourcegen.data.worldgen.structure.TLWorldgenStructureGenerator;

import net.minecraft.resources.ResourceKey;
import net.minecraft.world.level.levelgen.structure.Structure;

/**
 * <p>
 * This class contains Resource Keys for Structures.
 * The corresponding Structures are created in json format during Data Generation in {@link TLWorldgenStructureGenerator}.
 * </p>
 * 
 * @tl.status GREEN
 */
public final class TechnologicaStructures extends MasterKeyCreator {
	public static final ResourceKey<Structure> EL_DORADO = structure("el_dorado");
	public static final ResourceKey<Structure> DOME = structure("dome");
}