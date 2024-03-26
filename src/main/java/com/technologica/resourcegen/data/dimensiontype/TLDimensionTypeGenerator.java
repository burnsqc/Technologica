package com.technologica.resourcegen.data.dimensiontype;

import java.util.OptionalLong;

import com.technologica.api.tlrg.resourcegen.TLRGDimensionTypeGenerator;
import com.technologica.registration.key.TechnologicaDimensionTypes;

import net.minecraft.data.worldgen.BootstapContext;
import net.minecraft.tags.BlockTags;
import net.minecraft.world.level.dimension.BuiltinDimensionTypes;
import net.minecraft.world.level.dimension.DimensionType;

public class TLDimensionTypeGenerator extends TLRGDimensionTypeGenerator {
	public static void bootstrap(BootstapContext<DimensionType> dimensionType) {
		dimensionType.register(TechnologicaDimensionTypes.MOON, TLRGDimensionType(0.0F, true, 1.0D, TechnologicaDimensionTypes.MOON_EFFECTS, OptionalLong.empty(), false, false, true, 384, BlockTags.INFINIBURN_OVERWORLD, 384, -64, 0, monsterSpawnLightLevel("uniform", 7, 0), true, false, false, false));
		dimensionType.register(TechnologicaDimensionTypes.CHALLENGER_DEEP, TLRGDimensionType(0.0F, true, 1.0D, TechnologicaDimensionTypes.MOON_EFFECTS, OptionalLong.empty(), true, false, false, 384, BlockTags.INFINIBURN_OVERWORLD, 384, -64, 0, monsterSpawnLightLevel("uniform", 7, 0), true, false, false, false));
		dimensionType.register(TechnologicaDimensionTypes.OVERGROWTH, TLRGDimensionType(0.1F, true, 1.0D, BuiltinDimensionTypes.NETHER_EFFECTS, OptionalLong.of(18000L), true, false, true, 384, BlockTags.INFINIBURN_OVERWORLD, 384, -64, 0, monsterSpawnLightLevel("uniform", 7, 0), true, false, false, false));
	}
}
