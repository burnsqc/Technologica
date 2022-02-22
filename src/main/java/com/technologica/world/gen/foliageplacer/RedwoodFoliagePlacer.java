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

public class RedwoodFoliagePlacer extends FoliagePlacer {
	public static final Codec<RedwoodFoliagePlacer> redwoodCodec = RecordCodecBuilder.create((p_236742_0_) -> {
		return foliagePlacerParts(p_236742_0_).apply(p_236742_0_, RedwoodFoliagePlacer::new);
	});

	public RedwoodFoliagePlacer(FeatureSpread p_i241995_1_, FeatureSpread p_i241995_2_) {
		super(p_i241995_1_, p_i241995_2_);

	}

	protected FoliagePlacerType<?> type() {
		return TechnologicaFoliagePlacers.REDWOOD.get();
	}

	// Generate foliage
	protected void createFoliage(IWorldGenerationReader p_230372_1_, Random p_230372_2_,
			BaseTreeFeatureConfig p_230372_3_, int p_230372_4_, FoliagePlacer.Foliage p_230372_5_, int p_230372_6_,
			int p_230372_7_, Set<BlockPos> p_230372_8_, int p_230372_9_, MutableBoundingBox p_230372_10_) {
		BlockPos blockpos = p_230372_5_.foliagePos();
		int i = p_230372_2_.nextInt(2);
		int j = 0;
		int k = 0;

		for (int l = p_230372_9_; l >= -p_230372_6_; --l) {
			this.placeLeavesRow(p_230372_1_, p_230372_2_, p_230372_3_, blockpos, i, p_230372_8_, l,
					p_230372_5_.doubleTrunk(), p_230372_10_);
			if (i >= j) {
				i = k;
				k = 5;
				j = Math.min(j + 1, p_230372_7_ + p_230372_5_.radiusOffset());
			} else {
				++i;
			}
		}

	}

	// Adjust number of layers based upon trunk height
	public int foliageHeight(Random randomIn, int i, BaseTreeFeatureConfig configIn) {
		int trim;
		if (i == 2) {
			trim = i - 1;
		} else if (i == 3) {
			trim = i - 1;
		} else {
			trim = (randomIn.nextInt(5) == 0) ? i - 1 : i - 2;
		}
		return trim;
	}

	// Prune foliage
	protected boolean shouldSkipLocation(Random randomIn, int relativeZ, int relativeY, int relativeX, int p_230373_5_,
			boolean p_230373_6_) {
		if (relativeY >= 2) {
			return (relativeX + relativeZ >= 0);
		} else if (relativeY == 1) {
			return (relativeX + relativeZ >= 1);
		} else if (relativeY == 0) {
			return (relativeX + relativeZ >= 2);
		} else if (relativeY == -1) {
			return (relativeX + relativeZ >= 4);
		} else if (relativeY == -2) {
			return (relativeX + relativeZ >= 1);
		} else if (relativeY == -3) {
			return (relativeX + relativeZ >= 2);
		} else if (relativeY == -4) {
			return (relativeX + relativeZ >= 4);
		} else if (relativeY == -5) {
			return (relativeX + relativeZ >= 5);
		} else if (relativeY == -6) {
			return (relativeX + relativeZ >= 1);
		} else if (relativeY == -7) {
			return (relativeX + relativeZ >= 2);
		} else if (relativeY == -8) {
			return (relativeX + relativeZ >= 4);
		} else if (relativeY == -9) {
			return (relativeX + relativeZ >= 5);
		} else if (relativeY == -10) {
			return (relativeX + relativeZ >= 1);
		} else if (relativeY == -11) {
			return (relativeX + relativeZ >= 2);
		} else if (relativeY == -12) {
			return (relativeX + relativeZ >= 4);
		} else if (relativeY == -13) {
			return (relativeX + relativeZ >= 5);
		} else if (relativeY == -14) {
			return (relativeX + relativeZ >= 7);
		} else if (relativeY == -15) {
			return (relativeX + relativeZ >= 1);
		} else if (relativeY == -16) {
			return (relativeX + relativeZ >= 2);
		} else if (relativeY == -17) {
			return (relativeX + relativeZ >= 4);
		} else if (relativeY == -18) {
			return (relativeX + relativeZ >= 5);
		} else if (relativeY == -19) {
			return (relativeX + relativeZ >= 7);
		} else if (relativeY == -20) {
			return (relativeX + relativeZ >= 0);
		} else if (relativeY == -21) {
			return (relativeX + relativeZ >= 0);
		} else if (relativeY <= -22) {
			return (relativeX + relativeZ >= 0);
		} else {
			return false;
		}
	}
}
