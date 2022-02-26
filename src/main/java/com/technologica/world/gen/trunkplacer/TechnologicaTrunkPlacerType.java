package com.technologica.world.gen.trunkplacer;

import com.mojang.serialization.Codec;
import com.technologica.Technologica;

import net.minecraft.core.Registry;
import net.minecraft.world.level.levelgen.feature.trunkplacers.TrunkPlacer;
import net.minecraft.world.level.levelgen.feature.trunkplacers.TrunkPlacerType;
import net.minecraftforge.fml.common.Mod;

@Mod.EventBusSubscriber(modid = Technologica.MODID, bus = Mod.EventBusSubscriber.Bus.MOD)
@SuppressWarnings("rawtypes")
public final class TechnologicaTrunkPlacerType extends TrunkPlacerType {

	public static final TrunkPlacerType<ThreeWideTrunkPlacer> THREE_WIDE_TRUNK_PLACER = register("three_wide_trunk_placer", ThreeWideTrunkPlacer.CODEC);

	private static <P extends TrunkPlacer> TrunkPlacerType<P> register(String key, Codec<P> codec) {
		return Registry.register(Registry.TRUNK_PLACER_TYPES, key, new TrunkPlacerType<>(codec));
	}

	@SuppressWarnings("unchecked")
	public TechnologicaTrunkPlacerType(Codec codec) {
		super(codec);
	}
}