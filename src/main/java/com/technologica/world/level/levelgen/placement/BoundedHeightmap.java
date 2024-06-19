package com.technologica.world.level.levelgen.placement;

import java.util.stream.Stream;

import com.mojang.serialization.Codec;
import com.mojang.serialization.codecs.RecordCodecBuilder;
import com.technologica.registration.deferred.TechnologicaPlacementModifierTypes;

import net.minecraft.core.BlockPos;
import net.minecraft.util.RandomSource;
import net.minecraft.util.valueproviders.IntProvider;
import net.minecraft.world.level.block.Blocks;
import net.minecraft.world.level.levelgen.placement.PlacementContext;
import net.minecraft.world.level.levelgen.placement.PlacementModifier;
import net.minecraft.world.level.levelgen.placement.PlacementModifierType;

public class BoundedHeightmap extends PlacementModifier {
	public static final Codec<BoundedHeightmap> CODEC = RecordCodecBuilder.create((p_191929_) -> {
		return p_191929_.group(Codec.INT.fieldOf("lower_bound").forGetter((p_191944_) -> {
			return p_191944_.lowerBound;
		}), Codec.INT.fieldOf("upper_bound").forGetter((p_191944_) -> {
			return p_191944_.upperBound;
		}), IntProvider.codec(0, 256).fieldOf("count").forGetter((p_191944_) -> {
			return p_191944_.count;
		})).apply(p_191929_, BoundedHeightmap::new);
	});

	private final int lowerBound;
	private final int upperBound;
	private final IntProvider count;

	public BoundedHeightmap(int lowerBound, int upperBound, IntProvider count) {
		this.count = count;
		this.lowerBound = lowerBound;
		this.upperBound = upperBound;
	}

	public static BoundedHeightmap of(int lowerBound, int upperBound, IntProvider count) {
		return new BoundedHeightmap(lowerBound, upperBound, count);
	}

	@Override
	public Stream<BlockPos> getPositions(PlacementContext placementContext, RandomSource random, BlockPos p_226331_) {
		int x = p_226331_.getX();
		int y = 0;
		int z = p_226331_.getZ();
		for (int height = this.lowerBound; height <= this.upperBound; height++) {
			y = height;
			if (placementContext.getBlockState(new BlockPos(x, height, z)).is(Blocks.WATER) || placementContext.getBlockState(new BlockPos(x, height, z)).isAir()) {
				break;
			}
		}

		return y > placementContext.getMinBuildHeight() ? Stream.of(new BlockPos(x, y, z)) : Stream.of();
	}

	@Override
	public PlacementModifierType<?> type() {
		return TechnologicaPlacementModifierTypes.BOUNDED_HEIGHTMAP.get();
	}
}
