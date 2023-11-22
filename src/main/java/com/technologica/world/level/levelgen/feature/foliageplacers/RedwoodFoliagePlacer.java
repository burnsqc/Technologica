package com.technologica.world.level.levelgen.feature.foliageplacers;

import com.mojang.serialization.Codec;
import com.mojang.serialization.codecs.RecordCodecBuilder;
import com.technologica.registration.deferred.TechnologicaFoliagePlacerTypes;

import net.minecraft.util.RandomSource;
import net.minecraft.util.valueproviders.IntProvider;
import net.minecraft.world.level.LevelSimulatedReader;
import net.minecraft.world.level.levelgen.feature.configurations.TreeConfiguration;
import net.minecraft.world.level.levelgen.feature.foliageplacers.FoliagePlacer;
import net.minecraft.world.level.levelgen.feature.foliageplacers.FoliagePlacerType;

public class RedwoodFoliagePlacer extends FoliagePlacer {
	public static final Codec<RedwoodFoliagePlacer> redwoodCodec = RecordCodecBuilder.create((p_236742_0_) -> {
		return foliagePlacerParts(p_236742_0_).apply(p_236742_0_, RedwoodFoliagePlacer::new);
	});

	public RedwoodFoliagePlacer(IntProvider p_i241995_1_, IntProvider p_i241995_2_) {
		super(p_i241995_1_, p_i241995_2_);
	}

	@Override
	protected FoliagePlacerType<?> type() {
		return TechnologicaFoliagePlacerTypes.REDWOOD.get();
	}

	@Override
	protected void createFoliage(LevelSimulatedReader p_161422_, FoliagePlacer.FoliageSetter p_161423_, RandomSource p_161424_, TreeConfiguration p_161425_, int p_161426_, FoliageAttachment p_161427_, int p_161428_, int diameter, int topLayer) {
		int i = p_161424_.nextInt(2);
		int j = 0;
		int k = 0;

		for (int l = diameter; l >= -p_161428_; --l) {
			this.placeLeavesRow(p_161422_, p_161423_, p_161424_, p_161425_, p_161427_.pos(), j, l, p_161427_.doubleTrunk());
			if (i >= j) {
				i = k;
				k = 5;
				j = Math.min(j + 1, p_161428_ + p_161427_.radiusOffset());
			} else {
				++i;
			}
		}
	}

	@Override
	public int foliageHeight(RandomSource RandomSourceIn, int i, TreeConfiguration configIn) {
		int trim;
		if (i == 2) {
			trim = i - 1;
		} else if (i == 3) {
			trim = i - 1;
		} else {
			trim = (RandomSourceIn.nextInt(5) == 0) ? i - 1 : i - 2;
		}
		return trim;
	}

	@Override
	protected boolean shouldSkipLocation(RandomSource RandomSourceIn, int relativeZ, int relativeY, int relativeX, int p_230373_5_, boolean p_230373_6_) {
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
