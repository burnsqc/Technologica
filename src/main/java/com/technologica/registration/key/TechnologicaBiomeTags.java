package com.technologica.registration.key;

import com.technologica.api.tlregen.registration.MasterKeyCreator;
import com.technologica.resourcegen.data.tags.worldgen.biome.TLTagWorldgenBiomeGenerator;

import net.minecraft.tags.TagKey;
import net.minecraft.world.level.biome.Biome;

/**
 * <p>
 * This class contains Tag Keys for Biomes.
 * The corresponding Biome Tags are created in json format during Data Generation in {@link TLTagWorldgenBiomeGenerator}.
 * </p>
 * 
 * @tl.status GREEN
 */
public final class TechnologicaBiomeTags extends MasterKeyCreator {
	public static final TagKey<Biome> HAS_EL_DORADO = biomeTag("has_el_dorado");
	public static final TagKey<Biome> HAS_DOME = biomeTag("has_dome");
	public static final TagKey<Biome> HAS_WHALE_CARCASS = biomeTag("has_whale_carcass");
	public static final TagKey<Biome> ALLOWS_PUFFERFISH_SPAWNS_AT_ANY_HEIGHT = biomeTag("allows_pufferfish_spawns_at_any_height");
	public static final TagKey<Biome> ALLOWS_SQUID_SPAWNS_AT_ANY_HEIGHT = biomeTag("allows_squid_spawns_at_any_height");
	public static final TagKey<Biome> ALLOWS_TURTLE_SPAWNS_AT_ANY_HEIGHT = biomeTag("allows_turtle_spawns_at_any_height");
}