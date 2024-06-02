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
	private static final ResourceLocation[] FOSSILS = new ResourceLocation[] { new TechnologicaLocation("whale_carcass") };

	public static void addPieces(StructureTemplateManager structureTemplateManager, StructurePieceAccessor structurePieceAccessor, RandomSource random, BlockPos blockPos) {
		Rotation rotation = Rotation.getRandom(random);
		structurePieceAccessor.addPiece(new WhaleCarcassPieces.WhaleCarcassPiece(structureTemplateManager, Util.getRandom(FOSSILS, random), blockPos, rotation));
	}

	public static class WhaleCarcassPiece extends TemplateStructurePiece {
		public WhaleCarcassPiece(StructureTemplateManager structureTemplateManager, ResourceLocation p_228541_, BlockPos blockPos, Rotation rotation) {
			super(TechnologicaStructurePieceTypes.WHALE_CARCASS.get(), 0, structureTemplateManager, p_228541_, p_228541_.toString(), makeSettings(rotation), blockPos);
		}

		public WhaleCarcassPiece(StructureTemplateManager p_228545_, CompoundTag p_228546_) {
			super(TechnologicaStructurePieceTypes.WHALE_CARCASS.get(), p_228546_, p_228545_, (p_228568_) -> {
				return makeSettings(Rotation.valueOf(p_228546_.getString("Rot")));
			});
		}

		private static StructurePlaceSettings makeSettings(Rotation rotation) {
			return new StructurePlaceSettings().setRotation(rotation).setMirror(Mirror.NONE).addProcessor(BlockIgnoreProcessor.STRUCTURE_AND_AIR);
		}

		@Override
		protected void addAdditionalSaveData(StructurePieceSerializationContext p_228558_, CompoundTag p_228559_) {
			super.addAdditionalSaveData(p_228558_, p_228559_);
			p_228559_.putString("Rot", this.placeSettings.getRotation().name());
		}

		@Override
		protected void handleDataMarker(String p_228561_, BlockPos p_228562_, ServerLevelAccessor p_228563_, RandomSource p_228564_, BoundingBox p_228565_) {
		}

		@SuppressWarnings("deprecation")
		@Override
		public void postProcess(WorldGenLevel p_228548_, StructureManager p_228549_, ChunkGenerator p_228550_, RandomSource p_228551_, BoundingBox p_228552_, ChunkPos p_228553_, BlockPos p_228554_) {
			p_228552_.encapsulate(this.template.getBoundingBox(this.placeSettings, this.templatePosition));
			super.postProcess(p_228548_, p_228549_, p_228550_, p_228551_, p_228552_, p_228553_, p_228554_);
		}
	}
}