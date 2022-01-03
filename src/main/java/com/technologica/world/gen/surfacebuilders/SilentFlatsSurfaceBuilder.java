package com.technologica.world.gen.surfacebuilders;

import java.util.Random;

import com.mojang.serialization.Codec;
import com.technologica.block.TechnologicaBlocks;

import net.minecraft.block.BlockState;
import net.minecraft.world.biome.Biome;
import net.minecraft.world.chunk.IChunk;
import net.minecraft.world.gen.surfacebuilders.SurfaceBuilder;
import net.minecraft.world.gen.surfacebuilders.SurfaceBuilderConfig;

public class SilentFlatsSurfaceBuilder extends SurfaceBuilder<SurfaceBuilderConfig> {
   public SilentFlatsSurfaceBuilder(Codec<SurfaceBuilderConfig> codec) {
      super(codec);
   }

   public void buildSurface(Random random, IChunk chunkIn, Biome biomeIn, int x, int z, int startHeight, double noise, BlockState defaultBlock, BlockState defaultFluid, int seaLevel, long seed, SurfaceBuilderConfig config) {
	   
	   SurfaceBuilderConfig config1 = new SurfaceBuilderConfig(TechnologicaBlocks.MOON_DUST.get().getDefaultState(), TechnologicaBlocks.MOON_DUST.get().getDefaultState(), TechnologicaBlocks.MOON_DUST.get().getDefaultState());
	   
	   SurfaceBuilder.DEFAULT.buildSurface(random, chunkIn, biomeIn, x, z, startHeight, noise, defaultBlock, defaultFluid, seaLevel, seed, config1);
   }
}
