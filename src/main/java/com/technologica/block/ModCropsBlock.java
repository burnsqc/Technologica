package com.technologica.block;

import java.util.function.Supplier;

import net.minecraft.block.AbstractBlock;
import net.minecraft.block.CropsBlock;
import net.minecraft.block.SoundType;
import net.minecraft.block.material.Material;
import net.minecraft.item.Item;
import net.minecraft.util.IItemProvider;

public class ModCropsBlock extends CropsBlock {
	private Supplier<Item> seeds;
	
	public ModCropsBlock(Supplier<Item> seedsIn) {
		super(AbstractBlock.Properties.create(Material.PLANTS).doesNotBlockMovement().tickRandomly().zeroHardnessAndResistance().sound(SoundType.CROP));
		seeds = seedsIn;
	}

	@Override
	protected IItemProvider getSeedsItem() {
		return seeds.get();
	}
	
}
