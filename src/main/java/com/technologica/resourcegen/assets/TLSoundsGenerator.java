package com.technologica.resourcegen.assets;

import com.technologica.api.tlrg.resourcegen.TLRGSoundsGenerator;
import com.technologica.registration.deferred.TechnologicaSoundEvents;
import com.technologica.util.text.TechnologicaLocation;

public class TLSoundsGenerator extends TLRGSoundsGenerator {
	@Override
	public void registerSounds() {
		add(TechnologicaSoundEvents.DODGEBALL.get(), definition().with(sound(new TechnologicaLocation("dodgeball")).attenuationDistance(32)));
	}
}
