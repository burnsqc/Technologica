package com.technologica.setup.listeners;

import static com.technologica.Technologica.LOGGER;

import com.technologica.registration.deferred.TechnologicaEntityTypes;
import com.technologica.world.entity.animal.Alligator;
import com.technologica.world.entity.animal.Beaver;
import com.technologica.world.entity.animal.Buffalo;
import com.technologica.world.entity.animal.Cobra;
import com.technologica.world.entity.animal.Cottonmouth;
import com.technologica.world.entity.animal.Coyote;
import com.technologica.world.entity.animal.Crab;
import com.technologica.world.entity.animal.Deer;
import com.technologica.world.entity.animal.Duck;
import com.technologica.world.entity.animal.Elephant;
import com.technologica.world.entity.animal.Flamingo;
import com.technologica.world.entity.animal.Frog;
import com.technologica.world.entity.animal.Giraffe;
import com.technologica.world.entity.animal.Gorilla;
import com.technologica.world.entity.animal.GrizzlyBear;
import com.technologica.world.entity.animal.Jaguar;
import com.technologica.world.entity.animal.KingCrab;
import com.technologica.world.entity.animal.LeopardSeal;
import com.technologica.world.entity.animal.Lion;
import com.technologica.world.entity.animal.Lizard;
import com.technologica.world.entity.animal.Moose;
import com.technologica.world.entity.animal.Narwhal;
import com.technologica.world.entity.animal.Octopus;
import com.technologica.world.entity.animal.Ostrich;
import com.technologica.world.entity.animal.Owl;
import com.technologica.world.entity.animal.Penguin;
import com.technologica.world.entity.animal.Piranha;
import com.technologica.world.entity.animal.PoisonDartFrog;
import com.technologica.world.entity.animal.Raccoon;
import com.technologica.world.entity.animal.Scorpion;
import com.technologica.world.entity.animal.Shark;
import com.technologica.world.entity.animal.Sloth;
import com.technologica.world.entity.animal.Stingray;
import com.technologica.world.entity.animal.Turkey;
import com.technologica.world.entity.animal.Vulture;
import com.technologica.world.entity.animal.Walrus;
import com.technologica.world.entity.animal.Zebra;
import com.technologica.world.entity.monster.AtomicCreeper;
import com.technologica.world.entity.monster.Beeper;
import com.technologica.world.entity.monster.DustDevil;
import com.technologica.world.entity.monster.Mummy;
import com.technologica.world.entity.monster.Peeper;
import com.technologica.world.entity.monster.Sleeper;
import com.technologica.world.entity.monster.Sweeper;
import com.technologica.world.entity.monster.Weeper;

import net.minecraft.world.entity.MobCategory;
import net.minecraft.world.entity.ai.attributes.DefaultAttributes;
import net.minecraftforge.event.entity.EntityAttributeCreationEvent;

/**
 * <p>
 * This class listens for EntityAttributeCreationEvent which is fired on the mod-specific event bus.
 * When the event is intercepted, Technologica Entity Attributes are created.
 * </p>
 * 
 * @tl.status GREEN
 */
public class TechnologicaEntityAttributes {

