package com.technologica.world.gen.foliageplacer;

import java.util.Random;
import java.util.Set;

import com.mojang.datafixers.Products.P3;
import com.mojang.serialization.Codec;
import com.mojang.serialization.codecs.RecordCodecBuilder;
import com.mojang.serialization.codecs.RecordCodecBuilder.Instance;
import com.mojang.serialization.codecs.RecordCodecBuilder.Mu;

import net.minecraft.util.math.BlockPos;
import net.minecraft.util.math.MutableBoundingBox;
import net.minecraft.world.gen.IWorldGenerationReader;
import net.minecraft.world.gen.feature.BaseTreeFeatureConfig;
import net.minecraft.world.gen.feature.FeatureSpread;
import net.minecraft.world.gen.foliageplacer.FoliagePlacer;
import net.minecraft.world.gen.foliageplacer.FoliagePlacerType;

public class TeardropFoliagePlacer extends FoliagePlacer {
	public static final Codec<TeardropFoliagePlacer> teardropCodec = RecordCodecBuilder.create(p_236742_0_ -> func_236740_a_(p_236742_0_).apply(p_236742_0_, TeardropFoliagePlacer::new));
	
	protected final int layersBelowTop;
	protected boolean largeTree;

	protected static <P extends TeardropFoliagePlacer> P3<Mu<P>, FeatureSpread, FeatureSpread, Integer> func_236740_a_(Instance<P> p_236740_0_) 
	{
		return func_242830_b(p_236740_0_).and(Codec.intRange(0, 16).fieldOf("height").forGetter(p_236741_0_ -> p_236741_0_.layersBelowTop));
	}

	public TeardropFoliagePlacer(FeatureSpread p_i241995_1_, FeatureSpread p_i241995_2_, int layersBelowTopIn) {
		super(p_i241995_1_, p_i241995_2_);
		this.layersBelowTop = layersBelowTopIn;
		this.largeTree = false;
	}

	@Override
	protected FoliagePlacerType<?> getPlacerType() {
		return TechnologicaFoliagePlacers.TEARDROP.get();
	}

	//Generate foliage
	@Override
	protected void func_230372_a_(IWorldGenerationReader worldIn, Random randomIn, BaseTreeFeatureConfig configIn, int p_230372_4_, FoliagePlacer.Foliage p_230372_5_, int layersBelowTop, int diameter, Set<BlockPos> p_230372_8_, int topLayer, MutableBoundingBox boundingBoxIn)
	{
		for (int layer = topLayer + 3; layer >= topLayer + 3 - layersBelowTop; --layer) 
		{
			int j = Math.max(diameter + 1 + p_230372_5_.func_236764_b_(), 0);
			this.func_236753_a_(worldIn, randomIn, configIn, p_230372_5_.func_236763_a_(), j, p_230372_8_, layer, p_230372_5_.func_236765_c_(), boundingBoxIn);
		}
	}

	//Adjust number of layers based upon trunk height
	@Override
	public int func_230374_a_(Random randomIn, int i, BaseTreeFeatureConfig configIn) {
		int trim;
		if (i == 7) {
			trim = i+1;
			largeTree = true;
		} else {
			trim = layersBelowTop;
			largeTree = false;
		}
		return trim;
	}

	//Prune foliage
	@Override
	protected boolean func_230373_a_(Random randomIn, int relativeZ, int relativeY, int relativeX, int p_230373_5_, boolean p_230373_6_) {
		if (relativeY>=2) {
			return relativeX + relativeZ >= 1;
		} else if (relativeY==1) {
			return relativeX + relativeZ >= 2;
		} else if (relativeY==0) { 
			return relativeX >= 2 || relativeZ >= 2;
		} else if (relativeY==-1) { 
			return relativeX + relativeZ >= 3;
		} else if (relativeY==-2) { 
			return relativeX + relativeZ >= 4 || relativeX >= 3 || relativeZ >= 3;
		} else if (relativeY==-3) {
			if (largeTree) {
				return relativeX + relativeZ >= 5;
			} else {
				return relativeX >= 2 || relativeZ >= 2;
			}
		} else if (relativeY==-4) {
			return relativeX + relativeZ >= 4 || relativeX >= 3 || relativeZ >= 3;
		} else if (relativeY==-5) {
			return relativeX >= 2 || relativeZ >= 2;
		} else {
			return false;
		}		
	}
}
