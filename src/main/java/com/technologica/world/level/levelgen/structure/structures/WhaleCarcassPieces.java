package com.technologica.world.level.levelgen.structure.structures;

import com.technologica.registration.deferred.TechnologicaStructurePieceTypes;
import com.technologica.util.text.TechnologicaLocation;

import net.minecraft.Util;
import net.minecraft.core.BlockPos;
import net.minecraft.nbt.CompoundTag;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.util.RandomSource;
import net.minecraft.world.level.ChunkPos;
import net.minecraft.world.level.ServerLevelAccessor;
import net.minecraft.world.level.StructureManager;
import net.minecraft.world.level.WorldGenLevel;
import net.minecraft.world.level.block.Mirror;
import net.minecraft.world.level.block.Rotation;
import net.minecraft.world.level.chunk.ChunkGenerator;
import net.minecraft.world.level.levelgen.structure.BoundingBox;
import net.minecraft.world.level.levelgen.structure.StructurePieceAccessor;
import net.minecraft.world.level.levelgen.structure.TemplateStructurePiece;
import net.minecraft.world.level.levelgen.structure.pieces.StructurePieceSerializationContext;
import net.minecraft.world.level.levelgen.structure.templatesystem.BlockIgnoreProcessor;
import net.minecraft.world.level.levelgen.structure.templatesystem.StructurePlaceSettings;
import net.minecraft.world.level.levelgen.structure.templatesystem.StructureTemplateManager;

public class WhaleCarcassPieces {
	private static final ResourceLocation[] FOSSILS = new ResourceLocation[] { new TechnologicaLocation("whale_carcass"), new ResourceLocation("nether_fossils/fossil_1"), new ResourceLocation("nether_fossils/fossil_2"), new ResourceLocation("nether_fossils/fossil_3"), new ResourceLocation("nether_fossils/fossil_4"), new ResourceLocation("nether_fossils/fossil_5"), new ResourceLocation("nether_fossils/fossil_6"), new ResourceLocation("nether_fossils/fossil_7"), new ResourceLocation("nether_fossils/fossil_8"), new ResourceLocation("nether_fossils/fossil_9"), new ResourceLocation("nether_fossils/fossil_10"), new ResourceLocation("nether_fossils/fossil_11"), new ResourceLocation("nether_fossils/fossil_12"), new ResourceLocation("nether_fossils/fossil_13"), new ResourceLocation("nether_fossils/fossil_14") };

	public static void addPieces(StructureTemplateManager structureTemplateManager, BlockPos blockPos, Rotation rotation, StructurePieceAccessor structurePieceAccessor, RandomSource random) {
		structurePieceAccessor.addPiece(new WhaleCarcassPieces.WhaleCarcassPiece(structureTemplateManager, Util.getRandom(FOSSILS, random), blockPos, rotation));
	}

	public static class WhaleCarcassPiece extends TemplateStructurePiece {
		public WhaleCarcassPiece(StructureTemplateManager structureTemplateManager, ResourceLocation p_228541_, BlockPos blockPos, Rotation rotation) {
			super(TechnologicaStructurePieceTypes.WHALE_CARCASS.get(), 0, structureTemplateManager, p_228541_, p_228541_.toString(), makeSettings(rotation), blockPos);
		}

		public WhaleCarcassPiece(StructureTemplateManager structureTemplateManager, CompoundTag compoundTag) {
			super(TechnologicaStructurePieceTypes.WHALE_CARCASS.get(), compoundTag, structureTemplateManager, (resourceLocation) -> {
				return makeSettings(Rotation.valueOf(compoundTag.getString("Rot")));
			});
		}

		private static StructurePlaceSettings makeSettings(Rotation rotation) {
			return new StructurePlaceSettings().setRotation(rotation).setMirror(Mirror.NONE).addProcessor(BlockIgnoreProcessor.STRUCTURE_AND_AIR);
		}

		@Override
		protected void addAdditionalSaveData(StructurePieceSerializationContext structurePieceSerializationContext, CompoundTag compoundTag) {
			super.addAdditionalSaveData(structurePieceSerializationContext, compoundTag);
			compoundTag.putString("Rot", this.placeSettings.getRotation().name());
		}

		@Override
		protected void handleDataMarker(String p_228561_, BlockPos p_228562_, ServerLevelAccessor p_228563_, RandomSource p_228564_, BoundingBox p_228565_) {
		}

		@Override
		public void postProcess(WorldGenLevel p_228548_, StructureManager p_228549_, ChunkGenerator p_228550_, RandomSource p_228551_, BoundingBox p_228552_, ChunkPos p_228553_, BlockPos p_228554_) {
			super.postProcess(p_228548_, p_228549_, p_228550_, p_228551_, p_228552_, p_228553_, p_228554_);
		}
	}
}