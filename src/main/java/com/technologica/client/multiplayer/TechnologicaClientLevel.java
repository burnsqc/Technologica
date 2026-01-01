package com.technologica.client.multiplayer;

import com.technologica.world.level.TechnologicaLevel;
import com.technologica.world.level.storage.TechnologicaLevelData;

import net.minecraft.client.multiplayer.ClientLevel;

public class TechnologicaClientLevel extends TechnologicaLevel {
	private final TechnologicaClientLevel.TechnologicaClientLevelData technologicaClientLevelData;

	public TechnologicaClientLevel(ClientLevel clientLevel, TechnologicaClientLevelData technologicaClientLevelData) {
		super(clientLevel, technologicaClientLevelData);
		this.technologicaClientLevelData = technologicaClientLevelData;
	}

	public TechnologicaClientLevelData getLevelData() {
		return this.technologicaClientLevelData;
	}

	public static class TechnologicaClientLevelData implements TechnologicaLevelData {
		private boolean isMeteorStorming;

		@Override
		public boolean isMeteorStorming() {
			return this.isMeteorStorming;
		}

		@Override
		public void setMeteorStorming(boolean isMeteorStorming) {
			this.isMeteorStorming = isMeteorStorming;
		}
	}
}
