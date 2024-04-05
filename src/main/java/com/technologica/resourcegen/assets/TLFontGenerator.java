package com.technologica.resourcegen.assets;

import com.technologica.api.tlregen.resourcegen.assets.TLReGenFont;
import com.technologica.util.text.TechnologicaLocation;

import net.minecraft.client.gui.font.providers.BitmapProvider;
import net.minecraft.resources.ResourceLocation;

public class TLFontGenerator extends TLReGenFont {
	protected static final ResourceLocation TLOS_FONT = new TechnologicaLocation("tlos");
	protected static final ResourceLocation TLOS_FONT_BITMAP = new TechnologicaLocation("tlos.png");

	@Override
	public void populate() {
		font(TLOS_FONT).addProvider(new BitmapProvider.Definition(TLOS_FONT_BITMAP, 1, 1, new int[2][2])).addProvider(new BitmapProvider.Definition(TLOS_FONT_BITMAP, 1, 1, new int[2][2]));
	}
}
