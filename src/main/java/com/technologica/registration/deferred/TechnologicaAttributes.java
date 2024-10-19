package com.technologica.registration.deferred;

import com.technologica.Technologica;

import net.minecraft.world.entity.ai.attributes.Attribute;
import net.minecraft.world.entity.ai.attributes.RangedAttribute;
import net.minecraftforge.registries.RegistryObject;

public final class TechnologicaAttributes {
	public static final RegistryObject<Attribute> DIVER = Technologica.ATTRIBUTES.register("diver", () -> new RangedAttribute("diver", 0, 0, 1).setSyncable(true));
}
