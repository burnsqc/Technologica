package com.technologica.world.level.levelgen.feature.foliageplacers;

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

public class DishFoliagePlacer extends FoliagePlacer {
	public static final Codec<DishFoliagePlacer> dishCodec = RecordCodecBuilder.create(p_236742_0_ -> blobParts(p_236742_0_).apply(p_236742_0_, DishFoliagePlacer::new));
	
	protected final int layers;

	protected static <P extends DishFoliagePlacer> P3<Mu<P>, IntProvider, IntProvider, Integer> blobParts(Instance<P> p_236740_0_) {
		return foliagePlacerParts(p_236740_0_).and(Codec.intRange(0, 16).fieldOf("height").forGetter(p_236741_0_ -> p_236741_0_.layers));
	}

	public DishFoliagePlacer(IntProvider width, IntProvider verticalOffset, int layersIn) {
		super(width, verticalOffset);
		this.layers = layersIn - 1;
	}

	protected FoliagePlacerType<?> type() {
		return TechnologicaFoliagePlacers.DISH.get();
	}

	@Override
	protected void createFoliage(LevelSimulatedReader p_161414_, BiConsumer<BlockPos, BlockState> p_161415_, Random p_161416_, TreeConfiguration p_161417_, int p_230372_4_, FoliagePlacer.FoliageAttachment p_161419_, int layersBelowTop, int diameter, int topLayer) {
		for (int layer = -2; layer >= -2 - layers; --layer) 
		{
			int j = diameter;
			this.placeLeavesRow(p_161414_, p_161415_, p_161416_, p_161417_, p_161419_.pos(), j, layer, p_161419_.doubleTrunk());
		}
	}

	public int foliageHeight(Random randomIn, int i, TreeConfiguration configIn) {
		return layers;
	}

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
