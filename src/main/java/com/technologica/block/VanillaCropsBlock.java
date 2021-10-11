package com.technologica.block;

import java.util.function.Supplier;

import net.minecraft.block.AbstractBlock;
import net.minecraft.block.CropsBlock;
import net.minecraft.block.SoundType;
import net.minecraft.block.material.Material;
import net.minecraft.item.Item;
import net.minecraft.util.IItemProvider;

/**
 * Identical in behavior to vanilla Minecraft crops with one exception: The constructor accepts a supplier which sets the seed type.  
 * Created to return the associated seeds when duplicated in creative mode.
 */
public class VanillaCropsBlock extends CropsBlock {
	private Supplier<Item> seeds;
	
	public VanillaCropsBlock(Supplier<Item> seedsIn) {
		super(AbstractBlock.Properties.create(Material.PLANTS).doesNotBlockMovement().tickRandomly().zeroHardnessAndResistance().sound(SoundType.CROP));
		seeds = seedsIn;
	}

	/*
	 * Minecraft Methods
	 */
	
	@Override
	protected IItemProvider getSeedsItem() {
		return seeds.get();
	}
	
}
