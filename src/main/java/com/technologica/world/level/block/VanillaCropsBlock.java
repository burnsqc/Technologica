package com.technologica.world.level.block;

import java.util.function.Supplier;

import net.minecraft.world.level.block.state.BlockBehaviour;
import net.minecraft.world.level.block.CropBlock;
import net.minecraft.world.level.block.SoundType;
import net.minecraft.world.level.material.Material;
import net.minecraft.world.item.Item;
import net.minecraft.world.level.ItemLike;

/**
 * Identical in behavior to vanilla Minecraft crops with one exception: The constructor accepts a supplier which sets the seed type.  
 * Created to return the associated seeds when duplicated in creative mode.
 */
public class VanillaCropsBlock extends CropBlock {
	private Supplier<Item> seeds;
	
	public VanillaCropsBlock(Supplier<Item> seedsIn) {
		super(BlockBehaviour.Properties.of(Material.PLANT).noCollission().randomTicks().instabreak().sound(SoundType.CROP));
		seeds = seedsIn;
	}

	/*
	 * Minecraft Methods
	 */
	
	@Override
	protected ItemLike getBaseSeedId() {
		return seeds.get();
	}
	
}
