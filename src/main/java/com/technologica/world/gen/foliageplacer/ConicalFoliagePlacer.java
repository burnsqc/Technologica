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

public class ConicalFoliagePlacer extends FoliagePlacer {
	public static final Codec<ConicalFoliagePlacer> field_236738_a_ = RecordCodecBuilder.create((p_236742_0_) -> {return func_236740_a_(p_236742_0_).apply(p_236742_0_, ConicalFoliagePlacer::new);});
	
	protected final int layersBelowTop;

	protected static <P extends ConicalFoliagePlacer> P3<Mu<P>, FeatureSpread, FeatureSpread, Integer> func_236740_a_(Instance<P> p_236740_0_) 
	{
		return func_242830_b(p_236740_0_).and(Codec.intRange(0, 16).fieldOf("height").forGetter((p_236741_0_) -> {return p_236741_0_.layersBelowTop;}));
	}

	public ConicalFoliagePlacer(FeatureSpread p_i241995_1_, FeatureSpread p_i241995_2_, int layersBelowTopIn) {
		super(p_i241995_1_, p_i241995_2_);
		this.layersBelowTop = layersBelowTopIn;
	}

	protected FoliagePlacerType<?> func_230371_a_() {
		return FoliagePlacerType.BLOB;
	}

	protected void func_230372_a_(IWorldGenerationReader worldIn, Random randomIn, BaseTreeFeatureConfig configIn, int p_230372_4_, FoliagePlacer.Foliage p_230372_5_, int p_230372_6_, int p_230372_7_, Set<BlockPos> p_230372_8_, int p_230372_9_, MutableBoundingBox boundingBoxIn) 
	{
		for (int i = p_230372_9_; i >= p_230372_9_ - p_230372_6_; --i) 
		{
			int j = Math.max(p_230372_7_ + p_230372_5_.func_236764_b_() - 1 - i / 2, 0);
			this.func_236753_a_(worldIn, randomIn, configIn, p_230372_5_.func_236763_a_(), j, p_230372_8_, i, p_230372_5_.func_236765_c_(), boundingBoxIn);
		}
	}

	public int func_230374_a_(Random randomIn, int p_230374_2_, BaseTreeFeatureConfig p_230374_3_) {
		return this.layersBelowTop;
	}

	protected boolean func_230373_a_(Random randomIn, int p_230373_2_, int p_230373_3_, int p_230373_4_, int p_230373_5_, boolean p_230373_6_) 
	{
		return p_230373_2_ == p_230373_5_ && p_230373_4_ == p_230373_5_ && (randomIn.nextInt(2) == 0 || p_230373_3_ == 0);
	}
}