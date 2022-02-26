package com.technologica.world.gen.foliageplacer;

import java.util.Random;
import java.util.function.BiConsumer;

import com.mojang.serialization.Codec;
import com.mojang.serialization.codecs.RecordCodecBuilder;

import net.minecraft.core.BlockPos;
import net.minecraft.util.valueproviders.IntProvider;
import net.minecraft.world.level.LevelSimulatedReader;
import net.minecraft.world.level.block.state.BlockState;
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

	protected FoliagePlacerType<?> type() {
		return TechnologicaFoliagePlacers.PALM.get();
	}

	@Override
	protected void createFoliage(LevelSimulatedReader p_161422_, BiConsumer<BlockPos, BlockState> p_161423_, Random p_161424_, TreeConfiguration p_161425_, int p_161426_, FoliageAttachment p_161427_, int layers, int diameter, int topLayer) {
		for (int layer = topLayer; layer >= topLayer - layers; --layer) {
			int j = diameter;
			this.placeLeavesRow(p_161422_, p_161423_, p_161424_, p_161425_, p_161427_.pos(), j, layer, p_161427_.doubleTrunk());
		}
	}

	public int foliageHeight(Random randomIn, int i, TreeConfiguration configIn) {
		return 4;
	}

	protected boolean shouldSkipLocation(Random randomIn, int relativeZ, int relativeY, int relativeX, int p_230373_5_, boolean p_230373_6_) {
		if (relativeY==1) {
			return relativeX != 0 && relativeZ != 0 || relativeX + relativeZ >= 4 || relativeX + relativeZ <= 1;
		} else if (relativeY==0) {
			return relativeX != 0 && relativeZ != 0 || relativeX + relativeZ >= 3;
		} else if (relativeY==-1) { 
			return relativeX != relativeZ && relativeX != relativeZ + 1 || relativeX + relativeZ >= 7;
		} else if (relativeY==-2) { 
			return relativeX != 0 && relativeZ != 0;
		} else if (relativeY==-3) { 
			return relativeX != relativeZ && relativeX != relativeZ + 1 || relativeX + relativeZ >= 7;
		} else {
			return false;
		}
	}
}
