package com.technologica.world.gen.trunkplacer;

import java.util.List;
import java.util.Random;
import java.util.Set;

import com.google.common.collect.ImmutableList;
import com.google.common.collect.Lists;
import com.mojang.serialization.Codec;
import com.mojang.serialization.codecs.RecordCodecBuilder;

import net.minecraft.util.math.BlockPos;
import net.minecraft.util.math.MutableBoundingBox;
import net.minecraft.world.gen.IWorldGenerationReader;
import net.minecraft.world.gen.feature.BaseTreeFeatureConfig;
import net.minecraft.world.gen.foliageplacer.FoliagePlacer;
import net.minecraft.world.gen.trunkplacer.GiantTrunkPlacer;
import net.minecraft.world.gen.trunkplacer.TrunkPlacerType;

public class ThreeWideTrunkPlacer extends GiantTrunkPlacer {
	public static final Codec<ThreeWideTrunkPlacer> field_236901_b_ = RecordCodecBuilder.create((p_236902_0_) -> {
		return getAbstractTrunkCodec(p_236902_0_).apply(p_236902_0_, ThreeWideTrunkPlacer::new);
	});

	public ThreeWideTrunkPlacer(int baseHeight, int heightRandA, int heightRandB) {
		super(baseHeight, heightRandA, heightRandB);
	}

	protected TrunkPlacerType<?> getPlacerType() {
		return TechnologicaTrunkPlacerType.THREE_WIDE_TRUNK_PLACER;
	}

	public List<FoliagePlacer.Foliage> getFoliages(IWorldGenerationReader reader, Random rand, int treeHeight, BlockPos p_230382_4_, Set<BlockPos> p_230382_5_, MutableBoundingBox p_230382_6_, BaseTreeFeatureConfig p_230382_7_) {
		List<FoliagePlacer.Foliage> list = Lists.newArrayList();
		BlockPos blockpos = p_230382_4_.down();
		func_236909_a_(reader, blockpos.east());
		func_236909_a_(reader, blockpos.south());
		func_236909_a_(reader, blockpos.south().east());
		func_236909_a_(reader, blockpos.south().west());
		func_236909_a_(reader, blockpos.west());
		func_236909_a_(reader, blockpos.north());
		func_236909_a_(reader, blockpos.north().east());
		func_236909_a_(reader, blockpos.north().west());
		BlockPos.Mutable blockpos$mutable = new BlockPos.Mutable();

		for (int i = 0; i < treeHeight; ++i) {
			func_236899_a_(reader, rand, blockpos$mutable, p_230382_5_, p_230382_6_, p_230382_7_, p_230382_4_, 0, i, 0);
			if (i < treeHeight - 1) {
				func_236899_a_(reader, rand, blockpos$mutable, p_230382_5_, p_230382_6_, p_230382_7_, p_230382_4_, 1, i, 0);
				func_236899_a_(reader, rand, blockpos$mutable, p_230382_5_, p_230382_6_, p_230382_7_, p_230382_4_, 1, i, 1);
				func_236899_a_(reader, rand, blockpos$mutable, p_230382_5_, p_230382_6_, p_230382_7_, p_230382_4_, 0, i, 1);
				func_236899_a_(reader, rand, blockpos$mutable, p_230382_5_, p_230382_6_, p_230382_7_, p_230382_4_, -1, i, 0);
				func_236899_a_(reader, rand, blockpos$mutable, p_230382_5_, p_230382_6_, p_230382_7_, p_230382_4_, -1, i, -1);
				func_236899_a_(reader, rand, blockpos$mutable, p_230382_5_, p_230382_6_, p_230382_7_, p_230382_4_, 0, i, -1);
				func_236899_a_(reader, rand, blockpos$mutable, p_230382_5_, p_230382_6_, p_230382_7_, p_230382_4_, 1, i, -1);
				func_236899_a_(reader, rand, blockpos$mutable, p_230382_5_, p_230382_6_, p_230382_7_, p_230382_4_, -1, i, 1);
			}
		}
		list.addAll(ImmutableList.of(new FoliagePlacer.Foliage(p_230382_4_.up(treeHeight), 0, true)));

		return list;
	}

	private static void func_236899_a_(IWorldGenerationReader p_236899_0_, Random p_236899_1_, BlockPos.Mutable blockPosIn, Set<BlockPos> p_236899_3_, MutableBoundingBox p_236899_4_, BaseTreeFeatureConfig p_236899_5_, BlockPos p_236899_6_, int p_236899_7_, int p_236899_8_, int p_236899_9_) {
		blockPosIn.setAndOffset(p_236899_6_, p_236899_7_, p_236899_8_, p_236899_9_);
		func_236910_a_(p_236899_0_, p_236899_1_, blockPosIn, p_236899_3_, p_236899_4_, p_236899_5_);
	}
}
