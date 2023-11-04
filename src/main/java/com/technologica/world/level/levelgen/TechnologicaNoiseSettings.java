package com.technologica.world.level.levelgen;

import net.minecraft.world.level.levelgen.NoiseSettings;

/**
 * <p>
 * This class contains Noise Settings.
 * The corresponding Noise Settings are created in json format during Data Generation via bootstrap in {@link TechnologicaNoiseGeneratorSettings}.
 * The structure of this class is a slight departure from the vanilla counterpart record as there is no use in this being a record as well and with the intent being ease of use.
 * </p>
 * 
 * @tl.status GREEN
 */
public class TechnologicaNoiseSettings {

	protected static final NoiseSettings MOON_NOISE_SETTINGS = moon();
	protected static final NoiseSettings CHALLENGER_DEEP_NOISE_SETTINGS = challengerDeep();
	protected static final NoiseSettings OVERGROWTH_NOISE_SETTINGS = overgrowth();

	/**
	 * <p>
	 * This method controls the contents of the noise property to be nested within the Noise Settings json file for the Moon.
	 * Variables are defined in the order they will appear in the json file.
	 * <p>
	 * 
	 * @return NoiseSettings for the Moon
	 */
	private static NoiseSettings moon() {
		int height = 384;
		int minY = -64;
		int sizeHorizontal = 1;
		int sizeVertical = 2;

		return NoiseSettings.create(minY, height, sizeHorizontal, sizeVertical);
	}

	/**
	 * <p>
	 * This method controls the contents of the noise property to be nested within the Noise Settings json file for the Challenger Deep.
	 * Variables are defined in the order they will appear in the json file.
	 * <p>
	 * 
	 * @return NoiseSettings for the Challenger Deep
	 */
	private static NoiseSettings challengerDeep() {
		int height = 384;
		int minY = -64;
		int sizeHorizontal = 1;
		int sizeVertical = 2;

		return NoiseSettings.create(minY, height, sizeHorizontal, sizeVertical);
	}

	/**
	 * <p>
	 * This method controls the contents of the noise property to be nested within the Noise Settings json file for the Overgrowth.
	 * Variables are defined in the order they will appear in the json file.
	 * <p>
	 * 
	 * @return NoiseSettings for the Overgrowth
	 */
	private static NoiseSettings overgrowth() {
		int height = 128;
		int minY = 0;
		int sizeHorizontal = 1;
		int sizeVertical = 2;

		return NoiseSettings.create(minY, height, sizeHorizontal, sizeVertical);
	}
}