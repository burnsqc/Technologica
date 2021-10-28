package com.technologica.util.color;

public class ColorHelper {

	public static int argbToInt(int a, int r, int g, int b) {
		/**
	     * Color used by universal bucket and the ModelFluid baked model.
	     * Note that this int includes the alpha so converting this to RGB with alpha would be
	     *   float r = ((color >> 16) & 0xFF) / 255f; // red
	     *   float g = ((color >> 8) & 0xFF) / 255f; // green
	     *   float b = ((color >> 0) & 0xFF) / 255f; // blue
	     *   float a = ((color >> 24) & 0xFF) / 255f; // alpha
	     */
		
		return (int) ((a << 24) + (r << 16) + (g << 8) + (b));
	}
	
}
