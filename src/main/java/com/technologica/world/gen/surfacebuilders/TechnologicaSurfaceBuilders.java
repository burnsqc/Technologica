package com.technologica.world.gen.surfacebuilders;

import static com.technologica.Technologica.MODID;

import net.minecraft.world.gen.surfacebuilders.SurfaceBuilder;
import net.minecraft.world.gen.surfacebuilders.SurfaceBuilderConfig;
import net.minecraftforge.fml.RegistryObject;
import net.minecraftforge.fml.javafmlmod.FMLJavaModLoadingContext;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.ForgeRegistries;

public class TechnologicaSurfaceBuilders {
	public static final DeferredRegister<SurfaceBuilder<?>> SURFACE_BUILDERS = DeferredRegister.create(ForgeRegistries.SURFACE_BUILDERS, MODID);
	
	public static final RegistryObject<SaltFlatsSurfaceBuilder> SALT_FLATS_SURFACE_BUILDER = SURFACE_BUILDERS.register("salt_flats", () -> new SaltFlatsSurfaceBuilder(SurfaceBuilderConfig.CODEC));
	public static final RegistryObject<ShatteredMoonSurfaceBuilder> DISRUPTED_CORRIDORS_SURFACE_BUILDER = SURFACE_BUILDERS.register("disrupted_corridors", () -> new ShatteredMoonSurfaceBuilder(SurfaceBuilderConfig.CODEC));
	
	public static void register() 
    {
        SURFACE_BUILDERS.register(FMLJavaModLoadingContext.get().getModEventBus());
    }
}
