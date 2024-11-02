package com.technologica.world.entity.ai.attributes;

import java.util.Map;

import com.google.common.collect.Maps;
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

import net.minecraft.world.entity.EntityType;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.entity.ai.attributes.AttributeSupplier;
import net.minecraft.world.entity.animal.AbstractFish;

public class TechnologicaDefaultAttributes {
	public static final Map<EntityType<? extends LivingEntity>, AttributeSupplier> SUPPLIERS = Maps.newHashMap();

	static {
		register(TechnologicaEntityTypes.ALLIGATOR.get(), Alligator.createAttributes().build());
		register(TechnologicaEntityTypes.BEAVER.get(), Beaver.createAttributes().build());
		register(TechnologicaEntityTypes.BUFFALO.get(), Buffalo.createAttributes().build());
		register(TechnologicaEntityTypes.COBRA.get(), Cobra.createAttributes().build());
		register(TechnologicaEntityTypes.COTTONMOUTH.get(), Cottonmouth.createAttributes().build());
		register(TechnologicaEntityTypes.COYOTE.get(), Coyote.createAttributes().build());
		register(TechnologicaEntityTypes.CRAB.get(), Crab.createAttributes().build());
		register(TechnologicaEntityTypes.DEER.get(), Deer.createAttributes().build());
		register(TechnologicaEntityTypes.DUCK.get(), Duck.createAttributes().build());
		register(TechnologicaEntityTypes.ELEPHANT.get(), Elephant.createAttributes().build());
		register(TechnologicaEntityTypes.FLAMINGO.get(), Flamingo.createAttributes().build());
		register(TechnologicaEntityTypes.FIGURE_EIGHT_PUFFERFISH.get(), AbstractFish.createAttributes().build());
		register(TechnologicaEntityTypes.GIRAFFE.get(), Giraffe.createBaseHorseAttributes().build());
		register(TechnologicaEntityTypes.GORILLA.get(), Gorilla.createAttributes().build());
		register(TechnologicaEntityTypes.GRIZZLY_BEAR.get(), GrizzlyBear.createAttributes().build());
		register(TechnologicaEntityTypes.JAGUAR.get(), Jaguar.createAttributes().build());
		register(TechnologicaEntityTypes.KING_CRAB.get(), KingCrab.createAttributes().build());
		register(TechnologicaEntityTypes.LEOPARD_SEAL.get(), LeopardSeal.createAttributes().build());
		register(TechnologicaEntityTypes.LION.get(), Lion.createAttributes().build());
		register(TechnologicaEntityTypes.LIZARD.get(), Lizard.createAttributes().build());
		register(TechnologicaEntityTypes.MOOSE.get(), Moose.createAttributes().build());
		register(TechnologicaEntityTypes.NARWHAL.get(), Narwhal.createAttributes().build());
		register(TechnologicaEntityTypes.OCTOPUS.get(), Octopus.createAttributes().build());
		register(TechnologicaEntityTypes.OSTRICH.get(), Ostrich.createBaseHorseAttributes().build());
		register(TechnologicaEntityTypes.OWL.get(), Owl.createAttributes().build());
		register(TechnologicaEntityTypes.PENGUIN.get(), Penguin.createAttributes().build());
		register(TechnologicaEntityTypes.PIRANHA.get(), Piranha.createAttributes().build());
		register(TechnologicaEntityTypes.POISON_DART_FROG.get(), PoisonDartFrog.createAttributes().build());
		register(TechnologicaEntityTypes.RACCOON.get(), Raccoon.createAttributes().build());
		register(TechnologicaEntityTypes.SCORPION.get(), Scorpion.createAttributes().build());
		register(TechnologicaEntityTypes.SHARK.get(), Shark.createAttributes().build());
		register(TechnologicaEntityTypes.SLOTH.get(), Sloth.createAttributes().build());
		register(TechnologicaEntityTypes.STINGRAY.get(), Stingray.createAttributes().build());
		register(TechnologicaEntityTypes.TURKEY.get(), Turkey.createAttributes().build());
		register(TechnologicaEntityTypes.VULTURE.get(), Vulture.createAttributes().build());
		register(TechnologicaEntityTypes.WALRUS.get(), Walrus.createAttributes().build());
		register(TechnologicaEntityTypes.ZEBRA.get(), Zebra.createBaseHorseAttributes().build());
		register(TechnologicaEntityTypes.ATOMIC_CREEPER.get(), AtomicCreeper.createAttributes().build());
		register(TechnologicaEntityTypes.BEEPER.get(), Beeper.registerAttributes().build());
		register(TechnologicaEntityTypes.DUST_DEVIL.get(), DustDevil.registerAttributes().build());
		register(TechnologicaEntityTypes.MUMMY.get(), Mummy.createAttributes().build());
		register(TechnologicaEntityTypes.PEEPER.get(), Peeper.registerAttributes().build());
		register(TechnologicaEntityTypes.SLEEPER.get(), Sleeper.registerAttributes().build());
		register(TechnologicaEntityTypes.SWEEPER.get(), Sweeper.registerAttributes().build());
		register(TechnologicaEntityTypes.WEEPER.get(), Weeper.registerAttributes().build());
	}

	private static void register(EntityType<? extends LivingEntity> entity, AttributeSupplier renderer) {
		SUPPLIERS.put(entity, renderer);
	}
}
