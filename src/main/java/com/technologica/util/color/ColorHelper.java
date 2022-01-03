package com.technologica.util.color;

public class ColorHelper {

	public static int argbToInt(int a, int r, int g, int b) {
		return (int) ((a << 24) + (r << 16) + (g << 8) + (b));
	}
	
	public static float intToRed(int color) {
		return ((color >> 16) & 0xFF) / 255f;
	}
	
	public static float intToGreen(int color) {
		return ((color >> 8) & 0xFF) / 255f;
	}
	
	public static float intToBlue(int color) {
		return ((color >> 0) & 0xFF) / 255f;
	}
}