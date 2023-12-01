package com.technologica.world.item;

import java.util.function.Supplier;

import javax.annotation.Nullable;

import com.technologica.registration.deferred.TechnologicaBlocks;

import net.minecraft.core.BlockPos;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.item.BucketItem;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.level.Level;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.Blocks;
import net.minecraft.world.level.block.state.BlockState;
import net.minecraft.world.level.material.Fluid;
import net.minecraft.world.phys.BlockHitResult;

public class OilBucketItem extends BucketItem {

	public OilBucketItem(Supplier<? extends Fluid> supplier, Item.Properties builder) {
		super(supplier, builder);
	}

	@Override
	public boolean emptyContents(@Nullable Player player, Level level, BlockPos pos, @Nullable BlockHitResult result, @Nullable ItemStack container) {
		BlockState blockstate = level.getBlockState(result.getBlockPos());
		Block block = blockstate.getBlock();
		if (block.equals(Blocks.COARSE_DIRT)) {
			level.setBlock(result.getBlockPos(), TechnologicaBlocks.OILY_COARSE_DIRT.get().defaultBlockState(), 3);
			return true;
		} else if (block.equals(Blocks.GRAVEL)) {
			level.setBlock(result.getBlockPos(), TechnologicaBlocks.OILY_GRAVEL.get().defaultBlockState(), 3);
			return true;
		} else if (block.equals(Blocks.RED_SAND)) {
			level.setBlock(result.getBlockPos(), TechnologicaBlocks.OILY_RED_SAND.get().defaultBlockState(), 3);
			return true;
		} else if (block.equals(Blocks.SAND)) {
			level.setBlock(result.getBlockPos(), TechnologicaBlocks.OILY_SAND.get().defaultBlockState(), 3);
			return true;
		} else {
			return super.emptyContents(player, level, pos, result, container);
		}
	}
}