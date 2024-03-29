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

public class CylindricalFoliagePlacer extends FoliagePlacer {
	public static final Codec<CylindricalFoliagePlacer> cylindricalCodec = RecordCodecBuilder.create(p_236742_0_ -> blobParts(p_236742_0_).apply(p_236742_0_, CylindricalFoliagePlacer::new));

	protected final int layers;

	protected static <P extends CylindricalFoliagePlacer> P3<Mu<P>, IntProvider, IntProvider, Integer> blobParts(Instance<P> p_236740_0_) {
		return foliagePlacerParts(p_236740_0_).and(Codec.intRange(0, 16).fieldOf("height").forGetter(p_236741_0_ -> p_236741_0_.layers));
	}

	public CylindricalFoliagePlacer(IntProvider width, IntProvider verticalOffset, int layersIn) {
		super(width, verticalOffset);
		this.layers = layersIn - 1;
	}

	@Override
	protected FoliagePlacerType<?> type() {
		return TechnologicaFoliagePlacerTypes.CYLINDRICAL.get();
	}

	@Override
	protected void createFoliage(LevelSimulatedReader p_161422_, FoliagePlacer.FoliageSetter p_161423_, RandomSource p_161424_, TreeConfiguration p_161425_, int p_161426_, FoliageAttachment p_161427_, int p_161428_, int diameter, int topLayer) {
		for (int layer = topLayer; layer >= topLayer - layers; --layer) {
			int j = diameter;
			this.placeLeavesRow(p_161422_, p_161423_, p_161424_, p_161425_, p_161427_.pos(), j, layer, p_161427_.doubleTrunk());
		}

	}

	@Override
	public int foliageHeight(RandomSource RandomSourceIn, int i, TreeConfiguration configIn) {
		return i;
	}

	@Override
	protected boolean shouldSkipLocation(RandomSource RandomSourceIn, int relativeZ, int relativeY, int relativeX, int p_230373_5_, boolean p_230373_6_) {
		return (relativeX * relativeX + relativeZ * relativeZ >= 100);
	}
}
