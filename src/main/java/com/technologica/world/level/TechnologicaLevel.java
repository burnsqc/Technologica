package com.technologica.world.level;

import com.technologica.registration.key.TechnologicaBiomes;
import com.technologica.world.level.storage.TechnologicaLevelData;

import net.minecraft.core.BlockPos;
import net.minecraft.util.Mth;
import net.minecraft.world.level.Level;
import net.minecraft.world.level.levelgen.Heightmap;

public class TechnologicaLevel {
	public float oMeteorStormLevel;
	public float meteorStormLevel;
	protected final TechnologicaLevelData technologicaLevelData;
	private Level level;

	protected TechnologicaLevel(Level level, TechnologicaLevelData technologicaLevelData) {
		this.technologicaLevelData = technologicaLevelData;
		this.level = level;
	}

	public float getMeteorStormLevel(float p_46723_) {
		return Mth.lerp(p_46723_, this.oMeteorStormLevel, this.meteorStormLevel);
	}

	public void setMeteorStormLevel(float p_46735_) {
		float f = Mth.clamp(p_46735_, 0.0F, 1.0F);
		this.oMeteorStormLevel = f;
		this.meteorStormLevel = f;
	}

	public boolean isMeteorStorming() {
		return this.getMeteorStormLevel(1.0F) > 0.2D;
	}

	public boolean isMeteorStormingAt(BlockPos blockPos) {
		if (!this.isMeteorStorming()) {
			return false;
		} else if (!level.canSeeSky(blockPos)) {
			return false;
		} else if (level.getHeightmapPos(Heightmap.Types.MOTION_BLOCKING, blockPos).getY() > blockPos.getY()) {
			return false;
		} else {
			return level.getBiome(blockPos).is(TechnologicaBiomes.CRATER_FIELDS);
		}
	}
}
