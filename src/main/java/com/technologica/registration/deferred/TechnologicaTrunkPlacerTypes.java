package com.technologica.registration.deferred;

import com.technologica.Technologica;
import com.technologica.api.tlregen.registration.MasterDeferredRegistrar;
import com.technologica.world.level.levelgen.feature.trunkplacers.HugeTrunkPlacer;

import net.minecraft.world.level.levelgen.feature.trunkplacers.TrunkPlacerType;
import net.minecraftforge.registries.RegistryObject;

/**
 * <p>
 * This class contains Registry Objects for Trunk Placer Types.
 * The {@link #init} method is called by {@link Technologica#initDeferredRegisters} and returns a head-count to later be checked during registration and other setup activities.
 * </p>
 * 
 * @tl.status GREEN
 */
public final class TechnologicaTrunkPlacerTypes extends MasterDeferredRegistrar {
	private TechnologicaTrunkPlacerTypes() {}
	public static final RegistryObject<TrunkPlacerType<?>> HUGE_TRUNK_PLACER = TRUNK_PLACER_TYPES.register("huge", () -> new TrunkPlacerType<>(HugeTrunkPlacer.CODEC));;
}
