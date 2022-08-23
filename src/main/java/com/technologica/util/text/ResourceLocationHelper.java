package com.technologica.util.text;

import com.technologica.Technologica;

import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.item.Item;
import net.minecraft.world.level.block.Block;
import net.minecraftforge.registries.ForgeRegistries;

public class ResourceLocationHelper {

	public ResourceLocation minecraftLocation(String pathIn) {
		return new ResourceLocation(pathIn);
	}

	public static ResourceLocation technologicaLocation(String pathIn) {
		return new ResourceLocation(Technologica.MODID, pathIn);
	}

	public static String getPath(Block block) {
		return ForgeRegistries.BLOCKS.getKey(block).getPath();
	}

	public static String getPath(Item item) {
		return ForgeRegistries.ITEMS.getKey(item).getPath();
	}

	public static String replace(String originalIn, String toBeReplacedIn, String replacementIn) {
		return new String(originalIn.replaceAll(toBeReplacedIn, replacementIn));
	}

	public static ResourceLocation extend(ResourceLocation rl, String suffix) {
		return new ResourceLocation(rl.getNamespace(), rl.getPath() + suffix);
	}

	public static ResourceLocation replace(ResourceLocation rl, String regex, String replacement) {
		return new ResourceLocation(rl.getNamespace(), rl.getPath().replaceAll(regex, replacement));
	}
}
