package com.technologica.client.multiplayer;

import com.technologica.world.level.TechnologicaLevel;
import com.technologica.world.level.storage.TechnologicaLevelData;

import net.minecraft.client.multiplayer.ClientLevel;

public class TechnologicaClientLevel extends TechnologicaLevel {
	private final TechnologicaClientLevel.TechnologicaClientLevelData technologicaClientLevelData;

	public TechnologicaClientLevel(ClientLevel level, TechnologicaClientLevel.TechnologicaClientLevelData technologicaClientLevelData) {
		super(level, technologicaClientLevelData);
		this.technologicaClientLevelData = technologicaClientLevelData;
	}

	public TechnologicaClientLevel.TechnologicaClientLevelData getLevelData() {
		return this.technologicaClientLevelData;
	}

	public static class TechnologicaClientLevelData implements TechnologicaLevelData {
		private boolean meteorStorming;

		@Override
		public boolean isMeteorStorming() {
			return this.meteorStorming;
		}

		@Override
		public void setMeteorStorming(boolean meteorStorming) {
			this.meteorStorming = meteorStorming;
		}
	}
}
