package com.technologica.resourcegen.assets;

import java.util.HashMap;
import java.util.Map;
import java.util.function.Supplier;

import com.technologica.registration.deferred.TechnologicaSoundEvents;
import com.technologica.util.text.TechnologicaLocation;
import com.tlregen.api.resourcegen.util.TLReGenSoundDefinition;
import com.tlregen.api.resourcegen.util.helpers.TLReGenSoundHelper;

import net.minecraft.sounds.SoundEvent;

public class TLSounds extends TLReGenSoundHelper {
	public static final Map<String, TLReGenSoundDefinition> SOUNDS = new HashMap<>();

	static {
		add(TechnologicaSoundEvents.DODGEBALL, sounds(32, new TechnologicaLocation("random/dodgeball")));

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

		add(TechnologicaSoundEvents.SONAR, sounds(new TechnologicaLocation("random/sonar")));
		add(TechnologicaSoundEvents.NIGHT_VISION, sounds(new TechnologicaLocation("random/night_vision")));

		add(TechnologicaSoundEvents.ABYSS_PORTAL_AMBIENT, sounds(10, new TechnologicaLocation("portal/abyss_portal_ambient")));
	}

	protected static void add(final Supplier<SoundEvent> soundEventSupplier, final TLReGenSoundDefinition definition) {
		addSounds(soundEventSupplier.get().getLocation().getPath(), definition);
	}

	private static void addSounds(final String soundEvent, final TLReGenSoundDefinition definition) {
		SOUNDS.put(soundEvent, definition);
	}
}
