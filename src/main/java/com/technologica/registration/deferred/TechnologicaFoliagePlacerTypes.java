package com.technologica.registration.deferred;

import com.technologica.Technologica;
import com.technologica.registration.deferred.util.MasterDeferredRegistrar;
import com.technologica.world.level.levelgen.feature.foliageplacers.ConicalFoliagePlacer;
import com.technologica.world.level.levelgen.feature.foliageplacers.CylindricalFoliagePlacer;
import com.technologica.world.level.levelgen.feature.foliageplacers.DishFoliagePlacer;
import com.technologica.world.level.levelgen.feature.foliageplacers.PalmFoliagePlacer;
import com.technologica.world.level.levelgen.feature.foliageplacers.RedwoodFoliagePlacer;
import com.technologica.world.level.levelgen.feature.foliageplacers.TeardropFoliagePlacer;

import net.minecraft.world.level.levelgen.feature.foliageplacers.FoliagePlacerType;
import net.minecraftforge.registries.RegistryObject;

/**
 * <p>
 * This class contains Registry Objects for Foliage Placer Types.
 * The {@link #init} method is called by {@link Technologica#initDeferredRegisters} and returns a head-count to later be checked during registration and other setup activities.
 * </p>
 * 
 * @tl.status GREEN
 */
public final class TechnologicaFoliagePlacerTypes extends MasterDeferredRegistrar {

	public static int init() {
		return FOLIAGE_PLACER_TYPES.getEntries().size();
	}

	public static final RegistryObject<FoliagePlacerType<?>> CONICAL = FOLIAGE_PLACER_TYPES.register("conical_foliage_placer", () -> new FoliagePlacerType<>(ConicalFoliagePlacer.conicalCodec));
	public static final RegistryObject<FoliagePlacerType<?>> CYLINDRICAL = FOLIAGE_PLACER_TYPES.register("cylindrical_foliage_placer", () -> new FoliagePlacerType<>(CylindricalFoliagePlacer.cylindricalCodec));
	public static final RegistryObject<FoliagePlacerType<?>> DISH = FOLIAGE_PLACER_TYPES.register("dish_foliage_placer", () -> new FoliagePlacerType<>(DishFoliagePlacer.dishCodec));
	public static final RegistryObject<FoliagePlacerType<?>> PALM = FOLIAGE_PLACER_TYPES.register("palm_foliage_placer", () -> new FoliagePlacerType<>(PalmFoliagePlacer.palmCodec));
	public static final RegistryObject<FoliagePlacerType<?>> TEARDROP = FOLIAGE_PLACER_TYPES.register("teardrop_foliage_placer", () -> new FoliagePlacerType<>(TeardropFoliagePlacer.teardropCodec));
	public static final RegistryObject<FoliagePlacerType<?>> REDWOOD = FOLIAGE_PLACER_TYPES.register("redwood_foliage_placer", () -> new FoliagePlacerType<>(RedwoodFoliagePlacer.redwoodCodec));
}