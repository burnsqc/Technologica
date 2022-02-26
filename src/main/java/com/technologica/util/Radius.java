package com.technologica.util;

import net.minecraft.util.StringRepresentable;

public enum Radius implements StringRepresentable {
	NONE("none", 0.00F), SMALL("small", 0.25F), MEDIUM("medium", 0.50F), LARGE("large", 1.00F);

	private final String name;
	private final Float radius;

	private Radius(String name, Float radius) {
		this.name = name;
		this.radius = radius;
	}

	public String getSerializedName() {
		return this.name;
	}

	public Float getRadius() {
		return this.radius;
	}
}
