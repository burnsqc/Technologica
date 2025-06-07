package com.technologica.resourcegen.assets;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import com.technologica.util.text.TechnologicaLocation;

import net.minecraft.client.gui.font.providers.BitmapProvider;
import net.minecraft.client.gui.font.providers.GlyphProviderDefinition;
import net.minecraft.resources.ResourceLocation;

public class TLFont {
	public static final Map<ResourceLocation, List<GlyphProviderDefinition>> FONTS = new HashMap<>();
	private static final ResourceLocation TLOS_FONT = new TechnologicaLocation("tlos");
	private static final ResourceLocation TLOS_FONT_BITMAP = new TechnologicaLocation("tlos.png");

	static {
		FONTS.put(TLOS_FONT, List.of(new BitmapProvider.Definition(TLOS_FONT_BITMAP, 1, 1, new int[2][2]), new BitmapProvider.Definition(TLOS_FONT_BITMAP, 1, 1, new int[2][2])));
	}
}
