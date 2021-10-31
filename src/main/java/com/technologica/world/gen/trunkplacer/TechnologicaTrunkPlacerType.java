package com.technologica.world.gen.trunkplacer;

import com.mojang.serialization.Codec;
import net.minecraft.util.ResourceLocation;
import net.minecraft.util.registry.Registry;
import net.minecraft.world.gen.feature.*;
import net.minecraft.world.gen.trunkplacer.AbstractTrunkPlacer;
import net.minecraft.world.gen.trunkplacer.StraightTrunkPlacer;
import net.minecraft.world.gen.trunkplacer.TrunkPlacerType;
import net.minecraftforge.event.RegistryEvent;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.fml.common.ObfuscationReflectionHelper;

import java.lang.reflect.Constructor;
import java.lang.reflect.InvocationTargetException;
import java.util.ArrayList;
import java.util.List;

import com.technologica.Technologica;

//@Mod.EventBusSubscriber(modid = Technologica.MODID, bus = Mod.EventBusSubscriber.Bus.MOD)
public final class TechnologicaTrunkPlacerType<P extends AbstractTrunkPlacer> {

	public final static TrunkPlacerType<AbstractTrunkPlacer> THREE_WIDE_TRUNK_PLACER = registerTrunk("wide_trunk_placer", ThreeWideTrunkPlacer.CODEC);
	
	public static <P extends AbstractTrunkPlacer> TrunkPlacerType<P> registerTrunk(String name, Codec<P> codec) {
		@SuppressWarnings("rawtypes")
		Constructor<TrunkPlacerType> constructor = ObfuscationReflectionHelper.findConstructor(TrunkPlacerType.class, Codec.class);
		try {
			return Registry.register(Registry.TRUNK_REPLACER, name, constructor.newInstance(codec));
		} catch (ReflectiveOperationException e) {
			throw new Exception("Failure to access TrunkPlacerType constructor");
			e.printStackTrace();
		}
	}
}