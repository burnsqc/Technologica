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
	public static final Codec<DishFoliagePlacer> dishCodec = RecordCodecBuilder.create(p_236742_0_ -> func_236740_a_(p_236742_0_).apply(p_236742_0_, DishFoliagePlacer::new));
	
	protected final int layers;

	protected static <P extends DishFoliagePlacer> P3<Mu<P>, FeatureSpread, FeatureSpread, Integer> func_236740_a_(Instance<P> p_236740_0_) 
	{
		return func_242830_b(p_236740_0_).and(Codec.intRange(0, 16).fieldOf("height").forGetter(p_236741_0_ -> p_236741_0_.layers));
	}

	public DishFoliagePlacer(FeatureSpread width, FeatureSpread verticalOffset, int layersIn) {
		super(width, verticalOffset);
		this.layers = layersIn - 1;
	}

	protected FoliagePlacerType<?> getPlacerType() {
		return TechnologicaFoliagePlacers.DISH.get();
	}

	//Generate foliage
	protected void func_230372_a_(IWorldGenerationReader worldIn, Random randomIn, BaseTreeFeatureConfig configIn, int p_230372_4_, FoliagePlacer.Foliage p_230372_5_, int layers, int diameter, Set<BlockPos> p_230372_8_, int topLayer, MutableBoundingBox boundingBoxIn) 
	{
		for (int layer = -2; layer >= -2 - layers; --layer) 
		{
			int j = diameter;
			this.func_236753_a_(worldIn, randomIn, configIn, p_230372_5_.func_236763_a_(), j, p_230372_8_, layer, p_230372_5_.func_236765_c_(), boundingBoxIn);
		}
	}

	//Adjust number of layers based upon trunk height
	public int func_230374_a_(Random randomIn, int i, BaseTreeFeatureConfig configIn) {
		return layers;
	}

	//Prune foliage
	protected boolean func_230373_a_(Random randomIn, int relativeZ, int relativeY, int relativeX, int p_230373_5_, boolean p_230373_6_) {
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