	/**
	 * <p>
	 * Create Entity Attributes in 3 steps:
	 * <p>
	 * 1. Count how many living Technologica Entity Types do not yet have attributes and log.
	 * <p>
	 * 2. Create attributes for living Technologica Entity Types.
	 * <p>
	 * 3. Count how many living Technologica Entity Types now have attributes and log.
	 * </p>
	 * 
	 * @param event EntityAttributeCreationEvent
	 */
	public static void onEntityAttributeCreationEvent(final EntityAttributeCreationEvent event) {
		long required = TechnologicaEntityTypes.ENTITY_TYPES.getEntries().stream().filter((entity) -> {
			return entity.get().getCategory() != MobCategory.MISC;
		}).filter((entity) -> {
			return !DefaultAttributes.hasSupplier(entity.get());
		}).count();

		event.put(TechnologicaEntityTypes.ALLIGATOR.get(), Alligator.registerAttributes().build());
		event.put(TechnologicaEntityTypes.BEAVER.get(), Beaver.registerAttributes().build());
		event.put(TechnologicaEntityTypes.BUFFALO.get(), Buffalo.createAttributes().build());
		event.put(TechnologicaEntityTypes.COBRA.get(), Cobra.registerAttributes().build());
		event.put(TechnologicaEntityTypes.COTTONMOUTH.get(), Cottonmouth.registerAttributes().build());
		event.put(TechnologicaEntityTypes.COYOTE.get(), Coyote.createAttributes().build());
		event.put(TechnologicaEntityTypes.CRAB.get(), Crab.registerAttributes().build());
		event.put(TechnologicaEntityTypes.DEER.get(), Deer.registerAttributes().build());
		event.put(TechnologicaEntityTypes.DUCK.get(), Duck.createAttributes().build());
		event.put(TechnologicaEntityTypes.ELEPHANT.get(), Elephant.registerAttributes().build());
		event.put(TechnologicaEntityTypes.FLAMINGO.get(), Flamingo.registerAttributes().build());
		event.put(TechnologicaEntityTypes.FIGURE_EIGHT_PUFFERFISH.get(), Frog.registerAttributes().build());
		event.put(TechnologicaEntityTypes.GIRAFFE.get(), Giraffe.createBaseHorseAttributes().build());
		event.put(TechnologicaEntityTypes.GORILLA.get(), Gorilla.registerAttributes().build());
		event.put(TechnologicaEntityTypes.GRIZZLY_BEAR.get(), GrizzlyBear.registerAttributes().build());
		event.put(TechnologicaEntityTypes.JAGUAR.get(), Jaguar.registerAttributes().build());
		event.put(TechnologicaEntityTypes.KING_CRAB.get(), KingCrab.registerAttributes().build());
		event.put(TechnologicaEntityTypes.LEOPARD_SEAL.get(), LeopardSeal.registerAttributes().build());
		event.put(TechnologicaEntityTypes.LION.get(), Lion.registerAttributes().build());
		event.put(TechnologicaEntityTypes.LIZARD.get(), Lizard.registerAttributes().build());
		event.put(TechnologicaEntityTypes.MOOSE.get(), Moose.registerAttributes().build());
		event.put(TechnologicaEntityTypes.NARWHAL.get(), Narwhal.registerAttributes().build());
		event.put(TechnologicaEntityTypes.OCTOPUS.get(), Octopus.registerAttributes().build());
		event.put(TechnologicaEntityTypes.OSTRICH.get(), Ostrich.createBaseHorseAttributes().build());
		event.put(TechnologicaEntityTypes.OWL.get(), Owl.registerAttributes().build());
		event.put(TechnologicaEntityTypes.PENGUIN.get(), Penguin.registerAttributes().build());
		event.put(TechnologicaEntityTypes.PIRANHA.get(), Piranha.registerAttributes().build());
		event.put(TechnologicaEntityTypes.POISON_DART_FROG.get(), PoisonDartFrog.registerAttributes().build());
		event.put(TechnologicaEntityTypes.RACCOON.get(), Raccoon.registerAttributes().build());
		event.put(TechnologicaEntityTypes.SCORPION.get(), Scorpion.createAttributes().build());
		event.put(TechnologicaEntityTypes.SHARK.get(), Shark.registerAttributes().build());
		event.put(TechnologicaEntityTypes.SLOTH.get(), Sloth.registerAttributes().build());
		event.put(TechnologicaEntityTypes.STINGRAY.get(), Stingray.registerAttributes().build());
		event.put(TechnologicaEntityTypes.TURKEY.get(), Turkey.registerAttributes().build());
		event.put(TechnologicaEntityTypes.VULTURE.get(), Vulture.registerAttributes().build());
		event.put(TechnologicaEntityTypes.WALRUS.get(), Walrus.registerAttributes().build());
		event.put(TechnologicaEntityTypes.ZEBRA.get(), Zebra.createBaseHorseAttributes().build());
		event.put(TechnologicaEntityTypes.ATOMIC_CREEPER.get(), AtomicCreeper.registerAttributes().build());
		event.put(TechnologicaEntityTypes.MUMMY.get(), Mummy.registerAttributes().build());
		event.put(TechnologicaEntityTypes.PEEPER.get(), Peeper.registerAttributes().build());
		event.put(TechnologicaEntityTypes.BEEPER.get(), Beeper.registerAttributes().build());
		event.put(TechnologicaEntityTypes.SLEEPER.get(), Sleeper.registerAttributes().build());
		event.put(TechnologicaEntityTypes.WEEPER.get(), Weeper.registerAttributes().build());
		event.put(TechnologicaEntityTypes.SWEEPER.get(), Sweeper.registerAttributes().build());
		event.put(TechnologicaEntityTypes.DUST_DEVIL.get(), DustDevil.registerAttributes().build());

		long completed = TechnologicaEntityTypes.ENTITY_TYPES.getEntries().stream().filter((entity) -> {
			return entity.get().getCategory() != MobCategory.MISC;
		}).filter((entity) -> {
			return DefaultAttributes.hasSupplier(entity.get());
		}).count();
		LOGGER.info("SETUP - ENTITY ATTRIBUTES - " + completed + " OF " + required);

		if (completed != required) {
			LOGGER.error("ENTITY ATTRIBUTE CREATION FAILED: " + (required - completed) + " MISSING");
		}
	}
}