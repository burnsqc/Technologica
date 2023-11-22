package com.technologica.registration.key;

import com.technologica.registration.key.util.MasterKeyCreator;

import net.minecraft.tags.TagKey;
import net.minecraft.world.level.biome.Biome;

/**
 * <p>
 * This class contains Tag Keys for Biomes.  The corresponding Biome Tags are created in json format during Resource Generation.
 * </p>
 * 
 * @tl.status GREEN
 */
public final class TechnologicaBiomeTags extends MasterKeyCreator {
	public static final TagKey<Biome> HAS_EL_DORADO = biomeTag("has_el_dorado");
	public static final TagKey<Biome> HAS_DOME = biomeTag("has_dome");
}