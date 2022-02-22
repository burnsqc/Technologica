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

public class DishFoliagePlacer extends FoliagePlacer {
	public static final Codec<DishFoliagePlacer> dishCodec = RecordCodecBuilder.create(p_236742_0_ -> blobParts(p_236742_0_).apply(p_236742_0_, DishFoliagePlacer::new));
	
	protected final int layers;

	protected static <P extends DishFoliagePlacer> P3<Mu<P>, FeatureSpread, FeatureSpread, Integer> blobParts(Instance<P> p_236740_0_) 
	{
		return foliagePlacerParts(p_236740_0_).and(Codec.intRange(0, 16).fieldOf("height").forGetter(p_236741_0_ -> p_236741_0_.layers));
	}

	public DishFoliagePlacer(FeatureSpread width, FeatureSpread verticalOffset, int layersIn) {
		super(width, verticalOffset);
		this.layers = layersIn - 1;
	}

	protected FoliagePlacerType<?> type() {
		return TechnologicaFoliagePlacers.DISH.get();
	}

	//Generate foliage
	protected void createFoliage(IWorldGenerationReader worldIn, Random randomIn, BaseTreeFeatureConfig configIn, int p_230372_4_, FoliagePlacer.Foliage p_230372_5_, int layers, int diameter, Set<BlockPos> p_230372_8_, int topLayer, MutableBoundingBox boundingBoxIn) 
	{
		for (int layer = -2; layer >= -2 - layers; --layer) 
		{
			int j = diameter;
			this.placeLeavesRow(worldIn, randomIn, configIn, p_230372_5_.foliagePos(), j, p_230372_8_, layer, p_230372_5_.doubleTrunk(), boundingBoxIn);
		}
	}

	//Adjust number of layers based upon trunk height
	public int foliageHeight(Random randomIn, int i, BaseTreeFeatureConfig configIn) {
		return layers;
	}

	//Prune foliage
	protected boolean shouldSkipLocation(Random randomIn, int relativeZ, int relativeY, int relativeX, int p_230373_5_, boolean p_230373_6_) {
		if (relativeY==-2) {
			return (relativeX*relativeX + relativeZ*relativeZ <= 75 || relativeX*relativeX + relativeZ*relativeZ >= 100);
		} else if (relativeY==-3) {
			return (relativeX*relativeX + relativeZ*relativeZ <= 40 || relativeX*relativeX + relativeZ*relativeZ >= 75);
		} else if (relativeY==-4) {
			return (relativeX*relativeX + relativeZ*relativeZ >= 40);
		} else {
			return false;
		}
	}
}
