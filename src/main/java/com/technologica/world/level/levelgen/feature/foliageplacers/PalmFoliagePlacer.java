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

public class PalmFoliagePlacer extends FoliagePlacer {
	public static final Codec<PalmFoliagePlacer> palmCodec = RecordCodecBuilder.create((p_236742_0_) -> {
		return foliagePlacerParts(p_236742_0_).apply(p_236742_0_, PalmFoliagePlacer::new);
	});

	public PalmFoliagePlacer(IntProvider width, IntProvider verticalOffset) {
		super(width, verticalOffset);
	}

	@Override
	protected FoliagePlacerType<?> type() {
		return TechnologicaFoliagePlacerTypes.PALM.get();
	}

	@Override
	protected void createFoliage(LevelSimulatedReader p_161422_, FoliagePlacer.FoliageSetter p_161423_, RandomSource p_161424_, TreeConfiguration p_161425_, int p_161426_, FoliageAttachment p_161427_, int layers, int diameter, int topLayer) {
		for (int layer = topLayer; layer >= topLayer - layers; --layer) {
			int j = diameter;
			this.placeLeavesRow(p_161422_, p_161423_, p_161424_, p_161425_, p_161427_.pos(), j, layer, p_161427_.doubleTrunk());
		}
	}

	@Override
	public int foliageHeight(RandomSource RandomSourceIn, int i, TreeConfiguration configIn) {
		return 4;
	}

	@Override
	protected boolean shouldSkipLocation(RandomSource RandomSourceIn, int relativeZ, int relativeY, int relativeX, int p_230373_5_, boolean p_230373_6_) {
		if (relativeY == 1) {
			return relativeX != 0 && relativeZ != 0 || relativeX + relativeZ >= 4 || relativeX + relativeZ <= 1;
		} else if (relativeY == 0) {
			return relativeX != 0 && relativeZ != 0 || relativeX + relativeZ >= 3;
		} else if (relativeY == -1) {
			return relativeX != relativeZ && relativeX != relativeZ + 1 || relativeX + relativeZ >= 7;
		} else if (relativeY == -2) {
			return relativeX != 0 && relativeZ != 0;
		} else if (relativeY == -3) {
			return relativeX != relativeZ && relativeX != relativeZ + 1 || relativeX + relativeZ >= 7;
		} else {
			return false;
		}
	}
}
