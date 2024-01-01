package com.technologica.world.level.levelgen.feature.foliageplacers;

import com.mojang.datafixers.Products.P3;
import com.mojang.serialization.Codec;
import com.mojang.serialization.codecs.RecordCodecBuilder;
import com.mojang.serialization.codecs.RecordCodecBuilder.Instance;
import com.mojang.serialization.codecs.RecordCodecBuilder.Mu;
import com.technologica.registration.deferred.TechnologicaFoliagePlacerTypes;

import net.minecraft.util.RandomSource;
import net.minecraft.util.valueproviders.IntProvider;
import net.minecraft.world.level.LevelSimulatedReader;
import net.minecraft.world.level.levelgen.feature.configurations.TreeConfiguration;
import net.minecraft.world.level.levelgen.feature.foliageplacers.FoliagePlacer;
import net.minecraft.world.level.levelgen.feature.foliageplacers.FoliagePlacerType;

public class TeardropFoliagePlacer extends FoliagePlacer {
	public static final Codec<TeardropFoliagePlacer> teardropCodec = RecordCodecBuilder.create(p_236742_0_ -> blobParts(p_236742_0_).apply(p_236742_0_, TeardropFoliagePlacer::new));

	protected int layersBelowTop;
	protected boolean largeTree;

	protected static <P extends TeardropFoliagePlacer> P3<Mu<P>, IntProvider, IntProvider, Integer> blobParts(Instance<P> p_236740_0_) {
		return foliagePlacerParts(p_236740_0_).and(Codec.intRange(0, 16).fieldOf("height").forGetter(p_236741_0_ -> p_236741_0_.layersBelowTop));
	}

	public TeardropFoliagePlacer(IntProvider p_i241995_1_, IntProvider p_i241995_2_, int layersBelowTopIn) {
		super(p_i241995_1_, p_i241995_2_);
		this.layersBelowTop = layersBelowTopIn;
		this.largeTree = false;
	}

	@Override
	protected FoliagePlacerType<?> type() {
		return TechnologicaFoliagePlacerTypes.TEARDROP.get();
	}

	@Override
	protected void createFoliage(LevelSimulatedReader readerIn, FoliagePlacer.FoliageSetter biConsumerIn, RandomSource RandomSourceIn, TreeConfiguration configIn, int p_161426_, FoliageAttachment attachmentIn, int p_161428_, int diameter, int topLayer) {
		for (int layer = topLayer + 3; layer >= topLayer + 3 - p_161428_; --layer) {
			int j = Math.max(diameter + 1 + attachmentIn.radiusOffset(), 0);
			this.placeLeavesRow(readerIn, biConsumerIn, RandomSourceIn, configIn, attachmentIn.pos(), j, layer, attachmentIn.doubleTrunk());
		}
	}

	@Override
	public int foliageHeight(RandomSource RandomSourceIn, int i, TreeConfiguration configIn) {
		int trim;
		if (i == 7) {
			trim = i + 1;
			largeTree = true;

		} else {
			trim = layersBelowTop;
			largeTree = false;
		}
		return trim;
	}

	@Override
	protected boolean shouldSkipLocation(RandomSource RandomSourceIn, int relativeZ, int relativeY, int relativeX, int p_230373_5_, boolean p_230373_6_) {
		if (relativeY >= 2) {
			return relativeX + relativeZ >= 1;
		} else if (relativeY == 1) {
			return relativeX + relativeZ >= 2;
		} else if (relativeY == 0) {
			return relativeX >= 2 || relativeZ >= 2;
		} else if (relativeY == -1) {
			return relativeX + relativeZ >= 3;
		} else if (relativeY == -2) {
			return relativeX + relativeZ >= 4 || relativeX >= 3 || relativeZ >= 3;
		} else if (relativeY == -3) {
			if (largeTree) {
				return relativeX + relativeZ >= 5;
			} else {
				return relativeX >= 2 || relativeZ >= 2;
			}
		} else if (relativeY == -4) {
			return relativeX + relativeZ >= 4 || relativeX >= 3 || relativeZ >= 3;
		} else if (relativeY == -5) {
			return relativeX >= 2 || relativeZ >= 2;
		} else {
			return false;
		}
	}
}
