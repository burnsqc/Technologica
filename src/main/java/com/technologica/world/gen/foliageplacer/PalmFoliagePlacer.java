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

public class PalmFoliagePlacer extends FoliagePlacer {
	public static final Codec<PalmFoliagePlacer> palmCodec = RecordCodecBuilder.create((p_236742_0_) -> {
		return func_242830_b(p_236742_0_).apply(p_236742_0_, PalmFoliagePlacer::new);
	});
	
	public PalmFoliagePlacer(FeatureSpread width, FeatureSpread verticalOffset) {
		super(width, verticalOffset);
		
	}

	protected FoliagePlacerType<?> getPlacerType() {
		return TechnologicaFoliagePlacers.PALM.get();
	}

	//Generate foliage
	protected void func_230372_a_(IWorldGenerationReader worldIn, Random randomIn, BaseTreeFeatureConfig configIn, int p_230372_4_, FoliagePlacer.Foliage p_230372_5_, int layers, int diameter, Set<BlockPos> p_230372_8_, int topLayer, MutableBoundingBox boundingBoxIn) 
	{
		for (int layer = topLayer; layer >= topLayer - layers; --layer) 
		{
			int j = diameter;
			this.func_236753_a_(worldIn, randomIn, configIn, p_230372_5_.func_236763_a_(), j, p_230372_8_, layer, p_230372_5_.func_236765_c_(), boundingBoxIn);
		}
	}

	//Adjust number of layers based upon trunk height
	public int func_230374_a_(Random randomIn, int i, BaseTreeFeatureConfig configIn) {
		return 4;
	}

	//Prune foliage
	protected boolean func_230373_a_(Random randomIn, int relativeZ, int relativeY, int relativeX, int p_230373_5_, boolean p_230373_6_) {
		if (relativeY==1) {
			return relativeX != 0 && relativeZ != 0 || relativeX + relativeZ >= 4 || relativeX + relativeZ <= 1;
		} else if (relativeY==0) {
			return relativeX != 0 && relativeZ != 0 || relativeX + relativeZ >= 3;
		} else if (relativeY==-1) { 
			return relativeX != relativeZ && relativeX != relativeZ + 1 || relativeX + relativeZ >= 7;
		} else if (relativeY==-2) { 
			return relativeX != 0 && relativeZ != 0;
		} else if (relativeY==-3) { 
			return relativeX != relativeZ && relativeX != relativeZ + 1 || relativeX + relativeZ >= 7;
		} else {
			return false;
		}
	}
}
