package com.technologica.registration.deferred;

import com.technologica.Technologica;
import com.technologica.world.level.levelgen.feature.trunkplacers.HugeTrunkPlacer;

import net.minecraft.world.level.levelgen.feature.trunkplacers.TrunkPlacerType;
import net.minecraftforge.registries.RegistryObject;

public final class TechnologicaTrunkPlacerTypes {
	public static final RegistryObject<TrunkPlacerType<?>> HUGE_TRUNK_PLACER = Technologica.TRUNK_PLACER_TYPES.register("huge", () -> new TrunkPlacerType<>(HugeTrunkPlacer.CODEC));;
}
