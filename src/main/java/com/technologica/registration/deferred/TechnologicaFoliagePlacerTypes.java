package com.technologica.registration.deferred;

import com.technologica.Technologica;
import com.technologica.world.level.levelgen.feature.foliageplacers.ConicalFoliagePlacer;
import com.technologica.world.level.levelgen.feature.foliageplacers.CylindricalFoliagePlacer;
import com.technologica.world.level.levelgen.feature.foliageplacers.DishFoliagePlacer;
import com.technologica.world.level.levelgen.feature.foliageplacers.PalmFoliagePlacer;
import com.technologica.world.level.levelgen.feature.foliageplacers.RedwoodFoliagePlacer;
import com.technologica.world.level.levelgen.feature.foliageplacers.TeardropFoliagePlacer;

import net.minecraft.world.level.levelgen.feature.foliageplacers.FoliagePlacerType;
import net.minecraftforge.registries.RegistryObject;

public final class TechnologicaFoliagePlacerTypes {
	public static final RegistryObject<FoliagePlacerType<?>> CONICAL = Technologica.FOLIAGE_PLACER_TYPES.register("conical_foliage_placer", () -> new FoliagePlacerType<>(ConicalFoliagePlacer.conicalCodec));
	public static final RegistryObject<FoliagePlacerType<?>> CYLINDRICAL = Technologica.FOLIAGE_PLACER_TYPES.register("cylindrical_foliage_placer", () -> new FoliagePlacerType<>(CylindricalFoliagePlacer.cylindricalCodec));
	public static final RegistryObject<FoliagePlacerType<?>> DISH = Technologica.FOLIAGE_PLACER_TYPES.register("dish_foliage_placer", () -> new FoliagePlacerType<>(DishFoliagePlacer.dishCodec));
	public static final RegistryObject<FoliagePlacerType<?>> PALM = Technologica.FOLIAGE_PLACER_TYPES.register("palm_foliage_placer", () -> new FoliagePlacerType<>(PalmFoliagePlacer.palmCodec));
	public static final RegistryObject<FoliagePlacerType<?>> TEARDROP = Technologica.FOLIAGE_PLACER_TYPES.register("teardrop_foliage_placer", () -> new FoliagePlacerType<>(TeardropFoliagePlacer.teardropCodec));
	public static final RegistryObject<FoliagePlacerType<?>> REDWOOD = Technologica.FOLIAGE_PLACER_TYPES.register("redwood_foliage_placer", () -> new FoliagePlacerType<>(RedwoodFoliagePlacer.redwoodCodec));
}
