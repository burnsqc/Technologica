package com.technologica.world.level.levelgen.feature.trunkplacers;

import java.util.List;
import java.util.function.BiConsumer;

import com.google.common.collect.ImmutableList;
import com.google.common.collect.Lists;
import com.mojang.serialization.Codec;
import com.mojang.serialization.codecs.RecordCodecBuilder;
import com.technologica.registration.deferred.TechnologicaTrunkPlacerTypes;

import net.minecraft.core.BlockPos;
import net.minecraft.util.RandomSource;
import net.minecraft.world.level.LevelSimulatedReader;
import net.minecraft.world.level.block.state.BlockState;
import net.minecraft.world.level.levelgen.feature.configurations.TreeConfiguration;
import net.minecraft.world.level.levelgen.feature.foliageplacers.FoliagePlacer;
import net.minecraft.world.level.levelgen.feature.trunkplacers.GiantTrunkPlacer;
import net.minecraft.world.level.levelgen.feature.trunkplacers.TrunkPlacerType;

public class HugeTrunkPlacer extends GiantTrunkPlacer {
	public static final Codec<HugeTrunkPlacer> CODEC = RecordCodecBuilder.create((p_236902_0_) -> {
		return trunkPlacerParts(p_236902_0_).apply(p_236902_0_, HugeTrunkPlacer::new);
	});

	public HugeTrunkPlacer(int baseHeight, int heightRandA, int heightRandB) {
		super(baseHeight, heightRandA, heightRandB);
	}

	@Override
	protected TrunkPlacerType<?> type() {
		return TechnologicaTrunkPlacerTypes.HUGE_TRUNK_PLACER.get();
	}

	@Override
	public List<FoliagePlacer.FoliageAttachment> placeTrunk(LevelSimulatedReader p_161835_, BiConsumer<BlockPos, BlockState> p_161836_, RandomSource rand, int treeHeight, BlockPos p_230382_4_, TreeConfiguration p_161840_) {
		List<FoliagePlacer.FoliageAttachment> list = Lists.newArrayList();
		BlockPos blockpos = p_230382_4_.below();
		setDirtAt(p_161835_, p_161836_, rand, blockpos.east(), p_161840_);
		setDirtAt(p_161835_, p_161836_, rand, blockpos.south(), p_161840_);
		setDirtAt(p_161835_, p_161836_, rand, blockpos.south().east(), p_161840_);
		setDirtAt(p_161835_, p_161836_, rand, blockpos.south().west(), p_161840_);
		setDirtAt(p_161835_, p_161836_, rand, blockpos.west(), p_161840_);
		setDirtAt(p_161835_, p_161836_, rand, blockpos.north(), p_161840_);
		setDirtAt(p_161835_, p_161836_, rand, blockpos.north().east(), p_161840_);
		setDirtAt(p_161835_, p_161836_, rand, blockpos.north().west(), p_161840_);
		BlockPos.MutableBlockPos blockpos$mutable = new BlockPos.MutableBlockPos();

		for (int i = 0; i < treeHeight; ++i) {
			placeLogIfFreeWithOffset(p_161835_, p_161836_, rand, blockpos$mutable, p_161840_, p_230382_4_, 0, i, 0);
			if (i < treeHeight - 1) {
				placeLogIfFreeWithOffset(p_161835_, p_161836_, rand, blockpos$mutable, p_161840_, p_230382_4_, 1, i, 0);
				placeLogIfFreeWithOffset(p_161835_, p_161836_, rand, blockpos$mutable, p_161840_, p_230382_4_, 1, i, 1);
				placeLogIfFreeWithOffset(p_161835_, p_161836_, rand, blockpos$mutable, p_161840_, p_230382_4_, 0, i, 1);
				placeLogIfFreeWithOffset(p_161835_, p_161836_, rand, blockpos$mutable, p_161840_, p_230382_4_, -1, i, 0);
				placeLogIfFreeWithOffset(p_161835_, p_161836_, rand, blockpos$mutable, p_161840_, p_230382_4_, -1, i, -1);
				placeLogIfFreeWithOffset(p_161835_, p_161836_, rand, blockpos$mutable, p_161840_, p_230382_4_, 0, i, -1);
				placeLogIfFreeWithOffset(p_161835_, p_161836_, rand, blockpos$mutable, p_161840_, p_230382_4_, 1, i, -1);
				placeLogIfFreeWithOffset(p_161835_, p_161836_, rand, blockpos$mutable, p_161840_, p_230382_4_, -1, i, 1);
			}
		}
		list.addAll(ImmutableList.of(new FoliagePlacer.FoliageAttachment(p_230382_4_.above(treeHeight), 0, true)));

		return list;
	}

	private void placeLogIfFreeWithOffset(LevelSimulatedReader p_161842_, BiConsumer<BlockPos, BlockState> p_161843_, RandomSource p_161844_, BlockPos.MutableBlockPos p_161845_, TreeConfiguration p_161846_, BlockPos p_161847_, int p_161848_, int p_161849_, int p_161850_) {
		p_161845_.setWithOffset(p_161847_, p_161848_, p_161849_, p_161850_);
		this.placeLogIfFree(p_161842_, p_161843_, p_161844_, p_161845_, p_161846_);
	}
}
