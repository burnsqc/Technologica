package com.technologica.resourcegen.data.dimensiontype;

import java.util.OptionalLong;

import com.technologica.api.tlregen.resourcegen.data.TLReGenDimensionType;
import com.technologica.registration.key.TechnologicaDimensionTypes;

import net.minecraft.data.worldgen.BootstapContext;
import net.minecraft.tags.BlockTags;
import net.minecraft.util.valueproviders.UniformInt;
import net.minecraft.world.level.dimension.BuiltinDimensionTypes;
import net.minecraft.world.level.dimension.DimensionType;

public final class TLDimensionTypes extends TLReGenDimensionType {
	public static void bootstrap(final BootstapContext<DimensionType> dimensionType) {
		dimensionType.register(TechnologicaDimensionTypes.MOON, dimensionType(0.0F, true, 1.0D, TechnologicaDimensionTypes.MOON_EFFECTS, OptionalLong.empty(), false, false, true, 384, BlockTags.INFINIBURN_OVERWORLD, 384, -64, 0, UniformInt.of(0, 7), true, false, false, false));
		dimensionType.register(TechnologicaDimensionTypes.CHALLENGER_DEEP, dimensionType(0.0F, true, 1.0D, TechnologicaDimensionTypes.MOON_EFFECTS, OptionalLong.empty(), true, false, false, 384, BlockTags.INFINIBURN_OVERWORLD, 384, -64, 0, UniformInt.of(0, 7), true, false, false, false));
		dimensionType.register(TechnologicaDimensionTypes.OVERGROWTH, dimensionType(0.1F, true, 1.0D, BuiltinDimensionTypes.NETHER_EFFECTS, OptionalLong.of(18000L), true, false, true, 384, BlockTags.INFINIBURN_OVERWORLD, 384, -64, 0, UniformInt.of(0, 7), true, false, false, false));
	}
}
