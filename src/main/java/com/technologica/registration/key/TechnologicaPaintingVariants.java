package com.technologica.registration.key;

import com.technologica.registration.key.util.MasterKeyCreator;
import com.technologica.resourcegen.data.worldgen.biome.TLWorldgenBiomeGenerator;

import net.minecraft.resources.ResourceKey;
import net.minecraft.world.entity.decoration.PaintingVariant;

/**
 * <p>
 * This class contains Resource Keys for Biomes.
 * The corresponding Biomes are created in json format during Data Generation in {@link TLWorldgenBiomeGenerator}.
 * </p>
 * 
 * @tl.status GREEN
 */
public final class TechnologicaPaintingVariants extends MasterKeyCreator {
	public static final ResourceKey<PaintingVariant> AMNESIA = paintingVariantTag("amnesia");
}