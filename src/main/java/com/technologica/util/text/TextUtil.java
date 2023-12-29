package com.technologica.util.text;

public class TextUtil {
	public static String stringToCapsName(String string) {
		String words[] = string.split("_");
		String name = "";
		for (String word : words) {
			String first = word.substring(0, 1);
			String afterFirst = word.substring(1);
			name += first.toUpperCase() + afterFirst + " ";
		}
		return name.trim();
	}

	public static String stringToProperName(String string) {
		String words[] = string.split("_");
		String name = "The ";
		for (String word : words) {
			String first = word.substring(0, 1);
			String afterFirst = word.substring(1);
			name += first.toUpperCase() + afterFirst + " ";
		}
		return name.trim();
	}
}