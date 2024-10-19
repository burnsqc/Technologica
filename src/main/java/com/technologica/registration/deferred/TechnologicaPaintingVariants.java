package com.technologica.registration.deferred;

import com.technologica.Technologica;

import net.minecraft.world.entity.decoration.PaintingVariant;
import net.minecraftforge.registries.RegistryObject;

public final class TechnologicaPaintingVariants {
	public static final RegistryObject<PaintingVariant> AMNESIA = Technologica.PAINTING_VARIANTS.register("amnesia", () -> new PaintingVariant(32, 32));
}
