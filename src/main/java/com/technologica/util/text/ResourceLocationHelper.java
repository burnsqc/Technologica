package com.technologica.util.text;

import com.technologica.Technologica;

import net.minecraft.block.Block;
import net.minecraft.item.Item;
import net.minecraft.util.ResourceLocation;

public class ResourceLocationHelper {

	public ResourceLocation minecraftLocation(String pathIn) {
		return new ResourceLocation(pathIn);
	}

	public static ResourceLocation technologicaLocation(String pathIn) {
		return new ResourceLocation(Technologica.MODID, pathIn);
	}
	
	public static String getPath(Block block) {
        return block.getRegistryName().getPath();
    }
	
	public static String getPath(Item item) {
        return item.getRegistryName().getPath();
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
