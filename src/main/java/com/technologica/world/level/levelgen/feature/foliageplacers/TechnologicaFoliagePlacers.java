package com.technologica.world.level.levelgen.feature.foliageplacers;

import static com.technologica.Technologica.LOGGER;
import static com.technologica.Technologica.MODID;

import net.minecraft.world.level.levelgen.feature.foliageplacers.FoliagePlacerType;
import net.minecraftforge.fml.javafmlmod.FMLJavaModLoadingContext;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.ForgeRegistries;
import net.minecraftforge.registries.RegistryObject;

public class TechnologicaFoliagePlacers {
	private static final DeferredRegister<FoliagePlacerType<?>> FOLIAGES = DeferredRegister.create(ForgeRegistries.FOLIAGE_PLACER_TYPES, MODID);
	
	public static void init() {
		LOGGER.info("INITIALIZING FOLIAGE PLACERS");
        FOLIAGES.register(FMLJavaModLoadingContext.get().getModEventBus());
        LOGGER.info(FOLIAGES.getEntries().size() + " FOLIAGE PLACERS INITIALIZED");
    }

	public static final RegistryObject<FoliagePlacerType<?>> CONICAL = FOLIAGES.register("conical_foliage_placer", () -> new FoliagePlacerType<>(ConicalFoliagePlacer.conicalCodec));
    public static final RegistryObject<FoliagePlacerType<?>> CYLINDRICAL = FOLIAGES.register("cylindrical_foliage_placer", () -> new FoliagePlacerType<>(CylindricalFoliagePlacer.cylindricalCodec));
    public static final RegistryObject<FoliagePlacerType<?>> DISH = FOLIAGES.register("dish_foliage_placer", () -> new FoliagePlacerType<>(DishFoliagePlacer.dishCodec));
    public static final RegistryObject<FoliagePlacerType<?>> PALM = FOLIAGES.register("palm_foliage_placer", () -> new FoliagePlacerType<>(PalmFoliagePlacer.palmCodec));
    public static final RegistryObject<FoliagePlacerType<?>> TEARDROP = FOLIAGES.register("teardrop_foliage_placer", () -> new FoliagePlacerType<>(TeardropFoliagePlacer.teardropCodec));    
    public static final RegistryObject<FoliagePlacerType<?>> REDWOOD = FOLIAGES.register("redwood_foliage_placer", () -> new FoliagePlacerType<>(RedwoodFoliagePlacer.redwoodCodec));    	
}