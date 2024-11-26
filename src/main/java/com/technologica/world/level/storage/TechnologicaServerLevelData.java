package com.technologica.world.level.storage;

import com.technologica.Technologica;

import net.minecraft.nbt.CompoundTag;
import net.minecraft.server.MinecraftServer;
import net.minecraft.world.level.saveddata.SavedData;

public class TechnologicaServerLevelData extends SavedData implements TechnologicaLevelData {
	private boolean meteorStorming;
	private int meteorStormTime;
	private int clearWeatherTime;

	@Override
	public boolean isMeteorStorming() {
		return this.meteorStorming;
	}

	@Override
	public void setMeteorStorming(boolean meteorStorming) {
		this.meteorStorming = meteorStorming;
		this.setDirty();
	}

	public int getMeteorStormTime() {
		return this.meteorStormTime;
	}

	public void setMeteorStormTime(int meteorStormTime) {
		this.meteorStormTime = meteorStormTime;
		this.setDirty();
	}

	public int getClearWeatherTime() {
		return this.clearWeatherTime;
	}

	public void setClearWeatherTime(int clearWeatherTime) {
		this.clearWeatherTime = clearWeatherTime;
		this.setDirty();
	}

	public static TechnologicaServerLevelData create() {
		return new TechnologicaServerLevelData();
	}

	public static TechnologicaServerLevelData load(CompoundTag compoundTag) {
		TechnologicaServerLevelData technologicaServerLevelData = create();
		boolean meteorStorming = compoundTag.getBoolean("meteorStorming");
		int meteorStormTime = compoundTag.getInt("meteorStormTime");
		int clearWeatherTime = compoundTag.getInt("clearWeatherTime");
		technologicaServerLevelData.clearWeatherTime = clearWeatherTime;
		technologicaServerLevelData.meteorStorming = meteorStorming;
		technologicaServerLevelData.meteorStormTime = meteorStormTime;
		return technologicaServerLevelData;
	}

	@Override
	public CompoundTag save(CompoundTag compoundTag) {
		compoundTag.putBoolean("meteorStorming", meteorStorming);
		compoundTag.putInt("meteorStormTime", meteorStormTime);
		compoundTag.putInt("clearWeatherTime", clearWeatherTime);
		return compoundTag;
	}

	public static TechnologicaServerLevelData getData(MinecraftServer minecraftServer) {
		return minecraftServer.overworld().getDataStorage().computeIfAbsent(TechnologicaServerLevelData::load, TechnologicaServerLevelData::create, Technologica.MOD_ID + "_weather");
	}
}
