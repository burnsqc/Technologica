package com.technologica.world.item;

import net.minecraft.core.BlockPos;
import net.minecraft.world.item.ItemNameBlockItem;
import net.minecraft.world.level.BlockGetter;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.state.BlockState;
import net.minecraftforge.common.IPlantable;
import net.minecraftforge.common.PlantType;

public class CropSeedItem extends ItemNameBlockItem implements IPlantable {
	private Block crop;

	public CropSeedItem(Block p_41579_, Properties p_41580_) {
		super(p_41579_, p_41580_);
		this.crop = p_41579_;
	}

	@Override
	public BlockState getPlant(BlockGetter level, BlockPos pos) {
		return crop.defaultBlockState();
	}

	@Override
	public PlantType getPlantType(BlockGetter level, BlockPos pos) {
		return PlantType.CROP;
	}
}