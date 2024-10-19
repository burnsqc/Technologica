package com.technologica.registration.deferred;

import com.technologica.Technologica;
import com.technologica.util.text.TechnologicaLocation;

import net.minecraft.sounds.SoundEvent;
import net.minecraftforge.registries.RegistryObject;

public final class TechnologicaSoundEvents {
	public static final RegistryObject<SoundEvent> DODGEBALL = Technologica.SOUND_EVENTS.register("dodgeball", () -> SoundEvent.createVariableRangeEvent(new TechnologicaLocation("dodgeball")));
	public static final RegistryObject<SoundEvent> DUCK_AMBIENT = Technologica.SOUND_EVENTS.register("entity.duck.ambient", () -> SoundEvent.createVariableRangeEvent(new TechnologicaLocation("entity.duck.ambient")));
	public static final RegistryObject<SoundEvent> DUCK_HURT = Technologica.SOUND_EVENTS.register("entity.duck.hurt", () -> SoundEvent.createVariableRangeEvent(new TechnologicaLocation("entity.duck.hurt")));
	public static final RegistryObject<SoundEvent> DUCK_DEATH = Technologica.SOUND_EVENTS.register("entity.duck.death", () -> SoundEvent.createVariableRangeEvent(new TechnologicaLocation("entity.duck.death")));
	public static final RegistryObject<SoundEvent> TURKEY_AMBIENT = Technologica.SOUND_EVENTS.register("entity.turkey.ambient", () -> SoundEvent.createVariableRangeEvent(new TechnologicaLocation("entity.turkey.ambient")));
	public static final RegistryObject<SoundEvent> TURKEY_HURT = Technologica.SOUND_EVENTS.register("entity.turkey.hurt", () -> SoundEvent.createVariableRangeEvent(new TechnologicaLocation("entity.turkey.hurt")));
	public static final RegistryObject<SoundEvent> TURKEY_DEATH = Technologica.SOUND_EVENTS.register("entity.turkey.death", () -> SoundEvent.createVariableRangeEvent(new TechnologicaLocation("entity.turkey.death")));
	public static final RegistryObject<SoundEvent> FLAMINGO_AMBIENT = Technologica.SOUND_EVENTS.register("entity.flamingo.ambient", () -> SoundEvent.createVariableRangeEvent(new TechnologicaLocation("entity.flamingo.ambient")));
	public static final RegistryObject<SoundEvent> FLAMINGO_HURT = Technologica.SOUND_EVENTS.register("entity.flamingo.hurt", () -> SoundEvent.createVariableRangeEvent(new TechnologicaLocation("entity.flamingo.hurt")));
	public static final RegistryObject<SoundEvent> FLAMINGO_DEATH = Technologica.SOUND_EVENTS.register("entity.flamingo.death", () -> SoundEvent.createVariableRangeEvent(new TechnologicaLocation("entity.flamingo.death")));
	public static final RegistryObject<SoundEvent> BUFFALO_AMBIENT = Technologica.SOUND_EVENTS.register("entity.buffalo.ambient", () -> SoundEvent.createVariableRangeEvent(new TechnologicaLocation("entity.buffalo.ambient")));
	public static final RegistryObject<SoundEvent> BUFFALO_HURT = Technologica.SOUND_EVENTS.register("entity.buffalo.hurt", () -> SoundEvent.createVariableRangeEvent(new TechnologicaLocation("entity.buffalo.hurt")));
	public static final RegistryObject<SoundEvent> BUFFALO_DEATH = Technologica.SOUND_EVENTS.register("entity.buffalo.death", () -> SoundEvent.createVariableRangeEvent(new TechnologicaLocation("entity.buffalo.death")));
}
