package com.technologica.util;

import net.minecraft.util.IStringSerializable;

public enum AnnunciatorOverlay implements IStringSerializable {
	INFO("info"), FAIL("fail"), PASS("pass"), WARN("warn");

	private final String name;

	private AnnunciatorOverlay(String name) {
		this.name = name;
	}

	public String getSerializedName() {
		return this.name;
	}
}
