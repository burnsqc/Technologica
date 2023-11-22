package com.technologica.resourcegen.data.dimensiontype;

import java.util.OptionalLong;
import java.util.Set;
import java.util.concurrent.CompletableFuture;

import com.technologica.Technologica;
import com.technologica.registration.key.TechnologicaDimensionTypes;
import com.technologica.resourcegen.util.TLRGTemplates;

import net.minecraft.core.HolderLookup.Provider;
import net.minecraft.core.RegistrySetBuilder;
import net.minecraft.data.PackOutput;
import net.minecraft.data.worldgen.BootstapContext;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.tags.BlockTags;
import net.minecraft.tags.TagKey;
import net.minecraft.util.valueproviders.IntProvider;
import net.minecraft.util.valueproviders.UniformInt;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.dimension.BuiltinDimensionTypes;
import net.minecraft.world.level.dimension.DimensionType;
import net.minecraftforge.common.data.DatapackBuiltinEntriesProvider;

public class DimensionTypeProvider extends DatapackBuiltinEntriesProvider {
	
	public DimensionTypeProvider(PackOutput output, CompletableFuture<Provider> registries, RegistrySetBuilder builder) {
		super(output, registries, builder, Set.of(Technologica.MOD_ID));
	}
	
	public static void bootstrap(BootstapContext<DimensionType> bootstrapContextIn) {
		bootstrapContextIn.register(TechnologicaDimensionTypes.MOON, moon());
		bootstrapContextIn.register(TechnologicaDimensionTypes.CHALLENGER_DEEP, challengerDeep());
		bootstrapContextIn.register(TechnologicaDimensionTypes.OVERGROWTH, overgrowth());
	}

	private static DimensionType moon() {
		return dimensionType(
			0.0F, 
			true, 
			1.0D, 
			TechnologicaDimensionTypes.MOON_EFFECTS, 
			OptionalLong.empty(), 
			false, 
			false, 
			true, 
			384, 
			BlockTags.INFINIBURN_OVERWORLD, 
			384, 
			-64, 
			0, 
			monsterSpawnLightLevel("uniform", 7, 0), 
			true, 
			false, 
			false, 
			false);
	}

	private static DimensionType challengerDeep() {
		return dimensionType(
			0.0F, 
			true, 
			1.0D, 
			TechnologicaDimensionTypes.MOON_EFFECTS, 
			OptionalLong.empty(), 
			true, 
			false, 
			false, 384, BlockTags.INFINIBURN_OVERWORLD, 384, -64, 0, monsterSpawnLightLevel("uniform", 7, 0), true, false, false, false);
	}

	private static DimensionType overgrowth() {
		return dimensionType(
			0.1F, 
			true, 
			1.0D, 
			BuiltinDimensionTypes.NETHER_EFFECTS, 
			OptionalLong.of(18000L), 
			true, 
			false, 
			true, 
			384, 
			BlockTags.INFINIBURN_OVERWORLD, 
			384, 
			-64, 
			0, 
			TLRGTemplates.TLRGMonsterSpawnLightLevel(UniformInt.class, 7, 0), 
			true, 
			false, 
			false, 
			false);
	}

	private static DimensionType dimensionType(float ambientLight, boolean bedWorks, double coordinateScale, ResourceLocation effects, OptionalLong fixedTime, boolean hasCeiling, boolean hasRaids, boolean hasSkylight, int height, TagKey<Block> infiniburn, int logicalHeight, int minY, int monsterSpawnBlockLightLimit, IntProvider monsterSpawnLightLevel, boolean natural, boolean piglinSafe, boolean respawnAnchorWorks, boolean ultraWarm) {
		return new DimensionType(fixedTime, hasSkylight, hasCeiling, ultraWarm, natural, coordinateScale, bedWorks, respawnAnchorWorks, minY, height, logicalHeight, infiniburn, effects, ambientLight, new DimensionType.MonsterSettings(piglinSafe, hasRaids, monsterSpawnLightLevel, monsterSpawnBlockLightLimit));
	}

	private static IntProvider monsterSpawnLightLevel(String type, int maxInclusive, int minInclusive) {
		return UniformInt.of(minInclusive, maxInclusive);
	}
	
	@Override
	public String getName() {
		return "Dimension Types";
	}
}