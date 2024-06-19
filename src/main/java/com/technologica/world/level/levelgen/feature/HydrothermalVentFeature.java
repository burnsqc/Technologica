package com.technologica.world.level.levelgen.feature;

import javax.annotation.Nullable;

import com.google.common.collect.ImmutableList;
import com.mojang.serialization.Codec;
import com.technologica.registration.deferred.TechnologicaBlocks;

import net.minecraft.core.BlockPos;
import net.minecraft.core.Direction;
import net.minecraft.util.RandomSource;
import net.minecraft.world.level.LevelAccessor;
import net.minecraft.world.level.LevelWriter;
import net.minecraft.world.level.WorldGenLevel;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.Blocks;
import net.minecraft.world.level.block.SeaPickleBlock;
import net.minecraft.world.level.block.state.BlockState;
import net.minecraft.world.level.levelgen.feature.Feature;
import net.minecraft.world.level.levelgen.feature.FeaturePlaceContext;
import net.minecraft.world.level.levelgen.feature.configurations.ColumnFeatureConfiguration;

public class HydrothermalVentFeature extends Feature<ColumnFeatureConfiguration> {
	private static final ImmutableList<Block> CANNOT_PLACE_ON = ImmutableList.of(Blocks.LAVA, Blocks.BEDROCK, Blocks.MAGMA_BLOCK, Blocks.SOUL_SAND, Blocks.NETHER_BRICKS, Blocks.NETHER_BRICK_FENCE, Blocks.NETHER_BRICK_STAIRS, Blocks.NETHER_WART, Blocks.CHEST, Blocks.SPAWNER);
	private boolean decorated;

	public HydrothermalVentFeature(Codec<ColumnFeatureConfiguration> p_65153_) {
		super(p_65153_);
	}

	@Override
	public boolean place(FeaturePlaceContext<ColumnFeatureConfiguration> p_159444_) {
		int i = p_159444_.chunkGenerator().getSeaLevel();
		BlockPos blockpos = p_159444_.origin();
		WorldGenLevel worldgenlevel = p_159444_.level();
		RandomSource randomsource = p_159444_.random();
		decorated = randomsource.nextInt(5) == 0;
		ColumnFeatureConfiguration columnfeatureconfiguration = p_159444_.config();
		if (!canPlaceAt(worldgenlevel, i, blockpos.mutable())) {
			return false;
		} else {
			int j = columnfeatureconfiguration.height().sample(randomsource);
			boolean flag = randomsource.nextFloat() < 0.9F;
			int k = Math.min(j, flag ? 5 : 8);
			int l = flag ? 50 : 15;
			boolean flag1 = false;
			for (BlockPos blockpos1 : BlockPos.randomBetweenClosed(randomsource, l, blockpos.getX() - k, blockpos.getY(), blockpos.getZ() - k, blockpos.getX() + k, blockpos.getY(), blockpos.getZ() + k)) {
				int i1 = j - blockpos1.distManhattan(blockpos);
				if (i1 >= 0) {
					flag1 |= this.placeColumn(worldgenlevel, i, blockpos1, i1, columnfeatureconfiguration.reach().sample(randomsource));
				}
			}
			return flag1;
		}
	}

	private boolean placeColumn(LevelAccessor level, int p_65169_, BlockPos blockPos, int p_65171_, int p_65172_) {
		boolean flag = false;
		for (BlockPos blockpos : BlockPos.betweenClosed(blockPos.getX() - p_65172_, blockPos.getY(), blockPos.getZ() - p_65172_, blockPos.getX() + p_65172_, blockPos.getY(), blockPos.getZ() + p_65172_)) {
			int i = blockpos.distManhattan(blockPos);
			BlockPos blockpos1 = findSurface(level, p_65169_, blockpos.mutable(), i);
			if (blockpos1 != null) {
				int j = p_65171_ - i / 2;
				for (BlockPos.MutableBlockPos blockpos$mutableblockpos = blockpos1.mutable(); j >= 0; --j) {
					if (!level.getBlockState(blockpos$mutableblockpos).is(TechnologicaBlocks.MOLTEN_CORE.get())) {
						this.setBlock(level, blockpos$mutableblockpos, Blocks.BASALT.defaultBlockState());
					}
					this.setBlock(level, new BlockPos(blockPos.getX(), blockpos$mutableblockpos.getY(), blockPos.getZ()), TechnologicaBlocks.MOLTEN_CORE.get().defaultBlockState());
					Block.updateFromNeighbourShapes(TechnologicaBlocks.MOLTEN_CORE.get().defaultBlockState(), level, new BlockPos(blockPos.getX(), blockpos$mutableblockpos.getY(), blockPos.getZ()));
					blockpos$mutableblockpos.move(Direction.UP);
					if (decorated) {
						if (!level.getBlockState(blockpos$mutableblockpos).is(Blocks.BASALT) && !level.getBlockState(blockpos$mutableblockpos).is(TechnologicaBlocks.MOLTEN_CORE.get()) && level.getRandom().nextInt(4) == 0) {
							if (level.getRandom().nextBoolean()) {
								this.setBlock(level, blockpos$mutableblockpos, Blocks.FIRE_CORAL_FAN.defaultBlockState());
							} else {
								this.setBlock(level, blockpos$mutableblockpos, TechnologicaBlocks.BARNACLE.get().defaultBlockState().setValue(SeaPickleBlock.WATERLOGGED, true).setValue(SeaPickleBlock.PICKLES, Integer.valueOf(level.getRandom().nextInt(4) + 1)));
							}

						}
					}

					flag = true;
				}
			}
		}
		return flag;
	}

	@Nullable
	private static BlockPos findSurface(LevelAccessor p_65159_, int p_65160_, BlockPos.MutableBlockPos p_65161_, int p_65162_) {
		while (p_65161_.getY() > p_65159_.getMinBuildHeight() + 1 && p_65162_ > 0) {
			--p_65162_;
			if (canPlaceAt(p_65159_, p_65160_, p_65161_)) {
				return p_65161_;
			}
			p_65161_.move(Direction.DOWN);
		}
		return null;
	}

	private static boolean canPlaceAt(LevelAccessor p_65155_, int p_65156_, BlockPos.MutableBlockPos p_65157_) {
		BlockState blockstate = p_65155_.getBlockState(p_65157_.move(Direction.DOWN));
		p_65157_.move(Direction.UP);
		return !blockstate.isAir() && !CANNOT_PLACE_ON.contains(blockstate.getBlock());
	}

	@Nullable
	private static BlockPos findAir(LevelAccessor p_65174_, BlockPos.MutableBlockPos p_65175_, int p_65176_) {
		while (p_65175_.getY() < p_65174_.getMaxBuildHeight() && p_65176_ > 0) {
			--p_65176_;
			BlockState blockstate = p_65174_.getBlockState(p_65175_);
			if (CANNOT_PLACE_ON.contains(blockstate.getBlock())) {
				return null;
			}
			if (blockstate.isAir()) {
				return p_65175_;
			}
			p_65175_.move(Direction.UP);
		}
		return null;
	}

	@Override
	protected void setBlock(LevelWriter p_65791_, BlockPos p_65792_, BlockState p_65793_) {
		p_65791_.setBlock(p_65792_, p_65793_, 2);
	}
}
