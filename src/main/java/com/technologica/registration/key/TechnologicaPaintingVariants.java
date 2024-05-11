package com.technologica.registration.key;

import com.technologica.api.tlregen.registration.MasterKeyCreator;
import com.technologica.resourcegen.data.worldgen.biome.TLBiomes;

import net.minecraft.resources.ResourceKey;
import net.minecraft.world.entity.decoration.PaintingVariant;

/**
 * <p>
 * This class contains Resource Keys for Biomes.
 * The corresponding Biomes are created in json format during Data Generation in {@link TLBiomes}.
 * </p>
 * 
 * @tl.status GREEN
 */
public final class TechnologicaPaintingVariants extends MasterKeyCreator {
	public static final ResourceKey<PaintingVariant> AMNESIA = paintingVariant("amnesia");
}