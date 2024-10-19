package com.technologica.world.entity.ai.attributes;

import java.util.Map;

import com.google.common.collect.ImmutableMap;
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
	public static final Map<EntityType<? extends LivingEntity>, AttributeSupplier> SUPPLIERS = ImmutableMap.<EntityType<? extends LivingEntity>, AttributeSupplier>builder().put(TechnologicaEntityTypes.ALLIGATOR.get(), Alligator.createAttributes().build()).put(TechnologicaEntityTypes.BEAVER.get(), Beaver.createAttributes().build()).put(TechnologicaEntityTypes.BUFFALO.get(), Buffalo.createAttributes().build()).put(TechnologicaEntityTypes.COBRA.get(), Cobra.createAttributes().build()).put(TechnologicaEntityTypes.COTTONMOUTH.get(), Cottonmouth.createAttributes().build()).put(TechnologicaEntityTypes.COYOTE.get(), Coyote.createAttributes().build()).put(TechnologicaEntityTypes.CRAB.get(), Crab.createAttributes().build()).put(TechnologicaEntityTypes.DEER.get(), Deer.createAttributes().build()).put(TechnologicaEntityTypes.DUCK.get(), Duck.createAttributes().build()).put(TechnologicaEntityTypes.ELEPHANT.get(), Elephant.createAttributes().build()).put(TechnologicaEntityTypes.FLAMINGO.get(), Flamingo.createAttributes().build()).put(TechnologicaEntityTypes.FIGURE_EIGHT_PUFFERFISH.get(), AbstractFish.createAttributes().build()).put(TechnologicaEntityTypes.GIRAFFE.get(), Giraffe.createBaseHorseAttributes().build()).put(TechnologicaEntityTypes.GORILLA.get(), Gorilla.registerAttributes().build()).put(TechnologicaEntityTypes.GRIZZLY_BEAR.get(), GrizzlyBear.createAttributes().build()).put(TechnologicaEntityTypes.JAGUAR.get(), Jaguar.createAttributes().build()).put(TechnologicaEntityTypes.KING_CRAB.get(), KingCrab.registerAttributes().build()).put(TechnologicaEntityTypes.LEOPARD_SEAL.get(), LeopardSeal.createAttributes().build()).put(TechnologicaEntityTypes.LION.get(), Lion.createAttributes().build()).put(TechnologicaEntityTypes.LIZARD.get(), Lizard.registerAttributes().build()).put(TechnologicaEntityTypes.MOOSE.get(), Moose.registerAttributes().build()).put(TechnologicaEntityTypes.NARWHAL.get(), Narwhal.createAttributes().build()).put(TechnologicaEntityTypes.OCTOPUS.get(), Octopus.registerAttributes().build()).put(TechnologicaEntityTypes.OSTRICH.get(), Ostrich.createBaseHorseAttributes().build()).put(TechnologicaEntityTypes.OWL.get(), Owl.registerAttributes().build()).put(TechnologicaEntityTypes.PENGUIN.get(), Penguin.registerAttributes().build()).put(TechnologicaEntityTypes.PIRANHA.get(), Piranha.createAttributes().build()).put(TechnologicaEntityTypes.POISON_DART_FROG.get(), PoisonDartFrog.createAttributes().build()).put(TechnologicaEntityTypes.RACCOON.get(), Raccoon.registerAttributes().build()).put(TechnologicaEntityTypes.SCORPION.get(), Scorpion.createAttributes().build()).put(TechnologicaEntityTypes.SHARK.get(), Shark.registerAttributes().build()).put(TechnologicaEntityTypes.SLOTH.get(), Sloth.registerAttributes().build()).put(TechnologicaEntityTypes.STINGRAY.get(), Stingray.registerAttributes().build()).put(TechnologicaEntityTypes.TURKEY.get(), Turkey.createAttributes().build()).put(TechnologicaEntityTypes.VULTURE.get(), Vulture.registerAttributes().build()).put(TechnologicaEntityTypes.WALRUS.get(), Walrus.registerAttributes().build()).put(TechnologicaEntityTypes.ZEBRA.get(), Zebra.createBaseHorseAttributes().build()).put(TechnologicaEntityTypes.ATOMIC_CREEPER.get(), AtomicCreeper.registerAttributes().build()).put(TechnologicaEntityTypes.MUMMY.get(), Mummy.registerAttributes().build()).put(TechnologicaEntityTypes.PEEPER.get(), Peeper.registerAttributes().build()).put(TechnologicaEntityTypes.BEEPER.get(), Beeper.registerAttributes().build()).put(TechnologicaEntityTypes.SLEEPER.get(), Sleeper.registerAttributes().build()).put(TechnologicaEntityTypes.WEEPER.get(), Weeper.registerAttributes().build()).put(TechnologicaEntityTypes.SWEEPER.get(), Sweeper.registerAttributes().build()).put(TechnologicaEntityTypes.DUST_DEVIL.get(), DustDevil.registerAttributes().build()).build();
}
