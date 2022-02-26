package com.technologica.world.gen.foliageplacer;

import java.util.Random;
import java.util.function.BiConsumer;

import com.mojang.datafixers.Products.P3;
import com.mojang.serialization.Codec;
import com.mojang.serialization.codecs.RecordCodecBuilder;
import com.mojang.serialization.codecs.RecordCodecBuilder.Instance;
import com.mojang.serialization.codecs.RecordCodecBuilder.Mu;

import net.minecraft.core.BlockPos;
import net.minecraft.util.valueproviders.IntProvider;
import net.minecraft.world.level.LevelSimulatedReader;
import net.minecraft.world.level.block.state.BlockState;
import net.minecraft.world.level.levelgen.feature.configurations.TreeConfiguration;
import net.minecraft.world.level.levelgen.feature.foliageplacers.FoliagePlacer;
import net.minecraft.world.level.levelgen.feature.foliageplacers.FoliagePlacerType;

public class TeardropFoliagePlacer extends FoliagePlacer {
	public static final Codec<TeardropFoliagePlacer> teardropCodec = RecordCodecBuilder.create(p_236742_0_ -> blobParts(p_236742_0_).apply(p_236742_0_, TeardropFoliagePlacer::new));
	
	protected final int layersBelowTop;
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
		return TechnologicaFoliagePlacers.TEARDROP.get();
	}

	@Override
	protected void createFoliage(LevelSimulatedReader p_161422_, BiConsumer<BlockPos, BlockState> p_161423_, Random p_161424_, TreeConfiguration p_161425_, int p_161426_, FoliageAttachment p_161427_, int p_161428_, int diameter, int topLayer) {
		for (int layer = topLayer + 3; layer >= topLayer + 3 - layersBelowTop; --layer) {
			int j = Math.max(diameter + 1 + p_161427_.radiusOffset(), 0);
			this.placeLeavesRow(p_161422_, p_161423_, p_161424_, p_161425_, p_161427_.pos(), j, layer, p_161427_.doubleTrunk());
		}
	}

	@Override
	public int foliageHeight(Random randomIn, int i, TreeConfiguration configIn) {
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

	@Override
	protected boolean shouldSkipLocation(Random randomIn, int relativeZ, int relativeY, int relativeX, int p_230373_5_, boolean p_230373_6_) {
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
