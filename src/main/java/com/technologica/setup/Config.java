package com.technologica.setup;

import net.minecraftforge.common.ForgeConfigSpec;
import net.minecraftforge.fml.common.Mod;

@Mod.EventBusSubscriber
public final class Config {
	public static final ForgeConfigSpec.Builder BUILDER = new ForgeConfigSpec.Builder();
	public static final ForgeConfigSpec SPEC;
	public static final ForgeConfigSpec.ConfigValue<Boolean> DISABLE_VANILLA_LOG_HARVESTING;
	public static final ForgeConfigSpec.ConfigValue<Boolean> DISABLE_VANILLA_PLANK_RECIPES;
	public static final ForgeConfigSpec.ConfigValue<Boolean> NAUGHTY_NAUTICAL_NANNERS;
	public static final ForgeConfigSpec.ConfigValue<Boolean> NITRO_JOSTLE;

	static {
		BUILDER.push("Technologica Common Config");

		DISABLE_VANILLA_LOG_HARVESTING = BUILDER.comment("true disables log drops when broken without appropriate tool, false retains vanilla mechanics.").define("Disable Vanilla Log Harvesting", true);
		DISABLE_VANILLA_PLANK_RECIPES = BUILDER.comment("true replaces all plank recipes with sawmill crafting, false retains vanilla mechanics.").define("Disable Vanilla Plank Recipes", true);
		NAUGHTY_NAUTICAL_NANNERS = BUILDER.comment("true yields no fish when fishing if the player has bananas in their inventory.").define("Naughty Nautical Nanners", true);
		NITRO_JOSTLE = BUILDER.comment("true yields no fish when fishing if the player has bananas in their inventory.").define("Naughty Nautical Nanners", true);

		BUILDER.pop();
		SPEC = BUILDER.build();
	}
}
