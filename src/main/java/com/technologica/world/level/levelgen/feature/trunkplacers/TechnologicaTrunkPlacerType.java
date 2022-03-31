package com.technologica.world.level.levelgen.feature.trunkplacers;

import com.mojang.serialization.Codec;
import com.technologica.Technologica;

import net.minecraft.core.Registry;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.level.levelgen.feature.trunkplacers.TrunkPlacer;
import net.minecraft.world.level.levelgen.feature.trunkplacers.TrunkPlacerType;

public final class TechnologicaTrunkPlacerType {

	public static TrunkPlacerType<ThreeWideTrunkPlacer> THREE_WIDE_TRUNK_PLACER;
	
	public static void register() {
		THREE_WIDE_TRUNK_PLACER = register("three_wide_trunk_placer", ThreeWideTrunkPlacer.CODEC);
    }

	private static <P extends TrunkPlacer> TrunkPlacerType<P> register(String stringIn, Codec<P> codec) {
		return Registry.register(Registry.TRUNK_PLACER_TYPES, new ResourceLocation(Technologica.MODID, stringIn), new TrunkPlacerType<>(codec));
	}
}