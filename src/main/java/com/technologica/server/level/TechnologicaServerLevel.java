package com.technologica.server.level;

import java.util.List;

import com.google.common.collect.Lists;
import com.technologica.Technologica;
import com.technologica.network.packets.clientbound.SetMeteorStorm;
import com.technologica.network.packets.clientbound.SetMeteorStormLevel;
import com.technologica.registration.key.TechnologicaDimensionTypes;
import com.technologica.world.entity.projectile.Meteor;
import com.technologica.world.level.TechnologicaLevel;
import com.technologica.world.level.storage.TechnologicaServerLevelData;

import net.minecraft.core.BlockPos;
import net.minecraft.server.level.ChunkHolder;
import net.minecraft.server.level.ChunkMap;
import net.minecraft.server.level.DistanceManager;
import net.minecraft.server.level.ServerLevel;
import net.minecraft.util.Mth;
import net.minecraft.util.valueproviders.IntProvider;
import net.minecraft.util.valueproviders.UniformInt;
import net.minecraft.world.level.ChunkPos;
import net.minecraft.world.level.GameRules;
import net.minecraft.world.level.chunk.LevelChunk;
import net.minecraftforge.network.PacketDistributor;

public class TechnologicaServerLevel extends TechnologicaLevel {
	public static final IntProvider METEOR_STORM_DELAY = UniformInt.of(12000, 180000);
	public static final IntProvider METEOR_STORM_DURATION = UniformInt.of(12000, 24000);
	private final TechnologicaServerLevelData technologicaServerLevelData;
	private ServerLevel level;

	public TechnologicaServerLevel(ServerLevel level, TechnologicaServerLevelData technologicaServerLevelData) {
		super(level, technologicaServerLevelData);
		this.technologicaServerLevelData = technologicaServerLevelData;
		this.level = level;
	}

	public void setWeatherParameters(int clearWeatherTime, int meteorStormingTime, boolean isMeteorStorming) {
		this.technologicaServerLevelData.setClearWeatherTime(clearWeatherTime);
		this.technologicaServerLevelData.setMeteorStormTime(meteorStormingTime);
		this.technologicaServerLevelData.setMeteorStorming(isMeteorStorming);
	}

	public void tick() {
		this.advanceWeatherCycle();

		ChunkMap chunkMap = level.getChunkSource().chunkMap;
		DistanceManager distanceManager = chunkMap.getDistanceManager();
		int l = distanceManager.getNaturalSpawnChunkCount();

		List<ChunkAndHolder> list = Lists.newArrayListWithCapacity(l);

		for (ChunkHolder chunkholder : chunkMap.getChunks()) {
			LevelChunk levelchunk = chunkholder.getTickingChunk();
			if (levelchunk != null) {
				list.add(new ChunkAndHolder(levelchunk, chunkholder));
			}
		}

		for (ChunkAndHolder serverchunkcache$chunkandholder : list) {
			LevelChunk levelchunk1 = serverchunkcache$chunkandholder.chunk;
			ChunkPos chunkpos = levelchunk1.getPos();
			if (true || distanceManager.shouldForceTicks(chunkpos.toLong())) {

				if (level.shouldTickBlocksAt(chunkpos.toLong())) {
					this.spawnMeteors(levelchunk1);
				}
			}
		}
	}

	private void advanceWeatherCycle() {
		boolean flag = this.isMeteorStorming();
		if (this.level.dimensionTypeId() == TechnologicaDimensionTypes.MOON) {
			if (this.level.getGameRules().getBoolean(GameRules.RULE_WEATHER_CYCLE)) {
				int i = this.technologicaServerLevelData.getClearWeatherTime();
				int k = this.technologicaServerLevelData.getMeteorStormTime();
				boolean flag2 = this.technologicaLevelData.isMeteorStorming();
				if (i > 0) {
					--i;
					k = flag2 ? 0 : 1;
					flag2 = false;
				} else {
					if (k > 0) {
						--k;
						if (k == 0) {
							flag2 = !flag2;
						}
					} else if (flag2) {
						k = METEOR_STORM_DURATION.sample(this.level.getRandom());
					} else {
						k = METEOR_STORM_DELAY.sample(this.level.getRandom());
					}
				}

				this.technologicaServerLevelData.setMeteorStormTime(k);
				this.technologicaServerLevelData.setClearWeatherTime(i);
				this.technologicaServerLevelData.setMeteorStorming(flag2);
			}

			this.oMeteorStormLevel = this.meteorStormLevel;
			if (this.technologicaLevelData.isMeteorStorming()) {
				this.meteorStormLevel += 0.01F;
			} else {
				this.meteorStormLevel -= 0.01F;
			}

			this.meteorStormLevel = Mth.clamp(this.meteorStormLevel, 0.0F, 1.0F);
		}

		if (this.oMeteorStormLevel != this.meteorStormLevel) {
			Technologica.CHANNEL.send(PacketDistributor.DIMENSION.with(() -> this.level.dimension()), new SetMeteorStormLevel(this.meteorStormLevel));
		}

		if (flag != this.isMeteorStorming()) {
			if (flag) {
				Technologica.LOGGER.debug("STOPPING METEOR STORM");
				Technologica.CHANNEL.send(PacketDistributor.DIMENSION.with(() -> this.level.dimension()), new SetMeteorStorm(false));
			} else {
				Technologica.LOGGER.debug("STARTING METEOR STORM");
				Technologica.CHANNEL.send(PacketDistributor.DIMENSION.with(() -> this.level.dimension()), new SetMeteorStorm(true));
			}
			Technologica.CHANNEL.send(PacketDistributor.DIMENSION.with(() -> this.level.dimension()), new SetMeteorStormLevel(this.meteorStormLevel));
		}
	}

	public void spawnMeteors(LevelChunk p_8715_) {
		ChunkPos chunkpos = p_8715_.getPos();
		boolean flag = this.isMeteorStorming();
		int i = chunkpos.getMinBlockX();
		int j = chunkpos.getMinBlockZ();
		if (flag && level.random.nextInt(5000) == 0) {
			BlockPos blockpos = level.getBlockRandomPos(i, 340, j, 15);
			if (this.isMeteorStormingAt(blockpos)) {
				Meteor meteor = new Meteor(level, blockpos.getX(), blockpos.getY(), blockpos.getZ());
				if (meteor != null) {
					meteor.setDeltaMovement(0, -10, 0);
					level.addFreshEntity(meteor);
				}
			}
		}
	}

	static record ChunkAndHolder(LevelChunk chunk, ChunkHolder holder) {
	}
}
