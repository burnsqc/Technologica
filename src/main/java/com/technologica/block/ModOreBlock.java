package com.technologica.block;

import net.minecraft.block.AbstractBlock;
import net.minecraft.block.OreBlock;
import net.minecraft.block.SoundType;
import net.minecraft.block.material.Material;
import net.minecraft.block.material.MaterialColor;

public class ModOreBlock extends OreBlock {

	public ModOreBlock() {
		super(AbstractBlock.Properties.create(Material.ROCK, MaterialColor.STONE).hardnessAndResistance(6.0F).sound(SoundType.STONE));
	}
}