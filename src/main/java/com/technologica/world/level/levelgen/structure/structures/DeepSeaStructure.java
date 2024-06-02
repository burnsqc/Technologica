package com.technologica.world.level.levelgen.structure.structures;

import java.util.Optional;

import com.mojang.serialization.Codec;
import com.mojang.serialization.codecs.RecordCodecBuilder;
import com.technologica.registration.deferred.TechnologicaStructureTypes;

import net.minecraft.core.BlockPos;
import net.minecraft.world.level.NoiseColumn;
import net.minecraft.world.level.block.Blocks;
import net.minecraft.world.level.block.state.BlockState;
import net.minecraft.world.level.levelgen.WorldGenerationContext;
import net.minecraft.world.level.levelgen.WorldgenRandom;
import net.minecraft.world.level.levelgen.heightproviders.HeightProvider;
import net.minecraft.world.level.levelgen.structure.Structure;
import net.minecraft.world.level.levelgen.structure.StructureType;

public final class DeepSeaStructure extends Structure {
	public static final Codec<DeepSeaStructure> CODEC = RecordCodecBuilder.create((p_228585_) -> {
		return p_228585_.group(settingsCodec(p_228585_), HeightProvider.CODEC.fieldOf("height").forGetter((p_228583_) -> {
			return p_228583_.height;
		})).apply(p_228585_, DeepSeaStructure::new);
	});
	private final HeightProvider height;

	public DeepSeaStructure(Structure.StructureSettings p_227627_, HeightProvider p_227631_) {
		super(p_227627_);
		this.height = p_227631_;
	}

	@Override
	public Optional<Structure.GenerationStub> findGenerationPoint(Structure.GenerationContext p_228576_) {
		WorldgenRandom worldgenrandom = p_228576_.random();
		int i = p_228576_.chunkPos().getMinBlockX() + worldgenrandom.nextInt(16);
		int j = p_228576_.chunkPos().getMinBlockZ() + worldgenrandom.nextInt(16);
		int k = 5;
		WorldGenerationContext worldgenerationcontext = new WorldGenerationContext(p_228576_.chunkGenerator(), p_228576_.heightAccessor());
		int l = this.height.sample(worldgenrandom, worldgenerationcontext);
		NoiseColumn noisecolumn = p_228576_.chunkGenerator().getBaseColumn(i, j, p_228576_.heightAccessor(), p_228576_.randomState());

		while (l > k) {
			BlockState blockstate = noisecolumn.getBlock(l);
			--l;
			BlockState blockstate1 = noisecolumn.getBlock(l);
			if (blockstate.is(Blocks.WATER) && (blockstate1.is(Blocks.STONE))) {
				break;
			}
		}

		if (l <= k) {
			return Optional.empty();
		} else {
			BlockPos blockpos = new BlockPos(i, l, j);
			return Optional.of(new Structure.GenerationStub(blockpos, (p_228581_) -> {
				WhaleCarcassPieces.addPieces(p_228576_.structureTemplateManager(), p_228581_, worldgenrandom, blockpos);
			}));
		}
	}

	@Override
	public StructureType<?> type() {
		return TechnologicaStructureTypes.DEEP_SEA.get();
	}
}