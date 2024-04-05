package com.technologica.api.tlregen.resourcegen.data;

import java.util.Set;

import com.technologica.Technologica;
import com.technologica.api.tlregen.resourcegen.TLRGMasterResourceGenerator;
import com.technologica.resourcegen.data.dimension.TLDimensionGenerator;

import net.minecraft.core.registries.Registries;
import net.minecraft.data.worldgen.BootstapContext;
import net.minecraft.resources.ResourceKey;
import net.minecraft.world.level.chunk.ChunkGenerator;
import net.minecraft.world.level.dimension.DimensionType;
import net.minecraft.world.level.dimension.LevelStem;
import net.minecraftforge.common.data.DatapackBuiltinEntriesProvider;

public abstract class TLReGenDimension extends DatapackBuiltinEntriesProvider {
	public TLReGenDimension() {
		super(TLRGMasterResourceGenerator.packOutput, TLRGMasterResourceGenerator.lookupProvider, TLRGMasterResourceGenerator.registrySetBuilder.add(Registries.LEVEL_STEM, TLDimensionGenerator::bootstrap), Set.of(Technologica.MOD_ID));
	}

	@Override
	public final String getName() {
		return "data." + Technologica.MOD_ID + ".dimension";
	}

	/*
	 * HELPER METHODS
	 */

	protected static LevelStem Dimension(BootstapContext<?> bootstrapContextIn, ResourceKey<DimensionType> moon, ChunkGenerator generator) {
		return new LevelStem(bootstrapContextIn.lookup(Registries.DIMENSION_TYPE).getOrThrow(moon), generator);
	}
}