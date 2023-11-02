package com.technologica.world.level.levelgen.feature.foliageplacers;

import static com.technologica.Technologica.MODID;

import net.minecraft.world.level.levelgen.feature.foliageplacers.FoliagePlacerType;
import net.minecraftforge.fml.javafmlmod.FMLJavaModLoadingContext;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.ForgeRegistries;
import net.minecraftforge.registries.RegistryObject;

public class TechnologicaFoliagePlacers {
	private static final DeferredRegister<FoliagePlacerType<?>> FOLIAGE_PLACER_TYPES = DeferredRegister.create(ForgeRegistries.Keys.FOLIAGE_PLACER_TYPES, MODID);

	public static int init() {
		FOLIAGE_PLACER_TYPES.register(FMLJavaModLoadingContext.get().getModEventBus());
		return FOLIAGE_PLACER_TYPES.getEntries().size();
	}

	public static final RegistryObject<FoliagePlacerType<?>> CONICAL = FOLIAGE_PLACER_TYPES.register("conical_foliage_placer", () -> new FoliagePlacerType<>(ConicalFoliagePlacer.conicalCodec));
	public static final RegistryObject<FoliagePlacerType<?>> CYLINDRICAL = FOLIAGE_PLACER_TYPES.register("cylindrical_foliage_placer", () -> new FoliagePlacerType<>(CylindricalFoliagePlacer.cylindricalCodec));
	public static final RegistryObject<FoliagePlacerType<?>> DISH = FOLIAGE_PLACER_TYPES.register("dish_foliage_placer", () -> new FoliagePlacerType<>(DishFoliagePlacer.dishCodec));
	public static final RegistryObject<FoliagePlacerType<?>> PALM = FOLIAGE_PLACER_TYPES.register("palm_foliage_placer", () -> new FoliagePlacerType<>(PalmFoliagePlacer.palmCodec));
	public static final RegistryObject<FoliagePlacerType<?>> TEARDROP = FOLIAGE_PLACER_TYPES.register("teardrop_foliage_placer", () -> new FoliagePlacerType<>(TeardropFoliagePlacer.teardropCodec));
	public static final RegistryObject<FoliagePlacerType<?>> REDWOOD = FOLIAGE_PLACER_TYPES.register("redwood_foliage_placer", () -> new FoliagePlacerType<>(RedwoodFoliagePlacer.redwoodCodec));
}