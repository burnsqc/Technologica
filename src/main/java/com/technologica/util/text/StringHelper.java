package com.technologica.util.text;

import net.minecraft.block.Block;
import net.minecraft.item.Item;
import net.minecraft.util.ResourceLocation;

public class StringHelper {

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
