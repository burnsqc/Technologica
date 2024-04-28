package com.technologica.registration.key;

import com.technologica.registration.key.util.MasterKeyCreator;
import com.technologica.resourcegen.data.dimensiontype.TLDimensionTypes;
import com.technologica.util.text.TechnologicaLocation;

import net.minecraft.resources.ResourceKey;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.level.dimension.DimensionType;

/**
 * <p>
 * This class contains Resource Keys for Dimension Types.
 * The corresponding Dimension Types are created in json format during Data Generation in {@link TLDimensionTypes}.
 * </p>
 * 
 * @tl.status YELLOW
 */
public final class TechnologicaDimensionTypes extends MasterKeyCreator {
	public static final ResourceKey<DimensionType> MOON = dimensionType("moon");
	public static final ResourceKey<DimensionType> CHALLENGER_DEEP = dimensionType("challenger_deep");
	public static final ResourceKey<DimensionType> OVERGROWTH = dimensionType("overgrowth");
	//TODO: Never really liked that ResourceLocations for effects are here.  Determine where to move them.
	public static final ResourceLocation MOON_EFFECTS = new TechnologicaLocation("moon");
	public static final ResourceLocation CHALLENGER_DEEP_EFFECTS = new TechnologicaLocation("challenger_deep");
	public static final ResourceLocation OVERGROWTH_EFFECTS = new TechnologicaLocation("overgrowth");
}