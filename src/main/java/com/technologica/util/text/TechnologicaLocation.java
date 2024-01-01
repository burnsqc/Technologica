package com.technologica.util.text;

import com.technologica.Technologica;

import net.minecraft.resources.ResourceLocation;

/**
 * Simple extension of ResourceLocation to keep Technologica Resource Locations concise and obvious. 
 */
public class TechnologicaLocation extends ResourceLocation {
	public TechnologicaLocation(String path) {
		super(Technologica.MOD_ID, path);
	}
}