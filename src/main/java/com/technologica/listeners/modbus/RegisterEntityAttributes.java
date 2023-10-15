package com.technologica.listeners.modbus;

import static com.technologica.Technologica.LOGGER;

import com.technologica.world.entity.TechnologicaEntityType;
import com.technologica.world.entity.animal.Alligator;
import com.technologica.world.entity.animal.Beaver;
import com.technologica.world.entity.animal.Buffalo;
import com.technologica.world.entity.animal.Camel;
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
import com.technologica.world.entity.monster.Mummy;
import com.technologica.world.entity.monster.Peeper;
import com.technologica.world.entity.monster.Sweeper;

import net.minecraftforge.event.entity.EntityAttributeCreationEvent;

/**
 * <p>
 * This class listens for the EntityAttributeCreationEvent which is fired on the mod-specific event bus.
 * When the event is intercepted, Technologica Entity Attributes are registered.
 * This is currently the approved way to register Entity Attributes.
 * </p>
 */

public class RegisterEntityAttributes {

	public static void onEntityAttributeCreationEvent(final EntityAttributeCreationEvent event) {
		event.put(TechnologicaEntityType.ALLIGATOR.get(), Alligator.registerAttributes().build());
		event.put(TechnologicaEntityType.BEAVER.get(), Beaver.registerAttributes().build());
		event.put(TechnologicaEntityType.BUFFALO.get(), Buffalo.registerAttributes().build());
		event.put(TechnologicaEntityType.CAMEL.get(), Camel.registerAttributes().build());
		event.put(TechnologicaEntityType.COBRA.get(), Cobra.registerAttributes().build());
		event.put(TechnologicaEntityType.COTTONMOUTH.get(), Cottonmouth.registerAttributes().build());
		event.put(TechnologicaEntityType.COYOTE.get(), Coyote.createAttributes().build());
		event.put(TechnologicaEntityType.CRAB.get(), Crab.registerAttributes().build());
		event.put(TechnologicaEntityType.DEER.get(), Deer.registerAttributes().build());
		event.put(TechnologicaEntityType.DUCK.get(), Duck.registerAttributes().build());
		event.put(TechnologicaEntityType.ELEPHANT.get(), Elephant.registerAttributes().build());
		event.put(TechnologicaEntityType.FLAMINGO.get(), Flamingo.registerAttributes().build());
		event.put(TechnologicaEntityType.FIGURE_EIGHT_PUFFERFISH.get(), Frog.registerAttributes().build());
		event.put(TechnologicaEntityType.GIRAFFE.get(), Giraffe.createBaseHorseAttributes().build());
		event.put(TechnologicaEntityType.GORILLA.get(), Gorilla.registerAttributes().build());
		event.put(TechnologicaEntityType.GRIZZLY_BEAR.get(), GrizzlyBear.registerAttributes().build());
		event.put(TechnologicaEntityType.JAGUAR.get(), Jaguar.registerAttributes().build());
		event.put(TechnologicaEntityType.KING_CRAB.get(), KingCrab.registerAttributes().build());
		event.put(TechnologicaEntityType.LEOPARD_SEAL.get(), LeopardSeal.registerAttributes().build());
		event.put(TechnologicaEntityType.LION.get(), Lion.registerAttributes().build());
		event.put(TechnologicaEntityType.LIZARD.get(), Lizard.registerAttributes().build());
		event.put(TechnologicaEntityType.MOOSE.get(), Moose.registerAttributes().build());
		event.put(TechnologicaEntityType.NARWHAL.get(), Narwhal.registerAttributes().build());
		event.put(TechnologicaEntityType.OCTOPUS.get(), Octopus.registerAttributes().build());
		event.put(TechnologicaEntityType.OSTRICH.get(), Ostrich.createBaseHorseAttributes().build());
		event.put(TechnologicaEntityType.OWL.get(), Owl.registerAttributes().build());
		event.put(TechnologicaEntityType.PENGUIN.get(), Penguin.registerAttributes().build());
		event.put(TechnologicaEntityType.PIRANHA.get(), Piranha.registerAttributes().build());
		event.put(TechnologicaEntityType.POISON_DART_FROG.get(), PoisonDartFrog.registerAttributes().build());
		event.put(TechnologicaEntityType.RACCOON.get(), Raccoon.registerAttributes().build());
		event.put(TechnologicaEntityType.SCORPION.get(), Scorpion.createAttributes().build());
		event.put(TechnologicaEntityType.SHARK.get(), Shark.registerAttributes().build());
		event.put(TechnologicaEntityType.SLOTH.get(), Sloth.registerAttributes().build());
		event.put(TechnologicaEntityType.STINGRAY.get(), Stingray.registerAttributes().build());
		event.put(TechnologicaEntityType.TURKEY.get(), Turkey.registerAttributes().build());
		event.put(TechnologicaEntityType.VULTURE.get(), Vulture.registerAttributes().build());
		event.put(TechnologicaEntityType.WALRUS.get(), Walrus.registerAttributes().build());
		event.put(TechnologicaEntityType.ZEBRA.get(), Zebra.createBaseHorseAttributes().build());
		event.put(TechnologicaEntityType.ATOMIC_CREEPER.get(), AtomicCreeper.registerAttributes().build());
		event.put(TechnologicaEntityType.MUMMY.get(), Mummy.registerAttributes().build());
		event.put(TechnologicaEntityType.PEEPER.get(), Peeper.registerAttributes().build());
		event.put(TechnologicaEntityType.SWEEPER.get(), Sweeper.registerAttributes().build());
		/**
		 * TODO: Determine how to count how many Technologica Entity Attributes actually got registered and replace the hard-coded value in the logger message.
		 */
		LOGGER.info("ENTITY ATTRIBUTES REGISTERED: 40 OF 40");
	}
}
