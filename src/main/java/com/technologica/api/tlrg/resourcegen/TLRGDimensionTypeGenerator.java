package com.technologica.api.tlrg.resourcegen;

import java.util.OptionalLong;
import java.util.Set;

import com.technologica.Technologica;

import net.minecraft.resources.ResourceLocation;
import net.minecraft.tags.TagKey;
import net.minecraft.util.valueproviders.IntProvider;
import net.minecraft.util.valueproviders.UniformInt;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.dimension.DimensionType;
import net.minecraftforge.common.data.DatapackBuiltinEntriesProvider;

public abstract class TLRGDimensionTypeGenerator extends DatapackBuiltinEntriesProvider {
	public TLRGDimensionTypeGenerator() {
		super(TLRGMasterResourceGenerator.packOutput, TLRGMasterResourceGenerator.lookupProvider, TLRGMasterResourceGenerator.registrySetBuilder, Set.of(Technologica.MOD_ID));
	}

	@Override
	public String getName() {
		return "TLRG - data." + Technologica.MOD_ID + ".dimension_type";
	}

	/*
	 * HELPER METHODS
	 */

	protected static DimensionType TLRGDimensionType(float ambientLight, boolean bedWorks, double coordinateScale, ResourceLocation effects, OptionalLong fixedTime, boolean hasCeiling, boolean hasRaids, boolean hasSkylight, int height, TagKey<Block> infiniburn, int logicalHeight, int minY, int monsterSpawnBlockLightLimit, IntProvider monsterSpawnLightLevel, boolean natural, boolean piglinSafe, boolean respawnAnchorWorks, boolean ultraWarm) {
		return new DimensionType(fixedTime, hasSkylight, hasCeiling, ultraWarm, natural, coordinateScale, bedWorks, respawnAnchorWorks, minY, height, logicalHeight, infiniburn, effects, ambientLight, new DimensionType.MonsterSettings(piglinSafe, hasRaids, monsterSpawnLightLevel, monsterSpawnBlockLightLimit));
	}

	protected static IntProvider monsterSpawnLightLevel(String type, int maxInclusive, int minInclusive) {
		return UniformInt.of(minInclusive, maxInclusive);
	}
}
