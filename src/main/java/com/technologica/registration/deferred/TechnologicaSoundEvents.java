package com.technologica.registration.deferred;

import com.technologica.Technologica;
import com.technologica.api.tlregen.registration.MasterDeferredRegistrar;
import com.technologica.util.text.TechnologicaLocation;

import net.minecraft.sounds.SoundEvent;
import net.minecraftforge.registries.RegistryObject;

/**
 * <p>
 * This class contains Registry Objects for Sound Events.
 * The {@link #init} method is called by {@link Technologica#initDeferredRegisters} and returns a head-count to later be checked during registration and other setup activities.
 * </p>
 * 
 * @tl.status GREEN
 */
public final class TechnologicaSoundEvents extends MasterDeferredRegistrar {

	public static int init() {
		return SOUND_EVENTS.getEntries().size();
	}

	public static final RegistryObject<SoundEvent> DODGEBALL = SOUND_EVENTS.register("dodgeball", () -> SoundEvent.createVariableRangeEvent(new TechnologicaLocation("dodgeball")));

	public static final RegistryObject<SoundEvent> DUCK_AMBIENT = SOUND_EVENTS.register("entity.duck.ambient", () -> SoundEvent.createVariableRangeEvent(new TechnologicaLocation("entity.duck.ambient")));
	public static final RegistryObject<SoundEvent> DUCK_HURT = SOUND_EVENTS.register("entity.duck.hurt", () -> SoundEvent.createVariableRangeEvent(new TechnologicaLocation("entity.duck.hurt")));
	public static final RegistryObject<SoundEvent> DUCK_DEATH = SOUND_EVENTS.register("entity.duck.death", () -> SoundEvent.createVariableRangeEvent(new TechnologicaLocation("entity.duck.death")));

	public static final RegistryObject<SoundEvent> TURKEY_AMBIENT = SOUND_EVENTS.register("entity.turkey.ambient", () -> SoundEvent.createVariableRangeEvent(new TechnologicaLocation("entity.turkey.ambient")));
	public static final RegistryObject<SoundEvent> TURKEY_HURT = SOUND_EVENTS.register("entity.turkey.hurt", () -> SoundEvent.createVariableRangeEvent(new TechnologicaLocation("entity.turkey.hurt")));
	public static final RegistryObject<SoundEvent> TURKEY_DEATH = SOUND_EVENTS.register("entity.turkey.death", () -> SoundEvent.createVariableRangeEvent(new TechnologicaLocation("entity.turkey.death")));

	public static final RegistryObject<SoundEvent> FLAMINGO_AMBIENT = SOUND_EVENTS.register("entity.flamingo.ambient", () -> SoundEvent.createVariableRangeEvent(new TechnologicaLocation("entity.flamingo.ambient")));
	public static final RegistryObject<SoundEvent> FLAMINGO_HURT = SOUND_EVENTS.register("entity.flamingo.hurt", () -> SoundEvent.createVariableRangeEvent(new TechnologicaLocation("entity.flamingo.hurt")));
	public static final RegistryObject<SoundEvent> FLAMINGO_DEATH = SOUND_EVENTS.register("entity.flamingo.death", () -> SoundEvent.createVariableRangeEvent(new TechnologicaLocation("entity.flamingo.death")));

	public static final RegistryObject<SoundEvent> BUFFALO_AMBIENT = SOUND_EVENTS.register("entity.buffalo.ambient", () -> SoundEvent.createVariableRangeEvent(new TechnologicaLocation("entity.buffalo.ambient")));
	public static final RegistryObject<SoundEvent> BUFFALO_HURT = SOUND_EVENTS.register("entity.buffalo.hurt", () -> SoundEvent.createVariableRangeEvent(new TechnologicaLocation("entity.buffalo.hurt")));
	public static final RegistryObject<SoundEvent> BUFFALO_DEATH = SOUND_EVENTS.register("entity.buffalo.death", () -> SoundEvent.createVariableRangeEvent(new TechnologicaLocation("entity.buffalo.death")));

}
