package com.technologica.world.level.levelgen.structure;

import com.mojang.serialization.Codec;
import com.technologica.Technologica;
import com.technologica.world.level.levelgen.structure.structures.ElDoradoStructure;

import net.minecraft.core.registries.Registries;
import net.minecraft.world.level.levelgen.structure.Structure;
import net.minecraft.world.level.levelgen.structure.StructureType;
import net.minecraftforge.fml.javafmlmod.FMLJavaModLoadingContext;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.RegistryObject;

public class TechnologicaStructureType {
	public static final DeferredRegister<StructureType<?>> STRUCTURE_TYPES = DeferredRegister.create(Registries.STRUCTURE_TYPE, Technologica.MODID);

	public static int init() {
		STRUCTURE_TYPES.register(FMLJavaModLoadingContext.get().getModEventBus());
		return STRUCTURE_TYPES.getEntries().size();
	}

	public static final RegistryObject<StructureType<ElDoradoStructure>> EL_DORADO = STRUCTURE_TYPES.register("el_dorado", () -> explicitStructureTypeTyping(ElDoradoStructure.CODEC));

	private static <T extends Structure> StructureType<T> explicitStructureTypeTyping(Codec<T> structureCodec) {
		return () -> structureCodec;
	}
}
