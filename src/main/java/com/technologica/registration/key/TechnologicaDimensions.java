package com.technologica.registration.key;

import com.technologica.registration.key.util.MasterKeyCreator;
import com.technologica.resourcegen.data.dimension.DimensionProvider;

import net.minecraft.resources.ResourceKey;
import net.minecraft.world.level.dimension.LevelStem;

/**
 * <p>
 * This class contains Resource Keys for Dimensions.
 * The corresponding Dimensions are created in json format during Data Generation in {@link DimensionProvider}.
 * </p>
 * 
 * @tl.status GREEN
 */
public final class TechnologicaDimensions extends MasterKeyCreator {
	public static final ResourceKey<LevelStem> MOON_STEM = dimension("moon");
	public static final ResourceKey<LevelStem> CHALLENGER_DEEP_STEM = dimension("challenger_deep");
	public static final ResourceKey<LevelStem> OVERGROWTH_STEM = dimension("overgrowth");
}