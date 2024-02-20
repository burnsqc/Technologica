package com.technologica.registration.deferred;

import com.technologica.registration.deferred.util.MasterDeferredRegistrar;
import com.technologica.util.text.TechnologicaLocation;

import net.minecraft.world.entity.animal.FrogVariant;
import net.minecraftforge.registries.RegistryObject;

public final class TechnologicaPoisonDartFrogVariant extends MasterDeferredRegistrar {

	public static int init() {
		return POSION_DART_FROG_VARIANTS.getEntries().size();
	}

	public static final RegistryObject<FrogVariant> VARIANT1 = POSION_DART_FROG_VARIANTS.register("variant1", () -> new FrogVariant(new TechnologicaLocation("textures/entity/poison_dart_frog/poison_dart_frog1.png")));
	public static final RegistryObject<FrogVariant> VARIANT2 = POSION_DART_FROG_VARIANTS.register("variant2", () -> new FrogVariant(new TechnologicaLocation("textures/entity/poison_dart_frog/poison_dart_frog2.png")));
	public static final RegistryObject<FrogVariant> VARIANT3 = POSION_DART_FROG_VARIANTS.register("variant3", () -> new FrogVariant(new TechnologicaLocation("textures/entity/poison_dart_frog/poison_dart_frog3.png")));
	public static final RegistryObject<FrogVariant> VARIANT4 = POSION_DART_FROG_VARIANTS.register("variant4", () -> new FrogVariant(new TechnologicaLocation("textures/entity/poison_dart_frog/poison_dart_frog4.png")));
	public static final RegistryObject<FrogVariant> VARIANT5 = POSION_DART_FROG_VARIANTS.register("variant5", () -> new FrogVariant(new TechnologicaLocation("textures/entity/poison_dart_frog/poison_dart_frog5.png")));
}
