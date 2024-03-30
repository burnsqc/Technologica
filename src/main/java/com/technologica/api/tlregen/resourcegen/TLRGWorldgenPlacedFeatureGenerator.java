package com.technologica.api.tlregen.resourcegen;

import java.util.List;
import java.util.Set;

import com.google.common.collect.ImmutableList;
import com.technologica.Technologica;
import com.technologica.resourcegen.data.worldgen.placedfeature.TLWorldgenPlacedFeatureGenerator;

import net.minecraft.core.registries.Registries;
import net.minecraft.data.worldgen.placement.PlacementUtils;
import net.minecraft.world.level.levelgen.placement.BiomeFilter;
import net.minecraft.world.level.levelgen.placement.CountPlacement;
import net.minecraft.world.level.levelgen.placement.InSquarePlacement;
import net.minecraft.world.level.levelgen.placement.PlacementModifier;
import net.minecraft.world.level.levelgen.placement.SurfaceWaterDepthFilter;
import net.minecraftforge.common.data.DatapackBuiltinEntriesProvider;

public abstract class TLRGWorldgenPlacedFeatureGenerator extends DatapackBuiltinEntriesProvider {
	protected static final PlacementModifier TREE_THRESHOLD = SurfaceWaterDepthFilter.forMaxDepth(0);

	public TLRGWorldgenPlacedFeatureGenerator() {
		super(TLRGMasterResourceGenerator.packOutput, TLRGMasterResourceGenerator.lookupProvider, TLRGMasterResourceGenerator.registrySetBuilder.add(Registries.PLACED_FEATURE, TLWorldgenPlacedFeatureGenerator::bootstrap), Set.of(Technologica.MOD_ID));
	}

	@Override
	public String getName() {
		return "TLRG - data." + Technologica.MOD_ID + ".worldgen.placed_feature";
	}

	protected static List<PlacementModifier> commonOrePlacement(int p_195344_, PlacementModifier p_195345_) {
		return orePlacement(CountPlacement.of(p_195344_), p_195345_);
	}

	private static List<PlacementModifier> orePlacement(PlacementModifier p_195347_, PlacementModifier p_195348_) {
		return List.of(p_195347_, InSquarePlacement.spread(), p_195348_, BiomeFilter.biome());
	}

	protected static List<PlacementModifier> treePlacement(PlacementModifier p_195345_) {
		return List.of(p_195345_);
	}

	private static ImmutableList.Builder<PlacementModifier> treePlacementBase(PlacementModifier p_195485_) {
		return ImmutableList.<PlacementModifier>builder().add(p_195485_).add(InSquarePlacement.spread()).add(TREE_THRESHOLD).add(PlacementUtils.HEIGHTMAP_OCEAN_FLOOR).add(BiomeFilter.biome());
	}

	public static List<PlacementModifier> vegetationPlacement(PlacementModifier p_195480_) {
		return treePlacementBase(p_195480_).build();
	}
}
