package com.technologica.util;

import net.minecraft.util.StringRepresentable;

public enum MiddleEnd implements StringRepresentable {
	MIDDLE("middle"), LEFT("left"), RIGHT("right");

	private final String name;

	private MiddleEnd(String name) {
		this.name = name;
	}

	@Override
	public String getSerializedName() {
		return this.name;
	}
}
