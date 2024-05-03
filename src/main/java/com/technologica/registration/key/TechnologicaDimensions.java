package com.technologica.registration.key;

import com.technologica.api.tlregen.registration.MasterKeyCreator;
import com.technologica.resourcegen.data.dimension.TLDimensions;

import net.minecraft.resources.ResourceKey;
import net.minecraft.world.level.Level;
import net.minecraft.world.level.dimension.LevelStem;

/**
 * <p>
 * This class contains Resource Keys for Dimensions.
 * The corresponding Dimensions are created in json format during Data Generation in {@link TLDimensions}.
 * </p>
 * 
 * @tl.status GREEN
 */
public final class TechnologicaDimensions extends MasterKeyCreator {
	public static final ResourceKey<Level> MOON = dimension("moon");
	public static final ResourceKey<LevelStem> MOON_STEM = dimensionStem("moon");
	public static final ResourceKey<LevelStem> CHALLENGER_DEEP_STEM = dimensionStem("challenger_deep");
	public static final ResourceKey<LevelStem> OVERGROWTH_STEM = dimensionStem("overgrowth");
}