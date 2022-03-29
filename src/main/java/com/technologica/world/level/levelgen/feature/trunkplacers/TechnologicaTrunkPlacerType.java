package com.technologica.world.level.levelgen.feature.trunkplacers;

import com.mojang.serialization.Codec;

import net.minecraft.core.Registry;
import net.minecraft.world.level.levelgen.feature.trunkplacers.TrunkPlacer;
import net.minecraft.world.level.levelgen.feature.trunkplacers.TrunkPlacerType;

@SuppressWarnings("rawtypes")
public final class TechnologicaTrunkPlacerType extends TrunkPlacerType {
		
	public static void init() {
		Registry.register(Registry.TRUNK_PLACER_TYPES, "three_wide_trunk_placer", new TrunkPlacerType<>(ThreeWideTrunkPlacer.CODEC));
    }
	
	public static TrunkPlacerType<ThreeWideTrunkPlacer> THREE_WIDE_TRUNK_PLACER;// = register("three_wide_trunk_placer", ThreeWideTrunkPlacer.CODEC);

	private static <P extends TrunkPlacer> TrunkPlacerType<P> register(String key, Codec<P> codec) {
		return Registry.register(Registry.TRUNK_PLACER_TYPES, key, new TrunkPlacerType<>(codec));
	}

	@SuppressWarnings("unchecked")
	public TechnologicaTrunkPlacerType(Codec codec) {
		super(codec);
	}
}