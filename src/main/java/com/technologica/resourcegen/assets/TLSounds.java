package com.technologica.resourcegen.assets;

import com.technologica.api.tlregen.resourcegen.assets.TLReGenSounds;
import com.technologica.registration.deferred.TechnologicaSoundEvents;
import com.technologica.util.text.TechnologicaLocation;

public class TLSounds extends TLReGenSounds {
	@Override
	public void populate() {
		add(TechnologicaSoundEvents.DODGEBALL, sounds(32, new TechnologicaLocation("dodgeball")));

		add(TechnologicaSoundEvents.DUCK_AMBIENT, sounds(new TechnologicaLocation("mob/duck/say1"), new TechnologicaLocation("mob/duck/say2"), new TechnologicaLocation("mob/duck/say3")));
		add(TechnologicaSoundEvents.DUCK_DEATH, sounds(new TechnologicaLocation("mob/duck/hurt1"), new TechnologicaLocation("mob/duck/hurt2")));
		add(TechnologicaSoundEvents.DUCK_HURT, sounds(new TechnologicaLocation("mob/duck/hurt1"), new TechnologicaLocation("mob/duck/hurt2")));

		add(TechnologicaSoundEvents.TURKEY_AMBIENT, sounds(new TechnologicaLocation("mob/turkey/say1"), new TechnologicaLocation("mob/turkey/say2"), new TechnologicaLocation("mob/turkey/say3")));
		add(TechnologicaSoundEvents.TURKEY_DEATH, sounds(new TechnologicaLocation("mob/turkey/hurt1"), new TechnologicaLocation("mob/turkey/hurt2")));
		add(TechnologicaSoundEvents.TURKEY_HURT, sounds(new TechnologicaLocation("mob/turkey/hurt1"), new TechnologicaLocation("mob/turkey/hurt2")));

		add(TechnologicaSoundEvents.FLAMINGO_AMBIENT, sounds(new TechnologicaLocation("mob/flamingo/say1"), new TechnologicaLocation("mob/flamingo/say2"), new TechnologicaLocation("mob/flamingo/say3")));
		add(TechnologicaSoundEvents.FLAMINGO_DEATH, sounds(new TechnologicaLocation("mob/flamingo/hurt1"), new TechnologicaLocation("mob/flamingo/hurt2")));
		add(TechnologicaSoundEvents.FLAMINGO_HURT, sounds(new TechnologicaLocation("mob/flamingo/hurt1"), new TechnologicaLocation("mob/flamingo/hurt2")));

		add(TechnologicaSoundEvents.BUFFALO_AMBIENT, sounds(new TechnologicaLocation("mob/buffalo/say1"), new TechnologicaLocation("mob/buffalo/say2"), new TechnologicaLocation("mob/buffalo/say3"), new TechnologicaLocation("mob/buffalo/say4")));
		add(TechnologicaSoundEvents.BUFFALO_HURT, sounds(new TechnologicaLocation("mob/buffalo/hurt1"), new TechnologicaLocation("mob/buffalo/hurt2"), new TechnologicaLocation("mob/buffalo/hurt3")));
		add(TechnologicaSoundEvents.BUFFALO_DEATH, sounds(new TechnologicaLocation("mob/buffalo/hurt1"), new TechnologicaLocation("mob/buffalo/hurt2"), new TechnologicaLocation("mob/buffalo/hurt3")));
	}
}
