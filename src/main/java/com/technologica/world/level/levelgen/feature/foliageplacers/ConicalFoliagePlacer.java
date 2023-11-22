package com.technologica.world.level.levelgen.feature.foliageplacers;

import com.mojang.serialization.Codec;
import com.mojang.serialization.codecs.RecordCodecBuilder;
import com.technologica.registration.deferred.TechnologicaFoliagePlacers;

import net.minecraft.util.RandomSource;
import net.minecraft.util.valueproviders.IntProvider;
import net.minecraft.world.level.LevelSimulatedReader;
import net.minecraft.world.level.levelgen.feature.configurations.TreeConfiguration;
import net.minecraft.world.level.levelgen.feature.foliageplacers.FoliagePlacer;
import net.minecraft.world.level.levelgen.feature.foliageplacers.FoliagePlacerType;

public class ConicalFoliagePlacer extends FoliagePlacer {
	public static final Codec<ConicalFoliagePlacer> conicalCodec = RecordCodecBuilder.create((p_236742_0_) -> {
		return foliagePlacerParts(p_236742_0_).apply(p_236742_0_, ConicalFoliagePlacer::new);
	});

	public ConicalFoliagePlacer(IntProvider p_i241995_1_, IntProvider p_i241995_2_) {
		super(p_i241995_1_, p_i241995_2_);
	}

	@Override
	protected FoliagePlacerType<?> type() {
		return TechnologicaFoliagePlacers.CONICAL.get();
	}

	@Override
	protected void createFoliage(LevelSimulatedReader p_161414_, FoliagePlacer.FoliageSetter p_161415_, RandomSource p_161416_, TreeConfiguration p_161417_, int p_230372_4_, FoliagePlacer.FoliageAttachment p_161419_, int layersBelowTop, int diameter, int topLayer) {
		for (int layer = topLayer + 1; layer >= topLayer - layersBelowTop + 1; --layer) {
			int j = Math.max(diameter + p_161419_.radiusOffset() - layer + 1, 0);
			this.placeLeavesRow(p_161414_, p_161415_, p_161416_, p_161417_, p_161419_.pos(), j, layer, p_161419_.doubleTrunk());
		}
	}

	@Override
	public int foliageHeight(RandomSource randomIn, int i, TreeConfiguration configIn) {
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

	@Override
	protected boolean shouldSkipLocation(RandomSource randomIn, int relativeZ, int relativeY, int relativeX, int p_230373_5_, boolean p_230373_6_) {
		if (relativeY == 1) {
			return (relativeX + relativeZ >= 1);
		} else if (relativeY == 0) {
			return (relativeX + relativeZ >= 2);
		} else if (relativeY == -1) {
			return (relativeX + relativeZ >= 4);
		} else if (relativeY == -2) {
			return (relativeX + relativeZ >= 5);
		} else if (relativeY == -3) {
			return (relativeX + relativeZ >= 7);
		} else {
			return false;
		}
	}
}
