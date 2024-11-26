package com.technologica.world.level.storage;

/**
 * Simple interface implemeted by both TechnologicaClientLevelData and TechnologicaServerLevelData in order to control meteor storm on moon.
 */
public interface TechnologicaLevelData {
	boolean isMeteorStorming();

	void setMeteorStorming(boolean meteorStorming);
}
