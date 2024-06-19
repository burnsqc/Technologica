package com.technologica.setup.common;

import net.minecraftforge.common.ForgeConfigSpec;

public final class TechnologicaConfigCommon {
	public static final ForgeConfigSpec.Builder BUILDER = new ForgeConfigSpec.Builder();
	public static final ForgeConfigSpec COMMON_SPEC;

	public static final ForgeConfigSpec.ConfigValue<Boolean> DISABLE_VANILLA_LOG_HARVESTING;
	public static final ForgeConfigSpec.ConfigValue<Boolean> DISABLE_VANILLA_PLANK_RECIPES;
	public static final ForgeConfigSpec.ConfigValue<Boolean> NAUGHTY_NAUTICAL_NANNERS;
	public static final ForgeConfigSpec.ConfigValue<Boolean> NITRO_JOSTLE;

	static {
		BUILDER.comment("TECHNOLOGICA COMMON CONFIG\n");

		BUILDER.comment("In single-player, these settings will affect only you.");
		BUILDER.comment("In multi-player, these settings will affect all player on the server.  Please consider your players when making changes.");
		BUILDER.comment("These settings have been set to defaults selected by the Technologica development team.\n");

		BUILDER.push("WOOD HARVESTING AND CRAFTING");
		DISABLE_VANILLA_LOG_HARVESTING = BUILDER.comment("true - Disable log drops when harvested without appropriate tool.\nfalse - Retain vanilla mechanics when harvesting logs.").define("Disable Vanilla Log Harvesting", true);
		DISABLE_VANILLA_PLANK_RECIPES = BUILDER.comment("true - Replace all plank recipes to require a saw.\nfalse - Retain vanilla mechanics when crafting planks.").define("Disable Vanilla Plank Recipes", true);
		BUILDER.pop();

		BUILDER.push("EASTER EGGS");
		NAUGHTY_NAUTICAL_NANNERS = BUILDER.comment("true - Give no fishing loot if the player has bananas in their inventory.\nfalse - Retain vanilla fishing loot.").define("Naughty Nautical Nanners", true);
		NITRO_JOSTLE = BUILDER.comment("true - Explode when taking damage or jumping if the player has nitroglycerin in their inventory.\nfalse - Do not explode when taking damage or jumping if the player has nitroglycerin in their inventory.").define("Nitro Jostle", true);
		BUILDER.pop();

		COMMON_SPEC = BUILDER.build();
	}
}
