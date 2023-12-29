package com.technologica.setup.config;

import java.util.Arrays;

import net.minecraftforge.common.ForgeConfigSpec;
import net.minecraftforge.fml.common.Mod;

@Mod.EventBusSubscriber
public final class TechnologicaConfigClient {
	public static final ForgeConfigSpec.Builder BUILDER = new ForgeConfigSpec.Builder();
	public static final ForgeConfigSpec CLIENT_SPEC;

	public static final ForgeConfigSpec.ConfigValue<String> BIOME_TITLE_CARDS;

	static {
		BUILDER.comment("TECHNOLOGICA CLIENT CONFIG\n");

		BUILDER.comment("In single-player, these settings will affect only you.");
		BUILDER.comment("In multi-player, these settings will still affect only you.");
		BUILDER.comment("These settings have been set to defaults selected by the Technologica development team.\n");

		BUILDER.push("ENVIRONMENT TITLE CARDS");
		BIOME_TITLE_CARDS = BUILDER.comment("first - Display a title card for a biome on first discovery.\nalways - Display a title card for a biome on every entrance.\nnever - Never display biome title cards.").defineInList("Biome Title Cards", "first", Arrays.asList("first", "always", "never"));
		BUILDER.pop();

		CLIENT_SPEC = BUILDER.build();
	}
}