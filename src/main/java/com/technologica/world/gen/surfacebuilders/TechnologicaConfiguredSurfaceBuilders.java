package com.technologica.world.gen.surfacebuilders;

import net.minecraft.util.registry.WorldGenRegistries;
import net.minecraft.world.gen.surfacebuilders.ConfiguredSurfaceBuilder;
import net.minecraft.world.gen.surfacebuilders.ISurfaceBuilderConfig;
import net.minecraft.world.gen.surfacebuilders.SurfaceBuilder;
import net.minecraft.world.gen.surfacebuilders.SurfaceBuilderConfig;

public class TechnologicaConfiguredSurfaceBuilders {
	public static final ConfiguredSurfaceBuilder<SurfaceBuilderConfig> SALT_FLATS = register("salt_flats", SurfaceBuilder.BADLANDS.configured(SurfaceBuilder.CONFIG_BADLANDS));
	public static final ConfiguredSurfaceBuilder<SurfaceBuilderConfig> DISRUPTED_CORRIDORS = register("disrupted_corridors", SurfaceBuilder.BADLANDS.configured(SurfaceBuilder.CONFIG_BADLANDS));
	
	private static <SC extends ISurfaceBuilderConfig> ConfiguredSurfaceBuilder<SC> register(String name, ConfiguredSurfaceBuilder<SC> configuredSurfaceBuilder) {
		return WorldGenRegistries.register(WorldGenRegistries.CONFIGURED_SURFACE_BUILDER, name, configuredSurfaceBuilder);
	}
}