package com.technologica.listeners.forgebus;

import java.util.List;

import com.google.common.collect.Lists;
import com.technologica.Technologica;
import com.technologica.network.packets.ClientboundSetMeteorStorm;
import com.technologica.network.packets.ClientboundSetMeteorStormLevel;
import com.technologica.registration.key.TechnologicaBiomes;
import com.technologica.registration.key.TechnologicaDimensionTypes;

import net.minecraft.core.BlockPos;
import net.minecraft.server.level.ChunkHolder;
import net.minecraft.server.level.ChunkMap;
import net.minecraft.server.level.DistanceManager;
import net.minecraft.server.level.ServerLevel;
import net.minecraft.util.Mth;
import net.minecraft.util.valueproviders.IntProvider;
import net.minecraft.util.valueproviders.UniformInt;
import net.minecraft.world.entity.EntityType;
import net.minecraft.world.entity.projectile.LargeFireball;
import net.minecraft.world.level.ChunkPos;
import net.minecraft.world.level.GameRules;
import net.minecraft.world.level.chunk.LevelChunk;
import net.minecraft.world.level.levelgen.Heightmap;
import net.minecraft.world.phys.Vec3;
import net.minecraftforge.event.TickEvent.LevelTickEvent;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.fml.LogicalSide;
import net.minecraftforge.network.PacketDistributor;

public class ServerTickEventListener {
	public static float oStormLevel;
	public static float stormLevel;
	public static ServerLevel level;
	public static final IntProvider STORM_DELAY = UniformInt.of(1200, 1800);
	public static final IntProvider STORM_DURATION = UniformInt.of(1200, 2400);
	private static int clearWeatherTime;
	private static int stormTime;
	private static boolean isStorming;

	@SubscribeEvent
	public static void onServerTickEvent(final LevelTickEvent event) {
		if (event.level instanceof ServerLevel) {
			level = (ServerLevel) event.level;
			if (event.side == LogicalSide.SERVER) {
				advanceWeatherCycle();

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
							spawnMeteors(levelchunk1);
						}
					}
				}
			}
		}
	}

	private static void advanceWeatherCycle() {
		boolean flag = isStorming();
		if (level.dimensionTypeId() == TechnologicaDimensionTypes.MOON) {
			if (level.getGameRules().getBoolean(GameRules.RULE_WEATHER_CYCLE)) {
				int i = clearWeatherTime;
				int k = stormTime;
				boolean flag2 = isStorming;
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
						k = STORM_DURATION.sample(level.getRandom());
					} else {
						k = STORM_DELAY.sample(level.getRandom());
					}
				}

				stormTime = k;
				clearWeatherTime = i;
				isStorming = flag2;
			}

			oStormLevel = stormLevel;
			if (isStorming) {
				stormLevel += 0.01F;
			} else {
				stormLevel -= 0.01F;
			}
			stormLevel = Mth.clamp(stormLevel, 0.0F, 1.0F);
		}

		if (oStormLevel != stormLevel) {
			Technologica.CHANNEL.send(PacketDistributor.DIMENSION.with(() -> level.dimension()), new ClientboundSetMeteorStormLevel(stormLevel));
		}

		if (flag != isStorming()) {
			if (flag) {
				Technologica.LOGGER.debug("STOPPING METEOR STORM");
				Technologica.CHANNEL.send(PacketDistributor.DIMENSION.with(() -> level.dimension()), new ClientboundSetMeteorStorm(false));
			} else {
				Technologica.LOGGER.debug("STARTING METEOR STORM");
				Technologica.CHANNEL.send(PacketDistributor.DIMENSION.with(() -> level.dimension()), new ClientboundSetMeteorStorm(true));
			}
			Technologica.CHANNEL.send(PacketDistributor.DIMENSION.with(() -> level.dimension()), new ClientboundSetMeteorStormLevel(stormLevel));
		}
	}

	public static void spawnMeteors(LevelChunk p_8715_) {
		ChunkPos chunkpos = p_8715_.getPos();
		boolean flag = isStorming();
		int i = chunkpos.getMinBlockX();
		int j = chunkpos.getMinBlockZ();
		if (flag && level.random.nextInt(500) == 0) {
			BlockPos blockpos = level.getBlockRandomPos(i, 100, j, 15);
			if (isStormingAt(blockpos)) {

				LargeFireball lightningbolt = EntityType.FIREBALL.create(level);
				if (lightningbolt != null) {
					lightningbolt.setDeltaMovement(0, -3, 0);
					lightningbolt.moveTo(Vec3.atBottomCenterOf(blockpos));

					level.addFreshEntity(lightningbolt);
				}
			}
		}
	}

	public static boolean isStorming() {
		return getStormLevel(1.0F) > 0.2D;
	}

	public static boolean isStormingAt(BlockPos p_46759_) {
		if (!isStorming()) {
			return false;
		} else if (!level.canSeeSky(p_46759_)) {
			return false;
		} else if (level.getHeightmapPos(Heightmap.Types.MOTION_BLOCKING, p_46759_).getY() > p_46759_.getY()) {
			return false;
		} else {
			return level.getBiome(p_46759_).is(TechnologicaBiomes.CRATER_FIELDS);
		}
	}

	public static float getStormLevel(float p_46723_) {
		return Mth.lerp(p_46723_, oStormLevel, stormLevel);
	}

	public static void setStorming(boolean p_78576_) {
		isStorming = p_78576_;
	}

	public static void setStormTime(int p_78592_) {
		stormTime = p_78592_;
	}

	public static void setStormLevel(float p_46735_) {
		float f = Mth.clamp(p_46735_, 0.0F, 1.0F);
		oStormLevel = f;
		stormLevel = f;
	}

	static record ChunkAndHolder(LevelChunk chunk, ChunkHolder holder) {
	}
}