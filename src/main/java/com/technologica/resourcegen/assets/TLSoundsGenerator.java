package com.technologica.resourcegen.assets;

import com.technologica.api.tlregen.resourcegen.assets.TLReGenSounds;
import com.technologica.registration.deferred.TechnologicaSoundEvents;
import com.technologica.util.text.TechnologicaLocation;

public class TLSoundsGenerator extends TLReGenSounds {
	@Override
	public void populate() {
		add(TechnologicaSoundEvents.DODGEBALL.get(), definition().with(sound(new TechnologicaLocation("dodgeball")).attenuationDistance(32)));
	}
}
