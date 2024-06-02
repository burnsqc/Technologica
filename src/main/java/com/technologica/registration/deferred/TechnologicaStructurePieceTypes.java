package com.technologica.registration.deferred;

import java.util.Locale;

import com.technologica.api.tlregen.registration.MasterDeferredRegistrar;
import com.technologica.world.level.levelgen.structure.structures.WhaleCarcassPieces;

import net.minecraft.core.Registry;
import net.minecraft.core.registries.BuiltInRegistries;
import net.minecraft.world.level.levelgen.structure.pieces.StructurePieceType;
import net.minecraftforge.registries.RegistryObject;

public final class TechnologicaStructurePieceTypes extends MasterDeferredRegistrar {

	public static int init() {
		return STRUCTURE_PIECE_TYPES.getEntries().size();
	}

	public static final RegistryObject<StructurePieceType> WHALE_CARCASS = STRUCTURE_PIECE_TYPES.register("whale_carcass", () -> setTemplatePieceId(WhaleCarcassPieces.WhaleCarcassPiece::new, "CDWC"));

	private static StructurePieceType setTemplatePieceId(StructurePieceType.StructureTemplateType p_210156_, String p_210157_) {
		return setFullContextPieceId(p_210156_, p_210157_);
	}

	private static StructurePieceType setFullContextPieceId(StructurePieceType p_210159_, String p_210160_) {
		return Registry.register(BuiltInRegistries.STRUCTURE_PIECE, p_210160_.toLowerCase(Locale.ROOT), p_210159_);
	}
}