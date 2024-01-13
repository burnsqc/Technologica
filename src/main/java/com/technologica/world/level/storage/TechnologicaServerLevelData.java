package com.technologica.world.level.storage;

import com.technologica.Technologica;

import net.minecraft.nbt.CompoundTag;
import net.minecraft.server.MinecraftServer;
import net.minecraft.world.level.saveddata.SavedData;

public class TechnologicaServerLevelData extends SavedData implements TechnologicaLevelData {
	private int clearWeatherTime;
	private boolean meteorStorming;
	private int meteorStormTime;

	public int getClearWeatherTime() {
		return this.clearWeatherTime;
	}

	public void setClearWeatherTime(int p_78517_) {
		this.clearWeatherTime = p_78517_;
		this.setDirty();
	}

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

	public void setMeteorStormTime(int p_78592_) {
		this.meteorStormTime = p_78592_;
		this.setDirty();
	}

	public static TechnologicaServerLevelData create() {
		return new TechnologicaServerLevelData();
	}

	public static TechnologicaServerLevelData load(CompoundTag tag) {
		TechnologicaServerLevelData data = create();
		int clearWeatherTime = tag.getInt("clearWeatherTime");
		boolean meteorStorming = tag.getBoolean("meteorStorming");
		int meteorStormTime = tag.getInt("meteorStormTime");
		data.clearWeatherTime = clearWeatherTime;
		data.meteorStorming = meteorStorming;
		data.meteorStormTime = meteorStormTime;
		return data;
	}

	@Override
	public CompoundTag save(CompoundTag tag) {
		tag.putInt("clearWeatherTime", clearWeatherTime);
		tag.putBoolean("meteorStorming", meteorStorming);
		tag.putInt("meteorStormTime", meteorStormTime);
		return tag;
	}

	public static TechnologicaServerLevelData getData(MinecraftServer server) {
		return server.overworld().getDataStorage().computeIfAbsent(TechnologicaServerLevelData::load, TechnologicaServerLevelData::create, Technologica.MOD_ID + "_weather");
	}
}
