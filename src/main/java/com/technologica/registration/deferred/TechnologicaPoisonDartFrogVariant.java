package com.technologica.registration.deferred;

import com.technologica.registration.deferred.util.MasterDeferredRegistrar;
import com.technologica.util.text.TechnologicaLocation;

import net.minecraft.world.entity.animal.FrogVariant;
import net.minecraftforge.registries.RegistryObject;

public final class TechnologicaPoisonDartFrogVariant extends MasterDeferredRegistrar {

	public static int init() {
		return POSION_DART_FROG_VARIANTS.getEntries().size();
	}

	public static final RegistryObject<FrogVariant> RED = POSION_DART_FROG_VARIANTS.register("red", () -> new FrogVariant(new TechnologicaLocation("textures/entity/poison_dart_frog/poison_dart_frog_red.png")));
	public static final RegistryObject<FrogVariant> ORANGE = POSION_DART_FROG_VARIANTS.register("orange", () -> new FrogVariant(new TechnologicaLocation("textures/entity/poison_dart_frog/poison_dart_frog_orange.png")));
	public static final RegistryObject<FrogVariant> YELLOW = POSION_DART_FROG_VARIANTS.register("yellow", () -> new FrogVariant(new TechnologicaLocation("textures/entity/poison_dart_frog/poison_dart_frog_yellow.png")));
	public static final RegistryObject<FrogVariant> GREEN = POSION_DART_FROG_VARIANTS.register("green", () -> new FrogVariant(new TechnologicaLocation("textures/entity/poison_dart_frog/poison_dart_frog_green.png")));
	public static final RegistryObject<FrogVariant> BLUE = POSION_DART_FROG_VARIANTS.register("blue", () -> new FrogVariant(new TechnologicaLocation("textures/entity/poison_dart_frog/poison_dart_frog_blue.png")));
}
