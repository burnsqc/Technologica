package com.technologica.world.gen.foliageplacer;

import java.util.Random;
import java.util.Set;

import com.mojang.serialization.Codec;
import com.mojang.serialization.codecs.RecordCodecBuilder;

import net.minecraft.util.math.BlockPos;
import net.minecraft.util.math.MutableBoundingBox;
import net.minecraft.world.gen.IWorldGenerationReader;
import net.minecraft.world.gen.feature.BaseTreeFeatureConfig;
import net.minecraft.world.gen.feature.FeatureSpread;
import net.minecraft.world.gen.foliageplacer.FoliagePlacer;
import net.minecraft.world.gen.foliageplacer.FoliagePlacerType;

public class ConicalFoliagePlacer extends FoliagePlacer {
	public static final Codec<ConicalFoliagePlacer> conicalCodec = RecordCodecBuilder.create((p_236742_0_) -> {
		return foliagePlacerParts(p_236742_0_).apply(p_236742_0_, ConicalFoliagePlacer::new);
	});
	
	public ConicalFoliagePlacer(FeatureSpread p_i241995_1_, FeatureSpread p_i241995_2_) {
		super(p_i241995_1_, p_i241995_2_);
	}

	protected FoliagePlacerType<?> type() {
		return TechnologicaFoliagePlacers.CONICAL.get();
	}

	//Generate foliage
	protected void createFoliage(IWorldGenerationReader worldIn, Random randomIn, BaseTreeFeatureConfig configIn, int p_230372_4_, FoliagePlacer.Foliage p_230372_5_, int layersBelowTop, int diameter, Set<BlockPos> p_230372_8_, int topLayer, MutableBoundingBox boundingBoxIn) 
	{
		for (int layer = topLayer + 1; layer >= topLayer - layersBelowTop + 1; --layer) 
		{
			int j = Math.max(diameter + p_230372_5_.radiusOffset() - layer + 1, 0);
			this.placeLeavesRow(worldIn, randomIn, configIn, p_230372_5_.foliagePos(), j, p_230372_8_, layer, p_230372_5_.doubleTrunk(), boundingBoxIn);
		}
	}

	//Adjust number of layers based upon trunk height
	public int foliageHeight(Random randomIn, int i, BaseTreeFeatureConfig configIn) {
		int trim;
		if (i == 2) {
			trim = i-1;
		} else if(i == 3) {
			trim = i-1;
		} else {
			trim = (randomIn.nextInt(5) == 0) ? i-1 : i-2;
		}
		return trim;
	}

	//Prune foliage
	protected boolean shouldSkipLocation(Random randomIn, int relativeZ, int relativeY, int relativeX, int p_230373_5_, boolean p_230373_6_) {
		if (relativeY==1) {
			return (relativeX + relativeZ >= 1);
		} else if (relativeY==0) {
			return (relativeX + relativeZ >= 2);
		} else if (relativeY==-1) { 
			return (relativeX + relativeZ >= 4);	
		} else if (relativeY==-2) { 
			return (relativeX + relativeZ >= 5);
		} else if (relativeY==-3) { 
			return (relativeX + relativeZ >= 7);
		} else {  
			return false;
		}
	}
}
