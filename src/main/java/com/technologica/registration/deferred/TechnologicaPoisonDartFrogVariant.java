package com.technologica.registration.deferred;

import com.technologica.Technologica;
import com.technologica.util.text.TechnologicaLocation;

import net.minecraft.world.entity.animal.FrogVariant;
import net.minecraftforge.registries.RegistryObject;

public final class TechnologicaPoisonDartFrogVariant {
	public static final RegistryObject<FrogVariant> RED = Technologica.POSION_DART_FROG_VARIANTS.register("red", () -> new FrogVariant(new TechnologicaLocation("textures/entity/poison_dart_frog/poison_dart_frog_red.png")));
	public static final RegistryObject<FrogVariant> ORANGE = Technologica.POSION_DART_FROG_VARIANTS.register("orange", () -> new FrogVariant(new TechnologicaLocation("textures/entity/poison_dart_frog/poison_dart_frog_orange.png")));
	public static final RegistryObject<FrogVariant> YELLOW = Technologica.POSION_DART_FROG_VARIANTS.register("yellow", () -> new FrogVariant(new TechnologicaLocation("textures/entity/poison_dart_frog/poison_dart_frog_yellow.png")));
	public static final RegistryObject<FrogVariant> GREEN = Technologica.POSION_DART_FROG_VARIANTS.register("green", () -> new FrogVariant(new TechnologicaLocation("textures/entity/poison_dart_frog/poison_dart_frog_green.png")));
	public static final RegistryObject<FrogVariant> BLUE = Technologica.POSION_DART_FROG_VARIANTS.register("blue", () -> new FrogVariant(new TechnologicaLocation("textures/entity/poison_dart_frog/poison_dart_frog_blue.png")));
}
