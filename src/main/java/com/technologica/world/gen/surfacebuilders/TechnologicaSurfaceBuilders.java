package com.technologica.world.gen.surfacebuilders;

import static com.technologica.Technologica.LOGGER;
import static com.technologica.Technologica.MODID;

import net.minecraft.world.gen.surfacebuilders.SurfaceBuilder;
import net.minecraft.world.gen.surfacebuilders.SurfaceBuilderConfig;
import net.minecraftforge.fml.RegistryObject;
import net.minecraftforge.fml.javafmlmod.FMLJavaModLoadingContext;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.ForgeRegistries;

public class TechnologicaSurfaceBuilders {
	public static final DeferredRegister<SurfaceBuilder<?>> SURFACE_BUILDERS = DeferredRegister.create(ForgeRegistries.SURFACE_BUILDERS, MODID);
	
	public static void init() {
		LOGGER.info("INITIALIZING SURFACE BUILDERS");
        SURFACE_BUILDERS.register(FMLJavaModLoadingContext.get().getModEventBus());
        LOGGER.info(SURFACE_BUILDERS.getEntries().size() + " SURFACE BUILDERS INITIALIZED");
    }
	
	public static final RegistryObject<SaltFlatsSurfaceBuilder> SALT_FLATS_SURFACE_BUILDER = SURFACE_BUILDERS.register("salt_flats", () -> new SaltFlatsSurfaceBuilder(SurfaceBuilderConfig.CODEC));
	public static final RegistryObject<SilentFlatsSurfaceBuilder> SILENT_FLATS_SURFACE_BUILDER = SURFACE_BUILDERS.register("silent_flats", () -> new SilentFlatsSurfaceBuilder(SurfaceBuilderConfig.CODEC));
	public static final RegistryObject<DisruptedCorridorsSurfaceBuilder> DISRUPTED_CORRIDORS_SURFACE_BUILDER = SURFACE_BUILDERS.register("disrupted_corridors", () -> new DisruptedCorridorsSurfaceBuilder(SurfaceBuilderConfig.CODEC));
}
