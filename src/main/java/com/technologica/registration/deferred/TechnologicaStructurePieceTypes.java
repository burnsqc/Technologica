package com.technologica.registration.deferred;

import java.util.Locale;

import com.technologica.Technologica;
import com.technologica.world.level.levelgen.structure.structures.WhaleCarcassPieces;

import net.minecraft.core.Registry;
import net.minecraft.core.registries.BuiltInRegistries;
import net.minecraft.world.level.levelgen.structure.pieces.StructurePieceType;
import net.minecraftforge.registries.RegistryObject;

public final class TechnologicaStructurePieceTypes {
	public static final RegistryObject<StructurePieceType> WHALE_CARCASS = Technologica.STRUCTURE_PIECE_TYPES.register("whale_carcass", () -> setTemplatePieceId(WhaleCarcassPieces.WhaleCarcassPiece::new, "CDWC"));

	private static StructurePieceType setTemplatePieceId(StructurePieceType.StructureTemplateType structureTemplateType, String p_210157_) {
		return setFullContextPieceId(structureTemplateType, p_210157_);
	}

	private static StructurePieceType setFullContextPieceId(StructurePieceType structurePieceType, String p_210160_) {
		return Registry.register(BuiltInRegistries.STRUCTURE_PIECE, p_210160_.toLowerCase(Locale.ROOT), structurePieceType);
	}
}
