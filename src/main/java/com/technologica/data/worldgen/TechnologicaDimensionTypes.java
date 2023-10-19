package com.technologica.data.worldgen;

import java.util.OptionalLong;

import com.technologica.world.level.dimension.TechnologicaBuiltinDimensionTypes;

import net.minecraft.data.worldgen.BootstapContext;
import net.minecraft.tags.BlockTags;
import net.minecraft.util.valueproviders.UniformInt;
import net.minecraft.world.level.dimension.DimensionType;

public class TechnologicaDimensionTypes {
	public static void bootstrap(BootstapContext<DimensionType> context) {
		context.register(TechnologicaBuiltinDimensionTypes.MOON, new DimensionType(OptionalLong.empty(), true, false, false, true, 1.0D, true, false, -64, 384, 384, BlockTags.INFINIBURN_OVERWORLD, TechnologicaBuiltinDimensionTypes.MOON_EFFECTS, 0.0F, new DimensionType.MonsterSettings(false, true, UniformInt.of(0, 7), 0)));
		context.register(TechnologicaBuiltinDimensionTypes.CHALLENGER_DEEP, new DimensionType(OptionalLong.empty(), false, true, false, true, 1.0D, true, false, -64, 384, 384, BlockTags.INFINIBURN_OVERWORLD, TechnologicaBuiltinDimensionTypes.CHALLENGER_DEEP_EFFECTS, 0.0F, new DimensionType.MonsterSettings(false, true, UniformInt.of(0, 7), 0)));
	}
}
