package com.technologica.util;

import net.minecraft.util.StringRepresentable;

public enum AnnunciatorOverlay implements StringRepresentable {
	INFO("info"), FAIL("fail"), PASS("pass"), WARN("warn");

	private final String name;

	private AnnunciatorOverlay(String name) {
		this.name = name;
	}

	public String getSerializedName() {
		return this.name;
	}
}
